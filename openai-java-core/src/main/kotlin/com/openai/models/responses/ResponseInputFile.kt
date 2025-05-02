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
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A file input to the model. */
class ResponseInputFile
private constructor(
    private val type: JsonValue,
    private val fileData: JsonField<String>,
    private val fileId: JsonField<String>,
    private val filename: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("file_data") @ExcludeMissing fileData: JsonField<String> = JsonMissing.of(),
        @JsonProperty("file_id") @ExcludeMissing fileId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("filename") @ExcludeMissing filename: JsonField<String> = JsonMissing.of(),
    ) : this(type, fileData, fileId, filename, mutableMapOf())

    /**
     * The type of the input item. Always `input_file`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("input_file")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * The content of the file to be sent to the model.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun fileData(): Optional<String> = fileData.getOptional("file_data")

    /**
     * The ID of the file to be sent to the model.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun fileId(): Optional<String> = fileId.getOptional("file_id")

    /**
     * The name of the file to be sent to the model.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun filename(): Optional<String> = filename.getOptional("filename")

    /**
     * Returns the raw JSON value of [fileData].
     *
     * Unlike [fileData], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("file_data") @ExcludeMissing fun _fileData(): JsonField<String> = fileData

    /**
     * Returns the raw JSON value of [fileId].
     *
     * Unlike [fileId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("file_id") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

    /**
     * Returns the raw JSON value of [filename].
     *
     * Unlike [filename], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("filename") @ExcludeMissing fun _filename(): JsonField<String> = filename

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

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

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("input_file")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** The content of the file to be sent to the model. */
        fun fileData(fileData: String) = fileData(JsonField.of(fileData))

        /**
         * Sets [Builder.fileData] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fileData] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun fileData(fileData: JsonField<String>) = apply { this.fileData = fileData }

        /** The ID of the file to be sent to the model. */
        fun fileId(fileId: String?) = fileId(JsonField.ofNullable(fileId))

        /** Alias for calling [Builder.fileId] with `fileId.orElse(null)`. */
        fun fileId(fileId: Optional<String>) = fileId(fileId.getOrNull())

        /**
         * Sets [Builder.fileId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fileId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

        /** The name of the file to be sent to the model. */
        fun filename(filename: String) = filename(JsonField.of(filename))

        /**
         * Sets [Builder.filename] to an arbitrary JSON value.
         *
         * You should usually call [Builder.filename] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
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

        /**
         * Returns an immutable instance of [ResponseInputFile].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ResponseInputFile =
            ResponseInputFile(type, fileData, fileId, filename, additionalProperties.toMutableMap())
    }

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
        type.let { if (it == JsonValue.from("input_file")) 1 else 0 } +
            (if (fileData.asKnown().isPresent) 1 else 0) +
            (if (fileId.asKnown().isPresent) 1 else 0) +
            (if (filename.asKnown().isPresent) 1 else 0)

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
