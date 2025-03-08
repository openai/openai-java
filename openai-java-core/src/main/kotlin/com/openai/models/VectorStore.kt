// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.checkRequired
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A vector store is a collection of processed files can be used by the `file_search` tool. */
@NoAutoDetect
class VectorStore
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("created_at")
    @ExcludeMissing
    private val createdAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("file_counts")
    @ExcludeMissing
    private val fileCounts: JsonField<FileCounts> = JsonMissing.of(),
    @JsonProperty("last_active_at")
    @ExcludeMissing
    private val lastActiveAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("metadata")
    @ExcludeMissing
    private val metadata: JsonField<Metadata> = JsonMissing.of(),
    @JsonProperty("name") @ExcludeMissing private val name: JsonField<String> = JsonMissing.of(),
    @JsonProperty("object") @ExcludeMissing private val object_: JsonValue = JsonMissing.of(),
    @JsonProperty("status")
    @ExcludeMissing
    private val status: JsonField<Status> = JsonMissing.of(),
    @JsonProperty("usage_bytes")
    @ExcludeMissing
    private val usageBytes: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("expires_after")
    @ExcludeMissing
    private val expiresAfter: JsonField<ExpiresAfter> = JsonMissing.of(),
    @JsonProperty("expires_at")
    @ExcludeMissing
    private val expiresAt: JsonField<Long> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The identifier, which can be referenced in API endpoints. */
    fun id(): String = id.getRequired("id")

    /** The Unix timestamp (in seconds) for when the vector store was created. */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    fun fileCounts(): FileCounts = fileCounts.getRequired("file_counts")

    /** The Unix timestamp (in seconds) for when the vector store was last active. */
    fun lastActiveAt(): Optional<Long> =
        Optional.ofNullable(lastActiveAt.getNullable("last_active_at"))

    /**
     * Set of 16 key-value pairs that can be attached to an object. This can be useful for storing
     * additional information about the object in a structured format, and querying for objects via
     * API or the dashboard.
     *
     * Keys are strings with a maximum length of 64 characters. Values are strings with a maximum
     * length of 512 characters.
     */
    fun metadata(): Optional<Metadata> = Optional.ofNullable(metadata.getNullable("metadata"))

    /** The name of the vector store. */
    fun name(): String = name.getRequired("name")

    /** The object type, which is always `vector_store`. */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * The status of the vector store, which can be either `expired`, `in_progress`, or `completed`.
     * A status of `completed` indicates that the vector store is ready for use.
     */
    fun status(): Status = status.getRequired("status")

    /** The total number of bytes used by the files in the vector store. */
    fun usageBytes(): Long = usageBytes.getRequired("usage_bytes")

    /** The expiration policy for a vector store. */
    fun expiresAfter(): Optional<ExpiresAfter> =
        Optional.ofNullable(expiresAfter.getNullable("expires_after"))

    /** The Unix timestamp (in seconds) for when the vector store will expire. */
    fun expiresAt(): Optional<Long> = Optional.ofNullable(expiresAt.getNullable("expires_at"))

    /** The identifier, which can be referenced in API endpoints. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /** The Unix timestamp (in seconds) for when the vector store was created. */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt(): JsonField<Long> = createdAt

    @JsonProperty("file_counts")
    @ExcludeMissing
    fun _fileCounts(): JsonField<FileCounts> = fileCounts

    /** The Unix timestamp (in seconds) for when the vector store was last active. */
    @JsonProperty("last_active_at")
    @ExcludeMissing
    fun _lastActiveAt(): JsonField<Long> = lastActiveAt

    /**
     * Set of 16 key-value pairs that can be attached to an object. This can be useful for storing
     * additional information about the object in a structured format, and querying for objects via
     * API or the dashboard.
     *
     * Keys are strings with a maximum length of 64 characters. Values are strings with a maximum
     * length of 512 characters.
     */
    @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonField<Metadata> = metadata

    /** The name of the vector store. */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * The status of the vector store, which can be either `expired`, `in_progress`, or `completed`.
     * A status of `completed` indicates that the vector store is ready for use.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

    /** The total number of bytes used by the files in the vector store. */
    @JsonProperty("usage_bytes") @ExcludeMissing fun _usageBytes(): JsonField<Long> = usageBytes

    /** The expiration policy for a vector store. */
    @JsonProperty("expires_after")
    @ExcludeMissing
    fun _expiresAfter(): JsonField<ExpiresAfter> = expiresAfter

    /** The Unix timestamp (in seconds) for when the vector store will expire. */
    @JsonProperty("expires_at") @ExcludeMissing fun _expiresAt(): JsonField<Long> = expiresAt

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): VectorStore = apply {
        if (validated) {
            return@apply
        }

        id()
        createdAt()
        fileCounts().validate()
        lastActiveAt()
        metadata().ifPresent { it.validate() }
        name()
        _object_().let {
            if (it != JsonValue.from("vector_store")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        status()
        usageBytes()
        expiresAfter().ifPresent { it.validate() }
        expiresAt()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [VectorStore].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .fileCounts()
         * .lastActiveAt()
         * .metadata()
         * .name()
         * .status()
         * .usageBytes()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [VectorStore]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var createdAt: JsonField<Long>? = null
        private var fileCounts: JsonField<FileCounts>? = null
        private var lastActiveAt: JsonField<Long>? = null
        private var metadata: JsonField<Metadata>? = null
        private var name: JsonField<String>? = null
        private var object_: JsonValue = JsonValue.from("vector_store")
        private var status: JsonField<Status>? = null
        private var usageBytes: JsonField<Long>? = null
        private var expiresAfter: JsonField<ExpiresAfter> = JsonMissing.of()
        private var expiresAt: JsonField<Long> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(vectorStore: VectorStore) = apply {
            id = vectorStore.id
            createdAt = vectorStore.createdAt
            fileCounts = vectorStore.fileCounts
            lastActiveAt = vectorStore.lastActiveAt
            metadata = vectorStore.metadata
            name = vectorStore.name
            object_ = vectorStore.object_
            status = vectorStore.status
            usageBytes = vectorStore.usageBytes
            expiresAfter = vectorStore.expiresAfter
            expiresAt = vectorStore.expiresAt
            additionalProperties = vectorStore.additionalProperties.toMutableMap()
        }

        /** The identifier, which can be referenced in API endpoints. */
        fun id(id: String) = id(JsonField.of(id))

        /** The identifier, which can be referenced in API endpoints. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The Unix timestamp (in seconds) for when the vector store was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /** The Unix timestamp (in seconds) for when the vector store was created. */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        fun fileCounts(fileCounts: FileCounts) = fileCounts(JsonField.of(fileCounts))

        fun fileCounts(fileCounts: JsonField<FileCounts>) = apply { this.fileCounts = fileCounts }

        /** The Unix timestamp (in seconds) for when the vector store was last active. */
        fun lastActiveAt(lastActiveAt: Long?) = lastActiveAt(JsonField.ofNullable(lastActiveAt))

        /** The Unix timestamp (in seconds) for when the vector store was last active. */
        fun lastActiveAt(lastActiveAt: Long) = lastActiveAt(lastActiveAt as Long?)

        /** The Unix timestamp (in seconds) for when the vector store was last active. */
        fun lastActiveAt(lastActiveAt: Optional<Long>) = lastActiveAt(lastActiveAt.getOrNull())

        /** The Unix timestamp (in seconds) for when the vector store was last active. */
        fun lastActiveAt(lastActiveAt: JsonField<Long>) = apply { this.lastActiveAt = lastActiveAt }

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format, and querying for
         * objects via API or the dashboard.
         *
         * Keys are strings with a maximum length of 64 characters. Values are strings with a
         * maximum length of 512 characters.
         */
        fun metadata(metadata: Metadata?) = metadata(JsonField.ofNullable(metadata))

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format, and querying for
         * objects via API or the dashboard.
         *
         * Keys are strings with a maximum length of 64 characters. Values are strings with a
         * maximum length of 512 characters.
         */
        fun metadata(metadata: Optional<Metadata>) = metadata(metadata.getOrNull())

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format, and querying for
         * objects via API or the dashboard.
         *
         * Keys are strings with a maximum length of 64 characters. Values are strings with a
         * maximum length of 512 characters.
         */
        fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

        /** The name of the vector store. */
        fun name(name: String) = name(JsonField.of(name))

        /** The name of the vector store. */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** The object type, which is always `vector_store`. */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /**
         * The status of the vector store, which can be either `expired`, `in_progress`, or
         * `completed`. A status of `completed` indicates that the vector store is ready for use.
         */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * The status of the vector store, which can be either `expired`, `in_progress`, or
         * `completed`. A status of `completed` indicates that the vector store is ready for use.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /** The total number of bytes used by the files in the vector store. */
        fun usageBytes(usageBytes: Long) = usageBytes(JsonField.of(usageBytes))

        /** The total number of bytes used by the files in the vector store. */
        fun usageBytes(usageBytes: JsonField<Long>) = apply { this.usageBytes = usageBytes }

        /** The expiration policy for a vector store. */
        fun expiresAfter(expiresAfter: ExpiresAfter) = expiresAfter(JsonField.of(expiresAfter))

        /** The expiration policy for a vector store. */
        fun expiresAfter(expiresAfter: JsonField<ExpiresAfter>) = apply {
            this.expiresAfter = expiresAfter
        }

        /** The Unix timestamp (in seconds) for when the vector store will expire. */
        fun expiresAt(expiresAt: Long?) = expiresAt(JsonField.ofNullable(expiresAt))

        /** The Unix timestamp (in seconds) for when the vector store will expire. */
        fun expiresAt(expiresAt: Long) = expiresAt(expiresAt as Long?)

        /** The Unix timestamp (in seconds) for when the vector store will expire. */
        fun expiresAt(expiresAt: Optional<Long>) = expiresAt(expiresAt.getOrNull())

        /** The Unix timestamp (in seconds) for when the vector store will expire. */
        fun expiresAt(expiresAt: JsonField<Long>) = apply { this.expiresAt = expiresAt }

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

        fun build(): VectorStore =
            VectorStore(
                checkRequired("id", id),
                checkRequired("createdAt", createdAt),
                checkRequired("fileCounts", fileCounts),
                checkRequired("lastActiveAt", lastActiveAt),
                checkRequired("metadata", metadata),
                checkRequired("name", name),
                object_,
                checkRequired("status", status),
                checkRequired("usageBytes", usageBytes),
                expiresAfter,
                expiresAt,
                additionalProperties.toImmutable(),
            )
    }

    @NoAutoDetect
    class FileCounts
    @JsonCreator
    private constructor(
        @JsonProperty("cancelled")
        @ExcludeMissing
        private val cancelled: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("completed")
        @ExcludeMissing
        private val completed: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("failed")
        @ExcludeMissing
        private val failed: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("in_progress")
        @ExcludeMissing
        private val inProgress: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("total")
        @ExcludeMissing
        private val total: JsonField<Long> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The number of files that were cancelled. */
        fun cancelled(): Long = cancelled.getRequired("cancelled")

        /** The number of files that have been successfully processed. */
        fun completed(): Long = completed.getRequired("completed")

        /** The number of files that have failed to process. */
        fun failed(): Long = failed.getRequired("failed")

        /** The number of files that are currently being processed. */
        fun inProgress(): Long = inProgress.getRequired("in_progress")

        /** The total number of files. */
        fun total(): Long = total.getRequired("total")

        /** The number of files that were cancelled. */
        @JsonProperty("cancelled") @ExcludeMissing fun _cancelled(): JsonField<Long> = cancelled

        /** The number of files that have been successfully processed. */
        @JsonProperty("completed") @ExcludeMissing fun _completed(): JsonField<Long> = completed

        /** The number of files that have failed to process. */
        @JsonProperty("failed") @ExcludeMissing fun _failed(): JsonField<Long> = failed

        /** The number of files that are currently being processed. */
        @JsonProperty("in_progress") @ExcludeMissing fun _inProgress(): JsonField<Long> = inProgress

        /** The total number of files. */
        @JsonProperty("total") @ExcludeMissing fun _total(): JsonField<Long> = total

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): FileCounts = apply {
            if (validated) {
                return@apply
            }

            cancelled()
            completed()
            failed()
            inProgress()
            total()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [FileCounts].
             *
             * The following fields are required:
             * ```java
             * .cancelled()
             * .completed()
             * .failed()
             * .inProgress()
             * .total()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [FileCounts]. */
        class Builder internal constructor() {

            private var cancelled: JsonField<Long>? = null
            private var completed: JsonField<Long>? = null
            private var failed: JsonField<Long>? = null
            private var inProgress: JsonField<Long>? = null
            private var total: JsonField<Long>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(fileCounts: FileCounts) = apply {
                cancelled = fileCounts.cancelled
                completed = fileCounts.completed
                failed = fileCounts.failed
                inProgress = fileCounts.inProgress
                total = fileCounts.total
                additionalProperties = fileCounts.additionalProperties.toMutableMap()
            }

            /** The number of files that were cancelled. */
            fun cancelled(cancelled: Long) = cancelled(JsonField.of(cancelled))

            /** The number of files that were cancelled. */
            fun cancelled(cancelled: JsonField<Long>) = apply { this.cancelled = cancelled }

            /** The number of files that have been successfully processed. */
            fun completed(completed: Long) = completed(JsonField.of(completed))

            /** The number of files that have been successfully processed. */
            fun completed(completed: JsonField<Long>) = apply { this.completed = completed }

            /** The number of files that have failed to process. */
            fun failed(failed: Long) = failed(JsonField.of(failed))

            /** The number of files that have failed to process. */
            fun failed(failed: JsonField<Long>) = apply { this.failed = failed }

            /** The number of files that are currently being processed. */
            fun inProgress(inProgress: Long) = inProgress(JsonField.of(inProgress))

            /** The number of files that are currently being processed. */
            fun inProgress(inProgress: JsonField<Long>) = apply { this.inProgress = inProgress }

            /** The total number of files. */
            fun total(total: Long) = total(JsonField.of(total))

            /** The total number of files. */
            fun total(total: JsonField<Long>) = apply { this.total = total }

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

            fun build(): FileCounts =
                FileCounts(
                    checkRequired("cancelled", cancelled),
                    checkRequired("completed", completed),
                    checkRequired("failed", failed),
                    checkRequired("inProgress", inProgress),
                    checkRequired("total", total),
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is FileCounts && cancelled == other.cancelled && completed == other.completed && failed == other.failed && inProgress == other.inProgress && total == other.total && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(cancelled, completed, failed, inProgress, total, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "FileCounts{cancelled=$cancelled, completed=$completed, failed=$failed, inProgress=$inProgress, total=$total, additionalProperties=$additionalProperties}"
    }

    /**
     * The status of the vector store, which can be either `expired`, `in_progress`, or `completed`.
     * A status of `completed` indicates that the vector store is ready for use.
     */
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

            @JvmField val EXPIRED = of("expired")

            @JvmField val IN_PROGRESS = of("in_progress")

            @JvmField val COMPLETED = of("completed")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            EXPIRED,
            IN_PROGRESS,
            COMPLETED,
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
            EXPIRED,
            IN_PROGRESS,
            COMPLETED,
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
                EXPIRED -> Value.EXPIRED
                IN_PROGRESS -> Value.IN_PROGRESS
                COMPLETED -> Value.COMPLETED
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
                EXPIRED -> Known.EXPIRED
                IN_PROGRESS -> Known.IN_PROGRESS
                COMPLETED -> Known.COMPLETED
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Status && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** The expiration policy for a vector store. */
    @NoAutoDetect
    class ExpiresAfter
    @JsonCreator
    private constructor(
        @JsonProperty("anchor") @ExcludeMissing private val anchor: JsonValue = JsonMissing.of(),
        @JsonProperty("days") @ExcludeMissing private val days: JsonField<Long> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Anchor timestamp after which the expiration policy applies. Supported anchors:
         * `last_active_at`.
         */
        @JsonProperty("anchor") @ExcludeMissing fun _anchor(): JsonValue = anchor

        /** The number of days after the anchor time that the vector store will expire. */
        fun days(): Long = days.getRequired("days")

        /** The number of days after the anchor time that the vector store will expire. */
        @JsonProperty("days") @ExcludeMissing fun _days(): JsonField<Long> = days

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ExpiresAfter = apply {
            if (validated) {
                return@apply
            }

            _anchor().let {
                if (it != JsonValue.from("last_active_at")) {
                    throw OpenAIInvalidDataException("'anchor' is invalid, received $it")
                }
            }
            days()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [ExpiresAfter].
             *
             * The following fields are required:
             * ```java
             * .days()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ExpiresAfter]. */
        class Builder internal constructor() {

            private var anchor: JsonValue = JsonValue.from("last_active_at")
            private var days: JsonField<Long>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(expiresAfter: ExpiresAfter) = apply {
                anchor = expiresAfter.anchor
                days = expiresAfter.days
                additionalProperties = expiresAfter.additionalProperties.toMutableMap()
            }

            /**
             * Anchor timestamp after which the expiration policy applies. Supported anchors:
             * `last_active_at`.
             */
            fun anchor(anchor: JsonValue) = apply { this.anchor = anchor }

            /** The number of days after the anchor time that the vector store will expire. */
            fun days(days: Long) = days(JsonField.of(days))

            /** The number of days after the anchor time that the vector store will expire. */
            fun days(days: JsonField<Long>) = apply { this.days = days }

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

            fun build(): ExpiresAfter =
                ExpiresAfter(
                    anchor,
                    checkRequired("days", days),
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ExpiresAfter && anchor == other.anchor && days == other.days && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(anchor, days, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ExpiresAfter{anchor=$anchor, days=$days, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is VectorStore && id == other.id && createdAt == other.createdAt && fileCounts == other.fileCounts && lastActiveAt == other.lastActiveAt && metadata == other.metadata && name == other.name && object_ == other.object_ && status == other.status && usageBytes == other.usageBytes && expiresAfter == other.expiresAfter && expiresAt == other.expiresAt && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, createdAt, fileCounts, lastActiveAt, metadata, name, object_, status, usageBytes, expiresAfter, expiresAt, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "VectorStore{id=$id, createdAt=$createdAt, fileCounts=$fileCounts, lastActiveAt=$lastActiveAt, metadata=$metadata, name=$name, object_=$object_, status=$status, usageBytes=$usageBytes, expiresAfter=$expiresAfter, expiresAt=$expiresAt, additionalProperties=$additionalProperties}"
}
