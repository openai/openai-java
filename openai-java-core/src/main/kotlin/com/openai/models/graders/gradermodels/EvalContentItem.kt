// File generated from our OpenAPI spec by Stainless.

package com.openai.models.graders.gradermodels

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
import com.openai.models.responses.ResponseInputAudio
import com.openai.models.responses.ResponseInputText
import java.util.Collections
import java.util.Objects
import java.util.Optional

/** A single content item: input text, output text, input image, or input audio. */
@JsonDeserialize(using = EvalContentItem.Deserializer::class)
@JsonSerialize(using = EvalContentItem.Serializer::class)
class EvalContentItem
private constructor(
    private val textInput: String? = null,
    private val responseInputText: ResponseInputText? = null,
    private val outputText: OutputText? = null,
    private val inputImage: InputImage? = null,
    private val responseInputAudio: ResponseInputAudio? = null,
    private val _json: JsonValue? = null,
) {

    /** A text input to the model. */
    fun textInput(): Optional<String> = Optional.ofNullable(textInput)

    /** A text input to the model. */
    fun responseInputText(): Optional<ResponseInputText> = Optional.ofNullable(responseInputText)

    /** A text output from the model. */
    fun outputText(): Optional<OutputText> = Optional.ofNullable(outputText)

    /** An image input block used within EvalItem content arrays. */
    fun inputImage(): Optional<InputImage> = Optional.ofNullable(inputImage)

    /** An audio input to the model. */
    fun responseInputAudio(): Optional<ResponseInputAudio> = Optional.ofNullable(responseInputAudio)

    fun isTextInput(): Boolean = textInput != null

    fun isResponseInputText(): Boolean = responseInputText != null

    fun isOutputText(): Boolean = outputText != null

    fun isInputImage(): Boolean = inputImage != null

    fun isResponseInputAudio(): Boolean = responseInputAudio != null

    /** A text input to the model. */
    fun asTextInput(): String = textInput.getOrThrow("textInput")

    /** A text input to the model. */
    fun asResponseInputText(): ResponseInputText = responseInputText.getOrThrow("responseInputText")

    /** A text output from the model. */
    fun asOutputText(): OutputText = outputText.getOrThrow("outputText")

    /** An image input block used within EvalItem content arrays. */
    fun asInputImage(): InputImage = inputImage.getOrThrow("inputImage")

    /** An audio input to the model. */
    fun asResponseInputAudio(): ResponseInputAudio =
        responseInputAudio.getOrThrow("responseInputAudio")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            textInput != null -> visitor.visitTextInput(textInput)
            responseInputText != null -> visitor.visitResponseInputText(responseInputText)
            outputText != null -> visitor.visitOutputText(outputText)
            inputImage != null -> visitor.visitInputImage(inputImage)
            responseInputAudio != null -> visitor.visitResponseInputAudio(responseInputAudio)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): EvalContentItem = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitTextInput(textInput: String) {}

                override fun visitResponseInputText(responseInputText: ResponseInputText) {
                    responseInputText.validate()
                }

                override fun visitOutputText(outputText: OutputText) {
                    outputText.validate()
                }

                override fun visitInputImage(inputImage: InputImage) {
                    inputImage.validate()
                }

                override fun visitResponseInputAudio(responseInputAudio: ResponseInputAudio) {
                    responseInputAudio.validate()
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
                override fun visitTextInput(textInput: String) = 1

                override fun visitResponseInputText(responseInputText: ResponseInputText) =
                    responseInputText.validity()

                override fun visitOutputText(outputText: OutputText) = outputText.validity()

                override fun visitInputImage(inputImage: InputImage) = inputImage.validity()

                override fun visitResponseInputAudio(responseInputAudio: ResponseInputAudio) =
                    responseInputAudio.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is EvalContentItem &&
            textInput == other.textInput &&
            responseInputText == other.responseInputText &&
            outputText == other.outputText &&
            inputImage == other.inputImage &&
            responseInputAudio == other.responseInputAudio
    }

    override fun hashCode(): Int =
        Objects.hash(textInput, responseInputText, outputText, inputImage, responseInputAudio)

    override fun toString(): String =
        when {
            textInput != null -> "EvalContentItem{textInput=$textInput}"
            responseInputText != null -> "EvalContentItem{responseInputText=$responseInputText}"
            outputText != null -> "EvalContentItem{outputText=$outputText}"
            inputImage != null -> "EvalContentItem{inputImage=$inputImage}"
            responseInputAudio != null -> "EvalContentItem{responseInputAudio=$responseInputAudio}"
            _json != null -> "EvalContentItem{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid EvalContentItem")
        }

    companion object {

        /** A text input to the model. */
        @JvmStatic fun ofTextInput(textInput: String) = EvalContentItem(textInput = textInput)

        /** A text input to the model. */
        @JvmStatic
        fun ofResponseInputText(responseInputText: ResponseInputText) =
            EvalContentItem(responseInputText = responseInputText)

        /** A text output from the model. */
        @JvmStatic
        fun ofOutputText(outputText: OutputText) = EvalContentItem(outputText = outputText)

        /** An image input block used within EvalItem content arrays. */
        @JvmStatic
        fun ofInputImage(inputImage: InputImage) = EvalContentItem(inputImage = inputImage)

        /** An audio input to the model. */
        @JvmStatic
        fun ofResponseInputAudio(responseInputAudio: ResponseInputAudio) =
            EvalContentItem(responseInputAudio = responseInputAudio)
    }

    /**
     * An interface that defines how to map each variant of [EvalContentItem] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        /** A text input to the model. */
        fun visitTextInput(textInput: String): T

        /** A text input to the model. */
        fun visitResponseInputText(responseInputText: ResponseInputText): T

        /** A text output from the model. */
        fun visitOutputText(outputText: OutputText): T

        /** An image input block used within EvalItem content arrays. */
        fun visitInputImage(inputImage: InputImage): T

        /** An audio input to the model. */
        fun visitResponseInputAudio(responseInputAudio: ResponseInputAudio): T

        /**
         * Maps an unknown variant of [EvalContentItem] to a value of type [T].
         *
         * An instance of [EvalContentItem] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown EvalContentItem: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<EvalContentItem>(EvalContentItem::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): EvalContentItem {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<ResponseInputText>())?.let {
                            EvalContentItem(responseInputText = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<OutputText>())?.let {
                            EvalContentItem(outputText = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<InputImage>())?.let {
                            EvalContentItem(inputImage = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<ResponseInputAudio>())?.let {
                            EvalContentItem(responseInputAudio = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<String>())?.let {
                            EvalContentItem(textInput = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> EvalContentItem(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer : BaseSerializer<EvalContentItem>(EvalContentItem::class) {

        override fun serialize(
            value: EvalContentItem,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.textInput != null -> generator.writeObject(value.textInput)
                value.responseInputText != null -> generator.writeObject(value.responseInputText)
                value.outputText != null -> generator.writeObject(value.outputText)
                value.inputImage != null -> generator.writeObject(value.inputImage)
                value.responseInputAudio != null -> generator.writeObject(value.responseInputAudio)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid EvalContentItem")
            }
        }
    }

    /** A text output from the model. */
    class OutputText
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
         * The text output from the model.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun text(): String = text.getRequired("text")

        /**
         * The type of the output text. Always `output_text`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("output_text")
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
             * Returns a mutable builder for constructing an instance of [OutputText].
             *
             * The following fields are required:
             * ```java
             * .text()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [OutputText]. */
        class Builder internal constructor() {

            private var text: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("output_text")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(outputText: OutputText) = apply {
                text = outputText.text
                type = outputText.type
                additionalProperties = outputText.additionalProperties.toMutableMap()
            }

            /** The text output from the model. */
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
             * JsonValue.from("output_text")
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
             * Returns an immutable instance of [OutputText].
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
            fun build(): OutputText =
                OutputText(checkRequired("text", text), type, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): OutputText = apply {
            if (validated) {
                return@apply
            }

            text()
            _type().let {
                if (it != JsonValue.from("output_text")) {
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
                type.let { if (it == JsonValue.from("output_text")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is OutputText &&
                text == other.text &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(text, type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "OutputText{text=$text, type=$type, additionalProperties=$additionalProperties}"
    }

    /** An image input block used within EvalItem content arrays. */
    class InputImage
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val imageUrl: JsonField<String>,
        private val type: JsonValue,
        private val detail: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("image_url")
            @ExcludeMissing
            imageUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("detail") @ExcludeMissing detail: JsonField<String> = JsonMissing.of(),
        ) : this(imageUrl, type, detail, mutableMapOf())

        /**
         * The URL of the image input.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun imageUrl(): String = imageUrl.getRequired("image_url")

        /**
         * The type of the image input. Always `input_image`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("input_image")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The detail level of the image to be sent to the model. One of `high`, `low`, or `auto`.
         * Defaults to `auto`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun detail(): Optional<String> = detail.getOptional("detail")

        /**
         * Returns the raw JSON value of [imageUrl].
         *
         * Unlike [imageUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("image_url") @ExcludeMissing fun _imageUrl(): JsonField<String> = imageUrl

        /**
         * Returns the raw JSON value of [detail].
         *
         * Unlike [detail], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("detail") @ExcludeMissing fun _detail(): JsonField<String> = detail

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
             * Returns a mutable builder for constructing an instance of [InputImage].
             *
             * The following fields are required:
             * ```java
             * .imageUrl()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [InputImage]. */
        class Builder internal constructor() {

            private var imageUrl: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("input_image")
            private var detail: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(inputImage: InputImage) = apply {
                imageUrl = inputImage.imageUrl
                type = inputImage.type
                detail = inputImage.detail
                additionalProperties = inputImage.additionalProperties.toMutableMap()
            }

            /** The URL of the image input. */
            fun imageUrl(imageUrl: String) = imageUrl(JsonField.of(imageUrl))

            /**
             * Sets [Builder.imageUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.imageUrl] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun imageUrl(imageUrl: JsonField<String>) = apply { this.imageUrl = imageUrl }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("input_image")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            /**
             * The detail level of the image to be sent to the model. One of `high`, `low`, or
             * `auto`. Defaults to `auto`.
             */
            fun detail(detail: String) = detail(JsonField.of(detail))

            /**
             * Sets [Builder.detail] to an arbitrary JSON value.
             *
             * You should usually call [Builder.detail] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun detail(detail: JsonField<String>) = apply { this.detail = detail }

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
             * Returns an immutable instance of [InputImage].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .imageUrl()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): InputImage =
                InputImage(
                    checkRequired("imageUrl", imageUrl),
                    type,
                    detail,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): InputImage = apply {
            if (validated) {
                return@apply
            }

            imageUrl()
            _type().let {
                if (it != JsonValue.from("input_image")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            detail()
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
            (if (imageUrl.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("input_image")) 1 else 0 } +
                (if (detail.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is InputImage &&
                imageUrl == other.imageUrl &&
                type == other.type &&
                detail == other.detail &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(imageUrl, type, detail, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "InputImage{imageUrl=$imageUrl, type=$type, detail=$detail, additionalProperties=$additionalProperties}"
    }
}
