// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

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
import kotlin.jvm.optionals.getOrNull

class McpRequireApprovalFilter
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val always: JsonField<McpToolFilter>,
    private val never: JsonField<McpToolFilter>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("always") @ExcludeMissing always: JsonField<McpToolFilter> = JsonMissing.of(),
        @JsonProperty("never") @ExcludeMissing never: JsonField<McpToolFilter> = JsonMissing.of(),
    ) : this(always, never, mutableMapOf())

    /**
     * A filter that forces approval for matching tools.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun always(): Optional<McpToolFilter> = always.getOptional("always")

    /**
     * A filter that skips approval for matching tools.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun never(): Optional<McpToolFilter> = never.getOptional("never")

    /**
     * Returns the raw JSON value of [always].
     *
     * Unlike [always], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("always") @ExcludeMissing fun _always(): JsonField<McpToolFilter> = always

    /**
     * Returns the raw JSON value of [never].
     *
     * Unlike [never], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("never") @ExcludeMissing fun _never(): JsonField<McpToolFilter> = never

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
        collectAllProperties(additionalProperties, "always" to this.always, "never" to this.never)

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

        /** Returns a mutable builder for constructing an instance of [McpRequireApprovalFilter]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [McpRequireApprovalFilter]. */
    class Builder internal constructor() {

        private var always: JsonField<McpToolFilter> = JsonMissing.of()
        private var never: JsonField<McpToolFilter> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(mcpRequireApprovalFilter: McpRequireApprovalFilter) = apply {
            always = mcpRequireApprovalFilter.always
            never = mcpRequireApprovalFilter.never
            additionalProperties = mcpRequireApprovalFilter.additionalProperties.toMutableMap()
        }

        /** A filter that forces approval for matching tools. */
        fun always(always: McpToolFilter?) = always(JsonField.ofNullable(always))

        /** Alias for calling [Builder.always] with `always.orElse(null)`. */
        fun always(always: Optional<McpToolFilter>) = always(always.getOrNull())

        /**
         * Sets [Builder.always] to an arbitrary JSON value.
         *
         * You should usually call [Builder.always] with a well-typed [McpToolFilter] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun always(always: JsonField<McpToolFilter>) = apply { this.always = always }

        /** A filter that skips approval for matching tools. */
        fun never(never: McpToolFilter?) = never(JsonField.ofNullable(never))

        /** Alias for calling [Builder.never] with `never.orElse(null)`. */
        fun never(never: Optional<McpToolFilter>) = never(never.getOrNull())

        /**
         * Sets [Builder.never] to an arbitrary JSON value.
         *
         * You should usually call [Builder.never] with a well-typed [McpToolFilter] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun never(never: JsonField<McpToolFilter>) = apply { this.never = never }

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
         * Returns an immutable instance of [McpRequireApprovalFilter].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): McpRequireApprovalFilter =
            McpRequireApprovalFilter(always, never, additionalProperties.toMutableMap())
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
    fun validate(): McpRequireApprovalFilter = apply {
        if (validated) {
            return@apply
        }

        always().ifPresent { it.validate() }
        never().ifPresent { it.validate() }
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
        (always.asKnown().getOrNull()?.validity() ?: 0) +
            (never.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is McpRequireApprovalFilter &&
            always == other.always &&
            never == other.never &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(always, never, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "McpRequireApprovalFilter{always=$always, never=$never, additionalProperties=$additionalProperties}"
}
