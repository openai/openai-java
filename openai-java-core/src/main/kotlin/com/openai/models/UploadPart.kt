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

/** The upload Part represents a chunk of bytes we can add to an Upload object. */
@JsonDeserialize(builder = UploadPart.Builder::class)
@NoAutoDetect
class UploadPart
private constructor(
    private val id: JsonField<String>,
    private val createdAt: JsonField<Long>,
    private val uploadId: JsonField<String>,
    private val object_: JsonField<Object>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    /** The upload Part unique identifier, which can be referenced in API endpoints. */
    fun id(): String = id.getRequired("id")

    /** The Unix timestamp (in seconds) for when the Part was created. */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /** The ID of the Upload object that this Part was added to. */
    fun uploadId(): String = uploadId.getRequired("upload_id")

    /** The object type, which is always `upload.part`. */
    fun object_(): Object = object_.getRequired("object")

    /** The upload Part unique identifier, which can be referenced in API endpoints. */
    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** The Unix timestamp (in seconds) for when the Part was created. */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt() = createdAt

    /** The ID of the Upload object that this Part was added to. */
    @JsonProperty("upload_id") @ExcludeMissing fun _uploadId() = uploadId

    /** The object type, which is always `upload.part`. */
    @JsonProperty("object") @ExcludeMissing fun _object_() = object_

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): UploadPart = apply {
        if (!validated) {
            id()
            createdAt()
            uploadId()
            object_()
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
        private var uploadId: JsonField<String> = JsonMissing.of()
        private var object_: JsonField<Object> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(uploadPart: UploadPart) = apply {
            this.id = uploadPart.id
            this.createdAt = uploadPart.createdAt
            this.uploadId = uploadPart.uploadId
            this.object_ = uploadPart.object_
            additionalProperties(uploadPart.additionalProperties)
        }

        /** The upload Part unique identifier, which can be referenced in API endpoints. */
        fun id(id: String) = id(JsonField.of(id))

        /** The upload Part unique identifier, which can be referenced in API endpoints. */
        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The Unix timestamp (in seconds) for when the Part was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /** The Unix timestamp (in seconds) for when the Part was created. */
        @JsonProperty("created_at")
        @ExcludeMissing
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /** The ID of the Upload object that this Part was added to. */
        fun uploadId(uploadId: String) = uploadId(JsonField.of(uploadId))

        /** The ID of the Upload object that this Part was added to. */
        @JsonProperty("upload_id")
        @ExcludeMissing
        fun uploadId(uploadId: JsonField<String>) = apply { this.uploadId = uploadId }

        /** The object type, which is always `upload.part`. */
        fun object_(object_: Object) = object_(JsonField.of(object_))

        /** The object type, which is always `upload.part`. */
        @JsonProperty("object")
        @ExcludeMissing
        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

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

        fun build(): UploadPart =
            UploadPart(
                id,
                createdAt,
                uploadId,
                object_,
                additionalProperties.toImmutable(),
            )
    }

    class Object
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Object && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val UPLOAD_PART = Object(JsonField.of("upload.part"))

            @JvmStatic fun of(value: String) = Object(JsonField.of(value))
        }

        enum class Known {
            UPLOAD_PART,
        }

        enum class Value {
            UPLOAD_PART,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                UPLOAD_PART -> Value.UPLOAD_PART
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                UPLOAD_PART -> Known.UPLOAD_PART
                else -> throw OpenAIInvalidDataException("Unknown Object: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is UploadPart && id == other.id && createdAt == other.createdAt && uploadId == other.uploadId && object_ == other.object_ && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, createdAt, uploadId, object_, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "UploadPart{id=$id, createdAt=$createdAt, uploadId=$uploadId, object_=$object_, additionalProperties=$additionalProperties}"
}
