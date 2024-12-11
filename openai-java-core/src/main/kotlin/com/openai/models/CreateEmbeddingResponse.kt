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

@JsonDeserialize(builder = CreateEmbeddingResponse.Builder::class)
@NoAutoDetect
class CreateEmbeddingResponse
private constructor(
    private val data: JsonField<List<Embedding>>,
    private val model: JsonField<String>,
    private val object_: JsonField<Object>,
    private val usage: JsonField<Usage>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    /** The list of embeddings generated by the model. */
    fun data(): List<Embedding> = data.getRequired("data")

    /** The name of the model used to generate the embedding. */
    fun model(): String = model.getRequired("model")

    /** The object type, which is always "list". */
    fun object_(): Object = object_.getRequired("object")

    /** The usage information for the request. */
    fun usage(): Usage = usage.getRequired("usage")

    /** The list of embeddings generated by the model. */
    @JsonProperty("data") @ExcludeMissing fun _data() = data

    /** The name of the model used to generate the embedding. */
    @JsonProperty("model") @ExcludeMissing fun _model() = model

    /** The object type, which is always "list". */
    @JsonProperty("object") @ExcludeMissing fun _object_() = object_

    /** The usage information for the request. */
    @JsonProperty("usage") @ExcludeMissing fun _usage() = usage

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): CreateEmbeddingResponse = apply {
        if (!validated) {
            data().forEach { it.validate() }
            model()
            object_()
            usage().validate()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var data: JsonField<List<Embedding>> = JsonMissing.of()
        private var model: JsonField<String> = JsonMissing.of()
        private var object_: JsonField<Object> = JsonMissing.of()
        private var usage: JsonField<Usage> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(createEmbeddingResponse: CreateEmbeddingResponse) = apply {
            this.data = createEmbeddingResponse.data
            this.model = createEmbeddingResponse.model
            this.object_ = createEmbeddingResponse.object_
            this.usage = createEmbeddingResponse.usage
            additionalProperties(createEmbeddingResponse.additionalProperties)
        }

        /** The list of embeddings generated by the model. */
        fun data(data: List<Embedding>) = data(JsonField.of(data))

        /** The list of embeddings generated by the model. */
        @JsonProperty("data")
        @ExcludeMissing
        fun data(data: JsonField<List<Embedding>>) = apply { this.data = data }

        /** The name of the model used to generate the embedding. */
        fun model(model: String) = model(JsonField.of(model))

        /** The name of the model used to generate the embedding. */
        @JsonProperty("model")
        @ExcludeMissing
        fun model(model: JsonField<String>) = apply { this.model = model }

        /** The object type, which is always "list". */
        fun object_(object_: Object) = object_(JsonField.of(object_))

        /** The object type, which is always "list". */
        @JsonProperty("object")
        @ExcludeMissing
        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

        /** The usage information for the request. */
        fun usage(usage: Usage) = usage(JsonField.of(usage))

        /** The usage information for the request. */
        @JsonProperty("usage")
        @ExcludeMissing
        fun usage(usage: JsonField<Usage>) = apply { this.usage = usage }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            this.additionalProperties.putAll(additionalProperties)
        }

        @JsonAnySetter
        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            this.additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun build(): CreateEmbeddingResponse =
            CreateEmbeddingResponse(
                data.map { it.toImmutable() },
                model,
                object_,
                usage,
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

            @JvmField val LIST = of("list")

            @JvmStatic fun of(value: String) = Object(JsonField.of(value))
        }

        enum class Known {
            LIST,
        }

        enum class Value {
            LIST,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                LIST -> Value.LIST
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                LIST -> Known.LIST
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

    /** The usage information for the request. */
    @JsonDeserialize(builder = Usage.Builder::class)
    @NoAutoDetect
    class Usage
    private constructor(
        private val promptTokens: JsonField<Long>,
        private val totalTokens: JsonField<Long>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        /** The number of tokens used by the prompt. */
        fun promptTokens(): Long = promptTokens.getRequired("prompt_tokens")

        /** The total number of tokens used by the request. */
        fun totalTokens(): Long = totalTokens.getRequired("total_tokens")

        /** The number of tokens used by the prompt. */
        @JsonProperty("prompt_tokens") @ExcludeMissing fun _promptTokens() = promptTokens

        /** The total number of tokens used by the request. */
        @JsonProperty("total_tokens") @ExcludeMissing fun _totalTokens() = totalTokens

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): Usage = apply {
            if (!validated) {
                promptTokens()
                totalTokens()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var promptTokens: JsonField<Long> = JsonMissing.of()
            private var totalTokens: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(usage: Usage) = apply {
                this.promptTokens = usage.promptTokens
                this.totalTokens = usage.totalTokens
                additionalProperties(usage.additionalProperties)
            }

            /** The number of tokens used by the prompt. */
            fun promptTokens(promptTokens: Long) = promptTokens(JsonField.of(promptTokens))

            /** The number of tokens used by the prompt. */
            @JsonProperty("prompt_tokens")
            @ExcludeMissing
            fun promptTokens(promptTokens: JsonField<Long>) = apply {
                this.promptTokens = promptTokens
            }

            /** The total number of tokens used by the request. */
            fun totalTokens(totalTokens: Long) = totalTokens(JsonField.of(totalTokens))

            /** The total number of tokens used by the request. */
            @JsonProperty("total_tokens")
            @ExcludeMissing
            fun totalTokens(totalTokens: JsonField<Long>) = apply { this.totalTokens = totalTokens }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                this.additionalProperties.putAll(additionalProperties)
            }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun build(): Usage =
                Usage(
                    promptTokens,
                    totalTokens,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Usage && promptTokens == other.promptTokens && totalTokens == other.totalTokens && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(promptTokens, totalTokens, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Usage{promptTokens=$promptTokens, totalTokens=$totalTokens, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is CreateEmbeddingResponse && data == other.data && model == other.model && object_ == other.object_ && usage == other.usage && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(data, model, object_, usage, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CreateEmbeddingResponse{data=$data, model=$model, object_=$object_, usage=$usage, additionalProperties=$additionalProperties}"
}
