// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.checkRequired
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import java.util.Objects

@NoAutoDetect
class StaticFileChunkingStrategy
@JsonCreator
private constructor(
    @JsonProperty("chunk_overlap_tokens")
    @ExcludeMissing
    private val chunkOverlapTokens: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("max_chunk_size_tokens")
    @ExcludeMissing
    private val maxChunkSizeTokens: JsonField<Long> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * The number of tokens that overlap between chunks. The default value is `400`.
     *
     * Note that the overlap must not exceed half of `max_chunk_size_tokens`.
     */
    fun chunkOverlapTokens(): Long = chunkOverlapTokens.getRequired("chunk_overlap_tokens")

    /**
     * The maximum number of tokens in each chunk. The default value is `800`. The minimum value is
     * `100` and the maximum value is `4096`.
     */
    fun maxChunkSizeTokens(): Long = maxChunkSizeTokens.getRequired("max_chunk_size_tokens")

    /**
     * The number of tokens that overlap between chunks. The default value is `400`.
     *
     * Note that the overlap must not exceed half of `max_chunk_size_tokens`.
     */
    @JsonProperty("chunk_overlap_tokens")
    @ExcludeMissing
    fun _chunkOverlapTokens(): JsonField<Long> = chunkOverlapTokens

    /**
     * The maximum number of tokens in each chunk. The default value is `800`. The minimum value is
     * `100` and the maximum value is `4096`.
     */
    @JsonProperty("max_chunk_size_tokens")
    @ExcludeMissing
    fun _maxChunkSizeTokens(): JsonField<Long> = maxChunkSizeTokens

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): StaticFileChunkingStrategy = apply {
        if (validated) {
            return@apply
        }

        chunkOverlapTokens()
        maxChunkSizeTokens()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

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
         * The number of tokens that overlap between chunks. The default value is `400`.
         *
         * Note that the overlap must not exceed half of `max_chunk_size_tokens`.
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
         * The maximum number of tokens in each chunk. The default value is `800`. The minimum value
         * is `100` and the maximum value is `4096`.
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

        fun build(): StaticFileChunkingStrategy =
            StaticFileChunkingStrategy(
                checkRequired("chunkOverlapTokens", chunkOverlapTokens),
                checkRequired("maxChunkSizeTokens", maxChunkSizeTokens),
                additionalProperties.toImmutable(),
            )
    }

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
