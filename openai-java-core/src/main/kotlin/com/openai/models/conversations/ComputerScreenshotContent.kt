// File generated from our OpenAPI spec by Stainless.

package com.openai.models.conversations

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

/** A screenshot of a computer. */
class ComputerScreenshotContent
private constructor(
    private val fileId: JsonField<String>,
    private val imageUrl: JsonField<String>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("file_id") @ExcludeMissing fileId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("image_url") @ExcludeMissing imageUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(fileId, imageUrl, type, mutableMapOf())

    /**
     * The identifier of an uploaded file that contains the screenshot.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun fileId(): Optional<String> = fileId.getOptional("file_id")

    /**
     * The URL of the screenshot image.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun imageUrl(): Optional<String> = imageUrl.getOptional("image_url")

    /**
     * Specifies the event type. For a computer screenshot, this property is always set to
     * `computer_screenshot`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("computer_screenshot")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [fileId].
     *
     * Unlike [fileId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("file_id") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

    /**
     * Returns the raw JSON value of [imageUrl].
     *
     * Unlike [imageUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("image_url") @ExcludeMissing fun _imageUrl(): JsonField<String> = imageUrl

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
         * Returns a mutable builder for constructing an instance of [ComputerScreenshotContent].
         *
         * The following fields are required:
         * ```java
         * .fileId()
         * .imageUrl()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ComputerScreenshotContent]. */
    class Builder internal constructor() {

        private var fileId: JsonField<String>? = null
        private var imageUrl: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("computer_screenshot")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(computerScreenshotContent: ComputerScreenshotContent) = apply {
            fileId = computerScreenshotContent.fileId
            imageUrl = computerScreenshotContent.imageUrl
            type = computerScreenshotContent.type
            additionalProperties = computerScreenshotContent.additionalProperties.toMutableMap()
        }

        /** The identifier of an uploaded file that contains the screenshot. */
        fun fileId(fileId: String?) = fileId(JsonField.ofNullable(fileId))

        /** Alias for calling [Builder.fileId] with `fileId.orElse(null)`. */
        fun fileId(fileId: Optional<String>) = fileId(fileId.getOrNull())

        /**
         * Sets [Builder.fileId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fileId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

        /** The URL of the screenshot image. */
        fun imageUrl(imageUrl: String?) = imageUrl(JsonField.ofNullable(imageUrl))

        /** Alias for calling [Builder.imageUrl] with `imageUrl.orElse(null)`. */
        fun imageUrl(imageUrl: Optional<String>) = imageUrl(imageUrl.getOrNull())

        /**
         * Sets [Builder.imageUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.imageUrl] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun imageUrl(imageUrl: JsonField<String>) = apply { this.imageUrl = imageUrl }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("computer_screenshot")
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
         * Returns an immutable instance of [ComputerScreenshotContent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .fileId()
         * .imageUrl()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ComputerScreenshotContent =
            ComputerScreenshotContent(
                checkRequired("fileId", fileId),
                checkRequired("imageUrl", imageUrl),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ComputerScreenshotContent = apply {
        if (validated) {
            return@apply
        }

        fileId()
        imageUrl()
        _type().let {
            if (it != JsonValue.from("computer_screenshot")) {
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
        (if (fileId.asKnown().isPresent) 1 else 0) +
            (if (imageUrl.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("computer_screenshot")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ComputerScreenshotContent &&
            fileId == other.fileId &&
            imageUrl == other.imageUrl &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(fileId, imageUrl, type, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ComputerScreenshotContent{fileId=$fileId, imageUrl=$imageUrl, type=$type, additionalProperties=$additionalProperties}"
}
