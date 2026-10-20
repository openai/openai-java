// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.decisions

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.collectAllProperties
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects

/**
 * Marks the exact end of a reusable prompt prefix. The breakpoint inherits its TTL from the
 * request's `prompt_cache_options.ttl`; the boundary is not rounded to a token block.
 */
class DecisionPromptCacheBreakpoint
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
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("mode") @ExcludeMissing fun _mode(): JsonValue = mode

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
        collectAllProperties(additionalProperties, "mode" to this.mode)

    /**
     * Returns the legacy additional-properties view.
     *
     * @deprecated Use [_allProperties] to access both declared and additional JSON properties. This
     *   accessor retains its legacy additional-properties behavior.
     */
    @Deprecated("Use _allProperties() to access both declared and additional JSON properties.")
    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [DecisionPromptCacheBreakpoint].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [DecisionPromptCacheBreakpoint]. */
    class Builder internal constructor() {

        private var mode: JsonValue = JsonValue.from("explicit")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(decisionPromptCacheBreakpoint: DecisionPromptCacheBreakpoint) = apply {
            mode = decisionPromptCacheBreakpoint.mode
            additionalProperties = decisionPromptCacheBreakpoint.additionalProperties.toMutableMap()
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
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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
         * Returns an immutable instance of [DecisionPromptCacheBreakpoint].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): DecisionPromptCacheBreakpoint =
            DecisionPromptCacheBreakpoint(mode, additionalProperties.toMutableMap())
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
    fun validate(): DecisionPromptCacheBreakpoint = apply {
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int = mode.let { if (it == JsonValue.from("explicit")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is DecisionPromptCacheBreakpoint &&
            mode == other.mode &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(mode, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "DecisionPromptCacheBreakpoint{mode=$mode, additionalProperties=$additionalProperties}"
}
