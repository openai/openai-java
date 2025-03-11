// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
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

/** A file input to the model. */
@NoAutoDetect
class ResponseInputFile
@JsonCreator
private constructor(
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonProperty("file_data")
    @ExcludeMissing
    private val fileData: JsonField<String> = JsonMissing.of(),
    @JsonProperty("file_id")
    @ExcludeMissing
    private val fileId: JsonField<String> = JsonMissing.of(),
    @JsonProperty("filename")
    @ExcludeMissing
    private val filename: JsonField<String> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The type of the input item. Always `input_file`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /** The content of the file to be sent to the model. */
    fun fileData(): Optional<String> = Optional.ofNullable(fileData.getNullable("file_data"))

    /** The ID of the file to be sent to the model. */
    fun fileId(): Optional<String> = Optional.ofNullable(fileId.getNullable("file_id"))

    /** The name of the file to be sent to the model. */
    fun filename(): Optional<String> = Optional.ofNullable(filename.getNullable("filename"))

    /** The content of the file to be sent to the model. */
    @JsonProperty("file_data") @ExcludeMissing fun _fileData(): JsonField<String> = fileData

    /** The ID of the file to be sent to the model. */
    @JsonProperty("file_id") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

    /** The name of the file to be sent to the model. */
    @JsonProperty("filename") @ExcludeMissing fun _filename(): JsonField<String> = filename

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ResponseInputFile = apply {
        if (validated) {
            return@apply
        }

        _type().let {
            if (it != JsonValue.from("input_file")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        fileData()
        fileId()
        filename()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /** Returns a mutable builder for constructing an instance of [ResponseInputFile]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseInputFile]. */
    class Builder internal constructor() {

        private var type: JsonValue = JsonValue.from("input_file")
        private var fileData: JsonField<String> = JsonMissing.of()
        private var fileId: JsonField<String> = JsonMissing.of()
        private var filename: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseInputFile: ResponseInputFile) = apply {
            type = responseInputFile.type
            fileData = responseInputFile.fileData
            fileId = responseInputFile.fileId
            filename = responseInputFile.filename
            additionalProperties = responseInputFile.additionalProperties.toMutableMap()
        }

        /** The type of the input item. Always `input_file`. */
        fun type(type: JsonValue) = apply { this.type = type }

        /** The content of the file to be sent to the model. */
        fun fileData(fileData: String) = fileData(JsonField.of(fileData))

        /** The content of the file to be sent to the model. */
        fun fileData(fileData: JsonField<String>) = apply { this.fileData = fileData }

        /** The ID of the file to be sent to the model. */
        fun fileId(fileId: String) = fileId(JsonField.of(fileId))

        /** The ID of the file to be sent to the model. */
        fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

        /** The name of the file to be sent to the model. */
        fun filename(filename: String) = filename(JsonField.of(filename))

        /** The name of the file to be sent to the model. */
        fun filename(filename: JsonField<String>) = apply { this.filename = filename }

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

        fun build(): ResponseInputFile =
            ResponseInputFile(type, fileData, fileId, filename, additionalProperties.toImmutable())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ResponseInputFile && type == other.type && fileData == other.fileData && fileId == other.fileId && filename == other.filename && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(type, fileData, fileId, filename, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseInputFile{type=$type, fileData=$fileData, fileId=$fileId, filename=$filename, additionalProperties=$additionalProperties}"
}
