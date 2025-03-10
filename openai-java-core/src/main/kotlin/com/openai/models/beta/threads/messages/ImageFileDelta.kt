// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

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
class ImageFileDelta
@JsonCreator
private constructor(
    @JsonProperty("detail")
    @ExcludeMissing
    private val detail: JsonField<Detail> = JsonMissing.of(),
    @JsonProperty("file_id")
    @ExcludeMissing
    private val fileId: JsonField<String> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * Specifies the detail level of the image if specified by the user. `low` uses fewer tokens,
     * you can opt in to high resolution using `high`.
     */
    fun detail(): Optional<Detail> = Optional.ofNullable(detail.getNullable("detail"))

    /**
     * The [File](https://platform.openai.com/docs/api-reference/files) ID of the image in the
     * message content. Set `purpose="vision"` when uploading the File if you need to later display
     * the file content.
     */
    fun fileId(): Optional<String> = Optional.ofNullable(fileId.getNullable("file_id"))

    /**
     * Specifies the detail level of the image if specified by the user. `low` uses fewer tokens,
     * you can opt in to high resolution using `high`.
     */
    @JsonProperty("detail") @ExcludeMissing fun _detail(): JsonField<Detail> = detail

    /**
     * The [File](https://platform.openai.com/docs/api-reference/files) ID of the image in the
     * message content. Set `purpose="vision"` when uploading the File if you need to later display
     * the file content.
     */
    @JsonProperty("file_id") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ImageFileDelta = apply {
        if (validated) {
            return@apply
        }

        detail()
        fileId()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /** Returns a mutable builder for constructing an instance of [ImageFileDelta]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ImageFileDelta]. */
    class Builder internal constructor() {

        private var detail: JsonField<Detail> = JsonMissing.of()
        private var fileId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(imageFileDelta: ImageFileDelta) = apply {
            detail = imageFileDelta.detail
            fileId = imageFileDelta.fileId
            additionalProperties = imageFileDelta.additionalProperties.toMutableMap()
        }

        /**
         * Specifies the detail level of the image if specified by the user. `low` uses fewer
         * tokens, you can opt in to high resolution using `high`.
         */
        fun detail(detail: Detail) = detail(JsonField.of(detail))

        /**
         * Specifies the detail level of the image if specified by the user. `low` uses fewer
         * tokens, you can opt in to high resolution using `high`.
         */
        fun detail(detail: JsonField<Detail>) = apply { this.detail = detail }

        /**
         * The [File](https://platform.openai.com/docs/api-reference/files) ID of the image in the
         * message content. Set `purpose="vision"` when uploading the File if you need to later
         * display the file content.
         */
        fun fileId(fileId: String) = fileId(JsonField.of(fileId))

        /**
         * The [File](https://platform.openai.com/docs/api-reference/files) ID of the image in the
         * message content. Set `purpose="vision"` when uploading the File if you need to later
         * display the file content.
         */
        fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

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

        fun build(): ImageFileDelta =
            ImageFileDelta(detail, fileId, additionalProperties.toImmutable())
    }

    /**
     * Specifies the detail level of the image if specified by the user. `low` uses fewer tokens,
     * you can opt in to high resolution using `high`.
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

            @JvmField val AUTO = of("auto")

            @JvmField val LOW = of("low")

            @JvmField val HIGH = of("high")

            @JvmStatic fun of(value: String) = Detail(JsonField.of(value))
        }

        /** An enum containing [Detail]'s known values. */
        enum class Known {
            AUTO,
            LOW,
            HIGH,
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
            AUTO,
            LOW,
            HIGH,
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
                AUTO -> Value.AUTO
                LOW -> Value.LOW
                HIGH -> Value.HIGH
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
                AUTO -> Known.AUTO
                LOW -> Known.LOW
                HIGH -> Known.HIGH
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

        return /* spotless:off */ other is ImageFileDelta && detail == other.detail && fileId == other.fileId && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(detail, fileId, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ImageFileDelta{detail=$detail, fileId=$fileId, additionalProperties=$additionalProperties}"
}
