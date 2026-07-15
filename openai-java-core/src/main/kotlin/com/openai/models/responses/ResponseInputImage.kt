// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
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
 * An image input to the model. Learn about
 * [image inputs](https://platform.openai.com/docs/guides/vision).
 */
class ResponseInputImage
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val detail: JsonField<Detail>,
    private val type: JsonValue,
    private val fileId: JsonField<String>,
    private val imageUrl: JsonField<String>,
    private val promptCacheBreakpoint: JsonField<PromptCacheBreakpoint>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("detail") @ExcludeMissing detail: JsonField<Detail> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("file_id") @ExcludeMissing fileId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("image_url") @ExcludeMissing imageUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("prompt_cache_breakpoint")
        @ExcludeMissing
        promptCacheBreakpoint: JsonField<PromptCacheBreakpoint> = JsonMissing.of(),
    ) : this(detail, type, fileId, imageUrl, promptCacheBreakpoint, mutableMapOf())

    /**
     * The detail level of the image to be sent to the model. One of `high`, `low`, `auto`, or
     * `original`. Defaults to `auto`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun detail(): Detail = detail.getRequired("detail")

    /**
     * The type of the input item. Always `input_image`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("input_image")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * The ID of the file to be sent to the model.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun fileId(): Optional<String> = fileId.getOptional("file_id")

    /**
     * The URL of the image to be sent to the model. A fully qualified URL or base64 encoded image
     * in a data URL.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun imageUrl(): Optional<String> = imageUrl.getOptional("image_url")

    /**
     * Marks the exact end of a reusable prompt prefix. The breakpoint inherits its TTL from the
     * request's `prompt_cache_options.ttl`; the boundary is not rounded to a token block.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun promptCacheBreakpoint(): Optional<PromptCacheBreakpoint> =
        promptCacheBreakpoint.getOptional("prompt_cache_breakpoint")

    /**
     * Returns the raw JSON value of [detail].
     *
     * Unlike [detail], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("detail") @ExcludeMissing fun _detail(): JsonField<Detail> = detail

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

    /**
     * Returns the raw JSON value of [promptCacheBreakpoint].
     *
     * Unlike [promptCacheBreakpoint], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("prompt_cache_breakpoint")
    @ExcludeMissing
    fun _promptCacheBreakpoint(): JsonField<PromptCacheBreakpoint> = promptCacheBreakpoint

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
         * Returns a mutable builder for constructing an instance of [ResponseInputImage].
         *
         * The following fields are required:
         * ```java
         * .detail()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseInputImage]. */
    class Builder internal constructor() {

        private var detail: JsonField<Detail>? = null
        private var type: JsonValue = JsonValue.from("input_image")
        private var fileId: JsonField<String> = JsonMissing.of()
        private var imageUrl: JsonField<String> = JsonMissing.of()
        private var promptCacheBreakpoint: JsonField<PromptCacheBreakpoint> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseInputImage: ResponseInputImage) = apply {
            detail = responseInputImage.detail
            type = responseInputImage.type
            fileId = responseInputImage.fileId
            imageUrl = responseInputImage.imageUrl
            promptCacheBreakpoint = responseInputImage.promptCacheBreakpoint
            additionalProperties = responseInputImage.additionalProperties.toMutableMap()
        }

        /**
         * The detail level of the image to be sent to the model. One of `high`, `low`, `auto`, or
         * `original`. Defaults to `auto`.
         */
        fun detail(detail: Detail) = detail(JsonField.of(detail))

        /**
         * Sets [Builder.detail] to an arbitrary JSON value.
         *
         * You should usually call [Builder.detail] with a well-typed [Detail] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun detail(detail: JsonField<Detail>) = apply { this.detail = detail }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("input_image")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** The ID of the file to be sent to the model. */
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

        /**
         * The URL of the image to be sent to the model. A fully qualified URL or base64 encoded
         * image in a data URL.
         */
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
         * Marks the exact end of a reusable prompt prefix. The breakpoint inherits its TTL from the
         * request's `prompt_cache_options.ttl`; the boundary is not rounded to a token block.
         */
        fun promptCacheBreakpoint(promptCacheBreakpoint: PromptCacheBreakpoint) =
            promptCacheBreakpoint(JsonField.of(promptCacheBreakpoint))

        /**
         * Sets [Builder.promptCacheBreakpoint] to an arbitrary JSON value.
         *
         * You should usually call [Builder.promptCacheBreakpoint] with a well-typed
         * [PromptCacheBreakpoint] value instead. This method is primarily for setting the field to
         * an undocumented or not yet supported value.
         */
        fun promptCacheBreakpoint(promptCacheBreakpoint: JsonField<PromptCacheBreakpoint>) = apply {
            this.promptCacheBreakpoint = promptCacheBreakpoint
        }

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
         * Returns an immutable instance of [ResponseInputImage].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .detail()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ResponseInputImage =
            ResponseInputImage(
                checkRequired("detail", detail),
                type,
                fileId,
                imageUrl,
                promptCacheBreakpoint,
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
    fun validate(): ResponseInputImage = apply {
        if (validated) {
            return@apply
        }

        detail().validate()
        _type().let {
            if (it != JsonValue.from("input_image")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        fileId()
        imageUrl()
        promptCacheBreakpoint().ifPresent { it.validate() }
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
        (detail.asKnown().getOrNull()?.validity() ?: 0) +
            type.let { if (it == JsonValue.from("input_image")) 1 else 0 } +
            (if (fileId.asKnown().isPresent) 1 else 0) +
            (if (imageUrl.asKnown().isPresent) 1 else 0) +
            (promptCacheBreakpoint.asKnown().getOrNull()?.validity() ?: 0)

    /**
     * The detail level of the image to be sent to the model. One of `high`, `low`, `auto`, or
     * `original`. Defaults to `auto`.
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

            @JvmField val LOW = of("low")

            @JvmField val HIGH = of("high")

            @JvmField val AUTO = of("auto")

            @JvmField val ORIGINAL = of("original")

            @JvmStatic fun of(value: String) = Detail(JsonField.of(value))
        }

        /** An enum containing [Detail]'s known values. */
        enum class Known {
            LOW,
            HIGH,
            AUTO,
            ORIGINAL,
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
            LOW,
            HIGH,
            AUTO,
            ORIGINAL,
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
                LOW -> Value.LOW
                HIGH -> Value.HIGH
                AUTO -> Value.AUTO
                ORIGINAL -> Value.ORIGINAL
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
                LOW -> Known.LOW
                HIGH -> Known.HIGH
                AUTO -> Known.AUTO
                ORIGINAL -> Known.ORIGINAL
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

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Detail = apply {
            if (validated) {
                return@apply
            }

            known()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Detail && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * Marks the exact end of a reusable prompt prefix. The breakpoint inherits its TTL from the
     * request's `prompt_cache_options.ttl`; the boundary is not rounded to a token block.
     */
    class PromptCacheBreakpoint
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val mode: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("mode") @ExcludeMissing mode: JsonValue = JsonMissing.of()
        ) : this(mode, mutableMapOf())

        /**
         * The breakpoint mode. Always `explicit`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("explicit")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("mode") @ExcludeMissing fun _mode(): JsonValue = mode

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
             * Returns a mutable builder for constructing an instance of [PromptCacheBreakpoint].
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [PromptCacheBreakpoint]. */
        class Builder internal constructor() {

            private var mode: JsonValue = JsonValue.from("explicit")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(promptCacheBreakpoint: PromptCacheBreakpoint) = apply {
                mode = promptCacheBreakpoint.mode
                additionalProperties = promptCacheBreakpoint.additionalProperties.toMutableMap()
            }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("explicit")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun mode(mode: JsonValue) = apply { this.mode = mode }

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
             * Returns an immutable instance of [PromptCacheBreakpoint].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): PromptCacheBreakpoint =
                PromptCacheBreakpoint(mode, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): PromptCacheBreakpoint = apply {
            if (validated) {
                return@apply
            }

            _mode().let {
                if (it != JsonValue.from("explicit")) {
                    throw OpenAIInvalidDataException("'mode' is invalid, received $it")
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int = mode.let { if (it == JsonValue.from("explicit")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is PromptCacheBreakpoint &&
                mode == other.mode &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(mode, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "PromptCacheBreakpoint{mode=$mode, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ResponseInputImage &&
            detail == other.detail &&
            type == other.type &&
            fileId == other.fileId &&
            imageUrl == other.imageUrl &&
            promptCacheBreakpoint == other.promptCacheBreakpoint &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(detail, type, fileId, imageUrl, promptCacheBreakpoint, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseInputImage{detail=$detail, type=$type, fileId=$fileId, imageUrl=$imageUrl, promptCacheBreakpoint=$promptCacheBreakpoint, additionalProperties=$additionalProperties}"
}
