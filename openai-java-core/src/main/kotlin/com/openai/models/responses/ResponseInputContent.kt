// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

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
@JsonDeserialize(using = ResponseInputContent.Deserializer::class)
@JsonSerialize(using = ResponseInputContent.Serializer::class)
class ResponseInputContent
private constructor(
    private val inputText: ResponseInputText? = null,
    private val inputImage: ResponseInputImage? = null,
    private val inputFile: ResponseInputFile? = null,
    private val inputAudio: ResponseInputAudio? = null,
    private val _json: JsonValue? = null,
) {

    /** A text input to the model. */
    fun inputText(): Optional<ResponseInputText> = Optional.ofNullable(inputText)

    /**
     * An image input to the model. Learn about
     * [image inputs](https://platform.openai.com/docs/guides/vision).
     */
    fun inputImage(): Optional<ResponseInputImage> = Optional.ofNullable(inputImage)

    /** A file input to the model. */
    fun inputFile(): Optional<ResponseInputFile> = Optional.ofNullable(inputFile)

    /** An audio input to the model. */
    fun inputAudio(): Optional<ResponseInputAudio> = Optional.ofNullable(inputAudio)

    fun isInputText(): Boolean = inputText != null

    fun isInputImage(): Boolean = inputImage != null

    fun isInputFile(): Boolean = inputFile != null

    fun isInputAudio(): Boolean = inputAudio != null

    /** A text input to the model. */
    fun asInputText(): ResponseInputText = inputText.getOrThrow("inputText")

    /**
     * An image input to the model. Learn about
     * [image inputs](https://platform.openai.com/docs/guides/vision).
     */
    fun asInputImage(): ResponseInputImage = inputImage.getOrThrow("inputImage")

    /** A file input to the model. */
    fun asInputFile(): ResponseInputFile = inputFile.getOrThrow("inputFile")

    /** An audio input to the model. */
    fun asInputAudio(): ResponseInputAudio = inputAudio.getOrThrow("inputAudio")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            inputText != null -> visitor.visitInputText(inputText)
            inputImage != null -> visitor.visitInputImage(inputImage)
            inputFile != null -> visitor.visitInputFile(inputFile)
            inputAudio != null -> visitor.visitInputAudio(inputAudio)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): ResponseInputContent = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitInputText(inputText: ResponseInputText) {
                    inputText.validate()
                }

                override fun visitInputImage(inputImage: ResponseInputImage) {
                    inputImage.validate()
                }

                override fun visitInputFile(inputFile: ResponseInputFile) {
                    inputFile.validate()
                }

                override fun visitInputAudio(inputAudio: ResponseInputAudio) {
                    inputAudio.validate()
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
                override fun visitInputText(inputText: ResponseInputText) = inputText.validity()

                override fun visitInputImage(inputImage: ResponseInputImage) = inputImage.validity()

                override fun visitInputFile(inputFile: ResponseInputFile) = inputFile.validity()

                override fun visitInputAudio(inputAudio: ResponseInputAudio) = inputAudio.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ResponseInputContent &&
            inputText == other.inputText &&
            inputImage == other.inputImage &&
            inputFile == other.inputFile &&
            inputAudio == other.inputAudio
    }

    override fun hashCode(): Int = Objects.hash(inputText, inputImage, inputFile, inputAudio)

    override fun toString(): String =
        when {
            inputText != null -> "ResponseInputContent{inputText=$inputText}"
            inputImage != null -> "ResponseInputContent{inputImage=$inputImage}"
            inputFile != null -> "ResponseInputContent{inputFile=$inputFile}"
            inputAudio != null -> "ResponseInputContent{inputAudio=$inputAudio}"
            _json != null -> "ResponseInputContent{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ResponseInputContent")
        }

    companion object {

        /** A text input to the model. */
        @JvmStatic
        fun ofInputText(inputText: ResponseInputText) = ResponseInputContent(inputText = inputText)

        /**
         * An image input to the model. Learn about
         * [image inputs](https://platform.openai.com/docs/guides/vision).
         */
        @JvmStatic
        fun ofInputImage(inputImage: ResponseInputImage) =
            ResponseInputContent(inputImage = inputImage)

        /** A file input to the model. */
        @JvmStatic
        fun ofInputFile(inputFile: ResponseInputFile) = ResponseInputContent(inputFile = inputFile)

        /** An audio input to the model. */
        @JvmStatic
        fun ofInputAudio(inputAudio: ResponseInputAudio) =
            ResponseInputContent(inputAudio = inputAudio)
    }

    /**
     * An interface that defines how to map each variant of [ResponseInputContent] to a value of
     * type [T].
     */
    interface Visitor<out T> {

        /** A text input to the model. */
        fun visitInputText(inputText: ResponseInputText): T

        /**
         * An image input to the model. Learn about
         * [image inputs](https://platform.openai.com/docs/guides/vision).
         */
        fun visitInputImage(inputImage: ResponseInputImage): T

        /** A file input to the model. */
        fun visitInputFile(inputFile: ResponseInputFile): T

        /** An audio input to the model. */
        fun visitInputAudio(inputAudio: ResponseInputAudio): T

        /**
         * Maps an unknown variant of [ResponseInputContent] to a value of type [T].
         *
         * An instance of [ResponseInputContent] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ResponseInputContent: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<ResponseInputContent>(ResponseInputContent::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ResponseInputContent {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "input_text" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseInputText>())?.let {
                        ResponseInputContent(inputText = it, _json = json)
                    } ?: ResponseInputContent(_json = json)
                }
                "input_image" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseInputImage>())?.let {
                        ResponseInputContent(inputImage = it, _json = json)
                    } ?: ResponseInputContent(_json = json)
                }
                "input_file" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseInputFile>())?.let {
                        ResponseInputContent(inputFile = it, _json = json)
                    } ?: ResponseInputContent(_json = json)
                }
                "input_audio" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseInputAudio>())?.let {
                        ResponseInputContent(inputAudio = it, _json = json)
                    } ?: ResponseInputContent(_json = json)
                }
            }

            return ResponseInputContent(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<ResponseInputContent>(ResponseInputContent::class) {

        override fun serialize(
            value: ResponseInputContent,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.inputText != null -> generator.writeObject(value.inputText)
                value.inputImage != null -> generator.writeObject(value.inputImage)
                value.inputFile != null -> generator.writeObject(value.inputFile)
                value.inputAudio != null -> generator.writeObject(value.inputAudio)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ResponseInputContent")
            }
        }
    }
}
