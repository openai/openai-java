// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals.runs.outputitems

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.evals.runs.EvalApiError
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A schema representing an evaluation run output item. */
class OutputItemListResponse
private constructor(
    private val id: JsonField<String>,
    private val createdAt: JsonField<Long>,
    private val datasourceItem: JsonField<DatasourceItem>,
    private val datasourceItemId: JsonField<Long>,
    private val evalId: JsonField<String>,
    private val object_: JsonValue,
    private val results: JsonField<List<Result>>,
    private val runId: JsonField<String>,
    private val sample: JsonField<Sample>,
    private val status: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("created_at") @ExcludeMissing createdAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("datasource_item")
        @ExcludeMissing
        datasourceItem: JsonField<DatasourceItem> = JsonMissing.of(),
        @JsonProperty("datasource_item_id")
        @ExcludeMissing
        datasourceItemId: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("eval_id") @ExcludeMissing evalId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("results")
        @ExcludeMissing
        results: JsonField<List<Result>> = JsonMissing.of(),
        @JsonProperty("run_id") @ExcludeMissing runId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("sample") @ExcludeMissing sample: JsonField<Sample> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
    ) : this(
        id,
        createdAt,
        datasourceItem,
        datasourceItemId,
        evalId,
        object_,
        results,
        runId,
        sample,
        status,
        mutableMapOf(),
    )

    /**
     * Unique identifier for the evaluation run output item.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * Unix timestamp (in seconds) when the evaluation run was created.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /**
     * Details of the input data source item.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun datasourceItem(): DatasourceItem = datasourceItem.getRequired("datasource_item")

    /**
     * The identifier for the data source item.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun datasourceItemId(): Long = datasourceItemId.getRequired("datasource_item_id")

    /**
     * The identifier of the evaluation group.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun evalId(): String = evalId.getRequired("eval_id")

    /**
     * The type of the object. Always "eval.run.output_item".
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("eval.run.output_item")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * A list of results from the evaluation run.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun results(): List<Result> = results.getRequired("results")

    /**
     * The identifier of the evaluation run associated with this output item.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun runId(): String = runId.getRequired("run_id")

    /**
     * A sample containing the input and output of the evaluation run.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun sample(): Sample = sample.getRequired("sample")

    /**
     * The status of the evaluation run.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): String = status.getRequired("status")

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
     * Returns the raw JSON value of [datasourceItem].
     *
     * Unlike [datasourceItem], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("datasource_item")
    @ExcludeMissing
    fun _datasourceItem(): JsonField<DatasourceItem> = datasourceItem

    /**
     * Returns the raw JSON value of [datasourceItemId].
     *
     * Unlike [datasourceItemId], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("datasource_item_id")
    @ExcludeMissing
    fun _datasourceItemId(): JsonField<Long> = datasourceItemId

    /**
     * Returns the raw JSON value of [evalId].
     *
     * Unlike [evalId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("eval_id") @ExcludeMissing fun _evalId(): JsonField<String> = evalId

    /**
     * Returns the raw JSON value of [results].
     *
     * Unlike [results], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("results") @ExcludeMissing fun _results(): JsonField<List<Result>> = results

    /**
     * Returns the raw JSON value of [runId].
     *
     * Unlike [runId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("run_id") @ExcludeMissing fun _runId(): JsonField<String> = runId

    /**
     * Returns the raw JSON value of [sample].
     *
     * Unlike [sample], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sample") @ExcludeMissing fun _sample(): JsonField<Sample> = sample

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

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
         * Returns a mutable builder for constructing an instance of [OutputItemListResponse].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .datasourceItem()
         * .datasourceItemId()
         * .evalId()
         * .results()
         * .runId()
         * .sample()
         * .status()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [OutputItemListResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var createdAt: JsonField<Long>? = null
        private var datasourceItem: JsonField<DatasourceItem>? = null
        private var datasourceItemId: JsonField<Long>? = null
        private var evalId: JsonField<String>? = null
        private var object_: JsonValue = JsonValue.from("eval.run.output_item")
        private var results: JsonField<MutableList<Result>>? = null
        private var runId: JsonField<String>? = null
        private var sample: JsonField<Sample>? = null
        private var status: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(outputItemListResponse: OutputItemListResponse) = apply {
            id = outputItemListResponse.id
            createdAt = outputItemListResponse.createdAt
            datasourceItem = outputItemListResponse.datasourceItem
            datasourceItemId = outputItemListResponse.datasourceItemId
            evalId = outputItemListResponse.evalId
            object_ = outputItemListResponse.object_
            results = outputItemListResponse.results.map { it.toMutableList() }
            runId = outputItemListResponse.runId
            sample = outputItemListResponse.sample
            status = outputItemListResponse.status
            additionalProperties = outputItemListResponse.additionalProperties.toMutableMap()
        }

        /** Unique identifier for the evaluation run output item. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Unix timestamp (in seconds) when the evaluation run was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /** Details of the input data source item. */
        fun datasourceItem(datasourceItem: DatasourceItem) =
            datasourceItem(JsonField.of(datasourceItem))

        /**
         * Sets [Builder.datasourceItem] to an arbitrary JSON value.
         *
         * You should usually call [Builder.datasourceItem] with a well-typed [DatasourceItem] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun datasourceItem(datasourceItem: JsonField<DatasourceItem>) = apply {
            this.datasourceItem = datasourceItem
        }

        /** The identifier for the data source item. */
        fun datasourceItemId(datasourceItemId: Long) =
            datasourceItemId(JsonField.of(datasourceItemId))

        /**
         * Sets [Builder.datasourceItemId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.datasourceItemId] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun datasourceItemId(datasourceItemId: JsonField<Long>) = apply {
            this.datasourceItemId = datasourceItemId
        }

        /** The identifier of the evaluation group. */
        fun evalId(evalId: String) = evalId(JsonField.of(evalId))

        /**
         * Sets [Builder.evalId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.evalId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun evalId(evalId: JsonField<String>) = apply { this.evalId = evalId }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("eval.run.output_item")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /** A list of results from the evaluation run. */
        fun results(results: List<Result>) = results(JsonField.of(results))

        /**
         * Sets [Builder.results] to an arbitrary JSON value.
         *
         * You should usually call [Builder.results] with a well-typed `List<Result>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun results(results: JsonField<List<Result>>) = apply {
            this.results = results.map { it.toMutableList() }
        }

        /**
         * Adds a single [Result] to [results].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addResult(result: Result) = apply {
            results =
                (results ?: JsonField.of(mutableListOf())).also {
                    checkKnown("results", it).add(result)
                }
        }

        /** The identifier of the evaluation run associated with this output item. */
        fun runId(runId: String) = runId(JsonField.of(runId))

        /**
         * Sets [Builder.runId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.runId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun runId(runId: JsonField<String>) = apply { this.runId = runId }

        /** A sample containing the input and output of the evaluation run. */
        fun sample(sample: Sample) = sample(JsonField.of(sample))

        /**
         * Sets [Builder.sample] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sample] with a well-typed [Sample] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun sample(sample: JsonField<Sample>) = apply { this.sample = sample }

        /** The status of the evaluation run. */
        fun status(status: String) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<String>) = apply { this.status = status }

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
         * Returns an immutable instance of [OutputItemListResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .datasourceItem()
         * .datasourceItemId()
         * .evalId()
         * .results()
         * .runId()
         * .sample()
         * .status()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): OutputItemListResponse =
            OutputItemListResponse(
                checkRequired("id", id),
                checkRequired("createdAt", createdAt),
                checkRequired("datasourceItem", datasourceItem),
                checkRequired("datasourceItemId", datasourceItemId),
                checkRequired("evalId", evalId),
                object_,
                checkRequired("results", results).map { it.toImmutable() },
                checkRequired("runId", runId),
                checkRequired("sample", sample),
                checkRequired("status", status),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): OutputItemListResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        createdAt()
        datasourceItem().validate()
        datasourceItemId()
        evalId()
        _object_().let {
            if (it != JsonValue.from("eval.run.output_item")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        results().forEach { it.validate() }
        runId()
        sample().validate()
        status()
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
            (datasourceItem.asKnown().getOrNull()?.validity() ?: 0) +
            (if (datasourceItemId.asKnown().isPresent) 1 else 0) +
            (if (evalId.asKnown().isPresent) 1 else 0) +
            object_.let { if (it == JsonValue.from("eval.run.output_item")) 1 else 0 } +
            (results.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (runId.asKnown().isPresent) 1 else 0) +
            (sample.asKnown().getOrNull()?.validity() ?: 0) +
            (if (status.asKnown().isPresent) 1 else 0)

    /** Details of the input data source item. */
    class DatasourceItem
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

            /** Returns a mutable builder for constructing an instance of [DatasourceItem]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [DatasourceItem]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(datasourceItem: DatasourceItem) = apply {
                additionalProperties = datasourceItem.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [DatasourceItem].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): DatasourceItem = DatasourceItem(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): DatasourceItem = apply {
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

            return /* spotless:off */ other is DatasourceItem && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() = "DatasourceItem{additionalProperties=$additionalProperties}"
    }

    /** A result object. */
    class Result
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

            /** Returns a mutable builder for constructing an instance of [Result]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Result]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(result: Result) = apply {
                additionalProperties = result.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [Result].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Result = Result(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): Result = apply {
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

            return /* spotless:off */ other is Result && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() = "Result{additionalProperties=$additionalProperties}"
    }

    /** A sample containing the input and output of the evaluation run. */
    class Sample
    private constructor(
        private val error: JsonField<EvalApiError>,
        private val finishReason: JsonField<String>,
        private val input: JsonField<List<Input>>,
        private val maxCompletionTokens: JsonField<Long>,
        private val model: JsonField<String>,
        private val output: JsonField<List<Output>>,
        private val seed: JsonField<Long>,
        private val temperature: JsonField<Double>,
        private val topP: JsonField<Double>,
        private val usage: JsonField<Usage>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("error")
            @ExcludeMissing
            error: JsonField<EvalApiError> = JsonMissing.of(),
            @JsonProperty("finish_reason")
            @ExcludeMissing
            finishReason: JsonField<String> = JsonMissing.of(),
            @JsonProperty("input") @ExcludeMissing input: JsonField<List<Input>> = JsonMissing.of(),
            @JsonProperty("max_completion_tokens")
            @ExcludeMissing
            maxCompletionTokens: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("model") @ExcludeMissing model: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output")
            @ExcludeMissing
            output: JsonField<List<Output>> = JsonMissing.of(),
            @JsonProperty("seed") @ExcludeMissing seed: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("temperature")
            @ExcludeMissing
            temperature: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("top_p") @ExcludeMissing topP: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("usage") @ExcludeMissing usage: JsonField<Usage> = JsonMissing.of(),
        ) : this(
            error,
            finishReason,
            input,
            maxCompletionTokens,
            model,
            output,
            seed,
            temperature,
            topP,
            usage,
            mutableMapOf(),
        )

        /**
         * An object representing an error response from the Eval API.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun error(): EvalApiError = error.getRequired("error")

        /**
         * The reason why the sample generation was finished.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun finishReason(): String = finishReason.getRequired("finish_reason")

        /**
         * An array of input messages.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun input(): List<Input> = input.getRequired("input")

        /**
         * The maximum number of tokens allowed for completion.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun maxCompletionTokens(): Long = maxCompletionTokens.getRequired("max_completion_tokens")

        /**
         * The model used for generating the sample.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun model(): String = model.getRequired("model")

        /**
         * An array of output messages.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun output(): List<Output> = output.getRequired("output")

        /**
         * The seed used for generating the sample.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun seed(): Long = seed.getRequired("seed")

        /**
         * The sampling temperature used.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun temperature(): Double = temperature.getRequired("temperature")

        /**
         * The top_p value used for sampling.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun topP(): Double = topP.getRequired("top_p")

        /**
         * Token usage details for the sample.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun usage(): Usage = usage.getRequired("usage")

        /**
         * Returns the raw JSON value of [error].
         *
         * Unlike [error], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<EvalApiError> = error

        /**
         * Returns the raw JSON value of [finishReason].
         *
         * Unlike [finishReason], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("finish_reason")
        @ExcludeMissing
        fun _finishReason(): JsonField<String> = finishReason

        /**
         * Returns the raw JSON value of [input].
         *
         * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("input") @ExcludeMissing fun _input(): JsonField<List<Input>> = input

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
         * Returns the raw JSON value of [model].
         *
         * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

        /**
         * Returns the raw JSON value of [output].
         *
         * Unlike [output], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output") @ExcludeMissing fun _output(): JsonField<List<Output>> = output

        /**
         * Returns the raw JSON value of [seed].
         *
         * Unlike [seed], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("seed") @ExcludeMissing fun _seed(): JsonField<Long> = seed

        /**
         * Returns the raw JSON value of [temperature].
         *
         * Unlike [temperature], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("temperature")
        @ExcludeMissing
        fun _temperature(): JsonField<Double> = temperature

        /**
         * Returns the raw JSON value of [topP].
         *
         * Unlike [topP], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("top_p") @ExcludeMissing fun _topP(): JsonField<Double> = topP

        /**
         * Returns the raw JSON value of [usage].
         *
         * Unlike [usage], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("usage") @ExcludeMissing fun _usage(): JsonField<Usage> = usage

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
             * Returns a mutable builder for constructing an instance of [Sample].
             *
             * The following fields are required:
             * ```java
             * .error()
             * .finishReason()
             * .input()
             * .maxCompletionTokens()
             * .model()
             * .output()
             * .seed()
             * .temperature()
             * .topP()
             * .usage()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Sample]. */
        class Builder internal constructor() {

            private var error: JsonField<EvalApiError>? = null
            private var finishReason: JsonField<String>? = null
            private var input: JsonField<MutableList<Input>>? = null
            private var maxCompletionTokens: JsonField<Long>? = null
            private var model: JsonField<String>? = null
            private var output: JsonField<MutableList<Output>>? = null
            private var seed: JsonField<Long>? = null
            private var temperature: JsonField<Double>? = null
            private var topP: JsonField<Double>? = null
            private var usage: JsonField<Usage>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(sample: Sample) = apply {
                error = sample.error
                finishReason = sample.finishReason
                input = sample.input.map { it.toMutableList() }
                maxCompletionTokens = sample.maxCompletionTokens
                model = sample.model
                output = sample.output.map { it.toMutableList() }
                seed = sample.seed
                temperature = sample.temperature
                topP = sample.topP
                usage = sample.usage
                additionalProperties = sample.additionalProperties.toMutableMap()
            }

            /** An object representing an error response from the Eval API. */
            fun error(error: EvalApiError) = error(JsonField.of(error))

            /**
             * Sets [Builder.error] to an arbitrary JSON value.
             *
             * You should usually call [Builder.error] with a well-typed [EvalApiError] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun error(error: JsonField<EvalApiError>) = apply { this.error = error }

            /** The reason why the sample generation was finished. */
            fun finishReason(finishReason: String) = finishReason(JsonField.of(finishReason))

            /**
             * Sets [Builder.finishReason] to an arbitrary JSON value.
             *
             * You should usually call [Builder.finishReason] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun finishReason(finishReason: JsonField<String>) = apply {
                this.finishReason = finishReason
            }

            /** An array of input messages. */
            fun input(input: List<Input>) = input(JsonField.of(input))

            /**
             * Sets [Builder.input] to an arbitrary JSON value.
             *
             * You should usually call [Builder.input] with a well-typed `List<Input>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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

            /** The maximum number of tokens allowed for completion. */
            fun maxCompletionTokens(maxCompletionTokens: Long) =
                maxCompletionTokens(JsonField.of(maxCompletionTokens))

            /**
             * Sets [Builder.maxCompletionTokens] to an arbitrary JSON value.
             *
             * You should usually call [Builder.maxCompletionTokens] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun maxCompletionTokens(maxCompletionTokens: JsonField<Long>) = apply {
                this.maxCompletionTokens = maxCompletionTokens
            }

            /** The model used for generating the sample. */
            fun model(model: String) = model(JsonField.of(model))

            /**
             * Sets [Builder.model] to an arbitrary JSON value.
             *
             * You should usually call [Builder.model] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun model(model: JsonField<String>) = apply { this.model = model }

            /** An array of output messages. */
            fun output(output: List<Output>) = output(JsonField.of(output))

            /**
             * Sets [Builder.output] to an arbitrary JSON value.
             *
             * You should usually call [Builder.output] with a well-typed `List<Output>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun output(output: JsonField<List<Output>>) = apply {
                this.output = output.map { it.toMutableList() }
            }

            /**
             * Adds a single [Output] to [Builder.output].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addOutput(output: Output) = apply {
                this.output =
                    (this.output ?: JsonField.of(mutableListOf())).also {
                        checkKnown("output", it).add(output)
                    }
            }

            /** The seed used for generating the sample. */
            fun seed(seed: Long) = seed(JsonField.of(seed))

            /**
             * Sets [Builder.seed] to an arbitrary JSON value.
             *
             * You should usually call [Builder.seed] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun seed(seed: JsonField<Long>) = apply { this.seed = seed }

            /** The sampling temperature used. */
            fun temperature(temperature: Double) = temperature(JsonField.of(temperature))

            /**
             * Sets [Builder.temperature] to an arbitrary JSON value.
             *
             * You should usually call [Builder.temperature] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun temperature(temperature: JsonField<Double>) = apply {
                this.temperature = temperature
            }

            /** The top_p value used for sampling. */
            fun topP(topP: Double) = topP(JsonField.of(topP))

            /**
             * Sets [Builder.topP] to an arbitrary JSON value.
             *
             * You should usually call [Builder.topP] with a well-typed [Double] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun topP(topP: JsonField<Double>) = apply { this.topP = topP }

            /** Token usage details for the sample. */
            fun usage(usage: Usage) = usage(JsonField.of(usage))

            /**
             * Sets [Builder.usage] to an arbitrary JSON value.
             *
             * You should usually call [Builder.usage] with a well-typed [Usage] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
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

            /**
             * Returns an immutable instance of [Sample].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .error()
             * .finishReason()
             * .input()
             * .maxCompletionTokens()
             * .model()
             * .output()
             * .seed()
             * .temperature()
             * .topP()
             * .usage()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Sample =
                Sample(
                    checkRequired("error", error),
                    checkRequired("finishReason", finishReason),
                    checkRequired("input", input).map { it.toImmutable() },
                    checkRequired("maxCompletionTokens", maxCompletionTokens),
                    checkRequired("model", model),
                    checkRequired("output", output).map { it.toImmutable() },
                    checkRequired("seed", seed),
                    checkRequired("temperature", temperature),
                    checkRequired("topP", topP),
                    checkRequired("usage", usage),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Sample = apply {
            if (validated) {
                return@apply
            }

            error().validate()
            finishReason()
            input().forEach { it.validate() }
            maxCompletionTokens()
            model()
            output().forEach { it.validate() }
            seed()
            temperature()
            topP()
            usage().validate()
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
            (error.asKnown().getOrNull()?.validity() ?: 0) +
                (if (finishReason.asKnown().isPresent) 1 else 0) +
                (input.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (maxCompletionTokens.asKnown().isPresent) 1 else 0) +
                (if (model.asKnown().isPresent) 1 else 0) +
                (output.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (seed.asKnown().isPresent) 1 else 0) +
                (if (temperature.asKnown().isPresent) 1 else 0) +
                (if (topP.asKnown().isPresent) 1 else 0) +
                (usage.asKnown().getOrNull()?.validity() ?: 0)

        /** An input message. */
        class Input
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
                @JsonProperty("role") @ExcludeMissing role: JsonField<String> = JsonMissing.of(),
            ) : this(content, role, mutableMapOf())

            /**
             * The content of the message.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun content(): String = content.getRequired("content")

            /**
             * The role of the message sender (e.g., system, user, developer).
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun role(): String = role.getRequired("role")

            /**
             * Returns the raw JSON value of [content].
             *
             * Unlike [content], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("content") @ExcludeMissing fun _content(): JsonField<String> = content

            /**
             * Returns the raw JSON value of [role].
             *
             * Unlike [role], this method doesn't throw if the JSON field has an unexpected type.
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
                 * Returns a mutable builder for constructing an instance of [Input].
                 *
                 * The following fields are required:
                 * ```java
                 * .content()
                 * .role()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Input]. */
            class Builder internal constructor() {

                private var content: JsonField<String>? = null
                private var role: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(input: Input) = apply {
                    content = input.content
                    role = input.role
                    additionalProperties = input.additionalProperties.toMutableMap()
                }

                /** The content of the message. */
                fun content(content: String) = content(JsonField.of(content))

                /**
                 * Sets [Builder.content] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.content] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun content(content: JsonField<String>) = apply { this.content = content }

                /** The role of the message sender (e.g., system, user, developer). */
                fun role(role: String) = role(JsonField.of(role))

                /**
                 * Sets [Builder.role] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.role] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun role(role: JsonField<String>) = apply { this.role = role }

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
                 * Returns an immutable instance of [Input].
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
                fun build(): Input =
                    Input(
                        checkRequired("content", content),
                        checkRequired("role", role),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Input = apply {
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

                return /* spotless:off */ other is Input && content == other.content && role == other.role && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(content, role, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Input{content=$content, role=$role, additionalProperties=$additionalProperties}"
        }

        class Output
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
                @JsonProperty("role") @ExcludeMissing role: JsonField<String> = JsonMissing.of(),
            ) : this(content, role, mutableMapOf())

            /**
             * The content of the message.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun content(): Optional<String> = content.getOptional("content")

            /**
             * The role of the message (e.g. "system", "assistant", "user").
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun role(): Optional<String> = role.getOptional("role")

            /**
             * Returns the raw JSON value of [content].
             *
             * Unlike [content], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("content") @ExcludeMissing fun _content(): JsonField<String> = content

            /**
             * Returns the raw JSON value of [role].
             *
             * Unlike [role], this method doesn't throw if the JSON field has an unexpected type.
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

                /** Returns a mutable builder for constructing an instance of [Output]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Output]. */
            class Builder internal constructor() {

                private var content: JsonField<String> = JsonMissing.of()
                private var role: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(output: Output) = apply {
                    content = output.content
                    role = output.role
                    additionalProperties = output.additionalProperties.toMutableMap()
                }

                /** The content of the message. */
                fun content(content: String) = content(JsonField.of(content))

                /**
                 * Sets [Builder.content] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.content] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun content(content: JsonField<String>) = apply { this.content = content }

                /** The role of the message (e.g. "system", "assistant", "user"). */
                fun role(role: String) = role(JsonField.of(role))

                /**
                 * Sets [Builder.role] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.role] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun role(role: JsonField<String>) = apply { this.role = role }

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
                 * Returns an immutable instance of [Output].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Output = Output(content, role, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): Output = apply {
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

                return /* spotless:off */ other is Output && content == other.content && role == other.role && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(content, role, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Output{content=$content, role=$role, additionalProperties=$additionalProperties}"
        }

        /** Token usage details for the sample. */
        class Usage
        private constructor(
            private val cachedTokens: JsonField<Long>,
            private val completionTokens: JsonField<Long>,
            private val promptTokens: JsonField<Long>,
            private val totalTokens: JsonField<Long>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("cached_tokens")
                @ExcludeMissing
                cachedTokens: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("completion_tokens")
                @ExcludeMissing
                completionTokens: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("prompt_tokens")
                @ExcludeMissing
                promptTokens: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("total_tokens")
                @ExcludeMissing
                totalTokens: JsonField<Long> = JsonMissing.of(),
            ) : this(cachedTokens, completionTokens, promptTokens, totalTokens, mutableMapOf())

            /**
             * The number of tokens retrieved from cache.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun cachedTokens(): Long = cachedTokens.getRequired("cached_tokens")

            /**
             * The number of completion tokens generated.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun completionTokens(): Long = completionTokens.getRequired("completion_tokens")

            /**
             * The number of prompt tokens used.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun promptTokens(): Long = promptTokens.getRequired("prompt_tokens")

            /**
             * The total number of tokens used.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun totalTokens(): Long = totalTokens.getRequired("total_tokens")

            /**
             * Returns the raw JSON value of [cachedTokens].
             *
             * Unlike [cachedTokens], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("cached_tokens")
            @ExcludeMissing
            fun _cachedTokens(): JsonField<Long> = cachedTokens

            /**
             * Returns the raw JSON value of [completionTokens].
             *
             * Unlike [completionTokens], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("completion_tokens")
            @ExcludeMissing
            fun _completionTokens(): JsonField<Long> = completionTokens

            /**
             * Returns the raw JSON value of [promptTokens].
             *
             * Unlike [promptTokens], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("prompt_tokens")
            @ExcludeMissing
            fun _promptTokens(): JsonField<Long> = promptTokens

            /**
             * Returns the raw JSON value of [totalTokens].
             *
             * Unlike [totalTokens], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("total_tokens")
            @ExcludeMissing
            fun _totalTokens(): JsonField<Long> = totalTokens

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
                 * Returns a mutable builder for constructing an instance of [Usage].
                 *
                 * The following fields are required:
                 * ```java
                 * .cachedTokens()
                 * .completionTokens()
                 * .promptTokens()
                 * .totalTokens()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Usage]. */
            class Builder internal constructor() {

                private var cachedTokens: JsonField<Long>? = null
                private var completionTokens: JsonField<Long>? = null
                private var promptTokens: JsonField<Long>? = null
                private var totalTokens: JsonField<Long>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(usage: Usage) = apply {
                    cachedTokens = usage.cachedTokens
                    completionTokens = usage.completionTokens
                    promptTokens = usage.promptTokens
                    totalTokens = usage.totalTokens
                    additionalProperties = usage.additionalProperties.toMutableMap()
                }

                /** The number of tokens retrieved from cache. */
                fun cachedTokens(cachedTokens: Long) = cachedTokens(JsonField.of(cachedTokens))

                /**
                 * Sets [Builder.cachedTokens] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.cachedTokens] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun cachedTokens(cachedTokens: JsonField<Long>) = apply {
                    this.cachedTokens = cachedTokens
                }

                /** The number of completion tokens generated. */
                fun completionTokens(completionTokens: Long) =
                    completionTokens(JsonField.of(completionTokens))

                /**
                 * Sets [Builder.completionTokens] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.completionTokens] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun completionTokens(completionTokens: JsonField<Long>) = apply {
                    this.completionTokens = completionTokens
                }

                /** The number of prompt tokens used. */
                fun promptTokens(promptTokens: Long) = promptTokens(JsonField.of(promptTokens))

                /**
                 * Sets [Builder.promptTokens] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.promptTokens] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun promptTokens(promptTokens: JsonField<Long>) = apply {
                    this.promptTokens = promptTokens
                }

                /** The total number of tokens used. */
                fun totalTokens(totalTokens: Long) = totalTokens(JsonField.of(totalTokens))

                /**
                 * Sets [Builder.totalTokens] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.totalTokens] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun totalTokens(totalTokens: JsonField<Long>) = apply {
                    this.totalTokens = totalTokens
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
                 * Returns an immutable instance of [Usage].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .cachedTokens()
                 * .completionTokens()
                 * .promptTokens()
                 * .totalTokens()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Usage =
                    Usage(
                        checkRequired("cachedTokens", cachedTokens),
                        checkRequired("completionTokens", completionTokens),
                        checkRequired("promptTokens", promptTokens),
                        checkRequired("totalTokens", totalTokens),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Usage = apply {
                if (validated) {
                    return@apply
                }

                cachedTokens()
                completionTokens()
                promptTokens()
                totalTokens()
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
                (if (cachedTokens.asKnown().isPresent) 1 else 0) +
                    (if (completionTokens.asKnown().isPresent) 1 else 0) +
                    (if (promptTokens.asKnown().isPresent) 1 else 0) +
                    (if (totalTokens.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Usage && cachedTokens == other.cachedTokens && completionTokens == other.completionTokens && promptTokens == other.promptTokens && totalTokens == other.totalTokens && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(cachedTokens, completionTokens, promptTokens, totalTokens, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Usage{cachedTokens=$cachedTokens, completionTokens=$completionTokens, promptTokens=$promptTokens, totalTokens=$totalTokens, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Sample && error == other.error && finishReason == other.finishReason && input == other.input && maxCompletionTokens == other.maxCompletionTokens && model == other.model && output == other.output && seed == other.seed && temperature == other.temperature && topP == other.topP && usage == other.usage && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(error, finishReason, input, maxCompletionTokens, model, output, seed, temperature, topP, usage, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Sample{error=$error, finishReason=$finishReason, input=$input, maxCompletionTokens=$maxCompletionTokens, model=$model, output=$output, seed=$seed, temperature=$temperature, topP=$topP, usage=$usage, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is OutputItemListResponse && id == other.id && createdAt == other.createdAt && datasourceItem == other.datasourceItem && datasourceItemId == other.datasourceItemId && evalId == other.evalId && object_ == other.object_ && results == other.results && runId == other.runId && sample == other.sample && status == other.status && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, createdAt, datasourceItem, datasourceItemId, evalId, object_, results, runId, sample, status, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "OutputItemListResponse{id=$id, createdAt=$createdAt, datasourceItem=$datasourceItem, datasourceItemId=$datasourceItemId, evalId=$evalId, object_=$object_, results=$results, runId=$runId, sample=$sample, status=$status, additionalProperties=$additionalProperties}"
}
