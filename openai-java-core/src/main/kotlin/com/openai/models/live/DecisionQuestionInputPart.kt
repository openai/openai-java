// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

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
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.allMaxBy
import com.openai.core.checkRequired
import com.openai.core.collectAllProperties
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

@JsonDeserialize(using = DecisionQuestionInputPart.Deserializer::class)
@JsonSerialize(using = DecisionQuestionInputPart.Serializer::class)
class DecisionQuestionInputPart
private constructor(
    private val inputText: DecisionInputText? = null,
    private val inputImage: InputImage? = null,
    private val inputJson: InputJson? = null,
    private val _json: JsonValue? = null,
) {

    fun inputText(): Optional<DecisionInputText> = Optional.ofNullable(inputText)

    fun inputImage(): Optional<InputImage> = Optional.ofNullable(inputImage)

    fun inputJson(): Optional<InputJson> = Optional.ofNullable(inputJson)

    fun isInputText(): Boolean = inputText != null

    fun isInputImage(): Boolean = inputImage != null

    fun isInputJson(): Boolean = inputJson != null

    fun asInputText(): DecisionInputText = inputText.getOrThrow("inputText")

    fun asInputImage(): InputImage = inputImage.getOrThrow("inputImage")

    fun asInputJson(): InputJson = inputJson.getOrThrow("inputJson")

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
                override fun visitInputText(inputText: DecisionInputText) {
                    inputText.validate()
                }

                override fun visitInputImage(inputImage: InputImage) {
                    inputImage.validate()
                }

                override fun visitInputJson(inputJson: InputJson) {
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
                override fun visitInputText(inputText: DecisionInputText) = inputText.validity()

                override fun visitInputImage(inputImage: InputImage) = inputImage.validity()

                override fun visitInputJson(inputJson: InputJson) = inputJson.validity()

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
        fun ofInputText(inputText: DecisionInputText) =
            DecisionQuestionInputPart(inputText = inputText)

        @JvmStatic
        fun ofInputImage(inputImage: InputImage) =
            DecisionQuestionInputPart(inputImage = inputImage)

        @JvmStatic
        fun ofInputJson(inputJson: InputJson) = DecisionQuestionInputPart(inputJson = inputJson)
    }

    /**
     * An interface that defines how to map each variant of [DecisionQuestionInputPart] to a value
     * of type [T].
     */
    interface Visitor<out T> {

        fun visitInputText(inputText: DecisionInputText): T = unknown(JsonValue.from(inputText))

        fun visitInputImage(inputImage: InputImage): T = unknown(JsonValue.from(inputImage))

        fun visitInputJson(inputJson: InputJson): T = unknown(JsonValue.from(inputJson))

        /**
         * Maps an unknown variant of [DecisionQuestionInputPart] to a value of type [T].
         *
         * An instance of [DecisionQuestionInputPart] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * Unhandled known JSON variants reach this method as JSON values.
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
                    return tryDeserialize(node, jacksonTypeRef<DecisionInputText>())?.let {
                        DecisionQuestionInputPart(inputText = it, _json = json)
                    } ?: DecisionQuestionInputPart(_json = json)
                }
                "input_image" -> {
                    return tryDeserialize(node, jacksonTypeRef<InputImage>())?.let {
                        DecisionQuestionInputPart(inputImage = it, _json = json)
                    } ?: DecisionQuestionInputPart(_json = json)
                }
                "input_json" -> {
                    return tryDeserialize(node, jacksonTypeRef<InputJson>())?.let {
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

    class InputImage
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val imageUrl: JsonField<String>,
        private val type: JsonValue,
        private val detail: JsonField<Detail>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("image_url")
            @ExcludeMissing
            imageUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("detail") @ExcludeMissing detail: JsonField<Detail> = JsonMissing.of(),
        ) : this(imageUrl, type, detail, mutableMapOf())

        /**
         * A base64-encoded image data URL or a publicly accessible HTTP(S) image URL. The schema
         * requires this property. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun imageUrl(): java.util.Optional<String> = imageUrl.getOptional("image_url")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun imageUrlOrThrow(): String = imageUrl.getRequired("image_url")

        /**
         * The schema requires this property. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun type(): java.util.Optional<JsonValue> {
            val raw = type
            return when {
                raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
                !(raw == JsonValue.from("input_image")) ->
                    throw OpenAIInvalidDataException("`type` is invalid")
                else -> java.util.Optional.of(raw)
            }
        }

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

        /**
         * The detail level of the image to be sent to the model. One of `high`, `low`, `auto`, or
         * `original`. Defaults to `auto`. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun detail(): java.util.Optional<Detail> = detail.getOptional("detail")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun detailOrThrow(): Detail = detail.getRequired("detail")

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
        @JsonProperty("detail") @ExcludeMissing fun _detail(): JsonField<Detail> = detail

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        /**
         * Returns an immutable snapshot of all present JSON properties, including declared and
         * additional properties.
         *
         * Keys use their JSON names. Declared properties take precedence over additional properties
         * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
         * values are preserved.
         */
        fun _allProperties(): Map<String, JsonValue> =
            collectAllProperties(
                additionalProperties,
                "image_url" to this.imageUrl,
                "type" to this.type,
                "detail" to this.detail,
            )

        @JvmSynthetic
        internal fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        @JsonAnyGetter
        @ExcludeMissing
        private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

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
            private var detail: JsonField<Detail> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(inputImage: InputImage) = apply {
                imageUrl = inputImage.imageUrl
                type = inputImage.type
                detail = inputImage.detail
                additionalProperties = inputImage.additionalProperties.toMutableMap()
            }

            /** A base64-encoded image data URL or a publicly accessible HTTP(S) image URL. */
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
             * The detail level of the image to be sent to the model. One of `high`, `low`, `auto`,
             * or `original`. Defaults to `auto`.
             */
            fun detail(detail: Detail?) = detail(JsonField.ofNullable(detail))

            /** Alias for calling [Builder.detail] with `detail.orElse(null)`. */
            fun detail(detail: Optional<Detail>) = detail(detail.getOrNull())

            /**
             * Sets [Builder.detail] to an arbitrary JSON value.
             *
             * You should usually call [Builder.detail] with a well-typed [Detail] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun detail(detail: JsonField<Detail>) = apply { this.detail = detail }

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

            imageUrlOrThrow()
            typeOrThrow()
            detail().ifPresent { it.validate() }
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
                (detail.asKnown().getOrNull()?.validity() ?: 0)

        /**
         * The detail level of the image to be sent to the model. One of `high`, `low`, `auto`, or
         * `original`. Defaults to `auto`.
         */
        class Detail @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val LOW = of("low")

                @JvmField val HIGH = of("high")

                @JvmField val AUTO = of("auto")

                @JvmField val ORIGINAL = of("original")

                @JvmStatic fun of(value: String) = Detail(JsonField.of(value))
            }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws OpenAIInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    OpenAIInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Detail = apply {
                if (validated) {
                    return@apply
                }

                asString()
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
                when (this) {
                    LOW -> 1
                    HIGH -> 1
                    AUTO -> 1
                    ORIGINAL -> 1
                    else -> 0
                }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Detail && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

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

    class InputJson
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val data: JsonField<Data>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("data") @ExcludeMissing data: JsonField<Data> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(data, type, mutableMapOf())

        /**
         * The schema requires this property. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun data(): java.util.Optional<Data> = data.getOptional("data")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun dataOrThrow(): Data = data.getRequired("data")

        /**
         * The schema requires this property. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun type(): java.util.Optional<JsonValue> {
            val raw = type
            return when {
                raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
                !(raw == JsonValue.from("input_json")) ->
                    throw OpenAIInvalidDataException("`type` is invalid")
                else -> java.util.Optional.of(raw)
            }
        }

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        /**
         * Returns an immutable snapshot of all present JSON properties, including declared and
         * additional properties.
         *
         * Keys use their JSON names. Declared properties take precedence over additional properties
         * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
         * values are preserved.
         */
        fun _allProperties(): Map<String, JsonValue> =
            collectAllProperties(additionalProperties, "data" to this.data, "type" to this.type)

        @JvmSynthetic
        internal fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        @JsonAnyGetter
        @ExcludeMissing
        private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [InputJson].
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [InputJson]. */
        class Builder internal constructor() {

            private var data: JsonField<Data>? = null
            private var type: JsonValue = JsonValue.from("input_json")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(inputJson: InputJson) = apply {
                data = inputJson.data
                type = inputJson.type
                additionalProperties = inputJson.additionalProperties.toMutableMap()
            }

            fun data(data: Data) = data(JsonField.of(data))

            /**
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [Data] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun data(data: JsonField<Data>) = apply { this.data = data }

            /** Alias for calling [data] with `Data.ofDecisionJsonObject(decisionJsonObject)`. */
            fun data(decisionJsonObject: DecisionJsonObject) =
                data(Data.ofDecisionJsonObject(decisionJsonObject))

            /** Alias for calling [data] with `Data.ofDecisionJsonObjects(decisionJsonObjects)`. */
            fun dataOfDecisionJsonObjects(decisionJsonObjects: List<DecisionJsonObject>) =
                data(Data.ofDecisionJsonObjects(decisionJsonObjects))

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("input_json")
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
             * Returns an immutable instance of [InputJson].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): InputJson =
                InputJson(checkRequired("data", data), type, additionalProperties.toMutableMap())
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
        fun validate(): InputJson = apply {
            if (validated) {
                return@apply
            }

            dataOrThrow().validate()
            typeOrThrow()
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
            (data.asKnown().getOrNull()?.validity() ?: 0) +
                type.let { if (it == JsonValue.from("input_json")) 1 else 0 }

        @JsonDeserialize(using = Data.Deserializer::class)
        @JsonSerialize(using = Data.Serializer::class)
        class Data
        private constructor(
            private val decisionJsonObject: DecisionJsonObject? = null,
            private val decisionJsonObjects: List<DecisionJsonObject>? = null,
            private val _json: JsonValue? = null,
        ) {

            fun decisionJsonObject(): Optional<DecisionJsonObject> =
                Optional.ofNullable(decisionJsonObject)

            fun decisionJsonObjects(): Optional<List<DecisionJsonObject>> =
                Optional.ofNullable(decisionJsonObjects)

            fun isDecisionJsonObject(): Boolean = decisionJsonObject != null

            fun isDecisionJsonObjects(): Boolean = decisionJsonObjects != null

            fun asDecisionJsonObject(): DecisionJsonObject =
                decisionJsonObject.getOrThrow("decisionJsonObject")

            fun asDecisionJsonObjects(): List<DecisionJsonObject> =
                decisionJsonObjects.getOrThrow("decisionJsonObjects")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            /**
             * Maps this instance's current variant to a value of type [T] using the given
             * [visitor].
             *
             * Note that this method is _not_ forwards compatible with new variants from the API,
             * unless [visitor] overrides [Visitor.unknown]. To handle variants not known to this
             * version of the SDK gracefully, consider overriding [Visitor.unknown]:
             * ```java
             * import com.openai.core.JsonValue;
             * import java.util.Optional;
             *
             * Optional<String> result = data.accept(new Data.Visitor<Optional<String>>() {
             *     @Override
             *     public Optional<String> visitDecisionJsonObject(DecisionJsonObject decisionJsonObject) {
             *         return Optional.of(decisionJsonObject.toString());
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
             * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in
             *   [visitor] and the current variant is unknown.
             */
            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    decisionJsonObject != null ->
                        visitor.visitDecisionJsonObject(decisionJsonObject)
                    decisionJsonObjects != null ->
                        visitor.visitDecisionJsonObjects(decisionJsonObjects)
                    else -> visitor.unknown(_json)
                }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Data = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitDecisionJsonObject(
                            decisionJsonObject: DecisionJsonObject
                        ) {
                            decisionJsonObject.validate()
                        }

                        override fun visitDecisionJsonObjects(
                            decisionJsonObjects: List<DecisionJsonObject>
                        ) {
                            decisionJsonObjects.forEach { it.validate() }
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
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                accept(
                    object : Visitor<Int> {
                        override fun visitDecisionJsonObject(
                            decisionJsonObject: DecisionJsonObject
                        ) = decisionJsonObject.validity()

                        override fun visitDecisionJsonObjects(
                            decisionJsonObjects: List<DecisionJsonObject>
                        ) = decisionJsonObjects.sumOf { it.validity().toInt() }

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Data &&
                    decisionJsonObject == other.decisionJsonObject &&
                    decisionJsonObjects == other.decisionJsonObjects &&
                    (decisionJsonObject != null ||
                        decisionJsonObjects != null ||
                        _json == other._json)
            }

            override fun hashCode(): Int =
                if (decisionJsonObject == null && decisionJsonObjects == null) Objects.hash(_json)
                else Objects.hash(decisionJsonObject, decisionJsonObjects)

            override fun toString(): String =
                when {
                    decisionJsonObject != null -> "Data{decisionJsonObject=$decisionJsonObject}"
                    decisionJsonObjects != null -> "Data{decisionJsonObjects=$decisionJsonObjects}"
                    _json != null -> "Data{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Data")
                }

            companion object {

                @JvmStatic
                fun ofDecisionJsonObject(decisionJsonObject: DecisionJsonObject) =
                    Data(decisionJsonObject = decisionJsonObject)

                @JvmStatic
                fun ofDecisionJsonObjects(decisionJsonObjects: List<DecisionJsonObject>) =
                    Data(decisionJsonObjects = decisionJsonObjects.toImmutable())
            }

            /**
             * An interface that defines how to map each variant of [Data] to a value of type [T].
             */
            interface Visitor<out T> {

                fun visitDecisionJsonObject(decisionJsonObject: DecisionJsonObject): T =
                    unknown(JsonValue.from(decisionJsonObject))

                fun visitDecisionJsonObjects(decisionJsonObjects: List<DecisionJsonObject>): T =
                    unknown(JsonValue.from(decisionJsonObjects))

                /**
                 * Maps an unknown variant of [Data] to a value of type [T].
                 *
                 * An instance of [Data] can contain an unknown variant if it was deserialized from
                 * data that doesn't match any known variant. For example, if the SDK is on an older
                 * version than the API, then the API may respond with new variants that the SDK is
                 * unaware of.
                 *
                 * Unhandled known JSON variants reach this method as JSON values.
                 *
                 * @throws OpenAIInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown Data")
                }
            }

            internal class Deserializer : BaseDeserializer<Data>(Data::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): Data {
                    val json = JsonValue.fromJsonNode(node)

                    val bestMatches =
                        sequenceOf(
                                tryDeserialize(node, jacksonTypeRef<DecisionJsonObject>())?.let {
                                    Data(decisionJsonObject = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<List<DecisionJsonObject>>())
                                    ?.let { Data(decisionJsonObjects = it, _json = json) },
                            )
                            .filterNotNull()
                            .allMaxBy { it.validity() }
                            .toList()
                    return when (bestMatches.size) {
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from boolean).
                        0 -> Data(_json = json)
                        1 -> bestMatches.single()
                        // If there's more than one match with the highest validity, then use the
                        // first completely valid match, or simply the first match if none are
                        // completely valid.
                        else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                    }
                }
            }

            internal class Serializer : BaseSerializer<Data>(Data::class) {

                override fun serialize(
                    value: Data,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.decisionJsonObject != null ->
                            generator.writeObject(value.decisionJsonObject)
                        value.decisionJsonObjects != null ->
                            generator.writeObject(value.decisionJsonObjects)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Data")
                    }
                }
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is InputJson &&
                data == other.data &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(data, type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "InputJson{data=$data, type=$type, additionalProperties=$additionalProperties}"
    }
}
