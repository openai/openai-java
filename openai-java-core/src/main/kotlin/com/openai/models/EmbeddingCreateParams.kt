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
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.Params
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/** Creates an embedding vector representing the input text. */
class EmbeddingCreateParams
private constructor(
    private val body: EmbeddingCreateBody,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Input text to embed, encoded as a string or array of tokens. To embed multiple inputs in a
     * single request, pass an array of strings or array of token arrays. The input must not exceed
     * the max input tokens for the model (8192 tokens for `text-embedding-ada-002`), cannot be an
     * empty string, and any array must be 2048 dimensions or less.
     * [Example Python code](https://cookbook.openai.com/examples/how_to_count_tokens_with_tiktoken)
     * for counting tokens. Some models may also impose a limit on total number of tokens summed
     * across inputs.
     */
    fun input(): Input = body.input()

    /**
     * ID of the model to use. You can use the
     * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see all of
     * your available models, or see our [Model overview](https://platform.openai.com/docs/models)
     * for descriptions of them.
     */
    fun model(): EmbeddingModel = body.model()

    /**
     * The number of dimensions the resulting output embeddings should have. Only supported in
     * `text-embedding-3` and later models.
     */
    fun dimensions(): Optional<Long> = body.dimensions()

    /**
     * The format to return the embeddings in. Can be either `float` or
     * [`base64`](https://pypi.org/project/pybase64/).
     */
    fun encodingFormat(): Optional<EncodingFormat> = body.encodingFormat()

    /**
     * A unique identifier representing your end-user, which can help OpenAI to monitor and detect
     * abuse.
     * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
     */
    fun user(): Optional<String> = body.user()

    /**
     * Input text to embed, encoded as a string or array of tokens. To embed multiple inputs in a
     * single request, pass an array of strings or array of token arrays. The input must not exceed
     * the max input tokens for the model (8192 tokens for `text-embedding-ada-002`), cannot be an
     * empty string, and any array must be 2048 dimensions or less.
     * [Example Python code](https://cookbook.openai.com/examples/how_to_count_tokens_with_tiktoken)
     * for counting tokens. Some models may also impose a limit on total number of tokens summed
     * across inputs.
     */
    fun _input(): JsonField<Input> = body._input()

    /**
     * ID of the model to use. You can use the
     * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see all of
     * your available models, or see our [Model overview](https://platform.openai.com/docs/models)
     * for descriptions of them.
     */
    fun _model(): JsonField<EmbeddingModel> = body._model()

    /**
     * The number of dimensions the resulting output embeddings should have. Only supported in
     * `text-embedding-3` and later models.
     */
    fun _dimensions(): JsonField<Long> = body._dimensions()

    /**
     * The format to return the embeddings in. Can be either `float` or
     * [`base64`](https://pypi.org/project/pybase64/).
     */
    fun _encodingFormat(): JsonField<EncodingFormat> = body._encodingFormat()

    /**
     * A unique identifier representing your end-user, which can help OpenAI to monitor and detect
     * abuse.
     * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
     */
    fun _user(): JsonField<String> = body._user()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    @JvmSynthetic internal fun _body(): EmbeddingCreateBody = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    @NoAutoDetect
    class EmbeddingCreateBody
    @JsonCreator
    internal constructor(
        @JsonProperty("input")
        @ExcludeMissing
        private val input: JsonField<Input> = JsonMissing.of(),
        @JsonProperty("model")
        @ExcludeMissing
        private val model: JsonField<EmbeddingModel> = JsonMissing.of(),
        @JsonProperty("dimensions")
        @ExcludeMissing
        private val dimensions: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("encoding_format")
        @ExcludeMissing
        private val encodingFormat: JsonField<EncodingFormat> = JsonMissing.of(),
        @JsonProperty("user")
        @ExcludeMissing
        private val user: JsonField<String> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Input text to embed, encoded as a string or array of tokens. To embed multiple inputs in
         * a single request, pass an array of strings or array of token arrays. The input must not
         * exceed the max input tokens for the model (8192 tokens for `text-embedding-ada-002`),
         * cannot be an empty string, and any array must be 2048 dimensions or less.
         * [Example Python code](https://cookbook.openai.com/examples/how_to_count_tokens_with_tiktoken)
         * for counting tokens. Some models may also impose a limit on total number of tokens summed
         * across inputs.
         */
        fun input(): Input = input.getRequired("input")

        /**
         * ID of the model to use. You can use the
         * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see all
         * of your available models, or see our
         * [Model overview](https://platform.openai.com/docs/models) for descriptions of them.
         */
        fun model(): EmbeddingModel = model.getRequired("model")

        /**
         * The number of dimensions the resulting output embeddings should have. Only supported in
         * `text-embedding-3` and later models.
         */
        fun dimensions(): Optional<Long> = Optional.ofNullable(dimensions.getNullable("dimensions"))

        /**
         * The format to return the embeddings in. Can be either `float` or
         * [`base64`](https://pypi.org/project/pybase64/).
         */
        fun encodingFormat(): Optional<EncodingFormat> =
            Optional.ofNullable(encodingFormat.getNullable("encoding_format"))

        /**
         * A unique identifier representing your end-user, which can help OpenAI to monitor and
         * detect abuse.
         * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
         */
        fun user(): Optional<String> = Optional.ofNullable(user.getNullable("user"))

        /**
         * Input text to embed, encoded as a string or array of tokens. To embed multiple inputs in
         * a single request, pass an array of strings or array of token arrays. The input must not
         * exceed the max input tokens for the model (8192 tokens for `text-embedding-ada-002`),
         * cannot be an empty string, and any array must be 2048 dimensions or less.
         * [Example Python code](https://cookbook.openai.com/examples/how_to_count_tokens_with_tiktoken)
         * for counting tokens. Some models may also impose a limit on total number of tokens summed
         * across inputs.
         */
        @JsonProperty("input") @ExcludeMissing fun _input(): JsonField<Input> = input

        /**
         * ID of the model to use. You can use the
         * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see all
         * of your available models, or see our
         * [Model overview](https://platform.openai.com/docs/models) for descriptions of them.
         */
        @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<EmbeddingModel> = model

        /**
         * The number of dimensions the resulting output embeddings should have. Only supported in
         * `text-embedding-3` and later models.
         */
        @JsonProperty("dimensions") @ExcludeMissing fun _dimensions(): JsonField<Long> = dimensions

        /**
         * The format to return the embeddings in. Can be either `float` or
         * [`base64`](https://pypi.org/project/pybase64/).
         */
        @JsonProperty("encoding_format")
        @ExcludeMissing
        fun _encodingFormat(): JsonField<EncodingFormat> = encodingFormat

        /**
         * A unique identifier representing your end-user, which can help OpenAI to monitor and
         * detect abuse.
         * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
         */
        @JsonProperty("user") @ExcludeMissing fun _user(): JsonField<String> = user

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): EmbeddingCreateBody = apply {
            if (validated) {
                return@apply
            }

            input().validate()
            model()
            dimensions()
            encodingFormat()
            user()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [EmbeddingCreateBody]. */
        class Builder internal constructor() {

            private var input: JsonField<Input>? = null
            private var model: JsonField<EmbeddingModel>? = null
            private var dimensions: JsonField<Long> = JsonMissing.of()
            private var encodingFormat: JsonField<EncodingFormat> = JsonMissing.of()
            private var user: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(embeddingCreateBody: EmbeddingCreateBody) = apply {
                input = embeddingCreateBody.input
                model = embeddingCreateBody.model
                dimensions = embeddingCreateBody.dimensions
                encodingFormat = embeddingCreateBody.encodingFormat
                user = embeddingCreateBody.user
                additionalProperties = embeddingCreateBody.additionalProperties.toMutableMap()
            }

            /**
             * Input text to embed, encoded as a string or array of tokens. To embed multiple inputs
             * in a single request, pass an array of strings or array of token arrays. The input
             * must not exceed the max input tokens for the model (8192 tokens for
             * `text-embedding-ada-002`), cannot be an empty string, and any array must be 2048
             * dimensions or less.
             * [Example Python code](https://cookbook.openai.com/examples/how_to_count_tokens_with_tiktoken)
             * for counting tokens. Some models may also impose a limit on total number of tokens
             * summed across inputs.
             */
            fun input(input: Input) = input(JsonField.of(input))

            /**
             * Input text to embed, encoded as a string or array of tokens. To embed multiple inputs
             * in a single request, pass an array of strings or array of token arrays. The input
             * must not exceed the max input tokens for the model (8192 tokens for
             * `text-embedding-ada-002`), cannot be an empty string, and any array must be 2048
             * dimensions or less.
             * [Example Python code](https://cookbook.openai.com/examples/how_to_count_tokens_with_tiktoken)
             * for counting tokens. Some models may also impose a limit on total number of tokens
             * summed across inputs.
             */
            fun input(input: JsonField<Input>) = apply { this.input = input }

            /** The string that will be turned into an embedding. */
            fun input(string: String) = input(Input.ofString(string))

            /** The array of strings that will be turned into an embedding. */
            fun inputOfArrayOfStrings(arrayOfStrings: List<String>) =
                input(Input.ofArrayOfStrings(arrayOfStrings))

            /** The array of integers that will be turned into an embedding. */
            fun inputOfArrayOfTokens(arrayOfTokens: List<Long>) =
                input(Input.ofArrayOfTokens(arrayOfTokens))

            /** The array of arrays containing integers that will be turned into an embedding. */
            fun inputOfArrayOfTokenArrays(arrayOfTokenArrays: List<List<Long>>) =
                input(Input.ofArrayOfTokenArrays(arrayOfTokenArrays))

            /**
             * ID of the model to use. You can use the
             * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see
             * all of your available models, or see our
             * [Model overview](https://platform.openai.com/docs/models) for descriptions of them.
             */
            fun model(model: EmbeddingModel) = model(JsonField.of(model))

            /**
             * ID of the model to use. You can use the
             * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see
             * all of your available models, or see our
             * [Model overview](https://platform.openai.com/docs/models) for descriptions of them.
             */
            fun model(model: JsonField<EmbeddingModel>) = apply { this.model = model }

            /**
             * ID of the model to use. You can use the
             * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see
             * all of your available models, or see our
             * [Model overview](https://platform.openai.com/docs/models) for descriptions of them.
             */
            fun model(value: String) = model(EmbeddingModel.of(value))

            /**
             * The number of dimensions the resulting output embeddings should have. Only supported
             * in `text-embedding-3` and later models.
             */
            fun dimensions(dimensions: Long) = dimensions(JsonField.of(dimensions))

            /**
             * The number of dimensions the resulting output embeddings should have. Only supported
             * in `text-embedding-3` and later models.
             */
            fun dimensions(dimensions: JsonField<Long>) = apply { this.dimensions = dimensions }

            /**
             * The format to return the embeddings in. Can be either `float` or
             * [`base64`](https://pypi.org/project/pybase64/).
             */
            fun encodingFormat(encodingFormat: EncodingFormat) =
                encodingFormat(JsonField.of(encodingFormat))

            /**
             * The format to return the embeddings in. Can be either `float` or
             * [`base64`](https://pypi.org/project/pybase64/).
             */
            fun encodingFormat(encodingFormat: JsonField<EncodingFormat>) = apply {
                this.encodingFormat = encodingFormat
            }

            /**
             * A unique identifier representing your end-user, which can help OpenAI to monitor and
             * detect abuse.
             * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
             */
            fun user(user: String) = user(JsonField.of(user))

            /**
             * A unique identifier representing your end-user, which can help OpenAI to monitor and
             * detect abuse.
             * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
             */
            fun user(user: JsonField<String>) = apply { this.user = user }

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

            fun build(): EmbeddingCreateBody =
                EmbeddingCreateBody(
                    checkRequired("input", input),
                    checkRequired("model", model),
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

    /** A builder for [EmbeddingCreateParams]. */
    @NoAutoDetect
    class Builder internal constructor() {

        private var body: EmbeddingCreateBody.Builder = EmbeddingCreateBody.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(embeddingCreateParams: EmbeddingCreateParams) = apply {
            body = embeddingCreateParams.body.toBuilder()
            additionalHeaders = embeddingCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = embeddingCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Input text to embed, encoded as a string or array of tokens. To embed multiple inputs in
         * a single request, pass an array of strings or array of token arrays. The input must not
         * exceed the max input tokens for the model (8192 tokens for `text-embedding-ada-002`),
         * cannot be an empty string, and any array must be 2048 dimensions or less.
         * [Example Python code](https://cookbook.openai.com/examples/how_to_count_tokens_with_tiktoken)
         * for counting tokens. Some models may also impose a limit on total number of tokens summed
         * across inputs.
         */
        fun input(input: Input) = apply { body.input(input) }

        /**
         * Input text to embed, encoded as a string or array of tokens. To embed multiple inputs in
         * a single request, pass an array of strings or array of token arrays. The input must not
         * exceed the max input tokens for the model (8192 tokens for `text-embedding-ada-002`),
         * cannot be an empty string, and any array must be 2048 dimensions or less.
         * [Example Python code](https://cookbook.openai.com/examples/how_to_count_tokens_with_tiktoken)
         * for counting tokens. Some models may also impose a limit on total number of tokens summed
         * across inputs.
         */
        fun input(input: JsonField<Input>) = apply { body.input(input) }

        /** The string that will be turned into an embedding. */
        fun input(string: String) = apply { body.input(string) }

        /** The array of strings that will be turned into an embedding. */
        fun inputOfArrayOfStrings(arrayOfStrings: List<String>) = apply {
            body.inputOfArrayOfStrings(arrayOfStrings)
        }

        /** The array of integers that will be turned into an embedding. */
        fun inputOfArrayOfTokens(arrayOfTokens: List<Long>) = apply {
            body.inputOfArrayOfTokens(arrayOfTokens)
        }

        /** The array of arrays containing integers that will be turned into an embedding. */
        fun inputOfArrayOfTokenArrays(arrayOfTokenArrays: List<List<Long>>) = apply {
            body.inputOfArrayOfTokenArrays(arrayOfTokenArrays)
        }

        /**
         * ID of the model to use. You can use the
         * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see all
         * of your available models, or see our
         * [Model overview](https://platform.openai.com/docs/models) for descriptions of them.
         */
        fun model(model: EmbeddingModel) = apply { body.model(model) }

        /**
         * ID of the model to use. You can use the
         * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see all
         * of your available models, or see our
         * [Model overview](https://platform.openai.com/docs/models) for descriptions of them.
         */
        fun model(model: JsonField<EmbeddingModel>) = apply { body.model(model) }

        /**
         * ID of the model to use. You can use the
         * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see all
         * of your available models, or see our
         * [Model overview](https://platform.openai.com/docs/models) for descriptions of them.
         */
        fun model(value: String) = apply { body.model(value) }

        /**
         * The number of dimensions the resulting output embeddings should have. Only supported in
         * `text-embedding-3` and later models.
         */
        fun dimensions(dimensions: Long) = apply { body.dimensions(dimensions) }

        /**
         * The number of dimensions the resulting output embeddings should have. Only supported in
         * `text-embedding-3` and later models.
         */
        fun dimensions(dimensions: JsonField<Long>) = apply { body.dimensions(dimensions) }

        /**
         * The format to return the embeddings in. Can be either `float` or
         * [`base64`](https://pypi.org/project/pybase64/).
         */
        fun encodingFormat(encodingFormat: EncodingFormat) = apply {
            body.encodingFormat(encodingFormat)
        }

        /**
         * The format to return the embeddings in. Can be either `float` or
         * [`base64`](https://pypi.org/project/pybase64/).
         */
        fun encodingFormat(encodingFormat: JsonField<EncodingFormat>) = apply {
            body.encodingFormat(encodingFormat)
        }

        /**
         * A unique identifier representing your end-user, which can help OpenAI to monitor and
         * detect abuse.
         * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
         */
        fun user(user: String) = apply { body.user(user) }

        /**
         * A unique identifier representing your end-user, which can help OpenAI to monitor and
         * detect abuse.
         * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
         */
        fun user(user: JsonField<String>) = apply { body.user(user) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

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

        fun build(): EmbeddingCreateParams =
            EmbeddingCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    /**
     * Input text to embed, encoded as a string or array of tokens. To embed multiple inputs in a
     * single request, pass an array of strings or array of token arrays. The input must not exceed
     * the max input tokens for the model (8192 tokens for `text-embedding-ada-002`), cannot be an
     * empty string, and any array must be 2048 dimensions or less.
     * [Example Python code](https://cookbook.openai.com/examples/how_to_count_tokens_with_tiktoken)
     * for counting tokens. Some models may also impose a limit on total number of tokens summed
     * across inputs.
     */
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

        /** The string that will be turned into an embedding. */
        fun asString(): String = string.getOrThrow("string")

        /** The array of strings that will be turned into an embedding. */
        fun asArrayOfStrings(): List<String> = arrayOfStrings.getOrThrow("arrayOfStrings")

        /** The array of integers that will be turned into an embedding. */
        fun asArrayOfTokens(): List<Long> = arrayOfTokens.getOrThrow("arrayOfTokens")

        /** The array of arrays containing integers that will be turned into an embedding. */
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

        private var validated: Boolean = false

        fun validate(): Input = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitString(string: String) {}

                    override fun visitArrayOfStrings(arrayOfStrings: List<String>) {}

                    override fun visitArrayOfTokens(arrayOfTokens: List<Long>) {}

                    override fun visitArrayOfTokenArrays(arrayOfTokenArrays: List<List<Long>>) {}
                }
            )
            validated = true
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

            /** The string that will be turned into an embedding. */
            @JvmStatic fun ofString(string: String) = Input(string = string)

            /** The array of strings that will be turned into an embedding. */
            @JvmStatic
            fun ofArrayOfStrings(arrayOfStrings: List<String>) =
                Input(arrayOfStrings = arrayOfStrings)

            /** The array of integers that will be turned into an embedding. */
            @JvmStatic
            fun ofArrayOfTokens(arrayOfTokens: List<Long>) = Input(arrayOfTokens = arrayOfTokens)

            /** The array of arrays containing integers that will be turned into an embedding. */
            @JvmStatic
            fun ofArrayOfTokenArrays(arrayOfTokenArrays: List<List<Long>>) =
                Input(arrayOfTokenArrays = arrayOfTokenArrays)
        }

        /** An interface that defines how to map each variant of [Input] to a value of type [T]. */
        interface Visitor<out T> {

            /** The string that will be turned into an embedding. */
            fun visitString(string: String): T

            /** The array of strings that will be turned into an embedding. */
            fun visitArrayOfStrings(arrayOfStrings: List<String>): T

            /** The array of integers that will be turned into an embedding. */
            fun visitArrayOfTokens(arrayOfTokens: List<Long>): T

            /** The array of arrays containing integers that will be turned into an embedding. */
            fun visitArrayOfTokenArrays(arrayOfTokenArrays: List<List<Long>>): T

            /**
             * Maps an unknown variant of [Input] to a value of type [T].
             *
             * An instance of [Input] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Input: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Input>(Input::class) {

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

        internal class Serializer : BaseSerializer<Input>(Input::class) {

            override fun serialize(
                value: Input,
                generator: JsonGenerator,
                provider: SerializerProvider,
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

    /**
     * The format to return the embeddings in. Can be either `float` or
     * [`base64`](https://pypi.org/project/pybase64/).
     */
    class EncodingFormat @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val FLOAT = of("float")

            @JvmField val BASE64 = of("base64")

            @JvmStatic fun of(value: String) = EncodingFormat(JsonField.of(value))
        }

        /** An enum containing [EncodingFormat]'s known values. */
        enum class Known {
            FLOAT,
            BASE64,
        }

        /**
         * An enum containing [EncodingFormat]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [EncodingFormat] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            FLOAT,
            BASE64,
            /**
             * An enum member indicating that [EncodingFormat] was instantiated with an unknown
             * value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                FLOAT -> Value.FLOAT
                BASE64 -> Value.BASE64
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws OpenAIInvalidDataException if this class instance's value is a not a known
         *   member.
         */
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

        return /* spotless:off */ other is EmbeddingCreateParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "EmbeddingCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
