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
import kotlin.jvm.optionals.getOrNull

/**
 * Indicates that the model should use a built-in tool to generate a response.
 * [Learn more about built-in tools](https://platform.openai.com/docs/guides/tools).
 */
class ToolChoiceTypes
private constructor(
    private val type: JsonField<Type>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of()
    ) : this(type, mutableMapOf())

    /**
     * The type of hosted tool the model should to use. Learn more about
     * [built-in tools](https://platform.openai.com/docs/guides/tools).
     *
     * Allowed values are:
     * - `file_search`
     * - `web_search_preview`
     * - `computer_use_preview`
     * - `code_interpreter`
     * - `image_generation`
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun type(): Type = type.getRequired("type")

    /**
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

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
         * Returns a mutable builder for constructing an instance of [ToolChoiceTypes].
         *
         * The following fields are required:
         * ```java
         * .type()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ToolChoiceTypes]. */
    class Builder internal constructor() {

        private var type: JsonField<Type>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(toolChoiceTypes: ToolChoiceTypes) = apply {
            type = toolChoiceTypes.type
            additionalProperties = toolChoiceTypes.additionalProperties.toMutableMap()
        }

        /**
         * The type of hosted tool the model should to use. Learn more about
         * [built-in tools](https://platform.openai.com/docs/guides/tools).
         *
         * Allowed values are:
         * - `file_search`
         * - `web_search_preview`
         * - `computer_use_preview`
         * - `code_interpreter`
         * - `image_generation`
         */
        fun type(type: Type) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [Type] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<Type>) = apply { this.type = type }

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
         * Returns an immutable instance of [ToolChoiceTypes].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .type()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ToolChoiceTypes =
            ToolChoiceTypes(checkRequired("type", type), additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): ToolChoiceTypes = apply {
        if (validated) {
            return@apply
        }

        type().validate()
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
    @JvmSynthetic internal fun validity(): Int = (type.asKnown().getOrNull()?.validity() ?: 0)

    /**
     * The type of hosted tool the model should to use. Learn more about
     * [built-in tools](https://platform.openai.com/docs/guides/tools).
     *
     * Allowed values are:
     * - `file_search`
     * - `web_search_preview`
     * - `computer_use_preview`
     * - `code_interpreter`
     * - `image_generation`
     */
    class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val FILE_SEARCH = of("file_search")

            @JvmField val WEB_SEARCH_PREVIEW = of("web_search_preview")

            @JvmField val COMPUTER_USE_PREVIEW = of("computer_use_preview")

            @JvmField val WEB_SEARCH_PREVIEW_2025_03_11 = of("web_search_preview_2025_03_11")

            @JvmField val IMAGE_GENERATION = of("image_generation")

            @JvmField val CODE_INTERPRETER = of("code_interpreter")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        /** An enum containing [Type]'s known values. */
        enum class Known {
            FILE_SEARCH,
            WEB_SEARCH_PREVIEW,
            COMPUTER_USE_PREVIEW,
            WEB_SEARCH_PREVIEW_2025_03_11,
            IMAGE_GENERATION,
            CODE_INTERPRETER,
        }

        /**
         * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Type] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            FILE_SEARCH,
            WEB_SEARCH_PREVIEW,
            COMPUTER_USE_PREVIEW,
            WEB_SEARCH_PREVIEW_2025_03_11,
            IMAGE_GENERATION,
            CODE_INTERPRETER,
            /** An enum member indicating that [Type] was instantiated with an unknown value. */
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
                FILE_SEARCH -> Value.FILE_SEARCH
                WEB_SEARCH_PREVIEW -> Value.WEB_SEARCH_PREVIEW
                COMPUTER_USE_PREVIEW -> Value.COMPUTER_USE_PREVIEW
                WEB_SEARCH_PREVIEW_2025_03_11 -> Value.WEB_SEARCH_PREVIEW_2025_03_11
                IMAGE_GENERATION -> Value.IMAGE_GENERATION
                CODE_INTERPRETER -> Value.CODE_INTERPRETER
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
                FILE_SEARCH -> Known.FILE_SEARCH
                WEB_SEARCH_PREVIEW -> Known.WEB_SEARCH_PREVIEW
                COMPUTER_USE_PREVIEW -> Known.COMPUTER_USE_PREVIEW
                WEB_SEARCH_PREVIEW_2025_03_11 -> Known.WEB_SEARCH_PREVIEW_2025_03_11
                IMAGE_GENERATION -> Known.IMAGE_GENERATION
                CODE_INTERPRETER -> Known.CODE_INTERPRETER
                else -> throw OpenAIInvalidDataException("Unknown Type: $value")
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

        fun validate(): Type = apply {
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

            return other is Type && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ToolChoiceTypes &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(type, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ToolChoiceTypes{type=$type, additionalProperties=$additionalProperties}"
}
