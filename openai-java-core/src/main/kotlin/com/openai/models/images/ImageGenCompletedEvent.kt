// File generated from our OpenAPI spec by Stainless.

package com.openai.models.images

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** Emitted when image generation has completed and the final image is available. */
class ImageGenCompletedEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val b64Json: JsonField<String>,
    private val background: JsonField<Background>,
    private val createdAt: JsonField<Long>,
    private val outputFormat: JsonField<OutputFormat>,
    private val quality: JsonField<Quality>,
    private val size: JsonField<Size>,
    private val type: JsonValue,
    private val usage: JsonField<Usage>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("b64_json") @ExcludeMissing b64Json: JsonField<String> = JsonMissing.of(),
        @JsonProperty("background")
        @ExcludeMissing
        background: JsonField<Background> = JsonMissing.of(),
        @JsonProperty("created_at") @ExcludeMissing createdAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("output_format")
        @ExcludeMissing
        outputFormat: JsonField<OutputFormat> = JsonMissing.of(),
        @JsonProperty("quality") @ExcludeMissing quality: JsonField<Quality> = JsonMissing.of(),
        @JsonProperty("size") @ExcludeMissing size: JsonField<Size> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("usage") @ExcludeMissing usage: JsonField<Usage> = JsonMissing.of(),
    ) : this(
        b64Json,
        background,
        createdAt,
        outputFormat,
        quality,
        size,
        type,
        usage,
        mutableMapOf(),
    )

    /**
     * Base64-encoded image data, suitable for rendering as an image.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun b64Json(): String = b64Json.getRequired("b64_json")

    /**
     * The background setting for the generated image.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun background(): Background = background.getRequired("background")

    /**
     * The Unix timestamp when the event was created.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /**
     * The output format for the generated image.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun outputFormat(): OutputFormat = outputFormat.getRequired("output_format")

    /**
     * The quality setting for the generated image.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun quality(): Quality = quality.getRequired("quality")

    /**
     * The size of the generated image.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun size(): Size = size.getRequired("size")

    /**
     * The type of the event. Always `image_generation.completed`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("image_generation.completed")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * For the GPT image models only, the token usage information for the image generation.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun usage(): Usage = usage.getRequired("usage")

    /**
     * Returns the raw JSON value of [b64Json].
     *
     * Unlike [b64Json], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("b64_json") @ExcludeMissing fun _b64Json(): JsonField<String> = b64Json

    /**
     * Returns the raw JSON value of [background].
     *
     * Unlike [background], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("background")
    @ExcludeMissing
    fun _background(): JsonField<Background> = background

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt(): JsonField<Long> = createdAt

    /**
     * Returns the raw JSON value of [outputFormat].
     *
     * Unlike [outputFormat], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("output_format")
    @ExcludeMissing
    fun _outputFormat(): JsonField<OutputFormat> = outputFormat

    /**
     * Returns the raw JSON value of [quality].
     *
     * Unlike [quality], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("quality") @ExcludeMissing fun _quality(): JsonField<Quality> = quality

    /**
     * Returns the raw JSON value of [size].
     *
     * Unlike [size], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("size") @ExcludeMissing fun _size(): JsonField<Size> = size

    /**
     * Returns the raw JSON value of [usage].
     *
     * Unlike [usage], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("usage") @ExcludeMissing fun _usage(): JsonField<Usage> = usage

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
         * Returns a mutable builder for constructing an instance of [ImageGenCompletedEvent].
         *
         * The following fields are required:
         * ```java
         * .b64Json()
         * .background()
         * .createdAt()
         * .outputFormat()
         * .quality()
         * .size()
         * .usage()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ImageGenCompletedEvent]. */
    class Builder internal constructor() {

        private var b64Json: JsonField<String>? = null
        private var background: JsonField<Background>? = null
        private var createdAt: JsonField<Long>? = null
        private var outputFormat: JsonField<OutputFormat>? = null
        private var quality: JsonField<Quality>? = null
        private var size: JsonField<Size>? = null
        private var type: JsonValue = JsonValue.from("image_generation.completed")
        private var usage: JsonField<Usage>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(imageGenCompletedEvent: ImageGenCompletedEvent) = apply {
            b64Json = imageGenCompletedEvent.b64Json
            background = imageGenCompletedEvent.background
            createdAt = imageGenCompletedEvent.createdAt
            outputFormat = imageGenCompletedEvent.outputFormat
            quality = imageGenCompletedEvent.quality
            size = imageGenCompletedEvent.size
            type = imageGenCompletedEvent.type
            usage = imageGenCompletedEvent.usage
            additionalProperties = imageGenCompletedEvent.additionalProperties.toMutableMap()
        }

        /** Base64-encoded image data, suitable for rendering as an image. */
        fun b64Json(b64Json: String) = b64Json(JsonField.of(b64Json))

        /**
         * Sets [Builder.b64Json] to an arbitrary JSON value.
         *
         * You should usually call [Builder.b64Json] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun b64Json(b64Json: JsonField<String>) = apply { this.b64Json = b64Json }

        /** The background setting for the generated image. */
        fun background(background: Background) = background(JsonField.of(background))

        /**
         * Sets [Builder.background] to an arbitrary JSON value.
         *
         * You should usually call [Builder.background] with a well-typed [Background] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun background(background: JsonField<Background>) = apply { this.background = background }

        /** The Unix timestamp when the event was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /** The output format for the generated image. */
        fun outputFormat(outputFormat: OutputFormat) = outputFormat(JsonField.of(outputFormat))

        /**
         * Sets [Builder.outputFormat] to an arbitrary JSON value.
         *
         * You should usually call [Builder.outputFormat] with a well-typed [OutputFormat] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun outputFormat(outputFormat: JsonField<OutputFormat>) = apply {
            this.outputFormat = outputFormat
        }

        /** The quality setting for the generated image. */
        fun quality(quality: Quality) = quality(JsonField.of(quality))

        /**
         * Sets [Builder.quality] to an arbitrary JSON value.
         *
         * You should usually call [Builder.quality] with a well-typed [Quality] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun quality(quality: JsonField<Quality>) = apply { this.quality = quality }

        /** The size of the generated image. */
        fun size(size: Size) = size(JsonField.of(size))

        /**
         * Sets [Builder.size] to an arbitrary JSON value.
         *
         * You should usually call [Builder.size] with a well-typed [Size] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun size(size: JsonField<Size>) = apply { this.size = size }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("image_generation.completed")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** For the GPT image models only, the token usage information for the image generation. */
        fun usage(usage: Usage) = usage(JsonField.of(usage))

        /**
         * Sets [Builder.usage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.usage] with a well-typed [Usage] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun usage(usage: JsonField<Usage>) = apply { this.usage = usage }

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
         * Returns an immutable instance of [ImageGenCompletedEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .b64Json()
         * .background()
         * .createdAt()
         * .outputFormat()
         * .quality()
         * .size()
         * .usage()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ImageGenCompletedEvent =
            ImageGenCompletedEvent(
                checkRequired("b64Json", b64Json),
                checkRequired("background", background),
                checkRequired("createdAt", createdAt),
                checkRequired("outputFormat", outputFormat),
                checkRequired("quality", quality),
                checkRequired("size", size),
                type,
                checkRequired("usage", usage),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ImageGenCompletedEvent = apply {
        if (validated) {
            return@apply
        }

        b64Json()
        background().validate()
        createdAt()
        outputFormat().validate()
        quality().validate()
        size().validate()
        _type().let {
            if (it != JsonValue.from("image_generation.completed")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        usage().validate()
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
        (if (b64Json.asKnown().isPresent) 1 else 0) +
            (background.asKnown().getOrNull()?.validity() ?: 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (outputFormat.asKnown().getOrNull()?.validity() ?: 0) +
            (quality.asKnown().getOrNull()?.validity() ?: 0) +
            (size.asKnown().getOrNull()?.validity() ?: 0) +
            type.let { if (it == JsonValue.from("image_generation.completed")) 1 else 0 } +
            (usage.asKnown().getOrNull()?.validity() ?: 0)

    /** The background setting for the generated image. */
    class Background @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val TRANSPARENT = of("transparent")

            @JvmField val OPAQUE = of("opaque")

            @JvmField val AUTO = of("auto")

            @JvmStatic fun of(value: String) = Background(JsonField.of(value))
        }

        /** An enum containing [Background]'s known values. */
        enum class Known {
            TRANSPARENT,
            OPAQUE,
            AUTO,
        }

        /**
         * An enum containing [Background]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Background] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            TRANSPARENT,
            OPAQUE,
            AUTO,
            /**
             * An enum member indicating that [Background] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                TRANSPARENT -> Value.TRANSPARENT
                OPAQUE -> Value.OPAQUE
                AUTO -> Value.AUTO
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws OpenAIInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                TRANSPARENT -> Known.TRANSPARENT
                OPAQUE -> Known.OPAQUE
                AUTO -> Known.AUTO
                else -> throw OpenAIInvalidDataException("Unknown Background: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws OpenAIInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { OpenAIInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

        fun validate(): Background = apply {
            if (validated) {
                return@apply
            }

            known()
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
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Background && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** The output format for the generated image. */
    class OutputFormat @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val PNG = of("png")

            @JvmField val WEBP = of("webp")

            @JvmField val JPEG = of("jpeg")

            @JvmStatic fun of(value: String) = OutputFormat(JsonField.of(value))
        }

        /** An enum containing [OutputFormat]'s known values. */
        enum class Known {
            PNG,
            WEBP,
            JPEG,
        }

        /**
         * An enum containing [OutputFormat]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [OutputFormat] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            PNG,
            WEBP,
            JPEG,
            /**
             * An enum member indicating that [OutputFormat] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                PNG -> Value.PNG
                WEBP -> Value.WEBP
                JPEG -> Value.JPEG
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws OpenAIInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                PNG -> Known.PNG
                WEBP -> Known.WEBP
                JPEG -> Known.JPEG
                else -> throw OpenAIInvalidDataException("Unknown OutputFormat: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws OpenAIInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { OpenAIInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

        fun validate(): OutputFormat = apply {
            if (validated) {
                return@apply
            }

            known()
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
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is OutputFormat && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** The quality setting for the generated image. */
    class Quality @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val LOW = of("low")

            @JvmField val MEDIUM = of("medium")

            @JvmField val HIGH = of("high")

            @JvmField val AUTO = of("auto")

            @JvmStatic fun of(value: String) = Quality(JsonField.of(value))
        }

        /** An enum containing [Quality]'s known values. */
        enum class Known {
            LOW,
            MEDIUM,
            HIGH,
            AUTO,
        }

        /**
         * An enum containing [Quality]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Quality] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            LOW,
            MEDIUM,
            HIGH,
            AUTO,
            /** An enum member indicating that [Quality] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                LOW -> Value.LOW
                MEDIUM -> Value.MEDIUM
                HIGH -> Value.HIGH
                AUTO -> Value.AUTO
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws OpenAIInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                LOW -> Known.LOW
                MEDIUM -> Known.MEDIUM
                HIGH -> Known.HIGH
                AUTO -> Known.AUTO
                else -> throw OpenAIInvalidDataException("Unknown Quality: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws OpenAIInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { OpenAIInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

        fun validate(): Quality = apply {
            if (validated) {
                return@apply
            }

            known()
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
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Quality && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** The size of the generated image. */
    class Size @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val _1024X1024 = of("1024x1024")

            @JvmField val _1024X1536 = of("1024x1536")

            @JvmField val _1536X1024 = of("1536x1024")

            @JvmField val AUTO = of("auto")

            @JvmStatic fun of(value: String) = Size(JsonField.of(value))
        }

        /** An enum containing [Size]'s known values. */
        enum class Known {
            _1024X1024,
            _1024X1536,
            _1536X1024,
            AUTO,
        }

        /**
         * An enum containing [Size]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Size] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            _1024X1024,
            _1024X1536,
            _1536X1024,
            AUTO,
            /** An enum member indicating that [Size] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                _1024X1024 -> Value._1024X1024
                _1024X1536 -> Value._1024X1536
                _1536X1024 -> Value._1536X1024
                AUTO -> Value.AUTO
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws OpenAIInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                _1024X1024 -> Known._1024X1024
                _1024X1536 -> Known._1024X1536
                _1536X1024 -> Known._1536X1024
                AUTO -> Known.AUTO
                else -> throw OpenAIInvalidDataException("Unknown Size: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws OpenAIInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { OpenAIInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

        fun validate(): Size = apply {
            if (validated) {
                return@apply
            }

            known()
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
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Size && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** For the GPT image models only, the token usage information for the image generation. */
    class Usage
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val inputTokens: JsonField<Long>,
        private val inputTokensDetails: JsonField<InputTokensDetails>,
        private val outputTokens: JsonField<Long>,
        private val totalTokens: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("input_tokens")
            @ExcludeMissing
            inputTokens: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("input_tokens_details")
            @ExcludeMissing
            inputTokensDetails: JsonField<InputTokensDetails> = JsonMissing.of(),
            @JsonProperty("output_tokens")
            @ExcludeMissing
            outputTokens: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("total_tokens")
            @ExcludeMissing
            totalTokens: JsonField<Long> = JsonMissing.of(),
        ) : this(inputTokens, inputTokensDetails, outputTokens, totalTokens, mutableMapOf())

        /**
         * The number of tokens (images and text) in the input prompt.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun inputTokens(): Long = inputTokens.getRequired("input_tokens")

        /**
         * The input tokens detailed information for the image generation.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun inputTokensDetails(): InputTokensDetails =
            inputTokensDetails.getRequired("input_tokens_details")

        /**
         * The number of image tokens in the output image.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputTokens(): Long = outputTokens.getRequired("output_tokens")

        /**
         * The total number of tokens (images and text) used for the image generation.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun totalTokens(): Long = totalTokens.getRequired("total_tokens")

        /**
         * Returns the raw JSON value of [inputTokens].
         *
         * Unlike [inputTokens], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("input_tokens")
        @ExcludeMissing
        fun _inputTokens(): JsonField<Long> = inputTokens

        /**
         * Returns the raw JSON value of [inputTokensDetails].
         *
         * Unlike [inputTokensDetails], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("input_tokens_details")
        @ExcludeMissing
        fun _inputTokensDetails(): JsonField<InputTokensDetails> = inputTokensDetails

        /**
         * Returns the raw JSON value of [outputTokens].
         *
         * Unlike [outputTokens], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("output_tokens")
        @ExcludeMissing
        fun _outputTokens(): JsonField<Long> = outputTokens

        /**
         * Returns the raw JSON value of [totalTokens].
         *
         * Unlike [totalTokens], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("total_tokens")
        @ExcludeMissing
        fun _totalTokens(): JsonField<Long> = totalTokens

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
             * Returns a mutable builder for constructing an instance of [Usage].
             *
             * The following fields are required:
             * ```java
             * .inputTokens()
             * .inputTokensDetails()
             * .outputTokens()
             * .totalTokens()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Usage]. */
        class Builder internal constructor() {

            private var inputTokens: JsonField<Long>? = null
            private var inputTokensDetails: JsonField<InputTokensDetails>? = null
            private var outputTokens: JsonField<Long>? = null
            private var totalTokens: JsonField<Long>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(usage: Usage) = apply {
                inputTokens = usage.inputTokens
                inputTokensDetails = usage.inputTokensDetails
                outputTokens = usage.outputTokens
                totalTokens = usage.totalTokens
                additionalProperties = usage.additionalProperties.toMutableMap()
            }

            /** The number of tokens (images and text) in the input prompt. */
            fun inputTokens(inputTokens: Long) = inputTokens(JsonField.of(inputTokens))

            /**
             * Sets [Builder.inputTokens] to an arbitrary JSON value.
             *
             * You should usually call [Builder.inputTokens] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun inputTokens(inputTokens: JsonField<Long>) = apply { this.inputTokens = inputTokens }

            /** The input tokens detailed information for the image generation. */
            fun inputTokensDetails(inputTokensDetails: InputTokensDetails) =
                inputTokensDetails(JsonField.of(inputTokensDetails))

            /**
             * Sets [Builder.inputTokensDetails] to an arbitrary JSON value.
             *
             * You should usually call [Builder.inputTokensDetails] with a well-typed
             * [InputTokensDetails] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun inputTokensDetails(inputTokensDetails: JsonField<InputTokensDetails>) = apply {
                this.inputTokensDetails = inputTokensDetails
            }

            /** The number of image tokens in the output image. */
            fun outputTokens(outputTokens: Long) = outputTokens(JsonField.of(outputTokens))

            /**
             * Sets [Builder.outputTokens] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputTokens] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputTokens(outputTokens: JsonField<Long>) = apply {
                this.outputTokens = outputTokens
            }

            /** The total number of tokens (images and text) used for the image generation. */
            fun totalTokens(totalTokens: Long) = totalTokens(JsonField.of(totalTokens))

            /**
             * Sets [Builder.totalTokens] to an arbitrary JSON value.
             *
             * You should usually call [Builder.totalTokens] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun totalTokens(totalTokens: JsonField<Long>) = apply { this.totalTokens = totalTokens }

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
             * Returns an immutable instance of [Usage].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .inputTokens()
             * .inputTokensDetails()
             * .outputTokens()
             * .totalTokens()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Usage =
                Usage(
                    checkRequired("inputTokens", inputTokens),
                    checkRequired("inputTokensDetails", inputTokensDetails),
                    checkRequired("outputTokens", outputTokens),
                    checkRequired("totalTokens", totalTokens),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Usage = apply {
            if (validated) {
                return@apply
            }

            inputTokens()
            inputTokensDetails().validate()
            outputTokens()
            totalTokens()
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
            (if (inputTokens.asKnown().isPresent) 1 else 0) +
                (inputTokensDetails.asKnown().getOrNull()?.validity() ?: 0) +
                (if (outputTokens.asKnown().isPresent) 1 else 0) +
                (if (totalTokens.asKnown().isPresent) 1 else 0)

        /** The input tokens detailed information for the image generation. */
        class InputTokensDetails
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val imageTokens: JsonField<Long>,
            private val textTokens: JsonField<Long>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("image_tokens")
                @ExcludeMissing
                imageTokens: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("text_tokens")
                @ExcludeMissing
                textTokens: JsonField<Long> = JsonMissing.of(),
            ) : this(imageTokens, textTokens, mutableMapOf())

            /**
             * The number of image tokens in the input prompt.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun imageTokens(): Long = imageTokens.getRequired("image_tokens")

            /**
             * The number of text tokens in the input prompt.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun textTokens(): Long = textTokens.getRequired("text_tokens")

            /**
             * Returns the raw JSON value of [imageTokens].
             *
             * Unlike [imageTokens], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("image_tokens")
            @ExcludeMissing
            fun _imageTokens(): JsonField<Long> = imageTokens

            /**
             * Returns the raw JSON value of [textTokens].
             *
             * Unlike [textTokens], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("text_tokens")
            @ExcludeMissing
            fun _textTokens(): JsonField<Long> = textTokens

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
                 * Returns a mutable builder for constructing an instance of [InputTokensDetails].
                 *
                 * The following fields are required:
                 * ```java
                 * .imageTokens()
                 * .textTokens()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [InputTokensDetails]. */
            class Builder internal constructor() {

                private var imageTokens: JsonField<Long>? = null
                private var textTokens: JsonField<Long>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(inputTokensDetails: InputTokensDetails) = apply {
                    imageTokens = inputTokensDetails.imageTokens
                    textTokens = inputTokensDetails.textTokens
                    additionalProperties = inputTokensDetails.additionalProperties.toMutableMap()
                }

                /** The number of image tokens in the input prompt. */
                fun imageTokens(imageTokens: Long) = imageTokens(JsonField.of(imageTokens))

                /**
                 * Sets [Builder.imageTokens] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.imageTokens] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun imageTokens(imageTokens: JsonField<Long>) = apply {
                    this.imageTokens = imageTokens
                }

                /** The number of text tokens in the input prompt. */
                fun textTokens(textTokens: Long) = textTokens(JsonField.of(textTokens))

                /**
                 * Sets [Builder.textTokens] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.textTokens] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun textTokens(textTokens: JsonField<Long>) = apply { this.textTokens = textTokens }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [InputTokensDetails].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .imageTokens()
                 * .textTokens()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): InputTokensDetails =
                    InputTokensDetails(
                        checkRequired("imageTokens", imageTokens),
                        checkRequired("textTokens", textTokens),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): InputTokensDetails = apply {
                if (validated) {
                    return@apply
                }

                imageTokens()
                textTokens()
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
                (if (imageTokens.asKnown().isPresent) 1 else 0) +
                    (if (textTokens.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is InputTokensDetails &&
                    imageTokens == other.imageTokens &&
                    textTokens == other.textTokens &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(imageTokens, textTokens, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "InputTokensDetails{imageTokens=$imageTokens, textTokens=$textTokens, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Usage &&
                inputTokens == other.inputTokens &&
                inputTokensDetails == other.inputTokensDetails &&
                outputTokens == other.outputTokens &&
                totalTokens == other.totalTokens &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                inputTokens,
                inputTokensDetails,
                outputTokens,
                totalTokens,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Usage{inputTokens=$inputTokens, inputTokensDetails=$inputTokensDetails, outputTokens=$outputTokens, totalTokens=$totalTokens, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ImageGenCompletedEvent &&
            b64Json == other.b64Json &&
            background == other.background &&
            createdAt == other.createdAt &&
            outputFormat == other.outputFormat &&
            quality == other.quality &&
            size == other.size &&
            type == other.type &&
            usage == other.usage &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            b64Json,
            background,
            createdAt,
            outputFormat,
            quality,
            size,
            type,
            usage,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ImageGenCompletedEvent{b64Json=$b64Json, background=$background, createdAt=$createdAt, outputFormat=$outputFormat, quality=$quality, size=$size, type=$type, usage=$usage, additionalProperties=$additionalProperties}"
}
