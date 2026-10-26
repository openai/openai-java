// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.usage

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.collectAllProperties
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class UsageDecisionsResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val data: JsonField<List<Data>>,
    private val hasMore: JsonField<Boolean>,
    private val nextPage: JsonField<String>,
    private val object_: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("data") @ExcludeMissing data: JsonField<List<Data>> = JsonMissing.of(),
        @JsonProperty("has_more") @ExcludeMissing hasMore: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("next_page") @ExcludeMissing nextPage: JsonField<String> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
    ) : this(data, hasMore, nextPage, object_, mutableMapOf())

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun data(): List<Data> = data.getRequired("data")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun hasMore(): Boolean = hasMore.getRequired("has_more")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun nextPage(): Optional<String> = nextPage.getOptional("next_page")

    /**
     * Expected to always return the following:
     * ```java
     * JsonValue.from("page")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * Returns the raw JSON value of [data].
     *
     * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<List<Data>> = data

    /**
     * Returns the raw JSON value of [hasMore].
     *
     * Unlike [hasMore], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("has_more") @ExcludeMissing fun _hasMore(): JsonField<Boolean> = hasMore

    /**
     * Returns the raw JSON value of [nextPage].
     *
     * Unlike [nextPage], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("next_page") @ExcludeMissing fun _nextPage(): JsonField<String> = nextPage

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    /**
     * Returns an immutable snapshot of all present JSON properties, including declared and
     * additional properties.
     *
     * Keys use their JSON names. Declared properties take precedence over additional properties
     * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
     * values are preserved.
     */
    fun _allProperties(): Map<String, JsonValue> =
        collectAllProperties(
            additionalProperties,
            "data" to this.data,
            "has_more" to this.hasMore,
            "next_page" to this.nextPage,
            "object" to this.object_,
        )

    /**
     * Returns the legacy additional-properties view.
     *
     * @deprecated Use [_allProperties] to access both declared and additional JSON properties. This
     *   accessor retains its legacy additional-properties behavior.
     */
    @Deprecated("Use _allProperties() to access both declared and additional JSON properties.")
    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [UsageDecisionsResponse].
         *
         * The following fields are required:
         * ```java
         * .data()
         * .hasMore()
         * .nextPage()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UsageDecisionsResponse]. */
    class Builder internal constructor() {

        private var data: JsonField<MutableList<Data>>? = null
        private var hasMore: JsonField<Boolean>? = null
        private var nextPage: JsonField<String>? = null
        private var object_: JsonValue = JsonValue.from("page")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(usageDecisionsResponse: UsageDecisionsResponse) = apply {
            data = usageDecisionsResponse.data.map { it.toMutableList() }
            hasMore = usageDecisionsResponse.hasMore
            nextPage = usageDecisionsResponse.nextPage
            object_ = usageDecisionsResponse.object_
            additionalProperties = usageDecisionsResponse.additionalProperties.toMutableMap()
        }

        fun data(data: List<Data>) = data(JsonField.of(data))

        /**
         * Sets [Builder.data] to an arbitrary JSON value.
         *
         * You should usually call [Builder.data] with a well-typed `List<Data>` value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun data(data: JsonField<List<Data>>) = apply {
            this.data = data.map { it.toMutableList() }
        }

        /**
         * Adds a single [Data] to [Builder.data].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addData(data: Data) = apply {
            this.data =
                (this.data ?: JsonField.of(mutableListOf())).also {
                    checkKnown("data", it).add(data)
                }
        }

        fun hasMore(hasMore: Boolean) = hasMore(JsonField.of(hasMore))

        /**
         * Sets [Builder.hasMore] to an arbitrary JSON value.
         *
         * You should usually call [Builder.hasMore] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun hasMore(hasMore: JsonField<Boolean>) = apply { this.hasMore = hasMore }

        fun nextPage(nextPage: String?) = nextPage(JsonField.ofNullable(nextPage))

        /** Alias for calling [Builder.nextPage] with `nextPage.orElse(null)`. */
        fun nextPage(nextPage: Optional<String>) = nextPage(nextPage.getOrNull())

        /**
         * Sets [Builder.nextPage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.nextPage] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun nextPage(nextPage: JsonField<String>) = apply { this.nextPage = nextPage }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("page")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

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
         * Returns an immutable instance of [UsageDecisionsResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .data()
         * .hasMore()
         * .nextPage()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): UsageDecisionsResponse =
            UsageDecisionsResponse(
                checkRequired("data", data).map { it.toImmutable() },
                checkRequired("hasMore", hasMore),
                checkRequired("nextPage", nextPage),
                object_,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): UsageDecisionsResponse = apply {
        if (validated) {
            return@apply
        }

        data().forEach { it.validate() }
        hasMore()
        nextPage()
        _object_().let {
            if (it != JsonValue.from("page")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (data.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (hasMore.asKnown().isPresent) 1 else 0) +
            (if (nextPage.asKnown().isPresent) 1 else 0) +
            object_.let { if (it == JsonValue.from("page")) 1 else 0 }

    class Data
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val endTime: JsonField<Long>,
        private val object_: JsonValue,
        private val results: JsonField<List<Result>>,
        private val startTime: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("end_time") @ExcludeMissing endTime: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
            @JsonProperty("results")
            @ExcludeMissing
            results: JsonField<List<Result>> = JsonMissing.of(),
            @JsonProperty("start_time")
            @ExcludeMissing
            startTime: JsonField<Long> = JsonMissing.of(),
        ) : this(endTime, object_, results, startTime, mutableMapOf())

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun endTime(): Long = endTime.getRequired("end_time")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("bucket")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun results(): List<Result> = results.getRequired("results")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun startTime(): Long = startTime.getRequired("start_time")

        /**
         * Returns the raw JSON value of [endTime].
         *
         * Unlike [endTime], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("end_time") @ExcludeMissing fun _endTime(): JsonField<Long> = endTime

        /**
         * Returns the raw JSON value of [results].
         *
         * Unlike [results], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("results") @ExcludeMissing fun _results(): JsonField<List<Result>> = results

        /**
         * Returns the raw JSON value of [startTime].
         *
         * Unlike [startTime], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("start_time") @ExcludeMissing fun _startTime(): JsonField<Long> = startTime

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        /**
         * Returns an immutable snapshot of all present JSON properties, including declared and
         * additional properties.
         *
         * Keys use their JSON names. Declared properties take precedence over additional properties
         * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
         * values are preserved.
         */
        fun _allProperties(): Map<String, JsonValue> =
            collectAllProperties(
                additionalProperties,
                "end_time" to this.endTime,
                "object" to this.object_,
                "results" to this.results,
                "start_time" to this.startTime,
            )

        /**
         * Returns the legacy additional-properties view.
         *
         * @deprecated Use [_allProperties] to access both declared and additional JSON properties.
         *   This accessor retains its legacy additional-properties behavior.
         */
        @Deprecated("Use _allProperties() to access both declared and additional JSON properties.")
        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Data].
             *
             * The following fields are required:
             * ```java
             * .endTime()
             * .results()
             * .startTime()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Data]. */
        class Builder internal constructor() {

            private var endTime: JsonField<Long>? = null
            private var object_: JsonValue = JsonValue.from("bucket")
            private var results: JsonField<MutableList<Result>>? = null
            private var startTime: JsonField<Long>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(data: Data) = apply {
                endTime = data.endTime
                object_ = data.object_
                results = data.results.map { it.toMutableList() }
                startTime = data.startTime
                additionalProperties = data.additionalProperties.toMutableMap()
            }

            fun endTime(endTime: Long) = endTime(JsonField.of(endTime))

            /**
             * Sets [Builder.endTime] to an arbitrary JSON value.
             *
             * You should usually call [Builder.endTime] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun endTime(endTime: JsonField<Long>) = apply { this.endTime = endTime }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("bucket")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun object_(object_: JsonValue) = apply { this.object_ = object_ }

            fun results(results: List<Result>) = results(JsonField.of(results))

            /**
             * Sets [Builder.results] to an arbitrary JSON value.
             *
             * You should usually call [Builder.results] with a well-typed `List<Result>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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

            fun startTime(startTime: Long) = startTime(JsonField.of(startTime))

            /**
             * Sets [Builder.startTime] to an arbitrary JSON value.
             *
             * You should usually call [Builder.startTime] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun startTime(startTime: JsonField<Long>) = apply { this.startTime = startTime }

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
             * Returns an immutable instance of [Data].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .endTime()
             * .results()
             * .startTime()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Data =
                Data(
                    checkRequired("endTime", endTime),
                    object_,
                    checkRequired("results", results).map { it.toImmutable() },
                    checkRequired("startTime", startTime),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Data = apply {
            if (validated) {
                return@apply
            }

            endTime()
            _object_().let {
                if (it != JsonValue.from("bucket")) {
                    throw OpenAIInvalidDataException("'object_' is invalid, received $it")
                }
            }
            results().forEach { it.validate() }
            startTime()
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
            (if (endTime.asKnown().isPresent) 1 else 0) +
                object_.let { if (it == JsonValue.from("bucket")) 1 else 0 } +
                (results.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (startTime.asKnown().isPresent) 1 else 0)

        /** The aggregated Decisions API usage details of the specific time bucket. */
        class Result
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val inputTokens: JsonField<Long>,
            private val numModelRequests: JsonField<Long>,
            private val object_: JsonValue,
            private val outputTokens: JsonField<Long>,
            private val apiKeyId: JsonField<String>,
            private val apiSource: JsonField<ApiSource>,
            private val batch: JsonField<Boolean>,
            private val inputAudioTokens: JsonField<Long>,
            private val inputCacheWrite12hTokens: JsonField<Long>,
            private val inputCacheWrite30mTokens: JsonField<Long>,
            private val inputCacheWriteTokens: JsonField<Long>,
            private val inputCachedAudioTokens: JsonField<Long>,
            private val inputCachedImageTokens: JsonField<Long>,
            private val inputCachedTextTokens: JsonField<Long>,
            private val inputCachedTokens: JsonField<Long>,
            private val inputImageTokens: JsonField<Long>,
            private val inputTextTokens: JsonField<Long>,
            private val inputUncachedTokens: JsonField<Long>,
            private val model: JsonField<String>,
            private val outputAudioTokens: JsonField<Long>,
            private val outputImageTokens: JsonField<Long>,
            private val outputTextTokens: JsonField<Long>,
            private val projectId: JsonField<String>,
            private val serviceTier: JsonField<String>,
            private val userId: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("input_tokens")
                @ExcludeMissing
                inputTokens: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("num_model_requests")
                @ExcludeMissing
                numModelRequests: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
                @JsonProperty("output_tokens")
                @ExcludeMissing
                outputTokens: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("api_key_id")
                @ExcludeMissing
                apiKeyId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("api_source")
                @ExcludeMissing
                apiSource: JsonField<ApiSource> = JsonMissing.of(),
                @JsonProperty("batch") @ExcludeMissing batch: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("input_audio_tokens")
                @ExcludeMissing
                inputAudioTokens: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("input_cache_write_12h_tokens")
                @ExcludeMissing
                inputCacheWrite12hTokens: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("input_cache_write_30m_tokens")
                @ExcludeMissing
                inputCacheWrite30mTokens: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("input_cache_write_tokens")
                @ExcludeMissing
                inputCacheWriteTokens: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("input_cached_audio_tokens")
                @ExcludeMissing
                inputCachedAudioTokens: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("input_cached_image_tokens")
                @ExcludeMissing
                inputCachedImageTokens: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("input_cached_text_tokens")
                @ExcludeMissing
                inputCachedTextTokens: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("input_cached_tokens")
                @ExcludeMissing
                inputCachedTokens: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("input_image_tokens")
                @ExcludeMissing
                inputImageTokens: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("input_text_tokens")
                @ExcludeMissing
                inputTextTokens: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("input_uncached_tokens")
                @ExcludeMissing
                inputUncachedTokens: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("model") @ExcludeMissing model: JsonField<String> = JsonMissing.of(),
                @JsonProperty("output_audio_tokens")
                @ExcludeMissing
                outputAudioTokens: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("output_image_tokens")
                @ExcludeMissing
                outputImageTokens: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("output_text_tokens")
                @ExcludeMissing
                outputTextTokens: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("project_id")
                @ExcludeMissing
                projectId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("service_tier")
                @ExcludeMissing
                serviceTier: JsonField<String> = JsonMissing.of(),
                @JsonProperty("user_id")
                @ExcludeMissing
                userId: JsonField<String> = JsonMissing.of(),
            ) : this(
                inputTokens,
                numModelRequests,
                object_,
                outputTokens,
                apiKeyId,
                apiSource,
                batch,
                inputAudioTokens,
                inputCacheWrite12hTokens,
                inputCacheWrite30mTokens,
                inputCacheWriteTokens,
                inputCachedAudioTokens,
                inputCachedImageTokens,
                inputCachedTextTokens,
                inputCachedTokens,
                inputImageTokens,
                inputTextTokens,
                inputUncachedTokens,
                model,
                outputAudioTokens,
                outputImageTokens,
                outputTextTokens,
                projectId,
                serviceTier,
                userId,
                mutableMapOf(),
            )

            /**
             * The aggregated number of input tokens used, including cached and cache-write tokens.
             * This includes text, audio, and image tokens. For customers subscribed to Scale Tier,
             * this includes Scale Tier tokens.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun inputTokens(): Long = inputTokens.getRequired("input_tokens")

            /**
             * The count of requests made to the model.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun numModelRequests(): Long = numModelRequests.getRequired("num_model_requests")

            /**
             * Expected to always return the following:
             * ```java
             * JsonValue.from("organization.usage.decisions.result")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

            /**
             * The aggregated number of output tokens used across text, audio, and image outputs.
             * For customers subscribed to Scale Tier, this includes Scale Tier tokens.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun outputTokens(): Long = outputTokens.getRequired("output_tokens")

            /**
             * When `group_by=api_key_id`, this field provides the API key ID of the grouped usage
             * result.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun apiKeyId(): Optional<String> = apiKeyId.getOptional("api_key_id")

            /**
             * When grouped by `api_source`, `agents_api` identifies attributed Agents API activity
             * and `unlabeled` includes all records without published source attribution, including
             * historical and unknown origins. Unlabeled does not imply direct API usage. Without
             * source grouping, this field is null.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun apiSource(): Optional<ApiSource> = apiSource.getOptional("api_source")

            /**
             * When `group_by=batch`, this field tells whether the grouped usage result is batch or
             * not.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun batch(): Optional<Boolean> = batch.getOptional("batch")

            /**
             * The aggregated number of uncached audio input tokens used.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun inputAudioTokens(): Optional<Long> =
                inputAudioTokens.getOptional("input_audio_tokens")

            /**
             * The aggregated number of input tokens written to the cache with a 12-hour retention
             * period.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun inputCacheWrite12hTokens(): Optional<Long> =
                inputCacheWrite12hTokens.getOptional("input_cache_write_12h_tokens")

            /**
             * The aggregated number of input tokens written to the cache with a 30-minute retention
             * period.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun inputCacheWrite30mTokens(): Optional<Long> =
                inputCacheWrite30mTokens.getOptional("input_cache_write_30m_tokens")

            /**
             * The aggregated number of input tokens written to the cache across 30-minute and
             * 12-hour retention periods.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun inputCacheWriteTokens(): Optional<Long> =
                inputCacheWriteTokens.getOptional("input_cache_write_tokens")

            /**
             * The aggregated number of cached audio input tokens used.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun inputCachedAudioTokens(): Optional<Long> =
                inputCachedAudioTokens.getOptional("input_cached_audio_tokens")

            /**
             * The aggregated number of cached image input tokens used.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun inputCachedImageTokens(): Optional<Long> =
                inputCachedImageTokens.getOptional("input_cached_image_tokens")

            /**
             * The aggregated number of cached text input tokens used.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun inputCachedTextTokens(): Optional<Long> =
                inputCachedTextTokens.getOptional("input_cached_text_tokens")

            /**
             * The aggregated number of cached input tokens used across text, audio, and image
             * inputs. For customers subscribed to Scale Tier, this includes Scale Tier tokens.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun inputCachedTokens(): Optional<Long> =
                inputCachedTokens.getOptional("input_cached_tokens")

            /**
             * The aggregated number of uncached image input tokens used.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun inputImageTokens(): Optional<Long> =
                inputImageTokens.getOptional("input_image_tokens")

            /**
             * The aggregated number of uncached text input tokens used, excluding cache-write
             * tokens.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun inputTextTokens(): Optional<Long> = inputTextTokens.getOptional("input_text_tokens")

            /**
             * The aggregated number of uncached input tokens used across text, audio, and image
             * inputs, excluding cache-write tokens.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun inputUncachedTokens(): Optional<Long> =
                inputUncachedTokens.getOptional("input_uncached_tokens")

            /**
             * When `group_by=model`, this field provides the model name of the grouped usage
             * result.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun model(): Optional<String> = model.getOptional("model")

            /**
             * The aggregated number of audio output tokens used.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun outputAudioTokens(): Optional<Long> =
                outputAudioTokens.getOptional("output_audio_tokens")

            /**
             * The aggregated number of image output tokens used.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun outputImageTokens(): Optional<Long> =
                outputImageTokens.getOptional("output_image_tokens")

            /**
             * The aggregated number of text output tokens used.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun outputTextTokens(): Optional<Long> =
                outputTextTokens.getOptional("output_text_tokens")

            /**
             * When `group_by=project_id`, this field provides the project ID of the grouped usage
             * result.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun projectId(): Optional<String> = projectId.getOptional("project_id")

            /**
             * When `group_by=service_tier`, this field provides the service tier of the grouped
             * usage result.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun serviceTier(): Optional<String> = serviceTier.getOptional("service_tier")

            /**
             * When `group_by=user_id`, this field provides the user ID of the grouped usage result.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun userId(): Optional<String> = userId.getOptional("user_id")

            /**
             * Returns the raw JSON value of [inputTokens].
             *
             * Unlike [inputTokens], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("input_tokens")
            @ExcludeMissing
            fun _inputTokens(): JsonField<Long> = inputTokens

            /**
             * Returns the raw JSON value of [numModelRequests].
             *
             * Unlike [numModelRequests], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("num_model_requests")
            @ExcludeMissing
            fun _numModelRequests(): JsonField<Long> = numModelRequests

            /**
             * Returns the raw JSON value of [outputTokens].
             *
             * Unlike [outputTokens], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("output_tokens")
            @ExcludeMissing
            fun _outputTokens(): JsonField<Long> = outputTokens

            /**
             * Returns the raw JSON value of [apiKeyId].
             *
             * Unlike [apiKeyId], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("api_key_id")
            @ExcludeMissing
            fun _apiKeyId(): JsonField<String> = apiKeyId

            /**
             * Returns the raw JSON value of [apiSource].
             *
             * Unlike [apiSource], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("api_source")
            @ExcludeMissing
            fun _apiSource(): JsonField<ApiSource> = apiSource

            /**
             * Returns the raw JSON value of [batch].
             *
             * Unlike [batch], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("batch") @ExcludeMissing fun _batch(): JsonField<Boolean> = batch

            /**
             * Returns the raw JSON value of [inputAudioTokens].
             *
             * Unlike [inputAudioTokens], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("input_audio_tokens")
            @ExcludeMissing
            fun _inputAudioTokens(): JsonField<Long> = inputAudioTokens

            /**
             * Returns the raw JSON value of [inputCacheWrite12hTokens].
             *
             * Unlike [inputCacheWrite12hTokens], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("input_cache_write_12h_tokens")
            @ExcludeMissing
            fun _inputCacheWrite12hTokens(): JsonField<Long> = inputCacheWrite12hTokens

            /**
             * Returns the raw JSON value of [inputCacheWrite30mTokens].
             *
             * Unlike [inputCacheWrite30mTokens], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("input_cache_write_30m_tokens")
            @ExcludeMissing
            fun _inputCacheWrite30mTokens(): JsonField<Long> = inputCacheWrite30mTokens

            /**
             * Returns the raw JSON value of [inputCacheWriteTokens].
             *
             * Unlike [inputCacheWriteTokens], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("input_cache_write_tokens")
            @ExcludeMissing
            fun _inputCacheWriteTokens(): JsonField<Long> = inputCacheWriteTokens

            /**
             * Returns the raw JSON value of [inputCachedAudioTokens].
             *
             * Unlike [inputCachedAudioTokens], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("input_cached_audio_tokens")
            @ExcludeMissing
            fun _inputCachedAudioTokens(): JsonField<Long> = inputCachedAudioTokens

            /**
             * Returns the raw JSON value of [inputCachedImageTokens].
             *
             * Unlike [inputCachedImageTokens], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("input_cached_image_tokens")
            @ExcludeMissing
            fun _inputCachedImageTokens(): JsonField<Long> = inputCachedImageTokens

            /**
             * Returns the raw JSON value of [inputCachedTextTokens].
             *
             * Unlike [inputCachedTextTokens], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("input_cached_text_tokens")
            @ExcludeMissing
            fun _inputCachedTextTokens(): JsonField<Long> = inputCachedTextTokens

            /**
             * Returns the raw JSON value of [inputCachedTokens].
             *
             * Unlike [inputCachedTokens], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("input_cached_tokens")
            @ExcludeMissing
            fun _inputCachedTokens(): JsonField<Long> = inputCachedTokens

            /**
             * Returns the raw JSON value of [inputImageTokens].
             *
             * Unlike [inputImageTokens], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("input_image_tokens")
            @ExcludeMissing
            fun _inputImageTokens(): JsonField<Long> = inputImageTokens

            /**
             * Returns the raw JSON value of [inputTextTokens].
             *
             * Unlike [inputTextTokens], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("input_text_tokens")
            @ExcludeMissing
            fun _inputTextTokens(): JsonField<Long> = inputTextTokens

            /**
             * Returns the raw JSON value of [inputUncachedTokens].
             *
             * Unlike [inputUncachedTokens], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("input_uncached_tokens")
            @ExcludeMissing
            fun _inputUncachedTokens(): JsonField<Long> = inputUncachedTokens

            /**
             * Returns the raw JSON value of [model].
             *
             * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

            /**
             * Returns the raw JSON value of [outputAudioTokens].
             *
             * Unlike [outputAudioTokens], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("output_audio_tokens")
            @ExcludeMissing
            fun _outputAudioTokens(): JsonField<Long> = outputAudioTokens

            /**
             * Returns the raw JSON value of [outputImageTokens].
             *
             * Unlike [outputImageTokens], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("output_image_tokens")
            @ExcludeMissing
            fun _outputImageTokens(): JsonField<Long> = outputImageTokens

            /**
             * Returns the raw JSON value of [outputTextTokens].
             *
             * Unlike [outputTextTokens], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("output_text_tokens")
            @ExcludeMissing
            fun _outputTextTokens(): JsonField<Long> = outputTextTokens

            /**
             * Returns the raw JSON value of [projectId].
             *
             * Unlike [projectId], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("project_id")
            @ExcludeMissing
            fun _projectId(): JsonField<String> = projectId

            /**
             * Returns the raw JSON value of [serviceTier].
             *
             * Unlike [serviceTier], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("service_tier")
            @ExcludeMissing
            fun _serviceTier(): JsonField<String> = serviceTier

            /**
             * Returns the raw JSON value of [userId].
             *
             * Unlike [userId], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("user_id") @ExcludeMissing fun _userId(): JsonField<String> = userId

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            /**
             * Returns an immutable snapshot of all present JSON properties, including declared and
             * additional properties.
             *
             * Keys use their JSON names. Declared properties take precedence over additional
             * properties with the same name. Missing properties are omitted, while explicit nulls
             * and unrecognized values are preserved.
             */
            fun _allProperties(): Map<String, JsonValue> =
                collectAllProperties(
                    additionalProperties,
                    "input_tokens" to this.inputTokens,
                    "num_model_requests" to this.numModelRequests,
                    "object" to this.object_,
                    "output_tokens" to this.outputTokens,
                    "api_key_id" to this.apiKeyId,
                    "api_source" to this.apiSource,
                    "batch" to this.batch,
                    "input_audio_tokens" to this.inputAudioTokens,
                    "input_cache_write_12h_tokens" to this.inputCacheWrite12hTokens,
                    "input_cache_write_30m_tokens" to this.inputCacheWrite30mTokens,
                    "input_cache_write_tokens" to this.inputCacheWriteTokens,
                    "input_cached_audio_tokens" to this.inputCachedAudioTokens,
                    "input_cached_image_tokens" to this.inputCachedImageTokens,
                    "input_cached_text_tokens" to this.inputCachedTextTokens,
                    "input_cached_tokens" to this.inputCachedTokens,
                    "input_image_tokens" to this.inputImageTokens,
                    "input_text_tokens" to this.inputTextTokens,
                    "input_uncached_tokens" to this.inputUncachedTokens,
                    "model" to this.model,
                    "output_audio_tokens" to this.outputAudioTokens,
                    "output_image_tokens" to this.outputImageTokens,
                    "output_text_tokens" to this.outputTextTokens,
                    "project_id" to this.projectId,
                    "service_tier" to this.serviceTier,
                    "user_id" to this.userId,
                )

            /**
             * Returns the legacy additional-properties view.
             *
             * @deprecated Use [_allProperties] to access both declared and additional JSON
             *   properties. This accessor retains its legacy additional-properties behavior.
             */
            @Deprecated(
                "Use _allProperties() to access both declared and additional JSON properties."
            )
            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Result].
                 *
                 * The following fields are required:
                 * ```java
                 * .inputTokens()
                 * .numModelRequests()
                 * .outputTokens()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Result]. */
            class Builder internal constructor() {

                private var inputTokens: JsonField<Long>? = null
                private var numModelRequests: JsonField<Long>? = null
                private var object_: JsonValue =
                    JsonValue.from("organization.usage.decisions.result")
                private var outputTokens: JsonField<Long>? = null
                private var apiKeyId: JsonField<String> = JsonMissing.of()
                private var apiSource: JsonField<ApiSource> = JsonMissing.of()
                private var batch: JsonField<Boolean> = JsonMissing.of()
                private var inputAudioTokens: JsonField<Long> = JsonMissing.of()
                private var inputCacheWrite12hTokens: JsonField<Long> = JsonMissing.of()
                private var inputCacheWrite30mTokens: JsonField<Long> = JsonMissing.of()
                private var inputCacheWriteTokens: JsonField<Long> = JsonMissing.of()
                private var inputCachedAudioTokens: JsonField<Long> = JsonMissing.of()
                private var inputCachedImageTokens: JsonField<Long> = JsonMissing.of()
                private var inputCachedTextTokens: JsonField<Long> = JsonMissing.of()
                private var inputCachedTokens: JsonField<Long> = JsonMissing.of()
                private var inputImageTokens: JsonField<Long> = JsonMissing.of()
                private var inputTextTokens: JsonField<Long> = JsonMissing.of()
                private var inputUncachedTokens: JsonField<Long> = JsonMissing.of()
                private var model: JsonField<String> = JsonMissing.of()
                private var outputAudioTokens: JsonField<Long> = JsonMissing.of()
                private var outputImageTokens: JsonField<Long> = JsonMissing.of()
                private var outputTextTokens: JsonField<Long> = JsonMissing.of()
                private var projectId: JsonField<String> = JsonMissing.of()
                private var serviceTier: JsonField<String> = JsonMissing.of()
                private var userId: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(result: Result) = apply {
                    inputTokens = result.inputTokens
                    numModelRequests = result.numModelRequests
                    object_ = result.object_
                    outputTokens = result.outputTokens
                    apiKeyId = result.apiKeyId
                    apiSource = result.apiSource
                    batch = result.batch
                    inputAudioTokens = result.inputAudioTokens
                    inputCacheWrite12hTokens = result.inputCacheWrite12hTokens
                    inputCacheWrite30mTokens = result.inputCacheWrite30mTokens
                    inputCacheWriteTokens = result.inputCacheWriteTokens
                    inputCachedAudioTokens = result.inputCachedAudioTokens
                    inputCachedImageTokens = result.inputCachedImageTokens
                    inputCachedTextTokens = result.inputCachedTextTokens
                    inputCachedTokens = result.inputCachedTokens
                    inputImageTokens = result.inputImageTokens
                    inputTextTokens = result.inputTextTokens
                    inputUncachedTokens = result.inputUncachedTokens
                    model = result.model
                    outputAudioTokens = result.outputAudioTokens
                    outputImageTokens = result.outputImageTokens
                    outputTextTokens = result.outputTextTokens
                    projectId = result.projectId
                    serviceTier = result.serviceTier
                    userId = result.userId
                    additionalProperties = result.additionalProperties.toMutableMap()
                }

                /**
                 * The aggregated number of input tokens used, including cached and cache-write
                 * tokens. This includes text, audio, and image tokens. For customers subscribed to
                 * Scale Tier, this includes Scale Tier tokens.
                 */
                fun inputTokens(inputTokens: Long) = inputTokens(JsonField.of(inputTokens))

                /**
                 * Sets [Builder.inputTokens] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.inputTokens] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun inputTokens(inputTokens: JsonField<Long>) = apply {
                    this.inputTokens = inputTokens
                }

                /** The count of requests made to the model. */
                fun numModelRequests(numModelRequests: Long) =
                    numModelRequests(JsonField.of(numModelRequests))

                /**
                 * Sets [Builder.numModelRequests] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.numModelRequests] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun numModelRequests(numModelRequests: JsonField<Long>) = apply {
                    this.numModelRequests = numModelRequests
                }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("organization.usage.decisions.result")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun object_(object_: JsonValue) = apply { this.object_ = object_ }

                /**
                 * The aggregated number of output tokens used across text, audio, and image
                 * outputs. For customers subscribed to Scale Tier, this includes Scale Tier tokens.
                 */
                fun outputTokens(outputTokens: Long) = outputTokens(JsonField.of(outputTokens))

                /**
                 * Sets [Builder.outputTokens] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.outputTokens] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun outputTokens(outputTokens: JsonField<Long>) = apply {
                    this.outputTokens = outputTokens
                }

                /**
                 * When `group_by=api_key_id`, this field provides the API key ID of the grouped
                 * usage result.
                 */
                fun apiKeyId(apiKeyId: String?) = apiKeyId(JsonField.ofNullable(apiKeyId))

                /** Alias for calling [Builder.apiKeyId] with `apiKeyId.orElse(null)`. */
                fun apiKeyId(apiKeyId: Optional<String>) = apiKeyId(apiKeyId.getOrNull())

                /**
                 * Sets [Builder.apiKeyId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.apiKeyId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun apiKeyId(apiKeyId: JsonField<String>) = apply { this.apiKeyId = apiKeyId }

                /**
                 * When grouped by `api_source`, `agents_api` identifies attributed Agents API
                 * activity and `unlabeled` includes all records without published source
                 * attribution, including historical and unknown origins. Unlabeled does not imply
                 * direct API usage. Without source grouping, this field is null.
                 */
                fun apiSource(apiSource: ApiSource?) = apiSource(JsonField.ofNullable(apiSource))

                /** Alias for calling [Builder.apiSource] with `apiSource.orElse(null)`. */
                fun apiSource(apiSource: Optional<ApiSource>) = apiSource(apiSource.getOrNull())

                /**
                 * Sets [Builder.apiSource] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.apiSource] with a well-typed [ApiSource] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun apiSource(apiSource: JsonField<ApiSource>) = apply {
                    this.apiSource = apiSource
                }

                /**
                 * When `group_by=batch`, this field tells whether the grouped usage result is batch
                 * or not.
                 */
                fun batch(batch: Boolean?) = batch(JsonField.ofNullable(batch))

                /**
                 * Alias for [Builder.batch].
                 *
                 * This unboxed primitive overload exists for backwards compatibility.
                 */
                fun batch(batch: Boolean) = batch(batch as Boolean?)

                /** Alias for calling [Builder.batch] with `batch.orElse(null)`. */
                fun batch(batch: Optional<Boolean>) = batch(batch.getOrNull())

                /**
                 * Sets [Builder.batch] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.batch] with a well-typed [Boolean] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun batch(batch: JsonField<Boolean>) = apply { this.batch = batch }

                /** The aggregated number of uncached audio input tokens used. */
                fun inputAudioTokens(inputAudioTokens: Long?) =
                    inputAudioTokens(JsonField.ofNullable(inputAudioTokens))

                /**
                 * Alias for [Builder.inputAudioTokens].
                 *
                 * This unboxed primitive overload exists for backwards compatibility.
                 */
                fun inputAudioTokens(inputAudioTokens: Long) =
                    inputAudioTokens(inputAudioTokens as Long?)

                /**
                 * Alias for calling [Builder.inputAudioTokens] with
                 * `inputAudioTokens.orElse(null)`.
                 */
                fun inputAudioTokens(inputAudioTokens: Optional<Long>) =
                    inputAudioTokens(inputAudioTokens.getOrNull())

                /**
                 * Sets [Builder.inputAudioTokens] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.inputAudioTokens] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun inputAudioTokens(inputAudioTokens: JsonField<Long>) = apply {
                    this.inputAudioTokens = inputAudioTokens
                }

                /**
                 * The aggregated number of input tokens written to the cache with a 12-hour
                 * retention period.
                 */
                fun inputCacheWrite12hTokens(inputCacheWrite12hTokens: Long?) =
                    inputCacheWrite12hTokens(JsonField.ofNullable(inputCacheWrite12hTokens))

                /**
                 * Alias for [Builder.inputCacheWrite12hTokens].
                 *
                 * This unboxed primitive overload exists for backwards compatibility.
                 */
                fun inputCacheWrite12hTokens(inputCacheWrite12hTokens: Long) =
                    inputCacheWrite12hTokens(inputCacheWrite12hTokens as Long?)

                /**
                 * Alias for calling [Builder.inputCacheWrite12hTokens] with
                 * `inputCacheWrite12hTokens.orElse(null)`.
                 */
                fun inputCacheWrite12hTokens(inputCacheWrite12hTokens: Optional<Long>) =
                    inputCacheWrite12hTokens(inputCacheWrite12hTokens.getOrNull())

                /**
                 * Sets [Builder.inputCacheWrite12hTokens] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.inputCacheWrite12hTokens] with a well-typed
                 * [Long] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun inputCacheWrite12hTokens(inputCacheWrite12hTokens: JsonField<Long>) = apply {
                    this.inputCacheWrite12hTokens = inputCacheWrite12hTokens
                }

                /**
                 * The aggregated number of input tokens written to the cache with a 30-minute
                 * retention period.
                 */
                fun inputCacheWrite30mTokens(inputCacheWrite30mTokens: Long?) =
                    inputCacheWrite30mTokens(JsonField.ofNullable(inputCacheWrite30mTokens))

                /**
                 * Alias for [Builder.inputCacheWrite30mTokens].
                 *
                 * This unboxed primitive overload exists for backwards compatibility.
                 */
                fun inputCacheWrite30mTokens(inputCacheWrite30mTokens: Long) =
                    inputCacheWrite30mTokens(inputCacheWrite30mTokens as Long?)

                /**
                 * Alias for calling [Builder.inputCacheWrite30mTokens] with
                 * `inputCacheWrite30mTokens.orElse(null)`.
                 */
                fun inputCacheWrite30mTokens(inputCacheWrite30mTokens: Optional<Long>) =
                    inputCacheWrite30mTokens(inputCacheWrite30mTokens.getOrNull())

                /**
                 * Sets [Builder.inputCacheWrite30mTokens] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.inputCacheWrite30mTokens] with a well-typed
                 * [Long] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun inputCacheWrite30mTokens(inputCacheWrite30mTokens: JsonField<Long>) = apply {
                    this.inputCacheWrite30mTokens = inputCacheWrite30mTokens
                }

                /**
                 * The aggregated number of input tokens written to the cache across 30-minute and
                 * 12-hour retention periods.
                 */
                fun inputCacheWriteTokens(inputCacheWriteTokens: Long?) =
                    inputCacheWriteTokens(JsonField.ofNullable(inputCacheWriteTokens))

                /**
                 * Alias for [Builder.inputCacheWriteTokens].
                 *
                 * This unboxed primitive overload exists for backwards compatibility.
                 */
                fun inputCacheWriteTokens(inputCacheWriteTokens: Long) =
                    inputCacheWriteTokens(inputCacheWriteTokens as Long?)

                /**
                 * Alias for calling [Builder.inputCacheWriteTokens] with
                 * `inputCacheWriteTokens.orElse(null)`.
                 */
                fun inputCacheWriteTokens(inputCacheWriteTokens: Optional<Long>) =
                    inputCacheWriteTokens(inputCacheWriteTokens.getOrNull())

                /**
                 * Sets [Builder.inputCacheWriteTokens] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.inputCacheWriteTokens] with a well-typed [Long]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun inputCacheWriteTokens(inputCacheWriteTokens: JsonField<Long>) = apply {
                    this.inputCacheWriteTokens = inputCacheWriteTokens
                }

                /** The aggregated number of cached audio input tokens used. */
                fun inputCachedAudioTokens(inputCachedAudioTokens: Long?) =
                    inputCachedAudioTokens(JsonField.ofNullable(inputCachedAudioTokens))

                /**
                 * Alias for [Builder.inputCachedAudioTokens].
                 *
                 * This unboxed primitive overload exists for backwards compatibility.
                 */
                fun inputCachedAudioTokens(inputCachedAudioTokens: Long) =
                    inputCachedAudioTokens(inputCachedAudioTokens as Long?)

                /**
                 * Alias for calling [Builder.inputCachedAudioTokens] with
                 * `inputCachedAudioTokens.orElse(null)`.
                 */
                fun inputCachedAudioTokens(inputCachedAudioTokens: Optional<Long>) =
                    inputCachedAudioTokens(inputCachedAudioTokens.getOrNull())

                /**
                 * Sets [Builder.inputCachedAudioTokens] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.inputCachedAudioTokens] with a well-typed [Long]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun inputCachedAudioTokens(inputCachedAudioTokens: JsonField<Long>) = apply {
                    this.inputCachedAudioTokens = inputCachedAudioTokens
                }

                /** The aggregated number of cached image input tokens used. */
                fun inputCachedImageTokens(inputCachedImageTokens: Long?) =
                    inputCachedImageTokens(JsonField.ofNullable(inputCachedImageTokens))

                /**
                 * Alias for [Builder.inputCachedImageTokens].
                 *
                 * This unboxed primitive overload exists for backwards compatibility.
                 */
                fun inputCachedImageTokens(inputCachedImageTokens: Long) =
                    inputCachedImageTokens(inputCachedImageTokens as Long?)

                /**
                 * Alias for calling [Builder.inputCachedImageTokens] with
                 * `inputCachedImageTokens.orElse(null)`.
                 */
                fun inputCachedImageTokens(inputCachedImageTokens: Optional<Long>) =
                    inputCachedImageTokens(inputCachedImageTokens.getOrNull())

                /**
                 * Sets [Builder.inputCachedImageTokens] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.inputCachedImageTokens] with a well-typed [Long]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun inputCachedImageTokens(inputCachedImageTokens: JsonField<Long>) = apply {
                    this.inputCachedImageTokens = inputCachedImageTokens
                }

                /** The aggregated number of cached text input tokens used. */
                fun inputCachedTextTokens(inputCachedTextTokens: Long?) =
                    inputCachedTextTokens(JsonField.ofNullable(inputCachedTextTokens))

                /**
                 * Alias for [Builder.inputCachedTextTokens].
                 *
                 * This unboxed primitive overload exists for backwards compatibility.
                 */
                fun inputCachedTextTokens(inputCachedTextTokens: Long) =
                    inputCachedTextTokens(inputCachedTextTokens as Long?)

                /**
                 * Alias for calling [Builder.inputCachedTextTokens] with
                 * `inputCachedTextTokens.orElse(null)`.
                 */
                fun inputCachedTextTokens(inputCachedTextTokens: Optional<Long>) =
                    inputCachedTextTokens(inputCachedTextTokens.getOrNull())

                /**
                 * Sets [Builder.inputCachedTextTokens] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.inputCachedTextTokens] with a well-typed [Long]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun inputCachedTextTokens(inputCachedTextTokens: JsonField<Long>) = apply {
                    this.inputCachedTextTokens = inputCachedTextTokens
                }

                /**
                 * The aggregated number of cached input tokens used across text, audio, and image
                 * inputs. For customers subscribed to Scale Tier, this includes Scale Tier tokens.
                 */
                fun inputCachedTokens(inputCachedTokens: Long?) =
                    inputCachedTokens(JsonField.ofNullable(inputCachedTokens))

                /**
                 * Alias for [Builder.inputCachedTokens].
                 *
                 * This unboxed primitive overload exists for backwards compatibility.
                 */
                fun inputCachedTokens(inputCachedTokens: Long) =
                    inputCachedTokens(inputCachedTokens as Long?)

                /**
                 * Alias for calling [Builder.inputCachedTokens] with
                 * `inputCachedTokens.orElse(null)`.
                 */
                fun inputCachedTokens(inputCachedTokens: Optional<Long>) =
                    inputCachedTokens(inputCachedTokens.getOrNull())

                /**
                 * Sets [Builder.inputCachedTokens] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.inputCachedTokens] with a well-typed [Long]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun inputCachedTokens(inputCachedTokens: JsonField<Long>) = apply {
                    this.inputCachedTokens = inputCachedTokens
                }

                /** The aggregated number of uncached image input tokens used. */
                fun inputImageTokens(inputImageTokens: Long?) =
                    inputImageTokens(JsonField.ofNullable(inputImageTokens))

                /**
                 * Alias for [Builder.inputImageTokens].
                 *
                 * This unboxed primitive overload exists for backwards compatibility.
                 */
                fun inputImageTokens(inputImageTokens: Long) =
                    inputImageTokens(inputImageTokens as Long?)

                /**
                 * Alias for calling [Builder.inputImageTokens] with
                 * `inputImageTokens.orElse(null)`.
                 */
                fun inputImageTokens(inputImageTokens: Optional<Long>) =
                    inputImageTokens(inputImageTokens.getOrNull())

                /**
                 * Sets [Builder.inputImageTokens] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.inputImageTokens] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun inputImageTokens(inputImageTokens: JsonField<Long>) = apply {
                    this.inputImageTokens = inputImageTokens
                }

                /**
                 * The aggregated number of uncached text input tokens used, excluding cache-write
                 * tokens.
                 */
                fun inputTextTokens(inputTextTokens: Long?) =
                    inputTextTokens(JsonField.ofNullable(inputTextTokens))

                /**
                 * Alias for [Builder.inputTextTokens].
                 *
                 * This unboxed primitive overload exists for backwards compatibility.
                 */
                fun inputTextTokens(inputTextTokens: Long) =
                    inputTextTokens(inputTextTokens as Long?)

                /**
                 * Alias for calling [Builder.inputTextTokens] with `inputTextTokens.orElse(null)`.
                 */
                fun inputTextTokens(inputTextTokens: Optional<Long>) =
                    inputTextTokens(inputTextTokens.getOrNull())

                /**
                 * Sets [Builder.inputTextTokens] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.inputTextTokens] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun inputTextTokens(inputTextTokens: JsonField<Long>) = apply {
                    this.inputTextTokens = inputTextTokens
                }

                /**
                 * The aggregated number of uncached input tokens used across text, audio, and image
                 * inputs, excluding cache-write tokens.
                 */
                fun inputUncachedTokens(inputUncachedTokens: Long?) =
                    inputUncachedTokens(JsonField.ofNullable(inputUncachedTokens))

                /**
                 * Alias for [Builder.inputUncachedTokens].
                 *
                 * This unboxed primitive overload exists for backwards compatibility.
                 */
                fun inputUncachedTokens(inputUncachedTokens: Long) =
                    inputUncachedTokens(inputUncachedTokens as Long?)

                /**
                 * Alias for calling [Builder.inputUncachedTokens] with
                 * `inputUncachedTokens.orElse(null)`.
                 */
                fun inputUncachedTokens(inputUncachedTokens: Optional<Long>) =
                    inputUncachedTokens(inputUncachedTokens.getOrNull())

                /**
                 * Sets [Builder.inputUncachedTokens] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.inputUncachedTokens] with a well-typed [Long]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun inputUncachedTokens(inputUncachedTokens: JsonField<Long>) = apply {
                    this.inputUncachedTokens = inputUncachedTokens
                }

                /**
                 * When `group_by=model`, this field provides the model name of the grouped usage
                 * result.
                 */
                fun model(model: String?) = model(JsonField.ofNullable(model))

                /** Alias for calling [Builder.model] with `model.orElse(null)`. */
                fun model(model: Optional<String>) = model(model.getOrNull())

                /**
                 * Sets [Builder.model] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.model] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun model(model: JsonField<String>) = apply { this.model = model }

                /** The aggregated number of audio output tokens used. */
                fun outputAudioTokens(outputAudioTokens: Long?) =
                    outputAudioTokens(JsonField.ofNullable(outputAudioTokens))

                /**
                 * Alias for [Builder.outputAudioTokens].
                 *
                 * This unboxed primitive overload exists for backwards compatibility.
                 */
                fun outputAudioTokens(outputAudioTokens: Long) =
                    outputAudioTokens(outputAudioTokens as Long?)

                /**
                 * Alias for calling [Builder.outputAudioTokens] with
                 * `outputAudioTokens.orElse(null)`.
                 */
                fun outputAudioTokens(outputAudioTokens: Optional<Long>) =
                    outputAudioTokens(outputAudioTokens.getOrNull())

                /**
                 * Sets [Builder.outputAudioTokens] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.outputAudioTokens] with a well-typed [Long]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun outputAudioTokens(outputAudioTokens: JsonField<Long>) = apply {
                    this.outputAudioTokens = outputAudioTokens
                }

                /** The aggregated number of image output tokens used. */
                fun outputImageTokens(outputImageTokens: Long?) =
                    outputImageTokens(JsonField.ofNullable(outputImageTokens))

                /**
                 * Alias for [Builder.outputImageTokens].
                 *
                 * This unboxed primitive overload exists for backwards compatibility.
                 */
                fun outputImageTokens(outputImageTokens: Long) =
                    outputImageTokens(outputImageTokens as Long?)

                /**
                 * Alias for calling [Builder.outputImageTokens] with
                 * `outputImageTokens.orElse(null)`.
                 */
                fun outputImageTokens(outputImageTokens: Optional<Long>) =
                    outputImageTokens(outputImageTokens.getOrNull())

                /**
                 * Sets [Builder.outputImageTokens] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.outputImageTokens] with a well-typed [Long]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun outputImageTokens(outputImageTokens: JsonField<Long>) = apply {
                    this.outputImageTokens = outputImageTokens
                }

                /** The aggregated number of text output tokens used. */
                fun outputTextTokens(outputTextTokens: Long?) =
                    outputTextTokens(JsonField.ofNullable(outputTextTokens))

                /**
                 * Alias for [Builder.outputTextTokens].
                 *
                 * This unboxed primitive overload exists for backwards compatibility.
                 */
                fun outputTextTokens(outputTextTokens: Long) =
                    outputTextTokens(outputTextTokens as Long?)

                /**
                 * Alias for calling [Builder.outputTextTokens] with
                 * `outputTextTokens.orElse(null)`.
                 */
                fun outputTextTokens(outputTextTokens: Optional<Long>) =
                    outputTextTokens(outputTextTokens.getOrNull())

                /**
                 * Sets [Builder.outputTextTokens] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.outputTextTokens] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun outputTextTokens(outputTextTokens: JsonField<Long>) = apply {
                    this.outputTextTokens = outputTextTokens
                }

                /**
                 * When `group_by=project_id`, this field provides the project ID of the grouped
                 * usage result.
                 */
                fun projectId(projectId: String?) = projectId(JsonField.ofNullable(projectId))

                /** Alias for calling [Builder.projectId] with `projectId.orElse(null)`. */
                fun projectId(projectId: Optional<String>) = projectId(projectId.getOrNull())

                /**
                 * Sets [Builder.projectId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.projectId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun projectId(projectId: JsonField<String>) = apply { this.projectId = projectId }

                /**
                 * When `group_by=service_tier`, this field provides the service tier of the grouped
                 * usage result.
                 */
                fun serviceTier(serviceTier: String?) =
                    serviceTier(JsonField.ofNullable(serviceTier))

                /** Alias for calling [Builder.serviceTier] with `serviceTier.orElse(null)`. */
                fun serviceTier(serviceTier: Optional<String>) =
                    serviceTier(serviceTier.getOrNull())

                /**
                 * Sets [Builder.serviceTier] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.serviceTier] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun serviceTier(serviceTier: JsonField<String>) = apply {
                    this.serviceTier = serviceTier
                }

                /**
                 * When `group_by=user_id`, this field provides the user ID of the grouped usage
                 * result.
                 */
                fun userId(userId: String?) = userId(JsonField.ofNullable(userId))

                /** Alias for calling [Builder.userId] with `userId.orElse(null)`. */
                fun userId(userId: Optional<String>) = userId(userId.getOrNull())

                /**
                 * Sets [Builder.userId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.userId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun userId(userId: JsonField<String>) = apply { this.userId = userId }

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
                 * Returns an immutable instance of [Result].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .inputTokens()
                 * .numModelRequests()
                 * .outputTokens()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Result =
                    Result(
                        checkRequired("inputTokens", inputTokens),
                        checkRequired("numModelRequests", numModelRequests),
                        object_,
                        checkRequired("outputTokens", outputTokens),
                        apiKeyId,
                        apiSource,
                        batch,
                        inputAudioTokens,
                        inputCacheWrite12hTokens,
                        inputCacheWrite30mTokens,
                        inputCacheWriteTokens,
                        inputCachedAudioTokens,
                        inputCachedImageTokens,
                        inputCachedTextTokens,
                        inputCachedTokens,
                        inputImageTokens,
                        inputTextTokens,
                        inputUncachedTokens,
                        model,
                        outputAudioTokens,
                        outputImageTokens,
                        outputTextTokens,
                        projectId,
                        serviceTier,
                        userId,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Result = apply {
                if (validated) {
                    return@apply
                }

                inputTokens()
                numModelRequests()
                _object_().let {
                    if (it != JsonValue.from("organization.usage.decisions.result")) {
                        throw OpenAIInvalidDataException("'object_' is invalid, received $it")
                    }
                }
                outputTokens()
                apiKeyId()
                apiSource().ifPresent { it.validate() }
                batch()
                inputAudioTokens()
                inputCacheWrite12hTokens()
                inputCacheWrite30mTokens()
                inputCacheWriteTokens()
                inputCachedAudioTokens()
                inputCachedImageTokens()
                inputCachedTextTokens()
                inputCachedTokens()
                inputImageTokens()
                inputTextTokens()
                inputUncachedTokens()
                model()
                outputAudioTokens()
                outputImageTokens()
                outputTextTokens()
                projectId()
                serviceTier()
                userId()
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
                (if (inputTokens.asKnown().isPresent) 1 else 0) +
                    (if (numModelRequests.asKnown().isPresent) 1 else 0) +
                    object_.let {
                        if (it == JsonValue.from("organization.usage.decisions.result")) 1 else 0
                    } +
                    (if (outputTokens.asKnown().isPresent) 1 else 0) +
                    (if (apiKeyId.asKnown().isPresent) 1 else 0) +
                    (apiSource.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (batch.asKnown().isPresent) 1 else 0) +
                    (if (inputAudioTokens.asKnown().isPresent) 1 else 0) +
                    (if (inputCacheWrite12hTokens.asKnown().isPresent) 1 else 0) +
                    (if (inputCacheWrite30mTokens.asKnown().isPresent) 1 else 0) +
                    (if (inputCacheWriteTokens.asKnown().isPresent) 1 else 0) +
                    (if (inputCachedAudioTokens.asKnown().isPresent) 1 else 0) +
                    (if (inputCachedImageTokens.asKnown().isPresent) 1 else 0) +
                    (if (inputCachedTextTokens.asKnown().isPresent) 1 else 0) +
                    (if (inputCachedTokens.asKnown().isPresent) 1 else 0) +
                    (if (inputImageTokens.asKnown().isPresent) 1 else 0) +
                    (if (inputTextTokens.asKnown().isPresent) 1 else 0) +
                    (if (inputUncachedTokens.asKnown().isPresent) 1 else 0) +
                    (if (model.asKnown().isPresent) 1 else 0) +
                    (if (outputAudioTokens.asKnown().isPresent) 1 else 0) +
                    (if (outputImageTokens.asKnown().isPresent) 1 else 0) +
                    (if (outputTextTokens.asKnown().isPresent) 1 else 0) +
                    (if (projectId.asKnown().isPresent) 1 else 0) +
                    (if (serviceTier.asKnown().isPresent) 1 else 0) +
                    (if (userId.asKnown().isPresent) 1 else 0)

            /**
             * When grouped by `api_source`, `agents_api` identifies attributed Agents API activity
             * and `unlabeled` includes all records without published source attribution, including
             * historical and unknown origins. Unlabeled does not imply direct API usage. Without
             * source grouping, this field is null.
             */
            class ApiSource @JsonCreator private constructor(private val value: JsonField<String>) :
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

                    @JvmField val AGENTS_API = of("agents_api")

                    @JvmField val UNLABELED = of("unlabeled")

                    @JvmStatic fun of(value: String) = ApiSource(JsonField.of(value))
                }

                /** An enum containing [ApiSource]'s known values. */
                enum class Known {
                    AGENTS_API,
                    UNLABELED,
                }

                /**
                 * An enum containing [ApiSource]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [ApiSource] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    AGENTS_API,
                    UNLABELED,
                    /**
                     * An enum member indicating that [ApiSource] was instantiated with an unknown
                     * value.
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
                        AGENTS_API -> Value.AGENTS_API
                        UNLABELED -> Value.UNLABELED
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
                        AGENTS_API -> Known.AGENTS_API
                        UNLABELED -> Known.UNLABELED
                        else -> throw OpenAIInvalidDataException("Unknown ApiSource: $value")
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

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): ApiSource = apply {
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

                    return other is ApiSource && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Result &&
                    inputTokens == other.inputTokens &&
                    numModelRequests == other.numModelRequests &&
                    object_ == other.object_ &&
                    outputTokens == other.outputTokens &&
                    apiKeyId == other.apiKeyId &&
                    apiSource == other.apiSource &&
                    batch == other.batch &&
                    inputAudioTokens == other.inputAudioTokens &&
                    inputCacheWrite12hTokens == other.inputCacheWrite12hTokens &&
                    inputCacheWrite30mTokens == other.inputCacheWrite30mTokens &&
                    inputCacheWriteTokens == other.inputCacheWriteTokens &&
                    inputCachedAudioTokens == other.inputCachedAudioTokens &&
                    inputCachedImageTokens == other.inputCachedImageTokens &&
                    inputCachedTextTokens == other.inputCachedTextTokens &&
                    inputCachedTokens == other.inputCachedTokens &&
                    inputImageTokens == other.inputImageTokens &&
                    inputTextTokens == other.inputTextTokens &&
                    inputUncachedTokens == other.inputUncachedTokens &&
                    model == other.model &&
                    outputAudioTokens == other.outputAudioTokens &&
                    outputImageTokens == other.outputImageTokens &&
                    outputTextTokens == other.outputTextTokens &&
                    projectId == other.projectId &&
                    serviceTier == other.serviceTier &&
                    userId == other.userId &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    inputTokens,
                    numModelRequests,
                    object_,
                    outputTokens,
                    apiKeyId,
                    apiSource,
                    batch,
                    inputAudioTokens,
                    inputCacheWrite12hTokens,
                    inputCacheWrite30mTokens,
                    inputCacheWriteTokens,
                    inputCachedAudioTokens,
                    inputCachedImageTokens,
                    inputCachedTextTokens,
                    inputCachedTokens,
                    inputImageTokens,
                    inputTextTokens,
                    inputUncachedTokens,
                    model,
                    outputAudioTokens,
                    outputImageTokens,
                    outputTextTokens,
                    projectId,
                    serviceTier,
                    userId,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Result{inputTokens=$inputTokens, numModelRequests=$numModelRequests, object_=$object_, outputTokens=$outputTokens, apiKeyId=$apiKeyId, apiSource=$apiSource, batch=$batch, inputAudioTokens=$inputAudioTokens, inputCacheWrite12hTokens=$inputCacheWrite12hTokens, inputCacheWrite30mTokens=$inputCacheWrite30mTokens, inputCacheWriteTokens=$inputCacheWriteTokens, inputCachedAudioTokens=$inputCachedAudioTokens, inputCachedImageTokens=$inputCachedImageTokens, inputCachedTextTokens=$inputCachedTextTokens, inputCachedTokens=$inputCachedTokens, inputImageTokens=$inputImageTokens, inputTextTokens=$inputTextTokens, inputUncachedTokens=$inputUncachedTokens, model=$model, outputAudioTokens=$outputAudioTokens, outputImageTokens=$outputImageTokens, outputTextTokens=$outputTextTokens, projectId=$projectId, serviceTier=$serviceTier, userId=$userId, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Data &&
                endTime == other.endTime &&
                object_ == other.object_ &&
                results == other.results &&
                startTime == other.startTime &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(endTime, object_, results, startTime, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Data{endTime=$endTime, object_=$object_, results=$results, startTime=$startTime, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UsageDecisionsResponse &&
            data == other.data &&
            hasMore == other.hasMore &&
            nextPage == other.nextPage &&
            object_ == other.object_ &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(data, hasMore, nextPage, object_, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "UsageDecisionsResponse{data=$data, hasMore=$hasMore, nextPage=$nextPage, object_=$object_, additionalProperties=$additionalProperties}"
}
