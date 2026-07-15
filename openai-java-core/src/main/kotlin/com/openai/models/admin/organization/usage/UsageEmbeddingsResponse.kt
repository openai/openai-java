// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.usage

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

class UsageEmbeddingsResponse
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

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [UsageEmbeddingsResponse].
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

    /** A builder for [UsageEmbeddingsResponse]. */
    class Builder internal constructor() {

        private var data: JsonField<MutableList<Data>>? = null
        private var hasMore: JsonField<Boolean>? = null
        private var nextPage: JsonField<String>? = null
        private var object_: JsonValue = JsonValue.from("page")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(usageEmbeddingsResponse: UsageEmbeddingsResponse) = apply {
            data = usageEmbeddingsResponse.data.map { it.toMutableList() }
            hasMore = usageEmbeddingsResponse.hasMore
            nextPage = usageEmbeddingsResponse.nextPage
            object_ = usageEmbeddingsResponse.object_
            additionalProperties = usageEmbeddingsResponse.additionalProperties.toMutableMap()
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
         * Returns an immutable instance of [UsageEmbeddingsResponse].
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
        fun build(): UsageEmbeddingsResponse =
            UsageEmbeddingsResponse(
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
    fun validate(): UsageEmbeddingsResponse = apply {
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

            /**
             * Alias for calling [addResult] with
             * `Result.ofOrganizationUsageCompletions(organizationUsageCompletions)`.
             */
            fun addResult(organizationUsageCompletions: Result.OrganizationUsageCompletionsResult) =
                addResult(Result.ofOrganizationUsageCompletions(organizationUsageCompletions))

            /**
             * Alias for calling [addResult] with
             * `Result.ofOrganizationUsageEmbeddings(organizationUsageEmbeddings)`.
             */
            fun addResult(organizationUsageEmbeddings: Result.OrganizationUsageEmbeddingsResult) =
                addResult(Result.ofOrganizationUsageEmbeddings(organizationUsageEmbeddings))

            /**
             * Alias for calling [addResult] with
             * `Result.ofOrganizationUsageModerations(organizationUsageModerations)`.
             */
            fun addResult(organizationUsageModerations: Result.OrganizationUsageModerationsResult) =
                addResult(Result.ofOrganizationUsageModerations(organizationUsageModerations))

            /**
             * Alias for calling [addResult] with
             * `Result.ofOrganizationUsageImages(organizationUsageImages)`.
             */
            fun addResult(organizationUsageImages: Result.OrganizationUsageImagesResult) =
                addResult(Result.ofOrganizationUsageImages(organizationUsageImages))

            /**
             * Alias for calling [addResult] with
             * `Result.ofOrganizationUsageAudioSpeeches(organizationUsageAudioSpeeches)`.
             */
            fun addResult(
                organizationUsageAudioSpeeches: Result.OrganizationUsageAudioSpeechesResult
            ) = addResult(Result.ofOrganizationUsageAudioSpeeches(organizationUsageAudioSpeeches))

            /**
             * Alias for calling [addResult] with
             * `Result.ofOrganizationUsageAudioTranscriptions(organizationUsageAudioTranscriptions)`.
             */
            fun addResult(
                organizationUsageAudioTranscriptions:
                    Result.OrganizationUsageAudioTranscriptionsResult
            ) =
                addResult(
                    Result.ofOrganizationUsageAudioTranscriptions(
                        organizationUsageAudioTranscriptions
                    )
                )

            /**
             * Alias for calling [addResult] with
             * `Result.ofOrganizationUsageVectorStores(organizationUsageVectorStores)`.
             */
            fun addResult(
                organizationUsageVectorStores: Result.OrganizationUsageVectorStoresResult
            ) = addResult(Result.ofOrganizationUsageVectorStores(organizationUsageVectorStores))

            /**
             * Alias for calling [addResult] with the following:
             * ```java
             * Result.OrganizationUsageVectorStoresResult.builder()
             *     .usageBytes(usageBytes)
             *     .build()
             * ```
             */
            fun addOrganizationUsageVectorStoresResult(usageBytes: Long) =
                addResult(
                    Result.OrganizationUsageVectorStoresResult.builder()
                        .usageBytes(usageBytes)
                        .build()
                )

            /**
             * Alias for calling [addResult] with
             * `Result.ofOrganizationUsageCodeInterpreterSessions(organizationUsageCodeInterpreterSessions)`.
             */
            fun addResult(
                organizationUsageCodeInterpreterSessions:
                    Result.OrganizationUsageCodeInterpreterSessionsResult
            ) =
                addResult(
                    Result.ofOrganizationUsageCodeInterpreterSessions(
                        organizationUsageCodeInterpreterSessions
                    )
                )

            /**
             * Alias for calling [addResult] with the following:
             * ```java
             * Result.OrganizationUsageCodeInterpreterSessionsResult.builder()
             *     .numSessions(numSessions)
             *     .build()
             * ```
             */
            fun addOrganizationUsageCodeInterpreterSessionsResult(numSessions: Long) =
                addResult(
                    Result.OrganizationUsageCodeInterpreterSessionsResult.builder()
                        .numSessions(numSessions)
                        .build()
                )

            /**
             * Alias for calling [addResult] with
             * `Result.ofOrganizationUsageFileSearches(organizationUsageFileSearches)`.
             */
            fun addResult(
                organizationUsageFileSearches: Result.OrganizationUsageFileSearchesResult
            ) = addResult(Result.ofOrganizationUsageFileSearches(organizationUsageFileSearches))

            /**
             * Alias for calling [addResult] with the following:
             * ```java
             * Result.OrganizationUsageFileSearchesResult.builder()
             *     .numRequests(numRequests)
             *     .build()
             * ```
             */
            fun addOrganizationUsageFileSearchesResult(numRequests: Long) =
                addResult(
                    Result.OrganizationUsageFileSearchesResult.builder()
                        .numRequests(numRequests)
                        .build()
                )

            /**
             * Alias for calling [addResult] with
             * `Result.ofOrganizationUsageWebSearches(organizationUsageWebSearches)`.
             */
            fun addResult(organizationUsageWebSearches: Result.OrganizationUsageWebSearchesResult) =
                addResult(Result.ofOrganizationUsageWebSearches(organizationUsageWebSearches))

            /**
             * Alias for calling [addResult] with `Result.ofOrganizationCosts(organizationCosts)`.
             */
            fun addResult(organizationCosts: Result.OrganizationCostsResult) =
                addResult(Result.ofOrganizationCosts(organizationCosts))

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

        /** The aggregated completions usage details of the specific time bucket. */
        @JsonDeserialize(using = Result.Deserializer::class)
        @JsonSerialize(using = Result.Serializer::class)
        class Result
        private constructor(
            private val organizationUsageCompletions: OrganizationUsageCompletionsResult? = null,
            private val organizationUsageEmbeddings: OrganizationUsageEmbeddingsResult? = null,
            private val organizationUsageModerations: OrganizationUsageModerationsResult? = null,
            private val organizationUsageImages: OrganizationUsageImagesResult? = null,
            private val organizationUsageAudioSpeeches: OrganizationUsageAudioSpeechesResult? =
                null,
            private val organizationUsageAudioTranscriptions:
                OrganizationUsageAudioTranscriptionsResult? =
                null,
            private val organizationUsageVectorStores: OrganizationUsageVectorStoresResult? = null,
            private val organizationUsageCodeInterpreterSessions:
                OrganizationUsageCodeInterpreterSessionsResult? =
                null,
            private val organizationUsageFileSearches: OrganizationUsageFileSearchesResult? = null,
            private val organizationUsageWebSearches: OrganizationUsageWebSearchesResult? = null,
            private val organizationCosts: OrganizationCostsResult? = null,
            private val _json: JsonValue? = null,
        ) {

            /** The aggregated completions usage details of the specific time bucket. */
            fun organizationUsageCompletions(): Optional<OrganizationUsageCompletionsResult> =
                Optional.ofNullable(organizationUsageCompletions)

            /** The aggregated embeddings usage details of the specific time bucket. */
            fun organizationUsageEmbeddings(): Optional<OrganizationUsageEmbeddingsResult> =
                Optional.ofNullable(organizationUsageEmbeddings)

            /** The aggregated moderations usage details of the specific time bucket. */
            fun organizationUsageModerations(): Optional<OrganizationUsageModerationsResult> =
                Optional.ofNullable(organizationUsageModerations)

            /** The aggregated images usage details of the specific time bucket. */
            fun organizationUsageImages(): Optional<OrganizationUsageImagesResult> =
                Optional.ofNullable(organizationUsageImages)

            /** The aggregated audio speeches usage details of the specific time bucket. */
            fun organizationUsageAudioSpeeches(): Optional<OrganizationUsageAudioSpeechesResult> =
                Optional.ofNullable(organizationUsageAudioSpeeches)

            /** The aggregated audio transcriptions usage details of the specific time bucket. */
            fun organizationUsageAudioTranscriptions():
                Optional<OrganizationUsageAudioTranscriptionsResult> =
                Optional.ofNullable(organizationUsageAudioTranscriptions)

            /** The aggregated vector stores usage details of the specific time bucket. */
            fun organizationUsageVectorStores(): Optional<OrganizationUsageVectorStoresResult> =
                Optional.ofNullable(organizationUsageVectorStores)

            /**
             * The aggregated code interpreter sessions usage details of the specific time bucket.
             */
            fun organizationUsageCodeInterpreterSessions():
                Optional<OrganizationUsageCodeInterpreterSessionsResult> =
                Optional.ofNullable(organizationUsageCodeInterpreterSessions)

            /** The aggregated file search calls usage details of the specific time bucket. */
            fun organizationUsageFileSearches(): Optional<OrganizationUsageFileSearchesResult> =
                Optional.ofNullable(organizationUsageFileSearches)

            /** The aggregated web search calls usage details of the specific time bucket. */
            fun organizationUsageWebSearches(): Optional<OrganizationUsageWebSearchesResult> =
                Optional.ofNullable(organizationUsageWebSearches)

            /** The aggregated costs details of the specific time bucket. */
            fun organizationCosts(): Optional<OrganizationCostsResult> =
                Optional.ofNullable(organizationCosts)

            fun isOrganizationUsageCompletions(): Boolean = organizationUsageCompletions != null

            fun isOrganizationUsageEmbeddings(): Boolean = organizationUsageEmbeddings != null

            fun isOrganizationUsageModerations(): Boolean = organizationUsageModerations != null

            fun isOrganizationUsageImages(): Boolean = organizationUsageImages != null

            fun isOrganizationUsageAudioSpeeches(): Boolean = organizationUsageAudioSpeeches != null

            fun isOrganizationUsageAudioTranscriptions(): Boolean =
                organizationUsageAudioTranscriptions != null

            fun isOrganizationUsageVectorStores(): Boolean = organizationUsageVectorStores != null

            fun isOrganizationUsageCodeInterpreterSessions(): Boolean =
                organizationUsageCodeInterpreterSessions != null

            fun isOrganizationUsageFileSearches(): Boolean = organizationUsageFileSearches != null

            fun isOrganizationUsageWebSearches(): Boolean = organizationUsageWebSearches != null

            fun isOrganizationCosts(): Boolean = organizationCosts != null

            /** The aggregated completions usage details of the specific time bucket. */
            fun asOrganizationUsageCompletions(): OrganizationUsageCompletionsResult =
                organizationUsageCompletions.getOrThrow("organizationUsageCompletions")

            /** The aggregated embeddings usage details of the specific time bucket. */
            fun asOrganizationUsageEmbeddings(): OrganizationUsageEmbeddingsResult =
                organizationUsageEmbeddings.getOrThrow("organizationUsageEmbeddings")

            /** The aggregated moderations usage details of the specific time bucket. */
            fun asOrganizationUsageModerations(): OrganizationUsageModerationsResult =
                organizationUsageModerations.getOrThrow("organizationUsageModerations")

            /** The aggregated images usage details of the specific time bucket. */
            fun asOrganizationUsageImages(): OrganizationUsageImagesResult =
                organizationUsageImages.getOrThrow("organizationUsageImages")

            /** The aggregated audio speeches usage details of the specific time bucket. */
            fun asOrganizationUsageAudioSpeeches(): OrganizationUsageAudioSpeechesResult =
                organizationUsageAudioSpeeches.getOrThrow("organizationUsageAudioSpeeches")

            /** The aggregated audio transcriptions usage details of the specific time bucket. */
            fun asOrganizationUsageAudioTranscriptions():
                OrganizationUsageAudioTranscriptionsResult =
                organizationUsageAudioTranscriptions.getOrThrow(
                    "organizationUsageAudioTranscriptions"
                )

            /** The aggregated vector stores usage details of the specific time bucket. */
            fun asOrganizationUsageVectorStores(): OrganizationUsageVectorStoresResult =
                organizationUsageVectorStores.getOrThrow("organizationUsageVectorStores")

            /**
             * The aggregated code interpreter sessions usage details of the specific time bucket.
             */
            fun asOrganizationUsageCodeInterpreterSessions():
                OrganizationUsageCodeInterpreterSessionsResult =
                organizationUsageCodeInterpreterSessions.getOrThrow(
                    "organizationUsageCodeInterpreterSessions"
                )

            /** The aggregated file search calls usage details of the specific time bucket. */
            fun asOrganizationUsageFileSearches(): OrganizationUsageFileSearchesResult =
                organizationUsageFileSearches.getOrThrow("organizationUsageFileSearches")

            /** The aggregated web search calls usage details of the specific time bucket. */
            fun asOrganizationUsageWebSearches(): OrganizationUsageWebSearchesResult =
                organizationUsageWebSearches.getOrThrow("organizationUsageWebSearches")

            /** The aggregated costs details of the specific time bucket. */
            fun asOrganizationCosts(): OrganizationCostsResult =
                organizationCosts.getOrThrow("organizationCosts")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            /**
             * Maps this instance's current variant to a value of type [T] using the given
             * [visitor].
             *
             * Note that this method is _not_ forwards compatible with new variants from the API,
             * unless [visitor] overrides [Visitor.unknown]. To handle variants not known to this
             * version of the SDK gracefully, consider overriding [Visitor.unknown]:
             * ```java
             * import com.openai.core.JsonValue;
             * import java.util.Optional;
             *
             * Optional<String> result = result.accept(new Result.Visitor<Optional<String>>() {
             *     @Override
             *     public Optional<String> visitOrganizationUsageCompletions(OrganizationUsageCompletionsResult organizationUsageCompletions) {
             *         return Optional.of(organizationUsageCompletions.toString());
             *     }
             *
             *     // ...
             *
             *     @Override
             *     public Optional<String> unknown(JsonValue json) {
             *         // Or inspect the `json`.
             *         return Optional.empty();
             *     }
             * });
             * ```
             *
             * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in
             *   [visitor] and the current variant is unknown.
             */
            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    organizationUsageCompletions != null ->
                        visitor.visitOrganizationUsageCompletions(organizationUsageCompletions)
                    organizationUsageEmbeddings != null ->
                        visitor.visitOrganizationUsageEmbeddings(organizationUsageEmbeddings)
                    organizationUsageModerations != null ->
                        visitor.visitOrganizationUsageModerations(organizationUsageModerations)
                    organizationUsageImages != null ->
                        visitor.visitOrganizationUsageImages(organizationUsageImages)
                    organizationUsageAudioSpeeches != null ->
                        visitor.visitOrganizationUsageAudioSpeeches(organizationUsageAudioSpeeches)
                    organizationUsageAudioTranscriptions != null ->
                        visitor.visitOrganizationUsageAudioTranscriptions(
                            organizationUsageAudioTranscriptions
                        )
                    organizationUsageVectorStores != null ->
                        visitor.visitOrganizationUsageVectorStores(organizationUsageVectorStores)
                    organizationUsageCodeInterpreterSessions != null ->
                        visitor.visitOrganizationUsageCodeInterpreterSessions(
                            organizationUsageCodeInterpreterSessions
                        )
                    organizationUsageFileSearches != null ->
                        visitor.visitOrganizationUsageFileSearches(organizationUsageFileSearches)
                    organizationUsageWebSearches != null ->
                        visitor.visitOrganizationUsageWebSearches(organizationUsageWebSearches)
                    organizationCosts != null -> visitor.visitOrganizationCosts(organizationCosts)
                    else -> visitor.unknown(_json)
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

                accept(
                    object : Visitor<Unit> {
                        override fun visitOrganizationUsageCompletions(
                            organizationUsageCompletions: OrganizationUsageCompletionsResult
                        ) {
                            organizationUsageCompletions.validate()
                        }

                        override fun visitOrganizationUsageEmbeddings(
                            organizationUsageEmbeddings: OrganizationUsageEmbeddingsResult
                        ) {
                            organizationUsageEmbeddings.validate()
                        }

                        override fun visitOrganizationUsageModerations(
                            organizationUsageModerations: OrganizationUsageModerationsResult
                        ) {
                            organizationUsageModerations.validate()
                        }

                        override fun visitOrganizationUsageImages(
                            organizationUsageImages: OrganizationUsageImagesResult
                        ) {
                            organizationUsageImages.validate()
                        }

                        override fun visitOrganizationUsageAudioSpeeches(
                            organizationUsageAudioSpeeches: OrganizationUsageAudioSpeechesResult
                        ) {
                            organizationUsageAudioSpeeches.validate()
                        }

                        override fun visitOrganizationUsageAudioTranscriptions(
                            organizationUsageAudioTranscriptions:
                                OrganizationUsageAudioTranscriptionsResult
                        ) {
                            organizationUsageAudioTranscriptions.validate()
                        }

                        override fun visitOrganizationUsageVectorStores(
                            organizationUsageVectorStores: OrganizationUsageVectorStoresResult
                        ) {
                            organizationUsageVectorStores.validate()
                        }

                        override fun visitOrganizationUsageCodeInterpreterSessions(
                            organizationUsageCodeInterpreterSessions:
                                OrganizationUsageCodeInterpreterSessionsResult
                        ) {
                            organizationUsageCodeInterpreterSessions.validate()
                        }

                        override fun visitOrganizationUsageFileSearches(
                            organizationUsageFileSearches: OrganizationUsageFileSearchesResult
                        ) {
                            organizationUsageFileSearches.validate()
                        }

                        override fun visitOrganizationUsageWebSearches(
                            organizationUsageWebSearches: OrganizationUsageWebSearchesResult
                        ) {
                            organizationUsageWebSearches.validate()
                        }

                        override fun visitOrganizationCosts(
                            organizationCosts: OrganizationCostsResult
                        ) {
                            organizationCosts.validate()
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
                        override fun visitOrganizationUsageCompletions(
                            organizationUsageCompletions: OrganizationUsageCompletionsResult
                        ) = organizationUsageCompletions.validity()

                        override fun visitOrganizationUsageEmbeddings(
                            organizationUsageEmbeddings: OrganizationUsageEmbeddingsResult
                        ) = organizationUsageEmbeddings.validity()

                        override fun visitOrganizationUsageModerations(
                            organizationUsageModerations: OrganizationUsageModerationsResult
                        ) = organizationUsageModerations.validity()

                        override fun visitOrganizationUsageImages(
                            organizationUsageImages: OrganizationUsageImagesResult
                        ) = organizationUsageImages.validity()

                        override fun visitOrganizationUsageAudioSpeeches(
                            organizationUsageAudioSpeeches: OrganizationUsageAudioSpeechesResult
                        ) = organizationUsageAudioSpeeches.validity()

                        override fun visitOrganizationUsageAudioTranscriptions(
                            organizationUsageAudioTranscriptions:
                                OrganizationUsageAudioTranscriptionsResult
                        ) = organizationUsageAudioTranscriptions.validity()

                        override fun visitOrganizationUsageVectorStores(
                            organizationUsageVectorStores: OrganizationUsageVectorStoresResult
                        ) = organizationUsageVectorStores.validity()

                        override fun visitOrganizationUsageCodeInterpreterSessions(
                            organizationUsageCodeInterpreterSessions:
                                OrganizationUsageCodeInterpreterSessionsResult
                        ) = organizationUsageCodeInterpreterSessions.validity()

                        override fun visitOrganizationUsageFileSearches(
                            organizationUsageFileSearches: OrganizationUsageFileSearchesResult
                        ) = organizationUsageFileSearches.validity()

                        override fun visitOrganizationUsageWebSearches(
                            organizationUsageWebSearches: OrganizationUsageWebSearchesResult
                        ) = organizationUsageWebSearches.validity()

                        override fun visitOrganizationCosts(
                            organizationCosts: OrganizationCostsResult
                        ) = organizationCosts.validity()

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Result &&
                    organizationUsageCompletions == other.organizationUsageCompletions &&
                    organizationUsageEmbeddings == other.organizationUsageEmbeddings &&
                    organizationUsageModerations == other.organizationUsageModerations &&
                    organizationUsageImages == other.organizationUsageImages &&
                    organizationUsageAudioSpeeches == other.organizationUsageAudioSpeeches &&
                    organizationUsageAudioTranscriptions ==
                        other.organizationUsageAudioTranscriptions &&
                    organizationUsageVectorStores == other.organizationUsageVectorStores &&
                    organizationUsageCodeInterpreterSessions ==
                        other.organizationUsageCodeInterpreterSessions &&
                    organizationUsageFileSearches == other.organizationUsageFileSearches &&
                    organizationUsageWebSearches == other.organizationUsageWebSearches &&
                    organizationCosts == other.organizationCosts
            }

            override fun hashCode(): Int =
                Objects.hash(
                    organizationUsageCompletions,
                    organizationUsageEmbeddings,
                    organizationUsageModerations,
                    organizationUsageImages,
                    organizationUsageAudioSpeeches,
                    organizationUsageAudioTranscriptions,
                    organizationUsageVectorStores,
                    organizationUsageCodeInterpreterSessions,
                    organizationUsageFileSearches,
                    organizationUsageWebSearches,
                    organizationCosts,
                )

            override fun toString(): String =
                when {
                    organizationUsageCompletions != null ->
                        "Result{organizationUsageCompletions=$organizationUsageCompletions}"
                    organizationUsageEmbeddings != null ->
                        "Result{organizationUsageEmbeddings=$organizationUsageEmbeddings}"
                    organizationUsageModerations != null ->
                        "Result{organizationUsageModerations=$organizationUsageModerations}"
                    organizationUsageImages != null ->
                        "Result{organizationUsageImages=$organizationUsageImages}"
                    organizationUsageAudioSpeeches != null ->
                        "Result{organizationUsageAudioSpeeches=$organizationUsageAudioSpeeches}"
                    organizationUsageAudioTranscriptions != null ->
                        "Result{organizationUsageAudioTranscriptions=$organizationUsageAudioTranscriptions}"
                    organizationUsageVectorStores != null ->
                        "Result{organizationUsageVectorStores=$organizationUsageVectorStores}"
                    organizationUsageCodeInterpreterSessions != null ->
                        "Result{organizationUsageCodeInterpreterSessions=$organizationUsageCodeInterpreterSessions}"
                    organizationUsageFileSearches != null ->
                        "Result{organizationUsageFileSearches=$organizationUsageFileSearches}"
                    organizationUsageWebSearches != null ->
                        "Result{organizationUsageWebSearches=$organizationUsageWebSearches}"
                    organizationCosts != null -> "Result{organizationCosts=$organizationCosts}"
                    _json != null -> "Result{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Result")
                }

            companion object {

                /** The aggregated completions usage details of the specific time bucket. */
                @JvmStatic
                fun ofOrganizationUsageCompletions(
                    organizationUsageCompletions: OrganizationUsageCompletionsResult
                ) = Result(organizationUsageCompletions = organizationUsageCompletions)

                /** The aggregated embeddings usage details of the specific time bucket. */
                @JvmStatic
                fun ofOrganizationUsageEmbeddings(
                    organizationUsageEmbeddings: OrganizationUsageEmbeddingsResult
                ) = Result(organizationUsageEmbeddings = organizationUsageEmbeddings)

                /** The aggregated moderations usage details of the specific time bucket. */
                @JvmStatic
                fun ofOrganizationUsageModerations(
                    organizationUsageModerations: OrganizationUsageModerationsResult
                ) = Result(organizationUsageModerations = organizationUsageModerations)

                /** The aggregated images usage details of the specific time bucket. */
                @JvmStatic
                fun ofOrganizationUsageImages(
                    organizationUsageImages: OrganizationUsageImagesResult
                ) = Result(organizationUsageImages = organizationUsageImages)

                /** The aggregated audio speeches usage details of the specific time bucket. */
                @JvmStatic
                fun ofOrganizationUsageAudioSpeeches(
                    organizationUsageAudioSpeeches: OrganizationUsageAudioSpeechesResult
                ) = Result(organizationUsageAudioSpeeches = organizationUsageAudioSpeeches)

                /**
                 * The aggregated audio transcriptions usage details of the specific time bucket.
                 */
                @JvmStatic
                fun ofOrganizationUsageAudioTranscriptions(
                    organizationUsageAudioTranscriptions: OrganizationUsageAudioTranscriptionsResult
                ) =
                    Result(
                        organizationUsageAudioTranscriptions = organizationUsageAudioTranscriptions
                    )

                /** The aggregated vector stores usage details of the specific time bucket. */
                @JvmStatic
                fun ofOrganizationUsageVectorStores(
                    organizationUsageVectorStores: OrganizationUsageVectorStoresResult
                ) = Result(organizationUsageVectorStores = organizationUsageVectorStores)

                /**
                 * The aggregated code interpreter sessions usage details of the specific time
                 * bucket.
                 */
                @JvmStatic
                fun ofOrganizationUsageCodeInterpreterSessions(
                    organizationUsageCodeInterpreterSessions:
                        OrganizationUsageCodeInterpreterSessionsResult
                ) =
                    Result(
                        organizationUsageCodeInterpreterSessions =
                            organizationUsageCodeInterpreterSessions
                    )

                /** The aggregated file search calls usage details of the specific time bucket. */
                @JvmStatic
                fun ofOrganizationUsageFileSearches(
                    organizationUsageFileSearches: OrganizationUsageFileSearchesResult
                ) = Result(organizationUsageFileSearches = organizationUsageFileSearches)

                /** The aggregated web search calls usage details of the specific time bucket. */
                @JvmStatic
                fun ofOrganizationUsageWebSearches(
                    organizationUsageWebSearches: OrganizationUsageWebSearchesResult
                ) = Result(organizationUsageWebSearches = organizationUsageWebSearches)

                /** The aggregated costs details of the specific time bucket. */
                @JvmStatic
                fun ofOrganizationCosts(organizationCosts: OrganizationCostsResult) =
                    Result(organizationCosts = organizationCosts)
            }

            /**
             * An interface that defines how to map each variant of [Result] to a value of type [T].
             */
            interface Visitor<out T> {

                /** The aggregated completions usage details of the specific time bucket. */
                fun visitOrganizationUsageCompletions(
                    organizationUsageCompletions: OrganizationUsageCompletionsResult
                ): T

                /** The aggregated embeddings usage details of the specific time bucket. */
                fun visitOrganizationUsageEmbeddings(
                    organizationUsageEmbeddings: OrganizationUsageEmbeddingsResult
                ): T

                /** The aggregated moderations usage details of the specific time bucket. */
                fun visitOrganizationUsageModerations(
                    organizationUsageModerations: OrganizationUsageModerationsResult
                ): T

                /** The aggregated images usage details of the specific time bucket. */
                fun visitOrganizationUsageImages(
                    organizationUsageImages: OrganizationUsageImagesResult
                ): T

                /** The aggregated audio speeches usage details of the specific time bucket. */
                fun visitOrganizationUsageAudioSpeeches(
                    organizationUsageAudioSpeeches: OrganizationUsageAudioSpeechesResult
                ): T

                /**
                 * The aggregated audio transcriptions usage details of the specific time bucket.
                 */
                fun visitOrganizationUsageAudioTranscriptions(
                    organizationUsageAudioTranscriptions: OrganizationUsageAudioTranscriptionsResult
                ): T

                /** The aggregated vector stores usage details of the specific time bucket. */
                fun visitOrganizationUsageVectorStores(
                    organizationUsageVectorStores: OrganizationUsageVectorStoresResult
                ): T

                /**
                 * The aggregated code interpreter sessions usage details of the specific time
                 * bucket.
                 */
                fun visitOrganizationUsageCodeInterpreterSessions(
                    organizationUsageCodeInterpreterSessions:
                        OrganizationUsageCodeInterpreterSessionsResult
                ): T

                /** The aggregated file search calls usage details of the specific time bucket. */
                fun visitOrganizationUsageFileSearches(
                    organizationUsageFileSearches: OrganizationUsageFileSearchesResult
                ): T

                /** The aggregated web search calls usage details of the specific time bucket. */
                fun visitOrganizationUsageWebSearches(
                    organizationUsageWebSearches: OrganizationUsageWebSearchesResult
                ): T

                /** The aggregated costs details of the specific time bucket. */
                fun visitOrganizationCosts(organizationCosts: OrganizationCostsResult): T

                /**
                 * Maps an unknown variant of [Result] to a value of type [T].
                 *
                 * An instance of [Result] can contain an unknown variant if it was deserialized
                 * from data that doesn't match any known variant. For example, if the SDK is on an
                 * older version than the API, then the API may respond with new variants that the
                 * SDK is unaware of.
                 *
                 * @throws OpenAIInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown Result: $json")
                }
            }

            internal class Deserializer : BaseDeserializer<Result>(Result::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): Result {
                    val json = JsonValue.fromJsonNode(node)
                    val object_ =
                        json.asObject().getOrNull()?.get("object")?.asString()?.getOrNull()

                    when (object_) {
                        "organization.usage.completions.result" -> {
                            return tryDeserialize(
                                    node,
                                    jacksonTypeRef<OrganizationUsageCompletionsResult>(),
                                )
                                ?.let { Result(organizationUsageCompletions = it, _json = json) }
                                ?: Result(_json = json)
                        }
                        "organization.usage.embeddings.result" -> {
                            return tryDeserialize(
                                    node,
                                    jacksonTypeRef<OrganizationUsageEmbeddingsResult>(),
                                )
                                ?.let { Result(organizationUsageEmbeddings = it, _json = json) }
                                ?: Result(_json = json)
                        }
                        "organization.usage.moderations.result" -> {
                            return tryDeserialize(
                                    node,
                                    jacksonTypeRef<OrganizationUsageModerationsResult>(),
                                )
                                ?.let { Result(organizationUsageModerations = it, _json = json) }
                                ?: Result(_json = json)
                        }
                        "organization.usage.images.result" -> {
                            return tryDeserialize(
                                    node,
                                    jacksonTypeRef<OrganizationUsageImagesResult>(),
                                )
                                ?.let { Result(organizationUsageImages = it, _json = json) }
                                ?: Result(_json = json)
                        }
                        "organization.usage.audio_speeches.result" -> {
                            return tryDeserialize(
                                    node,
                                    jacksonTypeRef<OrganizationUsageAudioSpeechesResult>(),
                                )
                                ?.let { Result(organizationUsageAudioSpeeches = it, _json = json) }
                                ?: Result(_json = json)
                        }
                        "organization.usage.audio_transcriptions.result" -> {
                            return tryDeserialize(
                                    node,
                                    jacksonTypeRef<OrganizationUsageAudioTranscriptionsResult>(),
                                )
                                ?.let {
                                    Result(organizationUsageAudioTranscriptions = it, _json = json)
                                } ?: Result(_json = json)
                        }
                        "organization.usage.vector_stores.result" -> {
                            return tryDeserialize(
                                    node,
                                    jacksonTypeRef<OrganizationUsageVectorStoresResult>(),
                                )
                                ?.let { Result(organizationUsageVectorStores = it, _json = json) }
                                ?: Result(_json = json)
                        }
                        "organization.usage.code_interpreter_sessions.result" -> {
                            return tryDeserialize(
                                    node,
                                    jacksonTypeRef<OrganizationUsageCodeInterpreterSessionsResult>(),
                                )
                                ?.let {
                                    Result(
                                        organizationUsageCodeInterpreterSessions = it,
                                        _json = json,
                                    )
                                } ?: Result(_json = json)
                        }
                        "organization.usage.file_searches.result" -> {
                            return tryDeserialize(
                                    node,
                                    jacksonTypeRef<OrganizationUsageFileSearchesResult>(),
                                )
                                ?.let { Result(organizationUsageFileSearches = it, _json = json) }
                                ?: Result(_json = json)
                        }
                        "organization.usage.web_searches.result" -> {
                            return tryDeserialize(
                                    node,
                                    jacksonTypeRef<OrganizationUsageWebSearchesResult>(),
                                )
                                ?.let { Result(organizationUsageWebSearches = it, _json = json) }
                                ?: Result(_json = json)
                        }
                        "organization.costs.result" -> {
                            return tryDeserialize(node, jacksonTypeRef<OrganizationCostsResult>())
                                ?.let { Result(organizationCosts = it, _json = json) }
                                ?: Result(_json = json)
                        }
                    }

                    return Result(_json = json)
                }
            }

            internal class Serializer : BaseSerializer<Result>(Result::class) {

                override fun serialize(
                    value: Result,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.organizationUsageCompletions != null ->
                            generator.writeObject(value.organizationUsageCompletions)
                        value.organizationUsageEmbeddings != null ->
                            generator.writeObject(value.organizationUsageEmbeddings)
                        value.organizationUsageModerations != null ->
                            generator.writeObject(value.organizationUsageModerations)
                        value.organizationUsageImages != null ->
                            generator.writeObject(value.organizationUsageImages)
                        value.organizationUsageAudioSpeeches != null ->
                            generator.writeObject(value.organizationUsageAudioSpeeches)
                        value.organizationUsageAudioTranscriptions != null ->
                            generator.writeObject(value.organizationUsageAudioTranscriptions)
                        value.organizationUsageVectorStores != null ->
                            generator.writeObject(value.organizationUsageVectorStores)
                        value.organizationUsageCodeInterpreterSessions != null ->
                            generator.writeObject(value.organizationUsageCodeInterpreterSessions)
                        value.organizationUsageFileSearches != null ->
                            generator.writeObject(value.organizationUsageFileSearches)
                        value.organizationUsageWebSearches != null ->
                            generator.writeObject(value.organizationUsageWebSearches)
                        value.organizationCosts != null ->
                            generator.writeObject(value.organizationCosts)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Result")
                    }
                }
            }

            /** The aggregated completions usage details of the specific time bucket. */
            class OrganizationUsageCompletionsResult
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val inputTokens: JsonField<Long>,
                private val numModelRequests: JsonField<Long>,
                private val object_: JsonValue,
                private val outputTokens: JsonField<Long>,
                private val apiKeyId: JsonField<String>,
                private val batch: JsonField<Boolean>,
                private val inputAudioTokens: JsonField<Long>,
                private val inputCachedTokens: JsonField<Long>,
                private val model: JsonField<String>,
                private val outputAudioTokens: JsonField<Long>,
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
                    @JsonProperty("batch")
                    @ExcludeMissing
                    batch: JsonField<Boolean> = JsonMissing.of(),
                    @JsonProperty("input_audio_tokens")
                    @ExcludeMissing
                    inputAudioTokens: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("input_cached_tokens")
                    @ExcludeMissing
                    inputCachedTokens: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("model")
                    @ExcludeMissing
                    model: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("output_audio_tokens")
                    @ExcludeMissing
                    outputAudioTokens: JsonField<Long> = JsonMissing.of(),
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
                    batch,
                    inputAudioTokens,
                    inputCachedTokens,
                    model,
                    outputAudioTokens,
                    projectId,
                    serviceTier,
                    userId,
                    mutableMapOf(),
                )

                /**
                 * The aggregated number of text input tokens used, including cached tokens. For
                 * customers subscribe to scale tier, this includes scale tier tokens.
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
                 * JsonValue.from("organization.usage.completions.result")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

                /**
                 * The aggregated number of text output tokens used. For customers subscribe to
                 * scale tier, this includes scale tier tokens.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun outputTokens(): Long = outputTokens.getRequired("output_tokens")

                /**
                 * When `group_by=api_key_id`, this field provides the API key ID of the grouped
                 * usage result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun apiKeyId(): Optional<String> = apiKeyId.getOptional("api_key_id")

                /**
                 * When `group_by=batch`, this field tells whether the grouped usage result is batch
                 * or not.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun batch(): Optional<Boolean> = batch.getOptional("batch")

                /**
                 * The aggregated number of audio input tokens used, including cached tokens.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun inputAudioTokens(): Optional<Long> =
                    inputAudioTokens.getOptional("input_audio_tokens")

                /**
                 * The aggregated number of text input tokens that has been cached from previous
                 * requests. For customers subscribe to scale tier, this includes scale tier tokens.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun inputCachedTokens(): Optional<Long> =
                    inputCachedTokens.getOptional("input_cached_tokens")

                /**
                 * When `group_by=model`, this field provides the model name of the grouped usage
                 * result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun model(): Optional<String> = model.getOptional("model")

                /**
                 * The aggregated number of audio output tokens used.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun outputAudioTokens(): Optional<Long> =
                    outputAudioTokens.getOptional("output_audio_tokens")

                /**
                 * When `group_by=project_id`, this field provides the project ID of the grouped
                 * usage result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun projectId(): Optional<String> = projectId.getOptional("project_id")

                /**
                 * When `group_by=service_tier`, this field provides the service tier of the grouped
                 * usage result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun serviceTier(): Optional<String> = serviceTier.getOptional("service_tier")

                /**
                 * When `group_by=user_id`, this field provides the user ID of the grouped usage
                 * result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun userId(): Optional<String> = userId.getOptional("user_id")

                /**
                 * Returns the raw JSON value of [inputTokens].
                 *
                 * Unlike [inputTokens], this method doesn't throw if the JSON field has an
                 * unexpected type.
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
                 * Unlike [outputTokens], this method doesn't throw if the JSON field has an
                 * unexpected type.
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
                 * Returns the raw JSON value of [batch].
                 *
                 * Unlike [batch], this method doesn't throw if the JSON field has an unexpected
                 * type.
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
                 * Returns the raw JSON value of [inputCachedTokens].
                 *
                 * Unlike [inputCachedTokens], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("input_cached_tokens")
                @ExcludeMissing
                fun _inputCachedTokens(): JsonField<Long> = inputCachedTokens

                /**
                 * Returns the raw JSON value of [model].
                 *
                 * Unlike [model], this method doesn't throw if the JSON field has an unexpected
                 * type.
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
                 * Unlike [serviceTier], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("service_tier")
                @ExcludeMissing
                fun _serviceTier(): JsonField<String> = serviceTier

                /**
                 * Returns the raw JSON value of [userId].
                 *
                 * Unlike [userId], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("user_id") @ExcludeMissing fun _userId(): JsonField<String> = userId

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
                     * [OrganizationUsageCompletionsResult].
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

                /** A builder for [OrganizationUsageCompletionsResult]. */
                class Builder internal constructor() {

                    private var inputTokens: JsonField<Long>? = null
                    private var numModelRequests: JsonField<Long>? = null
                    private var object_: JsonValue =
                        JsonValue.from("organization.usage.completions.result")
                    private var outputTokens: JsonField<Long>? = null
                    private var apiKeyId: JsonField<String> = JsonMissing.of()
                    private var batch: JsonField<Boolean> = JsonMissing.of()
                    private var inputAudioTokens: JsonField<Long> = JsonMissing.of()
                    private var inputCachedTokens: JsonField<Long> = JsonMissing.of()
                    private var model: JsonField<String> = JsonMissing.of()
                    private var outputAudioTokens: JsonField<Long> = JsonMissing.of()
                    private var projectId: JsonField<String> = JsonMissing.of()
                    private var serviceTier: JsonField<String> = JsonMissing.of()
                    private var userId: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(
                        organizationUsageCompletionsResult: OrganizationUsageCompletionsResult
                    ) = apply {
                        inputTokens = organizationUsageCompletionsResult.inputTokens
                        numModelRequests = organizationUsageCompletionsResult.numModelRequests
                        object_ = organizationUsageCompletionsResult.object_
                        outputTokens = organizationUsageCompletionsResult.outputTokens
                        apiKeyId = organizationUsageCompletionsResult.apiKeyId
                        batch = organizationUsageCompletionsResult.batch
                        inputAudioTokens = organizationUsageCompletionsResult.inputAudioTokens
                        inputCachedTokens = organizationUsageCompletionsResult.inputCachedTokens
                        model = organizationUsageCompletionsResult.model
                        outputAudioTokens = organizationUsageCompletionsResult.outputAudioTokens
                        projectId = organizationUsageCompletionsResult.projectId
                        serviceTier = organizationUsageCompletionsResult.serviceTier
                        userId = organizationUsageCompletionsResult.userId
                        additionalProperties =
                            organizationUsageCompletionsResult.additionalProperties.toMutableMap()
                    }

                    /**
                     * The aggregated number of text input tokens used, including cached tokens. For
                     * customers subscribe to scale tier, this includes scale tier tokens.
                     */
                    fun inputTokens(inputTokens: Long) = inputTokens(JsonField.of(inputTokens))

                    /**
                     * Sets [Builder.inputTokens] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.inputTokens] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
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
                     * You should usually call [Builder.numModelRequests] with a well-typed [Long]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun numModelRequests(numModelRequests: JsonField<Long>) = apply {
                        this.numModelRequests = numModelRequests
                    }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("organization.usage.completions.result")
                     * ```
                     *
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
                     */
                    fun object_(object_: JsonValue) = apply { this.object_ = object_ }

                    /**
                     * The aggregated number of text output tokens used. For customers subscribe to
                     * scale tier, this includes scale tier tokens.
                     */
                    fun outputTokens(outputTokens: Long) = outputTokens(JsonField.of(outputTokens))

                    /**
                     * Sets [Builder.outputTokens] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.outputTokens] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
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
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun apiKeyId(apiKeyId: JsonField<String>) = apply { this.apiKeyId = apiKeyId }

                    /**
                     * When `group_by=batch`, this field tells whether the grouped usage result is
                     * batch or not.
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
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun batch(batch: JsonField<Boolean>) = apply { this.batch = batch }

                    /**
                     * The aggregated number of audio input tokens used, including cached tokens.
                     */
                    fun inputAudioTokens(inputAudioTokens: Long) =
                        inputAudioTokens(JsonField.of(inputAudioTokens))

                    /**
                     * Sets [Builder.inputAudioTokens] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.inputAudioTokens] with a well-typed [Long]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun inputAudioTokens(inputAudioTokens: JsonField<Long>) = apply {
                        this.inputAudioTokens = inputAudioTokens
                    }

                    /**
                     * The aggregated number of text input tokens that has been cached from previous
                     * requests. For customers subscribe to scale tier, this includes scale tier
                     * tokens.
                     */
                    fun inputCachedTokens(inputCachedTokens: Long) =
                        inputCachedTokens(JsonField.of(inputCachedTokens))

                    /**
                     * Sets [Builder.inputCachedTokens] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.inputCachedTokens] with a well-typed [Long]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun inputCachedTokens(inputCachedTokens: JsonField<Long>) = apply {
                        this.inputCachedTokens = inputCachedTokens
                    }

                    /**
                     * When `group_by=model`, this field provides the model name of the grouped
                     * usage result.
                     */
                    fun model(model: String?) = model(JsonField.ofNullable(model))

                    /** Alias for calling [Builder.model] with `model.orElse(null)`. */
                    fun model(model: Optional<String>) = model(model.getOrNull())

                    /**
                     * Sets [Builder.model] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.model] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun model(model: JsonField<String>) = apply { this.model = model }

                    /** The aggregated number of audio output tokens used. */
                    fun outputAudioTokens(outputAudioTokens: Long) =
                        outputAudioTokens(JsonField.of(outputAudioTokens))

                    /**
                     * Sets [Builder.outputAudioTokens] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.outputAudioTokens] with a well-typed [Long]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun outputAudioTokens(outputAudioTokens: JsonField<Long>) = apply {
                        this.outputAudioTokens = outputAudioTokens
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
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun projectId(projectId: JsonField<String>) = apply {
                        this.projectId = projectId
                    }

                    /**
                     * When `group_by=service_tier`, this field provides the service tier of the
                     * grouped usage result.
                     */
                    fun serviceTier(serviceTier: String?) =
                        serviceTier(JsonField.ofNullable(serviceTier))

                    /** Alias for calling [Builder.serviceTier] with `serviceTier.orElse(null)`. */
                    fun serviceTier(serviceTier: Optional<String>) =
                        serviceTier(serviceTier.getOrNull())

                    /**
                     * Sets [Builder.serviceTier] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.serviceTier] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
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
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
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
                     * Returns an immutable instance of [OrganizationUsageCompletionsResult].
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
                    fun build(): OrganizationUsageCompletionsResult =
                        OrganizationUsageCompletionsResult(
                            checkRequired("inputTokens", inputTokens),
                            checkRequired("numModelRequests", numModelRequests),
                            object_,
                            checkRequired("outputTokens", outputTokens),
                            apiKeyId,
                            batch,
                            inputAudioTokens,
                            inputCachedTokens,
                            model,
                            outputAudioTokens,
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
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): OrganizationUsageCompletionsResult = apply {
                    if (validated) {
                        return@apply
                    }

                    inputTokens()
                    numModelRequests()
                    _object_().let {
                        if (it != JsonValue.from("organization.usage.completions.result")) {
                            throw OpenAIInvalidDataException("'object_' is invalid, received $it")
                        }
                    }
                    outputTokens()
                    apiKeyId()
                    batch()
                    inputAudioTokens()
                    inputCachedTokens()
                    model()
                    outputAudioTokens()
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
                            if (it == JsonValue.from("organization.usage.completions.result")) 1
                            else 0
                        } +
                        (if (outputTokens.asKnown().isPresent) 1 else 0) +
                        (if (apiKeyId.asKnown().isPresent) 1 else 0) +
                        (if (batch.asKnown().isPresent) 1 else 0) +
                        (if (inputAudioTokens.asKnown().isPresent) 1 else 0) +
                        (if (inputCachedTokens.asKnown().isPresent) 1 else 0) +
                        (if (model.asKnown().isPresent) 1 else 0) +
                        (if (outputAudioTokens.asKnown().isPresent) 1 else 0) +
                        (if (projectId.asKnown().isPresent) 1 else 0) +
                        (if (serviceTier.asKnown().isPresent) 1 else 0) +
                        (if (userId.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is OrganizationUsageCompletionsResult &&
                        inputTokens == other.inputTokens &&
                        numModelRequests == other.numModelRequests &&
                        object_ == other.object_ &&
                        outputTokens == other.outputTokens &&
                        apiKeyId == other.apiKeyId &&
                        batch == other.batch &&
                        inputAudioTokens == other.inputAudioTokens &&
                        inputCachedTokens == other.inputCachedTokens &&
                        model == other.model &&
                        outputAudioTokens == other.outputAudioTokens &&
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
                        batch,
                        inputAudioTokens,
                        inputCachedTokens,
                        model,
                        outputAudioTokens,
                        projectId,
                        serviceTier,
                        userId,
                        additionalProperties,
                    )
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "OrganizationUsageCompletionsResult{inputTokens=$inputTokens, numModelRequests=$numModelRequests, object_=$object_, outputTokens=$outputTokens, apiKeyId=$apiKeyId, batch=$batch, inputAudioTokens=$inputAudioTokens, inputCachedTokens=$inputCachedTokens, model=$model, outputAudioTokens=$outputAudioTokens, projectId=$projectId, serviceTier=$serviceTier, userId=$userId, additionalProperties=$additionalProperties}"
            }

            /** The aggregated embeddings usage details of the specific time bucket. */
            class OrganizationUsageEmbeddingsResult
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val inputTokens: JsonField<Long>,
                private val numModelRequests: JsonField<Long>,
                private val object_: JsonValue,
                private val apiKeyId: JsonField<String>,
                private val model: JsonField<String>,
                private val projectId: JsonField<String>,
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
                    @JsonProperty("api_key_id")
                    @ExcludeMissing
                    apiKeyId: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("model")
                    @ExcludeMissing
                    model: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("project_id")
                    @ExcludeMissing
                    projectId: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("user_id")
                    @ExcludeMissing
                    userId: JsonField<String> = JsonMissing.of(),
                ) : this(
                    inputTokens,
                    numModelRequests,
                    object_,
                    apiKeyId,
                    model,
                    projectId,
                    userId,
                    mutableMapOf(),
                )

                /**
                 * The aggregated number of input tokens used.
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
                 * JsonValue.from("organization.usage.embeddings.result")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

                /**
                 * When `group_by=api_key_id`, this field provides the API key ID of the grouped
                 * usage result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun apiKeyId(): Optional<String> = apiKeyId.getOptional("api_key_id")

                /**
                 * When `group_by=model`, this field provides the model name of the grouped usage
                 * result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun model(): Optional<String> = model.getOptional("model")

                /**
                 * When `group_by=project_id`, this field provides the project ID of the grouped
                 * usage result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun projectId(): Optional<String> = projectId.getOptional("project_id")

                /**
                 * When `group_by=user_id`, this field provides the user ID of the grouped usage
                 * result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun userId(): Optional<String> = userId.getOptional("user_id")

                /**
                 * Returns the raw JSON value of [inputTokens].
                 *
                 * Unlike [inputTokens], this method doesn't throw if the JSON field has an
                 * unexpected type.
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
                 * Returns the raw JSON value of [apiKeyId].
                 *
                 * Unlike [apiKeyId], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("api_key_id")
                @ExcludeMissing
                fun _apiKeyId(): JsonField<String> = apiKeyId

                /**
                 * Returns the raw JSON value of [model].
                 *
                 * Unlike [model], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

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
                 * Returns the raw JSON value of [userId].
                 *
                 * Unlike [userId], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("user_id") @ExcludeMissing fun _userId(): JsonField<String> = userId

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
                     * [OrganizationUsageEmbeddingsResult].
                     *
                     * The following fields are required:
                     * ```java
                     * .inputTokens()
                     * .numModelRequests()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [OrganizationUsageEmbeddingsResult]. */
                class Builder internal constructor() {

                    private var inputTokens: JsonField<Long>? = null
                    private var numModelRequests: JsonField<Long>? = null
                    private var object_: JsonValue =
                        JsonValue.from("organization.usage.embeddings.result")
                    private var apiKeyId: JsonField<String> = JsonMissing.of()
                    private var model: JsonField<String> = JsonMissing.of()
                    private var projectId: JsonField<String> = JsonMissing.of()
                    private var userId: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(
                        organizationUsageEmbeddingsResult: OrganizationUsageEmbeddingsResult
                    ) = apply {
                        inputTokens = organizationUsageEmbeddingsResult.inputTokens
                        numModelRequests = organizationUsageEmbeddingsResult.numModelRequests
                        object_ = organizationUsageEmbeddingsResult.object_
                        apiKeyId = organizationUsageEmbeddingsResult.apiKeyId
                        model = organizationUsageEmbeddingsResult.model
                        projectId = organizationUsageEmbeddingsResult.projectId
                        userId = organizationUsageEmbeddingsResult.userId
                        additionalProperties =
                            organizationUsageEmbeddingsResult.additionalProperties.toMutableMap()
                    }

                    /** The aggregated number of input tokens used. */
                    fun inputTokens(inputTokens: Long) = inputTokens(JsonField.of(inputTokens))

                    /**
                     * Sets [Builder.inputTokens] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.inputTokens] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
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
                     * You should usually call [Builder.numModelRequests] with a well-typed [Long]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun numModelRequests(numModelRequests: JsonField<Long>) = apply {
                        this.numModelRequests = numModelRequests
                    }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("organization.usage.embeddings.result")
                     * ```
                     *
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
                     */
                    fun object_(object_: JsonValue) = apply { this.object_ = object_ }

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
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun apiKeyId(apiKeyId: JsonField<String>) = apply { this.apiKeyId = apiKeyId }

                    /**
                     * When `group_by=model`, this field provides the model name of the grouped
                     * usage result.
                     */
                    fun model(model: String?) = model(JsonField.ofNullable(model))

                    /** Alias for calling [Builder.model] with `model.orElse(null)`. */
                    fun model(model: Optional<String>) = model(model.getOrNull())

                    /**
                     * Sets [Builder.model] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.model] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun model(model: JsonField<String>) = apply { this.model = model }

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
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun projectId(projectId: JsonField<String>) = apply {
                        this.projectId = projectId
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
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
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
                     * Returns an immutable instance of [OrganizationUsageEmbeddingsResult].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .inputTokens()
                     * .numModelRequests()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): OrganizationUsageEmbeddingsResult =
                        OrganizationUsageEmbeddingsResult(
                            checkRequired("inputTokens", inputTokens),
                            checkRequired("numModelRequests", numModelRequests),
                            object_,
                            apiKeyId,
                            model,
                            projectId,
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
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): OrganizationUsageEmbeddingsResult = apply {
                    if (validated) {
                        return@apply
                    }

                    inputTokens()
                    numModelRequests()
                    _object_().let {
                        if (it != JsonValue.from("organization.usage.embeddings.result")) {
                            throw OpenAIInvalidDataException("'object_' is invalid, received $it")
                        }
                    }
                    apiKeyId()
                    model()
                    projectId()
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
                            if (it == JsonValue.from("organization.usage.embeddings.result")) 1
                            else 0
                        } +
                        (if (apiKeyId.asKnown().isPresent) 1 else 0) +
                        (if (model.asKnown().isPresent) 1 else 0) +
                        (if (projectId.asKnown().isPresent) 1 else 0) +
                        (if (userId.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is OrganizationUsageEmbeddingsResult &&
                        inputTokens == other.inputTokens &&
                        numModelRequests == other.numModelRequests &&
                        object_ == other.object_ &&
                        apiKeyId == other.apiKeyId &&
                        model == other.model &&
                        projectId == other.projectId &&
                        userId == other.userId &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(
                        inputTokens,
                        numModelRequests,
                        object_,
                        apiKeyId,
                        model,
                        projectId,
                        userId,
                        additionalProperties,
                    )
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "OrganizationUsageEmbeddingsResult{inputTokens=$inputTokens, numModelRequests=$numModelRequests, object_=$object_, apiKeyId=$apiKeyId, model=$model, projectId=$projectId, userId=$userId, additionalProperties=$additionalProperties}"
            }

            /** The aggregated moderations usage details of the specific time bucket. */
            class OrganizationUsageModerationsResult
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val inputTokens: JsonField<Long>,
                private val numModelRequests: JsonField<Long>,
                private val object_: JsonValue,
                private val apiKeyId: JsonField<String>,
                private val model: JsonField<String>,
                private val projectId: JsonField<String>,
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
                    @JsonProperty("api_key_id")
                    @ExcludeMissing
                    apiKeyId: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("model")
                    @ExcludeMissing
                    model: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("project_id")
                    @ExcludeMissing
                    projectId: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("user_id")
                    @ExcludeMissing
                    userId: JsonField<String> = JsonMissing.of(),
                ) : this(
                    inputTokens,
                    numModelRequests,
                    object_,
                    apiKeyId,
                    model,
                    projectId,
                    userId,
                    mutableMapOf(),
                )

                /**
                 * The aggregated number of input tokens used.
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
                 * JsonValue.from("organization.usage.moderations.result")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

                /**
                 * When `group_by=api_key_id`, this field provides the API key ID of the grouped
                 * usage result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun apiKeyId(): Optional<String> = apiKeyId.getOptional("api_key_id")

                /**
                 * When `group_by=model`, this field provides the model name of the grouped usage
                 * result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun model(): Optional<String> = model.getOptional("model")

                /**
                 * When `group_by=project_id`, this field provides the project ID of the grouped
                 * usage result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun projectId(): Optional<String> = projectId.getOptional("project_id")

                /**
                 * When `group_by=user_id`, this field provides the user ID of the grouped usage
                 * result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun userId(): Optional<String> = userId.getOptional("user_id")

                /**
                 * Returns the raw JSON value of [inputTokens].
                 *
                 * Unlike [inputTokens], this method doesn't throw if the JSON field has an
                 * unexpected type.
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
                 * Returns the raw JSON value of [apiKeyId].
                 *
                 * Unlike [apiKeyId], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("api_key_id")
                @ExcludeMissing
                fun _apiKeyId(): JsonField<String> = apiKeyId

                /**
                 * Returns the raw JSON value of [model].
                 *
                 * Unlike [model], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

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
                 * Returns the raw JSON value of [userId].
                 *
                 * Unlike [userId], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("user_id") @ExcludeMissing fun _userId(): JsonField<String> = userId

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
                     * [OrganizationUsageModerationsResult].
                     *
                     * The following fields are required:
                     * ```java
                     * .inputTokens()
                     * .numModelRequests()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [OrganizationUsageModerationsResult]. */
                class Builder internal constructor() {

                    private var inputTokens: JsonField<Long>? = null
                    private var numModelRequests: JsonField<Long>? = null
                    private var object_: JsonValue =
                        JsonValue.from("organization.usage.moderations.result")
                    private var apiKeyId: JsonField<String> = JsonMissing.of()
                    private var model: JsonField<String> = JsonMissing.of()
                    private var projectId: JsonField<String> = JsonMissing.of()
                    private var userId: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(
                        organizationUsageModerationsResult: OrganizationUsageModerationsResult
                    ) = apply {
                        inputTokens = organizationUsageModerationsResult.inputTokens
                        numModelRequests = organizationUsageModerationsResult.numModelRequests
                        object_ = organizationUsageModerationsResult.object_
                        apiKeyId = organizationUsageModerationsResult.apiKeyId
                        model = organizationUsageModerationsResult.model
                        projectId = organizationUsageModerationsResult.projectId
                        userId = organizationUsageModerationsResult.userId
                        additionalProperties =
                            organizationUsageModerationsResult.additionalProperties.toMutableMap()
                    }

                    /** The aggregated number of input tokens used. */
                    fun inputTokens(inputTokens: Long) = inputTokens(JsonField.of(inputTokens))

                    /**
                     * Sets [Builder.inputTokens] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.inputTokens] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
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
                     * You should usually call [Builder.numModelRequests] with a well-typed [Long]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun numModelRequests(numModelRequests: JsonField<Long>) = apply {
                        this.numModelRequests = numModelRequests
                    }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("organization.usage.moderations.result")
                     * ```
                     *
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
                     */
                    fun object_(object_: JsonValue) = apply { this.object_ = object_ }

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
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun apiKeyId(apiKeyId: JsonField<String>) = apply { this.apiKeyId = apiKeyId }

                    /**
                     * When `group_by=model`, this field provides the model name of the grouped
                     * usage result.
                     */
                    fun model(model: String?) = model(JsonField.ofNullable(model))

                    /** Alias for calling [Builder.model] with `model.orElse(null)`. */
                    fun model(model: Optional<String>) = model(model.getOrNull())

                    /**
                     * Sets [Builder.model] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.model] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun model(model: JsonField<String>) = apply { this.model = model }

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
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun projectId(projectId: JsonField<String>) = apply {
                        this.projectId = projectId
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
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
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
                     * Returns an immutable instance of [OrganizationUsageModerationsResult].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .inputTokens()
                     * .numModelRequests()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): OrganizationUsageModerationsResult =
                        OrganizationUsageModerationsResult(
                            checkRequired("inputTokens", inputTokens),
                            checkRequired("numModelRequests", numModelRequests),
                            object_,
                            apiKeyId,
                            model,
                            projectId,
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
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): OrganizationUsageModerationsResult = apply {
                    if (validated) {
                        return@apply
                    }

                    inputTokens()
                    numModelRequests()
                    _object_().let {
                        if (it != JsonValue.from("organization.usage.moderations.result")) {
                            throw OpenAIInvalidDataException("'object_' is invalid, received $it")
                        }
                    }
                    apiKeyId()
                    model()
                    projectId()
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
                            if (it == JsonValue.from("organization.usage.moderations.result")) 1
                            else 0
                        } +
                        (if (apiKeyId.asKnown().isPresent) 1 else 0) +
                        (if (model.asKnown().isPresent) 1 else 0) +
                        (if (projectId.asKnown().isPresent) 1 else 0) +
                        (if (userId.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is OrganizationUsageModerationsResult &&
                        inputTokens == other.inputTokens &&
                        numModelRequests == other.numModelRequests &&
                        object_ == other.object_ &&
                        apiKeyId == other.apiKeyId &&
                        model == other.model &&
                        projectId == other.projectId &&
                        userId == other.userId &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(
                        inputTokens,
                        numModelRequests,
                        object_,
                        apiKeyId,
                        model,
                        projectId,
                        userId,
                        additionalProperties,
                    )
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "OrganizationUsageModerationsResult{inputTokens=$inputTokens, numModelRequests=$numModelRequests, object_=$object_, apiKeyId=$apiKeyId, model=$model, projectId=$projectId, userId=$userId, additionalProperties=$additionalProperties}"
            }

            /** The aggregated images usage details of the specific time bucket. */
            class OrganizationUsageImagesResult
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val images: JsonField<Long>,
                private val numModelRequests: JsonField<Long>,
                private val object_: JsonValue,
                private val apiKeyId: JsonField<String>,
                private val model: JsonField<String>,
                private val projectId: JsonField<String>,
                private val size: JsonField<String>,
                private val source: JsonField<String>,
                private val userId: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("images")
                    @ExcludeMissing
                    images: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("num_model_requests")
                    @ExcludeMissing
                    numModelRequests: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
                    @JsonProperty("api_key_id")
                    @ExcludeMissing
                    apiKeyId: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("model")
                    @ExcludeMissing
                    model: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("project_id")
                    @ExcludeMissing
                    projectId: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("size")
                    @ExcludeMissing
                    size: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("source")
                    @ExcludeMissing
                    source: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("user_id")
                    @ExcludeMissing
                    userId: JsonField<String> = JsonMissing.of(),
                ) : this(
                    images,
                    numModelRequests,
                    object_,
                    apiKeyId,
                    model,
                    projectId,
                    size,
                    source,
                    userId,
                    mutableMapOf(),
                )

                /**
                 * The number of images processed.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun images(): Long = images.getRequired("images")

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
                 * JsonValue.from("organization.usage.images.result")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

                /**
                 * When `group_by=api_key_id`, this field provides the API key ID of the grouped
                 * usage result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun apiKeyId(): Optional<String> = apiKeyId.getOptional("api_key_id")

                /**
                 * When `group_by=model`, this field provides the model name of the grouped usage
                 * result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun model(): Optional<String> = model.getOptional("model")

                /**
                 * When `group_by=project_id`, this field provides the project ID of the grouped
                 * usage result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun projectId(): Optional<String> = projectId.getOptional("project_id")

                /**
                 * When `group_by=size`, this field provides the image size of the grouped usage
                 * result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun size(): Optional<String> = size.getOptional("size")

                /**
                 * When `group_by=source`, this field provides the source of the grouped usage
                 * result, possible values are `image.generation`, `image.edit`, `image.variation`.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun source(): Optional<String> = source.getOptional("source")

                /**
                 * When `group_by=user_id`, this field provides the user ID of the grouped usage
                 * result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun userId(): Optional<String> = userId.getOptional("user_id")

                /**
                 * Returns the raw JSON value of [images].
                 *
                 * Unlike [images], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("images") @ExcludeMissing fun _images(): JsonField<Long> = images

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
                 * Returns the raw JSON value of [apiKeyId].
                 *
                 * Unlike [apiKeyId], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("api_key_id")
                @ExcludeMissing
                fun _apiKeyId(): JsonField<String> = apiKeyId

                /**
                 * Returns the raw JSON value of [model].
                 *
                 * Unlike [model], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

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
                 * Returns the raw JSON value of [size].
                 *
                 * Unlike [size], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("size") @ExcludeMissing fun _size(): JsonField<String> = size

                /**
                 * Returns the raw JSON value of [source].
                 *
                 * Unlike [source], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("source") @ExcludeMissing fun _source(): JsonField<String> = source

                /**
                 * Returns the raw JSON value of [userId].
                 *
                 * Unlike [userId], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("user_id") @ExcludeMissing fun _userId(): JsonField<String> = userId

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
                     * [OrganizationUsageImagesResult].
                     *
                     * The following fields are required:
                     * ```java
                     * .images()
                     * .numModelRequests()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [OrganizationUsageImagesResult]. */
                class Builder internal constructor() {

                    private var images: JsonField<Long>? = null
                    private var numModelRequests: JsonField<Long>? = null
                    private var object_: JsonValue =
                        JsonValue.from("organization.usage.images.result")
                    private var apiKeyId: JsonField<String> = JsonMissing.of()
                    private var model: JsonField<String> = JsonMissing.of()
                    private var projectId: JsonField<String> = JsonMissing.of()
                    private var size: JsonField<String> = JsonMissing.of()
                    private var source: JsonField<String> = JsonMissing.of()
                    private var userId: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(
                        organizationUsageImagesResult: OrganizationUsageImagesResult
                    ) = apply {
                        images = organizationUsageImagesResult.images
                        numModelRequests = organizationUsageImagesResult.numModelRequests
                        object_ = organizationUsageImagesResult.object_
                        apiKeyId = organizationUsageImagesResult.apiKeyId
                        model = organizationUsageImagesResult.model
                        projectId = organizationUsageImagesResult.projectId
                        size = organizationUsageImagesResult.size
                        source = organizationUsageImagesResult.source
                        userId = organizationUsageImagesResult.userId
                        additionalProperties =
                            organizationUsageImagesResult.additionalProperties.toMutableMap()
                    }

                    /** The number of images processed. */
                    fun images(images: Long) = images(JsonField.of(images))

                    /**
                     * Sets [Builder.images] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.images] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun images(images: JsonField<Long>) = apply { this.images = images }

                    /** The count of requests made to the model. */
                    fun numModelRequests(numModelRequests: Long) =
                        numModelRequests(JsonField.of(numModelRequests))

                    /**
                     * Sets [Builder.numModelRequests] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.numModelRequests] with a well-typed [Long]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun numModelRequests(numModelRequests: JsonField<Long>) = apply {
                        this.numModelRequests = numModelRequests
                    }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("organization.usage.images.result")
                     * ```
                     *
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
                     */
                    fun object_(object_: JsonValue) = apply { this.object_ = object_ }

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
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun apiKeyId(apiKeyId: JsonField<String>) = apply { this.apiKeyId = apiKeyId }

                    /**
                     * When `group_by=model`, this field provides the model name of the grouped
                     * usage result.
                     */
                    fun model(model: String?) = model(JsonField.ofNullable(model))

                    /** Alias for calling [Builder.model] with `model.orElse(null)`. */
                    fun model(model: Optional<String>) = model(model.getOrNull())

                    /**
                     * Sets [Builder.model] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.model] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun model(model: JsonField<String>) = apply { this.model = model }

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
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun projectId(projectId: JsonField<String>) = apply {
                        this.projectId = projectId
                    }

                    /**
                     * When `group_by=size`, this field provides the image size of the grouped usage
                     * result.
                     */
                    fun size(size: String?) = size(JsonField.ofNullable(size))

                    /** Alias for calling [Builder.size] with `size.orElse(null)`. */
                    fun size(size: Optional<String>) = size(size.getOrNull())

                    /**
                     * Sets [Builder.size] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.size] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun size(size: JsonField<String>) = apply { this.size = size }

                    /**
                     * When `group_by=source`, this field provides the source of the grouped usage
                     * result, possible values are `image.generation`, `image.edit`,
                     * `image.variation`.
                     */
                    fun source(source: String?) = source(JsonField.ofNullable(source))

                    /** Alias for calling [Builder.source] with `source.orElse(null)`. */
                    fun source(source: Optional<String>) = source(source.getOrNull())

                    /**
                     * Sets [Builder.source] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.source] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun source(source: JsonField<String>) = apply { this.source = source }

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
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
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
                     * Returns an immutable instance of [OrganizationUsageImagesResult].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .images()
                     * .numModelRequests()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): OrganizationUsageImagesResult =
                        OrganizationUsageImagesResult(
                            checkRequired("images", images),
                            checkRequired("numModelRequests", numModelRequests),
                            object_,
                            apiKeyId,
                            model,
                            projectId,
                            size,
                            source,
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
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): OrganizationUsageImagesResult = apply {
                    if (validated) {
                        return@apply
                    }

                    images()
                    numModelRequests()
                    _object_().let {
                        if (it != JsonValue.from("organization.usage.images.result")) {
                            throw OpenAIInvalidDataException("'object_' is invalid, received $it")
                        }
                    }
                    apiKeyId()
                    model()
                    projectId()
                    size()
                    source()
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
                    (if (images.asKnown().isPresent) 1 else 0) +
                        (if (numModelRequests.asKnown().isPresent) 1 else 0) +
                        object_.let {
                            if (it == JsonValue.from("organization.usage.images.result")) 1 else 0
                        } +
                        (if (apiKeyId.asKnown().isPresent) 1 else 0) +
                        (if (model.asKnown().isPresent) 1 else 0) +
                        (if (projectId.asKnown().isPresent) 1 else 0) +
                        (if (size.asKnown().isPresent) 1 else 0) +
                        (if (source.asKnown().isPresent) 1 else 0) +
                        (if (userId.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is OrganizationUsageImagesResult &&
                        images == other.images &&
                        numModelRequests == other.numModelRequests &&
                        object_ == other.object_ &&
                        apiKeyId == other.apiKeyId &&
                        model == other.model &&
                        projectId == other.projectId &&
                        size == other.size &&
                        source == other.source &&
                        userId == other.userId &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(
                        images,
                        numModelRequests,
                        object_,
                        apiKeyId,
                        model,
                        projectId,
                        size,
                        source,
                        userId,
                        additionalProperties,
                    )
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "OrganizationUsageImagesResult{images=$images, numModelRequests=$numModelRequests, object_=$object_, apiKeyId=$apiKeyId, model=$model, projectId=$projectId, size=$size, source=$source, userId=$userId, additionalProperties=$additionalProperties}"
            }

            /** The aggregated audio speeches usage details of the specific time bucket. */
            class OrganizationUsageAudioSpeechesResult
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val characters: JsonField<Long>,
                private val numModelRequests: JsonField<Long>,
                private val object_: JsonValue,
                private val apiKeyId: JsonField<String>,
                private val model: JsonField<String>,
                private val projectId: JsonField<String>,
                private val userId: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("characters")
                    @ExcludeMissing
                    characters: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("num_model_requests")
                    @ExcludeMissing
                    numModelRequests: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
                    @JsonProperty("api_key_id")
                    @ExcludeMissing
                    apiKeyId: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("model")
                    @ExcludeMissing
                    model: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("project_id")
                    @ExcludeMissing
                    projectId: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("user_id")
                    @ExcludeMissing
                    userId: JsonField<String> = JsonMissing.of(),
                ) : this(
                    characters,
                    numModelRequests,
                    object_,
                    apiKeyId,
                    model,
                    projectId,
                    userId,
                    mutableMapOf(),
                )

                /**
                 * The number of characters processed.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun characters(): Long = characters.getRequired("characters")

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
                 * JsonValue.from("organization.usage.audio_speeches.result")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

                /**
                 * When `group_by=api_key_id`, this field provides the API key ID of the grouped
                 * usage result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun apiKeyId(): Optional<String> = apiKeyId.getOptional("api_key_id")

                /**
                 * When `group_by=model`, this field provides the model name of the grouped usage
                 * result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun model(): Optional<String> = model.getOptional("model")

                /**
                 * When `group_by=project_id`, this field provides the project ID of the grouped
                 * usage result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun projectId(): Optional<String> = projectId.getOptional("project_id")

                /**
                 * When `group_by=user_id`, this field provides the user ID of the grouped usage
                 * result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun userId(): Optional<String> = userId.getOptional("user_id")

                /**
                 * Returns the raw JSON value of [characters].
                 *
                 * Unlike [characters], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("characters")
                @ExcludeMissing
                fun _characters(): JsonField<Long> = characters

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
                 * Returns the raw JSON value of [apiKeyId].
                 *
                 * Unlike [apiKeyId], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("api_key_id")
                @ExcludeMissing
                fun _apiKeyId(): JsonField<String> = apiKeyId

                /**
                 * Returns the raw JSON value of [model].
                 *
                 * Unlike [model], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

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
                 * Returns the raw JSON value of [userId].
                 *
                 * Unlike [userId], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("user_id") @ExcludeMissing fun _userId(): JsonField<String> = userId

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
                     * [OrganizationUsageAudioSpeechesResult].
                     *
                     * The following fields are required:
                     * ```java
                     * .characters()
                     * .numModelRequests()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [OrganizationUsageAudioSpeechesResult]. */
                class Builder internal constructor() {

                    private var characters: JsonField<Long>? = null
                    private var numModelRequests: JsonField<Long>? = null
                    private var object_: JsonValue =
                        JsonValue.from("organization.usage.audio_speeches.result")
                    private var apiKeyId: JsonField<String> = JsonMissing.of()
                    private var model: JsonField<String> = JsonMissing.of()
                    private var projectId: JsonField<String> = JsonMissing.of()
                    private var userId: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(
                        organizationUsageAudioSpeechesResult: OrganizationUsageAudioSpeechesResult
                    ) = apply {
                        characters = organizationUsageAudioSpeechesResult.characters
                        numModelRequests = organizationUsageAudioSpeechesResult.numModelRequests
                        object_ = organizationUsageAudioSpeechesResult.object_
                        apiKeyId = organizationUsageAudioSpeechesResult.apiKeyId
                        model = organizationUsageAudioSpeechesResult.model
                        projectId = organizationUsageAudioSpeechesResult.projectId
                        userId = organizationUsageAudioSpeechesResult.userId
                        additionalProperties =
                            organizationUsageAudioSpeechesResult.additionalProperties.toMutableMap()
                    }

                    /** The number of characters processed. */
                    fun characters(characters: Long) = characters(JsonField.of(characters))

                    /**
                     * Sets [Builder.characters] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.characters] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun characters(characters: JsonField<Long>) = apply {
                        this.characters = characters
                    }

                    /** The count of requests made to the model. */
                    fun numModelRequests(numModelRequests: Long) =
                        numModelRequests(JsonField.of(numModelRequests))

                    /**
                     * Sets [Builder.numModelRequests] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.numModelRequests] with a well-typed [Long]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun numModelRequests(numModelRequests: JsonField<Long>) = apply {
                        this.numModelRequests = numModelRequests
                    }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("organization.usage.audio_speeches.result")
                     * ```
                     *
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
                     */
                    fun object_(object_: JsonValue) = apply { this.object_ = object_ }

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
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun apiKeyId(apiKeyId: JsonField<String>) = apply { this.apiKeyId = apiKeyId }

                    /**
                     * When `group_by=model`, this field provides the model name of the grouped
                     * usage result.
                     */
                    fun model(model: String?) = model(JsonField.ofNullable(model))

                    /** Alias for calling [Builder.model] with `model.orElse(null)`. */
                    fun model(model: Optional<String>) = model(model.getOrNull())

                    /**
                     * Sets [Builder.model] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.model] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun model(model: JsonField<String>) = apply { this.model = model }

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
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun projectId(projectId: JsonField<String>) = apply {
                        this.projectId = projectId
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
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
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
                     * Returns an immutable instance of [OrganizationUsageAudioSpeechesResult].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .characters()
                     * .numModelRequests()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): OrganizationUsageAudioSpeechesResult =
                        OrganizationUsageAudioSpeechesResult(
                            checkRequired("characters", characters),
                            checkRequired("numModelRequests", numModelRequests),
                            object_,
                            apiKeyId,
                            model,
                            projectId,
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
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): OrganizationUsageAudioSpeechesResult = apply {
                    if (validated) {
                        return@apply
                    }

                    characters()
                    numModelRequests()
                    _object_().let {
                        if (it != JsonValue.from("organization.usage.audio_speeches.result")) {
                            throw OpenAIInvalidDataException("'object_' is invalid, received $it")
                        }
                    }
                    apiKeyId()
                    model()
                    projectId()
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
                    (if (characters.asKnown().isPresent) 1 else 0) +
                        (if (numModelRequests.asKnown().isPresent) 1 else 0) +
                        object_.let {
                            if (it == JsonValue.from("organization.usage.audio_speeches.result")) 1
                            else 0
                        } +
                        (if (apiKeyId.asKnown().isPresent) 1 else 0) +
                        (if (model.asKnown().isPresent) 1 else 0) +
                        (if (projectId.asKnown().isPresent) 1 else 0) +
                        (if (userId.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is OrganizationUsageAudioSpeechesResult &&
                        characters == other.characters &&
                        numModelRequests == other.numModelRequests &&
                        object_ == other.object_ &&
                        apiKeyId == other.apiKeyId &&
                        model == other.model &&
                        projectId == other.projectId &&
                        userId == other.userId &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(
                        characters,
                        numModelRequests,
                        object_,
                        apiKeyId,
                        model,
                        projectId,
                        userId,
                        additionalProperties,
                    )
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "OrganizationUsageAudioSpeechesResult{characters=$characters, numModelRequests=$numModelRequests, object_=$object_, apiKeyId=$apiKeyId, model=$model, projectId=$projectId, userId=$userId, additionalProperties=$additionalProperties}"
            }

            /** The aggregated audio transcriptions usage details of the specific time bucket. */
            class OrganizationUsageAudioTranscriptionsResult
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val numModelRequests: JsonField<Long>,
                private val object_: JsonValue,
                private val seconds: JsonField<Long>,
                private val apiKeyId: JsonField<String>,
                private val model: JsonField<String>,
                private val projectId: JsonField<String>,
                private val userId: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("num_model_requests")
                    @ExcludeMissing
                    numModelRequests: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
                    @JsonProperty("seconds")
                    @ExcludeMissing
                    seconds: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("api_key_id")
                    @ExcludeMissing
                    apiKeyId: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("model")
                    @ExcludeMissing
                    model: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("project_id")
                    @ExcludeMissing
                    projectId: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("user_id")
                    @ExcludeMissing
                    userId: JsonField<String> = JsonMissing.of(),
                ) : this(
                    numModelRequests,
                    object_,
                    seconds,
                    apiKeyId,
                    model,
                    projectId,
                    userId,
                    mutableMapOf(),
                )

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
                 * JsonValue.from("organization.usage.audio_transcriptions.result")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

                /**
                 * The number of seconds processed.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun seconds(): Long = seconds.getRequired("seconds")

                /**
                 * When `group_by=api_key_id`, this field provides the API key ID of the grouped
                 * usage result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun apiKeyId(): Optional<String> = apiKeyId.getOptional("api_key_id")

                /**
                 * When `group_by=model`, this field provides the model name of the grouped usage
                 * result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun model(): Optional<String> = model.getOptional("model")

                /**
                 * When `group_by=project_id`, this field provides the project ID of the grouped
                 * usage result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun projectId(): Optional<String> = projectId.getOptional("project_id")

                /**
                 * When `group_by=user_id`, this field provides the user ID of the grouped usage
                 * result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun userId(): Optional<String> = userId.getOptional("user_id")

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
                 * Returns the raw JSON value of [seconds].
                 *
                 * Unlike [seconds], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("seconds") @ExcludeMissing fun _seconds(): JsonField<Long> = seconds

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
                 * Returns the raw JSON value of [model].
                 *
                 * Unlike [model], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

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
                 * Returns the raw JSON value of [userId].
                 *
                 * Unlike [userId], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("user_id") @ExcludeMissing fun _userId(): JsonField<String> = userId

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
                     * [OrganizationUsageAudioTranscriptionsResult].
                     *
                     * The following fields are required:
                     * ```java
                     * .numModelRequests()
                     * .seconds()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [OrganizationUsageAudioTranscriptionsResult]. */
                class Builder internal constructor() {

                    private var numModelRequests: JsonField<Long>? = null
                    private var object_: JsonValue =
                        JsonValue.from("organization.usage.audio_transcriptions.result")
                    private var seconds: JsonField<Long>? = null
                    private var apiKeyId: JsonField<String> = JsonMissing.of()
                    private var model: JsonField<String> = JsonMissing.of()
                    private var projectId: JsonField<String> = JsonMissing.of()
                    private var userId: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(
                        organizationUsageAudioTranscriptionsResult:
                            OrganizationUsageAudioTranscriptionsResult
                    ) = apply {
                        numModelRequests =
                            organizationUsageAudioTranscriptionsResult.numModelRequests
                        object_ = organizationUsageAudioTranscriptionsResult.object_
                        seconds = organizationUsageAudioTranscriptionsResult.seconds
                        apiKeyId = organizationUsageAudioTranscriptionsResult.apiKeyId
                        model = organizationUsageAudioTranscriptionsResult.model
                        projectId = organizationUsageAudioTranscriptionsResult.projectId
                        userId = organizationUsageAudioTranscriptionsResult.userId
                        additionalProperties =
                            organizationUsageAudioTranscriptionsResult.additionalProperties
                                .toMutableMap()
                    }

                    /** The count of requests made to the model. */
                    fun numModelRequests(numModelRequests: Long) =
                        numModelRequests(JsonField.of(numModelRequests))

                    /**
                     * Sets [Builder.numModelRequests] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.numModelRequests] with a well-typed [Long]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun numModelRequests(numModelRequests: JsonField<Long>) = apply {
                        this.numModelRequests = numModelRequests
                    }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("organization.usage.audio_transcriptions.result")
                     * ```
                     *
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
                     */
                    fun object_(object_: JsonValue) = apply { this.object_ = object_ }

                    /** The number of seconds processed. */
                    fun seconds(seconds: Long) = seconds(JsonField.of(seconds))

                    /**
                     * Sets [Builder.seconds] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.seconds] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun seconds(seconds: JsonField<Long>) = apply { this.seconds = seconds }

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
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun apiKeyId(apiKeyId: JsonField<String>) = apply { this.apiKeyId = apiKeyId }

                    /**
                     * When `group_by=model`, this field provides the model name of the grouped
                     * usage result.
                     */
                    fun model(model: String?) = model(JsonField.ofNullable(model))

                    /** Alias for calling [Builder.model] with `model.orElse(null)`. */
                    fun model(model: Optional<String>) = model(model.getOrNull())

                    /**
                     * Sets [Builder.model] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.model] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun model(model: JsonField<String>) = apply { this.model = model }

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
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun projectId(projectId: JsonField<String>) = apply {
                        this.projectId = projectId
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
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
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
                     * Returns an immutable instance of
                     * [OrganizationUsageAudioTranscriptionsResult].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .numModelRequests()
                     * .seconds()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): OrganizationUsageAudioTranscriptionsResult =
                        OrganizationUsageAudioTranscriptionsResult(
                            checkRequired("numModelRequests", numModelRequests),
                            object_,
                            checkRequired("seconds", seconds),
                            apiKeyId,
                            model,
                            projectId,
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
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): OrganizationUsageAudioTranscriptionsResult = apply {
                    if (validated) {
                        return@apply
                    }

                    numModelRequests()
                    _object_().let {
                        if (
                            it != JsonValue.from("organization.usage.audio_transcriptions.result")
                        ) {
                            throw OpenAIInvalidDataException("'object_' is invalid, received $it")
                        }
                    }
                    seconds()
                    apiKeyId()
                    model()
                    projectId()
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
                    (if (numModelRequests.asKnown().isPresent) 1 else 0) +
                        object_.let {
                            if (
                                it ==
                                    JsonValue.from("organization.usage.audio_transcriptions.result")
                            )
                                1
                            else 0
                        } +
                        (if (seconds.asKnown().isPresent) 1 else 0) +
                        (if (apiKeyId.asKnown().isPresent) 1 else 0) +
                        (if (model.asKnown().isPresent) 1 else 0) +
                        (if (projectId.asKnown().isPresent) 1 else 0) +
                        (if (userId.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is OrganizationUsageAudioTranscriptionsResult &&
                        numModelRequests == other.numModelRequests &&
                        object_ == other.object_ &&
                        seconds == other.seconds &&
                        apiKeyId == other.apiKeyId &&
                        model == other.model &&
                        projectId == other.projectId &&
                        userId == other.userId &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(
                        numModelRequests,
                        object_,
                        seconds,
                        apiKeyId,
                        model,
                        projectId,
                        userId,
                        additionalProperties,
                    )
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "OrganizationUsageAudioTranscriptionsResult{numModelRequests=$numModelRequests, object_=$object_, seconds=$seconds, apiKeyId=$apiKeyId, model=$model, projectId=$projectId, userId=$userId, additionalProperties=$additionalProperties}"
            }

            /** The aggregated vector stores usage details of the specific time bucket. */
            class OrganizationUsageVectorStoresResult
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val object_: JsonValue,
                private val usageBytes: JsonField<Long>,
                private val projectId: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
                    @JsonProperty("usage_bytes")
                    @ExcludeMissing
                    usageBytes: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("project_id")
                    @ExcludeMissing
                    projectId: JsonField<String> = JsonMissing.of(),
                ) : this(object_, usageBytes, projectId, mutableMapOf())

                /**
                 * Expected to always return the following:
                 * ```java
                 * JsonValue.from("organization.usage.vector_stores.result")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

                /**
                 * The vector stores usage in bytes.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun usageBytes(): Long = usageBytes.getRequired("usage_bytes")

                /**
                 * When `group_by=project_id`, this field provides the project ID of the grouped
                 * usage result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun projectId(): Optional<String> = projectId.getOptional("project_id")

                /**
                 * Returns the raw JSON value of [usageBytes].
                 *
                 * Unlike [usageBytes], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("usage_bytes")
                @ExcludeMissing
                fun _usageBytes(): JsonField<Long> = usageBytes

                /**
                 * Returns the raw JSON value of [projectId].
                 *
                 * Unlike [projectId], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("project_id")
                @ExcludeMissing
                fun _projectId(): JsonField<String> = projectId

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
                     * [OrganizationUsageVectorStoresResult].
                     *
                     * The following fields are required:
                     * ```java
                     * .usageBytes()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [OrganizationUsageVectorStoresResult]. */
                class Builder internal constructor() {

                    private var object_: JsonValue =
                        JsonValue.from("organization.usage.vector_stores.result")
                    private var usageBytes: JsonField<Long>? = null
                    private var projectId: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(
                        organizationUsageVectorStoresResult: OrganizationUsageVectorStoresResult
                    ) = apply {
                        object_ = organizationUsageVectorStoresResult.object_
                        usageBytes = organizationUsageVectorStoresResult.usageBytes
                        projectId = organizationUsageVectorStoresResult.projectId
                        additionalProperties =
                            organizationUsageVectorStoresResult.additionalProperties.toMutableMap()
                    }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("organization.usage.vector_stores.result")
                     * ```
                     *
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
                     */
                    fun object_(object_: JsonValue) = apply { this.object_ = object_ }

                    /** The vector stores usage in bytes. */
                    fun usageBytes(usageBytes: Long) = usageBytes(JsonField.of(usageBytes))

                    /**
                     * Sets [Builder.usageBytes] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.usageBytes] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun usageBytes(usageBytes: JsonField<Long>) = apply {
                        this.usageBytes = usageBytes
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
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun projectId(projectId: JsonField<String>) = apply {
                        this.projectId = projectId
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
                     * Returns an immutable instance of [OrganizationUsageVectorStoresResult].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .usageBytes()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): OrganizationUsageVectorStoresResult =
                        OrganizationUsageVectorStoresResult(
                            object_,
                            checkRequired("usageBytes", usageBytes),
                            projectId,
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
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): OrganizationUsageVectorStoresResult = apply {
                    if (validated) {
                        return@apply
                    }

                    _object_().let {
                        if (it != JsonValue.from("organization.usage.vector_stores.result")) {
                            throw OpenAIInvalidDataException("'object_' is invalid, received $it")
                        }
                    }
                    usageBytes()
                    projectId()
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
                    object_.let {
                        if (it == JsonValue.from("organization.usage.vector_stores.result")) 1
                        else 0
                    } +
                        (if (usageBytes.asKnown().isPresent) 1 else 0) +
                        (if (projectId.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is OrganizationUsageVectorStoresResult &&
                        object_ == other.object_ &&
                        usageBytes == other.usageBytes &&
                        projectId == other.projectId &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(object_, usageBytes, projectId, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "OrganizationUsageVectorStoresResult{object_=$object_, usageBytes=$usageBytes, projectId=$projectId, additionalProperties=$additionalProperties}"
            }

            /**
             * The aggregated code interpreter sessions usage details of the specific time bucket.
             */
            class OrganizationUsageCodeInterpreterSessionsResult
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val numSessions: JsonField<Long>,
                private val object_: JsonValue,
                private val projectId: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("num_sessions")
                    @ExcludeMissing
                    numSessions: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
                    @JsonProperty("project_id")
                    @ExcludeMissing
                    projectId: JsonField<String> = JsonMissing.of(),
                ) : this(numSessions, object_, projectId, mutableMapOf())

                /**
                 * The number of code interpreter sessions.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun numSessions(): Long = numSessions.getRequired("num_sessions")

                /**
                 * Expected to always return the following:
                 * ```java
                 * JsonValue.from("organization.usage.code_interpreter_sessions.result")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

                /**
                 * When `group_by=project_id`, this field provides the project ID of the grouped
                 * usage result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun projectId(): Optional<String> = projectId.getOptional("project_id")

                /**
                 * Returns the raw JSON value of [numSessions].
                 *
                 * Unlike [numSessions], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("num_sessions")
                @ExcludeMissing
                fun _numSessions(): JsonField<Long> = numSessions

                /**
                 * Returns the raw JSON value of [projectId].
                 *
                 * Unlike [projectId], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("project_id")
                @ExcludeMissing
                fun _projectId(): JsonField<String> = projectId

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
                     * [OrganizationUsageCodeInterpreterSessionsResult].
                     *
                     * The following fields are required:
                     * ```java
                     * .numSessions()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [OrganizationUsageCodeInterpreterSessionsResult]. */
                class Builder internal constructor() {

                    private var numSessions: JsonField<Long>? = null
                    private var object_: JsonValue =
                        JsonValue.from("organization.usage.code_interpreter_sessions.result")
                    private var projectId: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(
                        organizationUsageCodeInterpreterSessionsResult:
                            OrganizationUsageCodeInterpreterSessionsResult
                    ) = apply {
                        numSessions = organizationUsageCodeInterpreterSessionsResult.numSessions
                        object_ = organizationUsageCodeInterpreterSessionsResult.object_
                        projectId = organizationUsageCodeInterpreterSessionsResult.projectId
                        additionalProperties =
                            organizationUsageCodeInterpreterSessionsResult.additionalProperties
                                .toMutableMap()
                    }

                    /** The number of code interpreter sessions. */
                    fun numSessions(numSessions: Long) = numSessions(JsonField.of(numSessions))

                    /**
                     * Sets [Builder.numSessions] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.numSessions] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun numSessions(numSessions: JsonField<Long>) = apply {
                        this.numSessions = numSessions
                    }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("organization.usage.code_interpreter_sessions.result")
                     * ```
                     *
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
                     */
                    fun object_(object_: JsonValue) = apply { this.object_ = object_ }

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
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun projectId(projectId: JsonField<String>) = apply {
                        this.projectId = projectId
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
                     * Returns an immutable instance of
                     * [OrganizationUsageCodeInterpreterSessionsResult].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .numSessions()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): OrganizationUsageCodeInterpreterSessionsResult =
                        OrganizationUsageCodeInterpreterSessionsResult(
                            checkRequired("numSessions", numSessions),
                            object_,
                            projectId,
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
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): OrganizationUsageCodeInterpreterSessionsResult = apply {
                    if (validated) {
                        return@apply
                    }

                    numSessions()
                    _object_().let {
                        if (
                            it !=
                                JsonValue.from(
                                    "organization.usage.code_interpreter_sessions.result"
                                )
                        ) {
                            throw OpenAIInvalidDataException("'object_' is invalid, received $it")
                        }
                    }
                    projectId()
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
                    (if (numSessions.asKnown().isPresent) 1 else 0) +
                        object_.let {
                            if (
                                it ==
                                    JsonValue.from(
                                        "organization.usage.code_interpreter_sessions.result"
                                    )
                            )
                                1
                            else 0
                        } +
                        (if (projectId.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is OrganizationUsageCodeInterpreterSessionsResult &&
                        numSessions == other.numSessions &&
                        object_ == other.object_ &&
                        projectId == other.projectId &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(numSessions, object_, projectId, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "OrganizationUsageCodeInterpreterSessionsResult{numSessions=$numSessions, object_=$object_, projectId=$projectId, additionalProperties=$additionalProperties}"
            }

            /** The aggregated file search calls usage details of the specific time bucket. */
            class OrganizationUsageFileSearchesResult
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val numRequests: JsonField<Long>,
                private val object_: JsonValue,
                private val apiKeyId: JsonField<String>,
                private val projectId: JsonField<String>,
                private val userId: JsonField<String>,
                private val vectorStoreId: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("num_requests")
                    @ExcludeMissing
                    numRequests: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
                    @JsonProperty("api_key_id")
                    @ExcludeMissing
                    apiKeyId: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("project_id")
                    @ExcludeMissing
                    projectId: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("user_id")
                    @ExcludeMissing
                    userId: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("vector_store_id")
                    @ExcludeMissing
                    vectorStoreId: JsonField<String> = JsonMissing.of(),
                ) : this(
                    numRequests,
                    object_,
                    apiKeyId,
                    projectId,
                    userId,
                    vectorStoreId,
                    mutableMapOf(),
                )

                /**
                 * The count of file search calls.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun numRequests(): Long = numRequests.getRequired("num_requests")

                /**
                 * Expected to always return the following:
                 * ```java
                 * JsonValue.from("organization.usage.file_searches.result")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

                /**
                 * When `group_by=api_key_id`, this field provides the API key ID of the grouped
                 * usage result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun apiKeyId(): Optional<String> = apiKeyId.getOptional("api_key_id")

                /**
                 * When `group_by=project_id`, this field provides the project ID of the grouped
                 * usage result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun projectId(): Optional<String> = projectId.getOptional("project_id")

                /**
                 * When `group_by=user_id`, this field provides the user ID of the grouped usage
                 * result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun userId(): Optional<String> = userId.getOptional("user_id")

                /**
                 * When `group_by=vector_store_id`, this field provides the vector store ID of the
                 * grouped usage result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun vectorStoreId(): Optional<String> = vectorStoreId.getOptional("vector_store_id")

                /**
                 * Returns the raw JSON value of [numRequests].
                 *
                 * Unlike [numRequests], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("num_requests")
                @ExcludeMissing
                fun _numRequests(): JsonField<Long> = numRequests

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
                 * Returns the raw JSON value of [projectId].
                 *
                 * Unlike [projectId], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("project_id")
                @ExcludeMissing
                fun _projectId(): JsonField<String> = projectId

                /**
                 * Returns the raw JSON value of [userId].
                 *
                 * Unlike [userId], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("user_id") @ExcludeMissing fun _userId(): JsonField<String> = userId

                /**
                 * Returns the raw JSON value of [vectorStoreId].
                 *
                 * Unlike [vectorStoreId], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("vector_store_id")
                @ExcludeMissing
                fun _vectorStoreId(): JsonField<String> = vectorStoreId

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
                     * [OrganizationUsageFileSearchesResult].
                     *
                     * The following fields are required:
                     * ```java
                     * .numRequests()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [OrganizationUsageFileSearchesResult]. */
                class Builder internal constructor() {

                    private var numRequests: JsonField<Long>? = null
                    private var object_: JsonValue =
                        JsonValue.from("organization.usage.file_searches.result")
                    private var apiKeyId: JsonField<String> = JsonMissing.of()
                    private var projectId: JsonField<String> = JsonMissing.of()
                    private var userId: JsonField<String> = JsonMissing.of()
                    private var vectorStoreId: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(
                        organizationUsageFileSearchesResult: OrganizationUsageFileSearchesResult
                    ) = apply {
                        numRequests = organizationUsageFileSearchesResult.numRequests
                        object_ = organizationUsageFileSearchesResult.object_
                        apiKeyId = organizationUsageFileSearchesResult.apiKeyId
                        projectId = organizationUsageFileSearchesResult.projectId
                        userId = organizationUsageFileSearchesResult.userId
                        vectorStoreId = organizationUsageFileSearchesResult.vectorStoreId
                        additionalProperties =
                            organizationUsageFileSearchesResult.additionalProperties.toMutableMap()
                    }

                    /** The count of file search calls. */
                    fun numRequests(numRequests: Long) = numRequests(JsonField.of(numRequests))

                    /**
                     * Sets [Builder.numRequests] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.numRequests] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun numRequests(numRequests: JsonField<Long>) = apply {
                        this.numRequests = numRequests
                    }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("organization.usage.file_searches.result")
                     * ```
                     *
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
                     */
                    fun object_(object_: JsonValue) = apply { this.object_ = object_ }

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
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun apiKeyId(apiKeyId: JsonField<String>) = apply { this.apiKeyId = apiKeyId }

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
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun projectId(projectId: JsonField<String>) = apply {
                        this.projectId = projectId
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
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun userId(userId: JsonField<String>) = apply { this.userId = userId }

                    /**
                     * When `group_by=vector_store_id`, this field provides the vector store ID of
                     * the grouped usage result.
                     */
                    fun vectorStoreId(vectorStoreId: String?) =
                        vectorStoreId(JsonField.ofNullable(vectorStoreId))

                    /**
                     * Alias for calling [Builder.vectorStoreId] with `vectorStoreId.orElse(null)`.
                     */
                    fun vectorStoreId(vectorStoreId: Optional<String>) =
                        vectorStoreId(vectorStoreId.getOrNull())

                    /**
                     * Sets [Builder.vectorStoreId] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.vectorStoreId] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun vectorStoreId(vectorStoreId: JsonField<String>) = apply {
                        this.vectorStoreId = vectorStoreId
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
                     * Returns an immutable instance of [OrganizationUsageFileSearchesResult].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .numRequests()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): OrganizationUsageFileSearchesResult =
                        OrganizationUsageFileSearchesResult(
                            checkRequired("numRequests", numRequests),
                            object_,
                            apiKeyId,
                            projectId,
                            userId,
                            vectorStoreId,
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
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): OrganizationUsageFileSearchesResult = apply {
                    if (validated) {
                        return@apply
                    }

                    numRequests()
                    _object_().let {
                        if (it != JsonValue.from("organization.usage.file_searches.result")) {
                            throw OpenAIInvalidDataException("'object_' is invalid, received $it")
                        }
                    }
                    apiKeyId()
                    projectId()
                    userId()
                    vectorStoreId()
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
                    (if (numRequests.asKnown().isPresent) 1 else 0) +
                        object_.let {
                            if (it == JsonValue.from("organization.usage.file_searches.result")) 1
                            else 0
                        } +
                        (if (apiKeyId.asKnown().isPresent) 1 else 0) +
                        (if (projectId.asKnown().isPresent) 1 else 0) +
                        (if (userId.asKnown().isPresent) 1 else 0) +
                        (if (vectorStoreId.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is OrganizationUsageFileSearchesResult &&
                        numRequests == other.numRequests &&
                        object_ == other.object_ &&
                        apiKeyId == other.apiKeyId &&
                        projectId == other.projectId &&
                        userId == other.userId &&
                        vectorStoreId == other.vectorStoreId &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(
                        numRequests,
                        object_,
                        apiKeyId,
                        projectId,
                        userId,
                        vectorStoreId,
                        additionalProperties,
                    )
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "OrganizationUsageFileSearchesResult{numRequests=$numRequests, object_=$object_, apiKeyId=$apiKeyId, projectId=$projectId, userId=$userId, vectorStoreId=$vectorStoreId, additionalProperties=$additionalProperties}"
            }

            /** The aggregated web search calls usage details of the specific time bucket. */
            class OrganizationUsageWebSearchesResult
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val numModelRequests: JsonField<Long>,
                private val numRequests: JsonField<Long>,
                private val object_: JsonValue,
                private val apiKeyId: JsonField<String>,
                private val contextLevel: JsonField<String>,
                private val model: JsonField<String>,
                private val projectId: JsonField<String>,
                private val userId: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("num_model_requests")
                    @ExcludeMissing
                    numModelRequests: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("num_requests")
                    @ExcludeMissing
                    numRequests: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
                    @JsonProperty("api_key_id")
                    @ExcludeMissing
                    apiKeyId: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("context_level")
                    @ExcludeMissing
                    contextLevel: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("model")
                    @ExcludeMissing
                    model: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("project_id")
                    @ExcludeMissing
                    projectId: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("user_id")
                    @ExcludeMissing
                    userId: JsonField<String> = JsonMissing.of(),
                ) : this(
                    numModelRequests,
                    numRequests,
                    object_,
                    apiKeyId,
                    contextLevel,
                    model,
                    projectId,
                    userId,
                    mutableMapOf(),
                )

                /**
                 * The count of model requests.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun numModelRequests(): Long = numModelRequests.getRequired("num_model_requests")

                /**
                 * The count of web search calls.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun numRequests(): Long = numRequests.getRequired("num_requests")

                /**
                 * Expected to always return the following:
                 * ```java
                 * JsonValue.from("organization.usage.web_searches.result")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

                /**
                 * When `group_by=api_key_id`, this field provides the API key ID of the grouped
                 * usage result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun apiKeyId(): Optional<String> = apiKeyId.getOptional("api_key_id")

                /**
                 * When `group_by=context_level`, this field provides the search context size of the
                 * grouped usage result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun contextLevel(): Optional<String> = contextLevel.getOptional("context_level")

                /**
                 * When `group_by=model`, this field provides the model name of the grouped usage
                 * result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun model(): Optional<String> = model.getOptional("model")

                /**
                 * When `group_by=project_id`, this field provides the project ID of the grouped
                 * usage result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun projectId(): Optional<String> = projectId.getOptional("project_id")

                /**
                 * When `group_by=user_id`, this field provides the user ID of the grouped usage
                 * result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun userId(): Optional<String> = userId.getOptional("user_id")

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
                 * Returns the raw JSON value of [numRequests].
                 *
                 * Unlike [numRequests], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("num_requests")
                @ExcludeMissing
                fun _numRequests(): JsonField<Long> = numRequests

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
                 * Returns the raw JSON value of [contextLevel].
                 *
                 * Unlike [contextLevel], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("context_level")
                @ExcludeMissing
                fun _contextLevel(): JsonField<String> = contextLevel

                /**
                 * Returns the raw JSON value of [model].
                 *
                 * Unlike [model], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

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
                 * Returns the raw JSON value of [userId].
                 *
                 * Unlike [userId], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("user_id") @ExcludeMissing fun _userId(): JsonField<String> = userId

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
                     * [OrganizationUsageWebSearchesResult].
                     *
                     * The following fields are required:
                     * ```java
                     * .numModelRequests()
                     * .numRequests()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [OrganizationUsageWebSearchesResult]. */
                class Builder internal constructor() {

                    private var numModelRequests: JsonField<Long>? = null
                    private var numRequests: JsonField<Long>? = null
                    private var object_: JsonValue =
                        JsonValue.from("organization.usage.web_searches.result")
                    private var apiKeyId: JsonField<String> = JsonMissing.of()
                    private var contextLevel: JsonField<String> = JsonMissing.of()
                    private var model: JsonField<String> = JsonMissing.of()
                    private var projectId: JsonField<String> = JsonMissing.of()
                    private var userId: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(
                        organizationUsageWebSearchesResult: OrganizationUsageWebSearchesResult
                    ) = apply {
                        numModelRequests = organizationUsageWebSearchesResult.numModelRequests
                        numRequests = organizationUsageWebSearchesResult.numRequests
                        object_ = organizationUsageWebSearchesResult.object_
                        apiKeyId = organizationUsageWebSearchesResult.apiKeyId
                        contextLevel = organizationUsageWebSearchesResult.contextLevel
                        model = organizationUsageWebSearchesResult.model
                        projectId = organizationUsageWebSearchesResult.projectId
                        userId = organizationUsageWebSearchesResult.userId
                        additionalProperties =
                            organizationUsageWebSearchesResult.additionalProperties.toMutableMap()
                    }

                    /** The count of model requests. */
                    fun numModelRequests(numModelRequests: Long) =
                        numModelRequests(JsonField.of(numModelRequests))

                    /**
                     * Sets [Builder.numModelRequests] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.numModelRequests] with a well-typed [Long]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun numModelRequests(numModelRequests: JsonField<Long>) = apply {
                        this.numModelRequests = numModelRequests
                    }

                    /** The count of web search calls. */
                    fun numRequests(numRequests: Long) = numRequests(JsonField.of(numRequests))

                    /**
                     * Sets [Builder.numRequests] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.numRequests] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun numRequests(numRequests: JsonField<Long>) = apply {
                        this.numRequests = numRequests
                    }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("organization.usage.web_searches.result")
                     * ```
                     *
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
                     */
                    fun object_(object_: JsonValue) = apply { this.object_ = object_ }

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
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun apiKeyId(apiKeyId: JsonField<String>) = apply { this.apiKeyId = apiKeyId }

                    /**
                     * When `group_by=context_level`, this field provides the search context size of
                     * the grouped usage result.
                     */
                    fun contextLevel(contextLevel: String?) =
                        contextLevel(JsonField.ofNullable(contextLevel))

                    /**
                     * Alias for calling [Builder.contextLevel] with `contextLevel.orElse(null)`.
                     */
                    fun contextLevel(contextLevel: Optional<String>) =
                        contextLevel(contextLevel.getOrNull())

                    /**
                     * Sets [Builder.contextLevel] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.contextLevel] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun contextLevel(contextLevel: JsonField<String>) = apply {
                        this.contextLevel = contextLevel
                    }

                    /**
                     * When `group_by=model`, this field provides the model name of the grouped
                     * usage result.
                     */
                    fun model(model: String?) = model(JsonField.ofNullable(model))

                    /** Alias for calling [Builder.model] with `model.orElse(null)`. */
                    fun model(model: Optional<String>) = model(model.getOrNull())

                    /**
                     * Sets [Builder.model] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.model] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun model(model: JsonField<String>) = apply { this.model = model }

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
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun projectId(projectId: JsonField<String>) = apply {
                        this.projectId = projectId
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
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
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
                     * Returns an immutable instance of [OrganizationUsageWebSearchesResult].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .numModelRequests()
                     * .numRequests()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): OrganizationUsageWebSearchesResult =
                        OrganizationUsageWebSearchesResult(
                            checkRequired("numModelRequests", numModelRequests),
                            checkRequired("numRequests", numRequests),
                            object_,
                            apiKeyId,
                            contextLevel,
                            model,
                            projectId,
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
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): OrganizationUsageWebSearchesResult = apply {
                    if (validated) {
                        return@apply
                    }

                    numModelRequests()
                    numRequests()
                    _object_().let {
                        if (it != JsonValue.from("organization.usage.web_searches.result")) {
                            throw OpenAIInvalidDataException("'object_' is invalid, received $it")
                        }
                    }
                    apiKeyId()
                    contextLevel()
                    model()
                    projectId()
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
                    (if (numModelRequests.asKnown().isPresent) 1 else 0) +
                        (if (numRequests.asKnown().isPresent) 1 else 0) +
                        object_.let {
                            if (it == JsonValue.from("organization.usage.web_searches.result")) 1
                            else 0
                        } +
                        (if (apiKeyId.asKnown().isPresent) 1 else 0) +
                        (if (contextLevel.asKnown().isPresent) 1 else 0) +
                        (if (model.asKnown().isPresent) 1 else 0) +
                        (if (projectId.asKnown().isPresent) 1 else 0) +
                        (if (userId.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is OrganizationUsageWebSearchesResult &&
                        numModelRequests == other.numModelRequests &&
                        numRequests == other.numRequests &&
                        object_ == other.object_ &&
                        apiKeyId == other.apiKeyId &&
                        contextLevel == other.contextLevel &&
                        model == other.model &&
                        projectId == other.projectId &&
                        userId == other.userId &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(
                        numModelRequests,
                        numRequests,
                        object_,
                        apiKeyId,
                        contextLevel,
                        model,
                        projectId,
                        userId,
                        additionalProperties,
                    )
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "OrganizationUsageWebSearchesResult{numModelRequests=$numModelRequests, numRequests=$numRequests, object_=$object_, apiKeyId=$apiKeyId, contextLevel=$contextLevel, model=$model, projectId=$projectId, userId=$userId, additionalProperties=$additionalProperties}"
            }

            /** The aggregated costs details of the specific time bucket. */
            class OrganizationCostsResult
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val object_: JsonValue,
                private val amount: JsonField<Amount>,
                private val apiKeyId: JsonField<String>,
                private val lineItem: JsonField<String>,
                private val projectId: JsonField<String>,
                private val quantity: JsonField<Double>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
                    @JsonProperty("amount")
                    @ExcludeMissing
                    amount: JsonField<Amount> = JsonMissing.of(),
                    @JsonProperty("api_key_id")
                    @ExcludeMissing
                    apiKeyId: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("line_item")
                    @ExcludeMissing
                    lineItem: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("project_id")
                    @ExcludeMissing
                    projectId: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("quantity")
                    @ExcludeMissing
                    quantity: JsonField<Double> = JsonMissing.of(),
                ) : this(object_, amount, apiKeyId, lineItem, projectId, quantity, mutableMapOf())

                /**
                 * Expected to always return the following:
                 * ```java
                 * JsonValue.from("organization.costs.result")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

                /**
                 * The monetary value in its associated currency.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun amount(): Optional<Amount> = amount.getOptional("amount")

                /**
                 * When `group_by=api_key_id`, this field provides the API Key ID of the grouped
                 * costs result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun apiKeyId(): Optional<String> = apiKeyId.getOptional("api_key_id")

                /**
                 * When `group_by=line_item`, this field provides the line item of the grouped costs
                 * result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun lineItem(): Optional<String> = lineItem.getOptional("line_item")

                /**
                 * When `group_by=project_id`, this field provides the project ID of the grouped
                 * costs result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun projectId(): Optional<String> = projectId.getOptional("project_id")

                /**
                 * When `group_by=line_item`, this field provides the quantity of the grouped costs
                 * result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun quantity(): Optional<Double> = quantity.getOptional("quantity")

                /**
                 * Returns the raw JSON value of [amount].
                 *
                 * Unlike [amount], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("amount") @ExcludeMissing fun _amount(): JsonField<Amount> = amount

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
                 * Returns the raw JSON value of [lineItem].
                 *
                 * Unlike [lineItem], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("line_item")
                @ExcludeMissing
                fun _lineItem(): JsonField<String> = lineItem

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
                 * Returns the raw JSON value of [quantity].
                 *
                 * Unlike [quantity], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("quantity")
                @ExcludeMissing
                fun _quantity(): JsonField<Double> = quantity

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
                     * [OrganizationCostsResult].
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [OrganizationCostsResult]. */
                class Builder internal constructor() {

                    private var object_: JsonValue = JsonValue.from("organization.costs.result")
                    private var amount: JsonField<Amount> = JsonMissing.of()
                    private var apiKeyId: JsonField<String> = JsonMissing.of()
                    private var lineItem: JsonField<String> = JsonMissing.of()
                    private var projectId: JsonField<String> = JsonMissing.of()
                    private var quantity: JsonField<Double> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(organizationCostsResult: OrganizationCostsResult) = apply {
                        object_ = organizationCostsResult.object_
                        amount = organizationCostsResult.amount
                        apiKeyId = organizationCostsResult.apiKeyId
                        lineItem = organizationCostsResult.lineItem
                        projectId = organizationCostsResult.projectId
                        quantity = organizationCostsResult.quantity
                        additionalProperties =
                            organizationCostsResult.additionalProperties.toMutableMap()
                    }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("organization.costs.result")
                     * ```
                     *
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
                     */
                    fun object_(object_: JsonValue) = apply { this.object_ = object_ }

                    /** The monetary value in its associated currency. */
                    fun amount(amount: Amount) = amount(JsonField.of(amount))

                    /**
                     * Sets [Builder.amount] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.amount] with a well-typed [Amount] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun amount(amount: JsonField<Amount>) = apply { this.amount = amount }

                    /**
                     * When `group_by=api_key_id`, this field provides the API Key ID of the grouped
                     * costs result.
                     */
                    fun apiKeyId(apiKeyId: String?) = apiKeyId(JsonField.ofNullable(apiKeyId))

                    /** Alias for calling [Builder.apiKeyId] with `apiKeyId.orElse(null)`. */
                    fun apiKeyId(apiKeyId: Optional<String>) = apiKeyId(apiKeyId.getOrNull())

                    /**
                     * Sets [Builder.apiKeyId] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.apiKeyId] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun apiKeyId(apiKeyId: JsonField<String>) = apply { this.apiKeyId = apiKeyId }

                    /**
                     * When `group_by=line_item`, this field provides the line item of the grouped
                     * costs result.
                     */
                    fun lineItem(lineItem: String?) = lineItem(JsonField.ofNullable(lineItem))

                    /** Alias for calling [Builder.lineItem] with `lineItem.orElse(null)`. */
                    fun lineItem(lineItem: Optional<String>) = lineItem(lineItem.getOrNull())

                    /**
                     * Sets [Builder.lineItem] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.lineItem] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun lineItem(lineItem: JsonField<String>) = apply { this.lineItem = lineItem }

                    /**
                     * When `group_by=project_id`, this field provides the project ID of the grouped
                     * costs result.
                     */
                    fun projectId(projectId: String?) = projectId(JsonField.ofNullable(projectId))

                    /** Alias for calling [Builder.projectId] with `projectId.orElse(null)`. */
                    fun projectId(projectId: Optional<String>) = projectId(projectId.getOrNull())

                    /**
                     * Sets [Builder.projectId] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.projectId] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun projectId(projectId: JsonField<String>) = apply {
                        this.projectId = projectId
                    }

                    /**
                     * When `group_by=line_item`, this field provides the quantity of the grouped
                     * costs result.
                     */
                    fun quantity(quantity: Double?) = quantity(JsonField.ofNullable(quantity))

                    /**
                     * Alias for [Builder.quantity].
                     *
                     * This unboxed primitive overload exists for backwards compatibility.
                     */
                    fun quantity(quantity: Double) = quantity(quantity as Double?)

                    /** Alias for calling [Builder.quantity] with `quantity.orElse(null)`. */
                    fun quantity(quantity: Optional<Double>) = quantity(quantity.getOrNull())

                    /**
                     * Sets [Builder.quantity] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.quantity] with a well-typed [Double] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun quantity(quantity: JsonField<Double>) = apply { this.quantity = quantity }

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
                     * Returns an immutable instance of [OrganizationCostsResult].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): OrganizationCostsResult =
                        OrganizationCostsResult(
                            object_,
                            amount,
                            apiKeyId,
                            lineItem,
                            projectId,
                            quantity,
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
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): OrganizationCostsResult = apply {
                    if (validated) {
                        return@apply
                    }

                    _object_().let {
                        if (it != JsonValue.from("organization.costs.result")) {
                            throw OpenAIInvalidDataException("'object_' is invalid, received $it")
                        }
                    }
                    amount().ifPresent { it.validate() }
                    apiKeyId()
                    lineItem()
                    projectId()
                    quantity()
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
                    object_.let {
                        if (it == JsonValue.from("organization.costs.result")) 1 else 0
                    } +
                        (amount.asKnown().getOrNull()?.validity() ?: 0) +
                        (if (apiKeyId.asKnown().isPresent) 1 else 0) +
                        (if (lineItem.asKnown().isPresent) 1 else 0) +
                        (if (projectId.asKnown().isPresent) 1 else 0) +
                        (if (quantity.asKnown().isPresent) 1 else 0)

                /** The monetary value in its associated currency. */
                class Amount
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val currency: JsonField<String>,
                    private val value: JsonField<Double>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("currency")
                        @ExcludeMissing
                        currency: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("value")
                        @ExcludeMissing
                        value: JsonField<Double> = JsonMissing.of(),
                    ) : this(currency, value, mutableMapOf())

                    /**
                     * Lowercase ISO-4217 currency e.g. "usd"
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun currency(): Optional<String> = currency.getOptional("currency")

                    /**
                     * The numeric value of the cost.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun value(): Optional<Double> = value.getOptional("value")

                    /**
                     * Returns the raw JSON value of [currency].
                     *
                     * Unlike [currency], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("currency")
                    @ExcludeMissing
                    fun _currency(): JsonField<String> = currency

                    /**
                     * Returns the raw JSON value of [value].
                     *
                     * Unlike [value], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("value") @ExcludeMissing fun _value(): JsonField<Double> = value

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

                        /** Returns a mutable builder for constructing an instance of [Amount]. */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Amount]. */
                    class Builder internal constructor() {

                        private var currency: JsonField<String> = JsonMissing.of()
                        private var value: JsonField<Double> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(amount: Amount) = apply {
                            currency = amount.currency
                            value = amount.value
                            additionalProperties = amount.additionalProperties.toMutableMap()
                        }

                        /** Lowercase ISO-4217 currency e.g. "usd" */
                        fun currency(currency: String) = currency(JsonField.of(currency))

                        /**
                         * Sets [Builder.currency] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.currency] with a well-typed [String]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun currency(currency: JsonField<String>) = apply {
                            this.currency = currency
                        }

                        /** The numeric value of the cost. */
                        fun value(value: Double) = value(JsonField.of(value))

                        /**
                         * Sets [Builder.value] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.value] with a well-typed [Double] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun value(value: JsonField<Double>) = apply { this.value = value }

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
                         * Returns an immutable instance of [Amount].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): Amount =
                            Amount(currency, value, additionalProperties.toMutableMap())
                    }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws OpenAIInvalidDataException if any value type in this object doesn't
                     *   match its expected type.
                     */
                    fun validate(): Amount = apply {
                        if (validated) {
                            return@apply
                        }

                        currency()
                        value()
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
                        (if (currency.asKnown().isPresent) 1 else 0) +
                            (if (value.asKnown().isPresent) 1 else 0)

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Amount &&
                            currency == other.currency &&
                            value == other.value &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(currency, value, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Amount{currency=$currency, value=$value, additionalProperties=$additionalProperties}"
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is OrganizationCostsResult &&
                        object_ == other.object_ &&
                        amount == other.amount &&
                        apiKeyId == other.apiKeyId &&
                        lineItem == other.lineItem &&
                        projectId == other.projectId &&
                        quantity == other.quantity &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(
                        object_,
                        amount,
                        apiKeyId,
                        lineItem,
                        projectId,
                        quantity,
                        additionalProperties,
                    )
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "OrganizationCostsResult{object_=$object_, amount=$amount, apiKeyId=$apiKeyId, lineItem=$lineItem, projectId=$projectId, quantity=$quantity, additionalProperties=$additionalProperties}"
            }
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

        return other is UsageEmbeddingsResponse &&
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
        "UsageEmbeddingsResponse{data=$data, hasMore=$hasMore, nextPage=$nextPage, object_=$object_, additionalProperties=$additionalProperties}"
}
