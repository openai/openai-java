// File generated from our OpenAPI spec by Stainless.

package com.openai.models

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
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

@NoAutoDetect
class ImageUrlDelta
@JsonCreator
private constructor(
    @JsonProperty("detail")
    @ExcludeMissing
    private val detail: JsonField<Detail> = JsonMissing.of(),
    @JsonProperty("url") @ExcludeMissing private val url: JsonField<String> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * Specifies the detail level of the image. `low` uses fewer tokens, you can opt in to high
     * resolution using `high`.
     */
    fun detail(): Optional<Detail> = Optional.ofNullable(detail.getNullable("detail"))

    /** The URL of the image, must be a supported image types: jpeg, jpg, png, gif, webp. */
    fun url(): Optional<String> = Optional.ofNullable(url.getNullable("url"))

    /**
     * Specifies the detail level of the image. `low` uses fewer tokens, you can opt in to high
     * resolution using `high`.
     */
    @JsonProperty("detail") @ExcludeMissing fun _detail(): JsonField<Detail> = detail

    /** The URL of the image, must be a supported image types: jpeg, jpg, png, gif, webp. */
    @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ImageUrlDelta = apply {
        if (validated) {
            return@apply
        }

        detail()
        url()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var detail: JsonField<Detail> = JsonMissing.of()
        private var url: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(imageUrlDelta: ImageUrlDelta) = apply {
            detail = imageUrlDelta.detail
            url = imageUrlDelta.url
            additionalProperties = imageUrlDelta.additionalProperties.toMutableMap()
        }

        /**
         * Specifies the detail level of the image. `low` uses fewer tokens, you can opt in to high
         * resolution using `high`.
         */
        fun detail(detail: Detail) = detail(JsonField.of(detail))

        /**
         * Specifies the detail level of the image. `low` uses fewer tokens, you can opt in to high
         * resolution using `high`.
         */
        fun detail(detail: JsonField<Detail>) = apply { this.detail = detail }

        /** The URL of the image, must be a supported image types: jpeg, jpg, png, gif, webp. */
        fun url(url: String) = url(JsonField.of(url))

        /** The URL of the image, must be a supported image types: jpeg, jpg, png, gif, webp. */
        fun url(url: JsonField<String>) = apply { this.url = url }

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

        fun build(): ImageUrlDelta =
            ImageUrlDelta(
                detail,
                url,
                additionalProperties.toImmutable(),
            )
    }

    class Detail
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val AUTO = of("auto")

            @JvmField val LOW = of("low")

            @JvmField val HIGH = of("high")

            @JvmStatic fun of(value: String) = Detail(JsonField.of(value))
        }

        enum class Known {
            AUTO,
            LOW,
            HIGH,
        }

        enum class Value {
            AUTO,
            LOW,
            HIGH,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                AUTO -> Value.AUTO
                LOW -> Value.LOW
                HIGH -> Value.HIGH
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                AUTO -> Known.AUTO
                LOW -> Known.LOW
                HIGH -> Known.HIGH
                else -> throw OpenAIInvalidDataException("Unknown Detail: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

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

        return /* spotless:off */ other is ImageUrlDelta && detail == other.detail && url == other.url && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(detail, url, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ImageUrlDelta{detail=$detail, url=$url, additionalProperties=$additionalProperties}"
}
