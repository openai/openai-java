// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals

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
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Create the structure of an evaluation that can be used to test a model's performance. An
 * evaluation is a set of testing criteria and a datasource. After creating an evaluation, you can
 * run it on different models and model parameters. We support several types of graders and
 * datasources. For more information, see the
 * [Evals guide](https://platform.openai.com/docs/guides/evals).
 */
class EvalCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * The configuration for the data source used for the evaluation runs.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun dataSourceConfig(): DataSourceConfig = body.dataSourceConfig()

    /**
     * A list of graders for all eval runs in this group.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun testingCriteria(): List<TestingCriterion> = body.testingCriteria()

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
     * The name of the evaluation.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun name(): Optional<String> = body.name()

    /**
     * Indicates whether the evaluation is shared with OpenAI.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun shareWithOpenAI(): Optional<Boolean> = body.shareWithOpenAI()

    /**
     * Returns the raw JSON value of [dataSourceConfig].
     *
     * Unlike [dataSourceConfig], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _dataSourceConfig(): JsonField<DataSourceConfig> = body._dataSourceConfig()

    /**
     * Returns the raw JSON value of [testingCriteria].
     *
     * Unlike [testingCriteria], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _testingCriteria(): JsonField<List<TestingCriterion>> = body._testingCriteria()

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

    /**
     * Returns the raw JSON value of [shareWithOpenAI].
     *
     * Unlike [shareWithOpenAI], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _shareWithOpenAI(): JsonField<Boolean> = body._shareWithOpenAI()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [EvalCreateParams].
         *
         * The following fields are required:
         * ```java
         * .dataSourceConfig()
         * .testingCriteria()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [EvalCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(evalCreateParams: EvalCreateParams) = apply {
            body = evalCreateParams.body.toBuilder()
            additionalHeaders = evalCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = evalCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [dataSourceConfig]
         * - [testingCriteria]
         * - [metadata]
         * - [name]
         * - [shareWithOpenAI]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** The configuration for the data source used for the evaluation runs. */
        fun dataSourceConfig(dataSourceConfig: DataSourceConfig) = apply {
            body.dataSourceConfig(dataSourceConfig)
        }

        /**
         * Sets [Builder.dataSourceConfig] to an arbitrary JSON value.
         *
         * You should usually call [Builder.dataSourceConfig] with a well-typed [DataSourceConfig]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun dataSourceConfig(dataSourceConfig: JsonField<DataSourceConfig>) = apply {
            body.dataSourceConfig(dataSourceConfig)
        }

        /** Alias for calling [dataSourceConfig] with `DataSourceConfig.ofCustom(custom)`. */
        fun dataSourceConfig(custom: DataSourceConfig.Custom) = apply {
            body.dataSourceConfig(custom)
        }

        /**
         * Alias for calling [dataSourceConfig] with the following:
         * ```java
         * DataSourceConfig.Custom.builder()
         *     .itemSchema(itemSchema)
         *     .build()
         * ```
         */
        fun customDataSourceConfig(itemSchema: DataSourceConfig.Custom.ItemSchema) = apply {
            body.customDataSourceConfig(itemSchema)
        }

        /**
         * Alias for calling [dataSourceConfig] with
         * `DataSourceConfig.ofStoredCompletions(storedCompletions)`.
         */
        fun dataSourceConfig(storedCompletions: DataSourceConfig.StoredCompletions) = apply {
            body.dataSourceConfig(storedCompletions)
        }

        /** A list of graders for all eval runs in this group. */
        fun testingCriteria(testingCriteria: List<TestingCriterion>) = apply {
            body.testingCriteria(testingCriteria)
        }

        /**
         * Sets [Builder.testingCriteria] to an arbitrary JSON value.
         *
         * You should usually call [Builder.testingCriteria] with a well-typed
         * `List<TestingCriterion>` value instead. This method is primarily for setting the field to
         * an undocumented or not yet supported value.
         */
        fun testingCriteria(testingCriteria: JsonField<List<TestingCriterion>>) = apply {
            body.testingCriteria(testingCriteria)
        }

        /**
         * Adds a single [TestingCriterion] to [testingCriteria].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTestingCriterion(testingCriterion: TestingCriterion) = apply {
            body.addTestingCriterion(testingCriterion)
        }

        /**
         * Alias for calling [addTestingCriterion] with `TestingCriterion.ofLabelModel(labelModel)`.
         */
        fun addTestingCriterion(labelModel: TestingCriterion.LabelModel) = apply {
            body.addTestingCriterion(labelModel)
        }

        /**
         * Alias for calling [addTestingCriterion] with
         * `TestingCriterion.ofStringCheck(stringCheck)`.
         */
        fun addTestingCriterion(stringCheck: EvalStringCheckGrader) = apply {
            body.addTestingCriterion(stringCheck)
        }

        /**
         * Alias for calling [addTestingCriterion] with
         * `TestingCriterion.ofTextSimilarity(textSimilarity)`.
         */
        fun addTestingCriterion(textSimilarity: EvalTextSimilarityGrader) = apply {
            body.addTestingCriterion(textSimilarity)
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

        /** The name of the evaluation. */
        fun name(name: String) = apply { body.name(name) }

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { body.name(name) }

        /** Indicates whether the evaluation is shared with OpenAI. */
        fun shareWithOpenAI(shareWithOpenAI: Boolean) = apply {
            body.shareWithOpenAI(shareWithOpenAI)
        }

        /**
         * Sets [Builder.shareWithOpenAI] to an arbitrary JSON value.
         *
         * You should usually call [Builder.shareWithOpenAI] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun shareWithOpenAI(shareWithOpenAI: JsonField<Boolean>) = apply {
            body.shareWithOpenAI(shareWithOpenAI)
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
         * Returns an immutable instance of [EvalCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .dataSourceConfig()
         * .testingCriteria()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): EvalCreateParams =
            EvalCreateParams(body.build(), additionalHeaders.build(), additionalQueryParams.build())
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    private constructor(
        private val dataSourceConfig: JsonField<DataSourceConfig>,
        private val testingCriteria: JsonField<List<TestingCriterion>>,
        private val metadata: JsonField<Metadata>,
        private val name: JsonField<String>,
        private val shareWithOpenAI: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("data_source_config")
            @ExcludeMissing
            dataSourceConfig: JsonField<DataSourceConfig> = JsonMissing.of(),
            @JsonProperty("testing_criteria")
            @ExcludeMissing
            testingCriteria: JsonField<List<TestingCriterion>> = JsonMissing.of(),
            @JsonProperty("metadata")
            @ExcludeMissing
            metadata: JsonField<Metadata> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("share_with_openai")
            @ExcludeMissing
            shareWithOpenAI: JsonField<Boolean> = JsonMissing.of(),
        ) : this(dataSourceConfig, testingCriteria, metadata, name, shareWithOpenAI, mutableMapOf())

        /**
         * The configuration for the data source used for the evaluation runs.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun dataSourceConfig(): DataSourceConfig =
            dataSourceConfig.getRequired("data_source_config")

        /**
         * A list of graders for all eval runs in this group.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun testingCriteria(): List<TestingCriterion> =
            testingCriteria.getRequired("testing_criteria")

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
         * The name of the evaluation.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * Indicates whether the evaluation is shared with OpenAI.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun shareWithOpenAI(): Optional<Boolean> = shareWithOpenAI.getOptional("share_with_openai")

        /**
         * Returns the raw JSON value of [dataSourceConfig].
         *
         * Unlike [dataSourceConfig], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("data_source_config")
        @ExcludeMissing
        fun _dataSourceConfig(): JsonField<DataSourceConfig> = dataSourceConfig

        /**
         * Returns the raw JSON value of [testingCriteria].
         *
         * Unlike [testingCriteria], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("testing_criteria")
        @ExcludeMissing
        fun _testingCriteria(): JsonField<List<TestingCriterion>> = testingCriteria

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

        /**
         * Returns the raw JSON value of [shareWithOpenAI].
         *
         * Unlike [shareWithOpenAI], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("share_with_openai")
        @ExcludeMissing
        fun _shareWithOpenAI(): JsonField<Boolean> = shareWithOpenAI

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
             * .dataSourceConfig()
             * .testingCriteria()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var dataSourceConfig: JsonField<DataSourceConfig>? = null
            private var testingCriteria: JsonField<MutableList<TestingCriterion>>? = null
            private var metadata: JsonField<Metadata> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var shareWithOpenAI: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                dataSourceConfig = body.dataSourceConfig
                testingCriteria = body.testingCriteria.map { it.toMutableList() }
                metadata = body.metadata
                name = body.name
                shareWithOpenAI = body.shareWithOpenAI
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** The configuration for the data source used for the evaluation runs. */
            fun dataSourceConfig(dataSourceConfig: DataSourceConfig) =
                dataSourceConfig(JsonField.of(dataSourceConfig))

            /**
             * Sets [Builder.dataSourceConfig] to an arbitrary JSON value.
             *
             * You should usually call [Builder.dataSourceConfig] with a well-typed
             * [DataSourceConfig] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun dataSourceConfig(dataSourceConfig: JsonField<DataSourceConfig>) = apply {
                this.dataSourceConfig = dataSourceConfig
            }

            /** Alias for calling [dataSourceConfig] with `DataSourceConfig.ofCustom(custom)`. */
            fun dataSourceConfig(custom: DataSourceConfig.Custom) =
                dataSourceConfig(DataSourceConfig.ofCustom(custom))

            /**
             * Alias for calling [dataSourceConfig] with the following:
             * ```java
             * DataSourceConfig.Custom.builder()
             *     .itemSchema(itemSchema)
             *     .build()
             * ```
             */
            fun customDataSourceConfig(itemSchema: DataSourceConfig.Custom.ItemSchema) =
                dataSourceConfig(DataSourceConfig.Custom.builder().itemSchema(itemSchema).build())

            /**
             * Alias for calling [dataSourceConfig] with
             * `DataSourceConfig.ofStoredCompletions(storedCompletions)`.
             */
            fun dataSourceConfig(storedCompletions: DataSourceConfig.StoredCompletions) =
                dataSourceConfig(DataSourceConfig.ofStoredCompletions(storedCompletions))

            /** A list of graders for all eval runs in this group. */
            fun testingCriteria(testingCriteria: List<TestingCriterion>) =
                testingCriteria(JsonField.of(testingCriteria))

            /**
             * Sets [Builder.testingCriteria] to an arbitrary JSON value.
             *
             * You should usually call [Builder.testingCriteria] with a well-typed
             * `List<TestingCriterion>` value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
             */
            fun testingCriteria(testingCriteria: JsonField<List<TestingCriterion>>) = apply {
                this.testingCriteria = testingCriteria.map { it.toMutableList() }
            }

            /**
             * Adds a single [TestingCriterion] to [testingCriteria].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTestingCriterion(testingCriterion: TestingCriterion) = apply {
                testingCriteria =
                    (testingCriteria ?: JsonField.of(mutableListOf())).also {
                        checkKnown("testingCriteria", it).add(testingCriterion)
                    }
            }

            /**
             * Alias for calling [addTestingCriterion] with
             * `TestingCriterion.ofLabelModel(labelModel)`.
             */
            fun addTestingCriterion(labelModel: TestingCriterion.LabelModel) =
                addTestingCriterion(TestingCriterion.ofLabelModel(labelModel))

            /**
             * Alias for calling [addTestingCriterion] with
             * `TestingCriterion.ofStringCheck(stringCheck)`.
             */
            fun addTestingCriterion(stringCheck: EvalStringCheckGrader) =
                addTestingCriterion(TestingCriterion.ofStringCheck(stringCheck))

            /**
             * Alias for calling [addTestingCriterion] with
             * `TestingCriterion.ofTextSimilarity(textSimilarity)`.
             */
            fun addTestingCriterion(textSimilarity: EvalTextSimilarityGrader) =
                addTestingCriterion(TestingCriterion.ofTextSimilarity(textSimilarity))

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

            /** The name of the evaluation. */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** Indicates whether the evaluation is shared with OpenAI. */
            fun shareWithOpenAI(shareWithOpenAI: Boolean) =
                shareWithOpenAI(JsonField.of(shareWithOpenAI))

            /**
             * Sets [Builder.shareWithOpenAI] to an arbitrary JSON value.
             *
             * You should usually call [Builder.shareWithOpenAI] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun shareWithOpenAI(shareWithOpenAI: JsonField<Boolean>) = apply {
                this.shareWithOpenAI = shareWithOpenAI
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
             * .dataSourceConfig()
             * .testingCriteria()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("dataSourceConfig", dataSourceConfig),
                    checkRequired("testingCriteria", testingCriteria).map { it.toImmutable() },
                    metadata,
                    name,
                    shareWithOpenAI,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            dataSourceConfig().validate()
            testingCriteria().forEach { it.validate() }
            metadata().ifPresent { it.validate() }
            name()
            shareWithOpenAI()
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
            (dataSourceConfig.asKnown().getOrNull()?.validity() ?: 0) +
                (testingCriteria.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (metadata.asKnown().getOrNull()?.validity() ?: 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (shareWithOpenAI.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && dataSourceConfig == other.dataSourceConfig && testingCriteria == other.testingCriteria && metadata == other.metadata && name == other.name && shareWithOpenAI == other.shareWithOpenAI && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(dataSourceConfig, testingCriteria, metadata, name, shareWithOpenAI, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{dataSourceConfig=$dataSourceConfig, testingCriteria=$testingCriteria, metadata=$metadata, name=$name, shareWithOpenAI=$shareWithOpenAI, additionalProperties=$additionalProperties}"
    }

    /** The configuration for the data source used for the evaluation runs. */
    @JsonDeserialize(using = DataSourceConfig.Deserializer::class)
    @JsonSerialize(using = DataSourceConfig.Serializer::class)
    class DataSourceConfig
    private constructor(
        private val custom: Custom? = null,
        private val storedCompletions: StoredCompletions? = null,
        private val _json: JsonValue? = null,
    ) {

        /**
         * A CustomDataSourceConfig object that defines the schema for the data source used for the
         * evaluation runs. This schema is used to define the shape of the data that will be:
         * - Used to define your testing criteria and
         * - What data is required when creating a run
         */
        fun custom(): Optional<Custom> = Optional.ofNullable(custom)

        /**
         * A data source config which specifies the metadata property of your stored completions
         * query. This is usually metadata like `usecase=chatbot` or `prompt-version=v2`, etc.
         */
        fun storedCompletions(): Optional<StoredCompletions> =
            Optional.ofNullable(storedCompletions)

        fun isCustom(): Boolean = custom != null

        fun isStoredCompletions(): Boolean = storedCompletions != null

        /**
         * A CustomDataSourceConfig object that defines the schema for the data source used for the
         * evaluation runs. This schema is used to define the shape of the data that will be:
         * - Used to define your testing criteria and
         * - What data is required when creating a run
         */
        fun asCustom(): Custom = custom.getOrThrow("custom")

        /**
         * A data source config which specifies the metadata property of your stored completions
         * query. This is usually metadata like `usecase=chatbot` or `prompt-version=v2`, etc.
         */
        fun asStoredCompletions(): StoredCompletions =
            storedCompletions.getOrThrow("storedCompletions")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                custom != null -> visitor.visitCustom(custom)
                storedCompletions != null -> visitor.visitStoredCompletions(storedCompletions)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): DataSourceConfig = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitCustom(custom: Custom) {
                        custom.validate()
                    }

                    override fun visitStoredCompletions(storedCompletions: StoredCompletions) {
                        storedCompletions.validate()
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
                    override fun visitCustom(custom: Custom) = custom.validity()

                    override fun visitStoredCompletions(storedCompletions: StoredCompletions) =
                        storedCompletions.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is DataSourceConfig && custom == other.custom && storedCompletions == other.storedCompletions /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(custom, storedCompletions) /* spotless:on */

        override fun toString(): String =
            when {
                custom != null -> "DataSourceConfig{custom=$custom}"
                storedCompletions != null ->
                    "DataSourceConfig{storedCompletions=$storedCompletions}"
                _json != null -> "DataSourceConfig{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid DataSourceConfig")
            }

        companion object {

            /**
             * A CustomDataSourceConfig object that defines the schema for the data source used for
             * the evaluation runs. This schema is used to define the shape of the data that will
             * be:
             * - Used to define your testing criteria and
             * - What data is required when creating a run
             */
            @JvmStatic fun ofCustom(custom: Custom) = DataSourceConfig(custom = custom)

            /**
             * A data source config which specifies the metadata property of your stored completions
             * query. This is usually metadata like `usecase=chatbot` or `prompt-version=v2`, etc.
             */
            @JvmStatic
            fun ofStoredCompletions(storedCompletions: StoredCompletions) =
                DataSourceConfig(storedCompletions = storedCompletions)
        }

        /**
         * An interface that defines how to map each variant of [DataSourceConfig] to a value of
         * type [T].
         */
        interface Visitor<out T> {

            /**
             * A CustomDataSourceConfig object that defines the schema for the data source used for
             * the evaluation runs. This schema is used to define the shape of the data that will
             * be:
             * - Used to define your testing criteria and
             * - What data is required when creating a run
             */
            fun visitCustom(custom: Custom): T

            /**
             * A data source config which specifies the metadata property of your stored completions
             * query. This is usually metadata like `usecase=chatbot` or `prompt-version=v2`, etc.
             */
            fun visitStoredCompletions(storedCompletions: StoredCompletions): T

            /**
             * Maps an unknown variant of [DataSourceConfig] to a value of type [T].
             *
             * An instance of [DataSourceConfig] can contain an unknown variant if it was
             * deserialized from data that doesn't match any known variant. For example, if the SDK
             * is on an older version than the API, then the API may respond with new variants that
             * the SDK is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown DataSourceConfig: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<DataSourceConfig>(DataSourceConfig::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): DataSourceConfig {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "custom" -> {
                        return tryDeserialize(node, jacksonTypeRef<Custom>())?.let {
                            DataSourceConfig(custom = it, _json = json)
                        } ?: DataSourceConfig(_json = json)
                    }
                    "stored_completions" -> {
                        return tryDeserialize(node, jacksonTypeRef<StoredCompletions>())?.let {
                            DataSourceConfig(storedCompletions = it, _json = json)
                        } ?: DataSourceConfig(_json = json)
                    }
                }

                return DataSourceConfig(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<DataSourceConfig>(DataSourceConfig::class) {

            override fun serialize(
                value: DataSourceConfig,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.custom != null -> generator.writeObject(value.custom)
                    value.storedCompletions != null ->
                        generator.writeObject(value.storedCompletions)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid DataSourceConfig")
                }
            }
        }

        /**
         * A CustomDataSourceConfig object that defines the schema for the data source used for the
         * evaluation runs. This schema is used to define the shape of the data that will be:
         * - Used to define your testing criteria and
         * - What data is required when creating a run
         */
        class Custom
        private constructor(
            private val itemSchema: JsonField<ItemSchema>,
            private val type: JsonValue,
            private val includeSampleSchema: JsonField<Boolean>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("item_schema")
                @ExcludeMissing
                itemSchema: JsonField<ItemSchema> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                @JsonProperty("include_sample_schema")
                @ExcludeMissing
                includeSampleSchema: JsonField<Boolean> = JsonMissing.of(),
            ) : this(itemSchema, type, includeSampleSchema, mutableMapOf())

            /**
             * The json schema for the run data source items.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun itemSchema(): ItemSchema = itemSchema.getRequired("item_schema")

            /**
             * The type of data source. Always `custom`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("custom")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Whether to include the sample schema in the data source.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun includeSampleSchema(): Optional<Boolean> =
                includeSampleSchema.getOptional("include_sample_schema")

            /**
             * Returns the raw JSON value of [itemSchema].
             *
             * Unlike [itemSchema], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("item_schema")
            @ExcludeMissing
            fun _itemSchema(): JsonField<ItemSchema> = itemSchema

            /**
             * Returns the raw JSON value of [includeSampleSchema].
             *
             * Unlike [includeSampleSchema], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("include_sample_schema")
            @ExcludeMissing
            fun _includeSampleSchema(): JsonField<Boolean> = includeSampleSchema

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
                 * Returns a mutable builder for constructing an instance of [Custom].
                 *
                 * The following fields are required:
                 * ```java
                 * .itemSchema()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Custom]. */
            class Builder internal constructor() {

                private var itemSchema: JsonField<ItemSchema>? = null
                private var type: JsonValue = JsonValue.from("custom")
                private var includeSampleSchema: JsonField<Boolean> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(custom: Custom) = apply {
                    itemSchema = custom.itemSchema
                    type = custom.type
                    includeSampleSchema = custom.includeSampleSchema
                    additionalProperties = custom.additionalProperties.toMutableMap()
                }

                /** The json schema for the run data source items. */
                fun itemSchema(itemSchema: ItemSchema) = itemSchema(JsonField.of(itemSchema))

                /**
                 * Sets [Builder.itemSchema] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.itemSchema] with a well-typed [ItemSchema] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun itemSchema(itemSchema: JsonField<ItemSchema>) = apply {
                    this.itemSchema = itemSchema
                }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("custom")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                /** Whether to include the sample schema in the data source. */
                fun includeSampleSchema(includeSampleSchema: Boolean) =
                    includeSampleSchema(JsonField.of(includeSampleSchema))

                /**
                 * Sets [Builder.includeSampleSchema] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.includeSampleSchema] with a well-typed [Boolean]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun includeSampleSchema(includeSampleSchema: JsonField<Boolean>) = apply {
                    this.includeSampleSchema = includeSampleSchema
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
                 * Returns an immutable instance of [Custom].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .itemSchema()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Custom =
                    Custom(
                        checkRequired("itemSchema", itemSchema),
                        type,
                        includeSampleSchema,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Custom = apply {
                if (validated) {
                    return@apply
                }

                itemSchema().validate()
                _type().let {
                    if (it != JsonValue.from("custom")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                includeSampleSchema()
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
                (itemSchema.asKnown().getOrNull()?.validity() ?: 0) +
                    type.let { if (it == JsonValue.from("custom")) 1 else 0 } +
                    (if (includeSampleSchema.asKnown().isPresent) 1 else 0)

            /** The json schema for the run data source items. */
            class ItemSchema
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

                    /** Returns a mutable builder for constructing an instance of [ItemSchema]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [ItemSchema]. */
                class Builder internal constructor() {

                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(itemSchema: ItemSchema) = apply {
                        additionalProperties = itemSchema.additionalProperties.toMutableMap()
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
                     * Returns an immutable instance of [ItemSchema].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): ItemSchema = ItemSchema(additionalProperties.toImmutable())
                }

                private var validated: Boolean = false

                fun validate(): ItemSchema = apply {
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
                    additionalProperties.count { (_, value) ->
                        !value.isNull() && !value.isMissing()
                    }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is ItemSchema && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() = "ItemSchema{additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Custom && itemSchema == other.itemSchema && type == other.type && includeSampleSchema == other.includeSampleSchema && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(itemSchema, type, includeSampleSchema, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Custom{itemSchema=$itemSchema, type=$type, includeSampleSchema=$includeSampleSchema, additionalProperties=$additionalProperties}"
        }

        /**
         * A data source config which specifies the metadata property of your stored completions
         * query. This is usually metadata like `usecase=chatbot` or `prompt-version=v2`, etc.
         */
        class StoredCompletions
        private constructor(
            private val type: JsonValue,
            private val metadata: JsonField<Metadata>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                @JsonProperty("metadata")
                @ExcludeMissing
                metadata: JsonField<Metadata> = JsonMissing.of(),
            ) : this(type, metadata, mutableMapOf())

            /**
             * The type of data source. Always `stored_completions`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("stored_completions")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Set of 16 key-value pairs that can be attached to an object. This can be useful for
             * storing additional information about the object in a structured format, and querying
             * for objects via API or the dashboard.
             *
             * Keys are strings with a maximum length of 64 characters. Values are strings with a
             * maximum length of 512 characters.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun metadata(): Optional<Metadata> = metadata.getOptional("metadata")

            /**
             * Returns the raw JSON value of [metadata].
             *
             * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("metadata")
            @ExcludeMissing
            fun _metadata(): JsonField<Metadata> = metadata

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
                 * Returns a mutable builder for constructing an instance of [StoredCompletions].
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [StoredCompletions]. */
            class Builder internal constructor() {

                private var type: JsonValue = JsonValue.from("stored_completions")
                private var metadata: JsonField<Metadata> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(storedCompletions: StoredCompletions) = apply {
                    type = storedCompletions.type
                    metadata = storedCompletions.metadata
                    additionalProperties = storedCompletions.additionalProperties.toMutableMap()
                }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("stored_completions")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                /**
                 * Set of 16 key-value pairs that can be attached to an object. This can be useful
                 * for storing additional information about the object in a structured format, and
                 * querying for objects via API or the dashboard.
                 *
                 * Keys are strings with a maximum length of 64 characters. Values are strings with
                 * a maximum length of 512 characters.
                 */
                fun metadata(metadata: Metadata?) = metadata(JsonField.ofNullable(metadata))

                /** Alias for calling [Builder.metadata] with `metadata.orElse(null)`. */
                fun metadata(metadata: Optional<Metadata>) = metadata(metadata.getOrNull())

                /**
                 * Sets [Builder.metadata] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.metadata] with a well-typed [Metadata] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

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
                 * Returns an immutable instance of [StoredCompletions].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): StoredCompletions =
                    StoredCompletions(type, metadata, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): StoredCompletions = apply {
                if (validated) {
                    return@apply
                }

                _type().let {
                    if (it != JsonValue.from("stored_completions")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                metadata().ifPresent { it.validate() }
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
                type.let { if (it == JsonValue.from("stored_completions")) 1 else 0 } +
                    (metadata.asKnown().getOrNull()?.validity() ?: 0)

            /**
             * Set of 16 key-value pairs that can be attached to an object. This can be useful for
             * storing additional information about the object in a structured format, and querying
             * for objects via API or the dashboard.
             *
             * Keys are strings with a maximum length of 64 characters. Values are strings with a
             * maximum length of 512 characters.
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
                    additionalProperties.count { (_, value) ->
                        !value.isNull() && !value.isMissing()
                    }

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

                return /* spotless:off */ other is StoredCompletions && type == other.type && metadata == other.metadata && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(type, metadata, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "StoredCompletions{type=$type, metadata=$metadata, additionalProperties=$additionalProperties}"
        }
    }

    /**
     * A LabelModelGrader object which uses a model to assign labels to each item in the evaluation.
     */
    @JsonDeserialize(using = TestingCriterion.Deserializer::class)
    @JsonSerialize(using = TestingCriterion.Serializer::class)
    class TestingCriterion
    private constructor(
        private val labelModel: LabelModel? = null,
        private val stringCheck: EvalStringCheckGrader? = null,
        private val textSimilarity: EvalTextSimilarityGrader? = null,
        private val _json: JsonValue? = null,
    ) {

        /**
         * A LabelModelGrader object which uses a model to assign labels to each item in the
         * evaluation.
         */
        fun labelModel(): Optional<LabelModel> = Optional.ofNullable(labelModel)

        /**
         * A StringCheckGrader object that performs a string comparison between input and reference
         * using a specified operation.
         */
        fun stringCheck(): Optional<EvalStringCheckGrader> = Optional.ofNullable(stringCheck)

        /** A TextSimilarityGrader object which grades text based on similarity metrics. */
        fun textSimilarity(): Optional<EvalTextSimilarityGrader> =
            Optional.ofNullable(textSimilarity)

        fun isLabelModel(): Boolean = labelModel != null

        fun isStringCheck(): Boolean = stringCheck != null

        fun isTextSimilarity(): Boolean = textSimilarity != null

        /**
         * A LabelModelGrader object which uses a model to assign labels to each item in the
         * evaluation.
         */
        fun asLabelModel(): LabelModel = labelModel.getOrThrow("labelModel")

        /**
         * A StringCheckGrader object that performs a string comparison between input and reference
         * using a specified operation.
         */
        fun asStringCheck(): EvalStringCheckGrader = stringCheck.getOrThrow("stringCheck")

        /** A TextSimilarityGrader object which grades text based on similarity metrics. */
        fun asTextSimilarity(): EvalTextSimilarityGrader =
            textSimilarity.getOrThrow("textSimilarity")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                labelModel != null -> visitor.visitLabelModel(labelModel)
                stringCheck != null -> visitor.visitStringCheck(stringCheck)
                textSimilarity != null -> visitor.visitTextSimilarity(textSimilarity)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): TestingCriterion = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitLabelModel(labelModel: LabelModel) {
                        labelModel.validate()
                    }

                    override fun visitStringCheck(stringCheck: EvalStringCheckGrader) {
                        stringCheck.validate()
                    }

                    override fun visitTextSimilarity(textSimilarity: EvalTextSimilarityGrader) {
                        textSimilarity.validate()
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
                    override fun visitLabelModel(labelModel: LabelModel) = labelModel.validity()

                    override fun visitStringCheck(stringCheck: EvalStringCheckGrader) =
                        stringCheck.validity()

                    override fun visitTextSimilarity(textSimilarity: EvalTextSimilarityGrader) =
                        textSimilarity.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is TestingCriterion && labelModel == other.labelModel && stringCheck == other.stringCheck && textSimilarity == other.textSimilarity /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(labelModel, stringCheck, textSimilarity) /* spotless:on */

        override fun toString(): String =
            when {
                labelModel != null -> "TestingCriterion{labelModel=$labelModel}"
                stringCheck != null -> "TestingCriterion{stringCheck=$stringCheck}"
                textSimilarity != null -> "TestingCriterion{textSimilarity=$textSimilarity}"
                _json != null -> "TestingCriterion{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid TestingCriterion")
            }

        companion object {

            /**
             * A LabelModelGrader object which uses a model to assign labels to each item in the
             * evaluation.
             */
            @JvmStatic
            fun ofLabelModel(labelModel: LabelModel) = TestingCriterion(labelModel = labelModel)

            /**
             * A StringCheckGrader object that performs a string comparison between input and
             * reference using a specified operation.
             */
            @JvmStatic
            fun ofStringCheck(stringCheck: EvalStringCheckGrader) =
                TestingCriterion(stringCheck = stringCheck)

            /** A TextSimilarityGrader object which grades text based on similarity metrics. */
            @JvmStatic
            fun ofTextSimilarity(textSimilarity: EvalTextSimilarityGrader) =
                TestingCriterion(textSimilarity = textSimilarity)
        }

        /**
         * An interface that defines how to map each variant of [TestingCriterion] to a value of
         * type [T].
         */
        interface Visitor<out T> {

            /**
             * A LabelModelGrader object which uses a model to assign labels to each item in the
             * evaluation.
             */
            fun visitLabelModel(labelModel: LabelModel): T

            /**
             * A StringCheckGrader object that performs a string comparison between input and
             * reference using a specified operation.
             */
            fun visitStringCheck(stringCheck: EvalStringCheckGrader): T

            /** A TextSimilarityGrader object which grades text based on similarity metrics. */
            fun visitTextSimilarity(textSimilarity: EvalTextSimilarityGrader): T

            /**
             * Maps an unknown variant of [TestingCriterion] to a value of type [T].
             *
             * An instance of [TestingCriterion] can contain an unknown variant if it was
             * deserialized from data that doesn't match any known variant. For example, if the SDK
             * is on an older version than the API, then the API may respond with new variants that
             * the SDK is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown TestingCriterion: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<TestingCriterion>(TestingCriterion::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): TestingCriterion {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "label_model" -> {
                        return tryDeserialize(node, jacksonTypeRef<LabelModel>())?.let {
                            TestingCriterion(labelModel = it, _json = json)
                        } ?: TestingCriterion(_json = json)
                    }
                    "string_check" -> {
                        return tryDeserialize(node, jacksonTypeRef<EvalStringCheckGrader>())?.let {
                            TestingCriterion(stringCheck = it, _json = json)
                        } ?: TestingCriterion(_json = json)
                    }
                    "text_similarity" -> {
                        return tryDeserialize(node, jacksonTypeRef<EvalTextSimilarityGrader>())
                            ?.let { TestingCriterion(textSimilarity = it, _json = json) }
                            ?: TestingCriterion(_json = json)
                    }
                }

                return TestingCriterion(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<TestingCriterion>(TestingCriterion::class) {

            override fun serialize(
                value: TestingCriterion,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.labelModel != null -> generator.writeObject(value.labelModel)
                    value.stringCheck != null -> generator.writeObject(value.stringCheck)
                    value.textSimilarity != null -> generator.writeObject(value.textSimilarity)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid TestingCriterion")
                }
            }
        }

        /**
         * A LabelModelGrader object which uses a model to assign labels to each item in the
         * evaluation.
         */
        class LabelModel
        private constructor(
            private val input: JsonField<List<Input>>,
            private val labels: JsonField<List<String>>,
            private val model: JsonField<String>,
            private val name: JsonField<String>,
            private val passingLabels: JsonField<List<String>>,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("input")
                @ExcludeMissing
                input: JsonField<List<Input>> = JsonMissing.of(),
                @JsonProperty("labels")
                @ExcludeMissing
                labels: JsonField<List<String>> = JsonMissing.of(),
                @JsonProperty("model") @ExcludeMissing model: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("passing_labels")
                @ExcludeMissing
                passingLabels: JsonField<List<String>> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(input, labels, model, name, passingLabels, type, mutableMapOf())

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun input(): List<Input> = input.getRequired("input")

            /**
             * The labels to classify to each item in the evaluation.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun labels(): List<String> = labels.getRequired("labels")

            /**
             * The model to use for the evaluation. Must support structured outputs.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun model(): String = model.getRequired("model")

            /**
             * The name of the grader.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * The labels that indicate a passing result. Must be a subset of labels.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun passingLabels(): List<String> = passingLabels.getRequired("passing_labels")

            /**
             * The object type, which is always `label_model`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("label_model")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Returns the raw JSON value of [input].
             *
             * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("input") @ExcludeMissing fun _input(): JsonField<List<Input>> = input

            /**
             * Returns the raw JSON value of [labels].
             *
             * Unlike [labels], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("labels") @ExcludeMissing fun _labels(): JsonField<List<String>> = labels

            /**
             * Returns the raw JSON value of [model].
             *
             * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [passingLabels].
             *
             * Unlike [passingLabels], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("passing_labels")
            @ExcludeMissing
            fun _passingLabels(): JsonField<List<String>> = passingLabels

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
                 * Returns a mutable builder for constructing an instance of [LabelModel].
                 *
                 * The following fields are required:
                 * ```java
                 * .input()
                 * .labels()
                 * .model()
                 * .name()
                 * .passingLabels()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [LabelModel]. */
            class Builder internal constructor() {

                private var input: JsonField<MutableList<Input>>? = null
                private var labels: JsonField<MutableList<String>>? = null
                private var model: JsonField<String>? = null
                private var name: JsonField<String>? = null
                private var passingLabels: JsonField<MutableList<String>>? = null
                private var type: JsonValue = JsonValue.from("label_model")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(labelModel: LabelModel) = apply {
                    input = labelModel.input.map { it.toMutableList() }
                    labels = labelModel.labels.map { it.toMutableList() }
                    model = labelModel.model
                    name = labelModel.name
                    passingLabels = labelModel.passingLabels.map { it.toMutableList() }
                    type = labelModel.type
                    additionalProperties = labelModel.additionalProperties.toMutableMap()
                }

                fun input(input: List<Input>) = input(JsonField.of(input))

                /**
                 * Sets [Builder.input] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.input] with a well-typed `List<Input>` value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun input(input: JsonField<List<Input>>) = apply {
                    this.input = input.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Input] to [Builder.input].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addInput(input: Input) = apply {
                    this.input =
                        (this.input ?: JsonField.of(mutableListOf())).also {
                            checkKnown("input", it).add(input)
                        }
                }

                /**
                 * Alias for calling [addInput] with
                 * `Input.ofSimpleInputMessage(simpleInputMessage)`.
                 */
                fun addInput(simpleInputMessage: Input.SimpleInputMessage) =
                    addInput(Input.ofSimpleInputMessage(simpleInputMessage))

                /** Alias for calling [addInput] with `Input.ofMessage(message)`. */
                fun addInput(message: Input.InputMessage) = addInput(Input.ofMessage(message))

                /** Alias for calling [addInput] with `Input.ofOutputMessage(outputMessage)`. */
                fun addInput(outputMessage: Input.OutputMessage) =
                    addInput(Input.ofOutputMessage(outputMessage))

                /** The labels to classify to each item in the evaluation. */
                fun labels(labels: List<String>) = labels(JsonField.of(labels))

                /**
                 * Sets [Builder.labels] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.labels] with a well-typed `List<String>` value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun labels(labels: JsonField<List<String>>) = apply {
                    this.labels = labels.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [labels].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addLabel(label: String) = apply {
                    labels =
                        (labels ?: JsonField.of(mutableListOf())).also {
                            checkKnown("labels", it).add(label)
                        }
                }

                /** The model to use for the evaluation. Must support structured outputs. */
                fun model(model: String) = model(JsonField.of(model))

                /**
                 * Sets [Builder.model] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.model] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun model(model: JsonField<String>) = apply { this.model = model }

                /** The name of the grader. */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                /** The labels that indicate a passing result. Must be a subset of labels. */
                fun passingLabels(passingLabels: List<String>) =
                    passingLabels(JsonField.of(passingLabels))

                /**
                 * Sets [Builder.passingLabels] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.passingLabels] with a well-typed `List<String>`
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun passingLabels(passingLabels: JsonField<List<String>>) = apply {
                    this.passingLabels = passingLabels.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [passingLabels].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addPassingLabel(passingLabel: String) = apply {
                    passingLabels =
                        (passingLabels ?: JsonField.of(mutableListOf())).also {
                            checkKnown("passingLabels", it).add(passingLabel)
                        }
                }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("label_model")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

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
                 * Returns an immutable instance of [LabelModel].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .input()
                 * .labels()
                 * .model()
                 * .name()
                 * .passingLabels()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): LabelModel =
                    LabelModel(
                        checkRequired("input", input).map { it.toImmutable() },
                        checkRequired("labels", labels).map { it.toImmutable() },
                        checkRequired("model", model),
                        checkRequired("name", name),
                        checkRequired("passingLabels", passingLabels).map { it.toImmutable() },
                        type,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): LabelModel = apply {
                if (validated) {
                    return@apply
                }

                input().forEach { it.validate() }
                labels()
                model()
                name()
                passingLabels()
                _type().let {
                    if (it != JsonValue.from("label_model")) {
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
                (input.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                    (labels.asKnown().getOrNull()?.size ?: 0) +
                    (if (model.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0) +
                    (passingLabels.asKnown().getOrNull()?.size ?: 0) +
                    type.let { if (it == JsonValue.from("label_model")) 1 else 0 }

            @JsonDeserialize(using = Input.Deserializer::class)
            @JsonSerialize(using = Input.Serializer::class)
            class Input
            private constructor(
                private val simpleInputMessage: SimpleInputMessage? = null,
                private val message: InputMessage? = null,
                private val outputMessage: OutputMessage? = null,
                private val _json: JsonValue? = null,
            ) {

                fun simpleInputMessage(): Optional<SimpleInputMessage> =
                    Optional.ofNullable(simpleInputMessage)

                fun message(): Optional<InputMessage> = Optional.ofNullable(message)

                fun outputMessage(): Optional<OutputMessage> = Optional.ofNullable(outputMessage)

                fun isSimpleInputMessage(): Boolean = simpleInputMessage != null

                fun isMessage(): Boolean = message != null

                fun isOutputMessage(): Boolean = outputMessage != null

                fun asSimpleInputMessage(): SimpleInputMessage =
                    simpleInputMessage.getOrThrow("simpleInputMessage")

                fun asMessage(): InputMessage = message.getOrThrow("message")

                fun asOutputMessage(): OutputMessage = outputMessage.getOrThrow("outputMessage")

                fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                fun <T> accept(visitor: Visitor<T>): T =
                    when {
                        simpleInputMessage != null ->
                            visitor.visitSimpleInputMessage(simpleInputMessage)
                        message != null -> visitor.visitMessage(message)
                        outputMessage != null -> visitor.visitOutputMessage(outputMessage)
                        else -> visitor.unknown(_json)
                    }

                private var validated: Boolean = false

                fun validate(): Input = apply {
                    if (validated) {
                        return@apply
                    }

                    accept(
                        object : Visitor<Unit> {
                            override fun visitSimpleInputMessage(
                                simpleInputMessage: SimpleInputMessage
                            ) {
                                simpleInputMessage.validate()
                            }

                            override fun visitMessage(message: InputMessage) {
                                message.validate()
                            }

                            override fun visitOutputMessage(outputMessage: OutputMessage) {
                                outputMessage.validate()
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
                            override fun visitSimpleInputMessage(
                                simpleInputMessage: SimpleInputMessage
                            ) = simpleInputMessage.validity()

                            override fun visitMessage(message: InputMessage) = message.validity()

                            override fun visitOutputMessage(outputMessage: OutputMessage) =
                                outputMessage.validity()

                            override fun unknown(json: JsonValue?) = 0
                        }
                    )

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Input && simpleInputMessage == other.simpleInputMessage && message == other.message && outputMessage == other.outputMessage /* spotless:on */
                }

                override fun hashCode(): Int = /* spotless:off */ Objects.hash(simpleInputMessage, message, outputMessage) /* spotless:on */

                override fun toString(): String =
                    when {
                        simpleInputMessage != null ->
                            "Input{simpleInputMessage=$simpleInputMessage}"
                        message != null -> "Input{message=$message}"
                        outputMessage != null -> "Input{outputMessage=$outputMessage}"
                        _json != null -> "Input{_unknown=$_json}"
                        else -> throw IllegalStateException("Invalid Input")
                    }

                companion object {

                    @JvmStatic
                    fun ofSimpleInputMessage(simpleInputMessage: SimpleInputMessage) =
                        Input(simpleInputMessage = simpleInputMessage)

                    @JvmStatic fun ofMessage(message: InputMessage) = Input(message = message)

                    @JvmStatic
                    fun ofOutputMessage(outputMessage: OutputMessage) =
                        Input(outputMessage = outputMessage)
                }

                /**
                 * An interface that defines how to map each variant of [Input] to a value of type
                 * [T].
                 */
                interface Visitor<out T> {

                    fun visitSimpleInputMessage(simpleInputMessage: SimpleInputMessage): T

                    fun visitMessage(message: InputMessage): T

                    fun visitOutputMessage(outputMessage: OutputMessage): T

                    /**
                     * Maps an unknown variant of [Input] to a value of type [T].
                     *
                     * An instance of [Input] can contain an unknown variant if it was deserialized
                     * from data that doesn't match any known variant. For example, if the SDK is on
                     * an older version than the API, then the API may respond with new variants
                     * that the SDK is unaware of.
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

                        val bestMatches =
                            sequenceOf(
                                    tryDeserialize(node, jacksonTypeRef<SimpleInputMessage>())
                                        ?.let { Input(simpleInputMessage = it, _json = json) },
                                    tryDeserialize(node, jacksonTypeRef<InputMessage>())?.let {
                                        Input(message = it, _json = json)
                                    },
                                    tryDeserialize(node, jacksonTypeRef<OutputMessage>())?.let {
                                        Input(outputMessage = it, _json = json)
                                    },
                                )
                                .filterNotNull()
                                .allMaxBy { it.validity() }
                                .toList()
                        return when (bestMatches.size) {
                            // This can happen if what we're deserializing is completely
                            // incompatible with all the possible variants (e.g. deserializing from
                            // boolean).
                            0 -> Input(_json = json)
                            1 -> bestMatches.single()
                            // If there's more than one match with the highest validity, then use
                            // the first completely valid match, or simply the first match if none
                            // are completely valid.
                            else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                        }
                    }
                }

                internal class Serializer : BaseSerializer<Input>(Input::class) {

                    override fun serialize(
                        value: Input,
                        generator: JsonGenerator,
                        provider: SerializerProvider,
                    ) {
                        when {
                            value.simpleInputMessage != null ->
                                generator.writeObject(value.simpleInputMessage)
                            value.message != null -> generator.writeObject(value.message)
                            value.outputMessage != null ->
                                generator.writeObject(value.outputMessage)
                            value._json != null -> generator.writeObject(value._json)
                            else -> throw IllegalStateException("Invalid Input")
                        }
                    }
                }

                class SimpleInputMessage
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
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun content(): String = content.getRequired("content")

                    /**
                     * The role of the message (e.g. "system", "assistant", "user").
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
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
                     * Unlike [role], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("role") @ExcludeMissing fun _role(): JsonField<String> = role

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
                         * [SimpleInputMessage].
                         *
                         * The following fields are required:
                         * ```java
                         * .content()
                         * .role()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [SimpleInputMessage]. */
                    class Builder internal constructor() {

                        private var content: JsonField<String>? = null
                        private var role: JsonField<String>? = null
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(simpleInputMessage: SimpleInputMessage) = apply {
                            content = simpleInputMessage.content
                            role = simpleInputMessage.role
                            additionalProperties =
                                simpleInputMessage.additionalProperties.toMutableMap()
                        }

                        /** The content of the message. */
                        fun content(content: String) = content(JsonField.of(content))

                        /**
                         * Sets [Builder.content] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.content] with a well-typed [String]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun content(content: JsonField<String>) = apply { this.content = content }

                        /** The role of the message (e.g. "system", "assistant", "user"). */
                        fun role(role: String) = role(JsonField.of(role))

                        /**
                         * Sets [Builder.role] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.role] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun role(role: JsonField<String>) = apply { this.role = role }

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
                         * Returns an immutable instance of [SimpleInputMessage].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .content()
                         * .role()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): SimpleInputMessage =
                            SimpleInputMessage(
                                checkRequired("content", content),
                                checkRequired("role", role),
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    fun validate(): SimpleInputMessage = apply {
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
                     * Returns a score indicating how many valid values are contained in this object
                     * recursively.
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

                        return /* spotless:off */ other is SimpleInputMessage && content == other.content && role == other.role && additionalProperties == other.additionalProperties /* spotless:on */
                    }

                    /* spotless:off */
                    private val hashCode: Int by lazy { Objects.hash(content, role, additionalProperties) }
                    /* spotless:on */

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "SimpleInputMessage{content=$content, role=$role, additionalProperties=$additionalProperties}"
                }

                class InputMessage
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
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun content(): Content = content.getRequired("content")

                    /**
                     * The role of the message. One of `user`, `system`, or `developer`.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun role(): Role = role.getRequired("role")

                    /**
                     * The type of item, which is always `message`.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun type(): Type = type.getRequired("type")

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
                     * Unlike [role], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("role") @ExcludeMissing fun _role(): JsonField<Role> = role

                    /**
                     * Returns the raw JSON value of [type].
                     *
                     * Unlike [type], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

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
                         * Returns a mutable builder for constructing an instance of [InputMessage].
                         *
                         * The following fields are required:
                         * ```java
                         * .content()
                         * .role()
                         * .type()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [InputMessage]. */
                    class Builder internal constructor() {

                        private var content: JsonField<Content>? = null
                        private var role: JsonField<Role>? = null
                        private var type: JsonField<Type>? = null
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(inputMessage: InputMessage) = apply {
                            content = inputMessage.content
                            role = inputMessage.role
                            type = inputMessage.type
                            additionalProperties = inputMessage.additionalProperties.toMutableMap()
                        }

                        fun content(content: Content) = content(JsonField.of(content))

                        /**
                         * Sets [Builder.content] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.content] with a well-typed [Content]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun content(content: JsonField<Content>) = apply { this.content = content }

                        /** The role of the message. One of `user`, `system`, or `developer`. */
                        fun role(role: Role) = role(JsonField.of(role))

                        /**
                         * Sets [Builder.role] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.role] with a well-typed [Role] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun role(role: JsonField<Role>) = apply { this.role = role }

                        /** The type of item, which is always `message`. */
                        fun type(type: Type) = type(JsonField.of(type))

                        /**
                         * Sets [Builder.type] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.type] with a well-typed [Type] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun type(type: JsonField<Type>) = apply { this.type = type }

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
                         * Returns an immutable instance of [InputMessage].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .content()
                         * .role()
                         * .type()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): InputMessage =
                            InputMessage(
                                checkRequired("content", content),
                                checkRequired("role", role),
                                checkRequired("type", type),
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    fun validate(): InputMessage = apply {
                        if (validated) {
                            return@apply
                        }

                        content().validate()
                        role().validate()
                        type().validate()
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
                        (content.asKnown().getOrNull()?.validity() ?: 0) +
                            (role.asKnown().getOrNull()?.validity() ?: 0) +
                            (type.asKnown().getOrNull()?.validity() ?: 0)

                    class Content
                    private constructor(
                        private val text: JsonField<String>,
                        private val type: JsonField<Type>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("text")
                            @ExcludeMissing
                            text: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("type")
                            @ExcludeMissing
                            type: JsonField<Type> = JsonMissing.of(),
                        ) : this(text, type, mutableMapOf())

                        /**
                         * The text content.
                         *
                         * @throws OpenAIInvalidDataException if the JSON field has an unexpected
                         *   type or is unexpectedly missing or null (e.g. if the server responded
                         *   with an unexpected value).
                         */
                        fun text(): String = text.getRequired("text")

                        /**
                         * The type of content, which is always `input_text`.
                         *
                         * @throws OpenAIInvalidDataException if the JSON field has an unexpected
                         *   type or is unexpectedly missing or null (e.g. if the server responded
                         *   with an unexpected value).
                         */
                        fun type(): Type = type.getRequired("type")

                        /**
                         * Returns the raw JSON value of [text].
                         *
                         * Unlike [text], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

                        /**
                         * Returns the raw JSON value of [type].
                         *
                         * Unlike [type], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

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
                             * .text()
                             * .type()
                             * ```
                             */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [Content]. */
                        class Builder internal constructor() {

                            private var text: JsonField<String>? = null
                            private var type: JsonField<Type>? = null
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(content: Content) = apply {
                                text = content.text
                                type = content.type
                                additionalProperties = content.additionalProperties.toMutableMap()
                            }

                            /** The text content. */
                            fun text(text: String) = text(JsonField.of(text))

                            /**
                             * Sets [Builder.text] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.text] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun text(text: JsonField<String>) = apply { this.text = text }

                            /** The type of content, which is always `input_text`. */
                            fun type(type: Type) = type(JsonField.of(type))

                            /**
                             * Sets [Builder.type] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.type] with a well-typed [Type] value
                             * instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun type(type: JsonField<Type>) = apply { this.type = type }

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
                             * .text()
                             * .type()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): Content =
                                Content(
                                    checkRequired("text", text),
                                    checkRequired("type", type),
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): Content = apply {
                            if (validated) {
                                return@apply
                            }

                            text()
                            type().validate()
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
                            (if (text.asKnown().isPresent) 1 else 0) +
                                (type.asKnown().getOrNull()?.validity() ?: 0)

                        /** The type of content, which is always `input_text`. */
                        class Type
                        @JsonCreator
                        private constructor(private val value: JsonField<String>) : Enum {

                            /**
                             * Returns this class instance's raw value.
                             *
                             * This is usually only useful if this instance was deserialized from
                             * data that doesn't match any known member, and you want to know that
                             * value. For example, if the SDK is on an older version than the API,
                             * then the API may respond with new members that the SDK is unaware of.
                             */
                            @com.fasterxml.jackson.annotation.JsonValue
                            fun _value(): JsonField<String> = value

                            companion object {

                                @JvmField val INPUT_TEXT = of("input_text")

                                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                            }

                            /** An enum containing [Type]'s known values. */
                            enum class Known {
                                INPUT_TEXT
                            }

                            /**
                             * An enum containing [Type]'s known values, as well as an [_UNKNOWN]
                             * member.
                             *
                             * An instance of [Type] can contain an unknown value in a couple of
                             * cases:
                             * - It was deserialized from data that doesn't match any known member.
                             *   For example, if the SDK is on an older version than the API, then
                             *   the API may respond with new members that the SDK is unaware of.
                             * - It was constructed with an arbitrary value using the [of] method.
                             */
                            enum class Value {
                                INPUT_TEXT,
                                /**
                                 * An enum member indicating that [Type] was instantiated with an
                                 * unknown value.
                                 */
                                _UNKNOWN,
                            }

                            /**
                             * Returns an enum member corresponding to this class instance's value,
                             * or [Value._UNKNOWN] if the class was instantiated with an unknown
                             * value.
                             *
                             * Use the [known] method instead if you're certain the value is always
                             * known or if you want to throw for the unknown case.
                             */
                            fun value(): Value =
                                when (this) {
                                    INPUT_TEXT -> Value.INPUT_TEXT
                                    else -> Value._UNKNOWN
                                }

                            /**
                             * Returns an enum member corresponding to this class instance's value.
                             *
                             * Use the [value] method instead if you're uncertain the value is
                             * always known and don't want to throw for the unknown case.
                             *
                             * @throws OpenAIInvalidDataException if this class instance's value is
                             *   a not a known member.
                             */
                            fun known(): Known =
                                when (this) {
                                    INPUT_TEXT -> Known.INPUT_TEXT
                                    else -> throw OpenAIInvalidDataException("Unknown Type: $value")
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
                            internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

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

                            return /* spotless:off */ other is Content && text == other.text && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                        }

                        /* spotless:off */
                        private val hashCode: Int by lazy { Objects.hash(text, type, additionalProperties) }
                        /* spotless:on */

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "Content{text=$text, type=$type, additionalProperties=$additionalProperties}"
                    }

                    /** The role of the message. One of `user`, `system`, or `developer`. */
                    class Role
                    @JsonCreator
                    private constructor(private val value: JsonField<String>) : Enum {

                        /**
                         * Returns this class instance's raw value.
                         *
                         * This is usually only useful if this instance was deserialized from data
                         * that doesn't match any known member, and you want to know that value. For
                         * example, if the SDK is on an older version than the API, then the API may
                         * respond with new members that the SDK is unaware of.
                         */
                        @com.fasterxml.jackson.annotation.JsonValue
                        fun _value(): JsonField<String> = value

                        companion object {

                            @JvmField val USER = of("user")

                            @JvmField val SYSTEM = of("system")

                            @JvmField val DEVELOPER = of("developer")

                            @JvmStatic fun of(value: String) = Role(JsonField.of(value))
                        }

                        /** An enum containing [Role]'s known values. */
                        enum class Known {
                            USER,
                            SYSTEM,
                            DEVELOPER,
                        }

                        /**
                         * An enum containing [Role]'s known values, as well as an [_UNKNOWN]
                         * member.
                         *
                         * An instance of [Role] can contain an unknown value in a couple of cases:
                         * - It was deserialized from data that doesn't match any known member. For
                         *   example, if the SDK is on an older version than the API, then the API
                         *   may respond with new members that the SDK is unaware of.
                         * - It was constructed with an arbitrary value using the [of] method.
                         */
                        enum class Value {
                            USER,
                            SYSTEM,
                            DEVELOPER,
                            /**
                             * An enum member indicating that [Role] was instantiated with an
                             * unknown value.
                             */
                            _UNKNOWN,
                        }

                        /**
                         * Returns an enum member corresponding to this class instance's value, or
                         * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                         *
                         * Use the [known] method instead if you're certain the value is always
                         * known or if you want to throw for the unknown case.
                         */
                        fun value(): Value =
                            when (this) {
                                USER -> Value.USER
                                SYSTEM -> Value.SYSTEM
                                DEVELOPER -> Value.DEVELOPER
                                else -> Value._UNKNOWN
                            }

                        /**
                         * Returns an enum member corresponding to this class instance's value.
                         *
                         * Use the [value] method instead if you're uncertain the value is always
                         * known and don't want to throw for the unknown case.
                         *
                         * @throws OpenAIInvalidDataException if this class instance's value is a
                         *   not a known member.
                         */
                        fun known(): Known =
                            when (this) {
                                USER -> Known.USER
                                SYSTEM -> Known.SYSTEM
                                DEVELOPER -> Known.DEVELOPER
                                else -> throw OpenAIInvalidDataException("Unknown Role: $value")
                            }

                        /**
                         * Returns this class instance's primitive wire representation.
                         *
                         * This differs from the [toString] method because that method is primarily
                         * for debugging and generally doesn't throw.
                         *
                         * @throws OpenAIInvalidDataException if this class instance's value does
                         *   not have the expected primitive type.
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return /* spotless:off */ other is Role && value == other.value /* spotless:on */
                        }

                        override fun hashCode() = value.hashCode()

                        override fun toString() = value.toString()
                    }

                    /** The type of item, which is always `message`. */
                    class Type
                    @JsonCreator
                    private constructor(private val value: JsonField<String>) : Enum {

                        /**
                         * Returns this class instance's raw value.
                         *
                         * This is usually only useful if this instance was deserialized from data
                         * that doesn't match any known member, and you want to know that value. For
                         * example, if the SDK is on an older version than the API, then the API may
                         * respond with new members that the SDK is unaware of.
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
                         * An enum containing [Type]'s known values, as well as an [_UNKNOWN]
                         * member.
                         *
                         * An instance of [Type] can contain an unknown value in a couple of cases:
                         * - It was deserialized from data that doesn't match any known member. For
                         *   example, if the SDK is on an older version than the API, then the API
                         *   may respond with new members that the SDK is unaware of.
                         * - It was constructed with an arbitrary value using the [of] method.
                         */
                        enum class Value {
                            MESSAGE,
                            /**
                             * An enum member indicating that [Type] was instantiated with an
                             * unknown value.
                             */
                            _UNKNOWN,
                        }

                        /**
                         * Returns an enum member corresponding to this class instance's value, or
                         * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                         *
                         * Use the [known] method instead if you're certain the value is always
                         * known or if you want to throw for the unknown case.
                         */
                        fun value(): Value =
                            when (this) {
                                MESSAGE -> Value.MESSAGE
                                else -> Value._UNKNOWN
                            }

                        /**
                         * Returns an enum member corresponding to this class instance's value.
                         *
                         * Use the [value] method instead if you're uncertain the value is always
                         * known and don't want to throw for the unknown case.
                         *
                         * @throws OpenAIInvalidDataException if this class instance's value is a
                         *   not a known member.
                         */
                        fun known(): Known =
                            when (this) {
                                MESSAGE -> Known.MESSAGE
                                else -> throw OpenAIInvalidDataException("Unknown Type: $value")
                            }

                        /**
                         * Returns this class instance's primitive wire representation.
                         *
                         * This differs from the [toString] method because that method is primarily
                         * for debugging and generally doesn't throw.
                         *
                         * @throws OpenAIInvalidDataException if this class instance's value does
                         *   not have the expected primitive type.
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

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

                        return /* spotless:off */ other is InputMessage && content == other.content && role == other.role && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                    }

                    /* spotless:off */
                    private val hashCode: Int by lazy { Objects.hash(content, role, type, additionalProperties) }
                    /* spotless:on */

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "InputMessage{content=$content, role=$role, type=$type, additionalProperties=$additionalProperties}"
                }

                class OutputMessage
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
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun content(): Content = content.getRequired("content")

                    /**
                     * The role of the message. Must be `assistant` for output.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun role(): Role = role.getRequired("role")

                    /**
                     * The type of item, which is always `message`.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun type(): Type = type.getRequired("type")

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
                     * Unlike [role], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("role") @ExcludeMissing fun _role(): JsonField<Role> = role

                    /**
                     * Returns the raw JSON value of [type].
                     *
                     * Unlike [type], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

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
                         * [OutputMessage].
                         *
                         * The following fields are required:
                         * ```java
                         * .content()
                         * .role()
                         * .type()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [OutputMessage]. */
                    class Builder internal constructor() {

                        private var content: JsonField<Content>? = null
                        private var role: JsonField<Role>? = null
                        private var type: JsonField<Type>? = null
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(outputMessage: OutputMessage) = apply {
                            content = outputMessage.content
                            role = outputMessage.role
                            type = outputMessage.type
                            additionalProperties = outputMessage.additionalProperties.toMutableMap()
                        }

                        fun content(content: Content) = content(JsonField.of(content))

                        /**
                         * Sets [Builder.content] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.content] with a well-typed [Content]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun content(content: JsonField<Content>) = apply { this.content = content }

                        /** The role of the message. Must be `assistant` for output. */
                        fun role(role: Role) = role(JsonField.of(role))

                        /**
                         * Sets [Builder.role] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.role] with a well-typed [Role] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun role(role: JsonField<Role>) = apply { this.role = role }

                        /** The type of item, which is always `message`. */
                        fun type(type: Type) = type(JsonField.of(type))

                        /**
                         * Sets [Builder.type] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.type] with a well-typed [Type] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun type(type: JsonField<Type>) = apply { this.type = type }

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
                         * Returns an immutable instance of [OutputMessage].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .content()
                         * .role()
                         * .type()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): OutputMessage =
                            OutputMessage(
                                checkRequired("content", content),
                                checkRequired("role", role),
                                checkRequired("type", type),
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    fun validate(): OutputMessage = apply {
                        if (validated) {
                            return@apply
                        }

                        content().validate()
                        role().validate()
                        type().validate()
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
                        (content.asKnown().getOrNull()?.validity() ?: 0) +
                            (role.asKnown().getOrNull()?.validity() ?: 0) +
                            (type.asKnown().getOrNull()?.validity() ?: 0)

                    class Content
                    private constructor(
                        private val text: JsonField<String>,
                        private val type: JsonField<Type>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("text")
                            @ExcludeMissing
                            text: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("type")
                            @ExcludeMissing
                            type: JsonField<Type> = JsonMissing.of(),
                        ) : this(text, type, mutableMapOf())

                        /**
                         * The text content.
                         *
                         * @throws OpenAIInvalidDataException if the JSON field has an unexpected
                         *   type or is unexpectedly missing or null (e.g. if the server responded
                         *   with an unexpected value).
                         */
                        fun text(): String = text.getRequired("text")

                        /**
                         * The type of content, which is always `output_text`.
                         *
                         * @throws OpenAIInvalidDataException if the JSON field has an unexpected
                         *   type or is unexpectedly missing or null (e.g. if the server responded
                         *   with an unexpected value).
                         */
                        fun type(): Type = type.getRequired("type")

                        /**
                         * Returns the raw JSON value of [text].
                         *
                         * Unlike [text], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

                        /**
                         * Returns the raw JSON value of [type].
                         *
                         * Unlike [type], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

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
                             * .text()
                             * .type()
                             * ```
                             */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [Content]. */
                        class Builder internal constructor() {

                            private var text: JsonField<String>? = null
                            private var type: JsonField<Type>? = null
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(content: Content) = apply {
                                text = content.text
                                type = content.type
                                additionalProperties = content.additionalProperties.toMutableMap()
                            }

                            /** The text content. */
                            fun text(text: String) = text(JsonField.of(text))

                            /**
                             * Sets [Builder.text] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.text] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun text(text: JsonField<String>) = apply { this.text = text }

                            /** The type of content, which is always `output_text`. */
                            fun type(type: Type) = type(JsonField.of(type))

                            /**
                             * Sets [Builder.type] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.type] with a well-typed [Type] value
                             * instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun type(type: JsonField<Type>) = apply { this.type = type }

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
                             * .text()
                             * .type()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): Content =
                                Content(
                                    checkRequired("text", text),
                                    checkRequired("type", type),
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): Content = apply {
                            if (validated) {
                                return@apply
                            }

                            text()
                            type().validate()
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
                            (if (text.asKnown().isPresent) 1 else 0) +
                                (type.asKnown().getOrNull()?.validity() ?: 0)

                        /** The type of content, which is always `output_text`. */
                        class Type
                        @JsonCreator
                        private constructor(private val value: JsonField<String>) : Enum {

                            /**
                             * Returns this class instance's raw value.
                             *
                             * This is usually only useful if this instance was deserialized from
                             * data that doesn't match any known member, and you want to know that
                             * value. For example, if the SDK is on an older version than the API,
                             * then the API may respond with new members that the SDK is unaware of.
                             */
                            @com.fasterxml.jackson.annotation.JsonValue
                            fun _value(): JsonField<String> = value

                            companion object {

                                @JvmField val OUTPUT_TEXT = of("output_text")

                                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                            }

                            /** An enum containing [Type]'s known values. */
                            enum class Known {
                                OUTPUT_TEXT
                            }

                            /**
                             * An enum containing [Type]'s known values, as well as an [_UNKNOWN]
                             * member.
                             *
                             * An instance of [Type] can contain an unknown value in a couple of
                             * cases:
                             * - It was deserialized from data that doesn't match any known member.
                             *   For example, if the SDK is on an older version than the API, then
                             *   the API may respond with new members that the SDK is unaware of.
                             * - It was constructed with an arbitrary value using the [of] method.
                             */
                            enum class Value {
                                OUTPUT_TEXT,
                                /**
                                 * An enum member indicating that [Type] was instantiated with an
                                 * unknown value.
                                 */
                                _UNKNOWN,
                            }

                            /**
                             * Returns an enum member corresponding to this class instance's value,
                             * or [Value._UNKNOWN] if the class was instantiated with an unknown
                             * value.
                             *
                             * Use the [known] method instead if you're certain the value is always
                             * known or if you want to throw for the unknown case.
                             */
                            fun value(): Value =
                                when (this) {
                                    OUTPUT_TEXT -> Value.OUTPUT_TEXT
                                    else -> Value._UNKNOWN
                                }

                            /**
                             * Returns an enum member corresponding to this class instance's value.
                             *
                             * Use the [value] method instead if you're uncertain the value is
                             * always known and don't want to throw for the unknown case.
                             *
                             * @throws OpenAIInvalidDataException if this class instance's value is
                             *   a not a known member.
                             */
                            fun known(): Known =
                                when (this) {
                                    OUTPUT_TEXT -> Known.OUTPUT_TEXT
                                    else -> throw OpenAIInvalidDataException("Unknown Type: $value")
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
                            internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

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

                            return /* spotless:off */ other is Content && text == other.text && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                        }

                        /* spotless:off */
                        private val hashCode: Int by lazy { Objects.hash(text, type, additionalProperties) }
                        /* spotless:on */

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "Content{text=$text, type=$type, additionalProperties=$additionalProperties}"
                    }

                    /** The role of the message. Must be `assistant` for output. */
                    class Role
                    @JsonCreator
                    private constructor(private val value: JsonField<String>) : Enum {

                        /**
                         * Returns this class instance's raw value.
                         *
                         * This is usually only useful if this instance was deserialized from data
                         * that doesn't match any known member, and you want to know that value. For
                         * example, if the SDK is on an older version than the API, then the API may
                         * respond with new members that the SDK is unaware of.
                         */
                        @com.fasterxml.jackson.annotation.JsonValue
                        fun _value(): JsonField<String> = value

                        companion object {

                            @JvmField val ASSISTANT = of("assistant")

                            @JvmStatic fun of(value: String) = Role(JsonField.of(value))
                        }

                        /** An enum containing [Role]'s known values. */
                        enum class Known {
                            ASSISTANT
                        }

                        /**
                         * An enum containing [Role]'s known values, as well as an [_UNKNOWN]
                         * member.
                         *
                         * An instance of [Role] can contain an unknown value in a couple of cases:
                         * - It was deserialized from data that doesn't match any known member. For
                         *   example, if the SDK is on an older version than the API, then the API
                         *   may respond with new members that the SDK is unaware of.
                         * - It was constructed with an arbitrary value using the [of] method.
                         */
                        enum class Value {
                            ASSISTANT,
                            /**
                             * An enum member indicating that [Role] was instantiated with an
                             * unknown value.
                             */
                            _UNKNOWN,
                        }

                        /**
                         * Returns an enum member corresponding to this class instance's value, or
                         * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                         *
                         * Use the [known] method instead if you're certain the value is always
                         * known or if you want to throw for the unknown case.
                         */
                        fun value(): Value =
                            when (this) {
                                ASSISTANT -> Value.ASSISTANT
                                else -> Value._UNKNOWN
                            }

                        /**
                         * Returns an enum member corresponding to this class instance's value.
                         *
                         * Use the [value] method instead if you're uncertain the value is always
                         * known and don't want to throw for the unknown case.
                         *
                         * @throws OpenAIInvalidDataException if this class instance's value is a
                         *   not a known member.
                         */
                        fun known(): Known =
                            when (this) {
                                ASSISTANT -> Known.ASSISTANT
                                else -> throw OpenAIInvalidDataException("Unknown Role: $value")
                            }

                        /**
                         * Returns this class instance's primitive wire representation.
                         *
                         * This differs from the [toString] method because that method is primarily
                         * for debugging and generally doesn't throw.
                         *
                         * @throws OpenAIInvalidDataException if this class instance's value does
                         *   not have the expected primitive type.
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return /* spotless:off */ other is Role && value == other.value /* spotless:on */
                        }

                        override fun hashCode() = value.hashCode()

                        override fun toString() = value.toString()
                    }

                    /** The type of item, which is always `message`. */
                    class Type
                    @JsonCreator
                    private constructor(private val value: JsonField<String>) : Enum {

                        /**
                         * Returns this class instance's raw value.
                         *
                         * This is usually only useful if this instance was deserialized from data
                         * that doesn't match any known member, and you want to know that value. For
                         * example, if the SDK is on an older version than the API, then the API may
                         * respond with new members that the SDK is unaware of.
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
                         * An enum containing [Type]'s known values, as well as an [_UNKNOWN]
                         * member.
                         *
                         * An instance of [Type] can contain an unknown value in a couple of cases:
                         * - It was deserialized from data that doesn't match any known member. For
                         *   example, if the SDK is on an older version than the API, then the API
                         *   may respond with new members that the SDK is unaware of.
                         * - It was constructed with an arbitrary value using the [of] method.
                         */
                        enum class Value {
                            MESSAGE,
                            /**
                             * An enum member indicating that [Type] was instantiated with an
                             * unknown value.
                             */
                            _UNKNOWN,
                        }

                        /**
                         * Returns an enum member corresponding to this class instance's value, or
                         * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                         *
                         * Use the [known] method instead if you're certain the value is always
                         * known or if you want to throw for the unknown case.
                         */
                        fun value(): Value =
                            when (this) {
                                MESSAGE -> Value.MESSAGE
                                else -> Value._UNKNOWN
                            }

                        /**
                         * Returns an enum member corresponding to this class instance's value.
                         *
                         * Use the [value] method instead if you're uncertain the value is always
                         * known and don't want to throw for the unknown case.
                         *
                         * @throws OpenAIInvalidDataException if this class instance's value is a
                         *   not a known member.
                         */
                        fun known(): Known =
                            when (this) {
                                MESSAGE -> Known.MESSAGE
                                else -> throw OpenAIInvalidDataException("Unknown Type: $value")
                            }

                        /**
                         * Returns this class instance's primitive wire representation.
                         *
                         * This differs from the [toString] method because that method is primarily
                         * for debugging and generally doesn't throw.
                         *
                         * @throws OpenAIInvalidDataException if this class instance's value does
                         *   not have the expected primitive type.
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

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

                        return /* spotless:off */ other is OutputMessage && content == other.content && role == other.role && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                    }

                    /* spotless:off */
                    private val hashCode: Int by lazy { Objects.hash(content, role, type, additionalProperties) }
                    /* spotless:on */

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "OutputMessage{content=$content, role=$role, type=$type, additionalProperties=$additionalProperties}"
                }
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is LabelModel && input == other.input && labels == other.labels && model == other.model && name == other.name && passingLabels == other.passingLabels && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(input, labels, model, name, passingLabels, type, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "LabelModel{input=$input, labels=$labels, model=$model, name=$name, passingLabels=$passingLabels, type=$type, additionalProperties=$additionalProperties}"
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

        return /* spotless:off */ other is EvalCreateParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "EvalCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
