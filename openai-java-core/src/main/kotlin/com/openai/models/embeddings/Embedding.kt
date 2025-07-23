// File generated from our OpenAPI spec by Stainless.

package com.openai.models.embeddings

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** Represents an embedding vector returned by embedding endpoint. */
class Embedding
private constructor(
    private val embedding: JsonField<List<Float>>,
    private val embeddingValue: JsonField<EmbeddingValue>?,
    private val index: JsonField<Long>,
    private val object_: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("embedding")
        @ExcludeMissing
        embedding: JsonField<EmbeddingValue> = JsonMissing.of(),
        @JsonProperty("index") @ExcludeMissing index: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
    ) : this(
        JsonMissing.of(), // Legacy embedding field will be populated from embeddingValue
        embedding,
        index,
        object_,
        mutableMapOf(),
    )

    /**
     * The embedding vector, which is a list of floats. The length of vector depends on the model as
     * listed in the [embedding guide](https://platform.openai.com/docs/guides/embeddings).
     *
     * Important: When Base64 data is received, it is automatically decoded and returned as
     * List<Float>
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun embedding(): List<Float> =
        when {
            embeddingValue != null ->
                embeddingValue.getRequired("embedding").asFloats() // Base64→Float auto conversion
            !embedding.isMissing() ->
                embedding.getRequired("embedding") // Original Float format data
            else -> throw OpenAIInvalidDataException("Embedding data is missing")
        }

    /**
     * The embedding data in its original format (either float list or base64 string). This method
     * provides efficient access to the embedding data without unnecessary conversions.
     *
     * @return EmbeddingValue containing the embedding data in its original format
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun embeddingValue(): EmbeddingValue =
        when {
            embeddingValue != null -> embeddingValue.getRequired("embedding")
            !embedding.isMissing() -> EmbeddingValue.ofFloats(embedding.getRequired("embedding"))
            else -> throw OpenAIInvalidDataException("Embedding data is missing")
        }

    /**
     * The index of the embedding in the list of embeddings.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun index(): Long = index.getRequired("index")

    /**
     * The object type, which is always "embedding".
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("embedding")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * Returns the raw JSON value of [embedding].
     *
     * Unlike [embedding], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("embedding")
    @ExcludeMissing
    fun _embedding(): JsonField<EmbeddingValue> =
        when {
            embeddingValue != null -> embeddingValue
            !embedding.isMissing() ->
                JsonField.of(EmbeddingValue.ofFloats(embedding.getRequired("embedding")))
            else -> JsonMissing.of()
        }

    /**
     * Returns the raw JSON value of [index].
     *
     * Unlike [index], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("index") @ExcludeMissing fun _index(): JsonField<Long> = index

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
         * Returns a mutable builder for constructing an instance of [Embedding].
         *
         * The following fields are required:
         * ```java
         * .embedding()
         * .index()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Embedding]. */
    class Builder internal constructor() {

        private var embedding: JsonField<MutableList<Float>>? = null
        private var index: JsonField<Long>? = null
        private var object_: JsonValue = JsonValue.from("embedding")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(embedding: Embedding) = apply {
            try {
                this.embedding = JsonField.of(embedding.embedding().toMutableList())
            } catch (e: Exception) {
                // Fallback to field-level copying if embedding() method fails
                this.embedding = embedding.embedding.map { it.toMutableList() }
            }
            index = embedding.index
            object_ = embedding.object_
            additionalProperties = embedding.additionalProperties.toMutableMap()
        }

        /**
         * The embedding vector, which is a list of floats. The length of vector depends on the
         * model as listed in the
         * [embedding guide](https://platform.openai.com/docs/guides/embeddings).
         */
        fun embedding(embedding: List<Float>) = embedding(JsonField.of(embedding))

        /**
         * Sets [Builder.embedding] to an arbitrary JSON value.
         *
         * You should usually call [Builder.embedding] with a well-typed `List<Float>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun embedding(embedding: JsonField<List<Float>>) = apply {
            this.embedding = embedding.map { it.toMutableList() }
        }

        /**
         * Adds a single [Float] to [Builder.embedding].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addEmbedding(embedding: Float) = apply {
            this.embedding =
                (this.embedding ?: JsonField.of(mutableListOf())).also {
                    checkKnown("embedding", it).add(embedding)
                }
        }

        /** The index of the embedding in the list of embeddings. */
        fun index(index: Long) = index(JsonField.of(index))

        /**
         * Sets [Builder.index] to an arbitrary JSON value.
         *
         * You should usually call [Builder.index] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun index(index: JsonField<Long>) = apply { this.index = index }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("embedding")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

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
         * Returns an immutable instance of [Embedding].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .embedding()
         * .index()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Embedding =
            Embedding(
                checkRequired("embedding", embedding).map { it.toImmutable() },
                null, // embeddingValue - will be null for builder-created instances
                checkRequired("index", index),
                object_,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Embedding = apply {
        if (validated) {
            return@apply
        }

        embedding() // This will call the method that returns List<Float>
        index()
        _object_().let {
            if (it != JsonValue.from("embedding")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
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
    internal fun validity(): Int =
        when {
            embeddingValue != null -> embeddingValue.asKnown().getOrNull()?.validity() ?: 0
            !embedding.isMissing() -> embedding.asKnown().getOrNull()?.size ?: 0
            else -> 0
        } +
            (if (index.asKnown().isPresent) 1 else 0) +
            object_.let { if (it == JsonValue.from("embedding")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        if (other !is Embedding) {
            return false
        }

        return try {
            embedding() == other.embedding() &&
                index == other.index &&
                object_ == other.object_ &&
                additionalProperties == other.additionalProperties
        } catch (e: Exception) {
            // Fallback to field-level comparison if embedding() methods fail
            embedding == other.embedding &&
                embeddingValue == other.embeddingValue &&
                index == other.index &&
                object_ == other.object_ &&
                additionalProperties == other.additionalProperties
        }
    }

    /* spotless:off */
    private val hashCode: Int by lazy { 
        try {
            Objects.hash(embedding(), index, object_, additionalProperties)
        } catch (e: Exception) {
            // Fallback to field-level hashing if embedding() method fails
            Objects.hash(embedding, embeddingValue, index, object_, additionalProperties)
        }
    }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        when {
            embeddingValue != null ->
                "Embedding{embedding=${try { embedding() } catch (e: Exception) { "[]" }}, index=$index, object_=$object_, additionalProperties=$additionalProperties}"
            else ->
                "Embedding{embedding=${embedding.asKnown().getOrNull() ?: emptyList<Float>()}, index=$index, object_=$object_, additionalProperties=$additionalProperties}"
        }
}
