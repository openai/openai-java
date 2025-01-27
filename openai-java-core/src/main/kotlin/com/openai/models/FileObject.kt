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

/** The `File` object represents a document that has been uploaded to OpenAI. */
@NoAutoDetect
class FileObject
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("bytes") @ExcludeMissing private val bytes: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("created_at")
    @ExcludeMissing
    private val createdAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("filename")
    @ExcludeMissing
    private val filename: JsonField<String> = JsonMissing.of(),
    @JsonProperty("object") @ExcludeMissing private val object_: JsonValue = JsonMissing.of(),
    @JsonProperty("purpose")
    @ExcludeMissing
    private val purpose: JsonField<Purpose> = JsonMissing.of(),
    @JsonProperty("status")
    @ExcludeMissing
    private val status: JsonField<Status> = JsonMissing.of(),
    @JsonProperty("status_details")
    @ExcludeMissing
    private val statusDetails: JsonField<String> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The file identifier, which can be referenced in the API endpoints. */
    fun id(): String = id.getRequired("id")

    /** The size of the file, in bytes. */
    fun bytes(): Long = bytes.getRequired("bytes")

    /** The Unix timestamp (in seconds) for when the file was created. */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /** The name of the file. */
    fun filename(): String = filename.getRequired("filename")

    /** The object type, which is always `file`. */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * The intended purpose of the file. Supported values are `assistants`, `assistants_output`,
     * `batch`, `batch_output`, `fine-tune`, `fine-tune-results` and `vision`.
     */
    fun purpose(): Purpose = purpose.getRequired("purpose")

    /**
     * Deprecated. The current status of the file, which can be either `uploaded`, `processed`, or
     * `error`.
     */
    @Deprecated("deprecated") fun status(): Status = status.getRequired("status")

    /**
     * Deprecated. For details on why a fine-tuning training file failed validation, see the `error`
     * field on `fine_tuning.job`.
     */
    @Deprecated("deprecated")
    fun statusDetails(): Optional<String> =
        Optional.ofNullable(statusDetails.getNullable("status_details"))

    /** The file identifier, which can be referenced in the API endpoints. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /** The size of the file, in bytes. */
    @JsonProperty("bytes") @ExcludeMissing fun _bytes(): JsonField<Long> = bytes

    /** The Unix timestamp (in seconds) for when the file was created. */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt(): JsonField<Long> = createdAt

    /** The name of the file. */
    @JsonProperty("filename") @ExcludeMissing fun _filename(): JsonField<String> = filename

    /**
     * The intended purpose of the file. Supported values are `assistants`, `assistants_output`,
     * `batch`, `batch_output`, `fine-tune`, `fine-tune-results` and `vision`.
     */
    @JsonProperty("purpose") @ExcludeMissing fun _purpose(): JsonField<Purpose> = purpose

    /**
     * Deprecated. The current status of the file, which can be either `uploaded`, `processed`, or
     * `error`.
     */
    @Deprecated("deprecated")
    @JsonProperty("status")
    @ExcludeMissing
    fun _status(): JsonField<Status> = status

    /**
     * Deprecated. For details on why a fine-tuning training file failed validation, see the `error`
     * field on `fine_tuning.job`.
     */
    @Deprecated("deprecated")
    @JsonProperty("status_details")
    @ExcludeMissing
    fun _statusDetails(): JsonField<String> = statusDetails

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): FileObject = apply {
        if (validated) {
            return@apply
        }

        id()
        bytes()
        createdAt()
        filename()
        _object_().let {
            if (it != JsonValue.from("file")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        purpose()
        status()
        statusDetails()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FileObject]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var bytes: JsonField<Long>? = null
        private var createdAt: JsonField<Long>? = null
        private var filename: JsonField<String>? = null
        private var object_: JsonValue = JsonValue.from("file")
        private var purpose: JsonField<Purpose>? = null
        private var status: JsonField<Status>? = null
        private var statusDetails: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(fileObject: FileObject) = apply {
            id = fileObject.id
            bytes = fileObject.bytes
            createdAt = fileObject.createdAt
            filename = fileObject.filename
            object_ = fileObject.object_
            purpose = fileObject.purpose
            status = fileObject.status
            statusDetails = fileObject.statusDetails
            additionalProperties = fileObject.additionalProperties.toMutableMap()
        }

        /** The file identifier, which can be referenced in the API endpoints. */
        fun id(id: String) = id(JsonField.of(id))

        /** The file identifier, which can be referenced in the API endpoints. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The size of the file, in bytes. */
        fun bytes(bytes: Long) = bytes(JsonField.of(bytes))

        /** The size of the file, in bytes. */
        fun bytes(bytes: JsonField<Long>) = apply { this.bytes = bytes }

        /** The Unix timestamp (in seconds) for when the file was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /** The Unix timestamp (in seconds) for when the file was created. */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /** The name of the file. */
        fun filename(filename: String) = filename(JsonField.of(filename))

        /** The name of the file. */
        fun filename(filename: JsonField<String>) = apply { this.filename = filename }

        /** The object type, which is always `file`. */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /**
         * The intended purpose of the file. Supported values are `assistants`, `assistants_output`,
         * `batch`, `batch_output`, `fine-tune`, `fine-tune-results` and `vision`.
         */
        fun purpose(purpose: Purpose) = purpose(JsonField.of(purpose))

        /**
         * The intended purpose of the file. Supported values are `assistants`, `assistants_output`,
         * `batch`, `batch_output`, `fine-tune`, `fine-tune-results` and `vision`.
         */
        fun purpose(purpose: JsonField<Purpose>) = apply { this.purpose = purpose }

        /**
         * Deprecated. The current status of the file, which can be either `uploaded`, `processed`,
         * or `error`.
         */
        @Deprecated("deprecated") fun status(status: Status) = status(JsonField.of(status))

        /**
         * Deprecated. The current status of the file, which can be either `uploaded`, `processed`,
         * or `error`.
         */
        @Deprecated("deprecated")
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /**
         * Deprecated. For details on why a fine-tuning training file failed validation, see the
         * `error` field on `fine_tuning.job`.
         */
        @Deprecated("deprecated")
        fun statusDetails(statusDetails: String) = statusDetails(JsonField.of(statusDetails))

        /**
         * Deprecated. For details on why a fine-tuning training file failed validation, see the
         * `error` field on `fine_tuning.job`.
         */
        @Deprecated("deprecated")
        fun statusDetails(statusDetails: JsonField<String>) = apply {
            this.statusDetails = statusDetails
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

        fun build(): FileObject =
            FileObject(
                checkRequired("id", id),
                checkRequired("bytes", bytes),
                checkRequired("createdAt", createdAt),
                checkRequired("filename", filename),
                object_,
                checkRequired("purpose", purpose),
                checkRequired("status", status),
                statusDetails,
                additionalProperties.toImmutable(),
            )
    }

    /**
     * The intended purpose of the file. Supported values are `assistants`, `assistants_output`,
     * `batch`, `batch_output`, `fine-tune`, `fine-tune-results` and `vision`.
     */
    class Purpose
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

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

            @JvmField val ASSISTANTS = of("assistants")

            @JvmField val ASSISTANTS_OUTPUT = of("assistants_output")

            @JvmField val BATCH = of("batch")

            @JvmField val BATCH_OUTPUT = of("batch_output")

            @JvmField val FINE_TUNE = of("fine-tune")

            @JvmField val FINE_TUNE_RESULTS = of("fine-tune-results")

            @JvmField val VISION = of("vision")

            @JvmStatic fun of(value: String) = Purpose(JsonField.of(value))
        }

        /** An enum containing [Purpose]'s known values. */
        enum class Known {
            ASSISTANTS,
            ASSISTANTS_OUTPUT,
            BATCH,
            BATCH_OUTPUT,
            FINE_TUNE,
            FINE_TUNE_RESULTS,
            VISION,
        }

        /**
         * An enum containing [Purpose]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Purpose] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            ASSISTANTS,
            ASSISTANTS_OUTPUT,
            BATCH,
            BATCH_OUTPUT,
            FINE_TUNE,
            FINE_TUNE_RESULTS,
            VISION,
            /** An enum member indicating that [Purpose] was instantiated with an unknown value. */
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
                ASSISTANTS -> Value.ASSISTANTS
                ASSISTANTS_OUTPUT -> Value.ASSISTANTS_OUTPUT
                BATCH -> Value.BATCH
                BATCH_OUTPUT -> Value.BATCH_OUTPUT
                FINE_TUNE -> Value.FINE_TUNE
                FINE_TUNE_RESULTS -> Value.FINE_TUNE_RESULTS
                VISION -> Value.VISION
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

    /**
     * Deprecated. The current status of the file, which can be either `uploaded`, `processed`, or
     * `error`.
     */
    @Deprecated("deprecated")
    class Status
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

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

            @JvmField val UPLOADED = of("uploaded")

            @JvmField val PROCESSED = of("processed")

            @JvmField val ERROR = of("error")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            UPLOADED,
            PROCESSED,
            ERROR,
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
            UPLOADED,
            PROCESSED,
            ERROR,
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
                UPLOADED -> Value.UPLOADED
                PROCESSED -> Value.PROCESSED
                ERROR -> Value.ERROR
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
