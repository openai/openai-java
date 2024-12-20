// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects

/** Represents an embedding vector returned by embedding endpoint. */
@JsonDeserialize(builder = Embedding.Builder::class)
@NoAutoDetect
class Embedding
private constructor(
    private val index: JsonField<Long>,
    private val embedding: JsonField<List<Double>>,
    private val object_: JsonField<Object>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    /** The index of the embedding in the list of embeddings. */
    fun index(): Long = index.getRequired("index")

    /**
     * The embedding vector, which is a list of floats. The length of vector depends on the model as
     * listed in the [embedding guide](https://platform.openai.com/docs/guides/embeddings).
     */
    fun embedding(): List<Double> = embedding.getRequired("embedding")

    /** The object type, which is always "embedding". */
    fun object_(): Object = object_.getRequired("object")

    /** The index of the embedding in the list of embeddings. */
    @JsonProperty("index") @ExcludeMissing fun _index() = index

    /**
     * The embedding vector, which is a list of floats. The length of vector depends on the model as
     * listed in the [embedding guide](https://platform.openai.com/docs/guides/embeddings).
     */
    @JsonProperty("embedding") @ExcludeMissing fun _embedding() = embedding

    /** The object type, which is always "embedding". */
    @JsonProperty("object") @ExcludeMissing fun _object_() = object_

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): Embedding = apply {
        if (!validated) {
            index()
            embedding()
            object_()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var index: JsonField<Long> = JsonMissing.of()
        private var embedding: JsonField<List<Double>> = JsonMissing.of()
        private var object_: JsonField<Object> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(embedding: Embedding) = apply {
            index = embedding.index
            this.embedding = embedding.embedding
            object_ = embedding.object_
            additionalProperties = embedding.additionalProperties.toMutableMap()
        }

        /** The index of the embedding in the list of embeddings. */
        fun index(index: Long) = index(JsonField.of(index))

        /** The index of the embedding in the list of embeddings. */
        @JsonProperty("index")
        @ExcludeMissing
        fun index(index: JsonField<Long>) = apply { this.index = index }

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
        @JsonProperty("embedding")
        @ExcludeMissing
        fun embedding(embedding: JsonField<List<Double>>) = apply { this.embedding = embedding }

        /** The object type, which is always "embedding". */
        fun object_(object_: Object) = object_(JsonField.of(object_))

        /** The object type, which is always "embedding". */
        @JsonProperty("object")
        @ExcludeMissing
        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        @JsonAnySetter
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
                index,
                embedding.map { it.toImmutable() },
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

        return /* spotless:off */ other is Embedding && index == other.index && embedding == other.embedding && object_ == other.object_ && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(index, embedding, object_, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Embedding{index=$index, embedding=$embedding, object_=$object_, additionalProperties=$additionalProperties}"
}
