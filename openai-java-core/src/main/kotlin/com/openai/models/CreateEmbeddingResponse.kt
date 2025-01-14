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
import com.openai.core.checkRequired
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects

@NoAutoDetect
class CreateEmbeddingResponse
@JsonCreator
private constructor(
    @JsonProperty("data")
    @ExcludeMissing
    private val data: JsonField<List<Embedding>> = JsonMissing.of(),
    @JsonProperty("model") @ExcludeMissing private val model: JsonField<String> = JsonMissing.of(),
    @JsonProperty("object")
    @ExcludeMissing
    private val object_: JsonField<Object> = JsonMissing.of(),
    @JsonProperty("usage") @ExcludeMissing private val usage: JsonField<Usage> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The list of embeddings generated by the model. */
    fun data(): List<Embedding> = data.getRequired("data")

    /** The name of the model used to generate the embedding. */
    fun model(): String = model.getRequired("model")

    /** The object type, which is always "list". */
    fun object_(): Object = object_.getRequired("object")

    /** The usage information for the request. */
    fun usage(): Usage = usage.getRequired("usage")

    /** The list of embeddings generated by the model. */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<List<Embedding>> = data

    /** The name of the model used to generate the embedding. */
    @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

    /** The object type, which is always "list". */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonField<Object> = object_

    /** The usage information for the request. */
    @JsonProperty("usage") @ExcludeMissing fun _usage(): JsonField<Usage> = usage

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): CreateEmbeddingResponse = apply {
        if (validated) {
            return@apply
        }

        data().forEach { it.validate() }
        model()
        object_()
        usage().validate()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var data: JsonField<MutableList<Embedding>>? = null
        private var model: JsonField<String>? = null
        private var object_: JsonField<Object>? = null
        private var usage: JsonField<Usage>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(createEmbeddingResponse: CreateEmbeddingResponse) = apply {
            data = createEmbeddingResponse.data.map { it.toMutableList() }
            model = createEmbeddingResponse.model
            object_ = createEmbeddingResponse.object_
            usage = createEmbeddingResponse.usage
            additionalProperties = createEmbeddingResponse.additionalProperties.toMutableMap()
        }

        /** The list of embeddings generated by the model. */
        fun data(data: List<Embedding>) = data(JsonField.of(data))

        /** The list of embeddings generated by the model. */
        fun data(data: JsonField<List<Embedding>>) = apply {
            this.data = data.map { it.toMutableList() }
        }

        /** The list of embeddings generated by the model. */
        fun addData(data: Embedding) = apply {
            this.data =
                (this.data ?: JsonField.of(mutableListOf())).apply {
                    asKnown()
                        .orElseThrow {
                            IllegalStateException(
                                "Field was set to non-list type: ${javaClass.simpleName}"
                            )
                        }
                        .add(data)
                }
        }

        /** The name of the model used to generate the embedding. */
        fun model(model: String) = model(JsonField.of(model))

        /** The name of the model used to generate the embedding. */
        fun model(model: JsonField<String>) = apply { this.model = model }

        /** The object type, which is always "list". */
        fun object_(object_: Object) = object_(JsonField.of(object_))

        /** The object type, which is always "list". */
        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

        /** The usage information for the request. */
        fun usage(usage: Usage) = usage(JsonField.of(usage))

        /** The usage information for the request. */
        fun usage(usage: JsonField<Usage>) = apply { this.usage = usage }

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

        fun build(): CreateEmbeddingResponse =
            CreateEmbeddingResponse(
                checkRequired("data", data).map { it.toImmutable() },
                checkRequired("model", model),
                checkRequired("object_", object_),
                checkRequired("usage", usage),
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
    @NoAutoDetect
    class Usage
    @JsonCreator
    private constructor(
        @JsonProperty("prompt_tokens")
        @ExcludeMissing
        private val promptTokens: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("total_tokens")
        @ExcludeMissing
        private val totalTokens: JsonField<Long> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The number of tokens used by the prompt. */
        fun promptTokens(): Long = promptTokens.getRequired("prompt_tokens")

        /** The total number of tokens used by the request. */
        fun totalTokens(): Long = totalTokens.getRequired("total_tokens")

        /** The number of tokens used by the prompt. */
        @JsonProperty("prompt_tokens")
        @ExcludeMissing
        fun _promptTokens(): JsonField<Long> = promptTokens

        /** The total number of tokens used by the request. */
        @JsonProperty("total_tokens")
        @ExcludeMissing
        fun _totalTokens(): JsonField<Long> = totalTokens

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Usage = apply {
            if (validated) {
                return@apply
            }

            promptTokens()
            totalTokens()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var promptTokens: JsonField<Long>? = null
            private var totalTokens: JsonField<Long>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(usage: Usage) = apply {
                promptTokens = usage.promptTokens
                totalTokens = usage.totalTokens
                additionalProperties = usage.additionalProperties.toMutableMap()
            }

            /** The number of tokens used by the prompt. */
            fun promptTokens(promptTokens: Long) = promptTokens(JsonField.of(promptTokens))

            /** The number of tokens used by the prompt. */
            fun promptTokens(promptTokens: JsonField<Long>) = apply {
                this.promptTokens = promptTokens
            }

            /** The total number of tokens used by the request. */
            fun totalTokens(totalTokens: Long) = totalTokens(JsonField.of(totalTokens))

            /** The total number of tokens used by the request. */
            fun totalTokens(totalTokens: JsonField<Long>) = apply { this.totalTokens = totalTokens }

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

            fun build(): Usage =
                Usage(
                    checkRequired("promptTokens", promptTokens),
                    checkRequired("totalTokens", totalTokens),
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
