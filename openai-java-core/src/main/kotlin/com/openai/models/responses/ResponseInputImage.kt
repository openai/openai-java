// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.checkRequired
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * An image input to the model. Learn about
 * [image inputs](https://platform.openai.com/docs/guides/vision).
 */
@NoAutoDetect
class ResponseInputImage
@JsonCreator
private constructor(
    @JsonProperty("detail")
    @ExcludeMissing
    private val detail: JsonField<Detail> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonProperty("file_id")
    @ExcludeMissing
    private val fileId: JsonField<String> = JsonMissing.of(),
    @JsonProperty("image_url")
    @ExcludeMissing
    private val imageUrl: JsonField<String> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * The detail level of the image to be sent to the model. One of `high`, `low`, or `auto`.
     * Defaults to `auto`.
     */
    fun detail(): Detail = detail.getRequired("detail")

    /** The type of the input item. Always `input_image`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /** The ID of the file to be sent to the model. */
    fun fileId(): Optional<String> = Optional.ofNullable(fileId.getNullable("file_id"))

    /**
     * The URL of the image to be sent to the model. A fully qualified URL or base64 encoded image
     * in a data URL.
     */
    fun imageUrl(): Optional<String> = Optional.ofNullable(imageUrl.getNullable("image_url"))

    /**
     * The detail level of the image to be sent to the model. One of `high`, `low`, or `auto`.
     * Defaults to `auto`.
     */
    @JsonProperty("detail") @ExcludeMissing fun _detail(): JsonField<Detail> = detail

    /** The ID of the file to be sent to the model. */
    @JsonProperty("file_id") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

    /**
     * The URL of the image to be sent to the model. A fully qualified URL or base64 encoded image
     * in a data URL.
     */
    @JsonProperty("image_url") @ExcludeMissing fun _imageUrl(): JsonField<String> = imageUrl

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ResponseInputImage = apply {
        if (validated) {
            return@apply
        }

        detail()
        _type().let {
            if (it != JsonValue.from("input_image")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        fileId()
        imageUrl()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ResponseInputImage].
         *
         * The following fields are required:
         * ```java
         * .detail()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseInputImage]. */
    class Builder internal constructor() {

        private var detail: JsonField<Detail>? = null
        private var type: JsonValue = JsonValue.from("input_image")
        private var fileId: JsonField<String> = JsonMissing.of()
        private var imageUrl: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseInputImage: ResponseInputImage) = apply {
            detail = responseInputImage.detail
            type = responseInputImage.type
            fileId = responseInputImage.fileId
            imageUrl = responseInputImage.imageUrl
            additionalProperties = responseInputImage.additionalProperties.toMutableMap()
        }

        /**
         * The detail level of the image to be sent to the model. One of `high`, `low`, or `auto`.
         * Defaults to `auto`.
         */
        fun detail(detail: Detail) = detail(JsonField.of(detail))

        /**
         * The detail level of the image to be sent to the model. One of `high`, `low`, or `auto`.
         * Defaults to `auto`.
         */
        fun detail(detail: JsonField<Detail>) = apply { this.detail = detail }

        /** The type of the input item. Always `input_image`. */
        fun type(type: JsonValue) = apply { this.type = type }

        /** The ID of the file to be sent to the model. */
        fun fileId(fileId: String?) = fileId(JsonField.ofNullable(fileId))

        /** The ID of the file to be sent to the model. */
        fun fileId(fileId: Optional<String>) = fileId(fileId.getOrNull())

        /** The ID of the file to be sent to the model. */
        fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

        /**
         * The URL of the image to be sent to the model. A fully qualified URL or base64 encoded
         * image in a data URL.
         */
        fun imageUrl(imageUrl: String?) = imageUrl(JsonField.ofNullable(imageUrl))

        /**
         * The URL of the image to be sent to the model. A fully qualified URL or base64 encoded
         * image in a data URL.
         */
        fun imageUrl(imageUrl: Optional<String>) = imageUrl(imageUrl.getOrNull())

        /**
         * The URL of the image to be sent to the model. A fully qualified URL or base64 encoded
         * image in a data URL.
         */
        fun imageUrl(imageUrl: JsonField<String>) = apply { this.imageUrl = imageUrl }

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

        fun build(): ResponseInputImage =
            ResponseInputImage(
                checkRequired("detail", detail),
                type,
                fileId,
                imageUrl,
                additionalProperties.toImmutable(),
            )
    }

    /**
     * The detail level of the image to be sent to the model. One of `high`, `low`, or `auto`.
     * Defaults to `auto`.
     */
    class Detail @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val HIGH = of("high")

            @JvmField val LOW = of("low")

            @JvmField val AUTO = of("auto")

            @JvmStatic fun of(value: String) = Detail(JsonField.of(value))
        }

        /** An enum containing [Detail]'s known values. */
        enum class Known {
            HIGH,
            LOW,
            AUTO,
        }

        /**
         * An enum containing [Detail]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Detail] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            HIGH,
            LOW,
            AUTO,
            /** An enum member indicating that [Detail] was instantiated with an unknown value. */
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
                HIGH -> Value.HIGH
                LOW -> Value.LOW
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
                HIGH -> Known.HIGH
                LOW -> Known.LOW
                AUTO -> Known.AUTO
                else -> throw OpenAIInvalidDataException("Unknown Detail: $value")
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Detail && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ResponseInputImage && detail == other.detail && type == other.type && fileId == other.fileId && imageUrl == other.imageUrl && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(detail, type, fileId, imageUrl, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseInputImage{detail=$detail, type=$type, fileId=$fileId, imageUrl=$imageUrl, additionalProperties=$additionalProperties}"
}
