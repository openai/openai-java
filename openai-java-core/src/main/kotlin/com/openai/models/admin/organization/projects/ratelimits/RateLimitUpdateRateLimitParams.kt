// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.ratelimits

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.Params
import com.openai.core.checkRequired
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Updates a project rate limit. */
class RateLimitUpdateRateLimitParams
private constructor(
    private val projectId: String,
    private val rateLimitId: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun projectId(): String = projectId

    fun rateLimitId(): Optional<String> = Optional.ofNullable(rateLimitId)

    /**
     * The maximum batch input tokens per day. Only relevant for certain models.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun batch1DayMaxInputTokens(): Optional<Long> = body.batch1DayMaxInputTokens()

    /**
     * The maximum audio megabytes per minute. Only relevant for certain models.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun maxAudioMegabytesPer1Minute(): Optional<Long> = body.maxAudioMegabytesPer1Minute()

    /**
     * The maximum images per minute. Only relevant for certain models.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun maxImagesPer1Minute(): Optional<Long> = body.maxImagesPer1Minute()

    /**
     * The maximum requests per day. Only relevant for certain models.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun maxRequestsPer1Day(): Optional<Long> = body.maxRequestsPer1Day()

    /**
     * The maximum requests per minute.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun maxRequestsPer1Minute(): Optional<Long> = body.maxRequestsPer1Minute()

    /**
     * The maximum tokens per minute.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun maxTokensPer1Minute(): Optional<Long> = body.maxTokensPer1Minute()

    /**
     * Returns the raw JSON value of [batch1DayMaxInputTokens].
     *
     * Unlike [batch1DayMaxInputTokens], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    fun _batch1DayMaxInputTokens(): JsonField<Long> = body._batch1DayMaxInputTokens()

    /**
     * Returns the raw JSON value of [maxAudioMegabytesPer1Minute].
     *
     * Unlike [maxAudioMegabytesPer1Minute], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    fun _maxAudioMegabytesPer1Minute(): JsonField<Long> = body._maxAudioMegabytesPer1Minute()

    /**
     * Returns the raw JSON value of [maxImagesPer1Minute].
     *
     * Unlike [maxImagesPer1Minute], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _maxImagesPer1Minute(): JsonField<Long> = body._maxImagesPer1Minute()

    /**
     * Returns the raw JSON value of [maxRequestsPer1Day].
     *
     * Unlike [maxRequestsPer1Day], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _maxRequestsPer1Day(): JsonField<Long> = body._maxRequestsPer1Day()

    /**
     * Returns the raw JSON value of [maxRequestsPer1Minute].
     *
     * Unlike [maxRequestsPer1Minute], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _maxRequestsPer1Minute(): JsonField<Long> = body._maxRequestsPer1Minute()

    /**
     * Returns the raw JSON value of [maxTokensPer1Minute].
     *
     * Unlike [maxTokensPer1Minute], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _maxTokensPer1Minute(): JsonField<Long> = body._maxTokensPer1Minute()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [RateLimitUpdateRateLimitParams].
         *
         * The following fields are required:
         * ```java
         * .projectId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RateLimitUpdateRateLimitParams]. */
    class Builder internal constructor() {

        private var projectId: String? = null
        private var rateLimitId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(rateLimitUpdateRateLimitParams: RateLimitUpdateRateLimitParams) = apply {
            projectId = rateLimitUpdateRateLimitParams.projectId
            rateLimitId = rateLimitUpdateRateLimitParams.rateLimitId
            body = rateLimitUpdateRateLimitParams.body.toBuilder()
            additionalHeaders = rateLimitUpdateRateLimitParams.additionalHeaders.toBuilder()
            additionalQueryParams = rateLimitUpdateRateLimitParams.additionalQueryParams.toBuilder()
        }

        fun projectId(projectId: String) = apply { this.projectId = projectId }

        fun rateLimitId(rateLimitId: String?) = apply { this.rateLimitId = rateLimitId }

        /** Alias for calling [Builder.rateLimitId] with `rateLimitId.orElse(null)`. */
        fun rateLimitId(rateLimitId: Optional<String>) = rateLimitId(rateLimitId.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [batch1DayMaxInputTokens]
         * - [maxAudioMegabytesPer1Minute]
         * - [maxImagesPer1Minute]
         * - [maxRequestsPer1Day]
         * - [maxRequestsPer1Minute]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** The maximum batch input tokens per day. Only relevant for certain models. */
        fun batch1DayMaxInputTokens(batch1DayMaxInputTokens: Long) = apply {
            body.batch1DayMaxInputTokens(batch1DayMaxInputTokens)
        }

        /**
         * Sets [Builder.batch1DayMaxInputTokens] to an arbitrary JSON value.
         *
         * You should usually call [Builder.batch1DayMaxInputTokens] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun batch1DayMaxInputTokens(batch1DayMaxInputTokens: JsonField<Long>) = apply {
            body.batch1DayMaxInputTokens(batch1DayMaxInputTokens)
        }

        /** The maximum audio megabytes per minute. Only relevant for certain models. */
        fun maxAudioMegabytesPer1Minute(maxAudioMegabytesPer1Minute: Long) = apply {
            body.maxAudioMegabytesPer1Minute(maxAudioMegabytesPer1Minute)
        }

        /**
         * Sets [Builder.maxAudioMegabytesPer1Minute] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxAudioMegabytesPer1Minute] with a well-typed [Long]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun maxAudioMegabytesPer1Minute(maxAudioMegabytesPer1Minute: JsonField<Long>) = apply {
            body.maxAudioMegabytesPer1Minute(maxAudioMegabytesPer1Minute)
        }

        /** The maximum images per minute. Only relevant for certain models. */
        fun maxImagesPer1Minute(maxImagesPer1Minute: Long) = apply {
            body.maxImagesPer1Minute(maxImagesPer1Minute)
        }

        /**
         * Sets [Builder.maxImagesPer1Minute] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxImagesPer1Minute] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun maxImagesPer1Minute(maxImagesPer1Minute: JsonField<Long>) = apply {
            body.maxImagesPer1Minute(maxImagesPer1Minute)
        }

        /** The maximum requests per day. Only relevant for certain models. */
        fun maxRequestsPer1Day(maxRequestsPer1Day: Long) = apply {
            body.maxRequestsPer1Day(maxRequestsPer1Day)
        }

        /**
         * Sets [Builder.maxRequestsPer1Day] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxRequestsPer1Day] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun maxRequestsPer1Day(maxRequestsPer1Day: JsonField<Long>) = apply {
            body.maxRequestsPer1Day(maxRequestsPer1Day)
        }

        /** The maximum requests per minute. */
        fun maxRequestsPer1Minute(maxRequestsPer1Minute: Long) = apply {
            body.maxRequestsPer1Minute(maxRequestsPer1Minute)
        }

        /**
         * Sets [Builder.maxRequestsPer1Minute] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxRequestsPer1Minute] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun maxRequestsPer1Minute(maxRequestsPer1Minute: JsonField<Long>) = apply {
            body.maxRequestsPer1Minute(maxRequestsPer1Minute)
        }

        /** The maximum tokens per minute. */
        fun maxTokensPer1Minute(maxTokensPer1Minute: Long) = apply {
            body.maxTokensPer1Minute(maxTokensPer1Minute)
        }

        /**
         * Sets [Builder.maxTokensPer1Minute] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxTokensPer1Minute] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun maxTokensPer1Minute(maxTokensPer1Minute: JsonField<Long>) = apply {
            body.maxTokensPer1Minute(maxTokensPer1Minute)
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
         * Returns an immutable instance of [RateLimitUpdateRateLimitParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .projectId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): RateLimitUpdateRateLimitParams =
            RateLimitUpdateRateLimitParams(
                checkRequired("projectId", projectId),
                rateLimitId,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> projectId
            1 -> rateLimitId ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val batch1DayMaxInputTokens: JsonField<Long>,
        private val maxAudioMegabytesPer1Minute: JsonField<Long>,
        private val maxImagesPer1Minute: JsonField<Long>,
        private val maxRequestsPer1Day: JsonField<Long>,
        private val maxRequestsPer1Minute: JsonField<Long>,
        private val maxTokensPer1Minute: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("batch_1_day_max_input_tokens")
            @ExcludeMissing
            batch1DayMaxInputTokens: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("max_audio_megabytes_per_1_minute")
            @ExcludeMissing
            maxAudioMegabytesPer1Minute: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("max_images_per_1_minute")
            @ExcludeMissing
            maxImagesPer1Minute: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("max_requests_per_1_day")
            @ExcludeMissing
            maxRequestsPer1Day: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("max_requests_per_1_minute")
            @ExcludeMissing
            maxRequestsPer1Minute: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("max_tokens_per_1_minute")
            @ExcludeMissing
            maxTokensPer1Minute: JsonField<Long> = JsonMissing.of(),
        ) : this(
            batch1DayMaxInputTokens,
            maxAudioMegabytesPer1Minute,
            maxImagesPer1Minute,
            maxRequestsPer1Day,
            maxRequestsPer1Minute,
            maxTokensPer1Minute,
            mutableMapOf(),
        )

        /**
         * The maximum batch input tokens per day. Only relevant for certain models.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun batch1DayMaxInputTokens(): Optional<Long> =
            batch1DayMaxInputTokens.getOptional("batch_1_day_max_input_tokens")

        /**
         * The maximum audio megabytes per minute. Only relevant for certain models.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun maxAudioMegabytesPer1Minute(): Optional<Long> =
            maxAudioMegabytesPer1Minute.getOptional("max_audio_megabytes_per_1_minute")

        /**
         * The maximum images per minute. Only relevant for certain models.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun maxImagesPer1Minute(): Optional<Long> =
            maxImagesPer1Minute.getOptional("max_images_per_1_minute")

        /**
         * The maximum requests per day. Only relevant for certain models.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun maxRequestsPer1Day(): Optional<Long> =
            maxRequestsPer1Day.getOptional("max_requests_per_1_day")

        /**
         * The maximum requests per minute.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun maxRequestsPer1Minute(): Optional<Long> =
            maxRequestsPer1Minute.getOptional("max_requests_per_1_minute")

        /**
         * The maximum tokens per minute.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun maxTokensPer1Minute(): Optional<Long> =
            maxTokensPer1Minute.getOptional("max_tokens_per_1_minute")

        /**
         * Returns the raw JSON value of [batch1DayMaxInputTokens].
         *
         * Unlike [batch1DayMaxInputTokens], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("batch_1_day_max_input_tokens")
        @ExcludeMissing
        fun _batch1DayMaxInputTokens(): JsonField<Long> = batch1DayMaxInputTokens

        /**
         * Returns the raw JSON value of [maxAudioMegabytesPer1Minute].
         *
         * Unlike [maxAudioMegabytesPer1Minute], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("max_audio_megabytes_per_1_minute")
        @ExcludeMissing
        fun _maxAudioMegabytesPer1Minute(): JsonField<Long> = maxAudioMegabytesPer1Minute

        /**
         * Returns the raw JSON value of [maxImagesPer1Minute].
         *
         * Unlike [maxImagesPer1Minute], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("max_images_per_1_minute")
        @ExcludeMissing
        fun _maxImagesPer1Minute(): JsonField<Long> = maxImagesPer1Minute

        /**
         * Returns the raw JSON value of [maxRequestsPer1Day].
         *
         * Unlike [maxRequestsPer1Day], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("max_requests_per_1_day")
        @ExcludeMissing
        fun _maxRequestsPer1Day(): JsonField<Long> = maxRequestsPer1Day

        /**
         * Returns the raw JSON value of [maxRequestsPer1Minute].
         *
         * Unlike [maxRequestsPer1Minute], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("max_requests_per_1_minute")
        @ExcludeMissing
        fun _maxRequestsPer1Minute(): JsonField<Long> = maxRequestsPer1Minute

        /**
         * Returns the raw JSON value of [maxTokensPer1Minute].
         *
         * Unlike [maxTokensPer1Minute], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("max_tokens_per_1_minute")
        @ExcludeMissing
        fun _maxTokensPer1Minute(): JsonField<Long> = maxTokensPer1Minute

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

            /** Returns a mutable builder for constructing an instance of [Body]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var batch1DayMaxInputTokens: JsonField<Long> = JsonMissing.of()
            private var maxAudioMegabytesPer1Minute: JsonField<Long> = JsonMissing.of()
            private var maxImagesPer1Minute: JsonField<Long> = JsonMissing.of()
            private var maxRequestsPer1Day: JsonField<Long> = JsonMissing.of()
            private var maxRequestsPer1Minute: JsonField<Long> = JsonMissing.of()
            private var maxTokensPer1Minute: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                batch1DayMaxInputTokens = body.batch1DayMaxInputTokens
                maxAudioMegabytesPer1Minute = body.maxAudioMegabytesPer1Minute
                maxImagesPer1Minute = body.maxImagesPer1Minute
                maxRequestsPer1Day = body.maxRequestsPer1Day
                maxRequestsPer1Minute = body.maxRequestsPer1Minute
                maxTokensPer1Minute = body.maxTokensPer1Minute
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** The maximum batch input tokens per day. Only relevant for certain models. */
            fun batch1DayMaxInputTokens(batch1DayMaxInputTokens: Long) =
                batch1DayMaxInputTokens(JsonField.of(batch1DayMaxInputTokens))

            /**
             * Sets [Builder.batch1DayMaxInputTokens] to an arbitrary JSON value.
             *
             * You should usually call [Builder.batch1DayMaxInputTokens] with a well-typed [Long]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun batch1DayMaxInputTokens(batch1DayMaxInputTokens: JsonField<Long>) = apply {
                this.batch1DayMaxInputTokens = batch1DayMaxInputTokens
            }

            /** The maximum audio megabytes per minute. Only relevant for certain models. */
            fun maxAudioMegabytesPer1Minute(maxAudioMegabytesPer1Minute: Long) =
                maxAudioMegabytesPer1Minute(JsonField.of(maxAudioMegabytesPer1Minute))

            /**
             * Sets [Builder.maxAudioMegabytesPer1Minute] to an arbitrary JSON value.
             *
             * You should usually call [Builder.maxAudioMegabytesPer1Minute] with a well-typed
             * [Long] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun maxAudioMegabytesPer1Minute(maxAudioMegabytesPer1Minute: JsonField<Long>) = apply {
                this.maxAudioMegabytesPer1Minute = maxAudioMegabytesPer1Minute
            }

            /** The maximum images per minute. Only relevant for certain models. */
            fun maxImagesPer1Minute(maxImagesPer1Minute: Long) =
                maxImagesPer1Minute(JsonField.of(maxImagesPer1Minute))

            /**
             * Sets [Builder.maxImagesPer1Minute] to an arbitrary JSON value.
             *
             * You should usually call [Builder.maxImagesPer1Minute] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun maxImagesPer1Minute(maxImagesPer1Minute: JsonField<Long>) = apply {
                this.maxImagesPer1Minute = maxImagesPer1Minute
            }

            /** The maximum requests per day. Only relevant for certain models. */
            fun maxRequestsPer1Day(maxRequestsPer1Day: Long) =
                maxRequestsPer1Day(JsonField.of(maxRequestsPer1Day))

            /**
             * Sets [Builder.maxRequestsPer1Day] to an arbitrary JSON value.
             *
             * You should usually call [Builder.maxRequestsPer1Day] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun maxRequestsPer1Day(maxRequestsPer1Day: JsonField<Long>) = apply {
                this.maxRequestsPer1Day = maxRequestsPer1Day
            }

            /** The maximum requests per minute. */
            fun maxRequestsPer1Minute(maxRequestsPer1Minute: Long) =
                maxRequestsPer1Minute(JsonField.of(maxRequestsPer1Minute))

            /**
             * Sets [Builder.maxRequestsPer1Minute] to an arbitrary JSON value.
             *
             * You should usually call [Builder.maxRequestsPer1Minute] with a well-typed [Long]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun maxRequestsPer1Minute(maxRequestsPer1Minute: JsonField<Long>) = apply {
                this.maxRequestsPer1Minute = maxRequestsPer1Minute
            }

            /** The maximum tokens per minute. */
            fun maxTokensPer1Minute(maxTokensPer1Minute: Long) =
                maxTokensPer1Minute(JsonField.of(maxTokensPer1Minute))

            /**
             * Sets [Builder.maxTokensPer1Minute] to an arbitrary JSON value.
             *
             * You should usually call [Builder.maxTokensPer1Minute] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun maxTokensPer1Minute(maxTokensPer1Minute: JsonField<Long>) = apply {
                this.maxTokensPer1Minute = maxTokensPer1Minute
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
             */
            fun build(): Body =
                Body(
                    batch1DayMaxInputTokens,
                    maxAudioMegabytesPer1Minute,
                    maxImagesPer1Minute,
                    maxRequestsPer1Day,
                    maxRequestsPer1Minute,
                    maxTokensPer1Minute,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            batch1DayMaxInputTokens()
            maxAudioMegabytesPer1Minute()
            maxImagesPer1Minute()
            maxRequestsPer1Day()
            maxRequestsPer1Minute()
            maxTokensPer1Minute()
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
            (if (batch1DayMaxInputTokens.asKnown().isPresent) 1 else 0) +
                (if (maxAudioMegabytesPer1Minute.asKnown().isPresent) 1 else 0) +
                (if (maxImagesPer1Minute.asKnown().isPresent) 1 else 0) +
                (if (maxRequestsPer1Day.asKnown().isPresent) 1 else 0) +
                (if (maxRequestsPer1Minute.asKnown().isPresent) 1 else 0) +
                (if (maxTokensPer1Minute.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                batch1DayMaxInputTokens == other.batch1DayMaxInputTokens &&
                maxAudioMegabytesPer1Minute == other.maxAudioMegabytesPer1Minute &&
                maxImagesPer1Minute == other.maxImagesPer1Minute &&
                maxRequestsPer1Day == other.maxRequestsPer1Day &&
                maxRequestsPer1Minute == other.maxRequestsPer1Minute &&
                maxTokensPer1Minute == other.maxTokensPer1Minute &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                batch1DayMaxInputTokens,
                maxAudioMegabytesPer1Minute,
                maxImagesPer1Minute,
                maxRequestsPer1Day,
                maxRequestsPer1Minute,
                maxTokensPer1Minute,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{batch1DayMaxInputTokens=$batch1DayMaxInputTokens, maxAudioMegabytesPer1Minute=$maxAudioMegabytesPer1Minute, maxImagesPer1Minute=$maxImagesPer1Minute, maxRequestsPer1Day=$maxRequestsPer1Day, maxRequestsPer1Minute=$maxRequestsPer1Minute, maxTokensPer1Minute=$maxTokensPer1Minute, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RateLimitUpdateRateLimitParams &&
            projectId == other.projectId &&
            rateLimitId == other.rateLimitId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(projectId, rateLimitId, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "RateLimitUpdateRateLimitParams{projectId=$projectId, rateLimitId=$rateLimitId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
