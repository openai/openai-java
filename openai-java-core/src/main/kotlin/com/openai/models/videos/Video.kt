// File generated from our OpenAPI spec by Stainless.

package com.openai.models.videos

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Structured information describing a generated video job. */
class Video
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val completedAt: JsonField<Long>,
    private val createdAt: JsonField<Long>,
    private val error: JsonField<VideoCreateError>,
    private val expiresAt: JsonField<Long>,
    private val model: JsonField<VideoModel>,
    private val object_: JsonValue,
    private val progress: JsonField<Long>,
    private val prompt: JsonField<String>,
    private val remixedFromVideoId: JsonField<String>,
    private val seconds: JsonField<VideoSeconds>,
    private val size: JsonField<VideoSize>,
    private val status: JsonField<Status>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("completed_at")
        @ExcludeMissing
        completedAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("created_at") @ExcludeMissing createdAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("error")
        @ExcludeMissing
        error: JsonField<VideoCreateError> = JsonMissing.of(),
        @JsonProperty("expires_at") @ExcludeMissing expiresAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("model") @ExcludeMissing model: JsonField<VideoModel> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("progress") @ExcludeMissing progress: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("prompt") @ExcludeMissing prompt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("remixed_from_video_id")
        @ExcludeMissing
        remixedFromVideoId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("seconds")
        @ExcludeMissing
        seconds: JsonField<VideoSeconds> = JsonMissing.of(),
        @JsonProperty("size") @ExcludeMissing size: JsonField<VideoSize> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
    ) : this(
        id,
        completedAt,
        createdAt,
        error,
        expiresAt,
        model,
        object_,
        progress,
        prompt,
        remixedFromVideoId,
        seconds,
        size,
        status,
        mutableMapOf(),
    )

    /**
     * Unique identifier for the video job.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * Unix timestamp (seconds) for when the job completed, if finished.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun completedAt(): Optional<Long> = completedAt.getOptional("completed_at")

    /**
     * Unix timestamp (seconds) for when the job was created.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /**
     * Error payload that explains why generation failed, if applicable.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun error(): Optional<VideoCreateError> = error.getOptional("error")

    /**
     * Unix timestamp (seconds) for when the downloadable assets expire, if set.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun expiresAt(): Optional<Long> = expiresAt.getOptional("expires_at")

    /**
     * The video generation model that produced the job.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun model(): VideoModel = model.getRequired("model")

    /**
     * The object type, which is always `video`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("video")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * Approximate completion percentage for the generation task.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun progress(): Long = progress.getRequired("progress")

    /**
     * The prompt that was used to generate the video.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun prompt(): Optional<String> = prompt.getOptional("prompt")

    /**
     * Identifier of the source video if this video is a remix.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun remixedFromVideoId(): Optional<String> =
        remixedFromVideoId.getOptional("remixed_from_video_id")

    /**
     * Duration of the generated clip in seconds.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun seconds(): VideoSeconds = seconds.getRequired("seconds")

    /**
     * The resolution of the generated video.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun size(): VideoSize = size.getRequired("size")

    /**
     * Current lifecycle status of the video job.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): Status = status.getRequired("status")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [completedAt].
     *
     * Unlike [completedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("completed_at") @ExcludeMissing fun _completedAt(): JsonField<Long> = completedAt

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt(): JsonField<Long> = createdAt

    /**
     * Returns the raw JSON value of [error].
     *
     * Unlike [error], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<VideoCreateError> = error

    /**
     * Returns the raw JSON value of [expiresAt].
     *
     * Unlike [expiresAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("expires_at") @ExcludeMissing fun _expiresAt(): JsonField<Long> = expiresAt

    /**
     * Returns the raw JSON value of [model].
     *
     * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<VideoModel> = model

    /**
     * Returns the raw JSON value of [progress].
     *
     * Unlike [progress], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("progress") @ExcludeMissing fun _progress(): JsonField<Long> = progress

    /**
     * Returns the raw JSON value of [prompt].
     *
     * Unlike [prompt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("prompt") @ExcludeMissing fun _prompt(): JsonField<String> = prompt

    /**
     * Returns the raw JSON value of [remixedFromVideoId].
     *
     * Unlike [remixedFromVideoId], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("remixed_from_video_id")
    @ExcludeMissing
    fun _remixedFromVideoId(): JsonField<String> = remixedFromVideoId

    /**
     * Returns the raw JSON value of [seconds].
     *
     * Unlike [seconds], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("seconds") @ExcludeMissing fun _seconds(): JsonField<VideoSeconds> = seconds

    /**
     * Returns the raw JSON value of [size].
     *
     * Unlike [size], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("size") @ExcludeMissing fun _size(): JsonField<VideoSize> = size

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

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
         * Returns a mutable builder for constructing an instance of [Video].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .completedAt()
         * .createdAt()
         * .error()
         * .expiresAt()
         * .model()
         * .progress()
         * .prompt()
         * .remixedFromVideoId()
         * .seconds()
         * .size()
         * .status()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Video]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var completedAt: JsonField<Long>? = null
        private var createdAt: JsonField<Long>? = null
        private var error: JsonField<VideoCreateError>? = null
        private var expiresAt: JsonField<Long>? = null
        private var model: JsonField<VideoModel>? = null
        private var object_: JsonValue = JsonValue.from("video")
        private var progress: JsonField<Long>? = null
        private var prompt: JsonField<String>? = null
        private var remixedFromVideoId: JsonField<String>? = null
        private var seconds: JsonField<VideoSeconds>? = null
        private var size: JsonField<VideoSize>? = null
        private var status: JsonField<Status>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(video: Video) = apply {
            id = video.id
            completedAt = video.completedAt
            createdAt = video.createdAt
            error = video.error
            expiresAt = video.expiresAt
            model = video.model
            object_ = video.object_
            progress = video.progress
            prompt = video.prompt
            remixedFromVideoId = video.remixedFromVideoId
            seconds = video.seconds
            size = video.size
            status = video.status
            additionalProperties = video.additionalProperties.toMutableMap()
        }

        /** Unique identifier for the video job. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Unix timestamp (seconds) for when the job completed, if finished. */
        fun completedAt(completedAt: Long?) = completedAt(JsonField.ofNullable(completedAt))

        /**
         * Alias for [Builder.completedAt].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun completedAt(completedAt: Long) = completedAt(completedAt as Long?)

        /** Alias for calling [Builder.completedAt] with `completedAt.orElse(null)`. */
        fun completedAt(completedAt: Optional<Long>) = completedAt(completedAt.getOrNull())

        /**
         * Sets [Builder.completedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.completedAt] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun completedAt(completedAt: JsonField<Long>) = apply { this.completedAt = completedAt }

        /** Unix timestamp (seconds) for when the job was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /** Error payload that explains why generation failed, if applicable. */
        fun error(error: VideoCreateError?) = error(JsonField.ofNullable(error))

        /** Alias for calling [Builder.error] with `error.orElse(null)`. */
        fun error(error: Optional<VideoCreateError>) = error(error.getOrNull())

        /**
         * Sets [Builder.error] to an arbitrary JSON value.
         *
         * You should usually call [Builder.error] with a well-typed [VideoCreateError] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun error(error: JsonField<VideoCreateError>) = apply { this.error = error }

        /** Unix timestamp (seconds) for when the downloadable assets expire, if set. */
        fun expiresAt(expiresAt: Long?) = expiresAt(JsonField.ofNullable(expiresAt))

        /**
         * Alias for [Builder.expiresAt].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun expiresAt(expiresAt: Long) = expiresAt(expiresAt as Long?)

        /** Alias for calling [Builder.expiresAt] with `expiresAt.orElse(null)`. */
        fun expiresAt(expiresAt: Optional<Long>) = expiresAt(expiresAt.getOrNull())

        /**
         * Sets [Builder.expiresAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.expiresAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun expiresAt(expiresAt: JsonField<Long>) = apply { this.expiresAt = expiresAt }

        /** The video generation model that produced the job. */
        fun model(model: VideoModel) = model(JsonField.of(model))

        /**
         * Sets [Builder.model] to an arbitrary JSON value.
         *
         * You should usually call [Builder.model] with a well-typed [VideoModel] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun model(model: JsonField<VideoModel>) = apply { this.model = model }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("video")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /** Approximate completion percentage for the generation task. */
        fun progress(progress: Long) = progress(JsonField.of(progress))

        /**
         * Sets [Builder.progress] to an arbitrary JSON value.
         *
         * You should usually call [Builder.progress] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun progress(progress: JsonField<Long>) = apply { this.progress = progress }

        /** The prompt that was used to generate the video. */
        fun prompt(prompt: String?) = prompt(JsonField.ofNullable(prompt))

        /** Alias for calling [Builder.prompt] with `prompt.orElse(null)`. */
        fun prompt(prompt: Optional<String>) = prompt(prompt.getOrNull())

        /**
         * Sets [Builder.prompt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.prompt] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun prompt(prompt: JsonField<String>) = apply { this.prompt = prompt }

        /** Identifier of the source video if this video is a remix. */
        fun remixedFromVideoId(remixedFromVideoId: String?) =
            remixedFromVideoId(JsonField.ofNullable(remixedFromVideoId))

        /**
         * Alias for calling [Builder.remixedFromVideoId] with `remixedFromVideoId.orElse(null)`.
         */
        fun remixedFromVideoId(remixedFromVideoId: Optional<String>) =
            remixedFromVideoId(remixedFromVideoId.getOrNull())

        /**
         * Sets [Builder.remixedFromVideoId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.remixedFromVideoId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun remixedFromVideoId(remixedFromVideoId: JsonField<String>) = apply {
            this.remixedFromVideoId = remixedFromVideoId
        }

        /** Duration of the generated clip in seconds. */
        fun seconds(seconds: VideoSeconds) = seconds(JsonField.of(seconds))

        /**
         * Sets [Builder.seconds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.seconds] with a well-typed [VideoSeconds] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun seconds(seconds: JsonField<VideoSeconds>) = apply { this.seconds = seconds }

        /** The resolution of the generated video. */
        fun size(size: VideoSize) = size(JsonField.of(size))

        /**
         * Sets [Builder.size] to an arbitrary JSON value.
         *
         * You should usually call [Builder.size] with a well-typed [VideoSize] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun size(size: JsonField<VideoSize>) = apply { this.size = size }

        /** Current lifecycle status of the video job. */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

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
         * Returns an immutable instance of [Video].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .completedAt()
         * .createdAt()
         * .error()
         * .expiresAt()
         * .model()
         * .progress()
         * .prompt()
         * .remixedFromVideoId()
         * .seconds()
         * .size()
         * .status()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Video =
            Video(
                checkRequired("id", id),
                checkRequired("completedAt", completedAt),
                checkRequired("createdAt", createdAt),
                checkRequired("error", error),
                checkRequired("expiresAt", expiresAt),
                checkRequired("model", model),
                object_,
                checkRequired("progress", progress),
                checkRequired("prompt", prompt),
                checkRequired("remixedFromVideoId", remixedFromVideoId),
                checkRequired("seconds", seconds),
                checkRequired("size", size),
                checkRequired("status", status),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Video = apply {
        if (validated) {
            return@apply
        }

        id()
        completedAt()
        createdAt()
        error().ifPresent { it.validate() }
        expiresAt()
        model().validate()
        _object_().let {
            if (it != JsonValue.from("video")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        progress()
        prompt()
        remixedFromVideoId()
        seconds().validate()
        size().validate()
        status().validate()
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
            (if (completedAt.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (error.asKnown().getOrNull()?.validity() ?: 0) +
            (if (expiresAt.asKnown().isPresent) 1 else 0) +
            (model.asKnown().getOrNull()?.validity() ?: 0) +
            object_.let { if (it == JsonValue.from("video")) 1 else 0 } +
            (if (progress.asKnown().isPresent) 1 else 0) +
            (if (prompt.asKnown().isPresent) 1 else 0) +
            (if (remixedFromVideoId.asKnown().isPresent) 1 else 0) +
            (seconds.asKnown().getOrNull()?.validity() ?: 0) +
            (size.asKnown().getOrNull()?.validity() ?: 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0)

    /** Current lifecycle status of the video job. */
    class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val QUEUED = of("queued")

            @JvmField val IN_PROGRESS = of("in_progress")

            @JvmField val COMPLETED = of("completed")

            @JvmField val FAILED = of("failed")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            QUEUED,
            IN_PROGRESS,
            COMPLETED,
            FAILED,
        }

        /**
         * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Status] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            QUEUED,
            IN_PROGRESS,
            COMPLETED,
            FAILED,
            /** An enum member indicating that [Status] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                QUEUED -> Value.QUEUED
                IN_PROGRESS -> Value.IN_PROGRESS
                COMPLETED -> Value.COMPLETED
                FAILED -> Value.FAILED
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws OpenAIInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                QUEUED -> Known.QUEUED
                IN_PROGRESS -> Known.IN_PROGRESS
                COMPLETED -> Known.COMPLETED
                FAILED -> Known.FAILED
                else -> throw OpenAIInvalidDataException("Unknown Status: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws OpenAIInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { OpenAIInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

        fun validate(): Status = apply {
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

            return other is Status && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Video &&
            id == other.id &&
            completedAt == other.completedAt &&
            createdAt == other.createdAt &&
            error == other.error &&
            expiresAt == other.expiresAt &&
            model == other.model &&
            object_ == other.object_ &&
            progress == other.progress &&
            prompt == other.prompt &&
            remixedFromVideoId == other.remixedFromVideoId &&
            seconds == other.seconds &&
            size == other.size &&
            status == other.status &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            completedAt,
            createdAt,
            error,
            expiresAt,
            model,
            object_,
            progress,
            prompt,
            remixedFromVideoId,
            seconds,
            size,
            status,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Video{id=$id, completedAt=$completedAt, createdAt=$createdAt, error=$error, expiresAt=$expiresAt, model=$model, object_=$object_, progress=$progress, prompt=$prompt, remixedFromVideoId=$remixedFromVideoId, seconds=$seconds, size=$size, status=$status, additionalProperties=$additionalProperties}"
}
