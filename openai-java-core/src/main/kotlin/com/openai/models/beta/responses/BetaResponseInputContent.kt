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

/** A text input to the model. */
@JsonDeserialize(using = BetaResponseInputContent.Deserializer::class)
@JsonSerialize(using = BetaResponseInputContent.Serializer::class)
class BetaResponseInputContent
private constructor(
    private val inputText: BetaResponseInputText? = null,
    private val inputImage: BetaResponseInputImage? = null,
    private val inputFile: BetaResponseInputFile? = null,
    private val _json: JsonValue? = null,
) {

    /** A text input to the model. */
    fun inputText(): Optional<BetaResponseInputText> = Optional.ofNullable(inputText)

    /**
     * An image input to the model. Learn about
     * [image inputs](https://platform.openai.com/docs/guides/vision).
     */
    fun inputImage(): Optional<BetaResponseInputImage> = Optional.ofNullable(inputImage)

    /** A file input to the model. */
    fun inputFile(): Optional<BetaResponseInputFile> = Optional.ofNullable(inputFile)

    fun isInputText(): Boolean = inputText != null

    fun isInputImage(): Boolean = inputImage != null

    fun isInputFile(): Boolean = inputFile != null

    /** A text input to the model. */
    fun asInputText(): BetaResponseInputText = inputText.getOrThrow("inputText")

    /**
     * An image input to the model. Learn about
     * [image inputs](https://platform.openai.com/docs/guides/vision).
     */
    fun asInputImage(): BetaResponseInputImage = inputImage.getOrThrow("inputImage")

    /** A file input to the model. */
    fun asInputFile(): BetaResponseInputFile = inputFile.getOrThrow("inputFile")

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
     * Optional<String> result = betaResponseInputContent.accept(new BetaResponseInputContent.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitInputText(BetaResponseInputText inputText) {
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
    fun validate(): BetaResponseInputContent = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitInputText(inputText: BetaResponseInputText) {
                    inputText.validate()
                }

                override fun visitInputImage(inputImage: BetaResponseInputImage) {
                    inputImage.validate()
                }

                override fun visitInputFile(inputFile: BetaResponseInputFile) {
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
                override fun visitInputText(inputText: BetaResponseInputText) = inputText.validity()

                override fun visitInputImage(inputImage: BetaResponseInputImage) =
                    inputImage.validity()

                override fun visitInputFile(inputFile: BetaResponseInputFile) = inputFile.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BetaResponseInputContent &&
            inputText == other.inputText &&
            inputImage == other.inputImage &&
            inputFile == other.inputFile
    }

    override fun hashCode(): Int = Objects.hash(inputText, inputImage, inputFile)

    override fun toString(): String =
        when {
            inputText != null -> "BetaResponseInputContent{inputText=$inputText}"
            inputImage != null -> "BetaResponseInputContent{inputImage=$inputImage}"
            inputFile != null -> "BetaResponseInputContent{inputFile=$inputFile}"
            _json != null -> "BetaResponseInputContent{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid BetaResponseInputContent")
        }

    companion object {

        /** A text input to the model. */
        @JvmStatic
        fun ofInputText(inputText: BetaResponseInputText) =
            BetaResponseInputContent(inputText = inputText)

        /**
         * An image input to the model. Learn about
         * [image inputs](https://platform.openai.com/docs/guides/vision).
         */
        @JvmStatic
        fun ofInputImage(inputImage: BetaResponseInputImage) =
            BetaResponseInputContent(inputImage = inputImage)

        /** A file input to the model. */
        @JvmStatic
        fun ofInputFile(inputFile: BetaResponseInputFile) =
            BetaResponseInputContent(inputFile = inputFile)
    }

    /**
     * An interface that defines how to map each variant of [BetaResponseInputContent] to a value of
     * type [T].
     */
    interface Visitor<out T> {

        /** A text input to the model. */
        fun visitInputText(inputText: BetaResponseInputText): T

        /**
         * An image input to the model. Learn about
         * [image inputs](https://platform.openai.com/docs/guides/vision).
         */
        fun visitInputImage(inputImage: BetaResponseInputImage): T

        /** A file input to the model. */
        fun visitInputFile(inputFile: BetaResponseInputFile): T

        /**
         * Maps an unknown variant of [BetaResponseInputContent] to a value of type [T].
         *
         * An instance of [BetaResponseInputContent] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown BetaResponseInputContent: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<BetaResponseInputContent>(BetaResponseInputContent::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): BetaResponseInputContent {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "input_text" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseInputText>())?.let {
                        BetaResponseInputContent(inputText = it, _json = json)
                    } ?: BetaResponseInputContent(_json = json)
                }
                "input_image" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseInputImage>())?.let {
                        BetaResponseInputContent(inputImage = it, _json = json)
                    } ?: BetaResponseInputContent(_json = json)
                }
                "input_file" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseInputFile>())?.let {
                        BetaResponseInputContent(inputFile = it, _json = json)
                    } ?: BetaResponseInputContent(_json = json)
                }
            }

            return BetaResponseInputContent(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<BetaResponseInputContent>(BetaResponseInputContent::class) {

        override fun serialize(
            value: BetaResponseInputContent,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.inputText != null -> generator.writeObject(value.inputText)
                value.inputImage != null -> generator.writeObject(value.inputImage)
                value.inputFile != null -> generator.writeObject(value.inputFile)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid BetaResponseInputContent")
            }
        }
    }
}
