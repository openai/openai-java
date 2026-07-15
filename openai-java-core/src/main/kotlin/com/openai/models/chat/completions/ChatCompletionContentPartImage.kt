// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

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

/** Learn about [image inputs](https://platform.openai.com/docs/guides/vision). */
class ChatCompletionContentPartImage
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val imageUrl: JsonField<ImageUrl>,
    private val type: JsonValue,
    private val promptCacheBreakpoint: JsonField<PromptCacheBreakpoint>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("image_url") @ExcludeMissing imageUrl: JsonField<ImageUrl> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("prompt_cache_breakpoint")
        @ExcludeMissing
        promptCacheBreakpoint: JsonField<PromptCacheBreakpoint> = JsonMissing.of(),
    ) : this(imageUrl, type, promptCacheBreakpoint, mutableMapOf())

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun imageUrl(): ImageUrl = imageUrl.getRequired("image_url")

    /**
     * The type of the content part.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("image_url")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

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
     * Returns the raw JSON value of [imageUrl].
     *
     * Unlike [imageUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("image_url") @ExcludeMissing fun _imageUrl(): JsonField<ImageUrl> = imageUrl

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
         * Returns a mutable builder for constructing an instance of
         * [ChatCompletionContentPartImage].
         *
         * The following fields are required:
         * ```java
         * .imageUrl()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ChatCompletionContentPartImage]. */
    class Builder internal constructor() {

        private var imageUrl: JsonField<ImageUrl>? = null
        private var type: JsonValue = JsonValue.from("image_url")
        private var promptCacheBreakpoint: JsonField<PromptCacheBreakpoint> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatCompletionContentPartImage: ChatCompletionContentPartImage) = apply {
            imageUrl = chatCompletionContentPartImage.imageUrl
            type = chatCompletionContentPartImage.type
            promptCacheBreakpoint = chatCompletionContentPartImage.promptCacheBreakpoint
            additionalProperties =
                chatCompletionContentPartImage.additionalProperties.toMutableMap()
        }

        fun imageUrl(imageUrl: ImageUrl) = imageUrl(JsonField.of(imageUrl))

        /**
         * Sets [Builder.imageUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.imageUrl] with a well-typed [ImageUrl] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun imageUrl(imageUrl: JsonField<ImageUrl>) = apply { this.imageUrl = imageUrl }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("image_url")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

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
         * Returns an immutable instance of [ChatCompletionContentPartImage].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .imageUrl()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ChatCompletionContentPartImage =
            ChatCompletionContentPartImage(
                checkRequired("imageUrl", imageUrl),
                type,
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
    fun validate(): ChatCompletionContentPartImage = apply {
        if (validated) {
            return@apply
        }

        imageUrl().validate()
        _type().let {
            if (it != JsonValue.from("image_url")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
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
        (imageUrl.asKnown().getOrNull()?.validity() ?: 0) +
            type.let { if (it == JsonValue.from("image_url")) 1 else 0 } +
            (promptCacheBreakpoint.asKnown().getOrNull()?.validity() ?: 0)

    class ImageUrl
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val url: JsonField<String>,
        private val detail: JsonField<Detail>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
            @JsonProperty("detail") @ExcludeMissing detail: JsonField<Detail> = JsonMissing.of(),
        ) : this(url, detail, mutableMapOf())

        /**
         * Either a URL of the image or the base64 encoded image data.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun url(): String = url.getRequired("url")

        /**
         * Specifies the detail level of the image. Learn more in the
         * [Vision guide](https://platform.openai.com/docs/guides/vision#low-or-high-fidelity-image-understanding).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun detail(): Optional<Detail> = detail.getOptional("detail")

        /**
         * Returns the raw JSON value of [url].
         *
         * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

        /**
         * Returns the raw JSON value of [detail].
         *
         * Unlike [detail], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("detail") @ExcludeMissing fun _detail(): JsonField<Detail> = detail

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
             * Returns a mutable builder for constructing an instance of [ImageUrl].
             *
             * The following fields are required:
             * ```java
             * .url()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ImageUrl]. */
        class Builder internal constructor() {

            private var url: JsonField<String>? = null
            private var detail: JsonField<Detail> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(imageUrl: ImageUrl) = apply {
                url = imageUrl.url
                detail = imageUrl.detail
                additionalProperties = imageUrl.additionalProperties.toMutableMap()
            }

            /** Either a URL of the image or the base64 encoded image data. */
            fun url(url: String) = url(JsonField.of(url))

            /**
             * Sets [Builder.url] to an arbitrary JSON value.
             *
             * You should usually call [Builder.url] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun url(url: JsonField<String>) = apply { this.url = url }

            /**
             * Specifies the detail level of the image. Learn more in the
             * [Vision guide](https://platform.openai.com/docs/guides/vision#low-or-high-fidelity-image-understanding).
             */
            fun detail(detail: Detail) = detail(JsonField.of(detail))

            /**
             * Sets [Builder.detail] to an arbitrary JSON value.
             *
             * You should usually call [Builder.detail] with a well-typed [Detail] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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

            /**
             * Returns an immutable instance of [ImageUrl].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .url()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ImageUrl =
                ImageUrl(checkRequired("url", url), detail, additionalProperties.toMutableMap())
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
        fun validate(): ImageUrl = apply {
            if (validated) {
                return@apply
            }

            url()
            detail().ifPresent { it.validate() }
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
        internal fun validity(): Int =
            (if (url.asKnown().isPresent) 1 else 0) +
                (detail.asKnown().getOrNull()?.validity() ?: 0)

        /**
         * Specifies the detail level of the image. Learn more in the
         * [Vision guide](https://platform.openai.com/docs/guides/vision#low-or-high-fidelity-image-understanding).
         */
        class Detail @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
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
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                AUTO,
                LOW,
                HIGH,
                /**
                 * An enum member indicating that [Detail] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
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
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
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
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws OpenAIInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    OpenAIInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ImageUrl &&
                url == other.url &&
                detail == other.detail &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(url, detail, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ImageUrl{url=$url, detail=$detail, additionalProperties=$additionalProperties}"
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

        return other is ChatCompletionContentPartImage &&
            imageUrl == other.imageUrl &&
            type == other.type &&
            promptCacheBreakpoint == other.promptCacheBreakpoint &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(imageUrl, type, promptCacheBreakpoint, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChatCompletionContentPartImage{imageUrl=$imageUrl, type=$type, promptCacheBreakpoint=$promptCacheBreakpoint, additionalProperties=$additionalProperties}"
}
