// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.collectAllProperties
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional

/** A computer screenshot image used with the computer use tool. */
class BetaResponseComputerToolCallOutputScreenshot
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val type: JsonValue,
    private val fileId: JsonField<String>,
    private val imageUrl: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("file_id") @ExcludeMissing fileId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("image_url") @ExcludeMissing imageUrl: JsonField<String> = JsonMissing.of(),
    ) : this(type, fileId, imageUrl, mutableMapOf())

    /**
     * Specifies the event type. For a computer screenshot, this property is always set to
     * `computer_screenshot`. The schema requires this property. Returns empty if the JSON property
     * is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun type(): java.util.Optional<JsonValue> {
        val raw = type
        return when {
            raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
            !(raw == JsonValue.from("computer_screenshot")) ->
                throw OpenAIInvalidDataException("`type` is invalid")
            else -> java.util.Optional.of(raw)
        }
    }

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

    /**
     * The identifier of an uploaded file that contains the screenshot. Returns empty if the JSON
     * property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun fileId(): java.util.Optional<String> = fileId.getOptional("file_id")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun fileIdOrThrow(): String = fileId.getRequired("file_id")

    /**
     * The URL of the screenshot image. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun imageUrl(): java.util.Optional<String> = imageUrl.getOptional("image_url")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun imageUrlOrThrow(): String = imageUrl.getRequired("image_url")

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

    /**
     * Returns an immutable snapshot of all present JSON properties, including declared and
     * additional properties.
     *
     * Keys use their JSON names. Declared properties take precedence over additional properties
     * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
     * values are preserved.
     */
    fun _allProperties(): Map<String, JsonValue> =
        collectAllProperties(
            additionalProperties,
            "type" to this.type,
            "file_id" to this.fileId,
            "image_url" to this.imageUrl,
        )

    @JvmSynthetic
    internal fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    @JsonAnyGetter
    @ExcludeMissing
    private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [BetaResponseComputerToolCallOutputScreenshot].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BetaResponseComputerToolCallOutputScreenshot]. */
    class Builder internal constructor() {

        private var type: JsonValue = JsonValue.from("computer_screenshot")
        private var fileId: JsonField<String> = JsonMissing.of()
        private var imageUrl: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            betaResponseComputerToolCallOutputScreenshot:
                BetaResponseComputerToolCallOutputScreenshot
        ) = apply {
            type = betaResponseComputerToolCallOutputScreenshot.type
            fileId = betaResponseComputerToolCallOutputScreenshot.fileId
            imageUrl = betaResponseComputerToolCallOutputScreenshot.imageUrl
            additionalProperties =
                betaResponseComputerToolCallOutputScreenshot.additionalProperties.toMutableMap()
        }

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

        /** The identifier of an uploaded file that contains the screenshot. */
        fun fileId(fileId: String) = fileId(JsonField.of(fileId))

        /**
         * Sets [Builder.fileId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fileId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

        /** The URL of the screenshot image. */
        fun imageUrl(imageUrl: String) = imageUrl(JsonField.of(imageUrl))

        /**
         * Sets [Builder.imageUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.imageUrl] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
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

        /**
         * Returns an immutable instance of [BetaResponseComputerToolCallOutputScreenshot].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): BetaResponseComputerToolCallOutputScreenshot =
            BetaResponseComputerToolCallOutputScreenshot(
                type,
                fileId,
                imageUrl,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): BetaResponseComputerToolCallOutputScreenshot = apply {
        if (validated) {
            return@apply
        }

        typeOrThrow()
        fileId()
        imageUrl()
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
        type.let { if (it == JsonValue.from("computer_screenshot")) 1 else 0 } +
            (if (fileId.asKnown().isPresent) 1 else 0) +
            (if (imageUrl.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BetaResponseComputerToolCallOutputScreenshot &&
            type == other.type &&
            fileId == other.fileId &&
            imageUrl == other.imageUrl &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(type, fileId, imageUrl, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BetaResponseComputerToolCallOutputScreenshot{type=$type, fileId=$fileId, imageUrl=$imageUrl, additionalProperties=$additionalProperties}"
}
