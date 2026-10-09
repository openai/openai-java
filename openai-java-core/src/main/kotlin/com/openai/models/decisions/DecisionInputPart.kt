// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.decisions

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

/**
 * An image provided as a base64 data URL or a publicly accessible HTTP(S) URL. File IDs are not
 * supported.
 */
@JsonDeserialize(using = DecisionInputPart.Deserializer::class)
@JsonSerialize(using = DecisionInputPart.Serializer::class)
class DecisionInputPart
private constructor(
    private val inputText: DecisionInputText? = null,
    private val inputImage: DecisionInputImage? = null,
    private val _json: JsonValue? = null,
) {

    fun inputText(): Optional<DecisionInputText> = Optional.ofNullable(inputText)

    /**
     * An image provided as a base64 data URL or a publicly accessible HTTP(S) URL. File IDs are not
     * supported.
     */
    fun inputImage(): Optional<DecisionInputImage> = Optional.ofNullable(inputImage)

    fun isInputText(): Boolean = inputText != null

    fun isInputImage(): Boolean = inputImage != null

    fun asInputText(): DecisionInputText = inputText.getOrThrow("inputText")

    /**
     * An image provided as a base64 data URL or a publicly accessible HTTP(S) URL. File IDs are not
     * supported.
     */
    fun asInputImage(): DecisionInputImage = inputImage.getOrThrow("inputImage")

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
     * Optional<String> result = decisionInputPart.accept(new DecisionInputPart.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitInputText(DecisionInputText inputText) {
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
    fun validate(): DecisionInputPart = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitInputText(inputText: DecisionInputText) {
                    inputText.validate()
                }

                override fun visitInputImage(inputImage: DecisionInputImage) {
                    inputImage.validate()
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
                override fun visitInputText(inputText: DecisionInputText) = inputText.validity()

                override fun visitInputImage(inputImage: DecisionInputImage) = inputImage.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is DecisionInputPart &&
            inputText == other.inputText &&
            inputImage == other.inputImage
    }

    override fun hashCode(): Int = Objects.hash(inputText, inputImage)

    override fun toString(): String =
        when {
            inputText != null -> "DecisionInputPart{inputText=$inputText}"
            inputImage != null -> "DecisionInputPart{inputImage=$inputImage}"
            _json != null -> "DecisionInputPart{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid DecisionInputPart")
        }

    companion object {

        @JvmStatic
        fun ofInputText(inputText: DecisionInputText) = DecisionInputPart(inputText = inputText)

        /**
         * An image provided as a base64 data URL or a publicly accessible HTTP(S) URL. File IDs are
         * not supported.
         */
        @JvmStatic
        fun ofInputImage(inputImage: DecisionInputImage) =
            DecisionInputPart(inputImage = inputImage)
    }

    /**
     * An interface that defines how to map each variant of [DecisionInputPart] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        fun visitInputText(inputText: DecisionInputText): T

        /**
         * An image provided as a base64 data URL or a publicly accessible HTTP(S) URL. File IDs are
         * not supported.
         */
        fun visitInputImage(inputImage: DecisionInputImage): T

        /**
         * Maps an unknown variant of [DecisionInputPart] to a value of type [T].
         *
         * An instance of [DecisionInputPart] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown DecisionInputPart")
        }
    }

    internal class Deserializer : BaseDeserializer<DecisionInputPart>(DecisionInputPart::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): DecisionInputPart {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "input_text" -> {
                    return tryDeserialize(node, jacksonTypeRef<DecisionInputText>())?.let {
                        DecisionInputPart(inputText = it, _json = json)
                    } ?: DecisionInputPart(_json = json)
                }
                "input_image" -> {
                    return tryDeserialize(node, jacksonTypeRef<DecisionInputImage>())?.let {
                        DecisionInputPart(inputImage = it, _json = json)
                    } ?: DecisionInputPart(_json = json)
                }
            }

            return DecisionInputPart(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<DecisionInputPart>(DecisionInputPart::class) {

        override fun serialize(
            value: DecisionInputPart,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.inputText != null -> generator.writeObject(value.inputText)
                value.inputImage != null -> generator.writeObject(value.inputImage)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid DecisionInputPart")
            }
        }
    }
}
