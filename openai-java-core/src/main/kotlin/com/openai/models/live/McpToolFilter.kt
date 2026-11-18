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
import com.openai.core.checkKnown
import com.openai.core.collectAllProperties
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class McpToolFilter
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val readOnly: JsonField<Boolean>,
    private val toolNames: JsonField<List<String>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("read_only") @ExcludeMissing readOnly: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("tool_names")
        @ExcludeMissing
        toolNames: JsonField<List<String>> = JsonMissing.of(),
    ) : this(readOnly, toolNames, mutableMapOf())

    /**
     * Whether to allow only read-only tools for matching entries. Returns empty if the JSON
     * property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun readOnly(): java.util.Optional<Boolean> = readOnly.getOptional("read_only")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun readOnlyOrThrow(): Boolean = readOnly.getRequired("read_only")

    /**
     * A list of tool names to match against. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun toolNames(): java.util.Optional<List<String>> = toolNames.getOptional("tool_names")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun toolNamesOrThrow(): List<String> = toolNames.getRequired("tool_names")

    /**
     * Returns the raw JSON value of [readOnly].
     *
     * Unlike [readOnly], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("read_only") @ExcludeMissing fun _readOnly(): JsonField<Boolean> = readOnly

    /**
     * Returns the raw JSON value of [toolNames].
     *
     * Unlike [toolNames], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tool_names")
    @ExcludeMissing
    fun _toolNames(): JsonField<List<String>> = toolNames

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
            "read_only" to this.readOnly,
            "tool_names" to this.toolNames,
        )

    @JvmSynthetic
    internal fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    @JsonAnyGetter
    @ExcludeMissing
    private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun toBuilder() = Builder().from(this)

    companion object {

        /** Returns a mutable builder for constructing an instance of [McpToolFilter]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [McpToolFilter]. */
    class Builder internal constructor() {

        private var readOnly: JsonField<Boolean> = JsonMissing.of()
        private var toolNames: JsonField<MutableList<String>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(mcpToolFilter: McpToolFilter) = apply {
            readOnly = mcpToolFilter.readOnly
            toolNames = mcpToolFilter.toolNames.map { it.toMutableList() }
            additionalProperties = mcpToolFilter.additionalProperties.toMutableMap()
        }

        /** Whether to allow only read-only tools for matching entries. */
        fun readOnly(readOnly: Boolean?) = readOnly(JsonField.ofNullable(readOnly))

        /**
         * Alias for [Builder.readOnly].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun readOnly(readOnly: Boolean) = readOnly(readOnly as Boolean?)

        /** Alias for calling [Builder.readOnly] with `readOnly.orElse(null)`. */
        fun readOnly(readOnly: Optional<Boolean>) = readOnly(readOnly.getOrNull())

        /**
         * Sets [Builder.readOnly] to an arbitrary JSON value.
         *
         * You should usually call [Builder.readOnly] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun readOnly(readOnly: JsonField<Boolean>) = apply { this.readOnly = readOnly }

        /** A list of tool names to match against. */
        fun toolNames(toolNames: List<String>?) = toolNames(JsonField.ofNullable(toolNames))

        /** Alias for calling [Builder.toolNames] with `toolNames.orElse(null)`. */
        fun toolNames(toolNames: Optional<List<String>>) = toolNames(toolNames.getOrNull())

        /**
         * Sets [Builder.toolNames] to an arbitrary JSON value.
         *
         * You should usually call [Builder.toolNames] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun toolNames(toolNames: JsonField<List<String>>) = apply {
            this.toolNames = toolNames.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [toolNames].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addToolName(toolName: String) = apply {
            toolNames =
                (toolNames?.takeUnless { it.isMissing() } ?: JsonField.of(mutableListOf())).also {
                    checkKnown("toolNames", it).add(toolName)
                }
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
         * Returns an immutable instance of [McpToolFilter].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): McpToolFilter =
            McpToolFilter(
                readOnly,
                (toolNames ?: JsonMissing.of()).map { it.toImmutable() },
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
    fun validate(): McpToolFilter = apply {
        if (validated) {
            return@apply
        }

        readOnly()
        toolNames()
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
        (if (readOnly.asKnown().isPresent) 1 else 0) + (toolNames.asKnown().getOrNull()?.size ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is McpToolFilter &&
            readOnly == other.readOnly &&
            toolNames == other.toolNames &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(readOnly, toolNames, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "McpToolFilter{readOnly=$readOnly, toolNames=$toolNames, additionalProperties=$additionalProperties}"
}
