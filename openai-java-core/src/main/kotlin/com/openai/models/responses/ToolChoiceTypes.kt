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
import com.openai.core.NoAutoDetect
import com.openai.core.checkRequired
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects

/**
 * Indicates that the model should use a built-in tool to generate a response.
 * [Learn more about built-in tools](https://platform.openai.com/docs/guides/tools).
 */
@NoAutoDetect
class ToolChoiceTypes
@JsonCreator
private constructor(
    @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * The type of hosted tool the model should to use. Learn more about
     * [built-in tools](https://platform.openai.com/docs/guides/tools).
     *
     * Allowed values are:
     * - `file_search`
     * - `web_search_preview`
     * - `computer_use_preview`
     */
    fun type(): Type = type.getRequired("type")

    /**
     * The type of hosted tool the model should to use. Learn more about
     * [built-in tools](https://platform.openai.com/docs/guides/tools).
     *
     * Allowed values are:
     * - `file_search`
     * - `web_search_preview`
     * - `computer_use_preview`
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ToolChoiceTypes = apply {
        if (validated) {
            return@apply
        }

        type()
        validated = true
    }

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
         */
        fun type(type: Type) = type(JsonField.of(type))

        /**
         * The type of hosted tool the model should to use. Learn more about
         * [built-in tools](https://platform.openai.com/docs/guides/tools).
         *
         * Allowed values are:
         * - `file_search`
         * - `web_search_preview`
         * - `computer_use_preview`
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

        fun build(): ToolChoiceTypes =
            ToolChoiceTypes(checkRequired("type", type), additionalProperties.toImmutable())
    }

    /**
     * The type of hosted tool the model should to use. Learn more about
     * [built-in tools](https://platform.openai.com/docs/guides/tools).
     *
     * Allowed values are:
     * - `file_search`
     * - `web_search_preview`
     * - `computer_use_preview`
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

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        /** An enum containing [Type]'s known values. */
        enum class Known {
            FILE_SEARCH,
            WEB_SEARCH_PREVIEW,
            COMPUTER_USE_PREVIEW,
            WEB_SEARCH_PREVIEW_2025_03_11,
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Type && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ToolChoiceTypes && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ToolChoiceTypes{type=$type, additionalProperties=$additionalProperties}"
}
