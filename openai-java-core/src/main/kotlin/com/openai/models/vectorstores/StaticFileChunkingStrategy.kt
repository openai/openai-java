// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores

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

class StaticFileChunkingStrategy
private constructor(
    private val chunkOverlapTokens: JsonField<Long>,
    private val maxChunkSizeTokens: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("chunk_overlap_tokens")
        @ExcludeMissing
        chunkOverlapTokens: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("max_chunk_size_tokens")
        @ExcludeMissing
        maxChunkSizeTokens: JsonField<Long> = JsonMissing.of(),
    ) : this(chunkOverlapTokens, maxChunkSizeTokens, mutableMapOf())

    /**
     * The number of tokens that overlap between chunks. The default value is `400`.
     *
     * Note that the overlap must not exceed half of `max_chunk_size_tokens`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun chunkOverlapTokens(): Long = chunkOverlapTokens.getRequired("chunk_overlap_tokens")

    /**
     * The maximum number of tokens in each chunk. The default value is `800`. The minimum value is
     * `100` and the maximum value is `4096`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun maxChunkSizeTokens(): Long = maxChunkSizeTokens.getRequired("max_chunk_size_tokens")

    /**
     * Returns the raw JSON value of [chunkOverlapTokens].
     *
     * Unlike [chunkOverlapTokens], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("chunk_overlap_tokens")
    @ExcludeMissing
    fun _chunkOverlapTokens(): JsonField<Long> = chunkOverlapTokens

    /**
     * Returns the raw JSON value of [maxChunkSizeTokens].
     *
     * Unlike [maxChunkSizeTokens], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("max_chunk_size_tokens")
    @ExcludeMissing
    fun _maxChunkSizeTokens(): JsonField<Long> = maxChunkSizeTokens

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
         * Returns a mutable builder for constructing an instance of [StaticFileChunkingStrategy].
         *
         * The following fields are required:
         * ```java
         * .chunkOverlapTokens()
         * .maxChunkSizeTokens()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [StaticFileChunkingStrategy]. */
    class Builder internal constructor() {

        private var chunkOverlapTokens: JsonField<Long>? = null
        private var maxChunkSizeTokens: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(staticFileChunkingStrategy: StaticFileChunkingStrategy) = apply {
            chunkOverlapTokens = staticFileChunkingStrategy.chunkOverlapTokens
            maxChunkSizeTokens = staticFileChunkingStrategy.maxChunkSizeTokens
            additionalProperties = staticFileChunkingStrategy.additionalProperties.toMutableMap()
        }

        /**
         * The number of tokens that overlap between chunks. The default value is `400`.
         *
         * Note that the overlap must not exceed half of `max_chunk_size_tokens`.
         */
        fun chunkOverlapTokens(chunkOverlapTokens: Long) =
            chunkOverlapTokens(JsonField.of(chunkOverlapTokens))

        /**
         * Sets [Builder.chunkOverlapTokens] to an arbitrary JSON value.
         *
         * You should usually call [Builder.chunkOverlapTokens] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun chunkOverlapTokens(chunkOverlapTokens: JsonField<Long>) = apply {
            this.chunkOverlapTokens = chunkOverlapTokens
        }

        /**
         * The maximum number of tokens in each chunk. The default value is `800`. The minimum value
         * is `100` and the maximum value is `4096`.
         */
        fun maxChunkSizeTokens(maxChunkSizeTokens: Long) =
            maxChunkSizeTokens(JsonField.of(maxChunkSizeTokens))

        /**
         * Sets [Builder.maxChunkSizeTokens] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxChunkSizeTokens] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun maxChunkSizeTokens(maxChunkSizeTokens: JsonField<Long>) = apply {
            this.maxChunkSizeTokens = maxChunkSizeTokens
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
         * Returns an immutable instance of [StaticFileChunkingStrategy].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .chunkOverlapTokens()
         * .maxChunkSizeTokens()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): StaticFileChunkingStrategy =
            StaticFileChunkingStrategy(
                checkRequired("chunkOverlapTokens", chunkOverlapTokens),
                checkRequired("maxChunkSizeTokens", maxChunkSizeTokens),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): StaticFileChunkingStrategy = apply {
        if (validated) {
            return@apply
        }

        chunkOverlapTokens()
        maxChunkSizeTokens()
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
        (if (chunkOverlapTokens.asKnown().isPresent) 1 else 0) +
            (if (maxChunkSizeTokens.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is StaticFileChunkingStrategy && chunkOverlapTokens == other.chunkOverlapTokens && maxChunkSizeTokens == other.maxChunkSizeTokens && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(chunkOverlapTokens, maxChunkSizeTokens, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "StaticFileChunkingStrategy{chunkOverlapTokens=$chunkOverlapTokens, maxChunkSizeTokens=$maxChunkSizeTokens, additionalProperties=$additionalProperties}"
}
