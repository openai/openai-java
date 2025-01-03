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
class ImageFileDelta
@JsonCreator
private constructor(
    @JsonProperty("file_id")
    @ExcludeMissing
    private val fileId: JsonField<String> = JsonMissing.of(),
    @JsonProperty("detail")
    @ExcludeMissing
    private val detail: JsonField<Detail> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

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
    fun detail(): Optional<Detail> = Optional.ofNullable(detail.getNullable("detail"))

    /**
     * The [File](https://platform.openai.com/docs/api-reference/files) ID of the image in the
     * message content. Set `purpose="vision"` when uploading the File if you need to later display
     * the file content.
     */
    @JsonProperty("file_id") @ExcludeMissing fun _fileId() = fileId

    /**
     * Specifies the detail level of the image if specified by the user. `low` uses fewer tokens,
     * you can opt in to high resolution using `high`.
     */
    @JsonProperty("detail") @ExcludeMissing fun _detail() = detail

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ImageFileDelta = apply {
        if (!validated) {
            fileId()
            detail()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var fileId: JsonField<String> = JsonMissing.of()
        private var detail: JsonField<Detail> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(imageFileDelta: ImageFileDelta) = apply {
            fileId = imageFileDelta.fileId
            detail = imageFileDelta.detail
            additionalProperties = imageFileDelta.additionalProperties.toMutableMap()
        }

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
            ImageFileDelta(
                fileId,
                detail,
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

        return /* spotless:off */ other is ImageFileDelta && fileId == other.fileId && detail == other.detail && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(fileId, detail, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ImageFileDelta{fileId=$fileId, detail=$detail, additionalProperties=$additionalProperties}"
}