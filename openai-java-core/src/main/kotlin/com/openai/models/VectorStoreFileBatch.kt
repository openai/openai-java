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

/** A batch of files attached to a vector store. */
@NoAutoDetect
class VectorStoreFileBatch
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("created_at")
    @ExcludeMissing
    private val createdAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("file_counts")
    @ExcludeMissing
    private val fileCounts: JsonField<FileCounts> = JsonMissing.of(),
    @JsonProperty("object") @ExcludeMissing private val object_: JsonValue = JsonMissing.of(),
    @JsonProperty("status")
    @ExcludeMissing
    private val status: JsonField<Status> = JsonMissing.of(),
    @JsonProperty("vector_store_id")
    @ExcludeMissing
    private val vectorStoreId: JsonField<String> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The identifier, which can be referenced in API endpoints. */
    fun id(): String = id.getRequired("id")

    /** The Unix timestamp (in seconds) for when the vector store files batch was created. */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    fun fileCounts(): FileCounts = fileCounts.getRequired("file_counts")

    /** The object type, which is always `vector_store.file_batch`. */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * The status of the vector store files batch, which can be either `in_progress`, `completed`,
     * `cancelled` or `failed`.
     */
    fun status(): Status = status.getRequired("status")

    /**
     * The ID of the
     * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object) that the
     * [File](https://platform.openai.com/docs/api-reference/files) is attached to.
     */
    fun vectorStoreId(): String = vectorStoreId.getRequired("vector_store_id")

    /** The identifier, which can be referenced in API endpoints. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /** The Unix timestamp (in seconds) for when the vector store files batch was created. */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt(): JsonField<Long> = createdAt

    @JsonProperty("file_counts")
    @ExcludeMissing
    fun _fileCounts(): JsonField<FileCounts> = fileCounts

    /**
     * The status of the vector store files batch, which can be either `in_progress`, `completed`,
     * `cancelled` or `failed`.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

    /**
     * The ID of the
     * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object) that the
     * [File](https://platform.openai.com/docs/api-reference/files) is attached to.
     */
    @JsonProperty("vector_store_id")
    @ExcludeMissing
    fun _vectorStoreId(): JsonField<String> = vectorStoreId

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): VectorStoreFileBatch = apply {
        if (validated) {
            return@apply
        }

        id()
        createdAt()
        fileCounts().validate()
        _object_().let {
            if (it != JsonValue.from("vector_store.files_batch")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        status()
        vectorStoreId()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [VectorStoreFileBatch].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .fileCounts()
         * .status()
         * .vectorStoreId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [VectorStoreFileBatch]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var createdAt: JsonField<Long>? = null
        private var fileCounts: JsonField<FileCounts>? = null
        private var object_: JsonValue = JsonValue.from("vector_store.files_batch")
        private var status: JsonField<Status>? = null
        private var vectorStoreId: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(vectorStoreFileBatch: VectorStoreFileBatch) = apply {
            id = vectorStoreFileBatch.id
            createdAt = vectorStoreFileBatch.createdAt
            fileCounts = vectorStoreFileBatch.fileCounts
            object_ = vectorStoreFileBatch.object_
            status = vectorStoreFileBatch.status
            vectorStoreId = vectorStoreFileBatch.vectorStoreId
            additionalProperties = vectorStoreFileBatch.additionalProperties.toMutableMap()
        }

        /** The identifier, which can be referenced in API endpoints. */
        fun id(id: String) = id(JsonField.of(id))

        /** The identifier, which can be referenced in API endpoints. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The Unix timestamp (in seconds) for when the vector store files batch was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /** The Unix timestamp (in seconds) for when the vector store files batch was created. */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        fun fileCounts(fileCounts: FileCounts) = fileCounts(JsonField.of(fileCounts))

        fun fileCounts(fileCounts: JsonField<FileCounts>) = apply { this.fileCounts = fileCounts }

        /** The object type, which is always `vector_store.file_batch`. */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

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
                checkRequired("id", id),
                checkRequired("createdAt", createdAt),
                checkRequired("fileCounts", fileCounts),
                object_,
                checkRequired("status", status),
                checkRequired("vectorStoreId", vectorStoreId),
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

        /** The number of files that where cancelled. */
        fun cancelled(): Long = cancelled.getRequired("cancelled")

        /** The number of files that have been processed. */
        fun completed(): Long = completed.getRequired("completed")

        /** The number of files that have failed to process. */
        fun failed(): Long = failed.getRequired("failed")

        /** The number of files that are currently being processed. */
        fun inProgress(): Long = inProgress.getRequired("in_progress")

        /** The total number of files. */
        fun total(): Long = total.getRequired("total")

        /** The number of files that where cancelled. */
        @JsonProperty("cancelled") @ExcludeMissing fun _cancelled(): JsonField<Long> = cancelled

        /** The number of files that have been processed. */
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

            /** The number of files that where cancelled. */
            fun cancelled(cancelled: Long) = cancelled(JsonField.of(cancelled))

            /** The number of files that where cancelled. */
            fun cancelled(cancelled: JsonField<Long>) = apply { this.cancelled = cancelled }

            /** The number of files that have been processed. */
            fun completed(completed: Long) = completed(JsonField.of(completed))

            /** The number of files that have been processed. */
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
     * The status of the vector store files batch, which can be either `in_progress`, `completed`,
     * `cancelled` or `failed`.
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

            @JvmField val IN_PROGRESS = of("in_progress")

            @JvmField val COMPLETED = of("completed")

            @JvmField val CANCELLED = of("cancelled")

            @JvmField val FAILED = of("failed")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            IN_PROGRESS,
            COMPLETED,
            CANCELLED,
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
            IN_PROGRESS,
            COMPLETED,
            CANCELLED,
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
                IN_PROGRESS -> Value.IN_PROGRESS
                COMPLETED -> Value.COMPLETED
                CANCELLED -> Value.CANCELLED
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
                IN_PROGRESS -> Known.IN_PROGRESS
                COMPLETED -> Known.COMPLETED
                CANCELLED -> Known.CANCELLED
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

        return /* spotless:off */ other is VectorStoreFileBatch && id == other.id && createdAt == other.createdAt && fileCounts == other.fileCounts && object_ == other.object_ && status == other.status && vectorStoreId == other.vectorStoreId && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, createdAt, fileCounts, object_, status, vectorStoreId, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "VectorStoreFileBatch{id=$id, createdAt=$createdAt, fileCounts=$fileCounts, object_=$object_, status=$status, vectorStoreId=$vectorStoreId, additionalProperties=$additionalProperties}"
}
