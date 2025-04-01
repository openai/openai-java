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
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * References an image [File](https://platform.openai.com/docs/api-reference/files) in the content
 * of a message.
 */
class ImageFileDeltaBlock
private constructor(
    private val index: JsonField<Long>,
    private val type: JsonValue,
    private val imageFile: JsonField<ImageFileDelta>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("index") @ExcludeMissing index: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("image_file")
        @ExcludeMissing
        imageFile: JsonField<ImageFileDelta> = JsonMissing.of(),
    ) : this(index, type, imageFile, mutableMapOf())

    /**
     * The index of the content part in the message.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun index(): Long = index.getRequired("index")

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
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun imageFile(): Optional<ImageFileDelta> =
        Optional.ofNullable(imageFile.getNullable("image_file"))

    /**
     * Returns the raw JSON value of [index].
     *
     * Unlike [index], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("index") @ExcludeMissing fun _index(): JsonField<Long> = index

    /**
     * Returns the raw JSON value of [imageFile].
     *
     * Unlike [imageFile], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("image_file")
    @ExcludeMissing
    fun _imageFile(): JsonField<ImageFileDelta> = imageFile

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
         * Returns a mutable builder for constructing an instance of [ImageFileDeltaBlock].
         *
         * The following fields are required:
         * ```java
         * .index()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ImageFileDeltaBlock]. */
    class Builder internal constructor() {

        private var index: JsonField<Long>? = null
        private var type: JsonValue = JsonValue.from("image_file")
        private var imageFile: JsonField<ImageFileDelta> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(imageFileDeltaBlock: ImageFileDeltaBlock) = apply {
            index = imageFileDeltaBlock.index
            type = imageFileDeltaBlock.type
            imageFile = imageFileDeltaBlock.imageFile
            additionalProperties = imageFileDeltaBlock.additionalProperties.toMutableMap()
        }

        /** The index of the content part in the message. */
        fun index(index: Long) = index(JsonField.of(index))

        /**
         * Sets [Builder.index] to an arbitrary JSON value.
         *
         * You should usually call [Builder.index] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun index(index: JsonField<Long>) = apply { this.index = index }

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

        fun imageFile(imageFile: ImageFileDelta) = imageFile(JsonField.of(imageFile))

        /**
         * Sets [Builder.imageFile] to an arbitrary JSON value.
         *
         * You should usually call [Builder.imageFile] with a well-typed [ImageFileDelta] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun imageFile(imageFile: JsonField<ImageFileDelta>) = apply { this.imageFile = imageFile }

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
         * Returns an immutable instance of [ImageFileDeltaBlock].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .index()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ImageFileDeltaBlock =
            ImageFileDeltaBlock(
                checkRequired("index", index),
                type,
                imageFile,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ImageFileDeltaBlock = apply {
        if (validated) {
            return@apply
        }

        index()
        _type().let {
            if (it != JsonValue.from("image_file")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        imageFile().ifPresent { it.validate() }
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
        (if (index.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("image_file")) 1 else 0 } +
            (imageFile.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ImageFileDeltaBlock && index == other.index && type == other.type && imageFile == other.imageFile && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(index, type, imageFile, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ImageFileDeltaBlock{index=$index, type=$type, imageFile=$imageFile, additionalProperties=$additionalProperties}"
}
