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
import com.openai.core.checkRequired
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional

/** Represents a project rate limit config. */
class ProjectRateLimit
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val maxRequestsPer1Minute: JsonField<Long>,
    private val maxTokensPer1Minute: JsonField<Long>,
    private val model: JsonField<String>,
    private val object_: JsonValue,
    private val batch1DayMaxInputTokens: JsonField<Long>,
    private val maxAudioMegabytesPer1Minute: JsonField<Long>,
    private val maxImagesPer1Minute: JsonField<Long>,
    private val maxRequestsPer1Day: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("max_requests_per_1_minute")
        @ExcludeMissing
        maxRequestsPer1Minute: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("max_tokens_per_1_minute")
        @ExcludeMissing
        maxTokensPer1Minute: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("model") @ExcludeMissing model: JsonField<String> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
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
    ) : this(
        id,
        maxRequestsPer1Minute,
        maxTokensPer1Minute,
        model,
        object_,
        batch1DayMaxInputTokens,
        maxAudioMegabytesPer1Minute,
        maxImagesPer1Minute,
        maxRequestsPer1Day,
        mutableMapOf(),
    )

    /**
     * The identifier, which can be referenced in API endpoints.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The maximum requests per minute.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun maxRequestsPer1Minute(): Long =
        maxRequestsPer1Minute.getRequired("max_requests_per_1_minute")

    /**
     * The maximum tokens per minute.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun maxTokensPer1Minute(): Long = maxTokensPer1Minute.getRequired("max_tokens_per_1_minute")

    /**
     * The model this rate limit applies to.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun model(): String = model.getRequired("model")

    /**
     * The object type, which is always `project.rate_limit`
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("project.rate_limit")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * The maximum batch input tokens per day. Only present for relevant models.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun batch1DayMaxInputTokens(): Optional<Long> =
        batch1DayMaxInputTokens.getOptional("batch_1_day_max_input_tokens")

    /**
     * The maximum audio megabytes per minute. Only present for relevant models.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun maxAudioMegabytesPer1Minute(): Optional<Long> =
        maxAudioMegabytesPer1Minute.getOptional("max_audio_megabytes_per_1_minute")

    /**
     * The maximum images per minute. Only present for relevant models.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun maxImagesPer1Minute(): Optional<Long> =
        maxImagesPer1Minute.getOptional("max_images_per_1_minute")

    /**
     * The maximum requests per day. Only present for relevant models.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun maxRequestsPer1Day(): Optional<Long> =
        maxRequestsPer1Day.getOptional("max_requests_per_1_day")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [maxRequestsPer1Minute].
     *
     * Unlike [maxRequestsPer1Minute], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("max_requests_per_1_minute")
    @ExcludeMissing
    fun _maxRequestsPer1Minute(): JsonField<Long> = maxRequestsPer1Minute

    /**
     * Returns the raw JSON value of [maxTokensPer1Minute].
     *
     * Unlike [maxTokensPer1Minute], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("max_tokens_per_1_minute")
    @ExcludeMissing
    fun _maxTokensPer1Minute(): JsonField<Long> = maxTokensPer1Minute

    /**
     * Returns the raw JSON value of [model].
     *
     * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

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
     * Unlike [maxImagesPer1Minute], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("max_images_per_1_minute")
    @ExcludeMissing
    fun _maxImagesPer1Minute(): JsonField<Long> = maxImagesPer1Minute

    /**
     * Returns the raw JSON value of [maxRequestsPer1Day].
     *
     * Unlike [maxRequestsPer1Day], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("max_requests_per_1_day")
    @ExcludeMissing
    fun _maxRequestsPer1Day(): JsonField<Long> = maxRequestsPer1Day

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
         * Returns a mutable builder for constructing an instance of [ProjectRateLimit].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .maxRequestsPer1Minute()
         * .maxTokensPer1Minute()
         * .model()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ProjectRateLimit]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var maxRequestsPer1Minute: JsonField<Long>? = null
        private var maxTokensPer1Minute: JsonField<Long>? = null
        private var model: JsonField<String>? = null
        private var object_: JsonValue = JsonValue.from("project.rate_limit")
        private var batch1DayMaxInputTokens: JsonField<Long> = JsonMissing.of()
        private var maxAudioMegabytesPer1Minute: JsonField<Long> = JsonMissing.of()
        private var maxImagesPer1Minute: JsonField<Long> = JsonMissing.of()
        private var maxRequestsPer1Day: JsonField<Long> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(projectRateLimit: ProjectRateLimit) = apply {
            id = projectRateLimit.id
            maxRequestsPer1Minute = projectRateLimit.maxRequestsPer1Minute
            maxTokensPer1Minute = projectRateLimit.maxTokensPer1Minute
            model = projectRateLimit.model
            object_ = projectRateLimit.object_
            batch1DayMaxInputTokens = projectRateLimit.batch1DayMaxInputTokens
            maxAudioMegabytesPer1Minute = projectRateLimit.maxAudioMegabytesPer1Minute
            maxImagesPer1Minute = projectRateLimit.maxImagesPer1Minute
            maxRequestsPer1Day = projectRateLimit.maxRequestsPer1Day
            additionalProperties = projectRateLimit.additionalProperties.toMutableMap()
        }

        /** The identifier, which can be referenced in API endpoints. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The maximum requests per minute. */
        fun maxRequestsPer1Minute(maxRequestsPer1Minute: Long) =
            maxRequestsPer1Minute(JsonField.of(maxRequestsPer1Minute))

        /**
         * Sets [Builder.maxRequestsPer1Minute] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxRequestsPer1Minute] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
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

        /** The model this rate limit applies to. */
        fun model(model: String) = model(JsonField.of(model))

        /**
         * Sets [Builder.model] to an arbitrary JSON value.
         *
         * You should usually call [Builder.model] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(model: JsonField<String>) = apply { this.model = model }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("project.rate_limit")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /** The maximum batch input tokens per day. Only present for relevant models. */
        fun batch1DayMaxInputTokens(batch1DayMaxInputTokens: Long) =
            batch1DayMaxInputTokens(JsonField.of(batch1DayMaxInputTokens))

        /**
         * Sets [Builder.batch1DayMaxInputTokens] to an arbitrary JSON value.
         *
         * You should usually call [Builder.batch1DayMaxInputTokens] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun batch1DayMaxInputTokens(batch1DayMaxInputTokens: JsonField<Long>) = apply {
            this.batch1DayMaxInputTokens = batch1DayMaxInputTokens
        }

        /** The maximum audio megabytes per minute. Only present for relevant models. */
        fun maxAudioMegabytesPer1Minute(maxAudioMegabytesPer1Minute: Long) =
            maxAudioMegabytesPer1Minute(JsonField.of(maxAudioMegabytesPer1Minute))

        /**
         * Sets [Builder.maxAudioMegabytesPer1Minute] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxAudioMegabytesPer1Minute] with a well-typed [Long]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun maxAudioMegabytesPer1Minute(maxAudioMegabytesPer1Minute: JsonField<Long>) = apply {
            this.maxAudioMegabytesPer1Minute = maxAudioMegabytesPer1Minute
        }

        /** The maximum images per minute. Only present for relevant models. */
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

        /** The maximum requests per day. Only present for relevant models. */
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
         * Returns an immutable instance of [ProjectRateLimit].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .maxRequestsPer1Minute()
         * .maxTokensPer1Minute()
         * .model()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ProjectRateLimit =
            ProjectRateLimit(
                checkRequired("id", id),
                checkRequired("maxRequestsPer1Minute", maxRequestsPer1Minute),
                checkRequired("maxTokensPer1Minute", maxTokensPer1Minute),
                checkRequired("model", model),
                object_,
                batch1DayMaxInputTokens,
                maxAudioMegabytesPer1Minute,
                maxImagesPer1Minute,
                maxRequestsPer1Day,
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
    fun validate(): ProjectRateLimit = apply {
        if (validated) {
            return@apply
        }

        id()
        maxRequestsPer1Minute()
        maxTokensPer1Minute()
        model()
        _object_().let {
            if (it != JsonValue.from("project.rate_limit")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        batch1DayMaxInputTokens()
        maxAudioMegabytesPer1Minute()
        maxImagesPer1Minute()
        maxRequestsPer1Day()
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
            (if (maxRequestsPer1Minute.asKnown().isPresent) 1 else 0) +
            (if (maxTokensPer1Minute.asKnown().isPresent) 1 else 0) +
            (if (model.asKnown().isPresent) 1 else 0) +
            object_.let { if (it == JsonValue.from("project.rate_limit")) 1 else 0 } +
            (if (batch1DayMaxInputTokens.asKnown().isPresent) 1 else 0) +
            (if (maxAudioMegabytesPer1Minute.asKnown().isPresent) 1 else 0) +
            (if (maxImagesPer1Minute.asKnown().isPresent) 1 else 0) +
            (if (maxRequestsPer1Day.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ProjectRateLimit &&
            id == other.id &&
            maxRequestsPer1Minute == other.maxRequestsPer1Minute &&
            maxTokensPer1Minute == other.maxTokensPer1Minute &&
            model == other.model &&
            object_ == other.object_ &&
            batch1DayMaxInputTokens == other.batch1DayMaxInputTokens &&
            maxAudioMegabytesPer1Minute == other.maxAudioMegabytesPer1Minute &&
            maxImagesPer1Minute == other.maxImagesPer1Minute &&
            maxRequestsPer1Day == other.maxRequestsPer1Day &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            maxRequestsPer1Minute,
            maxTokensPer1Minute,
            model,
            object_,
            batch1DayMaxInputTokens,
            maxAudioMegabytesPer1Minute,
            maxImagesPer1Minute,
            maxRequestsPer1Day,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ProjectRateLimit{id=$id, maxRequestsPer1Minute=$maxRequestsPer1Minute, maxTokensPer1Minute=$maxTokensPer1Minute, model=$model, object_=$object_, batch1DayMaxInputTokens=$batch1DayMaxInputTokens, maxAudioMegabytesPer1Minute=$maxAudioMegabytesPer1Minute, maxImagesPer1Minute=$maxImagesPer1Minute, maxRequestsPer1Day=$maxRequestsPer1Day, additionalProperties=$additionalProperties}"
}
