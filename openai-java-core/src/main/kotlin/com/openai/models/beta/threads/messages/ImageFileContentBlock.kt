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
import com.openai.core.checkRequired
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/**
 * References an image [File](https://platform.openai.com/docs/api-reference/files) in the content
 * of a message.
 */
class ImageFileContentBlock
private constructor(
    private val imageFile: JsonField<ImageFile>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("image_file")
        @ExcludeMissing
        imageFile: JsonField<ImageFile> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(imageFile, type, mutableMapOf())

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun imageFile(): ImageFile = imageFile.getRequired("image_file")

    /**
     * Always `image_file`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("image_file")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [imageFile].
     *
     * Unlike [imageFile], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("image_file") @ExcludeMissing fun _imageFile(): JsonField<ImageFile> = imageFile

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

        /**
         * Sets [Builder.imageFile] to an arbitrary JSON value.
         *
         * You should usually call [Builder.imageFile] with a well-typed [ImageFile] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun imageFile(imageFile: JsonField<ImageFile>) = apply { this.imageFile = imageFile }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("image_file")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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
         * Returns an immutable instance of [ImageFileContentBlock].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .imageFile()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ImageFileContentBlock =
            ImageFileContentBlock(
                checkRequired("imageFile", imageFile),
                type,
                additionalProperties.toMutableMap(),
            )
    }

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
        (imageFile.asKnown().getOrNull()?.validity() ?: 0) +
            type.let { if (it == JsonValue.from("image_file")) 1 else 0 }

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
