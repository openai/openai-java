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

@NoAutoDetect
class Batch
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("completion_window")
    @ExcludeMissing
    private val completionWindow: JsonField<String> = JsonMissing.of(),
    @JsonProperty("created_at")
    @ExcludeMissing
    private val createdAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("endpoint")
    @ExcludeMissing
    private val endpoint: JsonField<String> = JsonMissing.of(),
    @JsonProperty("input_file_id")
    @ExcludeMissing
    private val inputFileId: JsonField<String> = JsonMissing.of(),
    @JsonProperty("object")
    @ExcludeMissing
    private val object_: JsonField<Object> = JsonMissing.of(),
    @JsonProperty("status")
    @ExcludeMissing
    private val status: JsonField<Status> = JsonMissing.of(),
    @JsonProperty("cancelled_at")
    @ExcludeMissing
    private val cancelledAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("cancelling_at")
    @ExcludeMissing
    private val cancellingAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("completed_at")
    @ExcludeMissing
    private val completedAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("error_file_id")
    @ExcludeMissing
    private val errorFileId: JsonField<String> = JsonMissing.of(),
    @JsonProperty("errors")
    @ExcludeMissing
    private val errors: JsonField<Errors> = JsonMissing.of(),
    @JsonProperty("expired_at")
    @ExcludeMissing
    private val expiredAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("expires_at")
    @ExcludeMissing
    private val expiresAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("failed_at")
    @ExcludeMissing
    private val failedAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("finalizing_at")
    @ExcludeMissing
    private val finalizingAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("in_progress_at")
    @ExcludeMissing
    private val inProgressAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("metadata") @ExcludeMissing private val metadata: JsonValue = JsonMissing.of(),
    @JsonProperty("output_file_id")
    @ExcludeMissing
    private val outputFileId: JsonField<String> = JsonMissing.of(),
    @JsonProperty("request_counts")
    @ExcludeMissing
    private val requestCounts: JsonField<BatchRequestCounts> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    fun id(): String = id.getRequired("id")

    /** The time frame within which the batch should be processed. */
    fun completionWindow(): String = completionWindow.getRequired("completion_window")

    /** The Unix timestamp (in seconds) for when the batch was created. */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /** The OpenAI API endpoint used by the batch. */
    fun endpoint(): String = endpoint.getRequired("endpoint")

    /** The ID of the input file for the batch. */
    fun inputFileId(): String = inputFileId.getRequired("input_file_id")

    /** The object type, which is always `batch`. */
    fun object_(): Object = object_.getRequired("object")

    /** The current status of the batch. */
    fun status(): Status = status.getRequired("status")

    /** The Unix timestamp (in seconds) for when the batch was cancelled. */
    fun cancelledAt(): Optional<Long> = Optional.ofNullable(cancelledAt.getNullable("cancelled_at"))

    /** The Unix timestamp (in seconds) for when the batch started cancelling. */
    fun cancellingAt(): Optional<Long> =
        Optional.ofNullable(cancellingAt.getNullable("cancelling_at"))

    /** The Unix timestamp (in seconds) for when the batch was completed. */
    fun completedAt(): Optional<Long> = Optional.ofNullable(completedAt.getNullable("completed_at"))

    /** The ID of the file containing the outputs of requests with errors. */
    fun errorFileId(): Optional<String> =
        Optional.ofNullable(errorFileId.getNullable("error_file_id"))

    fun errors(): Optional<Errors> = Optional.ofNullable(errors.getNullable("errors"))

    /** The Unix timestamp (in seconds) for when the batch expired. */
    fun expiredAt(): Optional<Long> = Optional.ofNullable(expiredAt.getNullable("expired_at"))

    /** The Unix timestamp (in seconds) for when the batch will expire. */
    fun expiresAt(): Optional<Long> = Optional.ofNullable(expiresAt.getNullable("expires_at"))

    /** The Unix timestamp (in seconds) for when the batch failed. */
    fun failedAt(): Optional<Long> = Optional.ofNullable(failedAt.getNullable("failed_at"))

    /** The Unix timestamp (in seconds) for when the batch started finalizing. */
    fun finalizingAt(): Optional<Long> =
        Optional.ofNullable(finalizingAt.getNullable("finalizing_at"))

    /** The Unix timestamp (in seconds) for when the batch started processing. */
    fun inProgressAt(): Optional<Long> =
        Optional.ofNullable(inProgressAt.getNullable("in_progress_at"))

    /**
     * Set of 16 key-value pairs that can be attached to an object. This can be useful for storing
     * additional information about the object in a structured format. Keys can be a maximum of 64
     * characters long and values can be a maximum of 512 characters long.
     */
    @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonValue = metadata

    /** The ID of the file containing the outputs of successfully executed requests. */
    fun outputFileId(): Optional<String> =
        Optional.ofNullable(outputFileId.getNullable("output_file_id"))

    /** The request counts for different statuses within the batch. */
    fun requestCounts(): Optional<BatchRequestCounts> =
        Optional.ofNullable(requestCounts.getNullable("request_counts"))

    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /** The time frame within which the batch should be processed. */
    @JsonProperty("completion_window")
    @ExcludeMissing
    fun _completionWindow(): JsonField<String> = completionWindow

    /** The Unix timestamp (in seconds) for when the batch was created. */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt(): JsonField<Long> = createdAt

    /** The OpenAI API endpoint used by the batch. */
    @JsonProperty("endpoint") @ExcludeMissing fun _endpoint(): JsonField<String> = endpoint

    /** The ID of the input file for the batch. */
    @JsonProperty("input_file_id")
    @ExcludeMissing
    fun _inputFileId(): JsonField<String> = inputFileId

    /** The object type, which is always `batch`. */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonField<Object> = object_

    /** The current status of the batch. */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

    /** The Unix timestamp (in seconds) for when the batch was cancelled. */
    @JsonProperty("cancelled_at") @ExcludeMissing fun _cancelledAt(): JsonField<Long> = cancelledAt

    /** The Unix timestamp (in seconds) for when the batch started cancelling. */
    @JsonProperty("cancelling_at")
    @ExcludeMissing
    fun _cancellingAt(): JsonField<Long> = cancellingAt

    /** The Unix timestamp (in seconds) for when the batch was completed. */
    @JsonProperty("completed_at") @ExcludeMissing fun _completedAt(): JsonField<Long> = completedAt

    /** The ID of the file containing the outputs of requests with errors. */
    @JsonProperty("error_file_id")
    @ExcludeMissing
    fun _errorFileId(): JsonField<String> = errorFileId

    @JsonProperty("errors") @ExcludeMissing fun _errors(): JsonField<Errors> = errors

    /** The Unix timestamp (in seconds) for when the batch expired. */
    @JsonProperty("expired_at") @ExcludeMissing fun _expiredAt(): JsonField<Long> = expiredAt

    /** The Unix timestamp (in seconds) for when the batch will expire. */
    @JsonProperty("expires_at") @ExcludeMissing fun _expiresAt(): JsonField<Long> = expiresAt

    /** The Unix timestamp (in seconds) for when the batch failed. */
    @JsonProperty("failed_at") @ExcludeMissing fun _failedAt(): JsonField<Long> = failedAt

    /** The Unix timestamp (in seconds) for when the batch started finalizing. */
    @JsonProperty("finalizing_at")
    @ExcludeMissing
    fun _finalizingAt(): JsonField<Long> = finalizingAt

    /** The Unix timestamp (in seconds) for when the batch started processing. */
    @JsonProperty("in_progress_at")
    @ExcludeMissing
    fun _inProgressAt(): JsonField<Long> = inProgressAt

    /** The ID of the file containing the outputs of successfully executed requests. */
    @JsonProperty("output_file_id")
    @ExcludeMissing
    fun _outputFileId(): JsonField<String> = outputFileId

    /** The request counts for different statuses within the batch. */
    @JsonProperty("request_counts")
    @ExcludeMissing
    fun _requestCounts(): JsonField<BatchRequestCounts> = requestCounts

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): Batch = apply {
        if (validated) {
            return@apply
        }

        id()
        completionWindow()
        createdAt()
        endpoint()
        inputFileId()
        object_()
        status()
        cancelledAt()
        cancellingAt()
        completedAt()
        errorFileId()
        errors().ifPresent { it.validate() }
        expiredAt()
        expiresAt()
        failedAt()
        finalizingAt()
        inProgressAt()
        outputFileId()
        requestCounts().ifPresent { it.validate() }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String>? = null
        private var completionWindow: JsonField<String>? = null
        private var createdAt: JsonField<Long>? = null
        private var endpoint: JsonField<String>? = null
        private var inputFileId: JsonField<String>? = null
        private var object_: JsonField<Object>? = null
        private var status: JsonField<Status>? = null
        private var cancelledAt: JsonField<Long> = JsonMissing.of()
        private var cancellingAt: JsonField<Long> = JsonMissing.of()
        private var completedAt: JsonField<Long> = JsonMissing.of()
        private var errorFileId: JsonField<String> = JsonMissing.of()
        private var errors: JsonField<Errors> = JsonMissing.of()
        private var expiredAt: JsonField<Long> = JsonMissing.of()
        private var expiresAt: JsonField<Long> = JsonMissing.of()
        private var failedAt: JsonField<Long> = JsonMissing.of()
        private var finalizingAt: JsonField<Long> = JsonMissing.of()
        private var inProgressAt: JsonField<Long> = JsonMissing.of()
        private var metadata: JsonValue = JsonMissing.of()
        private var outputFileId: JsonField<String> = JsonMissing.of()
        private var requestCounts: JsonField<BatchRequestCounts> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(batch: Batch) = apply {
            id = batch.id
            completionWindow = batch.completionWindow
            createdAt = batch.createdAt
            endpoint = batch.endpoint
            inputFileId = batch.inputFileId
            object_ = batch.object_
            status = batch.status
            cancelledAt = batch.cancelledAt
            cancellingAt = batch.cancellingAt
            completedAt = batch.completedAt
            errorFileId = batch.errorFileId
            errors = batch.errors
            expiredAt = batch.expiredAt
            expiresAt = batch.expiresAt
            failedAt = batch.failedAt
            finalizingAt = batch.finalizingAt
            inProgressAt = batch.inProgressAt
            metadata = batch.metadata
            outputFileId = batch.outputFileId
            requestCounts = batch.requestCounts
            additionalProperties = batch.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The time frame within which the batch should be processed. */
        fun completionWindow(completionWindow: String) =
            completionWindow(JsonField.of(completionWindow))

        /** The time frame within which the batch should be processed. */
        fun completionWindow(completionWindow: JsonField<String>) = apply {
            this.completionWindow = completionWindow
        }

        /** The Unix timestamp (in seconds) for when the batch was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /** The Unix timestamp (in seconds) for when the batch was created. */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /** The OpenAI API endpoint used by the batch. */
        fun endpoint(endpoint: String) = endpoint(JsonField.of(endpoint))

        /** The OpenAI API endpoint used by the batch. */
        fun endpoint(endpoint: JsonField<String>) = apply { this.endpoint = endpoint }

        /** The ID of the input file for the batch. */
        fun inputFileId(inputFileId: String) = inputFileId(JsonField.of(inputFileId))

        /** The ID of the input file for the batch. */
        fun inputFileId(inputFileId: JsonField<String>) = apply { this.inputFileId = inputFileId }

        /** The object type, which is always `batch`. */
        fun object_(object_: Object) = object_(JsonField.of(object_))

        /** The object type, which is always `batch`. */
        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

        /** The current status of the batch. */
        fun status(status: Status) = status(JsonField.of(status))

        /** The current status of the batch. */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /** The Unix timestamp (in seconds) for when the batch was cancelled. */
        fun cancelledAt(cancelledAt: Long) = cancelledAt(JsonField.of(cancelledAt))

        /** The Unix timestamp (in seconds) for when the batch was cancelled. */
        fun cancelledAt(cancelledAt: JsonField<Long>) = apply { this.cancelledAt = cancelledAt }

        /** The Unix timestamp (in seconds) for when the batch started cancelling. */
        fun cancellingAt(cancellingAt: Long) = cancellingAt(JsonField.of(cancellingAt))

        /** The Unix timestamp (in seconds) for when the batch started cancelling. */
        fun cancellingAt(cancellingAt: JsonField<Long>) = apply { this.cancellingAt = cancellingAt }

        /** The Unix timestamp (in seconds) for when the batch was completed. */
        fun completedAt(completedAt: Long) = completedAt(JsonField.of(completedAt))

        /** The Unix timestamp (in seconds) for when the batch was completed. */
        fun completedAt(completedAt: JsonField<Long>) = apply { this.completedAt = completedAt }

        /** The ID of the file containing the outputs of requests with errors. */
        fun errorFileId(errorFileId: String) = errorFileId(JsonField.of(errorFileId))

        /** The ID of the file containing the outputs of requests with errors. */
        fun errorFileId(errorFileId: JsonField<String>) = apply { this.errorFileId = errorFileId }

        fun errors(errors: Errors) = errors(JsonField.of(errors))

        fun errors(errors: JsonField<Errors>) = apply { this.errors = errors }

        /** The Unix timestamp (in seconds) for when the batch expired. */
        fun expiredAt(expiredAt: Long) = expiredAt(JsonField.of(expiredAt))

        /** The Unix timestamp (in seconds) for when the batch expired. */
        fun expiredAt(expiredAt: JsonField<Long>) = apply { this.expiredAt = expiredAt }

        /** The Unix timestamp (in seconds) for when the batch will expire. */
        fun expiresAt(expiresAt: Long) = expiresAt(JsonField.of(expiresAt))

        /** The Unix timestamp (in seconds) for when the batch will expire. */
        fun expiresAt(expiresAt: JsonField<Long>) = apply { this.expiresAt = expiresAt }

        /** The Unix timestamp (in seconds) for when the batch failed. */
        fun failedAt(failedAt: Long) = failedAt(JsonField.of(failedAt))

        /** The Unix timestamp (in seconds) for when the batch failed. */
        fun failedAt(failedAt: JsonField<Long>) = apply { this.failedAt = failedAt }

        /** The Unix timestamp (in seconds) for when the batch started finalizing. */
        fun finalizingAt(finalizingAt: Long) = finalizingAt(JsonField.of(finalizingAt))

        /** The Unix timestamp (in seconds) for when the batch started finalizing. */
        fun finalizingAt(finalizingAt: JsonField<Long>) = apply { this.finalizingAt = finalizingAt }

        /** The Unix timestamp (in seconds) for when the batch started processing. */
        fun inProgressAt(inProgressAt: Long) = inProgressAt(JsonField.of(inProgressAt))

        /** The Unix timestamp (in seconds) for when the batch started processing. */
        fun inProgressAt(inProgressAt: JsonField<Long>) = apply { this.inProgressAt = inProgressAt }

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format. Keys can be a
         * maximum of 64 characters long and values can be a maximum of 512 characters long.
         */
        fun metadata(metadata: JsonValue) = apply { this.metadata = metadata }

        /** The ID of the file containing the outputs of successfully executed requests. */
        fun outputFileId(outputFileId: String) = outputFileId(JsonField.of(outputFileId))

        /** The ID of the file containing the outputs of successfully executed requests. */
        fun outputFileId(outputFileId: JsonField<String>) = apply {
            this.outputFileId = outputFileId
        }

        /** The request counts for different statuses within the batch. */
        fun requestCounts(requestCounts: BatchRequestCounts) =
            requestCounts(JsonField.of(requestCounts))

        /** The request counts for different statuses within the batch. */
        fun requestCounts(requestCounts: JsonField<BatchRequestCounts>) = apply {
            this.requestCounts = requestCounts
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

        fun build(): Batch =
            Batch(
                checkRequired("id", id),
                checkRequired("completionWindow", completionWindow),
                checkRequired("createdAt", createdAt),
                checkRequired("endpoint", endpoint),
                checkRequired("inputFileId", inputFileId),
                checkRequired("object_", object_),
                checkRequired("status", status),
                cancelledAt,
                cancellingAt,
                completedAt,
                errorFileId,
                errors,
                expiredAt,
                expiresAt,
                failedAt,
                finalizingAt,
                inProgressAt,
                metadata,
                outputFileId,
                requestCounts,
                additionalProperties.toImmutable(),
            )
    }

    /** The object type, which is always `batch`. */
    class Object
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val BATCH = of("batch")

            @JvmStatic fun of(value: String) = Object(JsonField.of(value))
        }

        enum class Known {
            BATCH,
        }

        enum class Value {
            BATCH,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                BATCH -> Value.BATCH
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                BATCH -> Known.BATCH
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

    /** The current status of the batch. */
    class Status
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val VALIDATING = of("validating")

            @JvmField val FAILED = of("failed")

            @JvmField val IN_PROGRESS = of("in_progress")

            @JvmField val FINALIZING = of("finalizing")

            @JvmField val COMPLETED = of("completed")

            @JvmField val EXPIRED = of("expired")

            @JvmField val CANCELLING = of("cancelling")

            @JvmField val CANCELLED = of("cancelled")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        enum class Known {
            VALIDATING,
            FAILED,
            IN_PROGRESS,
            FINALIZING,
            COMPLETED,
            EXPIRED,
            CANCELLING,
            CANCELLED,
        }

        enum class Value {
            VALIDATING,
            FAILED,
            IN_PROGRESS,
            FINALIZING,
            COMPLETED,
            EXPIRED,
            CANCELLING,
            CANCELLED,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                VALIDATING -> Value.VALIDATING
                FAILED -> Value.FAILED
                IN_PROGRESS -> Value.IN_PROGRESS
                FINALIZING -> Value.FINALIZING
                COMPLETED -> Value.COMPLETED
                EXPIRED -> Value.EXPIRED
                CANCELLING -> Value.CANCELLING
                CANCELLED -> Value.CANCELLED
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                VALIDATING -> Known.VALIDATING
                FAILED -> Known.FAILED
                IN_PROGRESS -> Known.IN_PROGRESS
                FINALIZING -> Known.FINALIZING
                COMPLETED -> Known.COMPLETED
                EXPIRED -> Known.EXPIRED
                CANCELLING -> Known.CANCELLING
                CANCELLED -> Known.CANCELLED
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

    @NoAutoDetect
    class Errors
    @JsonCreator
    private constructor(
        @JsonProperty("data")
        @ExcludeMissing
        private val data: JsonField<List<BatchError>> = JsonMissing.of(),
        @JsonProperty("object")
        @ExcludeMissing
        private val object_: JsonField<String> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun data(): Optional<List<BatchError>> = Optional.ofNullable(data.getNullable("data"))

        /** The object type, which is always `list`. */
        fun object_(): Optional<String> = Optional.ofNullable(object_.getNullable("object"))

        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<List<BatchError>> = data

        /** The object type, which is always `list`. */
        @JsonProperty("object") @ExcludeMissing fun _object_(): JsonField<String> = object_

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Errors = apply {
            if (validated) {
                return@apply
            }

            data().ifPresent { it.forEach { it.validate() } }
            object_()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var data: JsonField<MutableList<BatchError>>? = null
            private var object_: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(errors: Errors) = apply {
                data = errors.data.map { it.toMutableList() }
                object_ = errors.object_
                additionalProperties = errors.additionalProperties.toMutableMap()
            }

            fun data(data: List<BatchError>) = data(JsonField.of(data))

            fun data(data: JsonField<List<BatchError>>) = apply {
                this.data = data.map { it.toMutableList() }
            }

            fun addData(data: BatchError) = apply {
                this.data =
                    (this.data ?: JsonField.of(mutableListOf())).apply {
                        asKnown()
                            .orElseThrow {
                                IllegalStateException(
                                    "Field was set to non-list type: ${javaClass.simpleName}"
                                )
                            }
                            .add(data)
                    }
            }

            /** The object type, which is always `list`. */
            fun object_(object_: String) = object_(JsonField.of(object_))

            /** The object type, which is always `list`. */
            fun object_(object_: JsonField<String>) = apply { this.object_ = object_ }

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

            fun build(): Errors =
                Errors(
                    (data ?: JsonMissing.of()).map { it.toImmutable() },
                    object_,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Errors && data == other.data && object_ == other.object_ && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(data, object_, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Errors{data=$data, object_=$object_, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is Batch && id == other.id && completionWindow == other.completionWindow && createdAt == other.createdAt && endpoint == other.endpoint && inputFileId == other.inputFileId && object_ == other.object_ && status == other.status && cancelledAt == other.cancelledAt && cancellingAt == other.cancellingAt && completedAt == other.completedAt && errorFileId == other.errorFileId && errors == other.errors && expiredAt == other.expiredAt && expiresAt == other.expiresAt && failedAt == other.failedAt && finalizingAt == other.finalizingAt && inProgressAt == other.inProgressAt && metadata == other.metadata && outputFileId == other.outputFileId && requestCounts == other.requestCounts && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, completionWindow, createdAt, endpoint, inputFileId, object_, status, cancelledAt, cancellingAt, completedAt, errorFileId, errors, expiredAt, expiresAt, failedAt, finalizingAt, inProgressAt, metadata, outputFileId, requestCounts, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Batch{id=$id, completionWindow=$completionWindow, createdAt=$createdAt, endpoint=$endpoint, inputFileId=$inputFileId, object_=$object_, status=$status, cancelledAt=$cancelledAt, cancellingAt=$cancellingAt, completedAt=$completedAt, errorFileId=$errorFileId, errors=$errors, expiredAt=$expiredAt, expiresAt=$expiresAt, failedAt=$failedAt, finalizingAt=$finalizingAt, inProgressAt=$inProgressAt, metadata=$metadata, outputFileId=$outputFileId, requestCounts=$requestCounts, additionalProperties=$additionalProperties}"
}
