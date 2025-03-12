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
import com.openai.core.NoAutoDetect
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/** Represents an embedding vector returned by embedding endpoint. */
@NoAutoDetect
class Embedding
@JsonCreator
private constructor(
    @JsonProperty("embedding")
    @ExcludeMissing
    private val embedding: JsonField<EmbeddingValue> = JsonMissing.of(),
    @JsonProperty("index") @ExcludeMissing private val index: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("object") @ExcludeMissing private val object_: JsonValue = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * The embedding vector, which is a list of floats. The length of vector depends on the model as
     * listed in the [embedding guide](https://platform.openai.com/docs/guides/embeddings).
     */
    fun embedding(): EmbeddingValue = embedding.getRequired("embedding")

    /** The index of the embedding in the list of embeddings. */
    fun index(): Long = index.getRequired("index")

    /** The object type, which is always "embedding". */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * The embedding vector, which is a list of floats. The length of vector depends on the model as
     * listed in the [embedding guide](https://platform.openai.com/docs/guides/embeddings).
     */
    @JsonProperty("embedding")
    @ExcludeMissing
    fun _embedding(): JsonField<EmbeddingValue> = embedding

    /** The index of the embedding in the list of embeddings. */
    @JsonProperty("index") @ExcludeMissing fun _index(): JsonField<Long> = index

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): Embedding = apply {
        if (validated) {
            return@apply
        }

        embedding()
        index()
        _object_().let {
            if (it != JsonValue.from("embedding")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        validated = true
    }

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

        private var embedding: JsonField<EmbeddingValue>? = null
        private var index: JsonField<Long>? = null
        private var object_: JsonValue = JsonValue.from("embedding")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(embedding: Embedding) = apply {
            this.embedding =
                embedding.embedding.map {
                    EmbeddingValue(
                        floatEmbedding =
                            Optional.of(it.floatEmbedding.orElse(mutableListOf()).toMutableList()),
                        base64Embedding = it.base64Embedding,
                    )
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
        fun embedding(embedding: EmbeddingValue) = embedding(JsonField.of(embedding))

        /**
         * The embedding vector, which is a list of floats or Base64. The float length of vector
         * depends on the model as listed in the
         * [embedding guide](https://platform.openai.com/docs/guides/embeddings).
         */
        fun embedding(embedding: JsonField<EmbeddingValue>) = apply {
            this.embedding =
                embedding.map {
                    EmbeddingValue(
                        floatEmbedding =
                            Optional.of(it.floatEmbedding.orElse(mutableListOf()).toMutableList()),
                        base64Embedding = it.base64Embedding,
                    )
                }
        }

        /**
         * The embedding vector, which is a list of floats or Base64. The float length of vector
         * depends on the model as listed in the
         * [embedding guide](https://platform.openai.com/docs/guides/embeddings).
         */
        fun addEmbedding(embedding: EmbeddingValue) = apply {
            this.embedding =
                (this.embedding ?: JsonField.of(embedding)).also { checkKnown("embedding", it) }
        }

        /** The index of the embedding in the list of embeddings. */
        fun index(index: Long) = index(JsonField.of(index))

        /** The index of the embedding in the list of embeddings. */
        fun index(index: JsonField<Long>) = apply { this.index = index }

        /** The object type, which is always "embedding". */
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

        fun build(): Embedding =
            Embedding(
                checkRequired("embedding", embedding).map {
                    EmbeddingValue(
                        floatEmbedding =
                            Optional.of(it.floatEmbedding.orElse(mutableListOf()).toMutableList()),
                        base64Embedding = it.base64Embedding,
                    )
                },
                checkRequired("index", index),
                object_,
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is Embedding && embedding == other.embedding && index == other.index && object_ == other.object_ && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(embedding, index, object_, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Embedding{embedding=$embedding, index=$index, object_=$object_, additionalProperties=$additionalProperties}"
}
