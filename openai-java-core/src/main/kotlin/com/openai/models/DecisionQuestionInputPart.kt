// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

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

/** A text, image, or JSON content part in a question instruction. */
@JsonDeserialize(using = DecisionQuestionInputPart.Deserializer::class)
@JsonSerialize(using = DecisionQuestionInputPart.Serializer::class)
class DecisionQuestionInputPart
private constructor(
    private val inputText: DecisionQuestionInputText? = null,
    private val inputImage: DecisionQuestionInputImage? = null,
    private val inputJson: DecisionInputJson? = null,
    private val _json: JsonValue? = null,
) {

    fun inputText(): Optional<DecisionQuestionInputText> = Optional.ofNullable(inputText)

    /**
     * An image provided as a base64 data URL or a publicly accessible HTTP(S) URL. File IDs are not
     * supported.
     */
    fun inputImage(): Optional<DecisionQuestionInputImage> = Optional.ofNullable(inputImage)

    /**
     * A JSON object or an array of objects rendered as text. Nested values may be any JSON value.
     * Limited to 32 container levels, 10,000 values, and 256 KiB of compact UTF-8 JSON.
     */
    fun inputJson(): Optional<DecisionInputJson> = Optional.ofNullable(inputJson)

    fun isInputText(): Boolean = inputText != null

    fun isInputImage(): Boolean = inputImage != null

    fun isInputJson(): Boolean = inputJson != null

    fun asInputText(): DecisionQuestionInputText = inputText.getOrThrow("inputText")

    /**
     * An image provided as a base64 data URL or a publicly accessible HTTP(S) URL. File IDs are not
     * supported.
     */
    fun asInputImage(): DecisionQuestionInputImage = inputImage.getOrThrow("inputImage")

    /**
     * A JSON object or an array of objects rendered as text. Nested values may be any JSON value.
     * Limited to 32 container levels, 10,000 values, and 256 KiB of compact UTF-8 JSON.
     */
    fun asInputJson(): DecisionInputJson = inputJson.getOrThrow("inputJson")

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
     * Optional<String> result = decisionQuestionInputPart.accept(new DecisionQuestionInputPart.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitInputText(DecisionQuestionInputText inputText) {
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
            inputJson != null -> visitor.visitInputJson(inputJson)
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
    fun validate(): DecisionQuestionInputPart = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitInputText(inputText: DecisionQuestionInputText) {
                    inputText.validate()
                }

                override fun visitInputImage(inputImage: DecisionQuestionInputImage) {
                    inputImage.validate()
                }

                override fun visitInputJson(inputJson: DecisionInputJson) {
                    inputJson.validate()
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
                override fun visitInputText(inputText: DecisionQuestionInputText) =
                    inputText.validity()

                override fun visitInputImage(inputImage: DecisionQuestionInputImage) =
                    inputImage.validity()

                override fun visitInputJson(inputJson: DecisionInputJson) = inputJson.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is DecisionQuestionInputPart &&
            inputText == other.inputText &&
            inputImage == other.inputImage &&
            inputJson == other.inputJson &&
            (inputText != null || inputImage != null || inputJson != null || _json == other._json)
    }

    override fun hashCode(): Int =
        if (inputText == null && inputImage == null && inputJson == null) Objects.hash(_json)
        else Objects.hash(inputText, inputImage, inputJson)

    override fun toString(): String =
        when {
            inputText != null -> "DecisionQuestionInputPart{inputText=$inputText}"
            inputImage != null -> "DecisionQuestionInputPart{inputImage=$inputImage}"
            inputJson != null -> "DecisionQuestionInputPart{inputJson=$inputJson}"
            _json != null -> "DecisionQuestionInputPart{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid DecisionQuestionInputPart")
        }

    companion object {

        @JvmStatic
        fun ofInputText(inputText: DecisionQuestionInputText) =
            DecisionQuestionInputPart(inputText = inputText)

        /**
         * An image provided as a base64 data URL or a publicly accessible HTTP(S) URL. File IDs are
         * not supported.
         */
        @JvmStatic
        fun ofInputImage(inputImage: DecisionQuestionInputImage) =
            DecisionQuestionInputPart(inputImage = inputImage)

        /**
         * A JSON object or an array of objects rendered as text. Nested values may be any JSON
         * value. Limited to 32 container levels, 10,000 values, and 256 KiB of compact UTF-8 JSON.
         */
        @JvmStatic
        fun ofInputJson(inputJson: DecisionInputJson) =
            DecisionQuestionInputPart(inputJson = inputJson)
    }

    /**
     * An interface that defines how to map each variant of [DecisionQuestionInputPart] to a value
     * of type [T].
     */
    interface Visitor<out T> {

        fun visitInputText(inputText: DecisionQuestionInputText): T

        /**
         * An image provided as a base64 data URL or a publicly accessible HTTP(S) URL. File IDs are
         * not supported.
         */
        fun visitInputImage(inputImage: DecisionQuestionInputImage): T

        /**
         * A JSON object or an array of objects rendered as text. Nested values may be any JSON
         * value. Limited to 32 container levels, 10,000 values, and 256 KiB of compact UTF-8 JSON.
         */
        fun visitInputJson(inputJson: DecisionInputJson): T

        /**
         * Maps an unknown variant of [DecisionQuestionInputPart] to a value of type [T].
         *
         * An instance of [DecisionQuestionInputPart] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown DecisionQuestionInputPart")
        }
    }

    internal class Deserializer :
        BaseDeserializer<DecisionQuestionInputPart>(DecisionQuestionInputPart::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): DecisionQuestionInputPart {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "input_text" -> {
                    return tryDeserialize(node, jacksonTypeRef<DecisionQuestionInputText>())?.let {
                        DecisionQuestionInputPart(inputText = it, _json = json)
                    } ?: DecisionQuestionInputPart(_json = json)
                }
                "input_image" -> {
                    return tryDeserialize(node, jacksonTypeRef<DecisionQuestionInputImage>())?.let {
                        DecisionQuestionInputPart(inputImage = it, _json = json)
                    } ?: DecisionQuestionInputPart(_json = json)
                }
                "input_json" -> {
                    return tryDeserialize(node, jacksonTypeRef<DecisionInputJson>())?.let {
                        DecisionQuestionInputPart(inputJson = it, _json = json)
                    } ?: DecisionQuestionInputPart(_json = json)
                }
            }

            return DecisionQuestionInputPart(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<DecisionQuestionInputPart>(DecisionQuestionInputPart::class) {

        override fun serialize(
            value: DecisionQuestionInputPart,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.inputText != null -> generator.writeObject(value.inputText)
                value.inputImage != null -> generator.writeObject(value.inputImage)
                value.inputJson != null -> generator.writeObject(value.inputJson)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid DecisionQuestionInputPart")
            }
        }
    }
}
