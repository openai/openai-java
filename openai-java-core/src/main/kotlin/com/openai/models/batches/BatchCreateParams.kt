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
import com.openai.core.Params
import com.openai.core.checkRequired
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
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
     * `/v1/chat/completions`, `/v1/embeddings`, `/v1/completions`, `/v1/moderations`,
     * `/v1/images/generations`, and `/v1/images/edits` are supported. Note that `/v1/embeddings`
     * batches are also restricted to a maximum of 50,000 embedding inputs across all requests in
     * the batch.
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
     * The expiration policy for the output and/or error file that are generated for a batch.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun outputExpiresAfter(): Optional<OutputExpiresAfter> = body.outputExpiresAfter()

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

    /**
     * Returns the raw JSON value of [outputExpiresAfter].
     *
     * Unlike [outputExpiresAfter], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _outputExpiresAfter(): JsonField<OutputExpiresAfter> = body._outputExpiresAfter()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

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
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [completionWindow]
         * - [endpoint]
         * - [inputFileId]
         * - [metadata]
         * - [outputExpiresAfter]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

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
         * `/v1/chat/completions`, `/v1/embeddings`, `/v1/completions`, `/v1/moderations`,
         * `/v1/images/generations`, and `/v1/images/edits` are supported. Note that
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

        /**
         * The expiration policy for the output and/or error file that are generated for a batch.
         */
        fun outputExpiresAfter(outputExpiresAfter: OutputExpiresAfter) = apply {
            body.outputExpiresAfter(outputExpiresAfter)
        }

        /**
         * Sets [Builder.outputExpiresAfter] to an arbitrary JSON value.
         *
         * You should usually call [Builder.outputExpiresAfter] with a well-typed
         * [OutputExpiresAfter] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun outputExpiresAfter(outputExpiresAfter: JsonField<OutputExpiresAfter>) = apply {
            body.outputExpiresAfter(outputExpiresAfter)
        }

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

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val completionWindow: JsonField<CompletionWindow>,
        private val endpoint: JsonField<Endpoint>,
        private val inputFileId: JsonField<String>,
        private val metadata: JsonField<Metadata>,
        private val outputExpiresAfter: JsonField<OutputExpiresAfter>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("completion_window")
            @ExcludeMissing
            completionWindow: JsonField<CompletionWindow> = JsonMissing.of(),
            @JsonProperty("endpoint")
            @ExcludeMissing
            endpoint: JsonField<Endpoint> = JsonMissing.of(),
            @JsonProperty("input_file_id")
            @ExcludeMissing
            inputFileId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("metadata")
            @ExcludeMissing
            metadata: JsonField<Metadata> = JsonMissing.of(),
            @JsonProperty("output_expires_after")
            @ExcludeMissing
            outputExpiresAfter: JsonField<OutputExpiresAfter> = JsonMissing.of(),
        ) : this(
            completionWindow,
            endpoint,
            inputFileId,
            metadata,
            outputExpiresAfter,
            mutableMapOf(),
        )

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
         * `/v1/chat/completions`, `/v1/embeddings`, `/v1/completions`, `/v1/moderations`,
         * `/v1/images/generations`, and `/v1/images/edits` are supported. Note that
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
        fun metadata(): Optional<Metadata> = metadata.getOptional("metadata")

        /**
         * The expiration policy for the output and/or error file that are generated for a batch.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun outputExpiresAfter(): Optional<OutputExpiresAfter> =
            outputExpiresAfter.getOptional("output_expires_after")

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

        /**
         * Returns the raw JSON value of [outputExpiresAfter].
         *
         * Unlike [outputExpiresAfter], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("output_expires_after")
        @ExcludeMissing
        fun _outputExpiresAfter(): JsonField<OutputExpiresAfter> = outputExpiresAfter

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
            private var outputExpiresAfter: JsonField<OutputExpiresAfter> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                completionWindow = body.completionWindow
                endpoint = body.endpoint
                inputFileId = body.inputFileId
                metadata = body.metadata
                outputExpiresAfter = body.outputExpiresAfter
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
             * `/v1/chat/completions`, `/v1/embeddings`, `/v1/completions`, `/v1/moderations`,
             * `/v1/images/generations`, and `/v1/images/edits` are supported. Note that
             * `/v1/embeddings` batches are also restricted to a maximum of 50,000 embedding inputs
             * across all requests in the batch.
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

            /**
             * The expiration policy for the output and/or error file that are generated for a
             * batch.
             */
            fun outputExpiresAfter(outputExpiresAfter: OutputExpiresAfter) =
                outputExpiresAfter(JsonField.of(outputExpiresAfter))

            /**
             * Sets [Builder.outputExpiresAfter] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputExpiresAfter] with a well-typed
             * [OutputExpiresAfter] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun outputExpiresAfter(outputExpiresAfter: JsonField<OutputExpiresAfter>) = apply {
                this.outputExpiresAfter = outputExpiresAfter
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
                    outputExpiresAfter,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            completionWindow().validate()
            endpoint().validate()
            inputFileId()
            metadata().ifPresent { it.validate() }
            outputExpiresAfter().ifPresent { it.validate() }
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (completionWindow.asKnown().getOrNull()?.validity() ?: 0) +
                (endpoint.asKnown().getOrNull()?.validity() ?: 0) +
                (if (inputFileId.asKnown().isPresent) 1 else 0) +
                (metadata.asKnown().getOrNull()?.validity() ?: 0) +
                (outputExpiresAfter.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                completionWindow == other.completionWindow &&
                endpoint == other.endpoint &&
                inputFileId == other.inputFileId &&
                metadata == other.metadata &&
                outputExpiresAfter == other.outputExpiresAfter &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                completionWindow,
                endpoint,
                inputFileId,
                metadata,
                outputExpiresAfter,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{completionWindow=$completionWindow, endpoint=$endpoint, inputFileId=$inputFileId, metadata=$metadata, outputExpiresAfter=$outputExpiresAfter, additionalProperties=$additionalProperties}"
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

        private var validated: Boolean = false

        fun validate(): CompletionWindow = apply {
            if (validated) {
                return@apply
            }

            known()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CompletionWindow && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * The endpoint to be used for all requests in the batch. Currently `/v1/responses`,
     * `/v1/chat/completions`, `/v1/embeddings`, `/v1/completions`, `/v1/moderations`,
     * `/v1/images/generations`, and `/v1/images/edits` are supported. Note that `/v1/embeddings`
     * batches are also restricted to a maximum of 50,000 embedding inputs across all requests in
     * the batch.
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

            @JvmField val V1_MODERATIONS = of("/v1/moderations")

            @JvmField val V1_IMAGES_GENERATIONS = of("/v1/images/generations")

            @JvmField val V1_IMAGES_EDITS = of("/v1/images/edits")

            @JvmStatic fun of(value: String) = Endpoint(JsonField.of(value))
        }

        /** An enum containing [Endpoint]'s known values. */
        enum class Known {
            V1_RESPONSES,
            V1_CHAT_COMPLETIONS,
            V1_EMBEDDINGS,
            V1_COMPLETIONS,
            V1_MODERATIONS,
            V1_IMAGES_GENERATIONS,
            V1_IMAGES_EDITS,
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
            V1_MODERATIONS,
            V1_IMAGES_GENERATIONS,
            V1_IMAGES_EDITS,
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
                V1_MODERATIONS -> Value.V1_MODERATIONS
                V1_IMAGES_GENERATIONS -> Value.V1_IMAGES_GENERATIONS
                V1_IMAGES_EDITS -> Value.V1_IMAGES_EDITS
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
                V1_MODERATIONS -> Known.V1_MODERATIONS
                V1_IMAGES_GENERATIONS -> Known.V1_IMAGES_GENERATIONS
                V1_IMAGES_EDITS -> Known.V1_IMAGES_EDITS
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

        private var validated: Boolean = false

        fun validate(): Endpoint = apply {
            if (validated) {
                return@apply
            }

            known()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Endpoint && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * Set of 16 key-value pairs that can be attached to an object. This can be useful for storing
     * additional information about the object in a structured format, and querying for objects via
     * API or the dashboard.
     *
     * Keys are strings with a maximum length of 64 characters. Values are strings with a maximum
     * length of 512 characters.
     */
    class Metadata
    @JsonCreator
    private constructor(
        @com.fasterxml.jackson.annotation.JsonValue
        private val additionalProperties: Map<String, JsonValue>
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Metadata]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Metadata]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(metadata: Metadata) = apply {
                additionalProperties = metadata.additionalProperties.toMutableMap()
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

            /**
             * Returns an immutable instance of [Metadata].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Metadata = Metadata(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): Metadata = apply {
            if (validated) {
                return@apply
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Metadata && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "Metadata{additionalProperties=$additionalProperties}"
    }

    /** The expiration policy for the output and/or error file that are generated for a batch. */
    class OutputExpiresAfter
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val anchor: JsonValue,
        private val seconds: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("anchor") @ExcludeMissing anchor: JsonValue = JsonMissing.of(),
            @JsonProperty("seconds") @ExcludeMissing seconds: JsonField<Long> = JsonMissing.of(),
        ) : this(anchor, seconds, mutableMapOf())

        /**
         * Anchor timestamp after which the expiration policy applies. Supported anchors:
         * `created_at`. Note that the anchor is the file creation time, not the time the batch is
         * created.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("created_at")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("anchor") @ExcludeMissing fun _anchor(): JsonValue = anchor

        /**
         * The number of seconds after the anchor time that the file will expire. Must be between
         * 3600 (1 hour) and 2592000 (30 days).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun seconds(): Long = seconds.getRequired("seconds")

        /**
         * Returns the raw JSON value of [seconds].
         *
         * Unlike [seconds], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("seconds") @ExcludeMissing fun _seconds(): JsonField<Long> = seconds

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
             * Returns a mutable builder for constructing an instance of [OutputExpiresAfter].
             *
             * The following fields are required:
             * ```java
             * .seconds()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [OutputExpiresAfter]. */
        class Builder internal constructor() {

            private var anchor: JsonValue = JsonValue.from("created_at")
            private var seconds: JsonField<Long>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(outputExpiresAfter: OutputExpiresAfter) = apply {
                anchor = outputExpiresAfter.anchor
                seconds = outputExpiresAfter.seconds
                additionalProperties = outputExpiresAfter.additionalProperties.toMutableMap()
            }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("created_at")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun anchor(anchor: JsonValue) = apply { this.anchor = anchor }

            /**
             * The number of seconds after the anchor time that the file will expire. Must be
             * between 3600 (1 hour) and 2592000 (30 days).
             */
            fun seconds(seconds: Long) = seconds(JsonField.of(seconds))

            /**
             * Sets [Builder.seconds] to an arbitrary JSON value.
             *
             * You should usually call [Builder.seconds] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun seconds(seconds: JsonField<Long>) = apply { this.seconds = seconds }

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
             * Returns an immutable instance of [OutputExpiresAfter].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .seconds()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): OutputExpiresAfter =
                OutputExpiresAfter(
                    anchor,
                    checkRequired("seconds", seconds),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): OutputExpiresAfter = apply {
            if (validated) {
                return@apply
            }

            _anchor().let {
                if (it != JsonValue.from("created_at")) {
                    throw OpenAIInvalidDataException("'anchor' is invalid, received $it")
                }
            }
            seconds()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            anchor.let { if (it == JsonValue.from("created_at")) 1 else 0 } +
                (if (seconds.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is OutputExpiresAfter &&
                anchor == other.anchor &&
                seconds == other.seconds &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(anchor, seconds, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "OutputExpiresAfter{anchor=$anchor, seconds=$seconds, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BatchCreateParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "BatchCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
