// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals.runs

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
import com.openai.core.Params
import com.openai.core.allMaxBy
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.ReasoningEffort
import com.openai.models.responses.ResponseInputText
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Create a new evaluation run. This is the endpoint that will kick off grading. */
class RunCreateParams
private constructor(
    private val evalId: String,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun evalId(): String = evalId

    /**
     * Details about the run's data source.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun dataSource(): DataSource = body.dataSource()

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
     * The name of the run.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun name(): Optional<String> = body.name()

    /**
     * Returns the raw JSON value of [dataSource].
     *
     * Unlike [dataSource], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _dataSource(): JsonField<DataSource> = body._dataSource()

    /**
     * Returns the raw JSON value of [metadata].
     *
     * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _metadata(): JsonField<Metadata> = body._metadata()

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _name(): JsonField<String> = body._name()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [RunCreateParams].
         *
         * The following fields are required:
         * ```java
         * .evalId()
         * .dataSource()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RunCreateParams]. */
    class Builder internal constructor() {

        private var evalId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(runCreateParams: RunCreateParams) = apply {
            evalId = runCreateParams.evalId
            body = runCreateParams.body.toBuilder()
            additionalHeaders = runCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = runCreateParams.additionalQueryParams.toBuilder()
        }

        fun evalId(evalId: String) = apply { this.evalId = evalId }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [dataSource]
         * - [metadata]
         * - [name]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** Details about the run's data source. */
        fun dataSource(dataSource: DataSource) = apply { body.dataSource(dataSource) }

        /**
         * Sets [Builder.dataSource] to an arbitrary JSON value.
         *
         * You should usually call [Builder.dataSource] with a well-typed [DataSource] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun dataSource(dataSource: JsonField<DataSource>) = apply { body.dataSource(dataSource) }

        /**
         * Alias for calling [dataSource] with
         * `DataSource.ofCreateEvalJsonlRun(createEvalJsonlRun)`.
         */
        fun dataSource(createEvalJsonlRun: CreateEvalJsonlRunDataSource) = apply {
            body.dataSource(createEvalJsonlRun)
        }

        /**
         * Alias for calling [dataSource] with
         * `DataSource.ofCreateEvalCompletionsRun(createEvalCompletionsRun)`.
         */
        fun dataSource(createEvalCompletionsRun: CreateEvalCompletionsRunDataSource) = apply {
            body.dataSource(createEvalCompletionsRun)
        }

        /**
         * Alias for calling [dataSource] with
         * `DataSource.ofCreateEvalResponsesRun(createEvalResponsesRun)`.
         */
        fun dataSource(createEvalResponsesRun: DataSource.CreateEvalResponsesRunDataSource) =
            apply {
                body.dataSource(createEvalResponsesRun)
            }

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

        /** The name of the run. */
        fun name(name: String) = apply { body.name(name) }

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { body.name(name) }

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
         * Returns an immutable instance of [RunCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .evalId()
         * .dataSource()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): RunCreateParams =
            RunCreateParams(
                checkRequired("evalId", evalId),
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> evalId
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    private constructor(
        private val dataSource: JsonField<DataSource>,
        private val metadata: JsonField<Metadata>,
        private val name: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("data_source")
            @ExcludeMissing
            dataSource: JsonField<DataSource> = JsonMissing.of(),
            @JsonProperty("metadata")
            @ExcludeMissing
            metadata: JsonField<Metadata> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        ) : this(dataSource, metadata, name, mutableMapOf())

        /**
         * Details about the run's data source.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun dataSource(): DataSource = dataSource.getRequired("data_source")

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
         * The name of the run.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * Returns the raw JSON value of [dataSource].
         *
         * Unlike [dataSource], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data_source")
        @ExcludeMissing
        fun _dataSource(): JsonField<DataSource> = dataSource

        /**
         * Returns the raw JSON value of [metadata].
         *
         * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonField<Metadata> = metadata

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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
             * .dataSource()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var dataSource: JsonField<DataSource>? = null
            private var metadata: JsonField<Metadata> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                dataSource = body.dataSource
                metadata = body.metadata
                name = body.name
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** Details about the run's data source. */
            fun dataSource(dataSource: DataSource) = dataSource(JsonField.of(dataSource))

            /**
             * Sets [Builder.dataSource] to an arbitrary JSON value.
             *
             * You should usually call [Builder.dataSource] with a well-typed [DataSource] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun dataSource(dataSource: JsonField<DataSource>) = apply {
                this.dataSource = dataSource
            }

            /**
             * Alias for calling [dataSource] with
             * `DataSource.ofCreateEvalJsonlRun(createEvalJsonlRun)`.
             */
            fun dataSource(createEvalJsonlRun: CreateEvalJsonlRunDataSource) =
                dataSource(DataSource.ofCreateEvalJsonlRun(createEvalJsonlRun))

            /**
             * Alias for calling [dataSource] with
             * `DataSource.ofCreateEvalCompletionsRun(createEvalCompletionsRun)`.
             */
            fun dataSource(createEvalCompletionsRun: CreateEvalCompletionsRunDataSource) =
                dataSource(DataSource.ofCreateEvalCompletionsRun(createEvalCompletionsRun))

            /**
             * Alias for calling [dataSource] with
             * `DataSource.ofCreateEvalResponsesRun(createEvalResponsesRun)`.
             */
            fun dataSource(createEvalResponsesRun: DataSource.CreateEvalResponsesRunDataSource) =
                dataSource(DataSource.ofCreateEvalResponsesRun(createEvalResponsesRun))

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

            /** The name of the run. */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

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
             * .dataSource()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("dataSource", dataSource),
                    metadata,
                    name,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            dataSource().validate()
            metadata().ifPresent { it.validate() }
            name()
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
            (dataSource.asKnown().getOrNull()?.validity() ?: 0) +
                (metadata.asKnown().getOrNull()?.validity() ?: 0) +
                (if (name.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && dataSource == other.dataSource && metadata == other.metadata && name == other.name && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(dataSource, metadata, name, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{dataSource=$dataSource, metadata=$metadata, name=$name, additionalProperties=$additionalProperties}"
    }

    /** Details about the run's data source. */
    @JsonDeserialize(using = DataSource.Deserializer::class)
    @JsonSerialize(using = DataSource.Serializer::class)
    class DataSource
    private constructor(
        private val createEvalJsonlRun: CreateEvalJsonlRunDataSource? = null,
        private val createEvalCompletionsRun: CreateEvalCompletionsRunDataSource? = null,
        private val createEvalResponsesRun: CreateEvalResponsesRunDataSource? = null,
        private val _json: JsonValue? = null,
    ) {

        /** A JsonlRunDataSource object with that specifies a JSONL file that matches the eval */
        fun createEvalJsonlRun(): Optional<CreateEvalJsonlRunDataSource> =
            Optional.ofNullable(createEvalJsonlRun)

        /** A CompletionsRunDataSource object describing a model sampling configuration. */
        fun createEvalCompletionsRun(): Optional<CreateEvalCompletionsRunDataSource> =
            Optional.ofNullable(createEvalCompletionsRun)

        /** A ResponsesRunDataSource object describing a model sampling configuration. */
        fun createEvalResponsesRun(): Optional<CreateEvalResponsesRunDataSource> =
            Optional.ofNullable(createEvalResponsesRun)

        fun isCreateEvalJsonlRun(): Boolean = createEvalJsonlRun != null

        fun isCreateEvalCompletionsRun(): Boolean = createEvalCompletionsRun != null

        fun isCreateEvalResponsesRun(): Boolean = createEvalResponsesRun != null

        /** A JsonlRunDataSource object with that specifies a JSONL file that matches the eval */
        fun asCreateEvalJsonlRun(): CreateEvalJsonlRunDataSource =
            createEvalJsonlRun.getOrThrow("createEvalJsonlRun")

        /** A CompletionsRunDataSource object describing a model sampling configuration. */
        fun asCreateEvalCompletionsRun(): CreateEvalCompletionsRunDataSource =
            createEvalCompletionsRun.getOrThrow("createEvalCompletionsRun")

        /** A ResponsesRunDataSource object describing a model sampling configuration. */
        fun asCreateEvalResponsesRun(): CreateEvalResponsesRunDataSource =
            createEvalResponsesRun.getOrThrow("createEvalResponsesRun")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                createEvalJsonlRun != null -> visitor.visitCreateEvalJsonlRun(createEvalJsonlRun)
                createEvalCompletionsRun != null ->
                    visitor.visitCreateEvalCompletionsRun(createEvalCompletionsRun)
                createEvalResponsesRun != null ->
                    visitor.visitCreateEvalResponsesRun(createEvalResponsesRun)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): DataSource = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitCreateEvalJsonlRun(
                        createEvalJsonlRun: CreateEvalJsonlRunDataSource
                    ) {
                        createEvalJsonlRun.validate()
                    }

                    override fun visitCreateEvalCompletionsRun(
                        createEvalCompletionsRun: CreateEvalCompletionsRunDataSource
                    ) {
                        createEvalCompletionsRun.validate()
                    }

                    override fun visitCreateEvalResponsesRun(
                        createEvalResponsesRun: CreateEvalResponsesRunDataSource
                    ) {
                        createEvalResponsesRun.validate()
                    }
                }
            )
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
            accept(
                object : Visitor<Int> {
                    override fun visitCreateEvalJsonlRun(
                        createEvalJsonlRun: CreateEvalJsonlRunDataSource
                    ) = createEvalJsonlRun.validity()

                    override fun visitCreateEvalCompletionsRun(
                        createEvalCompletionsRun: CreateEvalCompletionsRunDataSource
                    ) = createEvalCompletionsRun.validity()

                    override fun visitCreateEvalResponsesRun(
                        createEvalResponsesRun: CreateEvalResponsesRunDataSource
                    ) = createEvalResponsesRun.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is DataSource && createEvalJsonlRun == other.createEvalJsonlRun && createEvalCompletionsRun == other.createEvalCompletionsRun && createEvalResponsesRun == other.createEvalResponsesRun /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(createEvalJsonlRun, createEvalCompletionsRun, createEvalResponsesRun) /* spotless:on */

        override fun toString(): String =
            when {
                createEvalJsonlRun != null -> "DataSource{createEvalJsonlRun=$createEvalJsonlRun}"
                createEvalCompletionsRun != null ->
                    "DataSource{createEvalCompletionsRun=$createEvalCompletionsRun}"
                createEvalResponsesRun != null ->
                    "DataSource{createEvalResponsesRun=$createEvalResponsesRun}"
                _json != null -> "DataSource{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid DataSource")
            }

        companion object {

            /**
             * A JsonlRunDataSource object with that specifies a JSONL file that matches the eval
             */
            @JvmStatic
            fun ofCreateEvalJsonlRun(createEvalJsonlRun: CreateEvalJsonlRunDataSource) =
                DataSource(createEvalJsonlRun = createEvalJsonlRun)

            /** A CompletionsRunDataSource object describing a model sampling configuration. */
            @JvmStatic
            fun ofCreateEvalCompletionsRun(
                createEvalCompletionsRun: CreateEvalCompletionsRunDataSource
            ) = DataSource(createEvalCompletionsRun = createEvalCompletionsRun)

            /** A ResponsesRunDataSource object describing a model sampling configuration. */
            @JvmStatic
            fun ofCreateEvalResponsesRun(createEvalResponsesRun: CreateEvalResponsesRunDataSource) =
                DataSource(createEvalResponsesRun = createEvalResponsesRun)
        }

        /**
         * An interface that defines how to map each variant of [DataSource] to a value of type [T].
         */
        interface Visitor<out T> {

            /**
             * A JsonlRunDataSource object with that specifies a JSONL file that matches the eval
             */
            fun visitCreateEvalJsonlRun(createEvalJsonlRun: CreateEvalJsonlRunDataSource): T

            /** A CompletionsRunDataSource object describing a model sampling configuration. */
            fun visitCreateEvalCompletionsRun(
                createEvalCompletionsRun: CreateEvalCompletionsRunDataSource
            ): T

            /** A ResponsesRunDataSource object describing a model sampling configuration. */
            fun visitCreateEvalResponsesRun(
                createEvalResponsesRun: CreateEvalResponsesRunDataSource
            ): T

            /**
             * Maps an unknown variant of [DataSource] to a value of type [T].
             *
             * An instance of [DataSource] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown DataSource: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<DataSource>(DataSource::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): DataSource {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<CreateEvalJsonlRunDataSource>())
                                ?.let { DataSource(createEvalJsonlRun = it, _json = json) },
                            tryDeserialize(
                                    node,
                                    jacksonTypeRef<CreateEvalCompletionsRunDataSource>(),
                                )
                                ?.let { DataSource(createEvalCompletionsRun = it, _json = json) },
                            tryDeserialize(node, jacksonTypeRef<CreateEvalResponsesRunDataSource>())
                                ?.let { DataSource(createEvalResponsesRun = it, _json = json) },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> DataSource(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<DataSource>(DataSource::class) {

            override fun serialize(
                value: DataSource,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.createEvalJsonlRun != null ->
                        generator.writeObject(value.createEvalJsonlRun)
                    value.createEvalCompletionsRun != null ->
                        generator.writeObject(value.createEvalCompletionsRun)
                    value.createEvalResponsesRun != null ->
                        generator.writeObject(value.createEvalResponsesRun)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid DataSource")
                }
            }
        }

        /** A ResponsesRunDataSource object describing a model sampling configuration. */
        class CreateEvalResponsesRunDataSource
        private constructor(
            private val source: JsonField<Source>,
            private val type: JsonField<Type>,
            private val inputMessages: JsonField<InputMessages>,
            private val model: JsonField<String>,
            private val samplingParams: JsonField<SamplingParams>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("source")
                @ExcludeMissing
                source: JsonField<Source> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
                @JsonProperty("input_messages")
                @ExcludeMissing
                inputMessages: JsonField<InputMessages> = JsonMissing.of(),
                @JsonProperty("model") @ExcludeMissing model: JsonField<String> = JsonMissing.of(),
                @JsonProperty("sampling_params")
                @ExcludeMissing
                samplingParams: JsonField<SamplingParams> = JsonMissing.of(),
            ) : this(source, type, inputMessages, model, samplingParams, mutableMapOf())

            /**
             * A EvalResponsesSource object describing a run data source configuration.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun source(): Source = source.getRequired("source")

            /**
             * The type of run data source. Always `completions`.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun type(): Type = type.getRequired("type")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun inputMessages(): Optional<InputMessages> =
                inputMessages.getOptional("input_messages")

            /**
             * The name of the model to use for generating completions (e.g. "o3-mini").
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun model(): Optional<String> = model.getOptional("model")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun samplingParams(): Optional<SamplingParams> =
                samplingParams.getOptional("sampling_params")

            /**
             * Returns the raw JSON value of [source].
             *
             * Unlike [source], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("source") @ExcludeMissing fun _source(): JsonField<Source> = source

            /**
             * Returns the raw JSON value of [type].
             *
             * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

            /**
             * Returns the raw JSON value of [inputMessages].
             *
             * Unlike [inputMessages], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("input_messages")
            @ExcludeMissing
            fun _inputMessages(): JsonField<InputMessages> = inputMessages

            /**
             * Returns the raw JSON value of [model].
             *
             * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

            /**
             * Returns the raw JSON value of [samplingParams].
             *
             * Unlike [samplingParams], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("sampling_params")
            @ExcludeMissing
            fun _samplingParams(): JsonField<SamplingParams> = samplingParams

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
                 * Returns a mutable builder for constructing an instance of
                 * [CreateEvalResponsesRunDataSource].
                 *
                 * The following fields are required:
                 * ```java
                 * .source()
                 * .type()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [CreateEvalResponsesRunDataSource]. */
            class Builder internal constructor() {

                private var source: JsonField<Source>? = null
                private var type: JsonField<Type>? = null
                private var inputMessages: JsonField<InputMessages> = JsonMissing.of()
                private var model: JsonField<String> = JsonMissing.of()
                private var samplingParams: JsonField<SamplingParams> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(
                    createEvalResponsesRunDataSource: CreateEvalResponsesRunDataSource
                ) = apply {
                    source = createEvalResponsesRunDataSource.source
                    type = createEvalResponsesRunDataSource.type
                    inputMessages = createEvalResponsesRunDataSource.inputMessages
                    model = createEvalResponsesRunDataSource.model
                    samplingParams = createEvalResponsesRunDataSource.samplingParams
                    additionalProperties =
                        createEvalResponsesRunDataSource.additionalProperties.toMutableMap()
                }

                /** A EvalResponsesSource object describing a run data source configuration. */
                fun source(source: Source) = source(JsonField.of(source))

                /**
                 * Sets [Builder.source] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.source] with a well-typed [Source] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun source(source: JsonField<Source>) = apply { this.source = source }

                /** Alias for calling [source] with `Source.ofFileContent(fileContent)`. */
                fun source(fileContent: Source.FileContent) =
                    source(Source.ofFileContent(fileContent))

                /**
                 * Alias for calling [source] with the following:
                 * ```java
                 * Source.FileContent.builder()
                 *     .content(content)
                 *     .build()
                 * ```
                 */
                fun fileContentSource(content: List<Source.FileContent.Content>) =
                    source(Source.FileContent.builder().content(content).build())

                /** Alias for calling [source] with `Source.ofFileId(fileId)`. */
                fun source(fileId: Source.FileId) = source(Source.ofFileId(fileId))

                /**
                 * Alias for calling [source] with the following:
                 * ```java
                 * Source.FileId.builder()
                 *     .id(id)
                 *     .build()
                 * ```
                 */
                fun fileIdSource(id: String) = source(Source.FileId.builder().id(id).build())

                /** Alias for calling [source] with `Source.ofResponses(responses)`. */
                fun source(responses: Source.Responses) = source(Source.ofResponses(responses))

                /** The type of run data source. Always `completions`. */
                fun type(type: Type) = type(JsonField.of(type))

                /**
                 * Sets [Builder.type] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.type] with a well-typed [Type] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonField<Type>) = apply { this.type = type }

                fun inputMessages(inputMessages: InputMessages) =
                    inputMessages(JsonField.of(inputMessages))

                /**
                 * Sets [Builder.inputMessages] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.inputMessages] with a well-typed [InputMessages]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun inputMessages(inputMessages: JsonField<InputMessages>) = apply {
                    this.inputMessages = inputMessages
                }

                /** Alias for calling [inputMessages] with `InputMessages.ofTemplate(template)`. */
                fun inputMessages(template: InputMessages.Template) =
                    inputMessages(InputMessages.ofTemplate(template))

                /**
                 * Alias for calling [inputMessages] with the following:
                 * ```java
                 * InputMessages.Template.builder()
                 *     .template(template)
                 *     .build()
                 * ```
                 */
                fun templateInputMessages(template: List<InputMessages.Template.InnerTemplate>) =
                    inputMessages(InputMessages.Template.builder().template(template).build())

                /**
                 * Alias for calling [inputMessages] with
                 * `InputMessages.ofItemReference(itemReference)`.
                 */
                fun inputMessages(itemReference: InputMessages.ItemReference) =
                    inputMessages(InputMessages.ofItemReference(itemReference))

                /**
                 * Alias for calling [inputMessages] with the following:
                 * ```java
                 * InputMessages.ItemReference.builder()
                 *     .itemReference(itemReference)
                 *     .build()
                 * ```
                 */
                fun itemReferenceInputMessages(itemReference: String) =
                    inputMessages(
                        InputMessages.ItemReference.builder().itemReference(itemReference).build()
                    )

                /** The name of the model to use for generating completions (e.g. "o3-mini"). */
                fun model(model: String) = model(JsonField.of(model))

                /**
                 * Sets [Builder.model] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.model] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun model(model: JsonField<String>) = apply { this.model = model }

                fun samplingParams(samplingParams: SamplingParams) =
                    samplingParams(JsonField.of(samplingParams))

                /**
                 * Sets [Builder.samplingParams] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.samplingParams] with a well-typed
                 * [SamplingParams] value instead. This method is primarily for setting the field to
                 * an undocumented or not yet supported value.
                 */
                fun samplingParams(samplingParams: JsonField<SamplingParams>) = apply {
                    this.samplingParams = samplingParams
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [CreateEvalResponsesRunDataSource].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .source()
                 * .type()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): CreateEvalResponsesRunDataSource =
                    CreateEvalResponsesRunDataSource(
                        checkRequired("source", source),
                        checkRequired("type", type),
                        inputMessages,
                        model,
                        samplingParams,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): CreateEvalResponsesRunDataSource = apply {
                if (validated) {
                    return@apply
                }

                source().validate()
                type().validate()
                inputMessages().ifPresent { it.validate() }
                model()
                samplingParams().ifPresent { it.validate() }
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
                (source.asKnown().getOrNull()?.validity() ?: 0) +
                    (type.asKnown().getOrNull()?.validity() ?: 0) +
                    (inputMessages.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (model.asKnown().isPresent) 1 else 0) +
                    (samplingParams.asKnown().getOrNull()?.validity() ?: 0)

            /** A EvalResponsesSource object describing a run data source configuration. */
            @JsonDeserialize(using = Source.Deserializer::class)
            @JsonSerialize(using = Source.Serializer::class)
            class Source
            private constructor(
                private val fileContent: FileContent? = null,
                private val fileId: FileId? = null,
                private val responses: Responses? = null,
                private val _json: JsonValue? = null,
            ) {

                fun fileContent(): Optional<FileContent> = Optional.ofNullable(fileContent)

                fun fileId(): Optional<FileId> = Optional.ofNullable(fileId)

                /** A EvalResponsesSource object describing a run data source configuration. */
                fun responses(): Optional<Responses> = Optional.ofNullable(responses)

                fun isFileContent(): Boolean = fileContent != null

                fun isFileId(): Boolean = fileId != null

                fun isResponses(): Boolean = responses != null

                fun asFileContent(): FileContent = fileContent.getOrThrow("fileContent")

                fun asFileId(): FileId = fileId.getOrThrow("fileId")

                /** A EvalResponsesSource object describing a run data source configuration. */
                fun asResponses(): Responses = responses.getOrThrow("responses")

                fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                fun <T> accept(visitor: Visitor<T>): T =
                    when {
                        fileContent != null -> visitor.visitFileContent(fileContent)
                        fileId != null -> visitor.visitFileId(fileId)
                        responses != null -> visitor.visitResponses(responses)
                        else -> visitor.unknown(_json)
                    }

                private var validated: Boolean = false

                fun validate(): Source = apply {
                    if (validated) {
                        return@apply
                    }

                    accept(
                        object : Visitor<Unit> {
                            override fun visitFileContent(fileContent: FileContent) {
                                fileContent.validate()
                            }

                            override fun visitFileId(fileId: FileId) {
                                fileId.validate()
                            }

                            override fun visitResponses(responses: Responses) {
                                responses.validate()
                            }
                        }
                    )
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
                    accept(
                        object : Visitor<Int> {
                            override fun visitFileContent(fileContent: FileContent) =
                                fileContent.validity()

                            override fun visitFileId(fileId: FileId) = fileId.validity()

                            override fun visitResponses(responses: Responses) = responses.validity()

                            override fun unknown(json: JsonValue?) = 0
                        }
                    )

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Source && fileContent == other.fileContent && fileId == other.fileId && responses == other.responses /* spotless:on */
                }

                override fun hashCode(): Int = /* spotless:off */ Objects.hash(fileContent, fileId, responses) /* spotless:on */

                override fun toString(): String =
                    when {
                        fileContent != null -> "Source{fileContent=$fileContent}"
                        fileId != null -> "Source{fileId=$fileId}"
                        responses != null -> "Source{responses=$responses}"
                        _json != null -> "Source{_unknown=$_json}"
                        else -> throw IllegalStateException("Invalid Source")
                    }

                companion object {

                    @JvmStatic
                    fun ofFileContent(fileContent: FileContent) = Source(fileContent = fileContent)

                    @JvmStatic fun ofFileId(fileId: FileId) = Source(fileId = fileId)

                    /** A EvalResponsesSource object describing a run data source configuration. */
                    @JvmStatic fun ofResponses(responses: Responses) = Source(responses = responses)
                }

                /**
                 * An interface that defines how to map each variant of [Source] to a value of type
                 * [T].
                 */
                interface Visitor<out T> {

                    fun visitFileContent(fileContent: FileContent): T

                    fun visitFileId(fileId: FileId): T

                    /** A EvalResponsesSource object describing a run data source configuration. */
                    fun visitResponses(responses: Responses): T

                    /**
                     * Maps an unknown variant of [Source] to a value of type [T].
                     *
                     * An instance of [Source] can contain an unknown variant if it was deserialized
                     * from data that doesn't match any known variant. For example, if the SDK is on
                     * an older version than the API, then the API may respond with new variants
                     * that the SDK is unaware of.
                     *
                     * @throws OpenAIInvalidDataException in the default implementation.
                     */
                    fun unknown(json: JsonValue?): T {
                        throw OpenAIInvalidDataException("Unknown Source: $json")
                    }
                }

                internal class Deserializer : BaseDeserializer<Source>(Source::class) {

                    override fun ObjectCodec.deserialize(node: JsonNode): Source {
                        val json = JsonValue.fromJsonNode(node)
                        val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                        when (type) {
                            "file_content" -> {
                                return tryDeserialize(node, jacksonTypeRef<FileContent>())?.let {
                                    Source(fileContent = it, _json = json)
                                } ?: Source(_json = json)
                            }
                            "file_id" -> {
                                return tryDeserialize(node, jacksonTypeRef<FileId>())?.let {
                                    Source(fileId = it, _json = json)
                                } ?: Source(_json = json)
                            }
                            "responses" -> {
                                return tryDeserialize(node, jacksonTypeRef<Responses>())?.let {
                                    Source(responses = it, _json = json)
                                } ?: Source(_json = json)
                            }
                        }

                        return Source(_json = json)
                    }
                }

                internal class Serializer : BaseSerializer<Source>(Source::class) {

                    override fun serialize(
                        value: Source,
                        generator: JsonGenerator,
                        provider: SerializerProvider,
                    ) {
                        when {
                            value.fileContent != null -> generator.writeObject(value.fileContent)
                            value.fileId != null -> generator.writeObject(value.fileId)
                            value.responses != null -> generator.writeObject(value.responses)
                            value._json != null -> generator.writeObject(value._json)
                            else -> throw IllegalStateException("Invalid Source")
                        }
                    }
                }

                class FileContent
                private constructor(
                    private val content: JsonField<List<Content>>,
                    private val type: JsonValue,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("content")
                        @ExcludeMissing
                        content: JsonField<List<Content>> = JsonMissing.of(),
                        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                    ) : this(content, type, mutableMapOf())

                    /**
                     * The content of the jsonl file.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun content(): List<Content> = content.getRequired("content")

                    /**
                     * The type of jsonl source. Always `file_content`.
                     *
                     * Expected to always return the following:
                     * ```java
                     * JsonValue.from("file_content")
                     * ```
                     *
                     * However, this method can be useful for debugging and logging (e.g. if the
                     * server responded with an unexpected value).
                     */
                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                    /**
                     * Returns the raw JSON value of [content].
                     *
                     * Unlike [content], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("content")
                    @ExcludeMissing
                    fun _content(): JsonField<List<Content>> = content

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
                         * Returns a mutable builder for constructing an instance of [FileContent].
                         *
                         * The following fields are required:
                         * ```java
                         * .content()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [FileContent]. */
                    class Builder internal constructor() {

                        private var content: JsonField<MutableList<Content>>? = null
                        private var type: JsonValue = JsonValue.from("file_content")
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(fileContent: FileContent) = apply {
                            content = fileContent.content.map { it.toMutableList() }
                            type = fileContent.type
                            additionalProperties = fileContent.additionalProperties.toMutableMap()
                        }

                        /** The content of the jsonl file. */
                        fun content(content: List<Content>) = content(JsonField.of(content))

                        /**
                         * Sets [Builder.content] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.content] with a well-typed
                         * `List<Content>` value instead. This method is primarily for setting the
                         * field to an undocumented or not yet supported value.
                         */
                        fun content(content: JsonField<List<Content>>) = apply {
                            this.content = content.map { it.toMutableList() }
                        }

                        /**
                         * Adds a single [Content] to [Builder.content].
                         *
                         * @throws IllegalStateException if the field was previously set to a
                         *   non-list.
                         */
                        fun addContent(content: Content) = apply {
                            this.content =
                                (this.content ?: JsonField.of(mutableListOf())).also {
                                    checkKnown("content", it).add(content)
                                }
                        }

                        /**
                         * Sets the field to an arbitrary JSON value.
                         *
                         * It is usually unnecessary to call this method because the field defaults
                         * to the following:
                         * ```java
                         * JsonValue.from("file_content")
                         * ```
                         *
                         * This method is primarily for setting the field to an undocumented or not
                         * yet supported value.
                         */
                        fun type(type: JsonValue) = apply { this.type = type }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [FileContent].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .content()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): FileContent =
                            FileContent(
                                checkRequired("content", content).map { it.toImmutable() },
                                type,
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    fun validate(): FileContent = apply {
                        if (validated) {
                            return@apply
                        }

                        content().forEach { it.validate() }
                        _type().let {
                            if (it != JsonValue.from("file_content")) {
                                throw OpenAIInvalidDataException("'type' is invalid, received $it")
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
                     * Returns a score indicating how many valid values are contained in this object
                     * recursively.
                     *
                     * Used for best match union deserialization.
                     */
                    @JvmSynthetic
                    internal fun validity(): Int =
                        (content.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                            type.let { if (it == JsonValue.from("file_content")) 1 else 0 }

                    class Content
                    private constructor(
                        private val item: JsonField<Item>,
                        private val sample: JsonField<Sample>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("item")
                            @ExcludeMissing
                            item: JsonField<Item> = JsonMissing.of(),
                            @JsonProperty("sample")
                            @ExcludeMissing
                            sample: JsonField<Sample> = JsonMissing.of(),
                        ) : this(item, sample, mutableMapOf())

                        /**
                         * @throws OpenAIInvalidDataException if the JSON field has an unexpected
                         *   type or is unexpectedly missing or null (e.g. if the server responded
                         *   with an unexpected value).
                         */
                        fun item(): Item = item.getRequired("item")

                        /**
                         * @throws OpenAIInvalidDataException if the JSON field has an unexpected
                         *   type (e.g. if the server responded with an unexpected value).
                         */
                        fun sample(): Optional<Sample> = sample.getOptional("sample")

                        /**
                         * Returns the raw JSON value of [item].
                         *
                         * Unlike [item], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("item") @ExcludeMissing fun _item(): JsonField<Item> = item

                        /**
                         * Returns the raw JSON value of [sample].
                         *
                         * Unlike [sample], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("sample")
                        @ExcludeMissing
                        fun _sample(): JsonField<Sample> = sample

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
                             * Returns a mutable builder for constructing an instance of [Content].
                             *
                             * The following fields are required:
                             * ```java
                             * .item()
                             * ```
                             */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [Content]. */
                        class Builder internal constructor() {

                            private var item: JsonField<Item>? = null
                            private var sample: JsonField<Sample> = JsonMissing.of()
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(content: Content) = apply {
                                item = content.item
                                sample = content.sample
                                additionalProperties = content.additionalProperties.toMutableMap()
                            }

                            fun item(item: Item) = item(JsonField.of(item))

                            /**
                             * Sets [Builder.item] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.item] with a well-typed [Item] value
                             * instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun item(item: JsonField<Item>) = apply { this.item = item }

                            fun sample(sample: Sample) = sample(JsonField.of(sample))

                            /**
                             * Sets [Builder.sample] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.sample] with a well-typed [Sample]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun sample(sample: JsonField<Sample>) = apply { this.sample = sample }

                            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                                apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                additionalProperties.put(key, value)
                            }

                            fun putAllAdditionalProperties(
                                additionalProperties: Map<String, JsonValue>
                            ) = apply { this.additionalProperties.putAll(additionalProperties) }

                            fun removeAdditionalProperty(key: String) = apply {
                                additionalProperties.remove(key)
                            }

                            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                keys.forEach(::removeAdditionalProperty)
                            }

                            /**
                             * Returns an immutable instance of [Content].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             *
                             * The following fields are required:
                             * ```java
                             * .item()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): Content =
                                Content(
                                    checkRequired("item", item),
                                    sample,
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): Content = apply {
                            if (validated) {
                                return@apply
                            }

                            item().validate()
                            sample().ifPresent { it.validate() }
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int =
                            (item.asKnown().getOrNull()?.validity() ?: 0) +
                                (sample.asKnown().getOrNull()?.validity() ?: 0)

                        class Item
                        @JsonCreator
                        private constructor(
                            @com.fasterxml.jackson.annotation.JsonValue
                            private val additionalProperties: Map<String, JsonValue>
                        ) {

                            @JsonAnyGetter
                            @ExcludeMissing
                            fun _additionalProperties(): Map<String, JsonValue> =
                                additionalProperties

                            fun toBuilder() = Builder().from(this)

                            companion object {

                                /**
                                 * Returns a mutable builder for constructing an instance of [Item].
                                 */
                                @JvmStatic fun builder() = Builder()
                            }

                            /** A builder for [Item]. */
                            class Builder internal constructor() {

                                private var additionalProperties: MutableMap<String, JsonValue> =
                                    mutableMapOf()

                                @JvmSynthetic
                                internal fun from(item: Item) = apply {
                                    additionalProperties = item.additionalProperties.toMutableMap()
                                }

                                fun additionalProperties(
                                    additionalProperties: Map<String, JsonValue>
                                ) = apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                    additionalProperties.put(key, value)
                                }

                                fun putAllAdditionalProperties(
                                    additionalProperties: Map<String, JsonValue>
                                ) = apply { this.additionalProperties.putAll(additionalProperties) }

                                fun removeAdditionalProperty(key: String) = apply {
                                    additionalProperties.remove(key)
                                }

                                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                    keys.forEach(::removeAdditionalProperty)
                                }

                                /**
                                 * Returns an immutable instance of [Item].
                                 *
                                 * Further updates to this [Builder] will not mutate the returned
                                 * instance.
                                 */
                                fun build(): Item = Item(additionalProperties.toImmutable())
                            }

                            private var validated: Boolean = false

                            fun validate(): Item = apply {
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
                             * Returns a score indicating how many valid values are contained in
                             * this object recursively.
                             *
                             * Used for best match union deserialization.
                             */
                            @JvmSynthetic
                            internal fun validity(): Int =
                                additionalProperties.count { (_, value) ->
                                    !value.isNull() && !value.isMissing()
                                }

                            override fun equals(other: Any?): Boolean {
                                if (this === other) {
                                    return true
                                }

                                return /* spotless:off */ other is Item && additionalProperties == other.additionalProperties /* spotless:on */
                            }

                            /* spotless:off */
                            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
                            /* spotless:on */

                            override fun hashCode(): Int = hashCode

                            override fun toString() =
                                "Item{additionalProperties=$additionalProperties}"
                        }

                        class Sample
                        @JsonCreator
                        private constructor(
                            @com.fasterxml.jackson.annotation.JsonValue
                            private val additionalProperties: Map<String, JsonValue>
                        ) {

                            @JsonAnyGetter
                            @ExcludeMissing
                            fun _additionalProperties(): Map<String, JsonValue> =
                                additionalProperties

                            fun toBuilder() = Builder().from(this)

                            companion object {

                                /**
                                 * Returns a mutable builder for constructing an instance of
                                 * [Sample].
                                 */
                                @JvmStatic fun builder() = Builder()
                            }

                            /** A builder for [Sample]. */
                            class Builder internal constructor() {

                                private var additionalProperties: MutableMap<String, JsonValue> =
                                    mutableMapOf()

                                @JvmSynthetic
                                internal fun from(sample: Sample) = apply {
                                    additionalProperties =
                                        sample.additionalProperties.toMutableMap()
                                }

                                fun additionalProperties(
                                    additionalProperties: Map<String, JsonValue>
                                ) = apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                    additionalProperties.put(key, value)
                                }

                                fun putAllAdditionalProperties(
                                    additionalProperties: Map<String, JsonValue>
                                ) = apply { this.additionalProperties.putAll(additionalProperties) }

                                fun removeAdditionalProperty(key: String) = apply {
                                    additionalProperties.remove(key)
                                }

                                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                    keys.forEach(::removeAdditionalProperty)
                                }

                                /**
                                 * Returns an immutable instance of [Sample].
                                 *
                                 * Further updates to this [Builder] will not mutate the returned
                                 * instance.
                                 */
                                fun build(): Sample = Sample(additionalProperties.toImmutable())
                            }

                            private var validated: Boolean = false

                            fun validate(): Sample = apply {
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
                             * Returns a score indicating how many valid values are contained in
                             * this object recursively.
                             *
                             * Used for best match union deserialization.
                             */
                            @JvmSynthetic
                            internal fun validity(): Int =
                                additionalProperties.count { (_, value) ->
                                    !value.isNull() && !value.isMissing()
                                }

                            override fun equals(other: Any?): Boolean {
                                if (this === other) {
                                    return true
                                }

                                return /* spotless:off */ other is Sample && additionalProperties == other.additionalProperties /* spotless:on */
                            }

                            /* spotless:off */
                            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
                            /* spotless:on */

                            override fun hashCode(): Int = hashCode

                            override fun toString() =
                                "Sample{additionalProperties=$additionalProperties}"
                        }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return /* spotless:off */ other is Content && item == other.item && sample == other.sample && additionalProperties == other.additionalProperties /* spotless:on */
                        }

                        /* spotless:off */
                        private val hashCode: Int by lazy { Objects.hash(item, sample, additionalProperties) }
                        /* spotless:on */

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "Content{item=$item, sample=$sample, additionalProperties=$additionalProperties}"
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is FileContent && content == other.content && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                    }

                    /* spotless:off */
                    private val hashCode: Int by lazy { Objects.hash(content, type, additionalProperties) }
                    /* spotless:on */

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "FileContent{content=$content, type=$type, additionalProperties=$additionalProperties}"
                }

                class FileId
                private constructor(
                    private val id: JsonField<String>,
                    private val type: JsonValue,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("id")
                        @ExcludeMissing
                        id: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                    ) : this(id, type, mutableMapOf())

                    /**
                     * The identifier of the file.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun id(): String = id.getRequired("id")

                    /**
                     * The type of jsonl source. Always `file_id`.
                     *
                     * Expected to always return the following:
                     * ```java
                     * JsonValue.from("file_id")
                     * ```
                     *
                     * However, this method can be useful for debugging and logging (e.g. if the
                     * server responded with an unexpected value).
                     */
                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                    /**
                     * Returns the raw JSON value of [id].
                     *
                     * Unlike [id], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

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
                         * Returns a mutable builder for constructing an instance of [FileId].
                         *
                         * The following fields are required:
                         * ```java
                         * .id()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [FileId]. */
                    class Builder internal constructor() {

                        private var id: JsonField<String>? = null
                        private var type: JsonValue = JsonValue.from("file_id")
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(fileId: FileId) = apply {
                            id = fileId.id
                            type = fileId.type
                            additionalProperties = fileId.additionalProperties.toMutableMap()
                        }

                        /** The identifier of the file. */
                        fun id(id: String) = id(JsonField.of(id))

                        /**
                         * Sets [Builder.id] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.id] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun id(id: JsonField<String>) = apply { this.id = id }

                        /**
                         * Sets the field to an arbitrary JSON value.
                         *
                         * It is usually unnecessary to call this method because the field defaults
                         * to the following:
                         * ```java
                         * JsonValue.from("file_id")
                         * ```
                         *
                         * This method is primarily for setting the field to an undocumented or not
                         * yet supported value.
                         */
                        fun type(type: JsonValue) = apply { this.type = type }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [FileId].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .id()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): FileId =
                            FileId(
                                checkRequired("id", id),
                                type,
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    fun validate(): FileId = apply {
                        if (validated) {
                            return@apply
                        }

                        id()
                        _type().let {
                            if (it != JsonValue.from("file_id")) {
                                throw OpenAIInvalidDataException("'type' is invalid, received $it")
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
                     * Returns a score indicating how many valid values are contained in this object
                     * recursively.
                     *
                     * Used for best match union deserialization.
                     */
                    @JvmSynthetic
                    internal fun validity(): Int =
                        (if (id.asKnown().isPresent) 1 else 0) +
                            type.let { if (it == JsonValue.from("file_id")) 1 else 0 }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is FileId && id == other.id && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                    }

                    /* spotless:off */
                    private val hashCode: Int by lazy { Objects.hash(id, type, additionalProperties) }
                    /* spotless:on */

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "FileId{id=$id, type=$type, additionalProperties=$additionalProperties}"
                }

                /** A EvalResponsesSource object describing a run data source configuration. */
                class Responses
                private constructor(
                    private val type: JsonValue,
                    private val allowParallelToolCalls: JsonField<Boolean>,
                    private val createdAfter: JsonField<Long>,
                    private val createdBefore: JsonField<Long>,
                    private val hasToolCalls: JsonField<Boolean>,
                    private val instructionsSearch: JsonField<String>,
                    private val metadata: JsonValue,
                    private val model: JsonField<String>,
                    private val reasoningEffort: JsonField<ReasoningEffort>,
                    private val temperature: JsonField<Double>,
                    private val topP: JsonField<Double>,
                    private val users: JsonField<List<String>>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                        @JsonProperty("allow_parallel_tool_calls")
                        @ExcludeMissing
                        allowParallelToolCalls: JsonField<Boolean> = JsonMissing.of(),
                        @JsonProperty("created_after")
                        @ExcludeMissing
                        createdAfter: JsonField<Long> = JsonMissing.of(),
                        @JsonProperty("created_before")
                        @ExcludeMissing
                        createdBefore: JsonField<Long> = JsonMissing.of(),
                        @JsonProperty("has_tool_calls")
                        @ExcludeMissing
                        hasToolCalls: JsonField<Boolean> = JsonMissing.of(),
                        @JsonProperty("instructions_search")
                        @ExcludeMissing
                        instructionsSearch: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("metadata")
                        @ExcludeMissing
                        metadata: JsonValue = JsonMissing.of(),
                        @JsonProperty("model")
                        @ExcludeMissing
                        model: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("reasoning_effort")
                        @ExcludeMissing
                        reasoningEffort: JsonField<ReasoningEffort> = JsonMissing.of(),
                        @JsonProperty("temperature")
                        @ExcludeMissing
                        temperature: JsonField<Double> = JsonMissing.of(),
                        @JsonProperty("top_p")
                        @ExcludeMissing
                        topP: JsonField<Double> = JsonMissing.of(),
                        @JsonProperty("users")
                        @ExcludeMissing
                        users: JsonField<List<String>> = JsonMissing.of(),
                    ) : this(
                        type,
                        allowParallelToolCalls,
                        createdAfter,
                        createdBefore,
                        hasToolCalls,
                        instructionsSearch,
                        metadata,
                        model,
                        reasoningEffort,
                        temperature,
                        topP,
                        users,
                        mutableMapOf(),
                    )

                    /**
                     * The type of run data source. Always `responses`.
                     *
                     * Expected to always return the following:
                     * ```java
                     * JsonValue.from("responses")
                     * ```
                     *
                     * However, this method can be useful for debugging and logging (e.g. if the
                     * server responded with an unexpected value).
                     */
                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                    /**
                     * Whether to allow parallel tool calls. This is a query parameter used to
                     * select responses.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun allowParallelToolCalls(): Optional<Boolean> =
                        allowParallelToolCalls.getOptional("allow_parallel_tool_calls")

                    /**
                     * Only include items created after this timestamp (inclusive). This is a query
                     * parameter used to select responses.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun createdAfter(): Optional<Long> = createdAfter.getOptional("created_after")

                    /**
                     * Only include items created before this timestamp (inclusive). This is a query
                     * parameter used to select responses.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun createdBefore(): Optional<Long> =
                        createdBefore.getOptional("created_before")

                    /**
                     * Whether the response has tool calls. This is a query parameter used to select
                     * responses.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun hasToolCalls(): Optional<Boolean> =
                        hasToolCalls.getOptional("has_tool_calls")

                    /**
                     * Optional search string for instructions. This is a query parameter used to
                     * select responses.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun instructionsSearch(): Optional<String> =
                        instructionsSearch.getOptional("instructions_search")

                    /**
                     * Metadata filter for the responses. This is a query parameter used to select
                     * responses.
                     */
                    @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonValue = metadata

                    /**
                     * The name of the model to find responses for. This is a query parameter used
                     * to select responses.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun model(): Optional<String> = model.getOptional("model")

                    /**
                     * Optional reasoning effort parameter. This is a query parameter used to select
                     * responses.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun reasoningEffort(): Optional<ReasoningEffort> =
                        reasoningEffort.getOptional("reasoning_effort")

                    /**
                     * Sampling temperature. This is a query parameter used to select responses.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun temperature(): Optional<Double> = temperature.getOptional("temperature")

                    /**
                     * Nucleus sampling parameter. This is a query parameter used to select
                     * responses.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun topP(): Optional<Double> = topP.getOptional("top_p")

                    /**
                     * List of user identifiers. This is a query parameter used to select responses.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun users(): Optional<List<String>> = users.getOptional("users")

                    /**
                     * Returns the raw JSON value of [allowParallelToolCalls].
                     *
                     * Unlike [allowParallelToolCalls], this method doesn't throw if the JSON field
                     * has an unexpected type.
                     */
                    @JsonProperty("allow_parallel_tool_calls")
                    @ExcludeMissing
                    fun _allowParallelToolCalls(): JsonField<Boolean> = allowParallelToolCalls

                    /**
                     * Returns the raw JSON value of [createdAfter].
                     *
                     * Unlike [createdAfter], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("created_after")
                    @ExcludeMissing
                    fun _createdAfter(): JsonField<Long> = createdAfter

                    /**
                     * Returns the raw JSON value of [createdBefore].
                     *
                     * Unlike [createdBefore], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("created_before")
                    @ExcludeMissing
                    fun _createdBefore(): JsonField<Long> = createdBefore

                    /**
                     * Returns the raw JSON value of [hasToolCalls].
                     *
                     * Unlike [hasToolCalls], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("has_tool_calls")
                    @ExcludeMissing
                    fun _hasToolCalls(): JsonField<Boolean> = hasToolCalls

                    /**
                     * Returns the raw JSON value of [instructionsSearch].
                     *
                     * Unlike [instructionsSearch], this method doesn't throw if the JSON field has
                     * an unexpected type.
                     */
                    @JsonProperty("instructions_search")
                    @ExcludeMissing
                    fun _instructionsSearch(): JsonField<String> = instructionsSearch

                    /**
                     * Returns the raw JSON value of [model].
                     *
                     * Unlike [model], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

                    /**
                     * Returns the raw JSON value of [reasoningEffort].
                     *
                     * Unlike [reasoningEffort], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("reasoning_effort")
                    @ExcludeMissing
                    fun _reasoningEffort(): JsonField<ReasoningEffort> = reasoningEffort

                    /**
                     * Returns the raw JSON value of [temperature].
                     *
                     * Unlike [temperature], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("temperature")
                    @ExcludeMissing
                    fun _temperature(): JsonField<Double> = temperature

                    /**
                     * Returns the raw JSON value of [topP].
                     *
                     * Unlike [topP], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("top_p") @ExcludeMissing fun _topP(): JsonField<Double> = topP

                    /**
                     * Returns the raw JSON value of [users].
                     *
                     * Unlike [users], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("users")
                    @ExcludeMissing
                    fun _users(): JsonField<List<String>> = users

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
                         * Returns a mutable builder for constructing an instance of [Responses].
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Responses]. */
                    class Builder internal constructor() {

                        private var type: JsonValue = JsonValue.from("responses")
                        private var allowParallelToolCalls: JsonField<Boolean> = JsonMissing.of()
                        private var createdAfter: JsonField<Long> = JsonMissing.of()
                        private var createdBefore: JsonField<Long> = JsonMissing.of()
                        private var hasToolCalls: JsonField<Boolean> = JsonMissing.of()
                        private var instructionsSearch: JsonField<String> = JsonMissing.of()
                        private var metadata: JsonValue = JsonMissing.of()
                        private var model: JsonField<String> = JsonMissing.of()
                        private var reasoningEffort: JsonField<ReasoningEffort> = JsonMissing.of()
                        private var temperature: JsonField<Double> = JsonMissing.of()
                        private var topP: JsonField<Double> = JsonMissing.of()
                        private var users: JsonField<MutableList<String>>? = null
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(responses: Responses) = apply {
                            type = responses.type
                            allowParallelToolCalls = responses.allowParallelToolCalls
                            createdAfter = responses.createdAfter
                            createdBefore = responses.createdBefore
                            hasToolCalls = responses.hasToolCalls
                            instructionsSearch = responses.instructionsSearch
                            metadata = responses.metadata
                            model = responses.model
                            reasoningEffort = responses.reasoningEffort
                            temperature = responses.temperature
                            topP = responses.topP
                            users = responses.users.map { it.toMutableList() }
                            additionalProperties = responses.additionalProperties.toMutableMap()
                        }

                        /**
                         * Sets the field to an arbitrary JSON value.
                         *
                         * It is usually unnecessary to call this method because the field defaults
                         * to the following:
                         * ```java
                         * JsonValue.from("responses")
                         * ```
                         *
                         * This method is primarily for setting the field to an undocumented or not
                         * yet supported value.
                         */
                        fun type(type: JsonValue) = apply { this.type = type }

                        /**
                         * Whether to allow parallel tool calls. This is a query parameter used to
                         * select responses.
                         */
                        fun allowParallelToolCalls(allowParallelToolCalls: Boolean?) =
                            allowParallelToolCalls(JsonField.ofNullable(allowParallelToolCalls))

                        /**
                         * Alias for [Builder.allowParallelToolCalls].
                         *
                         * This unboxed primitive overload exists for backwards compatibility.
                         */
                        fun allowParallelToolCalls(allowParallelToolCalls: Boolean) =
                            allowParallelToolCalls(allowParallelToolCalls as Boolean?)

                        /**
                         * Alias for calling [Builder.allowParallelToolCalls] with
                         * `allowParallelToolCalls.orElse(null)`.
                         */
                        fun allowParallelToolCalls(allowParallelToolCalls: Optional<Boolean>) =
                            allowParallelToolCalls(allowParallelToolCalls.getOrNull())

                        /**
                         * Sets [Builder.allowParallelToolCalls] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.allowParallelToolCalls] with a
                         * well-typed [Boolean] value instead. This method is primarily for setting
                         * the field to an undocumented or not yet supported value.
                         */
                        fun allowParallelToolCalls(allowParallelToolCalls: JsonField<Boolean>) =
                            apply {
                                this.allowParallelToolCalls = allowParallelToolCalls
                            }

                        /**
                         * Only include items created after this timestamp (inclusive). This is a
                         * query parameter used to select responses.
                         */
                        fun createdAfter(createdAfter: Long?) =
                            createdAfter(JsonField.ofNullable(createdAfter))

                        /**
                         * Alias for [Builder.createdAfter].
                         *
                         * This unboxed primitive overload exists for backwards compatibility.
                         */
                        fun createdAfter(createdAfter: Long) = createdAfter(createdAfter as Long?)

                        /**
                         * Alias for calling [Builder.createdAfter] with
                         * `createdAfter.orElse(null)`.
                         */
                        fun createdAfter(createdAfter: Optional<Long>) =
                            createdAfter(createdAfter.getOrNull())

                        /**
                         * Sets [Builder.createdAfter] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.createdAfter] with a well-typed [Long]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun createdAfter(createdAfter: JsonField<Long>) = apply {
                            this.createdAfter = createdAfter
                        }

                        /**
                         * Only include items created before this timestamp (inclusive). This is a
                         * query parameter used to select responses.
                         */
                        fun createdBefore(createdBefore: Long?) =
                            createdBefore(JsonField.ofNullable(createdBefore))

                        /**
                         * Alias for [Builder.createdBefore].
                         *
                         * This unboxed primitive overload exists for backwards compatibility.
                         */
                        fun createdBefore(createdBefore: Long) =
                            createdBefore(createdBefore as Long?)

                        /**
                         * Alias for calling [Builder.createdBefore] with
                         * `createdBefore.orElse(null)`.
                         */
                        fun createdBefore(createdBefore: Optional<Long>) =
                            createdBefore(createdBefore.getOrNull())

                        /**
                         * Sets [Builder.createdBefore] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.createdBefore] with a well-typed [Long]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun createdBefore(createdBefore: JsonField<Long>) = apply {
                            this.createdBefore = createdBefore
                        }

                        /**
                         * Whether the response has tool calls. This is a query parameter used to
                         * select responses.
                         */
                        fun hasToolCalls(hasToolCalls: Boolean?) =
                            hasToolCalls(JsonField.ofNullable(hasToolCalls))

                        /**
                         * Alias for [Builder.hasToolCalls].
                         *
                         * This unboxed primitive overload exists for backwards compatibility.
                         */
                        fun hasToolCalls(hasToolCalls: Boolean) =
                            hasToolCalls(hasToolCalls as Boolean?)

                        /**
                         * Alias for calling [Builder.hasToolCalls] with
                         * `hasToolCalls.orElse(null)`.
                         */
                        fun hasToolCalls(hasToolCalls: Optional<Boolean>) =
                            hasToolCalls(hasToolCalls.getOrNull())

                        /**
                         * Sets [Builder.hasToolCalls] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.hasToolCalls] with a well-typed
                         * [Boolean] value instead. This method is primarily for setting the field
                         * to an undocumented or not yet supported value.
                         */
                        fun hasToolCalls(hasToolCalls: JsonField<Boolean>) = apply {
                            this.hasToolCalls = hasToolCalls
                        }

                        /**
                         * Optional search string for instructions. This is a query parameter used
                         * to select responses.
                         */
                        fun instructionsSearch(instructionsSearch: String?) =
                            instructionsSearch(JsonField.ofNullable(instructionsSearch))

                        /**
                         * Alias for calling [Builder.instructionsSearch] with
                         * `instructionsSearch.orElse(null)`.
                         */
                        fun instructionsSearch(instructionsSearch: Optional<String>) =
                            instructionsSearch(instructionsSearch.getOrNull())

                        /**
                         * Sets [Builder.instructionsSearch] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.instructionsSearch] with a well-typed
                         * [String] value instead. This method is primarily for setting the field to
                         * an undocumented or not yet supported value.
                         */
                        fun instructionsSearch(instructionsSearch: JsonField<String>) = apply {
                            this.instructionsSearch = instructionsSearch
                        }

                        /**
                         * Metadata filter for the responses. This is a query parameter used to
                         * select responses.
                         */
                        fun metadata(metadata: JsonValue) = apply { this.metadata = metadata }

                        /**
                         * The name of the model to find responses for. This is a query parameter
                         * used to select responses.
                         */
                        fun model(model: String?) = model(JsonField.ofNullable(model))

                        /** Alias for calling [Builder.model] with `model.orElse(null)`. */
                        fun model(model: Optional<String>) = model(model.getOrNull())

                        /**
                         * Sets [Builder.model] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.model] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun model(model: JsonField<String>) = apply { this.model = model }

                        /**
                         * Optional reasoning effort parameter. This is a query parameter used to
                         * select responses.
                         */
                        fun reasoningEffort(reasoningEffort: ReasoningEffort?) =
                            reasoningEffort(JsonField.ofNullable(reasoningEffort))

                        /**
                         * Alias for calling [Builder.reasoningEffort] with
                         * `reasoningEffort.orElse(null)`.
                         */
                        fun reasoningEffort(reasoningEffort: Optional<ReasoningEffort>) =
                            reasoningEffort(reasoningEffort.getOrNull())

                        /**
                         * Sets [Builder.reasoningEffort] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.reasoningEffort] with a well-typed
                         * [ReasoningEffort] value instead. This method is primarily for setting the
                         * field to an undocumented or not yet supported value.
                         */
                        fun reasoningEffort(reasoningEffort: JsonField<ReasoningEffort>) = apply {
                            this.reasoningEffort = reasoningEffort
                        }

                        /**
                         * Sampling temperature. This is a query parameter used to select responses.
                         */
                        fun temperature(temperature: Double?) =
                            temperature(JsonField.ofNullable(temperature))

                        /**
                         * Alias for [Builder.temperature].
                         *
                         * This unboxed primitive overload exists for backwards compatibility.
                         */
                        fun temperature(temperature: Double) = temperature(temperature as Double?)

                        /**
                         * Alias for calling [Builder.temperature] with `temperature.orElse(null)`.
                         */
                        fun temperature(temperature: Optional<Double>) =
                            temperature(temperature.getOrNull())

                        /**
                         * Sets [Builder.temperature] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.temperature] with a well-typed [Double]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun temperature(temperature: JsonField<Double>) = apply {
                            this.temperature = temperature
                        }

                        /**
                         * Nucleus sampling parameter. This is a query parameter used to select
                         * responses.
                         */
                        fun topP(topP: Double?) = topP(JsonField.ofNullable(topP))

                        /**
                         * Alias for [Builder.topP].
                         *
                         * This unboxed primitive overload exists for backwards compatibility.
                         */
                        fun topP(topP: Double) = topP(topP as Double?)

                        /** Alias for calling [Builder.topP] with `topP.orElse(null)`. */
                        fun topP(topP: Optional<Double>) = topP(topP.getOrNull())

                        /**
                         * Sets [Builder.topP] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.topP] with a well-typed [Double] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun topP(topP: JsonField<Double>) = apply { this.topP = topP }

                        /**
                         * List of user identifiers. This is a query parameter used to select
                         * responses.
                         */
                        fun users(users: List<String>?) = users(JsonField.ofNullable(users))

                        /** Alias for calling [Builder.users] with `users.orElse(null)`. */
                        fun users(users: Optional<List<String>>) = users(users.getOrNull())

                        /**
                         * Sets [Builder.users] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.users] with a well-typed `List<String>`
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun users(users: JsonField<List<String>>) = apply {
                            this.users = users.map { it.toMutableList() }
                        }

                        /**
                         * Adds a single [String] to [users].
                         *
                         * @throws IllegalStateException if the field was previously set to a
                         *   non-list.
                         */
                        fun addUser(user: String) = apply {
                            users =
                                (users ?: JsonField.of(mutableListOf())).also {
                                    checkKnown("users", it).add(user)
                                }
                        }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [Responses].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): Responses =
                            Responses(
                                type,
                                allowParallelToolCalls,
                                createdAfter,
                                createdBefore,
                                hasToolCalls,
                                instructionsSearch,
                                metadata,
                                model,
                                reasoningEffort,
                                temperature,
                                topP,
                                (users ?: JsonMissing.of()).map { it.toImmutable() },
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    fun validate(): Responses = apply {
                        if (validated) {
                            return@apply
                        }

                        _type().let {
                            if (it != JsonValue.from("responses")) {
                                throw OpenAIInvalidDataException("'type' is invalid, received $it")
                            }
                        }
                        allowParallelToolCalls()
                        createdAfter()
                        createdBefore()
                        hasToolCalls()
                        instructionsSearch()
                        model()
                        reasoningEffort().ifPresent { it.validate() }
                        temperature()
                        topP()
                        users()
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
                        type.let { if (it == JsonValue.from("responses")) 1 else 0 } +
                            (if (allowParallelToolCalls.asKnown().isPresent) 1 else 0) +
                            (if (createdAfter.asKnown().isPresent) 1 else 0) +
                            (if (createdBefore.asKnown().isPresent) 1 else 0) +
                            (if (hasToolCalls.asKnown().isPresent) 1 else 0) +
                            (if (instructionsSearch.asKnown().isPresent) 1 else 0) +
                            (if (model.asKnown().isPresent) 1 else 0) +
                            (reasoningEffort.asKnown().getOrNull()?.validity() ?: 0) +
                            (if (temperature.asKnown().isPresent) 1 else 0) +
                            (if (topP.asKnown().isPresent) 1 else 0) +
                            (users.asKnown().getOrNull()?.size ?: 0)

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is Responses && type == other.type && allowParallelToolCalls == other.allowParallelToolCalls && createdAfter == other.createdAfter && createdBefore == other.createdBefore && hasToolCalls == other.hasToolCalls && instructionsSearch == other.instructionsSearch && metadata == other.metadata && model == other.model && reasoningEffort == other.reasoningEffort && temperature == other.temperature && topP == other.topP && users == other.users && additionalProperties == other.additionalProperties /* spotless:on */
                    }

                    /* spotless:off */
                    private val hashCode: Int by lazy { Objects.hash(type, allowParallelToolCalls, createdAfter, createdBefore, hasToolCalls, instructionsSearch, metadata, model, reasoningEffort, temperature, topP, users, additionalProperties) }
                    /* spotless:on */

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Responses{type=$type, allowParallelToolCalls=$allowParallelToolCalls, createdAfter=$createdAfter, createdBefore=$createdBefore, hasToolCalls=$hasToolCalls, instructionsSearch=$instructionsSearch, metadata=$metadata, model=$model, reasoningEffort=$reasoningEffort, temperature=$temperature, topP=$topP, users=$users, additionalProperties=$additionalProperties}"
                }
            }

            /** The type of run data source. Always `completions`. */
            class Type @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val COMPLETIONS = of("completions")

                    @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                }

                /** An enum containing [Type]'s known values. */
                enum class Known {
                    COMPLETIONS
                }

                /**
                 * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Type] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    COMPLETIONS,
                    /**
                     * An enum member indicating that [Type] was instantiated with an unknown value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        COMPLETIONS -> Value.COMPLETIONS
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws OpenAIInvalidDataException if this class instance's value is a not a
                 *   known member.
                 */
                fun known(): Known =
                    when (this) {
                        COMPLETIONS -> Known.COMPLETIONS
                        else -> throw OpenAIInvalidDataException("Unknown Type: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws OpenAIInvalidDataException if this class instance's value does not have
                 *   the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        OpenAIInvalidDataException("Value is not a String")
                    }

                private var validated: Boolean = false

                fun validate(): Type = apply {
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

                    return /* spotless:off */ other is Type && value == other.value /* spotless:on */
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            @JsonDeserialize(using = InputMessages.Deserializer::class)
            @JsonSerialize(using = InputMessages.Serializer::class)
            class InputMessages
            private constructor(
                private val template: Template? = null,
                private val itemReference: ItemReference? = null,
                private val _json: JsonValue? = null,
            ) {

                fun template(): Optional<Template> = Optional.ofNullable(template)

                fun itemReference(): Optional<ItemReference> = Optional.ofNullable(itemReference)

                fun isTemplate(): Boolean = template != null

                fun isItemReference(): Boolean = itemReference != null

                fun asTemplate(): Template = template.getOrThrow("template")

                fun asItemReference(): ItemReference = itemReference.getOrThrow("itemReference")

                fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                fun <T> accept(visitor: Visitor<T>): T =
                    when {
                        template != null -> visitor.visitTemplate(template)
                        itemReference != null -> visitor.visitItemReference(itemReference)
                        else -> visitor.unknown(_json)
                    }

                private var validated: Boolean = false

                fun validate(): InputMessages = apply {
                    if (validated) {
                        return@apply
                    }

                    accept(
                        object : Visitor<Unit> {
                            override fun visitTemplate(template: Template) {
                                template.validate()
                            }

                            override fun visitItemReference(itemReference: ItemReference) {
                                itemReference.validate()
                            }
                        }
                    )
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
                    accept(
                        object : Visitor<Int> {
                            override fun visitTemplate(template: Template) = template.validity()

                            override fun visitItemReference(itemReference: ItemReference) =
                                itemReference.validity()

                            override fun unknown(json: JsonValue?) = 0
                        }
                    )

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is InputMessages && template == other.template && itemReference == other.itemReference /* spotless:on */
                }

                override fun hashCode(): Int = /* spotless:off */ Objects.hash(template, itemReference) /* spotless:on */

                override fun toString(): String =
                    when {
                        template != null -> "InputMessages{template=$template}"
                        itemReference != null -> "InputMessages{itemReference=$itemReference}"
                        _json != null -> "InputMessages{_unknown=$_json}"
                        else -> throw IllegalStateException("Invalid InputMessages")
                    }

                companion object {

                    @JvmStatic
                    fun ofTemplate(template: Template) = InputMessages(template = template)

                    @JvmStatic
                    fun ofItemReference(itemReference: ItemReference) =
                        InputMessages(itemReference = itemReference)
                }

                /**
                 * An interface that defines how to map each variant of [InputMessages] to a value
                 * of type [T].
                 */
                interface Visitor<out T> {

                    fun visitTemplate(template: Template): T

                    fun visitItemReference(itemReference: ItemReference): T

                    /**
                     * Maps an unknown variant of [InputMessages] to a value of type [T].
                     *
                     * An instance of [InputMessages] can contain an unknown variant if it was
                     * deserialized from data that doesn't match any known variant. For example, if
                     * the SDK is on an older version than the API, then the API may respond with
                     * new variants that the SDK is unaware of.
                     *
                     * @throws OpenAIInvalidDataException in the default implementation.
                     */
                    fun unknown(json: JsonValue?): T {
                        throw OpenAIInvalidDataException("Unknown InputMessages: $json")
                    }
                }

                internal class Deserializer :
                    BaseDeserializer<InputMessages>(InputMessages::class) {

                    override fun ObjectCodec.deserialize(node: JsonNode): InputMessages {
                        val json = JsonValue.fromJsonNode(node)
                        val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                        when (type) {
                            "template" -> {
                                return tryDeserialize(node, jacksonTypeRef<Template>())?.let {
                                    InputMessages(template = it, _json = json)
                                } ?: InputMessages(_json = json)
                            }
                            "item_reference" -> {
                                return tryDeserialize(node, jacksonTypeRef<ItemReference>())?.let {
                                    InputMessages(itemReference = it, _json = json)
                                } ?: InputMessages(_json = json)
                            }
                        }

                        return InputMessages(_json = json)
                    }
                }

                internal class Serializer : BaseSerializer<InputMessages>(InputMessages::class) {

                    override fun serialize(
                        value: InputMessages,
                        generator: JsonGenerator,
                        provider: SerializerProvider,
                    ) {
                        when {
                            value.template != null -> generator.writeObject(value.template)
                            value.itemReference != null ->
                                generator.writeObject(value.itemReference)
                            value._json != null -> generator.writeObject(value._json)
                            else -> throw IllegalStateException("Invalid InputMessages")
                        }
                    }
                }

                class Template
                private constructor(
                    private val template: JsonField<List<InnerTemplate>>,
                    private val type: JsonValue,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("template")
                        @ExcludeMissing
                        template: JsonField<List<InnerTemplate>> = JsonMissing.of(),
                        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                    ) : this(template, type, mutableMapOf())

                    /**
                     * A list of chat messages forming the prompt or context. May include variable
                     * references to the "item" namespace, ie {{item.name}}.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun template(): List<InnerTemplate> = template.getRequired("template")

                    /**
                     * The type of input messages. Always `template`.
                     *
                     * Expected to always return the following:
                     * ```java
                     * JsonValue.from("template")
                     * ```
                     *
                     * However, this method can be useful for debugging and logging (e.g. if the
                     * server responded with an unexpected value).
                     */
                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                    /**
                     * Returns the raw JSON value of [template].
                     *
                     * Unlike [template], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("template")
                    @ExcludeMissing
                    fun _template(): JsonField<List<InnerTemplate>> = template

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
                         * Returns a mutable builder for constructing an instance of [Template].
                         *
                         * The following fields are required:
                         * ```java
                         * .template()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Template]. */
                    class Builder internal constructor() {

                        private var template: JsonField<MutableList<InnerTemplate>>? = null
                        private var type: JsonValue = JsonValue.from("template")
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(template: Template) = apply {
                            this.template = template.template.map { it.toMutableList() }
                            type = template.type
                            additionalProperties = template.additionalProperties.toMutableMap()
                        }

                        /**
                         * A list of chat messages forming the prompt or context. May include
                         * variable references to the "item" namespace, ie {{item.name}}.
                         */
                        fun template(template: List<InnerTemplate>) =
                            template(JsonField.of(template))

                        /**
                         * Sets [Builder.template] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.template] with a well-typed
                         * `List<InnerTemplate>` value instead. This method is primarily for setting
                         * the field to an undocumented or not yet supported value.
                         */
                        fun template(template: JsonField<List<InnerTemplate>>) = apply {
                            this.template = template.map { it.toMutableList() }
                        }

                        /**
                         * Adds a single [InnerTemplate] to [Builder.template].
                         *
                         * @throws IllegalStateException if the field was previously set to a
                         *   non-list.
                         */
                        fun addTemplate(template: InnerTemplate) = apply {
                            this.template =
                                (this.template ?: JsonField.of(mutableListOf())).also {
                                    checkKnown("template", it).add(template)
                                }
                        }

                        /**
                         * Alias for calling [addTemplate] with
                         * `InnerTemplate.ofChatMessage(chatMessage)`.
                         */
                        fun addTemplate(chatMessage: InnerTemplate.ChatMessage) =
                            addTemplate(InnerTemplate.ofChatMessage(chatMessage))

                        /**
                         * Alias for calling [addTemplate] with
                         * `InnerTemplate.ofEvalItem(evalItem)`.
                         */
                        fun addTemplate(evalItem: InnerTemplate.EvalItem) =
                            addTemplate(InnerTemplate.ofEvalItem(evalItem))

                        /**
                         * Sets the field to an arbitrary JSON value.
                         *
                         * It is usually unnecessary to call this method because the field defaults
                         * to the following:
                         * ```java
                         * JsonValue.from("template")
                         * ```
                         *
                         * This method is primarily for setting the field to an undocumented or not
                         * yet supported value.
                         */
                        fun type(type: JsonValue) = apply { this.type = type }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [Template].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .template()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): Template =
                            Template(
                                checkRequired("template", template).map { it.toImmutable() },
                                type,
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    fun validate(): Template = apply {
                        if (validated) {
                            return@apply
                        }

                        template().forEach { it.validate() }
                        _type().let {
                            if (it != JsonValue.from("template")) {
                                throw OpenAIInvalidDataException("'type' is invalid, received $it")
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
                     * Returns a score indicating how many valid values are contained in this object
                     * recursively.
                     *
                     * Used for best match union deserialization.
                     */
                    @JvmSynthetic
                    internal fun validity(): Int =
                        (template.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                            type.let { if (it == JsonValue.from("template")) 1 else 0 }

                    /**
                     * A message input to the model with a role indicating instruction following
                     * hierarchy. Instructions given with the `developer` or `system` role take
                     * precedence over instructions given with the `user` role. Messages with the
                     * `assistant` role are presumed to have been generated by the model in previous
                     * interactions.
                     */
                    @JsonDeserialize(using = InnerTemplate.Deserializer::class)
                    @JsonSerialize(using = InnerTemplate.Serializer::class)
                    class InnerTemplate
                    private constructor(
                        private val chatMessage: ChatMessage? = null,
                        private val evalItem: EvalItem? = null,
                        private val _json: JsonValue? = null,
                    ) {

                        fun chatMessage(): Optional<ChatMessage> = Optional.ofNullable(chatMessage)

                        /**
                         * A message input to the model with a role indicating instruction following
                         * hierarchy. Instructions given with the `developer` or `system` role take
                         * precedence over instructions given with the `user` role. Messages with
                         * the `assistant` role are presumed to have been generated by the model in
                         * previous interactions.
                         */
                        fun evalItem(): Optional<EvalItem> = Optional.ofNullable(evalItem)

                        fun isChatMessage(): Boolean = chatMessage != null

                        fun isEvalItem(): Boolean = evalItem != null

                        fun asChatMessage(): ChatMessage = chatMessage.getOrThrow("chatMessage")

                        /**
                         * A message input to the model with a role indicating instruction following
                         * hierarchy. Instructions given with the `developer` or `system` role take
                         * precedence over instructions given with the `user` role. Messages with
                         * the `assistant` role are presumed to have been generated by the model in
                         * previous interactions.
                         */
                        fun asEvalItem(): EvalItem = evalItem.getOrThrow("evalItem")

                        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                        fun <T> accept(visitor: Visitor<T>): T =
                            when {
                                chatMessage != null -> visitor.visitChatMessage(chatMessage)
                                evalItem != null -> visitor.visitEvalItem(evalItem)
                                else -> visitor.unknown(_json)
                            }

                        private var validated: Boolean = false

                        fun validate(): InnerTemplate = apply {
                            if (validated) {
                                return@apply
                            }

                            accept(
                                object : Visitor<Unit> {
                                    override fun visitChatMessage(chatMessage: ChatMessage) {
                                        chatMessage.validate()
                                    }

                                    override fun visitEvalItem(evalItem: EvalItem) {
                                        evalItem.validate()
                                    }
                                }
                            )
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int =
                            accept(
                                object : Visitor<Int> {
                                    override fun visitChatMessage(chatMessage: ChatMessage) =
                                        chatMessage.validity()

                                    override fun visitEvalItem(evalItem: EvalItem) =
                                        evalItem.validity()

                                    override fun unknown(json: JsonValue?) = 0
                                }
                            )

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return /* spotless:off */ other is InnerTemplate && chatMessage == other.chatMessage && evalItem == other.evalItem /* spotless:on */
                        }

                        override fun hashCode(): Int = /* spotless:off */ Objects.hash(chatMessage, evalItem) /* spotless:on */

                        override fun toString(): String =
                            when {
                                chatMessage != null -> "InnerTemplate{chatMessage=$chatMessage}"
                                evalItem != null -> "InnerTemplate{evalItem=$evalItem}"
                                _json != null -> "InnerTemplate{_unknown=$_json}"
                                else -> throw IllegalStateException("Invalid InnerTemplate")
                            }

                        companion object {

                            @JvmStatic
                            fun ofChatMessage(chatMessage: ChatMessage) =
                                InnerTemplate(chatMessage = chatMessage)

                            /**
                             * A message input to the model with a role indicating instruction
                             * following hierarchy. Instructions given with the `developer` or
                             * `system` role take precedence over instructions given with the `user`
                             * role. Messages with the `assistant` role are presumed to have been
                             * generated by the model in previous interactions.
                             */
                            @JvmStatic
                            fun ofEvalItem(evalItem: EvalItem) = InnerTemplate(evalItem = evalItem)
                        }

                        /**
                         * An interface that defines how to map each variant of [InnerTemplate] to a
                         * value of type [T].
                         */
                        interface Visitor<out T> {

                            fun visitChatMessage(chatMessage: ChatMessage): T

                            /**
                             * A message input to the model with a role indicating instruction
                             * following hierarchy. Instructions given with the `developer` or
                             * `system` role take precedence over instructions given with the `user`
                             * role. Messages with the `assistant` role are presumed to have been
                             * generated by the model in previous interactions.
                             */
                            fun visitEvalItem(evalItem: EvalItem): T

                            /**
                             * Maps an unknown variant of [InnerTemplate] to a value of type [T].
                             *
                             * An instance of [InnerTemplate] can contain an unknown variant if it
                             * was deserialized from data that doesn't match any known variant. For
                             * example, if the SDK is on an older version than the API, then the API
                             * may respond with new variants that the SDK is unaware of.
                             *
                             * @throws OpenAIInvalidDataException in the default implementation.
                             */
                            fun unknown(json: JsonValue?): T {
                                throw OpenAIInvalidDataException("Unknown InnerTemplate: $json")
                            }
                        }

                        internal class Deserializer :
                            BaseDeserializer<InnerTemplate>(InnerTemplate::class) {

                            override fun ObjectCodec.deserialize(node: JsonNode): InnerTemplate {
                                val json = JsonValue.fromJsonNode(node)

                                val bestMatches =
                                    sequenceOf(
                                            tryDeserialize(node, jacksonTypeRef<ChatMessage>())
                                                ?.let {
                                                    InnerTemplate(chatMessage = it, _json = json)
                                                },
                                            tryDeserialize(node, jacksonTypeRef<EvalItem>())?.let {
                                                InnerTemplate(evalItem = it, _json = json)
                                            },
                                        )
                                        .filterNotNull()
                                        .allMaxBy { it.validity() }
                                        .toList()
                                return when (bestMatches.size) {
                                    // This can happen if what we're deserializing is completely
                                    // incompatible with all the possible variants (e.g.
                                    // deserializing from boolean).
                                    0 -> InnerTemplate(_json = json)
                                    1 -> bestMatches.single()
                                    // If there's more than one match with the highest validity,
                                    // then use the first completely valid match, or simply the
                                    // first match if none are completely valid.
                                    else ->
                                        bestMatches.firstOrNull { it.isValid() }
                                            ?: bestMatches.first()
                                }
                            }
                        }

                        internal class Serializer :
                            BaseSerializer<InnerTemplate>(InnerTemplate::class) {

                            override fun serialize(
                                value: InnerTemplate,
                                generator: JsonGenerator,
                                provider: SerializerProvider,
                            ) {
                                when {
                                    value.chatMessage != null ->
                                        generator.writeObject(value.chatMessage)
                                    value.evalItem != null -> generator.writeObject(value.evalItem)
                                    value._json != null -> generator.writeObject(value._json)
                                    else -> throw IllegalStateException("Invalid InnerTemplate")
                                }
                            }
                        }

                        class ChatMessage
                        private constructor(
                            private val content: JsonField<String>,
                            private val role: JsonField<String>,
                            private val additionalProperties: MutableMap<String, JsonValue>,
                        ) {

                            @JsonCreator
                            private constructor(
                                @JsonProperty("content")
                                @ExcludeMissing
                                content: JsonField<String> = JsonMissing.of(),
                                @JsonProperty("role")
                                @ExcludeMissing
                                role: JsonField<String> = JsonMissing.of(),
                            ) : this(content, role, mutableMapOf())

                            /**
                             * The content of the message.
                             *
                             * @throws OpenAIInvalidDataException if the JSON field has an
                             *   unexpected type or is unexpectedly missing or null (e.g. if the
                             *   server responded with an unexpected value).
                             */
                            fun content(): String = content.getRequired("content")

                            /**
                             * The role of the message (e.g. "system", "assistant", "user").
                             *
                             * @throws OpenAIInvalidDataException if the JSON field has an
                             *   unexpected type or is unexpectedly missing or null (e.g. if the
                             *   server responded with an unexpected value).
                             */
                            fun role(): String = role.getRequired("role")

                            /**
                             * Returns the raw JSON value of [content].
                             *
                             * Unlike [content], this method doesn't throw if the JSON field has an
                             * unexpected type.
                             */
                            @JsonProperty("content")
                            @ExcludeMissing
                            fun _content(): JsonField<String> = content

                            /**
                             * Returns the raw JSON value of [role].
                             *
                             * Unlike [role], this method doesn't throw if the JSON field has an
                             * unexpected type.
                             */
                            @JsonProperty("role")
                            @ExcludeMissing
                            fun _role(): JsonField<String> = role

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
                                 * Returns a mutable builder for constructing an instance of
                                 * [ChatMessage].
                                 *
                                 * The following fields are required:
                                 * ```java
                                 * .content()
                                 * .role()
                                 * ```
                                 */
                                @JvmStatic fun builder() = Builder()
                            }

                            /** A builder for [ChatMessage]. */
                            class Builder internal constructor() {

                                private var content: JsonField<String>? = null
                                private var role: JsonField<String>? = null
                                private var additionalProperties: MutableMap<String, JsonValue> =
                                    mutableMapOf()

                                @JvmSynthetic
                                internal fun from(chatMessage: ChatMessage) = apply {
                                    content = chatMessage.content
                                    role = chatMessage.role
                                    additionalProperties =
                                        chatMessage.additionalProperties.toMutableMap()
                                }

                                /** The content of the message. */
                                fun content(content: String) = content(JsonField.of(content))

                                /**
                                 * Sets [Builder.content] to an arbitrary JSON value.
                                 *
                                 * You should usually call [Builder.content] with a well-typed
                                 * [String] value instead. This method is primarily for setting the
                                 * field to an undocumented or not yet supported value.
                                 */
                                fun content(content: JsonField<String>) = apply {
                                    this.content = content
                                }

                                /** The role of the message (e.g. "system", "assistant", "user"). */
                                fun role(role: String) = role(JsonField.of(role))

                                /**
                                 * Sets [Builder.role] to an arbitrary JSON value.
                                 *
                                 * You should usually call [Builder.role] with a well-typed [String]
                                 * value instead. This method is primarily for setting the field to
                                 * an undocumented or not yet supported value.
                                 */
                                fun role(role: JsonField<String>) = apply { this.role = role }

                                fun additionalProperties(
                                    additionalProperties: Map<String, JsonValue>
                                ) = apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                    additionalProperties.put(key, value)
                                }

                                fun putAllAdditionalProperties(
                                    additionalProperties: Map<String, JsonValue>
                                ) = apply { this.additionalProperties.putAll(additionalProperties) }

                                fun removeAdditionalProperty(key: String) = apply {
                                    additionalProperties.remove(key)
                                }

                                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                    keys.forEach(::removeAdditionalProperty)
                                }

                                /**
                                 * Returns an immutable instance of [ChatMessage].
                                 *
                                 * Further updates to this [Builder] will not mutate the returned
                                 * instance.
                                 *
                                 * The following fields are required:
                                 * ```java
                                 * .content()
                                 * .role()
                                 * ```
                                 *
                                 * @throws IllegalStateException if any required field is unset.
                                 */
                                fun build(): ChatMessage =
                                    ChatMessage(
                                        checkRequired("content", content),
                                        checkRequired("role", role),
                                        additionalProperties.toMutableMap(),
                                    )
                            }

                            private var validated: Boolean = false

                            fun validate(): ChatMessage = apply {
                                if (validated) {
                                    return@apply
                                }

                                content()
                                role()
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
                             * Returns a score indicating how many valid values are contained in
                             * this object recursively.
                             *
                             * Used for best match union deserialization.
                             */
                            @JvmSynthetic
                            internal fun validity(): Int =
                                (if (content.asKnown().isPresent) 1 else 0) +
                                    (if (role.asKnown().isPresent) 1 else 0)

                            override fun equals(other: Any?): Boolean {
                                if (this === other) {
                                    return true
                                }

                                return /* spotless:off */ other is ChatMessage && content == other.content && role == other.role && additionalProperties == other.additionalProperties /* spotless:on */
                            }

                            /* spotless:off */
                            private val hashCode: Int by lazy { Objects.hash(content, role, additionalProperties) }
                            /* spotless:on */

                            override fun hashCode(): Int = hashCode

                            override fun toString() =
                                "ChatMessage{content=$content, role=$role, additionalProperties=$additionalProperties}"
                        }

                        /**
                         * A message input to the model with a role indicating instruction following
                         * hierarchy. Instructions given with the `developer` or `system` role take
                         * precedence over instructions given with the `user` role. Messages with
                         * the `assistant` role are presumed to have been generated by the model in
                         * previous interactions.
                         */
                        class EvalItem
                        private constructor(
                            private val content: JsonField<Content>,
                            private val role: JsonField<Role>,
                            private val type: JsonField<Type>,
                            private val additionalProperties: MutableMap<String, JsonValue>,
                        ) {

                            @JsonCreator
                            private constructor(
                                @JsonProperty("content")
                                @ExcludeMissing
                                content: JsonField<Content> = JsonMissing.of(),
                                @JsonProperty("role")
                                @ExcludeMissing
                                role: JsonField<Role> = JsonMissing.of(),
                                @JsonProperty("type")
                                @ExcludeMissing
                                type: JsonField<Type> = JsonMissing.of(),
                            ) : this(content, role, type, mutableMapOf())

                            /**
                             * Text inputs to the model - can contain template strings.
                             *
                             * @throws OpenAIInvalidDataException if the JSON field has an
                             *   unexpected type or is unexpectedly missing or null (e.g. if the
                             *   server responded with an unexpected value).
                             */
                            fun content(): Content = content.getRequired("content")

                            /**
                             * The role of the message input. One of `user`, `assistant`, `system`,
                             * or `developer`.
                             *
                             * @throws OpenAIInvalidDataException if the JSON field has an
                             *   unexpected type or is unexpectedly missing or null (e.g. if the
                             *   server responded with an unexpected value).
                             */
                            fun role(): Role = role.getRequired("role")

                            /**
                             * The type of the message input. Always `message`.
                             *
                             * @throws OpenAIInvalidDataException if the JSON field has an
                             *   unexpected type (e.g. if the server responded with an unexpected
                             *   value).
                             */
                            fun type(): Optional<Type> = type.getOptional("type")

                            /**
                             * Returns the raw JSON value of [content].
                             *
                             * Unlike [content], this method doesn't throw if the JSON field has an
                             * unexpected type.
                             */
                            @JsonProperty("content")
                            @ExcludeMissing
                            fun _content(): JsonField<Content> = content

                            /**
                             * Returns the raw JSON value of [role].
                             *
                             * Unlike [role], this method doesn't throw if the JSON field has an
                             * unexpected type.
                             */
                            @JsonProperty("role")
                            @ExcludeMissing
                            fun _role(): JsonField<Role> = role

                            /**
                             * Returns the raw JSON value of [type].
                             *
                             * Unlike [type], this method doesn't throw if the JSON field has an
                             * unexpected type.
                             */
                            @JsonProperty("type")
                            @ExcludeMissing
                            fun _type(): JsonField<Type> = type

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
                                 * Returns a mutable builder for constructing an instance of
                                 * [EvalItem].
                                 *
                                 * The following fields are required:
                                 * ```java
                                 * .content()
                                 * .role()
                                 * ```
                                 */
                                @JvmStatic fun builder() = Builder()
                            }

                            /** A builder for [EvalItem]. */
                            class Builder internal constructor() {

                                private var content: JsonField<Content>? = null
                                private var role: JsonField<Role>? = null
                                private var type: JsonField<Type> = JsonMissing.of()
                                private var additionalProperties: MutableMap<String, JsonValue> =
                                    mutableMapOf()

                                @JvmSynthetic
                                internal fun from(evalItem: EvalItem) = apply {
                                    content = evalItem.content
                                    role = evalItem.role
                                    type = evalItem.type
                                    additionalProperties =
                                        evalItem.additionalProperties.toMutableMap()
                                }

                                /** Text inputs to the model - can contain template strings. */
                                fun content(content: Content) = content(JsonField.of(content))

                                /**
                                 * Sets [Builder.content] to an arbitrary JSON value.
                                 *
                                 * You should usually call [Builder.content] with a well-typed
                                 * [Content] value instead. This method is primarily for setting the
                                 * field to an undocumented or not yet supported value.
                                 */
                                fun content(content: JsonField<Content>) = apply {
                                    this.content = content
                                }

                                /**
                                 * Alias for calling [content] with
                                 * `Content.ofTextInput(textInput)`.
                                 */
                                fun content(textInput: String) =
                                    content(Content.ofTextInput(textInput))

                                /**
                                 * Alias for calling [content] with
                                 * `Content.ofResponseInputText(responseInputText)`.
                                 */
                                fun content(responseInputText: ResponseInputText) =
                                    content(Content.ofResponseInputText(responseInputText))

                                /**
                                 * Alias for calling [content] with
                                 * `Content.ofOutputText(outputText)`.
                                 */
                                fun content(outputText: Content.OutputText) =
                                    content(Content.ofOutputText(outputText))

                                /**
                                 * The role of the message input. One of `user`, `assistant`,
                                 * `system`, or `developer`.
                                 */
                                fun role(role: Role) = role(JsonField.of(role))

                                /**
                                 * Sets [Builder.role] to an arbitrary JSON value.
                                 *
                                 * You should usually call [Builder.role] with a well-typed [Role]
                                 * value instead. This method is primarily for setting the field to
                                 * an undocumented or not yet supported value.
                                 */
                                fun role(role: JsonField<Role>) = apply { this.role = role }

                                /** The type of the message input. Always `message`. */
                                fun type(type: Type) = type(JsonField.of(type))

                                /**
                                 * Sets [Builder.type] to an arbitrary JSON value.
                                 *
                                 * You should usually call [Builder.type] with a well-typed [Type]
                                 * value instead. This method is primarily for setting the field to
                                 * an undocumented or not yet supported value.
                                 */
                                fun type(type: JsonField<Type>) = apply { this.type = type }

                                fun additionalProperties(
                                    additionalProperties: Map<String, JsonValue>
                                ) = apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                    additionalProperties.put(key, value)
                                }

                                fun putAllAdditionalProperties(
                                    additionalProperties: Map<String, JsonValue>
                                ) = apply { this.additionalProperties.putAll(additionalProperties) }

                                fun removeAdditionalProperty(key: String) = apply {
                                    additionalProperties.remove(key)
                                }

                                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                    keys.forEach(::removeAdditionalProperty)
                                }

                                /**
                                 * Returns an immutable instance of [EvalItem].
                                 *
                                 * Further updates to this [Builder] will not mutate the returned
                                 * instance.
                                 *
                                 * The following fields are required:
                                 * ```java
                                 * .content()
                                 * .role()
                                 * ```
                                 *
                                 * @throws IllegalStateException if any required field is unset.
                                 */
                                fun build(): EvalItem =
                                    EvalItem(
                                        checkRequired("content", content),
                                        checkRequired("role", role),
                                        type,
                                        additionalProperties.toMutableMap(),
                                    )
                            }

                            private var validated: Boolean = false

                            fun validate(): EvalItem = apply {
                                if (validated) {
                                    return@apply
                                }

                                content().validate()
                                role().validate()
                                type().ifPresent { it.validate() }
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
                             * Returns a score indicating how many valid values are contained in
                             * this object recursively.
                             *
                             * Used for best match union deserialization.
                             */
                            @JvmSynthetic
                            internal fun validity(): Int =
                                (content.asKnown().getOrNull()?.validity() ?: 0) +
                                    (role.asKnown().getOrNull()?.validity() ?: 0) +
                                    (type.asKnown().getOrNull()?.validity() ?: 0)

                            /** Text inputs to the model - can contain template strings. */
                            @JsonDeserialize(using = Content.Deserializer::class)
                            @JsonSerialize(using = Content.Serializer::class)
                            class Content
                            private constructor(
                                private val textInput: String? = null,
                                private val responseInputText: ResponseInputText? = null,
                                private val outputText: OutputText? = null,
                                private val _json: JsonValue? = null,
                            ) {

                                /** A text input to the model. */
                                fun textInput(): Optional<String> = Optional.ofNullable(textInput)

                                /** A text input to the model. */
                                fun responseInputText(): Optional<ResponseInputText> =
                                    Optional.ofNullable(responseInputText)

                                /** A text output from the model. */
                                fun outputText(): Optional<OutputText> =
                                    Optional.ofNullable(outputText)

                                fun isTextInput(): Boolean = textInput != null

                                fun isResponseInputText(): Boolean = responseInputText != null

                                fun isOutputText(): Boolean = outputText != null

                                /** A text input to the model. */
                                fun asTextInput(): String = textInput.getOrThrow("textInput")

                                /** A text input to the model. */
                                fun asResponseInputText(): ResponseInputText =
                                    responseInputText.getOrThrow("responseInputText")

                                /** A text output from the model. */
                                fun asOutputText(): OutputText = outputText.getOrThrow("outputText")

                                fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                                fun <T> accept(visitor: Visitor<T>): T =
                                    when {
                                        textInput != null -> visitor.visitTextInput(textInput)
                                        responseInputText != null ->
                                            visitor.visitResponseInputText(responseInputText)
                                        outputText != null -> visitor.visitOutputText(outputText)
                                        else -> visitor.unknown(_json)
                                    }

                                private var validated: Boolean = false

                                fun validate(): Content = apply {
                                    if (validated) {
                                        return@apply
                                    }

                                    accept(
                                        object : Visitor<Unit> {
                                            override fun visitTextInput(textInput: String) {}

                                            override fun visitResponseInputText(
                                                responseInputText: ResponseInputText
                                            ) {
                                                responseInputText.validate()
                                            }

                                            override fun visitOutputText(outputText: OutputText) {
                                                outputText.validate()
                                            }
                                        }
                                    )
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
                                 * Returns a score indicating how many valid values are contained in
                                 * this object recursively.
                                 *
                                 * Used for best match union deserialization.
                                 */
                                @JvmSynthetic
                                internal fun validity(): Int =
                                    accept(
                                        object : Visitor<Int> {
                                            override fun visitTextInput(textInput: String) = 1

                                            override fun visitResponseInputText(
                                                responseInputText: ResponseInputText
                                            ) = responseInputText.validity()

                                            override fun visitOutputText(outputText: OutputText) =
                                                outputText.validity()

                                            override fun unknown(json: JsonValue?) = 0
                                        }
                                    )

                                override fun equals(other: Any?): Boolean {
                                    if (this === other) {
                                        return true
                                    }

                                    return /* spotless:off */ other is Content && textInput == other.textInput && responseInputText == other.responseInputText && outputText == other.outputText /* spotless:on */
                                }

                                override fun hashCode(): Int = /* spotless:off */ Objects.hash(textInput, responseInputText, outputText) /* spotless:on */

                                override fun toString(): String =
                                    when {
                                        textInput != null -> "Content{textInput=$textInput}"
                                        responseInputText != null ->
                                            "Content{responseInputText=$responseInputText}"
                                        outputText != null -> "Content{outputText=$outputText}"
                                        _json != null -> "Content{_unknown=$_json}"
                                        else -> throw IllegalStateException("Invalid Content")
                                    }

                                companion object {

                                    /** A text input to the model. */
                                    @JvmStatic
                                    fun ofTextInput(textInput: String) =
                                        Content(textInput = textInput)

                                    /** A text input to the model. */
                                    @JvmStatic
                                    fun ofResponseInputText(responseInputText: ResponseInputText) =
                                        Content(responseInputText = responseInputText)

                                    /** A text output from the model. */
                                    @JvmStatic
                                    fun ofOutputText(outputText: OutputText) =
                                        Content(outputText = outputText)
                                }

                                /**
                                 * An interface that defines how to map each variant of [Content] to
                                 * a value of type [T].
                                 */
                                interface Visitor<out T> {

                                    /** A text input to the model. */
                                    fun visitTextInput(textInput: String): T

                                    /** A text input to the model. */
                                    fun visitResponseInputText(
                                        responseInputText: ResponseInputText
                                    ): T

                                    /** A text output from the model. */
                                    fun visitOutputText(outputText: OutputText): T

                                    /**
                                     * Maps an unknown variant of [Content] to a value of type [T].
                                     *
                                     * An instance of [Content] can contain an unknown variant if it
                                     * was deserialized from data that doesn't match any known
                                     * variant. For example, if the SDK is on an older version than
                                     * the API, then the API may respond with new variants that the
                                     * SDK is unaware of.
                                     *
                                     * @throws OpenAIInvalidDataException in the default
                                     *   implementation.
                                     */
                                    fun unknown(json: JsonValue?): T {
                                        throw OpenAIInvalidDataException("Unknown Content: $json")
                                    }
                                }

                                internal class Deserializer :
                                    BaseDeserializer<Content>(Content::class) {

                                    override fun ObjectCodec.deserialize(node: JsonNode): Content {
                                        val json = JsonValue.fromJsonNode(node)

                                        val bestMatches =
                                            sequenceOf(
                                                    tryDeserialize(
                                                            node,
                                                            jacksonTypeRef<ResponseInputText>(),
                                                        )
                                                        ?.let {
                                                            Content(
                                                                responseInputText = it,
                                                                _json = json,
                                                            )
                                                        },
                                                    tryDeserialize(
                                                            node,
                                                            jacksonTypeRef<OutputText>(),
                                                        )
                                                        ?.let {
                                                            Content(outputText = it, _json = json)
                                                        },
                                                    tryDeserialize(node, jacksonTypeRef<String>())
                                                        ?.let {
                                                            Content(textInput = it, _json = json)
                                                        },
                                                )
                                                .filterNotNull()
                                                .allMaxBy { it.validity() }
                                                .toList()
                                        return when (bestMatches.size) {
                                            // This can happen if what we're deserializing is
                                            // completely incompatible with all the possible
                                            // variants (e.g. deserializing from array).
                                            0 -> Content(_json = json)
                                            1 -> bestMatches.single()
                                            // If there's more than one match with the highest
                                            // validity, then use the first completely valid match,
                                            // or simply the first match if none are completely
                                            // valid.
                                            else ->
                                                bestMatches.firstOrNull { it.isValid() }
                                                    ?: bestMatches.first()
                                        }
                                    }
                                }

                                internal class Serializer :
                                    BaseSerializer<Content>(Content::class) {

                                    override fun serialize(
                                        value: Content,
                                        generator: JsonGenerator,
                                        provider: SerializerProvider,
                                    ) {
                                        when {
                                            value.textInput != null ->
                                                generator.writeObject(value.textInput)
                                            value.responseInputText != null ->
                                                generator.writeObject(value.responseInputText)
                                            value.outputText != null ->
                                                generator.writeObject(value.outputText)
                                            value._json != null ->
                                                generator.writeObject(value._json)
                                            else -> throw IllegalStateException("Invalid Content")
                                        }
                                    }
                                }

                                /** A text output from the model. */
                                class OutputText
                                private constructor(
                                    private val text: JsonField<String>,
                                    private val type: JsonValue,
                                    private val additionalProperties: MutableMap<String, JsonValue>,
                                ) {

                                    @JsonCreator
                                    private constructor(
                                        @JsonProperty("text")
                                        @ExcludeMissing
                                        text: JsonField<String> = JsonMissing.of(),
                                        @JsonProperty("type")
                                        @ExcludeMissing
                                        type: JsonValue = JsonMissing.of(),
                                    ) : this(text, type, mutableMapOf())

                                    /**
                                     * The text output from the model.
                                     *
                                     * @throws OpenAIInvalidDataException if the JSON field has an
                                     *   unexpected type or is unexpectedly missing or null (e.g. if
                                     *   the server responded with an unexpected value).
                                     */
                                    fun text(): String = text.getRequired("text")

                                    /**
                                     * The type of the output text. Always `output_text`.
                                     *
                                     * Expected to always return the following:
                                     * ```java
                                     * JsonValue.from("output_text")
                                     * ```
                                     *
                                     * However, this method can be useful for debugging and logging
                                     * (e.g. if the server responded with an unexpected value).
                                     */
                                    @JsonProperty("type")
                                    @ExcludeMissing
                                    fun _type(): JsonValue = type

                                    /**
                                     * Returns the raw JSON value of [text].
                                     *
                                     * Unlike [text], this method doesn't throw if the JSON field
                                     * has an unexpected type.
                                     */
                                    @JsonProperty("text")
                                    @ExcludeMissing
                                    fun _text(): JsonField<String> = text

                                    @JsonAnySetter
                                    private fun putAdditionalProperty(
                                        key: String,
                                        value: JsonValue,
                                    ) {
                                        additionalProperties.put(key, value)
                                    }

                                    @JsonAnyGetter
                                    @ExcludeMissing
                                    fun _additionalProperties(): Map<String, JsonValue> =
                                        Collections.unmodifiableMap(additionalProperties)

                                    fun toBuilder() = Builder().from(this)

                                    companion object {

                                        /**
                                         * Returns a mutable builder for constructing an instance of
                                         * [OutputText].
                                         *
                                         * The following fields are required:
                                         * ```java
                                         * .text()
                                         * ```
                                         */
                                        @JvmStatic fun builder() = Builder()
                                    }

                                    /** A builder for [OutputText]. */
                                    class Builder internal constructor() {

                                        private var text: JsonField<String>? = null
                                        private var type: JsonValue = JsonValue.from("output_text")
                                        private var additionalProperties:
                                            MutableMap<String, JsonValue> =
                                            mutableMapOf()

                                        @JvmSynthetic
                                        internal fun from(outputText: OutputText) = apply {
                                            text = outputText.text
                                            type = outputText.type
                                            additionalProperties =
                                                outputText.additionalProperties.toMutableMap()
                                        }

                                        /** The text output from the model. */
                                        fun text(text: String) = text(JsonField.of(text))

                                        /**
                                         * Sets [Builder.text] to an arbitrary JSON value.
                                         *
                                         * You should usually call [Builder.text] with a well-typed
                                         * [String] value instead. This method is primarily for
                                         * setting the field to an undocumented or not yet supported
                                         * value.
                                         */
                                        fun text(text: JsonField<String>) = apply {
                                            this.text = text
                                        }

                                        /**
                                         * Sets the field to an arbitrary JSON value.
                                         *
                                         * It is usually unnecessary to call this method because the
                                         * field defaults to the following:
                                         * ```java
                                         * JsonValue.from("output_text")
                                         * ```
                                         *
                                         * This method is primarily for setting the field to an
                                         * undocumented or not yet supported value.
                                         */
                                        fun type(type: JsonValue) = apply { this.type = type }

                                        fun additionalProperties(
                                            additionalProperties: Map<String, JsonValue>
                                        ) = apply {
                                            this.additionalProperties.clear()
                                            putAllAdditionalProperties(additionalProperties)
                                        }

                                        fun putAdditionalProperty(key: String, value: JsonValue) =
                                            apply {
                                                additionalProperties.put(key, value)
                                            }

                                        fun putAllAdditionalProperties(
                                            additionalProperties: Map<String, JsonValue>
                                        ) = apply {
                                            this.additionalProperties.putAll(additionalProperties)
                                        }

                                        fun removeAdditionalProperty(key: String) = apply {
                                            additionalProperties.remove(key)
                                        }

                                        fun removeAllAdditionalProperties(keys: Set<String>) =
                                            apply {
                                                keys.forEach(::removeAdditionalProperty)
                                            }

                                        /**
                                         * Returns an immutable instance of [OutputText].
                                         *
                                         * Further updates to this [Builder] will not mutate the
                                         * returned instance.
                                         *
                                         * The following fields are required:
                                         * ```java
                                         * .text()
                                         * ```
                                         *
                                         * @throws IllegalStateException if any required field is
                                         *   unset.
                                         */
                                        fun build(): OutputText =
                                            OutputText(
                                                checkRequired("text", text),
                                                type,
                                                additionalProperties.toMutableMap(),
                                            )
                                    }

                                    private var validated: Boolean = false

                                    fun validate(): OutputText = apply {
                                        if (validated) {
                                            return@apply
                                        }

                                        text()
                                        _type().let {
                                            if (it != JsonValue.from("output_text")) {
                                                throw OpenAIInvalidDataException(
                                                    "'type' is invalid, received $it"
                                                )
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
                                     * Returns a score indicating how many valid values are
                                     * contained in this object recursively.
                                     *
                                     * Used for best match union deserialization.
                                     */
                                    @JvmSynthetic
                                    internal fun validity(): Int =
                                        (if (text.asKnown().isPresent) 1 else 0) +
                                            type.let {
                                                if (it == JsonValue.from("output_text")) 1 else 0
                                            }

                                    override fun equals(other: Any?): Boolean {
                                        if (this === other) {
                                            return true
                                        }

                                        return /* spotless:off */ other is OutputText && text == other.text && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                                    }

                                    /* spotless:off */
                                    private val hashCode: Int by lazy { Objects.hash(text, type, additionalProperties) }
                                    /* spotless:on */

                                    override fun hashCode(): Int = hashCode

                                    override fun toString() =
                                        "OutputText{text=$text, type=$type, additionalProperties=$additionalProperties}"
                                }
                            }

                            /**
                             * The role of the message input. One of `user`, `assistant`, `system`,
                             * or `developer`.
                             */
                            class Role
                            @JsonCreator
                            private constructor(private val value: JsonField<String>) : Enum {

                                /**
                                 * Returns this class instance's raw value.
                                 *
                                 * This is usually only useful if this instance was deserialized
                                 * from data that doesn't match any known member, and you want to
                                 * know that value. For example, if the SDK is on an older version
                                 * than the API, then the API may respond with new members that the
                                 * SDK is unaware of.
                                 */
                                @com.fasterxml.jackson.annotation.JsonValue
                                fun _value(): JsonField<String> = value

                                companion object {

                                    @JvmField val USER = of("user")

                                    @JvmField val ASSISTANT = of("assistant")

                                    @JvmField val SYSTEM = of("system")

                                    @JvmField val DEVELOPER = of("developer")

                                    @JvmStatic fun of(value: String) = Role(JsonField.of(value))
                                }

                                /** An enum containing [Role]'s known values. */
                                enum class Known {
                                    USER,
                                    ASSISTANT,
                                    SYSTEM,
                                    DEVELOPER,
                                }

                                /**
                                 * An enum containing [Role]'s known values, as well as an
                                 * [_UNKNOWN] member.
                                 *
                                 * An instance of [Role] can contain an unknown value in a couple of
                                 * cases:
                                 * - It was deserialized from data that doesn't match any known
                                 *   member. For example, if the SDK is on an older version than the
                                 *   API, then the API may respond with new members that the SDK is
                                 *   unaware of.
                                 * - It was constructed with an arbitrary value using the [of]
                                 *   method.
                                 */
                                enum class Value {
                                    USER,
                                    ASSISTANT,
                                    SYSTEM,
                                    DEVELOPER,
                                    /**
                                     * An enum member indicating that [Role] was instantiated with
                                     * an unknown value.
                                     */
                                    _UNKNOWN,
                                }

                                /**
                                 * Returns an enum member corresponding to this class instance's
                                 * value, or [Value._UNKNOWN] if the class was instantiated with an
                                 * unknown value.
                                 *
                                 * Use the [known] method instead if you're certain the value is
                                 * always known or if you want to throw for the unknown case.
                                 */
                                fun value(): Value =
                                    when (this) {
                                        USER -> Value.USER
                                        ASSISTANT -> Value.ASSISTANT
                                        SYSTEM -> Value.SYSTEM
                                        DEVELOPER -> Value.DEVELOPER
                                        else -> Value._UNKNOWN
                                    }

                                /**
                                 * Returns an enum member corresponding to this class instance's
                                 * value.
                                 *
                                 * Use the [value] method instead if you're uncertain the value is
                                 * always known and don't want to throw for the unknown case.
                                 *
                                 * @throws OpenAIInvalidDataException if this class instance's value
                                 *   is a not a known member.
                                 */
                                fun known(): Known =
                                    when (this) {
                                        USER -> Known.USER
                                        ASSISTANT -> Known.ASSISTANT
                                        SYSTEM -> Known.SYSTEM
                                        DEVELOPER -> Known.DEVELOPER
                                        else ->
                                            throw OpenAIInvalidDataException("Unknown Role: $value")
                                    }

                                /**
                                 * Returns this class instance's primitive wire representation.
                                 *
                                 * This differs from the [toString] method because that method is
                                 * primarily for debugging and generally doesn't throw.
                                 *
                                 * @throws OpenAIInvalidDataException if this class instance's value
                                 *   does not have the expected primitive type.
                                 */
                                fun asString(): String =
                                    _value().asString().orElseThrow {
                                        OpenAIInvalidDataException("Value is not a String")
                                    }

                                private var validated: Boolean = false

                                fun validate(): Role = apply {
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
                                 * Returns a score indicating how many valid values are contained in
                                 * this object recursively.
                                 *
                                 * Used for best match union deserialization.
                                 */
                                @JvmSynthetic
                                internal fun validity(): Int =
                                    if (value() == Value._UNKNOWN) 0 else 1

                                override fun equals(other: Any?): Boolean {
                                    if (this === other) {
                                        return true
                                    }

                                    return /* spotless:off */ other is Role && value == other.value /* spotless:on */
                                }

                                override fun hashCode() = value.hashCode()

                                override fun toString() = value.toString()
                            }

                            /** The type of the message input. Always `message`. */
                            class Type
                            @JsonCreator
                            private constructor(private val value: JsonField<String>) : Enum {

                                /**
                                 * Returns this class instance's raw value.
                                 *
                                 * This is usually only useful if this instance was deserialized
                                 * from data that doesn't match any known member, and you want to
                                 * know that value. For example, if the SDK is on an older version
                                 * than the API, then the API may respond with new members that the
                                 * SDK is unaware of.
                                 */
                                @com.fasterxml.jackson.annotation.JsonValue
                                fun _value(): JsonField<String> = value

                                companion object {

                                    @JvmField val MESSAGE = of("message")

                                    @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                                }

                                /** An enum containing [Type]'s known values. */
                                enum class Known {
                                    MESSAGE
                                }

                                /**
                                 * An enum containing [Type]'s known values, as well as an
                                 * [_UNKNOWN] member.
                                 *
                                 * An instance of [Type] can contain an unknown value in a couple of
                                 * cases:
                                 * - It was deserialized from data that doesn't match any known
                                 *   member. For example, if the SDK is on an older version than the
                                 *   API, then the API may respond with new members that the SDK is
                                 *   unaware of.
                                 * - It was constructed with an arbitrary value using the [of]
                                 *   method.
                                 */
                                enum class Value {
                                    MESSAGE,
                                    /**
                                     * An enum member indicating that [Type] was instantiated with
                                     * an unknown value.
                                     */
                                    _UNKNOWN,
                                }

                                /**
                                 * Returns an enum member corresponding to this class instance's
                                 * value, or [Value._UNKNOWN] if the class was instantiated with an
                                 * unknown value.
                                 *
                                 * Use the [known] method instead if you're certain the value is
                                 * always known or if you want to throw for the unknown case.
                                 */
                                fun value(): Value =
                                    when (this) {
                                        MESSAGE -> Value.MESSAGE
                                        else -> Value._UNKNOWN
                                    }

                                /**
                                 * Returns an enum member corresponding to this class instance's
                                 * value.
                                 *
                                 * Use the [value] method instead if you're uncertain the value is
                                 * always known and don't want to throw for the unknown case.
                                 *
                                 * @throws OpenAIInvalidDataException if this class instance's value
                                 *   is a not a known member.
                                 */
                                fun known(): Known =
                                    when (this) {
                                        MESSAGE -> Known.MESSAGE
                                        else ->
                                            throw OpenAIInvalidDataException("Unknown Type: $value")
                                    }

                                /**
                                 * Returns this class instance's primitive wire representation.
                                 *
                                 * This differs from the [toString] method because that method is
                                 * primarily for debugging and generally doesn't throw.
                                 *
                                 * @throws OpenAIInvalidDataException if this class instance's value
                                 *   does not have the expected primitive type.
                                 */
                                fun asString(): String =
                                    _value().asString().orElseThrow {
                                        OpenAIInvalidDataException("Value is not a String")
                                    }

                                private var validated: Boolean = false

                                fun validate(): Type = apply {
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
                                 * Returns a score indicating how many valid values are contained in
                                 * this object recursively.
                                 *
                                 * Used for best match union deserialization.
                                 */
                                @JvmSynthetic
                                internal fun validity(): Int =
                                    if (value() == Value._UNKNOWN) 0 else 1

                                override fun equals(other: Any?): Boolean {
                                    if (this === other) {
                                        return true
                                    }

                                    return /* spotless:off */ other is Type && value == other.value /* spotless:on */
                                }

                                override fun hashCode() = value.hashCode()

                                override fun toString() = value.toString()
                            }

                            override fun equals(other: Any?): Boolean {
                                if (this === other) {
                                    return true
                                }

                                return /* spotless:off */ other is EvalItem && content == other.content && role == other.role && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                            }

                            /* spotless:off */
                            private val hashCode: Int by lazy { Objects.hash(content, role, type, additionalProperties) }
                            /* spotless:on */

                            override fun hashCode(): Int = hashCode

                            override fun toString() =
                                "EvalItem{content=$content, role=$role, type=$type, additionalProperties=$additionalProperties}"
                        }
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is Template && template == other.template && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                    }

                    /* spotless:off */
                    private val hashCode: Int by lazy { Objects.hash(template, type, additionalProperties) }
                    /* spotless:on */

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Template{template=$template, type=$type, additionalProperties=$additionalProperties}"
                }

                class ItemReference
                private constructor(
                    private val itemReference: JsonField<String>,
                    private val type: JsonValue,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("item_reference")
                        @ExcludeMissing
                        itemReference: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                    ) : this(itemReference, type, mutableMapOf())

                    /**
                     * A reference to a variable in the "item" namespace. Ie, "item.name"
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun itemReference(): String = itemReference.getRequired("item_reference")

                    /**
                     * The type of input messages. Always `item_reference`.
                     *
                     * Expected to always return the following:
                     * ```java
                     * JsonValue.from("item_reference")
                     * ```
                     *
                     * However, this method can be useful for debugging and logging (e.g. if the
                     * server responded with an unexpected value).
                     */
                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                    /**
                     * Returns the raw JSON value of [itemReference].
                     *
                     * Unlike [itemReference], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("item_reference")
                    @ExcludeMissing
                    fun _itemReference(): JsonField<String> = itemReference

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
                         * Returns a mutable builder for constructing an instance of
                         * [ItemReference].
                         *
                         * The following fields are required:
                         * ```java
                         * .itemReference()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [ItemReference]. */
                    class Builder internal constructor() {

                        private var itemReference: JsonField<String>? = null
                        private var type: JsonValue = JsonValue.from("item_reference")
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(itemReference: ItemReference) = apply {
                            this.itemReference = itemReference.itemReference
                            type = itemReference.type
                            additionalProperties = itemReference.additionalProperties.toMutableMap()
                        }

                        /** A reference to a variable in the "item" namespace. Ie, "item.name" */
                        fun itemReference(itemReference: String) =
                            itemReference(JsonField.of(itemReference))

                        /**
                         * Sets [Builder.itemReference] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.itemReference] with a well-typed
                         * [String] value instead. This method is primarily for setting the field to
                         * an undocumented or not yet supported value.
                         */
                        fun itemReference(itemReference: JsonField<String>) = apply {
                            this.itemReference = itemReference
                        }

                        /**
                         * Sets the field to an arbitrary JSON value.
                         *
                         * It is usually unnecessary to call this method because the field defaults
                         * to the following:
                         * ```java
                         * JsonValue.from("item_reference")
                         * ```
                         *
                         * This method is primarily for setting the field to an undocumented or not
                         * yet supported value.
                         */
                        fun type(type: JsonValue) = apply { this.type = type }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [ItemReference].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .itemReference()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): ItemReference =
                            ItemReference(
                                checkRequired("itemReference", itemReference),
                                type,
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    fun validate(): ItemReference = apply {
                        if (validated) {
                            return@apply
                        }

                        itemReference()
                        _type().let {
                            if (it != JsonValue.from("item_reference")) {
                                throw OpenAIInvalidDataException("'type' is invalid, received $it")
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
                     * Returns a score indicating how many valid values are contained in this object
                     * recursively.
                     *
                     * Used for best match union deserialization.
                     */
                    @JvmSynthetic
                    internal fun validity(): Int =
                        (if (itemReference.asKnown().isPresent) 1 else 0) +
                            type.let { if (it == JsonValue.from("item_reference")) 1 else 0 }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is ItemReference && itemReference == other.itemReference && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                    }

                    /* spotless:off */
                    private val hashCode: Int by lazy { Objects.hash(itemReference, type, additionalProperties) }
                    /* spotless:on */

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "ItemReference{itemReference=$itemReference, type=$type, additionalProperties=$additionalProperties}"
                }
            }

            class SamplingParams
            private constructor(
                private val maxCompletionTokens: JsonField<Long>,
                private val seed: JsonField<Long>,
                private val temperature: JsonField<Double>,
                private val topP: JsonField<Double>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("max_completion_tokens")
                    @ExcludeMissing
                    maxCompletionTokens: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("seed") @ExcludeMissing seed: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("temperature")
                    @ExcludeMissing
                    temperature: JsonField<Double> = JsonMissing.of(),
                    @JsonProperty("top_p")
                    @ExcludeMissing
                    topP: JsonField<Double> = JsonMissing.of(),
                ) : this(maxCompletionTokens, seed, temperature, topP, mutableMapOf())

                /**
                 * The maximum number of tokens in the generated output.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun maxCompletionTokens(): Optional<Long> =
                    maxCompletionTokens.getOptional("max_completion_tokens")

                /**
                 * A seed value to initialize the randomness, during sampling.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun seed(): Optional<Long> = seed.getOptional("seed")

                /**
                 * A higher temperature increases randomness in the outputs.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun temperature(): Optional<Double> = temperature.getOptional("temperature")

                /**
                 * An alternative to temperature for nucleus sampling; 1.0 includes all tokens.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun topP(): Optional<Double> = topP.getOptional("top_p")

                /**
                 * Returns the raw JSON value of [maxCompletionTokens].
                 *
                 * Unlike [maxCompletionTokens], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("max_completion_tokens")
                @ExcludeMissing
                fun _maxCompletionTokens(): JsonField<Long> = maxCompletionTokens

                /**
                 * Returns the raw JSON value of [seed].
                 *
                 * Unlike [seed], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("seed") @ExcludeMissing fun _seed(): JsonField<Long> = seed

                /**
                 * Returns the raw JSON value of [temperature].
                 *
                 * Unlike [temperature], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("temperature")
                @ExcludeMissing
                fun _temperature(): JsonField<Double> = temperature

                /**
                 * Returns the raw JSON value of [topP].
                 *
                 * Unlike [topP], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("top_p") @ExcludeMissing fun _topP(): JsonField<Double> = topP

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
                     * Returns a mutable builder for constructing an instance of [SamplingParams].
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [SamplingParams]. */
                class Builder internal constructor() {

                    private var maxCompletionTokens: JsonField<Long> = JsonMissing.of()
                    private var seed: JsonField<Long> = JsonMissing.of()
                    private var temperature: JsonField<Double> = JsonMissing.of()
                    private var topP: JsonField<Double> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(samplingParams: SamplingParams) = apply {
                        maxCompletionTokens = samplingParams.maxCompletionTokens
                        seed = samplingParams.seed
                        temperature = samplingParams.temperature
                        topP = samplingParams.topP
                        additionalProperties = samplingParams.additionalProperties.toMutableMap()
                    }

                    /** The maximum number of tokens in the generated output. */
                    fun maxCompletionTokens(maxCompletionTokens: Long) =
                        maxCompletionTokens(JsonField.of(maxCompletionTokens))

                    /**
                     * Sets [Builder.maxCompletionTokens] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.maxCompletionTokens] with a well-typed
                     * [Long] value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun maxCompletionTokens(maxCompletionTokens: JsonField<Long>) = apply {
                        this.maxCompletionTokens = maxCompletionTokens
                    }

                    /** A seed value to initialize the randomness, during sampling. */
                    fun seed(seed: Long) = seed(JsonField.of(seed))

                    /**
                     * Sets [Builder.seed] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.seed] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun seed(seed: JsonField<Long>) = apply { this.seed = seed }

                    /** A higher temperature increases randomness in the outputs. */
                    fun temperature(temperature: Double) = temperature(JsonField.of(temperature))

                    /**
                     * Sets [Builder.temperature] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.temperature] with a well-typed [Double]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun temperature(temperature: JsonField<Double>) = apply {
                        this.temperature = temperature
                    }

                    /**
                     * An alternative to temperature for nucleus sampling; 1.0 includes all tokens.
                     */
                    fun topP(topP: Double) = topP(JsonField.of(topP))

                    /**
                     * Sets [Builder.topP] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.topP] with a well-typed [Double] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun topP(topP: JsonField<Double>) = apply { this.topP = topP }

                    fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                        this.additionalProperties.clear()
                        putAllAdditionalProperties(additionalProperties)
                    }

                    fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                        additionalProperties.put(key, value)
                    }

                    fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                        apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                    fun removeAdditionalProperty(key: String) = apply {
                        additionalProperties.remove(key)
                    }

                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                        keys.forEach(::removeAdditionalProperty)
                    }

                    /**
                     * Returns an immutable instance of [SamplingParams].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): SamplingParams =
                        SamplingParams(
                            maxCompletionTokens,
                            seed,
                            temperature,
                            topP,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): SamplingParams = apply {
                    if (validated) {
                        return@apply
                    }

                    maxCompletionTokens()
                    seed()
                    temperature()
                    topP()
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
                    (if (maxCompletionTokens.asKnown().isPresent) 1 else 0) +
                        (if (seed.asKnown().isPresent) 1 else 0) +
                        (if (temperature.asKnown().isPresent) 1 else 0) +
                        (if (topP.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is SamplingParams && maxCompletionTokens == other.maxCompletionTokens && seed == other.seed && temperature == other.temperature && topP == other.topP && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(maxCompletionTokens, seed, temperature, topP, additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "SamplingParams{maxCompletionTokens=$maxCompletionTokens, seed=$seed, temperature=$temperature, topP=$topP, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is CreateEvalResponsesRunDataSource && source == other.source && type == other.type && inputMessages == other.inputMessages && model == other.model && samplingParams == other.samplingParams && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(source, type, inputMessages, model, samplingParams, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "CreateEvalResponsesRunDataSource{source=$source, type=$type, inputMessages=$inputMessages, model=$model, samplingParams=$samplingParams, additionalProperties=$additionalProperties}"
        }
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

            return /* spotless:off */ other is Metadata && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() = "Metadata{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is RunCreateParams && evalId == other.evalId && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(evalId, body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "RunCreateParams{evalId=$evalId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
