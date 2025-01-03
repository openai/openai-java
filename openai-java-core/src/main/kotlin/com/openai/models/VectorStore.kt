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
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/** A vector store is a collection of processed files can be used by the `file_search` tool. */
@NoAutoDetect
class VectorStore
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("object")
    @ExcludeMissing
    private val object_: JsonField<Object> = JsonMissing.of(),
    @JsonProperty("created_at")
    @ExcludeMissing
    private val createdAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("name") @ExcludeMissing private val name: JsonField<String> = JsonMissing.of(),
    @JsonProperty("usage_bytes")
    @ExcludeMissing
    private val usageBytes: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("file_counts")
    @ExcludeMissing
    private val fileCounts: JsonField<FileCounts> = JsonMissing.of(),
    @JsonProperty("status")
    @ExcludeMissing
    private val status: JsonField<Status> = JsonMissing.of(),
    @JsonProperty("expires_after")
    @ExcludeMissing
    private val expiresAfter: JsonField<ExpiresAfter> = JsonMissing.of(),
    @JsonProperty("expires_at")
    @ExcludeMissing
    private val expiresAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("last_active_at")
    @ExcludeMissing
    private val lastActiveAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("metadata") @ExcludeMissing private val metadata: JsonValue = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The identifier, which can be referenced in API endpoints. */
    fun id(): String = id.getRequired("id")

    /** The object type, which is always `vector_store`. */
    fun object_(): Object = object_.getRequired("object")

    /** The Unix timestamp (in seconds) for when the vector store was created. */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /** The name of the vector store. */
    fun name(): String = name.getRequired("name")

    /** The total number of bytes used by the files in the vector store. */
    fun usageBytes(): Long = usageBytes.getRequired("usage_bytes")

    fun fileCounts(): FileCounts = fileCounts.getRequired("file_counts")

    /**
     * The status of the vector store, which can be either `expired`, `in_progress`, or `completed`.
     * A status of `completed` indicates that the vector store is ready for use.
     */
    fun status(): Status = status.getRequired("status")

    /** The expiration policy for a vector store. */
    fun expiresAfter(): Optional<ExpiresAfter> =
        Optional.ofNullable(expiresAfter.getNullable("expires_after"))

    /** The Unix timestamp (in seconds) for when the vector store will expire. */
    fun expiresAt(): Optional<Long> = Optional.ofNullable(expiresAt.getNullable("expires_at"))

    /** The Unix timestamp (in seconds) for when the vector store was last active. */
    fun lastActiveAt(): Optional<Long> =
        Optional.ofNullable(lastActiveAt.getNullable("last_active_at"))

    /** The identifier, which can be referenced in API endpoints. */
    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** The object type, which is always `vector_store`. */
    @JsonProperty("object") @ExcludeMissing fun _object_() = object_

    /** The Unix timestamp (in seconds) for when the vector store was created. */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt() = createdAt

    /** The name of the vector store. */
    @JsonProperty("name") @ExcludeMissing fun _name() = name

    /** The total number of bytes used by the files in the vector store. */
    @JsonProperty("usage_bytes") @ExcludeMissing fun _usageBytes() = usageBytes

    @JsonProperty("file_counts") @ExcludeMissing fun _fileCounts() = fileCounts

    /**
     * The status of the vector store, which can be either `expired`, `in_progress`, or `completed`.
     * A status of `completed` indicates that the vector store is ready for use.
     */
    @JsonProperty("status") @ExcludeMissing fun _status() = status

    /** The expiration policy for a vector store. */
    @JsonProperty("expires_after") @ExcludeMissing fun _expiresAfter() = expiresAfter

    /** The Unix timestamp (in seconds) for when the vector store will expire. */
    @JsonProperty("expires_at") @ExcludeMissing fun _expiresAt() = expiresAt

    /** The Unix timestamp (in seconds) for when the vector store was last active. */
    @JsonProperty("last_active_at") @ExcludeMissing fun _lastActiveAt() = lastActiveAt

    /**
     * Set of 16 key-value pairs that can be attached to an object. This can be useful for storing
     * additional information about the object in a structured format. Keys can be a maximum of 64
     * characters long and values can be a maximum of 512 characters long.
     */
    @JsonProperty("metadata") @ExcludeMissing fun _metadata() = metadata

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): VectorStore = apply {
        if (!validated) {
            id()
            object_()
            createdAt()
            name()
            usageBytes()
            fileCounts().validate()
            status()
            expiresAfter().map { it.validate() }
            expiresAt()
            lastActiveAt()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var object_: JsonField<Object> = JsonMissing.of()
        private var createdAt: JsonField<Long> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var usageBytes: JsonField<Long> = JsonMissing.of()
        private var fileCounts: JsonField<FileCounts> = JsonMissing.of()
        private var status: JsonField<Status> = JsonMissing.of()
        private var expiresAfter: JsonField<ExpiresAfter> = JsonMissing.of()
        private var expiresAt: JsonField<Long> = JsonMissing.of()
        private var lastActiveAt: JsonField<Long> = JsonMissing.of()
        private var metadata: JsonValue = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(vectorStore: VectorStore) = apply {
            id = vectorStore.id
            object_ = vectorStore.object_
            createdAt = vectorStore.createdAt
            name = vectorStore.name
            usageBytes = vectorStore.usageBytes
            fileCounts = vectorStore.fileCounts
            status = vectorStore.status
            expiresAfter = vectorStore.expiresAfter
            expiresAt = vectorStore.expiresAt
            lastActiveAt = vectorStore.lastActiveAt
            metadata = vectorStore.metadata
            additionalProperties = vectorStore.additionalProperties.toMutableMap()
        }

        /** The identifier, which can be referenced in API endpoints. */
        fun id(id: String) = id(JsonField.of(id))

        /** The identifier, which can be referenced in API endpoints. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The object type, which is always `vector_store`. */
        fun object_(object_: Object) = object_(JsonField.of(object_))

        /** The object type, which is always `vector_store`. */
        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

        /** The Unix timestamp (in seconds) for when the vector store was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /** The Unix timestamp (in seconds) for when the vector store was created. */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /** The name of the vector store. */
        fun name(name: String) = name(JsonField.of(name))

        /** The name of the vector store. */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** The total number of bytes used by the files in the vector store. */
        fun usageBytes(usageBytes: Long) = usageBytes(JsonField.of(usageBytes))

        /** The total number of bytes used by the files in the vector store. */
        fun usageBytes(usageBytes: JsonField<Long>) = apply { this.usageBytes = usageBytes }

        fun fileCounts(fileCounts: FileCounts) = fileCounts(JsonField.of(fileCounts))

        fun fileCounts(fileCounts: JsonField<FileCounts>) = apply { this.fileCounts = fileCounts }

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

        /** The expiration policy for a vector store. */
        fun expiresAfter(expiresAfter: ExpiresAfter) = expiresAfter(JsonField.of(expiresAfter))

        /** The expiration policy for a vector store. */
        fun expiresAfter(expiresAfter: JsonField<ExpiresAfter>) = apply {
            this.expiresAfter = expiresAfter
        }

        /** The Unix timestamp (in seconds) for when the vector store will expire. */
        fun expiresAt(expiresAt: Long) = expiresAt(JsonField.of(expiresAt))

        /** The Unix timestamp (in seconds) for when the vector store will expire. */
        fun expiresAt(expiresAt: JsonField<Long>) = apply { this.expiresAt = expiresAt }

        /** The Unix timestamp (in seconds) for when the vector store was last active. */
        fun lastActiveAt(lastActiveAt: Long) = lastActiveAt(JsonField.of(lastActiveAt))

        /** The Unix timestamp (in seconds) for when the vector store was last active. */
        fun lastActiveAt(lastActiveAt: JsonField<Long>) = apply { this.lastActiveAt = lastActiveAt }

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format. Keys can be a
         * maximum of 64 characters long and values can be a maximum of 512 characters long.
         */
        fun metadata(metadata: JsonValue) = apply { this.metadata = metadata }

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
                id,
                object_,
                createdAt,
                name,
                usageBytes,
                fileCounts,
                status,
                expiresAfter,
                expiresAt,
                lastActiveAt,
                metadata,
                additionalProperties.toImmutable(),
            )
    }

    @NoAutoDetect
    class FileCounts
    @JsonCreator
    private constructor(
        @JsonProperty("in_progress")
        @ExcludeMissing
        private val inProgress: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("completed")
        @ExcludeMissing
        private val completed: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("failed")
        @ExcludeMissing
        private val failed: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("cancelled")
        @ExcludeMissing
        private val cancelled: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("total")
        @ExcludeMissing
        private val total: JsonField<Long> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The number of files that are currently being processed. */
        fun inProgress(): Long = inProgress.getRequired("in_progress")

        /** The number of files that have been successfully processed. */
        fun completed(): Long = completed.getRequired("completed")

        /** The number of files that have failed to process. */
        fun failed(): Long = failed.getRequired("failed")

        /** The number of files that were cancelled. */
        fun cancelled(): Long = cancelled.getRequired("cancelled")

        /** The total number of files. */
        fun total(): Long = total.getRequired("total")

        /** The number of files that are currently being processed. */
        @JsonProperty("in_progress") @ExcludeMissing fun _inProgress() = inProgress

        /** The number of files that have been successfully processed. */
        @JsonProperty("completed") @ExcludeMissing fun _completed() = completed

        /** The number of files that have failed to process. */
        @JsonProperty("failed") @ExcludeMissing fun _failed() = failed

        /** The number of files that were cancelled. */
        @JsonProperty("cancelled") @ExcludeMissing fun _cancelled() = cancelled

        /** The total number of files. */
        @JsonProperty("total") @ExcludeMissing fun _total() = total

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): FileCounts = apply {
            if (!validated) {
                inProgress()
                completed()
                failed()
                cancelled()
                total()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var inProgress: JsonField<Long> = JsonMissing.of()
            private var completed: JsonField<Long> = JsonMissing.of()
            private var failed: JsonField<Long> = JsonMissing.of()
            private var cancelled: JsonField<Long> = JsonMissing.of()
            private var total: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(fileCounts: FileCounts) = apply {
                inProgress = fileCounts.inProgress
                completed = fileCounts.completed
                failed = fileCounts.failed
                cancelled = fileCounts.cancelled
                total = fileCounts.total
                additionalProperties = fileCounts.additionalProperties.toMutableMap()
            }

            /** The number of files that are currently being processed. */
            fun inProgress(inProgress: Long) = inProgress(JsonField.of(inProgress))

            /** The number of files that are currently being processed. */
            fun inProgress(inProgress: JsonField<Long>) = apply { this.inProgress = inProgress }

            /** The number of files that have been successfully processed. */
            fun completed(completed: Long) = completed(JsonField.of(completed))

            /** The number of files that have been successfully processed. */
            fun completed(completed: JsonField<Long>) = apply { this.completed = completed }

            /** The number of files that have failed to process. */
            fun failed(failed: Long) = failed(JsonField.of(failed))

            /** The number of files that have failed to process. */
            fun failed(failed: JsonField<Long>) = apply { this.failed = failed }

            /** The number of files that were cancelled. */
            fun cancelled(cancelled: Long) = cancelled(JsonField.of(cancelled))

            /** The number of files that were cancelled. */
            fun cancelled(cancelled: JsonField<Long>) = apply { this.cancelled = cancelled }

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
                    inProgress,
                    completed,
                    failed,
                    cancelled,
                    total,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is FileCounts && inProgress == other.inProgress && completed == other.completed && failed == other.failed && cancelled == other.cancelled && total == other.total && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(inProgress, completed, failed, cancelled, total, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "FileCounts{inProgress=$inProgress, completed=$completed, failed=$failed, cancelled=$cancelled, total=$total, additionalProperties=$additionalProperties}"
    }

    class Object
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val VECTOR_STORE = of("vector_store")

            @JvmStatic fun of(value: String) = Object(JsonField.of(value))
        }

        enum class Known {
            VECTOR_STORE,
        }

        enum class Value {
            VECTOR_STORE,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                VECTOR_STORE -> Value.VECTOR_STORE
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                VECTOR_STORE -> Known.VECTOR_STORE
                else -> throw OpenAIInvalidDataException("Unknown Object: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Object && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    class Status
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val EXPIRED = of("expired")

            @JvmField val IN_PROGRESS = of("in_progress")

            @JvmField val COMPLETED = of("completed")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        enum class Known {
            EXPIRED,
            IN_PROGRESS,
            COMPLETED,
        }

        enum class Value {
            EXPIRED,
            IN_PROGRESS,
            COMPLETED,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                EXPIRED -> Value.EXPIRED
                IN_PROGRESS -> Value.IN_PROGRESS
                COMPLETED -> Value.COMPLETED
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                EXPIRED -> Known.EXPIRED
                IN_PROGRESS -> Known.IN_PROGRESS
                COMPLETED -> Known.COMPLETED
                else -> throw OpenAIInvalidDataException("Unknown Status: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

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
        @JsonProperty("anchor")
        @ExcludeMissing
        private val anchor: JsonField<Anchor> = JsonMissing.of(),
        @JsonProperty("days") @ExcludeMissing private val days: JsonField<Long> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Anchor timestamp after which the expiration policy applies. Supported anchors:
         * `last_active_at`.
         */
        fun anchor(): Anchor = anchor.getRequired("anchor")

        /** The number of days after the anchor time that the vector store will expire. */
        fun days(): Long = days.getRequired("days")

        /**
         * Anchor timestamp after which the expiration policy applies. Supported anchors:
         * `last_active_at`.
         */
        @JsonProperty("anchor") @ExcludeMissing fun _anchor() = anchor

        /** The number of days after the anchor time that the vector store will expire. */
        @JsonProperty("days") @ExcludeMissing fun _days() = days

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ExpiresAfter = apply {
            if (!validated) {
                anchor()
                days()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var anchor: JsonField<Anchor> = JsonMissing.of()
            private var days: JsonField<Long> = JsonMissing.of()
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
            fun anchor(anchor: Anchor) = anchor(JsonField.of(anchor))

            /**
             * Anchor timestamp after which the expiration policy applies. Supported anchors:
             * `last_active_at`.
             */
            fun anchor(anchor: JsonField<Anchor>) = apply { this.anchor = anchor }

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
                    days,
                    additionalProperties.toImmutable(),
                )
        }

        class Anchor
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val LAST_ACTIVE_AT = of("last_active_at")

                @JvmStatic fun of(value: String) = Anchor(JsonField.of(value))
            }

            enum class Known {
                LAST_ACTIVE_AT,
            }

            enum class Value {
                LAST_ACTIVE_AT,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    LAST_ACTIVE_AT -> Value.LAST_ACTIVE_AT
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    LAST_ACTIVE_AT -> Known.LAST_ACTIVE_AT
                    else -> throw OpenAIInvalidDataException("Unknown Anchor: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Anchor && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
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

        return /* spotless:off */ other is VectorStore && id == other.id && object_ == other.object_ && createdAt == other.createdAt && name == other.name && usageBytes == other.usageBytes && fileCounts == other.fileCounts && status == other.status && expiresAfter == other.expiresAfter && expiresAt == other.expiresAt && lastActiveAt == other.lastActiveAt && metadata == other.metadata && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, object_, createdAt, name, usageBytes, fileCounts, status, expiresAfter, expiresAt, lastActiveAt, metadata, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "VectorStore{id=$id, object_=$object_, createdAt=$createdAt, name=$name, usageBytes=$usageBytes, fileCounts=$fileCounts, status=$status, expiresAfter=$expiresAfter, expiresAt=$expiresAt, lastActiveAt=$lastActiveAt, metadata=$metadata, additionalProperties=$additionalProperties}"
}
