// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

@JsonDeserialize(builder = Batch.Builder::class)
@NoAutoDetect
class Batch
private constructor(
    private val id: JsonField<String>,
    private val object_: JsonField<Object>,
    private val endpoint: JsonField<String>,
    private val errors: JsonField<Errors>,
    private val inputFileId: JsonField<String>,
    private val completionWindow: JsonField<String>,
    private val status: JsonField<Status>,
    private val outputFileId: JsonField<String>,
    private val errorFileId: JsonField<String>,
    private val createdAt: JsonField<Long>,
    private val inProgressAt: JsonField<Long>,
    private val expiresAt: JsonField<Long>,
    private val finalizingAt: JsonField<Long>,
    private val completedAt: JsonField<Long>,
    private val failedAt: JsonField<Long>,
    private val expiredAt: JsonField<Long>,
    private val cancellingAt: JsonField<Long>,
    private val cancelledAt: JsonField<Long>,
    private val requestCounts: JsonField<BatchRequestCounts>,
    private val metadata: JsonValue,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    fun id(): String = id.getRequired("id")

    /** The object type, which is always `batch`. */
    fun object_(): Object = object_.getRequired("object")

    /** The OpenAI API endpoint used by the batch. */
    fun endpoint(): String = endpoint.getRequired("endpoint")

    fun errors(): Optional<Errors> = Optional.ofNullable(errors.getNullable("errors"))

    /** The ID of the input file for the batch. */
    fun inputFileId(): String = inputFileId.getRequired("input_file_id")

    /** The time frame within which the batch should be processed. */
    fun completionWindow(): String = completionWindow.getRequired("completion_window")

    /** The current status of the batch. */
    fun status(): Status = status.getRequired("status")

    /** The ID of the file containing the outputs of successfully executed requests. */
    fun outputFileId(): Optional<String> =
        Optional.ofNullable(outputFileId.getNullable("output_file_id"))

    /** The ID of the file containing the outputs of requests with errors. */
    fun errorFileId(): Optional<String> =
        Optional.ofNullable(errorFileId.getNullable("error_file_id"))

    /** The Unix timestamp (in seconds) for when the batch was created. */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /** The Unix timestamp (in seconds) for when the batch started processing. */
    fun inProgressAt(): Optional<Long> =
        Optional.ofNullable(inProgressAt.getNullable("in_progress_at"))

    /** The Unix timestamp (in seconds) for when the batch will expire. */
    fun expiresAt(): Optional<Long> = Optional.ofNullable(expiresAt.getNullable("expires_at"))

    /** The Unix timestamp (in seconds) for when the batch started finalizing. */
    fun finalizingAt(): Optional<Long> =
        Optional.ofNullable(finalizingAt.getNullable("finalizing_at"))

    /** The Unix timestamp (in seconds) for when the batch was completed. */
    fun completedAt(): Optional<Long> = Optional.ofNullable(completedAt.getNullable("completed_at"))

    /** The Unix timestamp (in seconds) for when the batch failed. */
    fun failedAt(): Optional<Long> = Optional.ofNullable(failedAt.getNullable("failed_at"))

    /** The Unix timestamp (in seconds) for when the batch expired. */
    fun expiredAt(): Optional<Long> = Optional.ofNullable(expiredAt.getNullable("expired_at"))

    /** The Unix timestamp (in seconds) for when the batch started cancelling. */
    fun cancellingAt(): Optional<Long> =
        Optional.ofNullable(cancellingAt.getNullable("cancelling_at"))

    /** The Unix timestamp (in seconds) for when the batch was cancelled. */
    fun cancelledAt(): Optional<Long> = Optional.ofNullable(cancelledAt.getNullable("cancelled_at"))

    /** The request counts for different statuses within the batch. */
    fun requestCounts(): Optional<BatchRequestCounts> =
        Optional.ofNullable(requestCounts.getNullable("request_counts"))

    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** The object type, which is always `batch`. */
    @JsonProperty("object") @ExcludeMissing fun _object_() = object_

    /** The OpenAI API endpoint used by the batch. */
    @JsonProperty("endpoint") @ExcludeMissing fun _endpoint() = endpoint

    @JsonProperty("errors") @ExcludeMissing fun _errors() = errors

    /** The ID of the input file for the batch. */
    @JsonProperty("input_file_id") @ExcludeMissing fun _inputFileId() = inputFileId

    /** The time frame within which the batch should be processed. */
    @JsonProperty("completion_window") @ExcludeMissing fun _completionWindow() = completionWindow

    /** The current status of the batch. */
    @JsonProperty("status") @ExcludeMissing fun _status() = status

    /** The ID of the file containing the outputs of successfully executed requests. */
    @JsonProperty("output_file_id") @ExcludeMissing fun _outputFileId() = outputFileId

    /** The ID of the file containing the outputs of requests with errors. */
    @JsonProperty("error_file_id") @ExcludeMissing fun _errorFileId() = errorFileId

    /** The Unix timestamp (in seconds) for when the batch was created. */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt() = createdAt

    /** The Unix timestamp (in seconds) for when the batch started processing. */
    @JsonProperty("in_progress_at") @ExcludeMissing fun _inProgressAt() = inProgressAt

    /** The Unix timestamp (in seconds) for when the batch will expire. */
    @JsonProperty("expires_at") @ExcludeMissing fun _expiresAt() = expiresAt

    /** The Unix timestamp (in seconds) for when the batch started finalizing. */
    @JsonProperty("finalizing_at") @ExcludeMissing fun _finalizingAt() = finalizingAt

    /** The Unix timestamp (in seconds) for when the batch was completed. */
    @JsonProperty("completed_at") @ExcludeMissing fun _completedAt() = completedAt

    /** The Unix timestamp (in seconds) for when the batch failed. */
    @JsonProperty("failed_at") @ExcludeMissing fun _failedAt() = failedAt

    /** The Unix timestamp (in seconds) for when the batch expired. */
    @JsonProperty("expired_at") @ExcludeMissing fun _expiredAt() = expiredAt

    /** The Unix timestamp (in seconds) for when the batch started cancelling. */
    @JsonProperty("cancelling_at") @ExcludeMissing fun _cancellingAt() = cancellingAt

    /** The Unix timestamp (in seconds) for when the batch was cancelled. */
    @JsonProperty("cancelled_at") @ExcludeMissing fun _cancelledAt() = cancelledAt

    /** The request counts for different statuses within the batch. */
    @JsonProperty("request_counts") @ExcludeMissing fun _requestCounts() = requestCounts

    /**
     * Set of 16 key-value pairs that can be attached to an object. This can be useful for storing
     * additional information about the object in a structured format. Keys can be a maximum of 64
     * characters long and values can be a maximum of 512 characters long.
     */
    @JsonProperty("metadata") @ExcludeMissing fun _metadata() = metadata

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): Batch = apply {
        if (!validated) {
            id()
            object_()
            endpoint()
            errors().map { it.validate() }
            inputFileId()
            completionWindow()
            status()
            outputFileId()
            errorFileId()
            createdAt()
            inProgressAt()
            expiresAt()
            finalizingAt()
            completedAt()
            failedAt()
            expiredAt()
            cancellingAt()
            cancelledAt()
            requestCounts().map { it.validate() }
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
        private var endpoint: JsonField<String> = JsonMissing.of()
        private var errors: JsonField<Errors> = JsonMissing.of()
        private var inputFileId: JsonField<String> = JsonMissing.of()
        private var completionWindow: JsonField<String> = JsonMissing.of()
        private var status: JsonField<Status> = JsonMissing.of()
        private var outputFileId: JsonField<String> = JsonMissing.of()
        private var errorFileId: JsonField<String> = JsonMissing.of()
        private var createdAt: JsonField<Long> = JsonMissing.of()
        private var inProgressAt: JsonField<Long> = JsonMissing.of()
        private var expiresAt: JsonField<Long> = JsonMissing.of()
        private var finalizingAt: JsonField<Long> = JsonMissing.of()
        private var completedAt: JsonField<Long> = JsonMissing.of()
        private var failedAt: JsonField<Long> = JsonMissing.of()
        private var expiredAt: JsonField<Long> = JsonMissing.of()
        private var cancellingAt: JsonField<Long> = JsonMissing.of()
        private var cancelledAt: JsonField<Long> = JsonMissing.of()
        private var requestCounts: JsonField<BatchRequestCounts> = JsonMissing.of()
        private var metadata: JsonValue = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(batch: Batch) = apply {
            this.id = batch.id
            this.object_ = batch.object_
            this.endpoint = batch.endpoint
            this.errors = batch.errors
            this.inputFileId = batch.inputFileId
            this.completionWindow = batch.completionWindow
            this.status = batch.status
            this.outputFileId = batch.outputFileId
            this.errorFileId = batch.errorFileId
            this.createdAt = batch.createdAt
            this.inProgressAt = batch.inProgressAt
            this.expiresAt = batch.expiresAt
            this.finalizingAt = batch.finalizingAt
            this.completedAt = batch.completedAt
            this.failedAt = batch.failedAt
            this.expiredAt = batch.expiredAt
            this.cancellingAt = batch.cancellingAt
            this.cancelledAt = batch.cancelledAt
            this.requestCounts = batch.requestCounts
            this.metadata = batch.metadata
            additionalProperties(batch.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The object type, which is always `batch`. */
        fun object_(object_: Object) = object_(JsonField.of(object_))

        /** The object type, which is always `batch`. */
        @JsonProperty("object")
        @ExcludeMissing
        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

        /** The OpenAI API endpoint used by the batch. */
        fun endpoint(endpoint: String) = endpoint(JsonField.of(endpoint))

        /** The OpenAI API endpoint used by the batch. */
        @JsonProperty("endpoint")
        @ExcludeMissing
        fun endpoint(endpoint: JsonField<String>) = apply { this.endpoint = endpoint }

        fun errors(errors: Errors) = errors(JsonField.of(errors))

        @JsonProperty("errors")
        @ExcludeMissing
        fun errors(errors: JsonField<Errors>) = apply { this.errors = errors }

        /** The ID of the input file for the batch. */
        fun inputFileId(inputFileId: String) = inputFileId(JsonField.of(inputFileId))

        /** The ID of the input file for the batch. */
        @JsonProperty("input_file_id")
        @ExcludeMissing
        fun inputFileId(inputFileId: JsonField<String>) = apply { this.inputFileId = inputFileId }

        /** The time frame within which the batch should be processed. */
        fun completionWindow(completionWindow: String) =
            completionWindow(JsonField.of(completionWindow))

        /** The time frame within which the batch should be processed. */
        @JsonProperty("completion_window")
        @ExcludeMissing
        fun completionWindow(completionWindow: JsonField<String>) = apply {
            this.completionWindow = completionWindow
        }

        /** The current status of the batch. */
        fun status(status: Status) = status(JsonField.of(status))

        /** The current status of the batch. */
        @JsonProperty("status")
        @ExcludeMissing
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /** The ID of the file containing the outputs of successfully executed requests. */
        fun outputFileId(outputFileId: String) = outputFileId(JsonField.of(outputFileId))

        /** The ID of the file containing the outputs of successfully executed requests. */
        @JsonProperty("output_file_id")
        @ExcludeMissing
        fun outputFileId(outputFileId: JsonField<String>) = apply {
            this.outputFileId = outputFileId
        }

        /** The ID of the file containing the outputs of requests with errors. */
        fun errorFileId(errorFileId: String) = errorFileId(JsonField.of(errorFileId))

        /** The ID of the file containing the outputs of requests with errors. */
        @JsonProperty("error_file_id")
        @ExcludeMissing
        fun errorFileId(errorFileId: JsonField<String>) = apply { this.errorFileId = errorFileId }

        /** The Unix timestamp (in seconds) for when the batch was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /** The Unix timestamp (in seconds) for when the batch was created. */
        @JsonProperty("created_at")
        @ExcludeMissing
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /** The Unix timestamp (in seconds) for when the batch started processing. */
        fun inProgressAt(inProgressAt: Long) = inProgressAt(JsonField.of(inProgressAt))

        /** The Unix timestamp (in seconds) for when the batch started processing. */
        @JsonProperty("in_progress_at")
        @ExcludeMissing
        fun inProgressAt(inProgressAt: JsonField<Long>) = apply { this.inProgressAt = inProgressAt }

        /** The Unix timestamp (in seconds) for when the batch will expire. */
        fun expiresAt(expiresAt: Long) = expiresAt(JsonField.of(expiresAt))

        /** The Unix timestamp (in seconds) for when the batch will expire. */
        @JsonProperty("expires_at")
        @ExcludeMissing
        fun expiresAt(expiresAt: JsonField<Long>) = apply { this.expiresAt = expiresAt }

        /** The Unix timestamp (in seconds) for when the batch started finalizing. */
        fun finalizingAt(finalizingAt: Long) = finalizingAt(JsonField.of(finalizingAt))

        /** The Unix timestamp (in seconds) for when the batch started finalizing. */
        @JsonProperty("finalizing_at")
        @ExcludeMissing
        fun finalizingAt(finalizingAt: JsonField<Long>) = apply { this.finalizingAt = finalizingAt }

        /** The Unix timestamp (in seconds) for when the batch was completed. */
        fun completedAt(completedAt: Long) = completedAt(JsonField.of(completedAt))

        /** The Unix timestamp (in seconds) for when the batch was completed. */
        @JsonProperty("completed_at")
        @ExcludeMissing
        fun completedAt(completedAt: JsonField<Long>) = apply { this.completedAt = completedAt }

        /** The Unix timestamp (in seconds) for when the batch failed. */
        fun failedAt(failedAt: Long) = failedAt(JsonField.of(failedAt))

        /** The Unix timestamp (in seconds) for when the batch failed. */
        @JsonProperty("failed_at")
        @ExcludeMissing
        fun failedAt(failedAt: JsonField<Long>) = apply { this.failedAt = failedAt }

        /** The Unix timestamp (in seconds) for when the batch expired. */
        fun expiredAt(expiredAt: Long) = expiredAt(JsonField.of(expiredAt))

        /** The Unix timestamp (in seconds) for when the batch expired. */
        @JsonProperty("expired_at")
        @ExcludeMissing
        fun expiredAt(expiredAt: JsonField<Long>) = apply { this.expiredAt = expiredAt }

        /** The Unix timestamp (in seconds) for when the batch started cancelling. */
        fun cancellingAt(cancellingAt: Long) = cancellingAt(JsonField.of(cancellingAt))

        /** The Unix timestamp (in seconds) for when the batch started cancelling. */
        @JsonProperty("cancelling_at")
        @ExcludeMissing
        fun cancellingAt(cancellingAt: JsonField<Long>) = apply { this.cancellingAt = cancellingAt }

        /** The Unix timestamp (in seconds) for when the batch was cancelled. */
        fun cancelledAt(cancelledAt: Long) = cancelledAt(JsonField.of(cancelledAt))

        /** The Unix timestamp (in seconds) for when the batch was cancelled. */
        @JsonProperty("cancelled_at")
        @ExcludeMissing
        fun cancelledAt(cancelledAt: JsonField<Long>) = apply { this.cancelledAt = cancelledAt }

        /** The request counts for different statuses within the batch. */
        fun requestCounts(requestCounts: BatchRequestCounts) =
            requestCounts(JsonField.of(requestCounts))

        /** The request counts for different statuses within the batch. */
        @JsonProperty("request_counts")
        @ExcludeMissing
        fun requestCounts(requestCounts: JsonField<BatchRequestCounts>) = apply {
            this.requestCounts = requestCounts
        }

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format. Keys can be a
         * maximum of 64 characters long and values can be a maximum of 512 characters long.
         */
        @JsonProperty("metadata")
        @ExcludeMissing
        fun metadata(metadata: JsonValue) = apply { this.metadata = metadata }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            this.additionalProperties.putAll(additionalProperties)
        }

        @JsonAnySetter
        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            this.additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun build(): Batch =
            Batch(
                id,
                object_,
                endpoint,
                errors,
                inputFileId,
                completionWindow,
                status,
                outputFileId,
                errorFileId,
                createdAt,
                inProgressAt,
                expiresAt,
                finalizingAt,
                completedAt,
                failedAt,
                expiredAt,
                cancellingAt,
                cancelledAt,
                requestCounts,
                metadata,
                additionalProperties.toImmutable(),
            )
    }

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

    @JsonDeserialize(builder = Errors.Builder::class)
    @NoAutoDetect
    class Errors
    private constructor(
        private val object_: JsonField<String>,
        private val data: JsonField<List<BatchError>>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        /** The object type, which is always `list`. */
        fun object_(): Optional<String> = Optional.ofNullable(object_.getNullable("object"))

        fun data(): Optional<List<BatchError>> = Optional.ofNullable(data.getNullable("data"))

        /** The object type, which is always `list`. */
        @JsonProperty("object") @ExcludeMissing fun _object_() = object_

        @JsonProperty("data") @ExcludeMissing fun _data() = data

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): Errors = apply {
            if (!validated) {
                object_()
                data().map { it.forEach { it.validate() } }
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var object_: JsonField<String> = JsonMissing.of()
            private var data: JsonField<List<BatchError>> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(errors: Errors) = apply {
                this.object_ = errors.object_
                this.data = errors.data
                additionalProperties(errors.additionalProperties)
            }

            /** The object type, which is always `list`. */
            fun object_(object_: String) = object_(JsonField.of(object_))

            /** The object type, which is always `list`. */
            @JsonProperty("object")
            @ExcludeMissing
            fun object_(object_: JsonField<String>) = apply { this.object_ = object_ }

            fun data(data: List<BatchError>) = data(JsonField.of(data))

            @JsonProperty("data")
            @ExcludeMissing
            fun data(data: JsonField<List<BatchError>>) = apply { this.data = data }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                this.additionalProperties.putAll(additionalProperties)
            }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun build(): Errors =
                Errors(
                    object_,
                    data.map { it.toImmutable() },
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Errors && object_ == other.object_ && data == other.data && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(object_, data, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Errors{object_=$object_, data=$data, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is Batch && id == other.id && object_ == other.object_ && endpoint == other.endpoint && errors == other.errors && inputFileId == other.inputFileId && completionWindow == other.completionWindow && status == other.status && outputFileId == other.outputFileId && errorFileId == other.errorFileId && createdAt == other.createdAt && inProgressAt == other.inProgressAt && expiresAt == other.expiresAt && finalizingAt == other.finalizingAt && completedAt == other.completedAt && failedAt == other.failedAt && expiredAt == other.expiredAt && cancellingAt == other.cancellingAt && cancelledAt == other.cancelledAt && requestCounts == other.requestCounts && metadata == other.metadata && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, object_, endpoint, errors, inputFileId, completionWindow, status, outputFileId, errorFileId, createdAt, inProgressAt, expiresAt, finalizingAt, completedAt, failedAt, expiredAt, cancellingAt, cancelledAt, requestCounts, metadata, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Batch{id=$id, object_=$object_, endpoint=$endpoint, errors=$errors, inputFileId=$inputFileId, completionWindow=$completionWindow, status=$status, outputFileId=$outputFileId, errorFileId=$errorFileId, createdAt=$createdAt, inProgressAt=$inProgressAt, expiresAt=$expiresAt, finalizingAt=$finalizingAt, completedAt=$completedAt, failedAt=$failedAt, expiredAt=$expiredAt, cancellingAt=$cancellingAt, cancelledAt=$cancelledAt, requestCounts=$requestCounts, metadata=$metadata, additionalProperties=$additionalProperties}"
}
