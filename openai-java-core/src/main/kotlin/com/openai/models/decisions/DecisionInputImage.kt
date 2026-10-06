// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.decisions

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

/** An inline image. External URLs and file IDs are not supported. */
class DecisionInputImage
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val imageUrl: JsonField<String>,
    private val type: JsonValue,
    private val detail: JsonField<Detail>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("image_url") @ExcludeMissing imageUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("detail") @ExcludeMissing detail: JsonField<Detail> = JsonMissing.of(),
    ) : this(imageUrl, type, detail, mutableMapOf())

    /**
     * A base64-encoded image in a data URL.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun imageUrl(): String = imageUrl.getRequired("image_url")

    /**
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
     * The image detail level, using the selected model's image profile. Defaults to auto.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun detail(): Optional<Detail> = detail.getOptional("detail")

    /**
     * Returns the raw JSON value of [imageUrl].
     *
     * Unlike [imageUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("image_url") @ExcludeMissing fun _imageUrl(): JsonField<String> = imageUrl

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
         * Returns a mutable builder for constructing an instance of [DecisionInputImage].
         *
         * The following fields are required:
         * ```java
         * .imageUrl()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [DecisionInputImage]. */
    class Builder internal constructor() {

        private var imageUrl: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("input_image")
        private var detail: JsonField<Detail> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(decisionInputImage: DecisionInputImage) = apply {
            imageUrl = decisionInputImage.imageUrl
            type = decisionInputImage.type
            detail = decisionInputImage.detail
            additionalProperties = decisionInputImage.additionalProperties.toMutableMap()
        }

        /** A base64-encoded image in a data URL. */
        fun imageUrl(imageUrl: String) = imageUrl(JsonField.of(imageUrl))

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
         * JsonValue.from("input_image")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** The image detail level, using the selected model's image profile. Defaults to auto. */
        fun detail(detail: Detail?) = detail(JsonField.ofNullable(detail))

        /** Alias for calling [Builder.detail] with `detail.orElse(null)`. */
        fun detail(detail: Optional<Detail>) = detail(detail.getOrNull())

        /**
         * Sets [Builder.detail] to an arbitrary JSON value.
         *
         * You should usually call [Builder.detail] with a well-typed [Detail] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
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
         * Returns an immutable instance of [DecisionInputImage].
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
        fun build(): DecisionInputImage =
            DecisionInputImage(
                checkRequired("imageUrl", imageUrl),
                type,
                detail,
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
    fun validate(): DecisionInputImage = apply {
        if (validated) {
            return@apply
        }

        imageUrl()
        _type().let {
            if (it != JsonValue.from("input_image")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (imageUrl.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("input_image")) 1 else 0 } +
            (detail.asKnown().getOrNull()?.validity() ?: 0)

    /** The image detail level, using the selected model's image profile. Defaults to auto. */
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is DecisionInputImage &&
            imageUrl == other.imageUrl &&
            type == other.type &&
            detail == other.detail &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(imageUrl, type, detail, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "DecisionInputImage{imageUrl=$imageUrl, type=$type, detail=$detail, additionalProperties=$additionalProperties}"
}
