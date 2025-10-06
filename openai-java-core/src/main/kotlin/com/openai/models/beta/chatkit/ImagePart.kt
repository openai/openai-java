// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.chatkit

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

/** Metadata for an image uploaded through ChatKit. */
class ImagePart
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val mimeType: JsonField<String>,
    private val name: JsonField<String>,
    private val previewUrl: JsonField<String>,
    private val type: JsonValue,
    private val uploadUrl: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("mime_type") @ExcludeMissing mimeType: JsonField<String> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("preview_url")
        @ExcludeMissing
        previewUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("upload_url") @ExcludeMissing uploadUrl: JsonField<String> = JsonMissing.of(),
    ) : this(id, mimeType, name, previewUrl, type, uploadUrl, mutableMapOf())

    /**
     * Unique identifier for the uploaded image.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * MIME type of the uploaded image.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun mimeType(): String = mimeType.getRequired("mime_type")

    /**
     * Original filename for the uploaded image. Defaults to null when unnamed.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun name(): Optional<String> = name.getOptional("name")

    /**
     * Preview URL that can be rendered inline for the image.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun previewUrl(): String = previewUrl.getRequired("preview_url")

    /**
     * Type discriminator that is always `image`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("image")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Signed URL for downloading the uploaded image. Defaults to null when no download link is
     * available.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun uploadUrl(): Optional<String> = uploadUrl.getOptional("upload_url")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [mimeType].
     *
     * Unlike [mimeType], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("mime_type") @ExcludeMissing fun _mimeType(): JsonField<String> = mimeType

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [previewUrl].
     *
     * Unlike [previewUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("preview_url") @ExcludeMissing fun _previewUrl(): JsonField<String> = previewUrl

    /**
     * Returns the raw JSON value of [uploadUrl].
     *
     * Unlike [uploadUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("upload_url") @ExcludeMissing fun _uploadUrl(): JsonField<String> = uploadUrl

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
         * Returns a mutable builder for constructing an instance of [ImagePart].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .mimeType()
         * .name()
         * .previewUrl()
         * .uploadUrl()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ImagePart]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var mimeType: JsonField<String>? = null
        private var name: JsonField<String>? = null
        private var previewUrl: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("image")
        private var uploadUrl: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(imagePart: ImagePart) = apply {
            id = imagePart.id
            mimeType = imagePart.mimeType
            name = imagePart.name
            previewUrl = imagePart.previewUrl
            type = imagePart.type
            uploadUrl = imagePart.uploadUrl
            additionalProperties = imagePart.additionalProperties.toMutableMap()
        }

        /** Unique identifier for the uploaded image. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** MIME type of the uploaded image. */
        fun mimeType(mimeType: String) = mimeType(JsonField.of(mimeType))

        /**
         * Sets [Builder.mimeType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.mimeType] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun mimeType(mimeType: JsonField<String>) = apply { this.mimeType = mimeType }

        /** Original filename for the uploaded image. Defaults to null when unnamed. */
        fun name(name: String?) = name(JsonField.ofNullable(name))

        /** Alias for calling [Builder.name] with `name.orElse(null)`. */
        fun name(name: Optional<String>) = name(name.getOrNull())

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** Preview URL that can be rendered inline for the image. */
        fun previewUrl(previewUrl: String) = previewUrl(JsonField.of(previewUrl))

        /**
         * Sets [Builder.previewUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.previewUrl] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun previewUrl(previewUrl: JsonField<String>) = apply { this.previewUrl = previewUrl }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("image")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /**
         * Signed URL for downloading the uploaded image. Defaults to null when no download link is
         * available.
         */
        fun uploadUrl(uploadUrl: String?) = uploadUrl(JsonField.ofNullable(uploadUrl))

        /** Alias for calling [Builder.uploadUrl] with `uploadUrl.orElse(null)`. */
        fun uploadUrl(uploadUrl: Optional<String>) = uploadUrl(uploadUrl.getOrNull())

        /**
         * Sets [Builder.uploadUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.uploadUrl] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun uploadUrl(uploadUrl: JsonField<String>) = apply { this.uploadUrl = uploadUrl }

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
         * Returns an immutable instance of [ImagePart].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .mimeType()
         * .name()
         * .previewUrl()
         * .uploadUrl()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ImagePart =
            ImagePart(
                checkRequired("id", id),
                checkRequired("mimeType", mimeType),
                checkRequired("name", name),
                checkRequired("previewUrl", previewUrl),
                type,
                checkRequired("uploadUrl", uploadUrl),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ImagePart = apply {
        if (validated) {
            return@apply
        }

        id()
        mimeType()
        name()
        previewUrl()
        _type().let {
            if (it != JsonValue.from("image")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        uploadUrl()
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
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (mimeType.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (if (previewUrl.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("image")) 1 else 0 } +
            (if (uploadUrl.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ImagePart &&
            id == other.id &&
            mimeType == other.mimeType &&
            name == other.name &&
            previewUrl == other.previewUrl &&
            type == other.type &&
            uploadUrl == other.uploadUrl &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, mimeType, name, previewUrl, type, uploadUrl, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ImagePart{id=$id, mimeType=$mimeType, name=$name, previewUrl=$previewUrl, type=$type, uploadUrl=$uploadUrl, additionalProperties=$additionalProperties}"
}
