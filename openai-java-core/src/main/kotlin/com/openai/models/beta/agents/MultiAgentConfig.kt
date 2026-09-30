// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

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

/** The resolved configuration for creating and coordinating subagents. */
class MultiAgentConfig
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val enabled: JsonField<Boolean>,
    private val maxConcurrentSubagents: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("enabled") @ExcludeMissing enabled: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("max_concurrent_subagents")
        @ExcludeMissing
        maxConcurrentSubagents: JsonField<Long> = JsonMissing.of(),
    ) : this(enabled, maxConcurrentSubagents, mutableMapOf())

    /**
     * Whether subagent tools are enabled. Defaults to false.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun enabled(): Boolean = enabled.getRequired("enabled")

    /**
     * Maximum number of subagents that may run concurrently, or null when disabled. Defaults to 6
     * when enabled.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun maxConcurrentSubagents(): Optional<Long> =
        maxConcurrentSubagents.getOptional("max_concurrent_subagents")

    /**
     * Returns the raw JSON value of [enabled].
     *
     * Unlike [enabled], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("enabled") @ExcludeMissing fun _enabled(): JsonField<Boolean> = enabled

    /**
     * Returns the raw JSON value of [maxConcurrentSubagents].
     *
     * Unlike [maxConcurrentSubagents], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("max_concurrent_subagents")
    @ExcludeMissing
    fun _maxConcurrentSubagents(): JsonField<Long> = maxConcurrentSubagents

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
         * Returns a mutable builder for constructing an instance of [MultiAgentConfig].
         *
         * The following fields are required:
         * ```java
         * .enabled()
         * .maxConcurrentSubagents()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MultiAgentConfig]. */
    class Builder internal constructor() {

        private var enabled: JsonField<Boolean>? = null
        private var maxConcurrentSubagents: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(multiAgentConfig: MultiAgentConfig) = apply {
            enabled = multiAgentConfig.enabled
            maxConcurrentSubagents = multiAgentConfig.maxConcurrentSubagents
            additionalProperties = multiAgentConfig.additionalProperties.toMutableMap()
        }

        /** Whether subagent tools are enabled. Defaults to false. */
        fun enabled(enabled: Boolean) = enabled(JsonField.of(enabled))

        /**
         * Sets [Builder.enabled] to an arbitrary JSON value.
         *
         * You should usually call [Builder.enabled] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun enabled(enabled: JsonField<Boolean>) = apply { this.enabled = enabled }

        /**
         * Maximum number of subagents that may run concurrently, or null when disabled. Defaults to
         * 6 when enabled.
         */
        fun maxConcurrentSubagents(maxConcurrentSubagents: Long?) =
            maxConcurrentSubagents(JsonField.ofNullable(maxConcurrentSubagents))

        /**
         * Alias for [Builder.maxConcurrentSubagents].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun maxConcurrentSubagents(maxConcurrentSubagents: Long) =
            maxConcurrentSubagents(maxConcurrentSubagents as Long?)

        /**
         * Alias for calling [Builder.maxConcurrentSubagents] with
         * `maxConcurrentSubagents.orElse(null)`.
         */
        fun maxConcurrentSubagents(maxConcurrentSubagents: Optional<Long>) =
            maxConcurrentSubagents(maxConcurrentSubagents.getOrNull())

        /**
         * Sets [Builder.maxConcurrentSubagents] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxConcurrentSubagents] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun maxConcurrentSubagents(maxConcurrentSubagents: JsonField<Long>) = apply {
            this.maxConcurrentSubagents = maxConcurrentSubagents
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
         * Returns an immutable instance of [MultiAgentConfig].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .enabled()
         * .maxConcurrentSubagents()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): MultiAgentConfig =
            MultiAgentConfig(
                checkRequired("enabled", enabled),
                checkRequired("maxConcurrentSubagents", maxConcurrentSubagents),
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
    fun validate(): MultiAgentConfig = apply {
        if (validated) {
            return@apply
        }

        enabled()
        maxConcurrentSubagents()
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
        (if (enabled.asKnown().isPresent) 1 else 0) +
            (if (maxConcurrentSubagents.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MultiAgentConfig &&
            enabled == other.enabled &&
            maxConcurrentSubagents == other.maxConcurrentSubagents &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(enabled, maxConcurrentSubagents, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MultiAgentConfig{enabled=$enabled, maxConcurrentSubagents=$maxConcurrentSubagents, additionalProperties=$additionalProperties}"
}
