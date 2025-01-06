// File generated from our OpenAPI spec by Stainless.

package com.openai.models

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
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects

/** Represents an embedding vector returned by embedding endpoint. */
@NoAutoDetect
class Embedding
@JsonCreator
private constructor(
    @JsonProperty("embedding")
    @ExcludeMissing
    private val embedding: JsonField<List<Double>> = JsonMissing.of(),
    @JsonProperty("index") @ExcludeMissing private val index: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("object")
    @ExcludeMissing
    private val object_: JsonField<Object> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * The embedding vector, which is a list of floats. The length of vector depends on the model as
     * listed in the [embedding guide](https://platform.openai.com/docs/guides/embeddings).
     */
    fun embedding(): List<Double> = embedding.getRequired("embedding")

    /** The index of the embedding in the list of embeddings. */
    fun index(): Long = index.getRequired("index")

    /** The object type, which is always "embedding". */
    fun object_(): Object = object_.getRequired("object")

    /**
     * The embedding vector, which is a list of floats. The length of vector depends on the model as
     * listed in the [embedding guide](https://platform.openai.com/docs/guides/embeddings).
     */
    @JsonProperty("embedding") @ExcludeMissing fun _embedding() = embedding

    /** The index of the embedding in the list of embeddings. */
    @JsonProperty("index") @ExcludeMissing fun _index() = index

    /** The object type, which is always "embedding". */
    @JsonProperty("object") @ExcludeMissing fun _object_() = object_

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): Embedding = apply {
        if (!validated) {
            embedding()
            index()
            object_()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var embedding: JsonField<List<Double>> = JsonMissing.of()
        private var index: JsonField<Long> = JsonMissing.of()
        private var object_: JsonField<Object> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(embedding: Embedding) = apply {
            this.embedding = embedding.embedding
            index = embedding.index
            object_ = embedding.object_
            additionalProperties = embedding.additionalProperties.toMutableMap()
        }

        /**
         * The embedding vector, which is a list of floats. The length of vector depends on the
         * model as listed in the
         * [embedding guide](https://platform.openai.com/docs/guides/embeddings).
         */
        fun embedding(embedding: List<Double>) = embedding(JsonField.of(embedding))

        /**
         * The embedding vector, which is a list of floats. The length of vector depends on the
         * model as listed in the
         * [embedding guide](https://platform.openai.com/docs/guides/embeddings).
         */
        fun embedding(embedding: JsonField<List<Double>>) = apply { this.embedding = embedding }

        /** The index of the embedding in the list of embeddings. */
        fun index(index: Long) = index(JsonField.of(index))

        /** The index of the embedding in the list of embeddings. */
        fun index(index: JsonField<Long>) = apply { this.index = index }

        /** The object type, which is always "embedding". */
        fun object_(object_: Object) = object_(JsonField.of(object_))

        /** The object type, which is always "embedding". */
        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

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
                embedding.map { it.toImmutable() },
                index,
                object_,
                additionalProperties.toImmutable(),
            )
    }

    class Object
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val EMBEDDING = of("embedding")

            @JvmStatic fun of(value: String) = Object(JsonField.of(value))
        }

        enum class Known {
            EMBEDDING,
        }

        enum class Value {
            EMBEDDING,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                EMBEDDING -> Value.EMBEDDING
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                EMBEDDING -> Known.EMBEDDING
                else -> throw OpenAIInvalidDataException("Unknown Object: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Object && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
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
