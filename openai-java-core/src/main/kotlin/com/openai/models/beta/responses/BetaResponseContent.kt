// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.allMaxBy
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional

/** Multi-modal input and output contents. */
@JsonDeserialize(using = BetaResponseContent.Deserializer::class)
@JsonSerialize(using = BetaResponseContent.Serializer::class)
class BetaResponseContent
private constructor(
    private val inputText: BetaResponseInputText? = null,
    private val inputImage: BetaResponseInputImage? = null,
    private val inputFile: BetaResponseInputFile? = null,
    private val outputText: BetaResponseOutputText? = null,
    private val outputRefusal: BetaResponseOutputRefusal? = null,
    private val reasoningText: ReasoningText? = null,
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

    /** A text output from the model. */
    fun outputText(): Optional<BetaResponseOutputText> = Optional.ofNullable(outputText)

    /** A refusal from the model. */
    fun outputRefusal(): Optional<BetaResponseOutputRefusal> = Optional.ofNullable(outputRefusal)

    /** Reasoning text from the model. */
    fun reasoningText(): Optional<ReasoningText> = Optional.ofNullable(reasoningText)

    fun isInputText(): Boolean = inputText != null

    fun isInputImage(): Boolean = inputImage != null

    fun isInputFile(): Boolean = inputFile != null

    fun isOutputText(): Boolean = outputText != null

    fun isOutputRefusal(): Boolean = outputRefusal != null

    fun isReasoningText(): Boolean = reasoningText != null

    /** A text input to the model. */
    fun asInputText(): BetaResponseInputText = inputText.getOrThrow("inputText")

    /**
     * An image input to the model. Learn about
     * [image inputs](https://platform.openai.com/docs/guides/vision).
     */
    fun asInputImage(): BetaResponseInputImage = inputImage.getOrThrow("inputImage")

    /** A file input to the model. */
    fun asInputFile(): BetaResponseInputFile = inputFile.getOrThrow("inputFile")

    /** A text output from the model. */
    fun asOutputText(): BetaResponseOutputText = outputText.getOrThrow("outputText")

    /** A refusal from the model. */
    fun asOutputRefusal(): BetaResponseOutputRefusal = outputRefusal.getOrThrow("outputRefusal")

    /** Reasoning text from the model. */
    fun asReasoningText(): ReasoningText = reasoningText.getOrThrow("reasoningText")

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
     * Optional<String> result = betaResponseContent.accept(new BetaResponseContent.Visitor<Optional<String>>() {
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
            outputText != null -> visitor.visitOutputText(outputText)
            outputRefusal != null -> visitor.visitOutputRefusal(outputRefusal)
            reasoningText != null -> visitor.visitReasoningText(reasoningText)
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
    fun validate(): BetaResponseContent = apply {
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

                override fun visitOutputText(outputText: BetaResponseOutputText) {
                    outputText.validate()
                }

                override fun visitOutputRefusal(outputRefusal: BetaResponseOutputRefusal) {
                    outputRefusal.validate()
                }

                override fun visitReasoningText(reasoningText: ReasoningText) {
                    reasoningText.validate()
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

                override fun visitOutputText(outputText: BetaResponseOutputText) =
                    outputText.validity()

                override fun visitOutputRefusal(outputRefusal: BetaResponseOutputRefusal) =
                    outputRefusal.validity()

                override fun visitReasoningText(reasoningText: ReasoningText) =
                    reasoningText.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BetaResponseContent &&
            inputText == other.inputText &&
            inputImage == other.inputImage &&
            inputFile == other.inputFile &&
            outputText == other.outputText &&
            outputRefusal == other.outputRefusal &&
            reasoningText == other.reasoningText
    }

    override fun hashCode(): Int =
        Objects.hash(inputText, inputImage, inputFile, outputText, outputRefusal, reasoningText)

    override fun toString(): String =
        when {
            inputText != null -> "BetaResponseContent{inputText=$inputText}"
            inputImage != null -> "BetaResponseContent{inputImage=$inputImage}"
            inputFile != null -> "BetaResponseContent{inputFile=$inputFile}"
            outputText != null -> "BetaResponseContent{outputText=$outputText}"
            outputRefusal != null -> "BetaResponseContent{outputRefusal=$outputRefusal}"
            reasoningText != null -> "BetaResponseContent{reasoningText=$reasoningText}"
            _json != null -> "BetaResponseContent{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid BetaResponseContent")
        }

    companion object {

        /** A text input to the model. */
        @JvmStatic
        fun ofInputText(inputText: BetaResponseInputText) =
            BetaResponseContent(inputText = inputText)

        /**
         * An image input to the model. Learn about
         * [image inputs](https://platform.openai.com/docs/guides/vision).
         */
        @JvmStatic
        fun ofInputImage(inputImage: BetaResponseInputImage) =
            BetaResponseContent(inputImage = inputImage)

        /** A file input to the model. */
        @JvmStatic
        fun ofInputFile(inputFile: BetaResponseInputFile) =
            BetaResponseContent(inputFile = inputFile)

        /** A text output from the model. */
        @JvmStatic
        fun ofOutputText(outputText: BetaResponseOutputText) =
            BetaResponseContent(outputText = outputText)

        /** A refusal from the model. */
        @JvmStatic
        fun ofOutputRefusal(outputRefusal: BetaResponseOutputRefusal) =
            BetaResponseContent(outputRefusal = outputRefusal)

        /** Reasoning text from the model. */
        @JvmStatic
        fun ofReasoningText(reasoningText: ReasoningText) =
            BetaResponseContent(reasoningText = reasoningText)
    }

    /**
     * An interface that defines how to map each variant of [BetaResponseContent] to a value of type
     * [T].
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

        /** A text output from the model. */
        fun visitOutputText(outputText: BetaResponseOutputText): T

        /** A refusal from the model. */
        fun visitOutputRefusal(outputRefusal: BetaResponseOutputRefusal): T

        /** Reasoning text from the model. */
        fun visitReasoningText(reasoningText: ReasoningText): T

        /**
         * Maps an unknown variant of [BetaResponseContent] to a value of type [T].
         *
         * An instance of [BetaResponseContent] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown BetaResponseContent: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<BetaResponseContent>(BetaResponseContent::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): BetaResponseContent {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<BetaResponseInputText>())?.let {
                            BetaResponseContent(inputText = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<BetaResponseInputImage>())?.let {
                            BetaResponseContent(inputImage = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<BetaResponseInputFile>())?.let {
                            BetaResponseContent(inputFile = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<BetaResponseOutputText>())?.let {
                            BetaResponseContent(outputText = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<BetaResponseOutputRefusal>())?.let {
                            BetaResponseContent(outputRefusal = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<ReasoningText>())?.let {
                            BetaResponseContent(reasoningText = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> BetaResponseContent(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer : BaseSerializer<BetaResponseContent>(BetaResponseContent::class) {

        override fun serialize(
            value: BetaResponseContent,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.inputText != null -> generator.writeObject(value.inputText)
                value.inputImage != null -> generator.writeObject(value.inputImage)
                value.inputFile != null -> generator.writeObject(value.inputFile)
                value.outputText != null -> generator.writeObject(value.outputText)
                value.outputRefusal != null -> generator.writeObject(value.outputRefusal)
                value.reasoningText != null -> generator.writeObject(value.reasoningText)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid BetaResponseContent")
            }
        }
    }

    /** Reasoning text from the model. */
    class ReasoningText
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val text: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(text, type, mutableMapOf())

        /**
         * The reasoning text from the model.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun text(): String = text.getRequired("text")

        /**
         * The type of the reasoning text. Always `reasoning_text`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("reasoning_text")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [text].
         *
         * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [ReasoningText].
             *
             * The following fields are required:
             * ```java
             * .text()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ReasoningText]. */
        class Builder internal constructor() {

            private var text: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("reasoning_text")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(reasoningText: ReasoningText) = apply {
                text = reasoningText.text
                type = reasoningText.type
                additionalProperties = reasoningText.additionalProperties.toMutableMap()
            }

            /** The reasoning text from the model. */
            fun text(text: String) = text(JsonField.of(text))

            /**
             * Sets [Builder.text] to an arbitrary JSON value.
             *
             * You should usually call [Builder.text] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun text(text: JsonField<String>) = apply { this.text = text }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("reasoning_text")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [ReasoningText].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .text()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ReasoningText =
                ReasoningText(
                    checkRequired("text", text),
                    type,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): ReasoningText = apply {
            if (validated) {
                return@apply
            }

            text()
            _type().let {
                if (it != JsonValue.from("reasoning_text")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (text.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("reasoning_text")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ReasoningText &&
                text == other.text &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(text, type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ReasoningText{text=$text, type=$type, additionalProperties=$additionalProperties}"
    }
}
