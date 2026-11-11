// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.files

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
import com.openai.core.collectAllProperties
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** The `File` object represents a document that has been uploaded to OpenAI. */
class FileObject
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val bytes: JsonField<Long>,
    private val createdAt: JsonField<Long>,
    private val filename: JsonField<String>,
    private val object_: JsonValue,
    private val purpose: JsonField<Purpose>,
    private val status: JsonField<Status>,
    private val expiresAt: JsonField<Long>,
    private val statusDetails: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("bytes") @ExcludeMissing bytes: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("created_at") @ExcludeMissing createdAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("filename") @ExcludeMissing filename: JsonField<String> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("purpose") @ExcludeMissing purpose: JsonField<Purpose> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        @JsonProperty("expires_at") @ExcludeMissing expiresAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("status_details")
        @ExcludeMissing
        statusDetails: JsonField<String> = JsonMissing.of(),
    ) : this(
        id,
        bytes,
        createdAt,
        filename,
        object_,
        purpose,
        status,
        expiresAt,
        statusDetails,
        mutableMapOf(),
    )

    /**
     * The file identifier, which can be referenced in the API endpoints. The schema requires this
     * property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun id(): java.util.Optional<String> = id.getOptional("id")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun idOrThrow(): String = id.getRequired("id")

    /**
     * The size of the file, in bytes. The schema requires this property. Returns empty if the JSON
     * property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun bytes(): java.util.Optional<Long> = bytes.getOptional("bytes")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun bytesOrThrow(): Long = bytes.getRequired("bytes")

    /**
     * The Unix timestamp (in seconds) for when the file was created. The schema requires this
     * property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun createdAt(): java.util.Optional<Long> = createdAt.getOptional("created_at")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun createdAtOrThrow(): Long = createdAt.getRequired("created_at")

    /**
     * The name of the file. The schema requires this property. Returns empty if the JSON property
     * is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun filename(): java.util.Optional<String> = filename.getOptional("filename")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun filenameOrThrow(): String = filename.getRequired("filename")

    /**
     * The object type, which is always `file`. The schema requires this property. Returns empty if
     * the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun object_(): java.util.Optional<JsonValue> {
        val raw = object_
        return when {
            raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
            !(raw == JsonValue.from("file")) ->
                throw OpenAIInvalidDataException("`object` is invalid")
            else -> java.util.Optional.of(raw)
        }
    }

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun object_OrThrow(): JsonValue = object_().orElseGet { object_.getRequired("object") }

    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonField<JsonValue> = object_

    /**
     * The intended purpose of the file. Supported values are `assistants`, `assistants_output`,
     * `batch`, `batch_output`, `fine-tune`, `fine-tune-results`, `vision`, and `user_data`. The
     * schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun purpose(): java.util.Optional<Purpose> = purpose.getOptional("purpose")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun purposeOrThrow(): Purpose = purpose.getRequired("purpose")

    /**
     * Deprecated. The current status of the file, which can be either `uploaded`, `processed`, or
     * `error`. The schema requires this property. Returns empty if the JSON property is missing or
     * null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    @Deprecated("deprecated")
    fun status(): java.util.Optional<Status> = status.getOptional("status")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    @Deprecated("deprecated") fun statusOrThrow(): Status = status.getRequired("status")

    /**
     * The Unix timestamp (in seconds) for when the file will expire. Returns empty if the JSON
     * property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun expiresAt(): java.util.Optional<Long> = expiresAt.getOptional("expires_at")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun expiresAtOrThrow(): Long = expiresAt.getRequired("expires_at")

    /**
     * Deprecated. For details on why a fine-tuning training file failed validation, see the `error`
     * field on `fine_tuning.job`. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    @Deprecated("deprecated")
    fun statusDetails(): java.util.Optional<String> = statusDetails.getOptional("status_details")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    @Deprecated("deprecated")
    fun statusDetailsOrThrow(): String = statusDetails.getRequired("status_details")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [bytes].
     *
     * Unlike [bytes], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("bytes") @ExcludeMissing fun _bytes(): JsonField<Long> = bytes

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt(): JsonField<Long> = createdAt

    /**
     * Returns the raw JSON value of [filename].
     *
     * Unlike [filename], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("filename") @ExcludeMissing fun _filename(): JsonField<String> = filename

    /**
     * Returns the raw JSON value of [purpose].
     *
     * Unlike [purpose], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("purpose") @ExcludeMissing fun _purpose(): JsonField<Purpose> = purpose

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @Deprecated("deprecated")
    @JsonProperty("status")
    @ExcludeMissing
    fun _status(): JsonField<Status> = status

    /**
     * Returns the raw JSON value of [expiresAt].
     *
     * Unlike [expiresAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("expires_at") @ExcludeMissing fun _expiresAt(): JsonField<Long> = expiresAt

    /**
     * Returns the raw JSON value of [statusDetails].
     *
     * Unlike [statusDetails], this method doesn't throw if the JSON field has an unexpected type.
     */
    @Deprecated("deprecated")
    @JsonProperty("status_details")
    @ExcludeMissing
    fun _statusDetails(): JsonField<String> = statusDetails

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    /**
     * Returns an immutable snapshot of all present JSON properties, including declared and
     * additional properties.
     *
     * Keys use their JSON names. Declared properties take precedence over additional properties
     * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
     * values are preserved.
     */
    fun _allProperties(): Map<String, JsonValue> =
        collectAllProperties(
            additionalProperties,
            "id" to this.id,
            "bytes" to this.bytes,
            "created_at" to this.createdAt,
            "filename" to this.filename,
            "object" to this.object_,
            "purpose" to this.purpose,
            "status" to this.status,
            "expires_at" to this.expiresAt,
            "status_details" to this.statusDetails,
        )

    @JvmSynthetic
    internal fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    @JsonAnyGetter
    @ExcludeMissing
    private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [FileObject].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .bytes()
         * .createdAt()
         * .filename()
         * .purpose()
         * .status()
         * ```
         */
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
        private var expiresAt: JsonField<Long> = JsonMissing.of()
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
            expiresAt = fileObject.expiresAt
            statusDetails = fileObject.statusDetails
            additionalProperties = fileObject.additionalProperties.toMutableMap()
        }

        /** The file identifier, which can be referenced in the API endpoints. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The size of the file, in bytes. */
        fun bytes(bytes: Long) = bytes(JsonField.of(bytes))

        /**
         * Sets [Builder.bytes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.bytes] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun bytes(bytes: JsonField<Long>) = apply { this.bytes = bytes }

        /** The Unix timestamp (in seconds) for when the file was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /** The name of the file. */
        fun filename(filename: String) = filename(JsonField.of(filename))

        /**
         * Sets [Builder.filename] to an arbitrary JSON value.
         *
         * You should usually call [Builder.filename] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun filename(filename: JsonField<String>) = apply { this.filename = filename }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("file")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /**
         * The intended purpose of the file. Supported values are `assistants`, `assistants_output`,
         * `batch`, `batch_output`, `fine-tune`, `fine-tune-results`, `vision`, and `user_data`.
         */
        fun purpose(purpose: Purpose) = purpose(JsonField.of(purpose))

        /**
         * Sets [Builder.purpose] to an arbitrary JSON value.
         *
         * You should usually call [Builder.purpose] with a well-typed [Purpose] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun purpose(purpose: JsonField<Purpose>) = apply { this.purpose = purpose }

        /**
         * Deprecated. The current status of the file, which can be either `uploaded`, `processed`,
         * or `error`.
         */
        @Deprecated("deprecated") fun status(status: Status) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        @Deprecated("deprecated")
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /** The Unix timestamp (in seconds) for when the file will expire. */
        fun expiresAt(expiresAt: Long) = expiresAt(JsonField.of(expiresAt))

        /**
         * Sets [Builder.expiresAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.expiresAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun expiresAt(expiresAt: JsonField<Long>) = apply { this.expiresAt = expiresAt }

        /**
         * Deprecated. For details on why a fine-tuning training file failed validation, see the
         * `error` field on `fine_tuning.job`.
         */
        @Deprecated("deprecated")
        fun statusDetails(statusDetails: String) = statusDetails(JsonField.of(statusDetails))

        /**
         * Sets [Builder.statusDetails] to an arbitrary JSON value.
         *
         * You should usually call [Builder.statusDetails] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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

        /**
         * Returns an immutable instance of [FileObject].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .bytes()
         * .createdAt()
         * .filename()
         * .purpose()
         * .status()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FileObject =
            FileObject(
                checkRequired("id", id),
                checkRequired("bytes", bytes),
                checkRequired("createdAt", createdAt),
                checkRequired("filename", filename),
                object_,
                checkRequired("purpose", purpose),
                checkRequired("status", status),
                expiresAt,
                statusDetails,
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
    fun validate(): FileObject = apply {
        if (validated) {
            return@apply
        }

        idOrThrow()
        bytesOrThrow()
        createdAtOrThrow()
        filenameOrThrow()
        object_OrThrow()
        purposeOrThrow().validate()
        statusOrThrow().validate()
        expiresAt()
        statusDetails()
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
            (if (bytes.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (filename.asKnown().isPresent) 1 else 0) +
            object_.let { if (it == JsonValue.from("file")) 1 else 0 } +
            (purpose.asKnown().getOrNull()?.validity() ?: 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (if (expiresAt.asKnown().isPresent) 1 else 0) +
            (if (statusDetails.asKnown().isPresent) 1 else 0)

    /**
     * The intended purpose of the file. Supported values are `assistants`, `assistants_output`,
     * `batch`, `batch_output`, `fine-tune`, `fine-tune-results`, `vision`, and `user_data`.
     */
    class Purpose @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val USER_DATA = of("user_data")

            @JvmStatic fun of(value: String) = Purpose(JsonField.of(value))
        }

        /** An enum containing [Purpose]'s known values. */
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
        enum class Known {
            ASSISTANTS,
            ASSISTANTS_OUTPUT,
            BATCH,
            BATCH_OUTPUT,
            FINE_TUNE,
            FINE_TUNE_RESULTS,
            VISION,
            USER_DATA,
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
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
        enum class Value {
            ASSISTANTS,
            ASSISTANTS_OUTPUT,
            BATCH,
            BATCH_OUTPUT,
            FINE_TUNE,
            FINE_TUNE_RESULTS,
            VISION,
            USER_DATA,
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
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
        fun value(): Value =
            when (this) {
                ASSISTANTS -> Value.ASSISTANTS
                ASSISTANTS_OUTPUT -> Value.ASSISTANTS_OUTPUT
                BATCH -> Value.BATCH
                BATCH_OUTPUT -> Value.BATCH_OUTPUT
                FINE_TUNE -> Value.FINE_TUNE
                FINE_TUNE_RESULTS -> Value.FINE_TUNE_RESULTS
                VISION -> Value.VISION
                USER_DATA -> Value.USER_DATA
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
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
        fun known(): Known =
            when (this) {
                ASSISTANTS -> Known.ASSISTANTS
                ASSISTANTS_OUTPUT -> Known.ASSISTANTS_OUTPUT
                BATCH -> Known.BATCH
                BATCH_OUTPUT -> Known.BATCH_OUTPUT
                FINE_TUNE -> Known.FINE_TUNE
                FINE_TUNE_RESULTS -> Known.FINE_TUNE_RESULTS
                VISION -> Known.VISION
                USER_DATA -> Known.USER_DATA
                else -> throw OpenAIInvalidDataException("Unknown Purpose: $value")
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

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Purpose = apply {
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

            return other is Purpose && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * Deprecated. The current status of the file, which can be either `uploaded`, `processed`, or
     * `error`.
     */
    @Deprecated("deprecated")
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

            @JvmField val UPLOADED = of("uploaded")

            @JvmField val PROCESSED = of("processed")

            @JvmField val ERROR = of("error")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
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
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
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
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
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
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
        fun known(): Known =
            when (this) {
                UPLOADED -> Known.UPLOADED
                PROCESSED -> Known.PROCESSED
                ERROR -> Known.ERROR
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

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
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

        return other is FileObject &&
            id == other.id &&
            bytes == other.bytes &&
            createdAt == other.createdAt &&
            filename == other.filename &&
            object_ == other.object_ &&
            purpose == other.purpose &&
            status == other.status &&
            expiresAt == other.expiresAt &&
            statusDetails == other.statusDetails &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            bytes,
            createdAt,
            filename,
            object_,
            purpose,
            status,
            expiresAt,
            statusDetails,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FileObject{id=$id, bytes=$bytes, createdAt=$createdAt, filename=$filename, object_=$object_, purpose=$purpose, status=$status, expiresAt=$expiresAt, statusDetails=$statusDetails, additionalProperties=$additionalProperties}"
}
