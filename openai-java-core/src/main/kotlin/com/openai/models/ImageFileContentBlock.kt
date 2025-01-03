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

/**
 * References an image [File](https://platform.openai.com/docs/api-reference/files) in the content
 * of a message.
 */
@NoAutoDetect
class ImageFileContentBlock
@JsonCreator
private constructor(
    @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
    @JsonProperty("image_file")
    @ExcludeMissing
    private val imageFile: JsonField<ImageFile> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** Always `image_file`. */
    fun type(): Type = type.getRequired("type")

    fun imageFile(): ImageFile = imageFile.getRequired("image_file")

    /** Always `image_file`. */
    @JsonProperty("type") @ExcludeMissing fun _type() = type

    @JsonProperty("image_file") @ExcludeMissing fun _imageFile() = imageFile

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ImageFileContentBlock = apply {
        if (!validated) {
            type()
            imageFile().validate()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var type: JsonField<Type> = JsonMissing.of()
        private var imageFile: JsonField<ImageFile> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(imageFileContentBlock: ImageFileContentBlock) = apply {
            type = imageFileContentBlock.type
            imageFile = imageFileContentBlock.imageFile
            additionalProperties = imageFileContentBlock.additionalProperties.toMutableMap()
        }

        /** Always `image_file`. */
        fun type(type: Type) = type(JsonField.of(type))

        /** Always `image_file`. */
        fun type(type: JsonField<Type>) = apply { this.type = type }

        fun imageFile(imageFile: ImageFile) = imageFile(JsonField.of(imageFile))

        fun imageFile(imageFile: JsonField<ImageFile>) = apply { this.imageFile = imageFile }

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

        fun build(): ImageFileContentBlock =
            ImageFileContentBlock(
                type,
                imageFile,
                additionalProperties.toImmutable(),
            )
    }

    class Type
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val IMAGE_FILE = of("image_file")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        enum class Known {
            IMAGE_FILE,
        }

        enum class Value {
            IMAGE_FILE,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                IMAGE_FILE -> Value.IMAGE_FILE
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                IMAGE_FILE -> Known.IMAGE_FILE
                else -> throw OpenAIInvalidDataException("Unknown Type: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Type && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ImageFileContentBlock && type == other.type && imageFile == other.imageFile && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(type, imageFile, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ImageFileContentBlock{type=$type, imageFile=$imageFile, additionalProperties=$additionalProperties}"
}
