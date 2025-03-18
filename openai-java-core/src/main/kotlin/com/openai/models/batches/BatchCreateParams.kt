// File generated from our OpenAPI spec by Stainless.

package com.openai.models.batches

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
import com.openai.core.Params
import com.openai.core.checkRequired
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.Metadata
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Creates and executes a batch from an uploaded file of requests */
class BatchCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * The time frame within which the batch should be processed. Currently only `24h` is supported.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun completionWindow(): CompletionWindow = body.completionWindow()

    /**
     * The endpoint to be used for all requests in the batch. Currently `/v1/responses`,
     * `/v1/chat/completions`, `/v1/embeddings`, and `/v1/completions` are supported. Note that
     * `/v1/embeddings` batches are also restricted to a maximum of 50,000 embedding inputs across
     * all requests in the batch.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun endpoint(): Endpoint = body.endpoint()

    /**
     * The ID of an uploaded file that contains requests for the new batch.
     *
     * See [upload file](https://platform.openai.com/docs/api-reference/files/create) for how to
     * upload a file.
     *
     * Your input file must be formatted as a
     * [JSONL file](https://platform.openai.com/docs/api-reference/batch/request-input), and must be
     * uploaded with the purpose `batch`. The file can contain up to 50,000 requests, and can be up
     * to 200 MB in size.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun inputFileId(): String = body.inputFileId()

    /**
     * Set of 16 key-value pairs that can be attached to an object. This can be useful for storing
     * additional information about the object in a structured format, and querying for objects via
     * API or the dashboard.
     *
     * Keys are strings with a maximum length of 64 characters. Values are strings with a maximum
     * length of 512 characters.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun metadata(): Optional<Metadata> = body.metadata()

    /**
     * Returns the raw JSON value of [completionWindow].
     *
     * Unlike [completionWindow], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _completionWindow(): JsonField<CompletionWindow> = body._completionWindow()

    /**
     * Returns the raw JSON value of [endpoint].
     *
     * Unlike [endpoint], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _endpoint(): JsonField<Endpoint> = body._endpoint()

    /**
     * Returns the raw JSON value of [inputFileId].
     *
     * Unlike [inputFileId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _inputFileId(): JsonField<String> = body._inputFileId()

    /**
     * Returns the raw JSON value of [metadata].
     *
     * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _metadata(): JsonField<Metadata> = body._metadata()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    @JvmSynthetic internal fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    @NoAutoDetect
    class Body
    @JsonCreator
    private constructor(
        @JsonProperty("completion_window")
        @ExcludeMissing
        private val completionWindow: JsonField<CompletionWindow> = JsonMissing.of(),
        @JsonProperty("endpoint")
        @ExcludeMissing
        private val endpoint: JsonField<Endpoint> = JsonMissing.of(),
        @JsonProperty("input_file_id")
        @ExcludeMissing
        private val inputFileId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("metadata")
        @ExcludeMissing
        private val metadata: JsonField<Metadata> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * The time frame within which the batch should be processed. Currently only `24h` is
         * supported.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun completionWindow(): CompletionWindow = completionWindow.getRequired("completion_window")

        /**
         * The endpoint to be used for all requests in the batch. Currently `/v1/responses`,
         * `/v1/chat/completions`, `/v1/embeddings`, and `/v1/completions` are supported. Note that
         * `/v1/embeddings` batches are also restricted to a maximum of 50,000 embedding inputs
         * across all requests in the batch.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun endpoint(): Endpoint = endpoint.getRequired("endpoint")

        /**
         * The ID of an uploaded file that contains requests for the new batch.
         *
         * See [upload file](https://platform.openai.com/docs/api-reference/files/create) for how to
         * upload a file.
         *
         * Your input file must be formatted as a
         * [JSONL file](https://platform.openai.com/docs/api-reference/batch/request-input), and
         * must be uploaded with the purpose `batch`. The file can contain up to 50,000 requests,
         * and can be up to 200 MB in size.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun inputFileId(): String = inputFileId.getRequired("input_file_id")

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format, and querying for
         * objects via API or the dashboard.
         *
         * Keys are strings with a maximum length of 64 characters. Values are strings with a
         * maximum length of 512 characters.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun metadata(): Optional<Metadata> = Optional.ofNullable(metadata.getNullable("metadata"))

        /**
         * Returns the raw JSON value of [completionWindow].
         *
         * Unlike [completionWindow], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("completion_window")
        @ExcludeMissing
        fun _completionWindow(): JsonField<CompletionWindow> = completionWindow

        /**
         * Returns the raw JSON value of [endpoint].
         *
         * Unlike [endpoint], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("endpoint") @ExcludeMissing fun _endpoint(): JsonField<Endpoint> = endpoint

        /**
         * Returns the raw JSON value of [inputFileId].
         *
         * Unlike [inputFileId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("input_file_id")
        @ExcludeMissing
        fun _inputFileId(): JsonField<String> = inputFileId

        /**
         * Returns the raw JSON value of [metadata].
         *
         * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonField<Metadata> = metadata

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            completionWindow()
            endpoint()
            inputFileId()
            metadata().ifPresent { it.validate() }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .completionWindow()
             * .endpoint()
             * .inputFileId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var completionWindow: JsonField<CompletionWindow>? = null
            private var endpoint: JsonField<Endpoint>? = null
            private var inputFileId: JsonField<String>? = null
            private var metadata: JsonField<Metadata> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                completionWindow = body.completionWindow
                endpoint = body.endpoint
                inputFileId = body.inputFileId
                metadata = body.metadata
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * The time frame within which the batch should be processed. Currently only `24h` is
             * supported.
             */
            fun completionWindow(completionWindow: CompletionWindow) =
                completionWindow(JsonField.of(completionWindow))

            /**
             * Sets [Builder.completionWindow] to an arbitrary JSON value.
             *
             * You should usually call [Builder.completionWindow] with a well-typed
             * [CompletionWindow] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun completionWindow(completionWindow: JsonField<CompletionWindow>) = apply {
                this.completionWindow = completionWindow
            }

            /**
             * The endpoint to be used for all requests in the batch. Currently `/v1/responses`,
             * `/v1/chat/completions`, `/v1/embeddings`, and `/v1/completions` are supported. Note
             * that `/v1/embeddings` batches are also restricted to a maximum of 50,000 embedding
             * inputs across all requests in the batch.
             */
            fun endpoint(endpoint: Endpoint) = endpoint(JsonField.of(endpoint))

            /**
             * Sets [Builder.endpoint] to an arbitrary JSON value.
             *
             * You should usually call [Builder.endpoint] with a well-typed [Endpoint] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun endpoint(endpoint: JsonField<Endpoint>) = apply { this.endpoint = endpoint }

            /**
             * The ID of an uploaded file that contains requests for the new batch.
             *
             * See [upload file](https://platform.openai.com/docs/api-reference/files/create) for
             * how to upload a file.
             *
             * Your input file must be formatted as a
             * [JSONL file](https://platform.openai.com/docs/api-reference/batch/request-input), and
             * must be uploaded with the purpose `batch`. The file can contain up to 50,000
             * requests, and can be up to 200 MB in size.
             */
            fun inputFileId(inputFileId: String) = inputFileId(JsonField.of(inputFileId))

            /**
             * Sets [Builder.inputFileId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.inputFileId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun inputFileId(inputFileId: JsonField<String>) = apply {
                this.inputFileId = inputFileId
            }

            /**
             * Set of 16 key-value pairs that can be attached to an object. This can be useful for
             * storing additional information about the object in a structured format, and querying
             * for objects via API or the dashboard.
             *
             * Keys are strings with a maximum length of 64 characters. Values are strings with a
             * maximum length of 512 characters.
             */
            fun metadata(metadata: Metadata?) = metadata(JsonField.ofNullable(metadata))

            /** Alias for calling [Builder.metadata] with `metadata.orElse(null)`. */
            fun metadata(metadata: Optional<Metadata>) = metadata(metadata.getOrNull())

            /**
             * Sets [Builder.metadata] to an arbitrary JSON value.
             *
             * You should usually call [Builder.metadata] with a well-typed [Metadata] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .completionWindow()
             * .endpoint()
             * .inputFileId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("completionWindow", completionWindow),
                    checkRequired("endpoint", endpoint),
                    checkRequired("inputFileId", inputFileId),
                    metadata,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && completionWindow == other.completionWindow && endpoint == other.endpoint && inputFileId == other.inputFileId && metadata == other.metadata && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(completionWindow, endpoint, inputFileId, metadata, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{completionWindow=$completionWindow, endpoint=$endpoint, inputFileId=$inputFileId, metadata=$metadata, additionalProperties=$additionalProperties}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [BatchCreateParams].
         *
         * The following fields are required:
         * ```java
         * .completionWindow()
         * .endpoint()
         * .inputFileId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BatchCreateParams]. */
    @NoAutoDetect
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(batchCreateParams: BatchCreateParams) = apply {
            body = batchCreateParams.body.toBuilder()
            additionalHeaders = batchCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = batchCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * The time frame within which the batch should be processed. Currently only `24h` is
         * supported.
         */
        fun completionWindow(completionWindow: CompletionWindow) = apply {
            body.completionWindow(completionWindow)
        }

        /**
         * Sets [Builder.completionWindow] to an arbitrary JSON value.
         *
         * You should usually call [Builder.completionWindow] with a well-typed [CompletionWindow]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun completionWindow(completionWindow: JsonField<CompletionWindow>) = apply {
            body.completionWindow(completionWindow)
        }

        /**
         * The endpoint to be used for all requests in the batch. Currently `/v1/responses`,
         * `/v1/chat/completions`, `/v1/embeddings`, and `/v1/completions` are supported. Note that
         * `/v1/embeddings` batches are also restricted to a maximum of 50,000 embedding inputs
         * across all requests in the batch.
         */
        fun endpoint(endpoint: Endpoint) = apply { body.endpoint(endpoint) }

        /**
         * Sets [Builder.endpoint] to an arbitrary JSON value.
         *
         * You should usually call [Builder.endpoint] with a well-typed [Endpoint] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun endpoint(endpoint: JsonField<Endpoint>) = apply { body.endpoint(endpoint) }

        /**
         * The ID of an uploaded file that contains requests for the new batch.
         *
         * See [upload file](https://platform.openai.com/docs/api-reference/files/create) for how to
         * upload a file.
         *
         * Your input file must be formatted as a
         * [JSONL file](https://platform.openai.com/docs/api-reference/batch/request-input), and
         * must be uploaded with the purpose `batch`. The file can contain up to 50,000 requests,
         * and can be up to 200 MB in size.
         */
        fun inputFileId(inputFileId: String) = apply { body.inputFileId(inputFileId) }

        /**
         * Sets [Builder.inputFileId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inputFileId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun inputFileId(inputFileId: JsonField<String>) = apply { body.inputFileId(inputFileId) }

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format, and querying for
         * objects via API or the dashboard.
         *
         * Keys are strings with a maximum length of 64 characters. Values are strings with a
         * maximum length of 512 characters.
         */
        fun metadata(metadata: Metadata?) = apply { body.metadata(metadata) }

        /** Alias for calling [Builder.metadata] with `metadata.orElse(null)`. */
        fun metadata(metadata: Optional<Metadata>) = metadata(metadata.getOrNull())

        /**
         * Sets [Builder.metadata] to an arbitrary JSON value.
         *
         * You should usually call [Builder.metadata] with a well-typed [Metadata] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun metadata(metadata: JsonField<Metadata>) = apply { body.metadata(metadata) }

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

        /**
         * Returns an immutable instance of [BatchCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .completionWindow()
         * .endpoint()
         * .inputFileId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): BatchCreateParams =
            BatchCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    /**
     * The time frame within which the batch should be processed. Currently only `24h` is supported.
     */
    class CompletionWindow @JsonCreator private constructor(private val value: JsonField<String>) :
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

            @JvmField val _24H = of("24h")

            @JvmStatic fun of(value: String) = CompletionWindow(JsonField.of(value))
        }

        /** An enum containing [CompletionWindow]'s known values. */
        enum class Known {
            _24H
        }

        /**
         * An enum containing [CompletionWindow]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [CompletionWindow] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            _24H,
            /**
             * An enum member indicating that [CompletionWindow] was instantiated with an unknown
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
                _24H -> Value._24H
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
                _24H -> Known._24H
                else -> throw OpenAIInvalidDataException("Unknown CompletionWindow: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws OpenAIInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { OpenAIInvalidDataException("Value is not a String") }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is CompletionWindow && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * The endpoint to be used for all requests in the batch. Currently `/v1/responses`,
     * `/v1/chat/completions`, `/v1/embeddings`, and `/v1/completions` are supported. Note that
     * `/v1/embeddings` batches are also restricted to a maximum of 50,000 embedding inputs across
     * all requests in the batch.
     */
    class Endpoint @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val V1_RESPONSES = of("/v1/responses")

            @JvmField val V1_CHAT_COMPLETIONS = of("/v1/chat/completions")

            @JvmField val V1_EMBEDDINGS = of("/v1/embeddings")

            @JvmField val V1_COMPLETIONS = of("/v1/completions")

            @JvmStatic fun of(value: String) = Endpoint(JsonField.of(value))
        }

        /** An enum containing [Endpoint]'s known values. */
        enum class Known {
            V1_RESPONSES,
            V1_CHAT_COMPLETIONS,
            V1_EMBEDDINGS,
            V1_COMPLETIONS,
        }

        /**
         * An enum containing [Endpoint]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Endpoint] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            V1_RESPONSES,
            V1_CHAT_COMPLETIONS,
            V1_EMBEDDINGS,
            V1_COMPLETIONS,
            /** An enum member indicating that [Endpoint] was instantiated with an unknown value. */
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
                V1_RESPONSES -> Value.V1_RESPONSES
                V1_CHAT_COMPLETIONS -> Value.V1_CHAT_COMPLETIONS
                V1_EMBEDDINGS -> Value.V1_EMBEDDINGS
                V1_COMPLETIONS -> Value.V1_COMPLETIONS
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
                V1_RESPONSES -> Known.V1_RESPONSES
                V1_CHAT_COMPLETIONS -> Known.V1_CHAT_COMPLETIONS
                V1_EMBEDDINGS -> Known.V1_EMBEDDINGS
                V1_COMPLETIONS -> Known.V1_COMPLETIONS
                else -> throw OpenAIInvalidDataException("Unknown Endpoint: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws OpenAIInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { OpenAIInvalidDataException("Value is not a String") }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Endpoint && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is BatchCreateParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "BatchCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
