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

/** A batch of files attached to a vector store. */
@NoAutoDetect
class VectorStoreFileBatch
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("object")
    @ExcludeMissing
    private val object_: JsonField<Object> = JsonMissing.of(),
    @JsonProperty("created_at")
    @ExcludeMissing
    private val createdAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("vector_store_id")
    @ExcludeMissing
    private val vectorStoreId: JsonField<String> = JsonMissing.of(),
    @JsonProperty("status")
    @ExcludeMissing
    private val status: JsonField<Status> = JsonMissing.of(),
    @JsonProperty("file_counts")
    @ExcludeMissing
    private val fileCounts: JsonField<FileCounts> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The identifier, which can be referenced in API endpoints. */
    fun id(): String = id.getRequired("id")

    /** The object type, which is always `vector_store.file_batch`. */
    fun object_(): Object = object_.getRequired("object")

    /** The Unix timestamp (in seconds) for when the vector store files batch was created. */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /**
     * The ID of the
     * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object) that the
     * [File](https://platform.openai.com/docs/api-reference/files) is attached to.
     */
    fun vectorStoreId(): String = vectorStoreId.getRequired("vector_store_id")

    /**
     * The status of the vector store files batch, which can be either `in_progress`, `completed`,
     * `cancelled` or `failed`.
     */
    fun status(): Status = status.getRequired("status")

    fun fileCounts(): FileCounts = fileCounts.getRequired("file_counts")

    /** The identifier, which can be referenced in API endpoints. */
    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** The object type, which is always `vector_store.file_batch`. */
    @JsonProperty("object") @ExcludeMissing fun _object_() = object_

    /** The Unix timestamp (in seconds) for when the vector store files batch was created. */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt() = createdAt

    /**
     * The ID of the
     * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object) that the
     * [File](https://platform.openai.com/docs/api-reference/files) is attached to.
     */
    @JsonProperty("vector_store_id") @ExcludeMissing fun _vectorStoreId() = vectorStoreId

    /**
     * The status of the vector store files batch, which can be either `in_progress`, `completed`,
     * `cancelled` or `failed`.
     */
    @JsonProperty("status") @ExcludeMissing fun _status() = status

    @JsonProperty("file_counts") @ExcludeMissing fun _fileCounts() = fileCounts

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): VectorStoreFileBatch = apply {
        if (!validated) {
            id()
            object_()
            createdAt()
            vectorStoreId()
            status()
            fileCounts().validate()
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
        private var vectorStoreId: JsonField<String> = JsonMissing.of()
        private var status: JsonField<Status> = JsonMissing.of()
        private var fileCounts: JsonField<FileCounts> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(vectorStoreFileBatch: VectorStoreFileBatch) = apply {
            id = vectorStoreFileBatch.id
            object_ = vectorStoreFileBatch.object_
            createdAt = vectorStoreFileBatch.createdAt
            vectorStoreId = vectorStoreFileBatch.vectorStoreId
            status = vectorStoreFileBatch.status
            fileCounts = vectorStoreFileBatch.fileCounts
            additionalProperties = vectorStoreFileBatch.additionalProperties.toMutableMap()
        }

        /** The identifier, which can be referenced in API endpoints. */
        fun id(id: String) = id(JsonField.of(id))

        /** The identifier, which can be referenced in API endpoints. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The object type, which is always `vector_store.file_batch`. */
        fun object_(object_: Object) = object_(JsonField.of(object_))

        /** The object type, which is always `vector_store.file_batch`. */
        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

        /** The Unix timestamp (in seconds) for when the vector store files batch was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /** The Unix timestamp (in seconds) for when the vector store files batch was created. */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /**
         * The ID of the
         * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object) that
         * the [File](https://platform.openai.com/docs/api-reference/files) is attached to.
         */
        fun vectorStoreId(vectorStoreId: String) = vectorStoreId(JsonField.of(vectorStoreId))

        /**
         * The ID of the
         * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object) that
         * the [File](https://platform.openai.com/docs/api-reference/files) is attached to.
         */
        fun vectorStoreId(vectorStoreId: JsonField<String>) = apply {
            this.vectorStoreId = vectorStoreId
        }

        /**
         * The status of the vector store files batch, which can be either `in_progress`,
         * `completed`, `cancelled` or `failed`.
         */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * The status of the vector store files batch, which can be either `in_progress`,
         * `completed`, `cancelled` or `failed`.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        fun fileCounts(fileCounts: FileCounts) = fileCounts(JsonField.of(fileCounts))

        fun fileCounts(fileCounts: JsonField<FileCounts>) = apply { this.fileCounts = fileCounts }

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

        fun build(): VectorStoreFileBatch =
            VectorStoreFileBatch(
                id,
                object_,
                createdAt,
                vectorStoreId,
                status,
                fileCounts,
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

        /** The number of files that have been processed. */
        fun completed(): Long = completed.getRequired("completed")

        /** The number of files that have failed to process. */
        fun failed(): Long = failed.getRequired("failed")

        /** The number of files that where cancelled. */
        fun cancelled(): Long = cancelled.getRequired("cancelled")

        /** The total number of files. */
        fun total(): Long = total.getRequired("total")

        /** The number of files that are currently being processed. */
        @JsonProperty("in_progress") @ExcludeMissing fun _inProgress() = inProgress

        /** The number of files that have been processed. */
        @JsonProperty("completed") @ExcludeMissing fun _completed() = completed

        /** The number of files that have failed to process. */
        @JsonProperty("failed") @ExcludeMissing fun _failed() = failed

        /** The number of files that where cancelled. */
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

            /** The number of files that have been processed. */
            fun completed(completed: Long) = completed(JsonField.of(completed))

            /** The number of files that have been processed. */
            fun completed(completed: JsonField<Long>) = apply { this.completed = completed }

            /** The number of files that have failed to process. */
            fun failed(failed: Long) = failed(JsonField.of(failed))

            /** The number of files that have failed to process. */
            fun failed(failed: JsonField<Long>) = apply { this.failed = failed }

            /** The number of files that where cancelled. */
            fun cancelled(cancelled: Long) = cancelled(JsonField.of(cancelled))

            /** The number of files that where cancelled. */
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

            @JvmField val VECTOR_STORE_FILES_BATCH = of("vector_store.files_batch")

            @JvmStatic fun of(value: String) = Object(JsonField.of(value))
        }

        enum class Known {
            VECTOR_STORE_FILES_BATCH,
        }

        enum class Value {
            VECTOR_STORE_FILES_BATCH,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                VECTOR_STORE_FILES_BATCH -> Value.VECTOR_STORE_FILES_BATCH
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                VECTOR_STORE_FILES_BATCH -> Known.VECTOR_STORE_FILES_BATCH
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

            @JvmField val IN_PROGRESS = of("in_progress")

            @JvmField val COMPLETED = of("completed")

            @JvmField val CANCELLED = of("cancelled")

            @JvmField val FAILED = of("failed")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        enum class Known {
            IN_PROGRESS,
            COMPLETED,
            CANCELLED,
            FAILED,
        }

        enum class Value {
            IN_PROGRESS,
            COMPLETED,
            CANCELLED,
            FAILED,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                IN_PROGRESS -> Value.IN_PROGRESS
                COMPLETED -> Value.COMPLETED
                CANCELLED -> Value.CANCELLED
                FAILED -> Value.FAILED
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                IN_PROGRESS -> Known.IN_PROGRESS
                COMPLETED -> Known.COMPLETED
                CANCELLED -> Known.CANCELLED
                FAILED -> Known.FAILED
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is VectorStoreFileBatch && id == other.id && object_ == other.object_ && createdAt == other.createdAt && vectorStoreId == other.vectorStoreId && status == other.status && fileCounts == other.fileCounts && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, object_, createdAt, vectorStoreId, status, fileCounts, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "VectorStoreFileBatch{id=$id, object_=$object_, createdAt=$createdAt, vectorStoreId=$vectorStoreId, status=$status, fileCounts=$fileCounts, additionalProperties=$additionalProperties}"
}
