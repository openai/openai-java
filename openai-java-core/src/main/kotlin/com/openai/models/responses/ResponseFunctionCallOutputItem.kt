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
@JsonDeserialize(using = ResponseFunctionCallOutputItem.Deserializer::class)
@JsonSerialize(using = ResponseFunctionCallOutputItem.Serializer::class)
class ResponseFunctionCallOutputItem
private constructor(
    private val inputText: ResponseInputTextContent? = null,
    private val inputImage: ResponseInputImageContent? = null,
    private val inputFile: ResponseInputFileContent? = null,
    private val _json: JsonValue? = null,
) {

    /** A text input to the model. */
    fun inputText(): Optional<ResponseInputTextContent> = Optional.ofNullable(inputText)

    /**
     * An image input to the model. Learn about
     * [image inputs](https://platform.openai.com/docs/guides/vision)
     */
    fun inputImage(): Optional<ResponseInputImageContent> = Optional.ofNullable(inputImage)

    /** A file input to the model. */
    fun inputFile(): Optional<ResponseInputFileContent> = Optional.ofNullable(inputFile)

    fun isInputText(): Boolean = inputText != null

    fun isInputImage(): Boolean = inputImage != null

    fun isInputFile(): Boolean = inputFile != null

    /** A text input to the model. */
    fun asInputText(): ResponseInputTextContent = inputText.getOrThrow("inputText")

    /**
     * An image input to the model. Learn about
     * [image inputs](https://platform.openai.com/docs/guides/vision)
     */
    fun asInputImage(): ResponseInputImageContent = inputImage.getOrThrow("inputImage")

    /** A file input to the model. */
    fun asInputFile(): ResponseInputFileContent = inputFile.getOrThrow("inputFile")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            inputText != null -> visitor.visitInputText(inputText)
            inputImage != null -> visitor.visitInputImage(inputImage)
            inputFile != null -> visitor.visitInputFile(inputFile)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): ResponseFunctionCallOutputItem = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitInputText(inputText: ResponseInputTextContent) {
                    inputText.validate()
                }

                override fun visitInputImage(inputImage: ResponseInputImageContent) {
                    inputImage.validate()
                }

                override fun visitInputFile(inputFile: ResponseInputFileContent) {
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
                override fun visitInputText(inputText: ResponseInputTextContent) =
                    inputText.validity()

                override fun visitInputImage(inputImage: ResponseInputImageContent) =
                    inputImage.validity()

                override fun visitInputFile(inputFile: ResponseInputFileContent) =
                    inputFile.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ResponseFunctionCallOutputItem &&
            inputText == other.inputText &&
            inputImage == other.inputImage &&
            inputFile == other.inputFile
    }

    override fun hashCode(): Int = Objects.hash(inputText, inputImage, inputFile)

    override fun toString(): String =
        when {
            inputText != null -> "ResponseFunctionCallOutputItem{inputText=$inputText}"
            inputImage != null -> "ResponseFunctionCallOutputItem{inputImage=$inputImage}"
            inputFile != null -> "ResponseFunctionCallOutputItem{inputFile=$inputFile}"
            _json != null -> "ResponseFunctionCallOutputItem{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ResponseFunctionCallOutputItem")
        }

    companion object {

        /** A text input to the model. */
        @JvmStatic
        fun ofInputText(inputText: ResponseInputTextContent) =
            ResponseFunctionCallOutputItem(inputText = inputText)

        /**
         * An image input to the model. Learn about
         * [image inputs](https://platform.openai.com/docs/guides/vision)
         */
        @JvmStatic
        fun ofInputImage(inputImage: ResponseInputImageContent) =
            ResponseFunctionCallOutputItem(inputImage = inputImage)

        /** A file input to the model. */
        @JvmStatic
        fun ofInputFile(inputFile: ResponseInputFileContent) =
            ResponseFunctionCallOutputItem(inputFile = inputFile)
    }

    /**
     * An interface that defines how to map each variant of [ResponseFunctionCallOutputItem] to a
     * value of type [T].
     */
    interface Visitor<out T> {

        /** A text input to the model. */
        fun visitInputText(inputText: ResponseInputTextContent): T

        /**
         * An image input to the model. Learn about
         * [image inputs](https://platform.openai.com/docs/guides/vision)
         */
        fun visitInputImage(inputImage: ResponseInputImageContent): T

        /** A file input to the model. */
        fun visitInputFile(inputFile: ResponseInputFileContent): T

        /**
         * Maps an unknown variant of [ResponseFunctionCallOutputItem] to a value of type [T].
         *
         * An instance of [ResponseFunctionCallOutputItem] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ResponseFunctionCallOutputItem: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<ResponseFunctionCallOutputItem>(ResponseFunctionCallOutputItem::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ResponseFunctionCallOutputItem {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "input_text" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseInputTextContent>())?.let {
                        ResponseFunctionCallOutputItem(inputText = it, _json = json)
                    } ?: ResponseFunctionCallOutputItem(_json = json)
                }
                "input_image" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseInputImageContent>())?.let {
                        ResponseFunctionCallOutputItem(inputImage = it, _json = json)
                    } ?: ResponseFunctionCallOutputItem(_json = json)
                }
                "input_file" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseInputFileContent>())?.let {
                        ResponseFunctionCallOutputItem(inputFile = it, _json = json)
                    } ?: ResponseFunctionCallOutputItem(_json = json)
                }
            }

            return ResponseFunctionCallOutputItem(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<ResponseFunctionCallOutputItem>(ResponseFunctionCallOutputItem::class) {

        override fun serialize(
            value: ResponseFunctionCallOutputItem,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.inputText != null -> generator.writeObject(value.inputText)
                value.inputImage != null -> generator.writeObject(value.inputImage)
                value.inputFile != null -> generator.writeObject(value.inputFile)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ResponseFunctionCallOutputItem")
            }
        }
    }
}
