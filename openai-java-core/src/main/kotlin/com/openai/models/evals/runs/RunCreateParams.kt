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
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.Params
import com.openai.core.allMaxBy
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
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
        private val _json: JsonValue? = null,
    ) {

        /** A JsonlRunDataSource object with that specifies a JSONL file that matches the eval */
        fun createEvalJsonlRun(): Optional<CreateEvalJsonlRunDataSource> =
            Optional.ofNullable(createEvalJsonlRun)

        /** A CompletionsRunDataSource object describing a model sampling configuration. */
        fun createEvalCompletionsRun(): Optional<CreateEvalCompletionsRunDataSource> =
            Optional.ofNullable(createEvalCompletionsRun)

        fun isCreateEvalJsonlRun(): Boolean = createEvalJsonlRun != null

        fun isCreateEvalCompletionsRun(): Boolean = createEvalCompletionsRun != null

        /** A JsonlRunDataSource object with that specifies a JSONL file that matches the eval */
        fun asCreateEvalJsonlRun(): CreateEvalJsonlRunDataSource =
            createEvalJsonlRun.getOrThrow("createEvalJsonlRun")

        /** A CompletionsRunDataSource object describing a model sampling configuration. */
        fun asCreateEvalCompletionsRun(): CreateEvalCompletionsRunDataSource =
            createEvalCompletionsRun.getOrThrow("createEvalCompletionsRun")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                createEvalJsonlRun != null -> visitor.visitCreateEvalJsonlRun(createEvalJsonlRun)
                createEvalCompletionsRun != null ->
                    visitor.visitCreateEvalCompletionsRun(createEvalCompletionsRun)
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

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is DataSource && createEvalJsonlRun == other.createEvalJsonlRun && createEvalCompletionsRun == other.createEvalCompletionsRun /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(createEvalJsonlRun, createEvalCompletionsRun) /* spotless:on */

        override fun toString(): String =
            when {
                createEvalJsonlRun != null -> "DataSource{createEvalJsonlRun=$createEvalJsonlRun}"
                createEvalCompletionsRun != null ->
                    "DataSource{createEvalCompletionsRun=$createEvalCompletionsRun}"
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
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid DataSource")
                }
            }
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
