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

/** The `File` object represents a document that has been uploaded to OpenAI. */
@JsonDeserialize(builder = FileObject.Builder::class)
@NoAutoDetect
class FileObject
private constructor(
    private val id: JsonField<String>,
    private val bytes: JsonField<Long>,
    private val createdAt: JsonField<Long>,
    private val filename: JsonField<String>,
    private val object_: JsonField<Object>,
    private val purpose: JsonField<Purpose>,
    private val status: JsonField<Status>,
    private val statusDetails: JsonField<String>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    /** The file identifier, which can be referenced in the API endpoints. */
    fun id(): String = id.getRequired("id")

    /** The size of the file, in bytes. */
    fun bytes(): Long = bytes.getRequired("bytes")

    /** The Unix timestamp (in seconds) for when the file was created. */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /** The name of the file. */
    fun filename(): String = filename.getRequired("filename")

    /** The object type, which is always `file`. */
    fun object_(): Object = object_.getRequired("object")

    /**
     * The intended purpose of the file. Supported values are `assistants`, `assistants_output`,
     * `batch`, `batch_output`, `fine-tune`, `fine-tune-results` and `vision`.
     */
    fun purpose(): Purpose = purpose.getRequired("purpose")

    /**
     * Deprecated. The current status of the file, which can be either `uploaded`, `processed`, or
     * `error`.
     */
    fun status(): Status = status.getRequired("status")

    /**
     * Deprecated. For details on why a fine-tuning training file failed validation, see the `error`
     * field on `fine_tuning.job`.
     */
    fun statusDetails(): Optional<String> =
        Optional.ofNullable(statusDetails.getNullable("status_details"))

    /** The file identifier, which can be referenced in the API endpoints. */
    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** The size of the file, in bytes. */
    @JsonProperty("bytes") @ExcludeMissing fun _bytes() = bytes

    /** The Unix timestamp (in seconds) for when the file was created. */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt() = createdAt

    /** The name of the file. */
    @JsonProperty("filename") @ExcludeMissing fun _filename() = filename

    /** The object type, which is always `file`. */
    @JsonProperty("object") @ExcludeMissing fun _object_() = object_

    /**
     * The intended purpose of the file. Supported values are `assistants`, `assistants_output`,
     * `batch`, `batch_output`, `fine-tune`, `fine-tune-results` and `vision`.
     */
    @JsonProperty("purpose") @ExcludeMissing fun _purpose() = purpose

    /**
     * Deprecated. The current status of the file, which can be either `uploaded`, `processed`, or
     * `error`.
     */
    @JsonProperty("status") @ExcludeMissing fun _status() = status

    /**
     * Deprecated. For details on why a fine-tuning training file failed validation, see the `error`
     * field on `fine_tuning.job`.
     */
    @JsonProperty("status_details") @ExcludeMissing fun _statusDetails() = statusDetails

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): FileObject = apply {
        if (!validated) {
            id()
            bytes()
            createdAt()
            filename()
            object_()
            purpose()
            status()
            statusDetails()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var bytes: JsonField<Long> = JsonMissing.of()
        private var createdAt: JsonField<Long> = JsonMissing.of()
        private var filename: JsonField<String> = JsonMissing.of()
        private var object_: JsonField<Object> = JsonMissing.of()
        private var purpose: JsonField<Purpose> = JsonMissing.of()
        private var status: JsonField<Status> = JsonMissing.of()
        private var statusDetails: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(fileObject: FileObject) = apply {
            this.id = fileObject.id
            this.bytes = fileObject.bytes
            this.createdAt = fileObject.createdAt
            this.filename = fileObject.filename
            this.object_ = fileObject.object_
            this.purpose = fileObject.purpose
            this.status = fileObject.status
            this.statusDetails = fileObject.statusDetails
            additionalProperties(fileObject.additionalProperties)
        }

        /** The file identifier, which can be referenced in the API endpoints. */
        fun id(id: String) = id(JsonField.of(id))

        /** The file identifier, which can be referenced in the API endpoints. */
        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The size of the file, in bytes. */
        fun bytes(bytes: Long) = bytes(JsonField.of(bytes))

        /** The size of the file, in bytes. */
        @JsonProperty("bytes")
        @ExcludeMissing
        fun bytes(bytes: JsonField<Long>) = apply { this.bytes = bytes }

        /** The Unix timestamp (in seconds) for when the file was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /** The Unix timestamp (in seconds) for when the file was created. */
        @JsonProperty("created_at")
        @ExcludeMissing
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /** The name of the file. */
        fun filename(filename: String) = filename(JsonField.of(filename))

        /** The name of the file. */
        @JsonProperty("filename")
        @ExcludeMissing
        fun filename(filename: JsonField<String>) = apply { this.filename = filename }

        /** The object type, which is always `file`. */
        fun object_(object_: Object) = object_(JsonField.of(object_))

        /** The object type, which is always `file`. */
        @JsonProperty("object")
        @ExcludeMissing
        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

        /**
         * The intended purpose of the file. Supported values are `assistants`, `assistants_output`,
         * `batch`, `batch_output`, `fine-tune`, `fine-tune-results` and `vision`.
         */
        fun purpose(purpose: Purpose) = purpose(JsonField.of(purpose))

        /**
         * The intended purpose of the file. Supported values are `assistants`, `assistants_output`,
         * `batch`, `batch_output`, `fine-tune`, `fine-tune-results` and `vision`.
         */
        @JsonProperty("purpose")
        @ExcludeMissing
        fun purpose(purpose: JsonField<Purpose>) = apply { this.purpose = purpose }

        /**
         * Deprecated. The current status of the file, which can be either `uploaded`, `processed`,
         * or `error`.
         */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * Deprecated. The current status of the file, which can be either `uploaded`, `processed`,
         * or `error`.
         */
        @JsonProperty("status")
        @ExcludeMissing
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /**
         * Deprecated. For details on why a fine-tuning training file failed validation, see the
         * `error` field on `fine_tuning.job`.
         */
        fun statusDetails(statusDetails: String) = statusDetails(JsonField.of(statusDetails))

        /**
         * Deprecated. For details on why a fine-tuning training file failed validation, see the
         * `error` field on `fine_tuning.job`.
         */
        @JsonProperty("status_details")
        @ExcludeMissing
        fun statusDetails(statusDetails: JsonField<String>) = apply {
            this.statusDetails = statusDetails
        }

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

        fun build(): FileObject =
            FileObject(
                id,
                bytes,
                createdAt,
                filename,
                object_,
                purpose,
                status,
                statusDetails,
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

            @JvmField val FILE = of("file")

            @JvmStatic fun of(value: String) = Object(JsonField.of(value))
        }

        enum class Known {
            FILE,
        }

        enum class Value {
            FILE,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                FILE -> Value.FILE
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                FILE -> Known.FILE
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

    class Purpose
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val ASSISTANTS = of("assistants")

            @JvmField val ASSISTANTS_OUTPUT = of("assistants_output")

            @JvmField val BATCH = of("batch")

            @JvmField val BATCH_OUTPUT = of("batch_output")

            @JvmField val FINE_TUNE = of("fine-tune")

            @JvmField val FINE_TUNE_RESULTS = of("fine-tune-results")

            @JvmField val VISION = of("vision")

            @JvmStatic fun of(value: String) = Purpose(JsonField.of(value))
        }

        enum class Known {
            ASSISTANTS,
            ASSISTANTS_OUTPUT,
            BATCH,
            BATCH_OUTPUT,
            FINE_TUNE,
            FINE_TUNE_RESULTS,
            VISION,
        }

        enum class Value {
            ASSISTANTS,
            ASSISTANTS_OUTPUT,
            BATCH,
            BATCH_OUTPUT,
            FINE_TUNE,
            FINE_TUNE_RESULTS,
            VISION,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                ASSISTANTS -> Value.ASSISTANTS
                ASSISTANTS_OUTPUT -> Value.ASSISTANTS_OUTPUT
                BATCH -> Value.BATCH
                BATCH_OUTPUT -> Value.BATCH_OUTPUT
                FINE_TUNE -> Value.FINE_TUNE
                FINE_TUNE_RESULTS -> Value.FINE_TUNE_RESULTS
                VISION -> Value.VISION
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                ASSISTANTS -> Known.ASSISTANTS
                ASSISTANTS_OUTPUT -> Known.ASSISTANTS_OUTPUT
                BATCH -> Known.BATCH
                BATCH_OUTPUT -> Known.BATCH_OUTPUT
                FINE_TUNE -> Known.FINE_TUNE
                FINE_TUNE_RESULTS -> Known.FINE_TUNE_RESULTS
                VISION -> Known.VISION
                else -> throw OpenAIInvalidDataException("Unknown Purpose: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Purpose && value == other.value /* spotless:on */
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

            @JvmField val UPLOADED = of("uploaded")

            @JvmField val PROCESSED = of("processed")

            @JvmField val ERROR = of("error")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        enum class Known {
            UPLOADED,
            PROCESSED,
            ERROR,
        }

        enum class Value {
            UPLOADED,
            PROCESSED,
            ERROR,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                UPLOADED -> Value.UPLOADED
                PROCESSED -> Value.PROCESSED
                ERROR -> Value.ERROR
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                UPLOADED -> Known.UPLOADED
                PROCESSED -> Known.PROCESSED
                ERROR -> Known.ERROR
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

        return /* spotless:off */ other is FileObject && id == other.id && bytes == other.bytes && createdAt == other.createdAt && filename == other.filename && object_ == other.object_ && purpose == other.purpose && status == other.status && statusDetails == other.statusDetails && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, bytes, createdAt, filename, object_, purpose, status, statusDetails, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FileObject{id=$id, bytes=$bytes, createdAt=$createdAt, filename=$filename, object_=$object_, purpose=$purpose, status=$status, statusDetails=$statusDetails, additionalProperties=$additionalProperties}"
}
