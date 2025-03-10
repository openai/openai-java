// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
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

/**
 * References an image [File](https://platform.openai.com/docs/api-reference/files) in the content
 * of a message.
 */
@NoAutoDetect
class ImageFileContentBlock
@JsonCreator
private constructor(
    @JsonProperty("image_file")
    @ExcludeMissing
    private val imageFile: JsonField<ImageFile> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    fun imageFile(): ImageFile = imageFile.getRequired("image_file")

    /** Always `image_file`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    @JsonProperty("image_file") @ExcludeMissing fun _imageFile(): JsonField<ImageFile> = imageFile

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ImageFileContentBlock = apply {
        if (validated) {
            return@apply
        }

        imageFile().validate()
        _type().let {
            if (it != JsonValue.from("image_file")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ImageFileContentBlock].
         *
         * The following fields are required:
         * ```java
         * .imageFile()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ImageFileContentBlock]. */
    class Builder internal constructor() {

        private var imageFile: JsonField<ImageFile>? = null
        private var type: JsonValue = JsonValue.from("image_file")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(imageFileContentBlock: ImageFileContentBlock) = apply {
            imageFile = imageFileContentBlock.imageFile
            type = imageFileContentBlock.type
            additionalProperties = imageFileContentBlock.additionalProperties.toMutableMap()
        }

        fun imageFile(imageFile: ImageFile) = imageFile(JsonField.of(imageFile))

        fun imageFile(imageFile: JsonField<ImageFile>) = apply { this.imageFile = imageFile }

        /** Always `image_file`. */
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

        fun build(): ImageFileContentBlock =
            ImageFileContentBlock(
                checkRequired("imageFile", imageFile),
                type,
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ImageFileContentBlock && imageFile == other.imageFile && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(imageFile, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ImageFileContentBlock{imageFile=$imageFile, type=$type, additionalProperties=$additionalProperties}"
}
