// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

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
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** User-provided content recorded in a session item. */
@JsonDeserialize(using = InputContent.Deserializer::class)
@JsonSerialize(using = InputContent.Serializer::class)
class InputContent
private constructor(
    private val inputText: InputText? = null,
    private val inputImage: InputImage? = null,
    private val _json: JsonValue? = null,
) {

    /** Text input recorded in a session item. */
    fun inputText(): Optional<InputText> = Optional.ofNullable(inputText)

    /** Image input recorded in a session item. */
    fun inputImage(): Optional<InputImage> = Optional.ofNullable(inputImage)

    fun isInputText(): Boolean = inputText != null

    fun isInputImage(): Boolean = inputImage != null

    /** Text input recorded in a session item. */
    fun asInputText(): InputText = inputText.getOrThrow("inputText")

    /** Image input recorded in a session item. */
    fun asInputImage(): InputImage = inputImage.getOrThrow("inputImage")

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
     * Optional<String> result = inputContent.accept(new InputContent.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitInputText(InputText inputText) {
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
    fun validate(): InputContent = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitInputText(inputText: InputText) {
                    inputText.validate()
                }

                override fun visitInputImage(inputImage: InputImage) {
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
                override fun visitInputText(inputText: InputText) = inputText.validity()

                override fun visitInputImage(inputImage: InputImage) = inputImage.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InputContent &&
            inputText == other.inputText &&
            inputImage == other.inputImage
    }

    override fun hashCode(): Int = Objects.hash(inputText, inputImage)

    override fun toString(): String =
        when {
            inputText != null -> "InputContent{inputText=$inputText}"
            inputImage != null -> "InputContent{inputImage=$inputImage}"
            _json != null -> "InputContent{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid InputContent")
        }

    companion object {

        /** Text input recorded in a session item. */
        @JvmStatic fun ofInputText(inputText: InputText) = InputContent(inputText = inputText)

        /** Image input recorded in a session item. */
        @JvmStatic fun ofInputImage(inputImage: InputImage) = InputContent(inputImage = inputImage)
    }

    /**
     * An interface that defines how to map each variant of [InputContent] to a value of type [T].
     */
    interface Visitor<out T> {

        /** Text input recorded in a session item. */
        fun visitInputText(inputText: InputText): T

        /** Image input recorded in a session item. */
        fun visitInputImage(inputImage: InputImage): T

        /**
         * Maps an unknown variant of [InputContent] to a value of type [T].
         *
         * An instance of [InputContent] can contain an unknown variant if it was deserialized from
         * data that doesn't match any known variant. For example, if the SDK is on an older version
         * than the API, then the API may respond with new variants that the SDK is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown InputContent: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<InputContent>(InputContent::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): InputContent {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "input_text" -> {
                    return tryDeserialize(node, jacksonTypeRef<InputText>())?.let {
                        InputContent(inputText = it, _json = json)
                    } ?: InputContent(_json = json)
                }
                "input_image" -> {
                    return tryDeserialize(node, jacksonTypeRef<InputImage>())?.let {
                        InputContent(inputImage = it, _json = json)
                    } ?: InputContent(_json = json)
                }
            }

            return InputContent(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<InputContent>(InputContent::class) {

        override fun serialize(
            value: InputContent,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.inputText != null -> generator.writeObject(value.inputText)
                value.inputImage != null -> generator.writeObject(value.inputImage)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid InputContent")
            }
        }
    }

    /** Text input recorded in a session item. */
    class InputText
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
         * The text supplied to the agent.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun text(): String = text.getRequired("text")

        /**
         * The type of the object. Always `input_text`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("input_text")
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
             * Returns a mutable builder for constructing an instance of [InputText].
             *
             * The following fields are required:
             * ```java
             * .text()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [InputText]. */
        class Builder internal constructor() {

            private var text: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("input_text")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(inputText: InputText) = apply {
                text = inputText.text
                type = inputText.type
                additionalProperties = inputText.additionalProperties.toMutableMap()
            }

            /** The text supplied to the agent. */
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
             * JsonValue.from("input_text")
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
             * Returns an immutable instance of [InputText].
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
            fun build(): InputText =
                InputText(checkRequired("text", text), type, additionalProperties.toMutableMap())
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
        fun validate(): InputText = apply {
            if (validated) {
                return@apply
            }

            text()
            _type().let {
                if (it != JsonValue.from("input_text")) {
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
                type.let { if (it == JsonValue.from("input_text")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is InputText &&
                text == other.text &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(text, type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "InputText{text=$text, type=$type, additionalProperties=$additionalProperties}"
    }

    /** Image input recorded in a session item. */
    class InputImage
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val imageUrl: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("image_url")
            @ExcludeMissing
            imageUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(imageUrl, type, mutableMapOf())

        /**
         * The URL of the image supplied to the agent, which may be a base64-encoded data URL.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun imageUrl(): String = imageUrl.getRequired("image_url")

        /**
         * The type of the object. Always `input_image`.
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
         * Returns the raw JSON value of [imageUrl].
         *
         * Unlike [imageUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("image_url") @ExcludeMissing fun _imageUrl(): JsonField<String> = imageUrl

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
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(inputImage: InputImage) = apply {
                imageUrl = inputImage.imageUrl
                type = inputImage.type
                additionalProperties = inputImage.additionalProperties.toMutableMap()
            }

            /**
             * The URL of the image supplied to the agent, which may be a base64-encoded data URL.
             */
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
                type.let { if (it == JsonValue.from("input_image")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is InputImage &&
                imageUrl == other.imageUrl &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(imageUrl, type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "InputImage{imageUrl=$imageUrl, type=$type, additionalProperties=$additionalProperties}"
    }
}
