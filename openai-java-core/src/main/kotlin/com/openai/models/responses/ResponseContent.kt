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

/** Multi-modal input and output contents. */
@JsonDeserialize(using = ResponseContent.Deserializer::class)
@JsonSerialize(using = ResponseContent.Serializer::class)
class ResponseContent
private constructor(
    private val inputText: ResponseInputText? = null,
    private val inputImage: ResponseInputImage? = null,
    private val inputFile: ResponseInputFile? = null,
    private val outputText: ResponseOutputText? = null,
    private val outputRefusal: ResponseOutputRefusal? = null,
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

    /** A text output from the model. */
    fun outputText(): Optional<ResponseOutputText> = Optional.ofNullable(outputText)

    /** A refusal from the model. */
    fun outputRefusal(): Optional<ResponseOutputRefusal> = Optional.ofNullable(outputRefusal)

    fun isInputText(): Boolean = inputText != null

    fun isInputImage(): Boolean = inputImage != null

    fun isInputFile(): Boolean = inputFile != null

    fun isOutputText(): Boolean = outputText != null

    fun isOutputRefusal(): Boolean = outputRefusal != null

    /** A text input to the model. */
    fun asInputText(): ResponseInputText = inputText.getOrThrow("inputText")

    /**
     * An image input to the model. Learn about
     * [image inputs](https://platform.openai.com/docs/guides/vision).
     */
    fun asInputImage(): ResponseInputImage = inputImage.getOrThrow("inputImage")

    /** A file input to the model. */
    fun asInputFile(): ResponseInputFile = inputFile.getOrThrow("inputFile")

    /** A text output from the model. */
    fun asOutputText(): ResponseOutputText = outputText.getOrThrow("outputText")

    /** A refusal from the model. */
    fun asOutputRefusal(): ResponseOutputRefusal = outputRefusal.getOrThrow("outputRefusal")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            inputText != null -> visitor.visitInputText(inputText)
            inputImage != null -> visitor.visitInputImage(inputImage)
            inputFile != null -> visitor.visitInputFile(inputFile)
            outputText != null -> visitor.visitOutputText(outputText)
            outputRefusal != null -> visitor.visitOutputRefusal(outputRefusal)
            else -> visitor.unknown(_json)
        }
    }

    private var validated: Boolean = false

    fun validate(): ResponseContent = apply {
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

                override fun visitOutputText(outputText: ResponseOutputText) {
                    outputText.validate()
                }

                override fun visitOutputRefusal(outputRefusal: ResponseOutputRefusal) {
                    outputRefusal.validate()
                }
            }
        )
        validated = true
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ResponseContent && inputText == other.inputText && inputImage == other.inputImage && inputFile == other.inputFile && outputText == other.outputText && outputRefusal == other.outputRefusal /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(inputText, inputImage, inputFile, outputText, outputRefusal) /* spotless:on */

    override fun toString(): String =
        when {
            inputText != null -> "ResponseContent{inputText=$inputText}"
            inputImage != null -> "ResponseContent{inputImage=$inputImage}"
            inputFile != null -> "ResponseContent{inputFile=$inputFile}"
            outputText != null -> "ResponseContent{outputText=$outputText}"
            outputRefusal != null -> "ResponseContent{outputRefusal=$outputRefusal}"
            _json != null -> "ResponseContent{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ResponseContent")
        }

    companion object {

        /** A text input to the model. */
        @JvmStatic
        fun ofInputText(inputText: ResponseInputText) = ResponseContent(inputText = inputText)

        /**
         * An image input to the model. Learn about
         * [image inputs](https://platform.openai.com/docs/guides/vision).
         */
        @JvmStatic
        fun ofInputImage(inputImage: ResponseInputImage) = ResponseContent(inputImage = inputImage)

        /** A file input to the model. */
        @JvmStatic
        fun ofInputFile(inputFile: ResponseInputFile) = ResponseContent(inputFile = inputFile)

        /** A text output from the model. */
        @JvmStatic
        fun ofOutputText(outputText: ResponseOutputText) = ResponseContent(outputText = outputText)

        /** A refusal from the model. */
        @JvmStatic
        fun ofOutputRefusal(outputRefusal: ResponseOutputRefusal) =
            ResponseContent(outputRefusal = outputRefusal)
    }

    /**
     * An interface that defines how to map each variant of [ResponseContent] to a value of type
     * [T].
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

        /** A text output from the model. */
        fun visitOutputText(outputText: ResponseOutputText): T

        /** A refusal from the model. */
        fun visitOutputRefusal(outputRefusal: ResponseOutputRefusal): T

        /**
         * Maps an unknown variant of [ResponseContent] to a value of type [T].
         *
         * An instance of [ResponseContent] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ResponseContent: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<ResponseContent>(ResponseContent::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ResponseContent {
            val json = JsonValue.fromJsonNode(node)

            tryDeserialize(node, jacksonTypeRef<ResponseInputText>()) { it.validate() }
                ?.let {
                    return ResponseContent(inputText = it, _json = json)
                }
            tryDeserialize(node, jacksonTypeRef<ResponseInputImage>()) { it.validate() }
                ?.let {
                    return ResponseContent(inputImage = it, _json = json)
                }
            tryDeserialize(node, jacksonTypeRef<ResponseInputFile>()) { it.validate() }
                ?.let {
                    return ResponseContent(inputFile = it, _json = json)
                }
            tryDeserialize(node, jacksonTypeRef<ResponseOutputText>()) { it.validate() }
                ?.let {
                    return ResponseContent(outputText = it, _json = json)
                }
            tryDeserialize(node, jacksonTypeRef<ResponseOutputRefusal>()) { it.validate() }
                ?.let {
                    return ResponseContent(outputRefusal = it, _json = json)
                }

            return ResponseContent(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<ResponseContent>(ResponseContent::class) {

        override fun serialize(
            value: ResponseContent,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.inputText != null -> generator.writeObject(value.inputText)
                value.inputImage != null -> generator.writeObject(value.inputImage)
                value.inputFile != null -> generator.writeObject(value.inputFile)
                value.outputText != null -> generator.writeObject(value.outputText)
                value.outputRefusal != null -> generator.writeObject(value.outputRefusal)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ResponseContent")
            }
        }
    }
}
