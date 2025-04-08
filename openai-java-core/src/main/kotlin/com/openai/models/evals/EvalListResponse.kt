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
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * An Eval object with a data source config and testing criteria. An Eval represents a task to be
 * done for your LLM integration. Like:
 * - Improve the quality of my chatbot
 * - See how well my chatbot handles customer support
 * - Check if o3-mini is better at my usecase than gpt-4o
 */
class EvalListResponse
private constructor(
    private val id: JsonField<String>,
    private val createdAt: JsonField<Long>,
    private val dataSourceConfig: JsonField<DataSourceConfig>,
    private val metadata: JsonField<Metadata>,
    private val name: JsonField<String>,
    private val object_: JsonValue,
    private val shareWithOpenAI: JsonField<Boolean>,
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
        @JsonProperty("share_with_openai")
        @ExcludeMissing
        shareWithOpenAI: JsonField<Boolean> = JsonMissing.of(),
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
        shareWithOpenAI,
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
     * Indicates whether the evaluation is shared with OpenAI.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun shareWithOpenAI(): Boolean = shareWithOpenAI.getRequired("share_with_openai")

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
     * Returns the raw JSON value of [shareWithOpenAI].
     *
     * Unlike [shareWithOpenAI], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("share_with_openai")
    @ExcludeMissing
    fun _shareWithOpenAI(): JsonField<Boolean> = shareWithOpenAI

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
         * Returns a mutable builder for constructing an instance of [EvalListResponse].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .dataSourceConfig()
         * .metadata()
         * .name()
         * .shareWithOpenAI()
         * .testingCriteria()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [EvalListResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var createdAt: JsonField<Long>? = null
        private var dataSourceConfig: JsonField<DataSourceConfig>? = null
        private var metadata: JsonField<Metadata>? = null
        private var name: JsonField<String>? = null
        private var object_: JsonValue = JsonValue.from("eval")
        private var shareWithOpenAI: JsonField<Boolean>? = null
        private var testingCriteria: JsonField<MutableList<TestingCriterion>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(evalListResponse: EvalListResponse) = apply {
            id = evalListResponse.id
            createdAt = evalListResponse.createdAt
            dataSourceConfig = evalListResponse.dataSourceConfig
            metadata = evalListResponse.metadata
            name = evalListResponse.name
            object_ = evalListResponse.object_
            shareWithOpenAI = evalListResponse.shareWithOpenAI
            testingCriteria = evalListResponse.testingCriteria.map { it.toMutableList() }
            additionalProperties = evalListResponse.additionalProperties.toMutableMap()
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

        /**
         * Alias for calling [dataSourceConfig] with
         * `DataSourceConfig.ofStoredCompletions(storedCompletions)`.
         */
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
         * Alias for calling [addTestingCriterion] with `TestingCriterion.ofLabelModel(labelModel)`.
         */
        fun addTestingCriterion(labelModel: EvalLabelModelGrader) =
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
         * Returns an immutable instance of [EvalListResponse].
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
         * .shareWithOpenAI()
         * .testingCriteria()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): EvalListResponse =
            EvalListResponse(
                checkRequired("id", id),
                checkRequired("createdAt", createdAt),
                checkRequired("dataSourceConfig", dataSourceConfig),
                checkRequired("metadata", metadata),
                checkRequired("name", name),
                object_,
                checkRequired("shareWithOpenAI", shareWithOpenAI),
                checkRequired("testingCriteria", testingCriteria).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): EvalListResponse = apply {
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
        shareWithOpenAI()
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
            (if (shareWithOpenAI.asKnown().isPresent) 1 else 0) +
            (testingCriteria.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    /** Configuration of data sources used in runs of the evaluation. */
    @JsonDeserialize(using = DataSourceConfig.Deserializer::class)
    @JsonSerialize(using = DataSourceConfig.Serializer::class)
    class DataSourceConfig
    private constructor(
        private val custom: EvalCustomDataSourceConfig? = null,
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
         * A StoredCompletionsDataSourceConfig which specifies the metadata property of your stored
         * completions query. This is usually metadata like `usecase=chatbot` or
         * `prompt-version=v2`, etc. The schema returned by this data source config is used to
         * defined what variables are available in your evals. `item` and `sample` are both defined
         * when using this data source config.
         */
        fun storedCompletions(): Optional<EvalStoredCompletionsDataSourceConfig> =
            Optional.ofNullable(storedCompletions)

        fun isCustom(): Boolean = custom != null

        fun isStoredCompletions(): Boolean = storedCompletions != null

        /**
         * A CustomDataSourceConfig which specifies the schema of your `item` and optionally
         * `sample` namespaces. The response schema defines the shape of the data that will be:
         * - Used to define your testing criteria and
         * - What data is required when creating a run
         */
        fun asCustom(): EvalCustomDataSourceConfig = custom.getOrThrow("custom")

        /**
         * A StoredCompletionsDataSourceConfig which specifies the metadata property of your stored
         * completions query. This is usually metadata like `usecase=chatbot` or
         * `prompt-version=v2`, etc. The schema returned by this data source config is used to
         * defined what variables are available in your evals. `item` and `sample` are both defined
         * when using this data source config.
         */
        fun asStoredCompletions(): EvalStoredCompletionsDataSourceConfig =
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
                    override fun visitCustom(custom: EvalCustomDataSourceConfig) {
                        custom.validate()
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
             * A CustomDataSourceConfig which specifies the schema of your `item` and optionally
             * `sample` namespaces. The response schema defines the shape of the data that will be:
             * - Used to define your testing criteria and
             * - What data is required when creating a run
             */
            @JvmStatic
            fun ofCustom(custom: EvalCustomDataSourceConfig) = DataSourceConfig(custom = custom)

            /**
             * A StoredCompletionsDataSourceConfig which specifies the metadata property of your
             * stored completions query. This is usually metadata like `usecase=chatbot` or
             * `prompt-version=v2`, etc. The schema returned by this data source config is used to
             * defined what variables are available in your evals. `item` and `sample` are both
             * defined when using this data source config.
             */
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
             * A StoredCompletionsDataSourceConfig which specifies the metadata property of your
             * stored completions query. This is usually metadata like `usecase=chatbot` or
             * `prompt-version=v2`, etc. The schema returned by this data source config is used to
             * defined what variables are available in your evals. `item` and `sample` are both
             * defined when using this data source config.
             */
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
                    value.storedCompletions != null ->
                        generator.writeObject(value.storedCompletions)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid DataSourceConfig")
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

    /**
     * A LabelModelGrader object which uses a model to assign labels to each item in the evaluation.
     */
    @JsonDeserialize(using = TestingCriterion.Deserializer::class)
    @JsonSerialize(using = TestingCriterion.Serializer::class)
    class TestingCriterion
    private constructor(
        private val labelModel: EvalLabelModelGrader? = null,
        private val stringCheck: EvalStringCheckGrader? = null,
        private val textSimilarity: EvalTextSimilarityGrader? = null,
        private val _json: JsonValue? = null,
    ) {

        /**
         * A LabelModelGrader object which uses a model to assign labels to each item in the
         * evaluation.
         */
        fun labelModel(): Optional<EvalLabelModelGrader> = Optional.ofNullable(labelModel)

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
        fun asLabelModel(): EvalLabelModelGrader = labelModel.getOrThrow("labelModel")

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
                    override fun visitLabelModel(labelModel: EvalLabelModelGrader) {
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
                    override fun visitLabelModel(labelModel: EvalLabelModelGrader) =
                        labelModel.validity()

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
            fun ofLabelModel(labelModel: EvalLabelModelGrader) =
                TestingCriterion(labelModel = labelModel)

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
            fun visitLabelModel(labelModel: EvalLabelModelGrader): T

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
                        return tryDeserialize(node, jacksonTypeRef<EvalLabelModelGrader>())?.let {
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
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is EvalListResponse && id == other.id && createdAt == other.createdAt && dataSourceConfig == other.dataSourceConfig && metadata == other.metadata && name == other.name && object_ == other.object_ && shareWithOpenAI == other.shareWithOpenAI && testingCriteria == other.testingCriteria && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, createdAt, dataSourceConfig, metadata, name, object_, shareWithOpenAI, testingCriteria, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "EvalListResponse{id=$id, createdAt=$createdAt, dataSourceConfig=$dataSourceConfig, metadata=$metadata, name=$name, object_=$object_, shareWithOpenAI=$shareWithOpenAI, testingCriteria=$testingCriteria, additionalProperties=$additionalProperties}"
}
