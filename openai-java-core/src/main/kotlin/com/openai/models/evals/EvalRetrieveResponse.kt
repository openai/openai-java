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
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.allMaxBy
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.graders.gradermodels.LabelModelGrader
import com.openai.models.graders.gradermodels.PythonGrader
import com.openai.models.graders.gradermodels.ScoreModelGrader
import com.openai.models.graders.gradermodels.StringCheckGrader
import com.openai.models.graders.gradermodels.TextSimilarityGrader
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * An Eval object with a data source config and testing criteria. An Eval represents a task to be
 * done for your LLM integration. Like:
 * - Improve the quality of my chatbot
 * - See how well my chatbot handles customer support
 * - Check if o4-mini is better at my usecase than gpt-4o
 */
class EvalRetrieveResponse
private constructor(
    private val id: JsonField<String>,
    private val createdAt: JsonField<Long>,
    private val dataSourceConfig: JsonField<DataSourceConfig>,
    private val metadata: JsonField<Metadata>,
    private val name: JsonField<String>,
    private val object_: JsonValue,
    private val testingCriteria: JsonField<List<TestingCriterion>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("created_at") @ExcludeMissing createdAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("data_source_config")
        @ExcludeMissing
        dataSourceConfig: JsonField<DataSourceConfig> = JsonMissing.of(),
        @JsonProperty("metadata") @ExcludeMissing metadata: JsonField<Metadata> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("testing_criteria")
        @ExcludeMissing
        testingCriteria: JsonField<List<TestingCriterion>> = JsonMissing.of(),
    ) : this(
        id,
        createdAt,
        dataSourceConfig,
        metadata,
        name,
        object_,
        testingCriteria,
        mutableMapOf(),
    )

    /**
     * Unique identifier for the evaluation.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The Unix timestamp (in seconds) for when the eval was created.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /**
     * Configuration of data sources used in runs of the evaluation.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun dataSourceConfig(): DataSourceConfig = dataSourceConfig.getRequired("data_source_config")

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
    fun metadata(): Optional<Metadata> = metadata.getOptional("metadata")

    /**
     * The name of the evaluation.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = name.getRequired("name")

    /**
     * The object type.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("eval")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * A list of testing criteria.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun testingCriteria(): List<TestingCriterion> = testingCriteria.getRequired("testing_criteria")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt(): JsonField<Long> = createdAt

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
     * Returns the raw JSON value of [testingCriteria].
     *
     * Unlike [testingCriteria], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("testing_criteria")
    @ExcludeMissing
    fun _testingCriteria(): JsonField<List<TestingCriterion>> = testingCriteria

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
         * Returns a mutable builder for constructing an instance of [EvalRetrieveResponse].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .dataSourceConfig()
         * .metadata()
         * .name()
         * .testingCriteria()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [EvalRetrieveResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var createdAt: JsonField<Long>? = null
        private var dataSourceConfig: JsonField<DataSourceConfig>? = null
        private var metadata: JsonField<Metadata>? = null
        private var name: JsonField<String>? = null
        private var object_: JsonValue = JsonValue.from("eval")
        private var testingCriteria: JsonField<MutableList<TestingCriterion>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(evalRetrieveResponse: EvalRetrieveResponse) = apply {
            id = evalRetrieveResponse.id
            createdAt = evalRetrieveResponse.createdAt
            dataSourceConfig = evalRetrieveResponse.dataSourceConfig
            metadata = evalRetrieveResponse.metadata
            name = evalRetrieveResponse.name
            object_ = evalRetrieveResponse.object_
            testingCriteria = evalRetrieveResponse.testingCriteria.map { it.toMutableList() }
            additionalProperties = evalRetrieveResponse.additionalProperties.toMutableMap()
        }

        /** Unique identifier for the evaluation. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The Unix timestamp (in seconds) for when the eval was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /** Configuration of data sources used in runs of the evaluation. */
        fun dataSourceConfig(dataSourceConfig: DataSourceConfig) =
            dataSourceConfig(JsonField.of(dataSourceConfig))

        /**
         * Sets [Builder.dataSourceConfig] to an arbitrary JSON value.
         *
         * You should usually call [Builder.dataSourceConfig] with a well-typed [DataSourceConfig]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun dataSourceConfig(dataSourceConfig: JsonField<DataSourceConfig>) = apply {
            this.dataSourceConfig = dataSourceConfig
        }

        /** Alias for calling [dataSourceConfig] with `DataSourceConfig.ofCustom(custom)`. */
        fun dataSourceConfig(custom: EvalCustomDataSourceConfig) =
            dataSourceConfig(DataSourceConfig.ofCustom(custom))

        /**
         * Alias for calling [dataSourceConfig] with the following:
         * ```java
         * EvalCustomDataSourceConfig.builder()
         *     .schema(schema)
         *     .build()
         * ```
         */
        fun customDataSourceConfig(schema: EvalCustomDataSourceConfig.Schema) =
            dataSourceConfig(EvalCustomDataSourceConfig.builder().schema(schema).build())

        /** Alias for calling [dataSourceConfig] with `DataSourceConfig.ofLogs(logs)`. */
        fun dataSourceConfig(logs: DataSourceConfig.Logs) =
            dataSourceConfig(DataSourceConfig.ofLogs(logs))

        /**
         * Alias for calling [dataSourceConfig] with the following:
         * ```java
         * DataSourceConfig.Logs.builder()
         *     .schema(schema)
         *     .build()
         * ```
         */
        fun logsDataSourceConfig(schema: DataSourceConfig.Logs.Schema) =
            dataSourceConfig(DataSourceConfig.Logs.builder().schema(schema).build())

        /**
         * Alias for calling [dataSourceConfig] with
         * `DataSourceConfig.ofStoredCompletions(storedCompletions)`.
         */
        @Deprecated("deprecated")
        fun dataSourceConfig(storedCompletions: EvalStoredCompletionsDataSourceConfig) =
            dataSourceConfig(DataSourceConfig.ofStoredCompletions(storedCompletions))

        /**
         * Alias for calling [dataSourceConfig] with the following:
         * ```java
         * EvalStoredCompletionsDataSourceConfig.builder()
         *     .schema(schema)
         *     .build()
         * ```
         */
        @Deprecated("deprecated")
        fun storedCompletionsDataSourceConfig(
            schema: EvalStoredCompletionsDataSourceConfig.Schema
        ) = dataSourceConfig(EvalStoredCompletionsDataSourceConfig.builder().schema(schema).build())

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format, and querying for
         * objects via API or the dashboard.
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
         * You should usually call [Builder.metadata] with a well-typed [Metadata] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

        /** The name of the evaluation. */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("eval")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /** A list of testing criteria. */
        fun testingCriteria(testingCriteria: List<TestingCriterion>) =
            testingCriteria(JsonField.of(testingCriteria))

        /**
         * Sets [Builder.testingCriteria] to an arbitrary JSON value.
         *
         * You should usually call [Builder.testingCriteria] with a well-typed
         * `List<TestingCriterion>` value instead. This method is primarily for setting the field to
         * an undocumented or not yet supported value.
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
         * `TestingCriterion.ofLabelModelGrader(labelModelGrader)`.
         */
        fun addTestingCriterion(labelModelGrader: LabelModelGrader) =
            addTestingCriterion(TestingCriterion.ofLabelModelGrader(labelModelGrader))

        /**
         * Alias for calling [addTestingCriterion] with
         * `TestingCriterion.ofStringCheckGrader(stringCheckGrader)`.
         */
        fun addTestingCriterion(stringCheckGrader: StringCheckGrader) =
            addTestingCriterion(TestingCriterion.ofStringCheckGrader(stringCheckGrader))

        /**
         * Alias for calling [addTestingCriterion] with
         * `TestingCriterion.ofEvalGraderTextSimilarity(evalGraderTextSimilarity)`.
         */
        fun addTestingCriterion(
            evalGraderTextSimilarity: TestingCriterion.EvalGraderTextSimilarity
        ) =
            addTestingCriterion(
                TestingCriterion.ofEvalGraderTextSimilarity(evalGraderTextSimilarity)
            )

        /**
         * Alias for calling [addTestingCriterion] with
         * `TestingCriterion.ofEvalGraderPython(evalGraderPython)`.
         */
        fun addTestingCriterion(evalGraderPython: TestingCriterion.EvalGraderPython) =
            addTestingCriterion(TestingCriterion.ofEvalGraderPython(evalGraderPython))

        /**
         * Alias for calling [addTestingCriterion] with
         * `TestingCriterion.ofEvalGraderScoreModel(evalGraderScoreModel)`.
         */
        fun addTestingCriterion(evalGraderScoreModel: TestingCriterion.EvalGraderScoreModel) =
            addTestingCriterion(TestingCriterion.ofEvalGraderScoreModel(evalGraderScoreModel))

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
         * Returns an immutable instance of [EvalRetrieveResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .dataSourceConfig()
         * .metadata()
         * .name()
         * .testingCriteria()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): EvalRetrieveResponse =
            EvalRetrieveResponse(
                checkRequired("id", id),
                checkRequired("createdAt", createdAt),
                checkRequired("dataSourceConfig", dataSourceConfig),
                checkRequired("metadata", metadata),
                checkRequired("name", name),
                object_,
                checkRequired("testingCriteria", testingCriteria).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): EvalRetrieveResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        createdAt()
        dataSourceConfig().validate()
        metadata().ifPresent { it.validate() }
        name()
        _object_().let {
            if (it != JsonValue.from("eval")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        testingCriteria().forEach { it.validate() }
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (dataSourceConfig.asKnown().getOrNull()?.validity() ?: 0) +
            (metadata.asKnown().getOrNull()?.validity() ?: 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            object_.let { if (it == JsonValue.from("eval")) 1 else 0 } +
            (testingCriteria.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    /** Configuration of data sources used in runs of the evaluation. */
    @JsonDeserialize(using = DataSourceConfig.Deserializer::class)
    @JsonSerialize(using = DataSourceConfig.Serializer::class)
    class DataSourceConfig
    private constructor(
        private val custom: EvalCustomDataSourceConfig? = null,
        private val logs: Logs? = null,
        private val storedCompletions: EvalStoredCompletionsDataSourceConfig? = null,
        private val _json: JsonValue? = null,
    ) {

        /**
         * A CustomDataSourceConfig which specifies the schema of your `item` and optionally
         * `sample` namespaces. The response schema defines the shape of the data that will be:
         * - Used to define your testing criteria and
         * - What data is required when creating a run
         */
        fun custom(): Optional<EvalCustomDataSourceConfig> = Optional.ofNullable(custom)

        /**
         * A LogsDataSourceConfig which specifies the metadata property of your logs query. This is
         * usually metadata like `usecase=chatbot` or `prompt-version=v2`, etc. The schema returned
         * by this data source config is used to defined what variables are available in your evals.
         * `item` and `sample` are both defined when using this data source config.
         */
        fun logs(): Optional<Logs> = Optional.ofNullable(logs)

        /** Deprecated in favor of LogsDataSourceConfig. */
        @Deprecated("deprecated")
        fun storedCompletions(): Optional<EvalStoredCompletionsDataSourceConfig> =
            Optional.ofNullable(storedCompletions)

        fun isCustom(): Boolean = custom != null

        fun isLogs(): Boolean = logs != null

        @Deprecated("deprecated") fun isStoredCompletions(): Boolean = storedCompletions != null

        /**
         * A CustomDataSourceConfig which specifies the schema of your `item` and optionally
         * `sample` namespaces. The response schema defines the shape of the data that will be:
         * - Used to define your testing criteria and
         * - What data is required when creating a run
         */
        fun asCustom(): EvalCustomDataSourceConfig = custom.getOrThrow("custom")

        /**
         * A LogsDataSourceConfig which specifies the metadata property of your logs query. This is
         * usually metadata like `usecase=chatbot` or `prompt-version=v2`, etc. The schema returned
         * by this data source config is used to defined what variables are available in your evals.
         * `item` and `sample` are both defined when using this data source config.
         */
        fun asLogs(): Logs = logs.getOrThrow("logs")

        /** Deprecated in favor of LogsDataSourceConfig. */
        @Deprecated("deprecated")
        fun asStoredCompletions(): EvalStoredCompletionsDataSourceConfig =
            storedCompletions.getOrThrow("storedCompletions")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                custom != null -> visitor.visitCustom(custom)
                logs != null -> visitor.visitLogs(logs)
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
                    override fun visitCustom(custom: EvalCustomDataSourceConfig) {
                        custom.validate()
                    }

                    override fun visitLogs(logs: Logs) {
                        logs.validate()
                    }

                    override fun visitStoredCompletions(
                        storedCompletions: EvalStoredCompletionsDataSourceConfig
                    ) {
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
                    override fun visitCustom(custom: EvalCustomDataSourceConfig) = custom.validity()

                    override fun visitLogs(logs: Logs) = logs.validity()

                    override fun visitStoredCompletions(
                        storedCompletions: EvalStoredCompletionsDataSourceConfig
                    ) = storedCompletions.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is DataSourceConfig &&
                custom == other.custom &&
                logs == other.logs &&
                storedCompletions == other.storedCompletions
        }

        override fun hashCode(): Int = Objects.hash(custom, logs, storedCompletions)

        override fun toString(): String =
            when {
                custom != null -> "DataSourceConfig{custom=$custom}"
                logs != null -> "DataSourceConfig{logs=$logs}"
                storedCompletions != null ->
                    "DataSourceConfig{storedCompletions=$storedCompletions}"
                _json != null -> "DataSourceConfig{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid DataSourceConfig")
            }

        companion object {

            /**
             * A CustomDataSourceConfig which specifies the schema of your `item` and optionally
             * `sample` namespaces. The response schema defines the shape of the data that will be:
             * - Used to define your testing criteria and
             * - What data is required when creating a run
             */
            @JvmStatic
            fun ofCustom(custom: EvalCustomDataSourceConfig) = DataSourceConfig(custom = custom)

            /**
             * A LogsDataSourceConfig which specifies the metadata property of your logs query. This
             * is usually metadata like `usecase=chatbot` or `prompt-version=v2`, etc. The schema
             * returned by this data source config is used to defined what variables are available
             * in your evals. `item` and `sample` are both defined when using this data source
             * config.
             */
            @JvmStatic fun ofLogs(logs: Logs) = DataSourceConfig(logs = logs)

            /** Deprecated in favor of LogsDataSourceConfig. */
            @Deprecated("deprecated")
            @JvmStatic
            fun ofStoredCompletions(storedCompletions: EvalStoredCompletionsDataSourceConfig) =
                DataSourceConfig(storedCompletions = storedCompletions)
        }

        /**
         * An interface that defines how to map each variant of [DataSourceConfig] to a value of
         * type [T].
         */
        interface Visitor<out T> {

            /**
             * A CustomDataSourceConfig which specifies the schema of your `item` and optionally
             * `sample` namespaces. The response schema defines the shape of the data that will be:
             * - Used to define your testing criteria and
             * - What data is required when creating a run
             */
            fun visitCustom(custom: EvalCustomDataSourceConfig): T

            /**
             * A LogsDataSourceConfig which specifies the metadata property of your logs query. This
             * is usually metadata like `usecase=chatbot` or `prompt-version=v2`, etc. The schema
             * returned by this data source config is used to defined what variables are available
             * in your evals. `item` and `sample` are both defined when using this data source
             * config.
             */
            fun visitLogs(logs: Logs): T

            /** Deprecated in favor of LogsDataSourceConfig. */
            @Deprecated("deprecated")
            fun visitStoredCompletions(storedCompletions: EvalStoredCompletionsDataSourceConfig): T

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
                        return tryDeserialize(node, jacksonTypeRef<EvalCustomDataSourceConfig>())
                            ?.let { DataSourceConfig(custom = it, _json = json) }
                            ?: DataSourceConfig(_json = json)
                    }
                    "logs" -> {
                        return tryDeserialize(node, jacksonTypeRef<Logs>())?.let {
                            DataSourceConfig(logs = it, _json = json)
                        } ?: DataSourceConfig(_json = json)
                    }
                    "stored_completions" -> {
                        return tryDeserialize(
                                node,
                                jacksonTypeRef<EvalStoredCompletionsDataSourceConfig>(),
                            )
                            ?.let { DataSourceConfig(storedCompletions = it, _json = json) }
                            ?: DataSourceConfig(_json = json)
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
                    value.logs != null -> generator.writeObject(value.logs)
                    value.storedCompletions != null ->
                        generator.writeObject(value.storedCompletions)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid DataSourceConfig")
                }
            }
        }

        /**
         * A LogsDataSourceConfig which specifies the metadata property of your logs query. This is
         * usually metadata like `usecase=chatbot` or `prompt-version=v2`, etc. The schema returned
         * by this data source config is used to defined what variables are available in your evals.
         * `item` and `sample` are both defined when using this data source config.
         */
        class Logs
        private constructor(
            private val schema: JsonField<Schema>,
            private val type: JsonValue,
            private val metadata: JsonField<Metadata>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("schema")
                @ExcludeMissing
                schema: JsonField<Schema> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                @JsonProperty("metadata")
                @ExcludeMissing
                metadata: JsonField<Metadata> = JsonMissing.of(),
            ) : this(schema, type, metadata, mutableMapOf())

            /**
             * The json schema for the run data source items. Learn how to build JSON schemas
             * [here](https://json-schema.org/).
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun schema(): Schema = schema.getRequired("schema")

            /**
             * The type of data source. Always `logs`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("logs")
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
             * Returns the raw JSON value of [schema].
             *
             * Unlike [schema], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("schema") @ExcludeMissing fun _schema(): JsonField<Schema> = schema

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
                 * Returns a mutable builder for constructing an instance of [Logs].
                 *
                 * The following fields are required:
                 * ```java
                 * .schema()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Logs]. */
            class Builder internal constructor() {

                private var schema: JsonField<Schema>? = null
                private var type: JsonValue = JsonValue.from("logs")
                private var metadata: JsonField<Metadata> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(logs: Logs) = apply {
                    schema = logs.schema
                    type = logs.type
                    metadata = logs.metadata
                    additionalProperties = logs.additionalProperties.toMutableMap()
                }

                /**
                 * The json schema for the run data source items. Learn how to build JSON schemas
                 * [here](https://json-schema.org/).
                 */
                fun schema(schema: Schema) = schema(JsonField.of(schema))

                /**
                 * Sets [Builder.schema] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.schema] with a well-typed [Schema] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun schema(schema: JsonField<Schema>) = apply { this.schema = schema }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("logs")
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
                 * Returns an immutable instance of [Logs].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .schema()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Logs =
                    Logs(
                        checkRequired("schema", schema),
                        type,
                        metadata,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Logs = apply {
                if (validated) {
                    return@apply
                }

                schema().validate()
                _type().let {
                    if (it != JsonValue.from("logs")) {
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
                (schema.asKnown().getOrNull()?.validity() ?: 0) +
                    type.let { if (it == JsonValue.from("logs")) 1 else 0 } +
                    (metadata.asKnown().getOrNull()?.validity() ?: 0)

            /**
             * The json schema for the run data source items. Learn how to build JSON schemas
             * [here](https://json-schema.org/).
             */
            class Schema
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

                    /** Returns a mutable builder for constructing an instance of [Schema]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Schema]. */
                class Builder internal constructor() {

                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(schema: Schema) = apply {
                        additionalProperties = schema.additionalProperties.toMutableMap()
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
                     * Returns an immutable instance of [Schema].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Schema = Schema(additionalProperties.toImmutable())
                }

                private var validated: Boolean = false

                fun validate(): Schema = apply {
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

                    return other is Schema && additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() = "Schema{additionalProperties=$additionalProperties}"
            }

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

                    return other is Metadata && additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() = "Metadata{additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Logs &&
                    schema == other.schema &&
                    type == other.type &&
                    metadata == other.metadata &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(schema, type, metadata, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Logs{schema=$schema, type=$type, metadata=$metadata, additionalProperties=$additionalProperties}"
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

            return other is Metadata && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "Metadata{additionalProperties=$additionalProperties}"
    }

    /**
     * A LabelModelGrader object which uses a model to assign labels to each item in the evaluation.
     */
    @JsonDeserialize(using = TestingCriterion.Deserializer::class)
    @JsonSerialize(using = TestingCriterion.Serializer::class)
    class TestingCriterion
    private constructor(
        private val labelModelGrader: LabelModelGrader? = null,
        private val stringCheckGrader: StringCheckGrader? = null,
        private val evalGraderTextSimilarity: EvalGraderTextSimilarity? = null,
        private val evalGraderPython: EvalGraderPython? = null,
        private val evalGraderScoreModel: EvalGraderScoreModel? = null,
        private val _json: JsonValue? = null,
    ) {

        /**
         * A LabelModelGrader object which uses a model to assign labels to each item in the
         * evaluation.
         */
        fun labelModelGrader(): Optional<LabelModelGrader> = Optional.ofNullable(labelModelGrader)

        /**
         * A StringCheckGrader object that performs a string comparison between input and reference
         * using a specified operation.
         */
        fun stringCheckGrader(): Optional<StringCheckGrader> =
            Optional.ofNullable(stringCheckGrader)

        /** A TextSimilarityGrader object which grades text based on similarity metrics. */
        fun evalGraderTextSimilarity(): Optional<EvalGraderTextSimilarity> =
            Optional.ofNullable(evalGraderTextSimilarity)

        /** A PythonGrader object that runs a python script on the input. */
        fun evalGraderPython(): Optional<EvalGraderPython> = Optional.ofNullable(evalGraderPython)

        /** A ScoreModelGrader object that uses a model to assign a score to the input. */
        fun evalGraderScoreModel(): Optional<EvalGraderScoreModel> =
            Optional.ofNullable(evalGraderScoreModel)

        fun isLabelModelGrader(): Boolean = labelModelGrader != null

        fun isStringCheckGrader(): Boolean = stringCheckGrader != null

        fun isEvalGraderTextSimilarity(): Boolean = evalGraderTextSimilarity != null

        fun isEvalGraderPython(): Boolean = evalGraderPython != null

        fun isEvalGraderScoreModel(): Boolean = evalGraderScoreModel != null

        /**
         * A LabelModelGrader object which uses a model to assign labels to each item in the
         * evaluation.
         */
        fun asLabelModelGrader(): LabelModelGrader = labelModelGrader.getOrThrow("labelModelGrader")

        /**
         * A StringCheckGrader object that performs a string comparison between input and reference
         * using a specified operation.
         */
        fun asStringCheckGrader(): StringCheckGrader =
            stringCheckGrader.getOrThrow("stringCheckGrader")

        /** A TextSimilarityGrader object which grades text based on similarity metrics. */
        fun asEvalGraderTextSimilarity(): EvalGraderTextSimilarity =
            evalGraderTextSimilarity.getOrThrow("evalGraderTextSimilarity")

        /** A PythonGrader object that runs a python script on the input. */
        fun asEvalGraderPython(): EvalGraderPython = evalGraderPython.getOrThrow("evalGraderPython")

        /** A ScoreModelGrader object that uses a model to assign a score to the input. */
        fun asEvalGraderScoreModel(): EvalGraderScoreModel =
            evalGraderScoreModel.getOrThrow("evalGraderScoreModel")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                labelModelGrader != null -> visitor.visitLabelModelGrader(labelModelGrader)
                stringCheckGrader != null -> visitor.visitStringCheckGrader(stringCheckGrader)
                evalGraderTextSimilarity != null ->
                    visitor.visitEvalGraderTextSimilarity(evalGraderTextSimilarity)
                evalGraderPython != null -> visitor.visitEvalGraderPython(evalGraderPython)
                evalGraderScoreModel != null ->
                    visitor.visitEvalGraderScoreModel(evalGraderScoreModel)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): TestingCriterion = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitLabelModelGrader(labelModelGrader: LabelModelGrader) {
                        labelModelGrader.validate()
                    }

                    override fun visitStringCheckGrader(stringCheckGrader: StringCheckGrader) {
                        stringCheckGrader.validate()
                    }

                    override fun visitEvalGraderTextSimilarity(
                        evalGraderTextSimilarity: EvalGraderTextSimilarity
                    ) {
                        evalGraderTextSimilarity.validate()
                    }

                    override fun visitEvalGraderPython(evalGraderPython: EvalGraderPython) {
                        evalGraderPython.validate()
                    }

                    override fun visitEvalGraderScoreModel(
                        evalGraderScoreModel: EvalGraderScoreModel
                    ) {
                        evalGraderScoreModel.validate()
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
                    override fun visitLabelModelGrader(labelModelGrader: LabelModelGrader) =
                        labelModelGrader.validity()

                    override fun visitStringCheckGrader(stringCheckGrader: StringCheckGrader) =
                        stringCheckGrader.validity()

                    override fun visitEvalGraderTextSimilarity(
                        evalGraderTextSimilarity: EvalGraderTextSimilarity
                    ) = evalGraderTextSimilarity.validity()

                    override fun visitEvalGraderPython(evalGraderPython: EvalGraderPython) =
                        evalGraderPython.validity()

                    override fun visitEvalGraderScoreModel(
                        evalGraderScoreModel: EvalGraderScoreModel
                    ) = evalGraderScoreModel.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is TestingCriterion &&
                labelModelGrader == other.labelModelGrader &&
                stringCheckGrader == other.stringCheckGrader &&
                evalGraderTextSimilarity == other.evalGraderTextSimilarity &&
                evalGraderPython == other.evalGraderPython &&
                evalGraderScoreModel == other.evalGraderScoreModel
        }

        override fun hashCode(): Int =
            Objects.hash(
                labelModelGrader,
                stringCheckGrader,
                evalGraderTextSimilarity,
                evalGraderPython,
                evalGraderScoreModel,
            )

        override fun toString(): String =
            when {
                labelModelGrader != null -> "TestingCriterion{labelModelGrader=$labelModelGrader}"
                stringCheckGrader != null ->
                    "TestingCriterion{stringCheckGrader=$stringCheckGrader}"
                evalGraderTextSimilarity != null ->
                    "TestingCriterion{evalGraderTextSimilarity=$evalGraderTextSimilarity}"
                evalGraderPython != null -> "TestingCriterion{evalGraderPython=$evalGraderPython}"
                evalGraderScoreModel != null ->
                    "TestingCriterion{evalGraderScoreModel=$evalGraderScoreModel}"
                _json != null -> "TestingCriterion{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid TestingCriterion")
            }

        companion object {

            /**
             * A LabelModelGrader object which uses a model to assign labels to each item in the
             * evaluation.
             */
            @JvmStatic
            fun ofLabelModelGrader(labelModelGrader: LabelModelGrader) =
                TestingCriterion(labelModelGrader = labelModelGrader)

            /**
             * A StringCheckGrader object that performs a string comparison between input and
             * reference using a specified operation.
             */
            @JvmStatic
            fun ofStringCheckGrader(stringCheckGrader: StringCheckGrader) =
                TestingCriterion(stringCheckGrader = stringCheckGrader)

            /** A TextSimilarityGrader object which grades text based on similarity metrics. */
            @JvmStatic
            fun ofEvalGraderTextSimilarity(evalGraderTextSimilarity: EvalGraderTextSimilarity) =
                TestingCriterion(evalGraderTextSimilarity = evalGraderTextSimilarity)

            /** A PythonGrader object that runs a python script on the input. */
            @JvmStatic
            fun ofEvalGraderPython(evalGraderPython: EvalGraderPython) =
                TestingCriterion(evalGraderPython = evalGraderPython)

            /** A ScoreModelGrader object that uses a model to assign a score to the input. */
            @JvmStatic
            fun ofEvalGraderScoreModel(evalGraderScoreModel: EvalGraderScoreModel) =
                TestingCriterion(evalGraderScoreModel = evalGraderScoreModel)
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
            fun visitLabelModelGrader(labelModelGrader: LabelModelGrader): T

            /**
             * A StringCheckGrader object that performs a string comparison between input and
             * reference using a specified operation.
             */
            fun visitStringCheckGrader(stringCheckGrader: StringCheckGrader): T

            /** A TextSimilarityGrader object which grades text based on similarity metrics. */
            fun visitEvalGraderTextSimilarity(evalGraderTextSimilarity: EvalGraderTextSimilarity): T

            /** A PythonGrader object that runs a python script on the input. */
            fun visitEvalGraderPython(evalGraderPython: EvalGraderPython): T

            /** A ScoreModelGrader object that uses a model to assign a score to the input. */
            fun visitEvalGraderScoreModel(evalGraderScoreModel: EvalGraderScoreModel): T

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

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<LabelModelGrader>())?.let {
                                TestingCriterion(labelModelGrader = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<StringCheckGrader>())?.let {
                                TestingCriterion(stringCheckGrader = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<EvalGraderTextSimilarity>())?.let {
                                TestingCriterion(evalGraderTextSimilarity = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<EvalGraderPython>())?.let {
                                TestingCriterion(evalGraderPython = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<EvalGraderScoreModel>())?.let {
                                TestingCriterion(evalGraderScoreModel = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> TestingCriterion(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<TestingCriterion>(TestingCriterion::class) {

            override fun serialize(
                value: TestingCriterion,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.labelModelGrader != null -> generator.writeObject(value.labelModelGrader)
                    value.stringCheckGrader != null ->
                        generator.writeObject(value.stringCheckGrader)
                    value.evalGraderTextSimilarity != null ->
                        generator.writeObject(value.evalGraderTextSimilarity)
                    value.evalGraderPython != null -> generator.writeObject(value.evalGraderPython)
                    value.evalGraderScoreModel != null ->
                        generator.writeObject(value.evalGraderScoreModel)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid TestingCriterion")
                }
            }
        }

        /** A TextSimilarityGrader object which grades text based on similarity metrics. */
        class EvalGraderTextSimilarity
        private constructor(
            private val evaluationMetric: JsonField<TextSimilarityGrader.EvaluationMetric>,
            private val input: JsonField<String>,
            private val name: JsonField<String>,
            private val reference: JsonField<String>,
            private val type: JsonValue,
            private val passThreshold: JsonField<Double>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("evaluation_metric")
                @ExcludeMissing
                evaluationMetric: JsonField<TextSimilarityGrader.EvaluationMetric> =
                    JsonMissing.of(),
                @JsonProperty("input") @ExcludeMissing input: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("reference")
                @ExcludeMissing
                reference: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                @JsonProperty("pass_threshold")
                @ExcludeMissing
                passThreshold: JsonField<Double> = JsonMissing.of(),
            ) : this(evaluationMetric, input, name, reference, type, passThreshold, mutableMapOf())

            fun toTextSimilarityGrader(): TextSimilarityGrader =
                TextSimilarityGrader.builder()
                    .evaluationMetric(evaluationMetric)
                    .input(input)
                    .name(name)
                    .reference(reference)
                    .type(type)
                    .build()

            /**
             * The evaluation metric to use. One of `cosine`, `fuzzy_match`, `bleu`, `gleu`,
             * `meteor`, `rouge_1`, `rouge_2`, `rouge_3`, `rouge_4`, `rouge_5`, or `rouge_l`.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun evaluationMetric(): TextSimilarityGrader.EvaluationMetric =
                evaluationMetric.getRequired("evaluation_metric")

            /**
             * The text being graded.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun input(): String = input.getRequired("input")

            /**
             * The name of the grader.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * The text being graded against.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun reference(): String = reference.getRequired("reference")

            /**
             * The type of grader.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("text_similarity")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * The threshold for the score.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun passThreshold(): Double = passThreshold.getRequired("pass_threshold")

            /**
             * Returns the raw JSON value of [evaluationMetric].
             *
             * Unlike [evaluationMetric], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("evaluation_metric")
            @ExcludeMissing
            fun _evaluationMetric(): JsonField<TextSimilarityGrader.EvaluationMetric> =
                evaluationMetric

            /**
             * Returns the raw JSON value of [input].
             *
             * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("input") @ExcludeMissing fun _input(): JsonField<String> = input

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [reference].
             *
             * Unlike [reference], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("reference")
            @ExcludeMissing
            fun _reference(): JsonField<String> = reference

            /**
             * Returns the raw JSON value of [passThreshold].
             *
             * Unlike [passThreshold], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("pass_threshold")
            @ExcludeMissing
            fun _passThreshold(): JsonField<Double> = passThreshold

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
                 * [EvalGraderTextSimilarity].
                 *
                 * The following fields are required:
                 * ```java
                 * .evaluationMetric()
                 * .input()
                 * .name()
                 * .reference()
                 * .passThreshold()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [EvalGraderTextSimilarity]. */
            class Builder internal constructor() {

                private var evaluationMetric: JsonField<TextSimilarityGrader.EvaluationMetric>? =
                    null
                private var input: JsonField<String>? = null
                private var name: JsonField<String>? = null
                private var reference: JsonField<String>? = null
                private var type: JsonValue = JsonValue.from("text_similarity")
                private var passThreshold: JsonField<Double>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(evalGraderTextSimilarity: EvalGraderTextSimilarity) = apply {
                    evaluationMetric = evalGraderTextSimilarity.evaluationMetric
                    input = evalGraderTextSimilarity.input
                    name = evalGraderTextSimilarity.name
                    reference = evalGraderTextSimilarity.reference
                    type = evalGraderTextSimilarity.type
                    passThreshold = evalGraderTextSimilarity.passThreshold
                    additionalProperties =
                        evalGraderTextSimilarity.additionalProperties.toMutableMap()
                }

                /**
                 * The evaluation metric to use. One of `cosine`, `fuzzy_match`, `bleu`, `gleu`,
                 * `meteor`, `rouge_1`, `rouge_2`, `rouge_3`, `rouge_4`, `rouge_5`, or `rouge_l`.
                 */
                fun evaluationMetric(evaluationMetric: TextSimilarityGrader.EvaluationMetric) =
                    evaluationMetric(JsonField.of(evaluationMetric))

                /**
                 * Sets [Builder.evaluationMetric] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.evaluationMetric] with a well-typed
                 * [TextSimilarityGrader.EvaluationMetric] value instead. This method is primarily
                 * for setting the field to an undocumented or not yet supported value.
                 */
                fun evaluationMetric(
                    evaluationMetric: JsonField<TextSimilarityGrader.EvaluationMetric>
                ) = apply { this.evaluationMetric = evaluationMetric }

                /** The text being graded. */
                fun input(input: String) = input(JsonField.of(input))

                /**
                 * Sets [Builder.input] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.input] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun input(input: JsonField<String>) = apply { this.input = input }

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

                /** The text being graded against. */
                fun reference(reference: String) = reference(JsonField.of(reference))

                /**
                 * Sets [Builder.reference] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.reference] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun reference(reference: JsonField<String>) = apply { this.reference = reference }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("text_similarity")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                /** The threshold for the score. */
                fun passThreshold(passThreshold: Double) =
                    passThreshold(JsonField.of(passThreshold))

                /**
                 * Sets [Builder.passThreshold] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.passThreshold] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun passThreshold(passThreshold: JsonField<Double>) = apply {
                    this.passThreshold = passThreshold
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
                 * Returns an immutable instance of [EvalGraderTextSimilarity].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .evaluationMetric()
                 * .input()
                 * .name()
                 * .reference()
                 * .passThreshold()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): EvalGraderTextSimilarity =
                    EvalGraderTextSimilarity(
                        checkRequired("evaluationMetric", evaluationMetric),
                        checkRequired("input", input),
                        checkRequired("name", name),
                        checkRequired("reference", reference),
                        type,
                        checkRequired("passThreshold", passThreshold),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): EvalGraderTextSimilarity = apply {
                if (validated) {
                    return@apply
                }

                evaluationMetric().validate()
                input()
                name()
                reference()
                _type().let {
                    if (it != JsonValue.from("text_similarity")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                passThreshold()
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
                (evaluationMetric.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (input.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0) +
                    (if (reference.asKnown().isPresent) 1 else 0) +
                    type.let { if (it == JsonValue.from("text_similarity")) 1 else 0 } +
                    (if (passThreshold.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is EvalGraderTextSimilarity &&
                    evaluationMetric == other.evaluationMetric &&
                    input == other.input &&
                    name == other.name &&
                    reference == other.reference &&
                    type == other.type &&
                    passThreshold == other.passThreshold &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    evaluationMetric,
                    input,
                    name,
                    reference,
                    type,
                    passThreshold,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "EvalGraderTextSimilarity{evaluationMetric=$evaluationMetric, input=$input, name=$name, reference=$reference, type=$type, passThreshold=$passThreshold, additionalProperties=$additionalProperties}"
        }

        /** A PythonGrader object that runs a python script on the input. */
        class EvalGraderPython
        private constructor(
            private val name: JsonField<String>,
            private val source: JsonField<String>,
            private val type: JsonValue,
            private val imageTag: JsonField<String>,
            private val passThreshold: JsonField<Double>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("source")
                @ExcludeMissing
                source: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                @JsonProperty("image_tag")
                @ExcludeMissing
                imageTag: JsonField<String> = JsonMissing.of(),
                @JsonProperty("pass_threshold")
                @ExcludeMissing
                passThreshold: JsonField<Double> = JsonMissing.of(),
            ) : this(name, source, type, imageTag, passThreshold, mutableMapOf())

            fun toPythonGrader(): PythonGrader =
                PythonGrader.builder()
                    .name(name)
                    .source(source)
                    .type(type)
                    .imageTag(imageTag)
                    .build()

            /**
             * The name of the grader.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * The source code of the python script.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun source(): String = source.getRequired("source")

            /**
             * The object type, which is always `python`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("python")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * The image tag to use for the python script.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun imageTag(): Optional<String> = imageTag.getOptional("image_tag")

            /**
             * The threshold for the score.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun passThreshold(): Optional<Double> = passThreshold.getOptional("pass_threshold")

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [source].
             *
             * Unlike [source], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("source") @ExcludeMissing fun _source(): JsonField<String> = source

            /**
             * Returns the raw JSON value of [imageTag].
             *
             * Unlike [imageTag], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("image_tag") @ExcludeMissing fun _imageTag(): JsonField<String> = imageTag

            /**
             * Returns the raw JSON value of [passThreshold].
             *
             * Unlike [passThreshold], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("pass_threshold")
            @ExcludeMissing
            fun _passThreshold(): JsonField<Double> = passThreshold

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
                 * Returns a mutable builder for constructing an instance of [EvalGraderPython].
                 *
                 * The following fields are required:
                 * ```java
                 * .name()
                 * .source()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [EvalGraderPython]. */
            class Builder internal constructor() {

                private var name: JsonField<String>? = null
                private var source: JsonField<String>? = null
                private var type: JsonValue = JsonValue.from("python")
                private var imageTag: JsonField<String> = JsonMissing.of()
                private var passThreshold: JsonField<Double> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(evalGraderPython: EvalGraderPython) = apply {
                    name = evalGraderPython.name
                    source = evalGraderPython.source
                    type = evalGraderPython.type
                    imageTag = evalGraderPython.imageTag
                    passThreshold = evalGraderPython.passThreshold
                    additionalProperties = evalGraderPython.additionalProperties.toMutableMap()
                }

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

                /** The source code of the python script. */
                fun source(source: String) = source(JsonField.of(source))

                /**
                 * Sets [Builder.source] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.source] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun source(source: JsonField<String>) = apply { this.source = source }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("python")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                /** The image tag to use for the python script. */
                fun imageTag(imageTag: String) = imageTag(JsonField.of(imageTag))

                /**
                 * Sets [Builder.imageTag] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.imageTag] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun imageTag(imageTag: JsonField<String>) = apply { this.imageTag = imageTag }

                /** The threshold for the score. */
                fun passThreshold(passThreshold: Double) =
                    passThreshold(JsonField.of(passThreshold))

                /**
                 * Sets [Builder.passThreshold] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.passThreshold] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun passThreshold(passThreshold: JsonField<Double>) = apply {
                    this.passThreshold = passThreshold
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
                 * Returns an immutable instance of [EvalGraderPython].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .name()
                 * .source()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): EvalGraderPython =
                    EvalGraderPython(
                        checkRequired("name", name),
                        checkRequired("source", source),
                        type,
                        imageTag,
                        passThreshold,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): EvalGraderPython = apply {
                if (validated) {
                    return@apply
                }

                name()
                source()
                _type().let {
                    if (it != JsonValue.from("python")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                imageTag()
                passThreshold()
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
                (if (name.asKnown().isPresent) 1 else 0) +
                    (if (source.asKnown().isPresent) 1 else 0) +
                    type.let { if (it == JsonValue.from("python")) 1 else 0 } +
                    (if (imageTag.asKnown().isPresent) 1 else 0) +
                    (if (passThreshold.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is EvalGraderPython &&
                    name == other.name &&
                    source == other.source &&
                    type == other.type &&
                    imageTag == other.imageTag &&
                    passThreshold == other.passThreshold &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(name, source, type, imageTag, passThreshold, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "EvalGraderPython{name=$name, source=$source, type=$type, imageTag=$imageTag, passThreshold=$passThreshold, additionalProperties=$additionalProperties}"
        }

        /** A ScoreModelGrader object that uses a model to assign a score to the input. */
        class EvalGraderScoreModel
        private constructor(
            private val input: JsonField<List<ScoreModelGrader.Input>>,
            private val model: JsonField<String>,
            private val name: JsonField<String>,
            private val type: JsonValue,
            private val range: JsonField<List<Double>>,
            private val samplingParams: JsonField<ScoreModelGrader.SamplingParams>,
            private val passThreshold: JsonField<Double>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("input")
                @ExcludeMissing
                input: JsonField<List<ScoreModelGrader.Input>> = JsonMissing.of(),
                @JsonProperty("model") @ExcludeMissing model: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                @JsonProperty("range")
                @ExcludeMissing
                range: JsonField<List<Double>> = JsonMissing.of(),
                @JsonProperty("sampling_params")
                @ExcludeMissing
                samplingParams: JsonField<ScoreModelGrader.SamplingParams> = JsonMissing.of(),
                @JsonProperty("pass_threshold")
                @ExcludeMissing
                passThreshold: JsonField<Double> = JsonMissing.of(),
            ) : this(input, model, name, type, range, samplingParams, passThreshold, mutableMapOf())

            fun toScoreModelGrader(): ScoreModelGrader =
                ScoreModelGrader.builder()
                    .input(input)
                    .model(model)
                    .name(name)
                    .type(type)
                    .range(range)
                    .samplingParams(samplingParams)
                    .build()

            /**
             * The input text. This may include template strings.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun input(): List<ScoreModelGrader.Input> = input.getRequired("input")

            /**
             * The model to use for the evaluation.
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
             * The object type, which is always `score_model`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("score_model")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * The range of the score. Defaults to `[0, 1]`.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun range(): Optional<List<Double>> = range.getOptional("range")

            /**
             * The sampling parameters for the model.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun samplingParams(): Optional<ScoreModelGrader.SamplingParams> =
                samplingParams.getOptional("sampling_params")

            /**
             * The threshold for the score.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun passThreshold(): Optional<Double> = passThreshold.getOptional("pass_threshold")

            /**
             * Returns the raw JSON value of [input].
             *
             * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("input")
            @ExcludeMissing
            fun _input(): JsonField<List<ScoreModelGrader.Input>> = input

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
             * Returns the raw JSON value of [range].
             *
             * Unlike [range], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("range") @ExcludeMissing fun _range(): JsonField<List<Double>> = range

            /**
             * Returns the raw JSON value of [samplingParams].
             *
             * Unlike [samplingParams], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("sampling_params")
            @ExcludeMissing
            fun _samplingParams(): JsonField<ScoreModelGrader.SamplingParams> = samplingParams

            /**
             * Returns the raw JSON value of [passThreshold].
             *
             * Unlike [passThreshold], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("pass_threshold")
            @ExcludeMissing
            fun _passThreshold(): JsonField<Double> = passThreshold

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
                 * Returns a mutable builder for constructing an instance of [EvalGraderScoreModel].
                 *
                 * The following fields are required:
                 * ```java
                 * .input()
                 * .model()
                 * .name()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [EvalGraderScoreModel]. */
            class Builder internal constructor() {

                private var input: JsonField<MutableList<ScoreModelGrader.Input>>? = null
                private var model: JsonField<String>? = null
                private var name: JsonField<String>? = null
                private var type: JsonValue = JsonValue.from("score_model")
                private var range: JsonField<MutableList<Double>>? = null
                private var samplingParams: JsonField<ScoreModelGrader.SamplingParams> =
                    JsonMissing.of()
                private var passThreshold: JsonField<Double> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(evalGraderScoreModel: EvalGraderScoreModel) = apply {
                    input = evalGraderScoreModel.input.map { it.toMutableList() }
                    model = evalGraderScoreModel.model
                    name = evalGraderScoreModel.name
                    type = evalGraderScoreModel.type
                    range = evalGraderScoreModel.range.map { it.toMutableList() }
                    samplingParams = evalGraderScoreModel.samplingParams
                    passThreshold = evalGraderScoreModel.passThreshold
                    additionalProperties = evalGraderScoreModel.additionalProperties.toMutableMap()
                }

                /** The input text. This may include template strings. */
                fun input(input: List<ScoreModelGrader.Input>) = input(JsonField.of(input))

                /**
                 * Sets [Builder.input] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.input] with a well-typed
                 * `List<ScoreModelGrader.Input>` value instead. This method is primarily for
                 * setting the field to an undocumented or not yet supported value.
                 */
                fun input(input: JsonField<List<ScoreModelGrader.Input>>) = apply {
                    this.input = input.map { it.toMutableList() }
                }

                /**
                 * Adds a single [ScoreModelGrader.Input] to [Builder.input].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addInput(input: ScoreModelGrader.Input) = apply {
                    this.input =
                        (this.input ?: JsonField.of(mutableListOf())).also {
                            checkKnown("input", it).add(input)
                        }
                }

                /** The model to use for the evaluation. */
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

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("score_model")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                /** The range of the score. Defaults to `[0, 1]`. */
                fun range(range: List<Double>) = range(JsonField.of(range))

                /**
                 * Sets [Builder.range] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.range] with a well-typed `List<Double>` value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun range(range: JsonField<List<Double>>) = apply {
                    this.range = range.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Double] to [Builder.range].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addRange(range: Double) = apply {
                    this.range =
                        (this.range ?: JsonField.of(mutableListOf())).also {
                            checkKnown("range", it).add(range)
                        }
                }

                /** The sampling parameters for the model. */
                fun samplingParams(samplingParams: ScoreModelGrader.SamplingParams) =
                    samplingParams(JsonField.of(samplingParams))

                /**
                 * Sets [Builder.samplingParams] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.samplingParams] with a well-typed
                 * [ScoreModelGrader.SamplingParams] value instead. This method is primarily for
                 * setting the field to an undocumented or not yet supported value.
                 */
                fun samplingParams(samplingParams: JsonField<ScoreModelGrader.SamplingParams>) =
                    apply {
                        this.samplingParams = samplingParams
                    }

                /** The threshold for the score. */
                fun passThreshold(passThreshold: Double) =
                    passThreshold(JsonField.of(passThreshold))

                /**
                 * Sets [Builder.passThreshold] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.passThreshold] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun passThreshold(passThreshold: JsonField<Double>) = apply {
                    this.passThreshold = passThreshold
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
                 * Returns an immutable instance of [EvalGraderScoreModel].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .input()
                 * .model()
                 * .name()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): EvalGraderScoreModel =
                    EvalGraderScoreModel(
                        checkRequired("input", input).map { it.toImmutable() },
                        checkRequired("model", model),
                        checkRequired("name", name),
                        type,
                        (range ?: JsonMissing.of()).map { it.toImmutable() },
                        samplingParams,
                        passThreshold,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): EvalGraderScoreModel = apply {
                if (validated) {
                    return@apply
                }

                input().forEach { it.validate() }
                model()
                name()
                _type().let {
                    if (it != JsonValue.from("score_model")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                range()
                samplingParams().ifPresent { it.validate() }
                passThreshold()
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
                    (if (model.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0) +
                    type.let { if (it == JsonValue.from("score_model")) 1 else 0 } +
                    (range.asKnown().getOrNull()?.size ?: 0) +
                    (samplingParams.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (passThreshold.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is EvalGraderScoreModel &&
                    input == other.input &&
                    model == other.model &&
                    name == other.name &&
                    type == other.type &&
                    range == other.range &&
                    samplingParams == other.samplingParams &&
                    passThreshold == other.passThreshold &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    input,
                    model,
                    name,
                    type,
                    range,
                    samplingParams,
                    passThreshold,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "EvalGraderScoreModel{input=$input, model=$model, name=$name, type=$type, range=$range, samplingParams=$samplingParams, passThreshold=$passThreshold, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is EvalRetrieveResponse &&
            id == other.id &&
            createdAt == other.createdAt &&
            dataSourceConfig == other.dataSourceConfig &&
            metadata == other.metadata &&
            name == other.name &&
            object_ == other.object_ &&
            testingCriteria == other.testingCriteria &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            createdAt,
            dataSourceConfig,
            metadata,
            name,
            object_,
            testingCriteria,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "EvalRetrieveResponse{id=$id, createdAt=$createdAt, dataSourceConfig=$dataSourceConfig, metadata=$metadata, name=$name, object_=$object_, testingCriteria=$testingCriteria, additionalProperties=$additionalProperties}"
}
