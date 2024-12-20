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

/** The Upload object can accept byte chunks in the form of Parts. */
@NoAutoDetect
class Upload
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("created_at")
    @ExcludeMissing
    private val createdAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("filename")
    @ExcludeMissing
    private val filename: JsonField<String> = JsonMissing.of(),
    @JsonProperty("bytes") @ExcludeMissing private val bytes: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("purpose")
    @ExcludeMissing
    private val purpose: JsonField<String> = JsonMissing.of(),
    @JsonProperty("status")
    @ExcludeMissing
    private val status: JsonField<Status> = JsonMissing.of(),
    @JsonProperty("expires_at")
    @ExcludeMissing
    private val expiresAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("object")
    @ExcludeMissing
    private val object_: JsonField<Object> = JsonMissing.of(),
    @JsonProperty("file")
    @ExcludeMissing
    private val file: JsonField<FileObject> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The Upload unique identifier, which can be referenced in API endpoints. */
    fun id(): String = id.getRequired("id")

    /** The Unix timestamp (in seconds) for when the Upload was created. */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /** The name of the file to be uploaded. */
    fun filename(): String = filename.getRequired("filename")

    /** The intended number of bytes to be uploaded. */
    fun bytes(): Long = bytes.getRequired("bytes")

    /**
     * The intended purpose of the file.
     * [Please refer here](https://platform.openai.com/docs/api-reference/files/object#files/object-purpose)
     * for acceptable values.
     */
    fun purpose(): String = purpose.getRequired("purpose")

    /** The status of the Upload. */
    fun status(): Status = status.getRequired("status")

    /** The Unix timestamp (in seconds) for when the Upload was created. */
    fun expiresAt(): Long = expiresAt.getRequired("expires_at")

    /** The object type, which is always "upload". */
    fun object_(): Object = object_.getRequired("object")

    /** The ready File object after the Upload is completed. */
    fun file(): Optional<FileObject> = Optional.ofNullable(file.getNullable("file"))

    /** The Upload unique identifier, which can be referenced in API endpoints. */
    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** The Unix timestamp (in seconds) for when the Upload was created. */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt() = createdAt

    /** The name of the file to be uploaded. */
    @JsonProperty("filename") @ExcludeMissing fun _filename() = filename

    /** The intended number of bytes to be uploaded. */
    @JsonProperty("bytes") @ExcludeMissing fun _bytes() = bytes

    /**
     * The intended purpose of the file.
     * [Please refer here](https://platform.openai.com/docs/api-reference/files/object#files/object-purpose)
     * for acceptable values.
     */
    @JsonProperty("purpose") @ExcludeMissing fun _purpose() = purpose

    /** The status of the Upload. */
    @JsonProperty("status") @ExcludeMissing fun _status() = status

    /** The Unix timestamp (in seconds) for when the Upload was created. */
    @JsonProperty("expires_at") @ExcludeMissing fun _expiresAt() = expiresAt

    /** The object type, which is always "upload". */
    @JsonProperty("object") @ExcludeMissing fun _object_() = object_

    /** The ready File object after the Upload is completed. */
    @JsonProperty("file") @ExcludeMissing fun _file() = file

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): Upload = apply {
        if (!validated) {
            id()
            createdAt()
            filename()
            bytes()
            purpose()
            status()
            expiresAt()
            object_()
            file().map { it.validate() }
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var createdAt: JsonField<Long> = JsonMissing.of()
        private var filename: JsonField<String> = JsonMissing.of()
        private var bytes: JsonField<Long> = JsonMissing.of()
        private var purpose: JsonField<String> = JsonMissing.of()
        private var status: JsonField<Status> = JsonMissing.of()
        private var expiresAt: JsonField<Long> = JsonMissing.of()
        private var object_: JsonField<Object> = JsonMissing.of()
        private var file: JsonField<FileObject> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(upload: Upload) = apply {
            id = upload.id
            createdAt = upload.createdAt
            filename = upload.filename
            bytes = upload.bytes
            purpose = upload.purpose
            status = upload.status
            expiresAt = upload.expiresAt
            object_ = upload.object_
            file = upload.file
            additionalProperties = upload.additionalProperties.toMutableMap()
        }

        /** The Upload unique identifier, which can be referenced in API endpoints. */
        fun id(id: String) = id(JsonField.of(id))

        /** The Upload unique identifier, which can be referenced in API endpoints. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The Unix timestamp (in seconds) for when the Upload was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /** The Unix timestamp (in seconds) for when the Upload was created. */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /** The name of the file to be uploaded. */
        fun filename(filename: String) = filename(JsonField.of(filename))

        /** The name of the file to be uploaded. */
        fun filename(filename: JsonField<String>) = apply { this.filename = filename }

        /** The intended number of bytes to be uploaded. */
        fun bytes(bytes: Long) = bytes(JsonField.of(bytes))

        /** The intended number of bytes to be uploaded. */
        fun bytes(bytes: JsonField<Long>) = apply { this.bytes = bytes }

        /**
         * The intended purpose of the file.
         * [Please refer here](https://platform.openai.com/docs/api-reference/files/object#files/object-purpose)
         * for acceptable values.
         */
        fun purpose(purpose: String) = purpose(JsonField.of(purpose))

        /**
         * The intended purpose of the file.
         * [Please refer here](https://platform.openai.com/docs/api-reference/files/object#files/object-purpose)
         * for acceptable values.
         */
        fun purpose(purpose: JsonField<String>) = apply { this.purpose = purpose }

        /** The status of the Upload. */
        fun status(status: Status) = status(JsonField.of(status))

        /** The status of the Upload. */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /** The Unix timestamp (in seconds) for when the Upload was created. */
        fun expiresAt(expiresAt: Long) = expiresAt(JsonField.of(expiresAt))

        /** The Unix timestamp (in seconds) for when the Upload was created. */
        fun expiresAt(expiresAt: JsonField<Long>) = apply { this.expiresAt = expiresAt }

        /** The object type, which is always "upload". */
        fun object_(object_: Object) = object_(JsonField.of(object_))

        /** The object type, which is always "upload". */
        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

        /** The ready File object after the Upload is completed. */
        fun file(file: FileObject) = file(JsonField.of(file))

        /** The ready File object after the Upload is completed. */
        fun file(file: JsonField<FileObject>) = apply { this.file = file }

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

        fun build(): Upload =
            Upload(
                id,
                createdAt,
                filename,
                bytes,
                purpose,
                status,
                expiresAt,
                object_,
                file,
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

            @JvmField val UPLOAD = of("upload")

            @JvmStatic fun of(value: String) = Object(JsonField.of(value))
        }

        enum class Known {
            UPLOAD,
        }

        enum class Value {
            UPLOAD,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                UPLOAD -> Value.UPLOAD
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                UPLOAD -> Known.UPLOAD
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

            @JvmField val PENDING = of("pending")

            @JvmField val COMPLETED = of("completed")

            @JvmField val CANCELLED = of("cancelled")

            @JvmField val EXPIRED = of("expired")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        enum class Known {
            PENDING,
            COMPLETED,
            CANCELLED,
            EXPIRED,
        }

        enum class Value {
            PENDING,
            COMPLETED,
            CANCELLED,
            EXPIRED,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                PENDING -> Value.PENDING
                COMPLETED -> Value.COMPLETED
                CANCELLED -> Value.CANCELLED
                EXPIRED -> Value.EXPIRED
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                PENDING -> Known.PENDING
                COMPLETED -> Known.COMPLETED
                CANCELLED -> Known.CANCELLED
                EXPIRED -> Known.EXPIRED
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

        return /* spotless:off */ other is Upload && id == other.id && createdAt == other.createdAt && filename == other.filename && bytes == other.bytes && purpose == other.purpose && status == other.status && expiresAt == other.expiresAt && object_ == other.object_ && file == other.file && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, createdAt, filename, bytes, purpose, status, expiresAt, object_, file, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Upload{id=$id, createdAt=$createdAt, filename=$filename, bytes=$bytes, purpose=$purpose, status=$status, expiresAt=$expiresAt, object_=$object_, file=$file, additionalProperties=$additionalProperties}"
}
