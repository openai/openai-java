// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.getOrThrow
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.*
import java.util.Objects
import java.util.Optional

class EmbeddingCreateParams
constructor(
    private val input: Input,
    private val model: EmbeddingModel,
    private val dimensions: Long?,
    private val encodingFormat: EncodingFormat?,
    private val user: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun input(): Input = input

    fun model(): EmbeddingModel = model

    fun dimensions(): Optional<Long> = Optional.ofNullable(dimensions)

    fun encodingFormat(): Optional<EncodingFormat> = Optional.ofNullable(encodingFormat)

    fun user(): Optional<String> = Optional.ofNullable(user)

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun _additionalBodyProperties(): Map<String, JsonValue> = additionalBodyProperties

    @JvmSynthetic
    internal fun getBody(): EmbeddingCreateBody {
        return EmbeddingCreateBody(
            input,
            model,
            dimensions,
            encodingFormat,
            user,
            additionalBodyProperties,
        )
    }

    @JvmSynthetic internal fun getHeaders(): Headers = additionalHeaders

    @JvmSynthetic internal fun getQueryParams(): QueryParams = additionalQueryParams

    @JsonDeserialize(builder = EmbeddingCreateBody.Builder::class)
    @NoAutoDetect
    class EmbeddingCreateBody
    internal constructor(
        private val input: Input?,
        private val model: EmbeddingModel?,
        private val dimensions: Long?,
        private val encodingFormat: EncodingFormat?,
        private val user: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        /**
         * Input text to embed, encoded as a string or array of tokens. To embed multiple inputs in
         * a single request, pass an array of strings or array of token arrays. The input must not
         * exceed the max input tokens for the model (8192 tokens for `text-embedding-ada-002`),
         * cannot be an empty string, and any array must be 2048 dimensions or less.
         * [Example Python code](https://cookbook.openai.com/examples/how_to_count_tokens_with_tiktoken)
         * for counting tokens.
         */
        @JsonProperty("input") fun input(): Input? = input

        /**
         * ID of the model to use. You can use the
         * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see all
         * of your available models, or see our
         * [Model overview](https://platform.openai.com/docs/models) for descriptions of them.
         */
        @JsonProperty("model") fun model(): EmbeddingModel? = model

        /**
         * The number of dimensions the resulting output embeddings should have. Only supported in
         * `text-embedding-3` and later models.
         */
        @JsonProperty("dimensions") fun dimensions(): Long? = dimensions

        /**
         * The format to return the embeddings in. Can be either `float` or
         * [`base64`](https://pypi.org/project/pybase64/).
         */
        @JsonProperty("encoding_format") fun encodingFormat(): EncodingFormat? = encodingFormat

        /**
         * A unique identifier representing your end-user, which can help OpenAI to monitor and
         * detect abuse.
         * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
         */
        @JsonProperty("user") fun user(): String? = user

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var input: Input? = null
            private var model: EmbeddingModel? = null
            private var dimensions: Long? = null
            private var encodingFormat: EncodingFormat? = null
            private var user: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(embeddingCreateBody: EmbeddingCreateBody) = apply {
                this.input = embeddingCreateBody.input
                this.model = embeddingCreateBody.model
                this.dimensions = embeddingCreateBody.dimensions
                this.encodingFormat = embeddingCreateBody.encodingFormat
                this.user = embeddingCreateBody.user
                additionalProperties(embeddingCreateBody.additionalProperties)
            }

            /**
             * Input text to embed, encoded as a string or array of tokens. To embed multiple inputs
             * in a single request, pass an array of strings or array of token arrays. The input
             * must not exceed the max input tokens for the model (8192 tokens for
             * `text-embedding-ada-002`), cannot be an empty string, and any array must be 2048
             * dimensions or less.
             * [Example Python code](https://cookbook.openai.com/examples/how_to_count_tokens_with_tiktoken)
             * for counting tokens.
             */
            @JsonProperty("input") fun input(input: Input) = apply { this.input = input }

            /**
             * ID of the model to use. You can use the
             * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see
             * all of your available models, or see our
             * [Model overview](https://platform.openai.com/docs/models) for descriptions of them.
             */
            @JsonProperty("model") fun model(model: EmbeddingModel) = apply { this.model = model }

            /**
             * The number of dimensions the resulting output embeddings should have. Only supported
             * in `text-embedding-3` and later models.
             */
            @JsonProperty("dimensions")
            fun dimensions(dimensions: Long) = apply { this.dimensions = dimensions }

            /**
             * The format to return the embeddings in. Can be either `float` or
             * [`base64`](https://pypi.org/project/pybase64/).
             */
            @JsonProperty("encoding_format")
            fun encodingFormat(encodingFormat: EncodingFormat) = apply {
                this.encodingFormat = encodingFormat
            }

            /**
             * A unique identifier representing your end-user, which can help OpenAI to monitor and
             * detect abuse.
             * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
             */
            @JsonProperty("user") fun user(user: String) = apply { this.user = user }

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

            fun build(): EmbeddingCreateBody =
                EmbeddingCreateBody(
                    checkNotNull(input) { "`input` is required but was not set" },
                    checkNotNull(model) { "`model` is required but was not set" },
                    dimensions,
                    encodingFormat,
                    user,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is EmbeddingCreateBody && input == other.input && model == other.model && dimensions == other.dimensions && encodingFormat == other.encodingFormat && user == other.user && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(input, model, dimensions, encodingFormat, user, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "EmbeddingCreateBody{input=$input, model=$model, dimensions=$dimensions, encodingFormat=$encodingFormat, user=$user, additionalProperties=$additionalProperties}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var input: Input? = null
        private var model: EmbeddingModel? = null
        private var dimensions: Long? = null
        private var encodingFormat: EncodingFormat? = null
        private var user: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(embeddingCreateParams: EmbeddingCreateParams) = apply {
            input = embeddingCreateParams.input
            model = embeddingCreateParams.model
            dimensions = embeddingCreateParams.dimensions
            encodingFormat = embeddingCreateParams.encodingFormat
            user = embeddingCreateParams.user
            additionalHeaders = embeddingCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = embeddingCreateParams.additionalQueryParams.toBuilder()
            additionalBodyProperties = embeddingCreateParams.additionalBodyProperties.toMutableMap()
        }

        /**
         * Input text to embed, encoded as a string or array of tokens. To embed multiple inputs in
         * a single request, pass an array of strings or array of token arrays. The input must not
         * exceed the max input tokens for the model (8192 tokens for `text-embedding-ada-002`),
         * cannot be an empty string, and any array must be 2048 dimensions or less.
         * [Example Python code](https://cookbook.openai.com/examples/how_to_count_tokens_with_tiktoken)
         * for counting tokens.
         */
        fun input(input: Input) = apply { this.input = input }

        /**
         * Input text to embed, encoded as a string or array of tokens. To embed multiple inputs in
         * a single request, pass an array of strings or array of token arrays. The input must not
         * exceed the max input tokens for the model (8192 tokens for `text-embedding-ada-002`),
         * cannot be an empty string, and any array must be 2048 dimensions or less.
         * [Example Python code](https://cookbook.openai.com/examples/how_to_count_tokens_with_tiktoken)
         * for counting tokens.
         */
        fun input(string: String) = apply { this.input = Input.ofString(string) }

        /**
         * Input text to embed, encoded as a string or array of tokens. To embed multiple inputs in
         * a single request, pass an array of strings or array of token arrays. The input must not
         * exceed the max input tokens for the model (8192 tokens for `text-embedding-ada-002`),
         * cannot be an empty string, and any array must be 2048 dimensions or less.
         * [Example Python code](https://cookbook.openai.com/examples/how_to_count_tokens_with_tiktoken)
         * for counting tokens.
         */
        fun inputOfArrayOfStrings(arrayOfStrings: List<String>) = apply {
            this.input = Input.ofArrayOfStrings(arrayOfStrings)
        }

        /**
         * Input text to embed, encoded as a string or array of tokens. To embed multiple inputs in
         * a single request, pass an array of strings or array of token arrays. The input must not
         * exceed the max input tokens for the model (8192 tokens for `text-embedding-ada-002`),
         * cannot be an empty string, and any array must be 2048 dimensions or less.
         * [Example Python code](https://cookbook.openai.com/examples/how_to_count_tokens_with_tiktoken)
         * for counting tokens.
         */
        fun inputOfArrayOfTokens(arrayOfTokens: List<Long>) = apply {
            this.input = Input.ofArrayOfTokens(arrayOfTokens)
        }

        /**
         * Input text to embed, encoded as a string or array of tokens. To embed multiple inputs in
         * a single request, pass an array of strings or array of token arrays. The input must not
         * exceed the max input tokens for the model (8192 tokens for `text-embedding-ada-002`),
         * cannot be an empty string, and any array must be 2048 dimensions or less.
         * [Example Python code](https://cookbook.openai.com/examples/how_to_count_tokens_with_tiktoken)
         * for counting tokens.
         */
        fun inputOfArrayOfTokenArrays(arrayOfTokenArrays: List<List<Long>>) = apply {
            this.input = Input.ofArrayOfTokenArrays(arrayOfTokenArrays)
        }

        /**
         * ID of the model to use. You can use the
         * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see all
         * of your available models, or see our
         * [Model overview](https://platform.openai.com/docs/models) for descriptions of them.
         */
        fun model(model: EmbeddingModel) = apply { this.model = model }

        /**
         * ID of the model to use. You can use the
         * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see all
         * of your available models, or see our
         * [Model overview](https://platform.openai.com/docs/models) for descriptions of them.
         */
        fun model(value: String) = apply { this.model = EmbeddingModel.of(value) }

        /**
         * The number of dimensions the resulting output embeddings should have. Only supported in
         * `text-embedding-3` and later models.
         */
        fun dimensions(dimensions: Long) = apply { this.dimensions = dimensions }

        /**
         * The format to return the embeddings in. Can be either `float` or
         * [`base64`](https://pypi.org/project/pybase64/).
         */
        fun encodingFormat(encodingFormat: EncodingFormat) = apply {
            this.encodingFormat = encodingFormat
        }

        /**
         * A unique identifier representing your end-user, which can help OpenAI to monitor and
         * detect abuse.
         * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
         */
        fun user(user: String) = apply { this.user = user }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            this.additionalBodyProperties.clear()
            putAllAdditionalBodyProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            additionalBodyProperties.put(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                this.additionalBodyProperties.putAll(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply {
            additionalBodyProperties.remove(key)
        }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalBodyProperty)
        }

        fun build(): EmbeddingCreateParams =
            EmbeddingCreateParams(
                checkNotNull(input) { "`input` is required but was not set" },
                checkNotNull(model) { "`model` is required but was not set" },
                dimensions,
                encodingFormat,
                user,
                additionalHeaders.build(),
                additionalQueryParams.build(),
                additionalBodyProperties.toImmutable(),
            )
    }

    @JsonDeserialize(using = Input.Deserializer::class)
    @JsonSerialize(using = Input.Serializer::class)
    class Input
    private constructor(
        private val string: String? = null,
        private val arrayOfStrings: List<String>? = null,
        private val arrayOfTokens: List<Long>? = null,
        private val arrayOfTokenArrays: List<List<Long>>? = null,
        private val _json: JsonValue? = null,
    ) {

        private var validated: Boolean = false

        /** The string that will be turned into an embedding. */
        fun string(): Optional<String> = Optional.ofNullable(string)
        /** The array of strings that will be turned into an embedding. */
        fun arrayOfStrings(): Optional<List<String>> = Optional.ofNullable(arrayOfStrings)
        /** The array of integers that will be turned into an embedding. */
        fun arrayOfTokens(): Optional<List<Long>> = Optional.ofNullable(arrayOfTokens)
        /** The array of arrays containing integers that will be turned into an embedding. */
        fun arrayOfTokenArrays(): Optional<List<List<Long>>> =
            Optional.ofNullable(arrayOfTokenArrays)

        fun isString(): Boolean = string != null

        fun isArrayOfStrings(): Boolean = arrayOfStrings != null

        fun isArrayOfTokens(): Boolean = arrayOfTokens != null

        fun isArrayOfTokenArrays(): Boolean = arrayOfTokenArrays != null

        fun asString(): String = string.getOrThrow("string")

        fun asArrayOfStrings(): List<String> = arrayOfStrings.getOrThrow("arrayOfStrings")

        fun asArrayOfTokens(): List<Long> = arrayOfTokens.getOrThrow("arrayOfTokens")

        fun asArrayOfTokenArrays(): List<List<Long>> =
            arrayOfTokenArrays.getOrThrow("arrayOfTokenArrays")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                string != null -> visitor.visitString(string)
                arrayOfStrings != null -> visitor.visitArrayOfStrings(arrayOfStrings)
                arrayOfTokens != null -> visitor.visitArrayOfTokens(arrayOfTokens)
                arrayOfTokenArrays != null -> visitor.visitArrayOfTokenArrays(arrayOfTokenArrays)
                else -> visitor.unknown(_json)
            }
        }

        fun validate(): Input = apply {
            if (!validated) {
                if (
                    string == null &&
                        arrayOfStrings == null &&
                        arrayOfTokens == null &&
                        arrayOfTokenArrays == null
                ) {
                    throw OpenAIInvalidDataException("Unknown Input: $_json")
                }
                validated = true
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Input && string == other.string && arrayOfStrings == other.arrayOfStrings && arrayOfTokens == other.arrayOfTokens && arrayOfTokenArrays == other.arrayOfTokenArrays /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(string, arrayOfStrings, arrayOfTokens, arrayOfTokenArrays) /* spotless:on */

        override fun toString(): String =
            when {
                string != null -> "Input{string=$string}"
                arrayOfStrings != null -> "Input{arrayOfStrings=$arrayOfStrings}"
                arrayOfTokens != null -> "Input{arrayOfTokens=$arrayOfTokens}"
                arrayOfTokenArrays != null -> "Input{arrayOfTokenArrays=$arrayOfTokenArrays}"
                _json != null -> "Input{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Input")
            }

        companion object {

            @JvmStatic fun ofString(string: String) = Input(string = string)

            @JvmStatic
            fun ofArrayOfStrings(arrayOfStrings: List<String>) =
                Input(arrayOfStrings = arrayOfStrings)

            @JvmStatic
            fun ofArrayOfTokens(arrayOfTokens: List<Long>) = Input(arrayOfTokens = arrayOfTokens)

            @JvmStatic
            fun ofArrayOfTokenArrays(arrayOfTokenArrays: List<List<Long>>) =
                Input(arrayOfTokenArrays = arrayOfTokenArrays)
        }

        interface Visitor<out T> {

            fun visitString(string: String): T

            fun visitArrayOfStrings(arrayOfStrings: List<String>): T

            fun visitArrayOfTokens(arrayOfTokens: List<Long>): T

            fun visitArrayOfTokenArrays(arrayOfTokenArrays: List<List<Long>>): T

            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Input: $json")
            }
        }

        class Deserializer : BaseDeserializer<Input>(Input::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Input {
                val json = JsonValue.fromJsonNode(node)

                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                    return Input(string = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<List<String>>())?.let {
                    return Input(arrayOfStrings = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<List<Long>>())?.let {
                    return Input(arrayOfTokens = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<List<List<Long>>>())?.let {
                    return Input(arrayOfTokenArrays = it, _json = json)
                }

                return Input(_json = json)
            }
        }

        class Serializer : BaseSerializer<Input>(Input::class) {

            override fun serialize(
                value: Input,
                generator: JsonGenerator,
                provider: SerializerProvider
            ) {
                when {
                    value.string != null -> generator.writeObject(value.string)
                    value.arrayOfStrings != null -> generator.writeObject(value.arrayOfStrings)
                    value.arrayOfTokens != null -> generator.writeObject(value.arrayOfTokens)
                    value.arrayOfTokenArrays != null ->
                        generator.writeObject(value.arrayOfTokenArrays)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Input")
                }
            }
        }
    }

    class EncodingFormat
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val FLOAT = of("float")

            @JvmField val BASE64 = of("base64")

            @JvmStatic fun of(value: String) = EncodingFormat(JsonField.of(value))
        }

        enum class Known {
            FLOAT,
            BASE64,
        }

        enum class Value {
            FLOAT,
            BASE64,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                FLOAT -> Value.FLOAT
                BASE64 -> Value.BASE64
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                FLOAT -> Known.FLOAT
                BASE64 -> Known.BASE64
                else -> throw OpenAIInvalidDataException("Unknown EncodingFormat: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is EncodingFormat && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is EmbeddingCreateParams && input == other.input && model == other.model && dimensions == other.dimensions && encodingFormat == other.encodingFormat && user == other.user && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams && additionalBodyProperties == other.additionalBodyProperties /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(input, model, dimensions, encodingFormat, user, additionalHeaders, additionalQueryParams, additionalBodyProperties) /* spotless:on */

    override fun toString() =
        "EmbeddingCreateParams{input=$input, model=$model, dimensions=$dimensions, encodingFormat=$encodingFormat, user=$user, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams, additionalBodyProperties=$additionalBodyProperties}"
}
