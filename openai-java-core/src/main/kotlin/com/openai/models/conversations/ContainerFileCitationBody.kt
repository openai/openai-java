// File generated from our OpenAPI spec by Stainless.

package com.openai.models.conversations

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects

class ContainerFileCitationBody
private constructor(
    private val containerId: JsonField<String>,
    private val endIndex: JsonField<Long>,
    private val fileId: JsonField<String>,
    private val filename: JsonField<String>,
    private val startIndex: JsonField<Long>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("container_id")
        @ExcludeMissing
        containerId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("end_index") @ExcludeMissing endIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("file_id") @ExcludeMissing fileId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("filename") @ExcludeMissing filename: JsonField<String> = JsonMissing.of(),
        @JsonProperty("start_index") @ExcludeMissing startIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(containerId, endIndex, fileId, filename, startIndex, type, mutableMapOf())

    /**
     * The ID of the container file.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun containerId(): String = containerId.getRequired("container_id")

    /**
     * The index of the last character of the container file citation in the message.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun endIndex(): Long = endIndex.getRequired("end_index")

    /**
     * The ID of the file.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun fileId(): String = fileId.getRequired("file_id")

    /**
     * The filename of the container file cited.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun filename(): String = filename.getRequired("filename")

    /**
     * The index of the first character of the container file citation in the message.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun startIndex(): Long = startIndex.getRequired("start_index")

    /**
     * The type of the container file citation. Always `container_file_citation`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("container_file_citation")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [containerId].
     *
     * Unlike [containerId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("container_id")
    @ExcludeMissing
    fun _containerId(): JsonField<String> = containerId

    /**
     * Returns the raw JSON value of [endIndex].
     *
     * Unlike [endIndex], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("end_index") @ExcludeMissing fun _endIndex(): JsonField<Long> = endIndex

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

    /**
     * Returns the raw JSON value of [startIndex].
     *
     * Unlike [startIndex], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("start_index") @ExcludeMissing fun _startIndex(): JsonField<Long> = startIndex

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

        /**
         * Returns a mutable builder for constructing an instance of [ContainerFileCitationBody].
         *
         * The following fields are required:
         * ```java
         * .containerId()
         * .endIndex()
         * .fileId()
         * .filename()
         * .startIndex()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ContainerFileCitationBody]. */
    class Builder internal constructor() {

        private var containerId: JsonField<String>? = null
        private var endIndex: JsonField<Long>? = null
        private var fileId: JsonField<String>? = null
        private var filename: JsonField<String>? = null
        private var startIndex: JsonField<Long>? = null
        private var type: JsonValue = JsonValue.from("container_file_citation")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(containerFileCitationBody: ContainerFileCitationBody) = apply {
            containerId = containerFileCitationBody.containerId
            endIndex = containerFileCitationBody.endIndex
            fileId = containerFileCitationBody.fileId
            filename = containerFileCitationBody.filename
            startIndex = containerFileCitationBody.startIndex
            type = containerFileCitationBody.type
            additionalProperties = containerFileCitationBody.additionalProperties.toMutableMap()
        }

        /** The ID of the container file. */
        fun containerId(containerId: String) = containerId(JsonField.of(containerId))

        /**
         * Sets [Builder.containerId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.containerId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun containerId(containerId: JsonField<String>) = apply { this.containerId = containerId }

        /** The index of the last character of the container file citation in the message. */
        fun endIndex(endIndex: Long) = endIndex(JsonField.of(endIndex))

        /**
         * Sets [Builder.endIndex] to an arbitrary JSON value.
         *
         * You should usually call [Builder.endIndex] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun endIndex(endIndex: JsonField<Long>) = apply { this.endIndex = endIndex }

        /** The ID of the file. */
        fun fileId(fileId: String) = fileId(JsonField.of(fileId))

        /**
         * Sets [Builder.fileId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fileId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

        /** The filename of the container file cited. */
        fun filename(filename: String) = filename(JsonField.of(filename))

        /**
         * Sets [Builder.filename] to an arbitrary JSON value.
         *
         * You should usually call [Builder.filename] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun filename(filename: JsonField<String>) = apply { this.filename = filename }

        /** The index of the first character of the container file citation in the message. */
        fun startIndex(startIndex: Long) = startIndex(JsonField.of(startIndex))

        /**
         * Sets [Builder.startIndex] to an arbitrary JSON value.
         *
         * You should usually call [Builder.startIndex] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun startIndex(startIndex: JsonField<Long>) = apply { this.startIndex = startIndex }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("container_file_citation")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

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
         * Returns an immutable instance of [ContainerFileCitationBody].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .containerId()
         * .endIndex()
         * .fileId()
         * .filename()
         * .startIndex()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ContainerFileCitationBody =
            ContainerFileCitationBody(
                checkRequired("containerId", containerId),
                checkRequired("endIndex", endIndex),
                checkRequired("fileId", fileId),
                checkRequired("filename", filename),
                checkRequired("startIndex", startIndex),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ContainerFileCitationBody = apply {
        if (validated) {
            return@apply
        }

        containerId()
        endIndex()
        fileId()
        filename()
        startIndex()
        _type().let {
            if (it != JsonValue.from("container_file_citation")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
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
        (if (containerId.asKnown().isPresent) 1 else 0) +
            (if (endIndex.asKnown().isPresent) 1 else 0) +
            (if (fileId.asKnown().isPresent) 1 else 0) +
            (if (filename.asKnown().isPresent) 1 else 0) +
            (if (startIndex.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("container_file_citation")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ContainerFileCitationBody &&
            containerId == other.containerId &&
            endIndex == other.endIndex &&
            fileId == other.fileId &&
            filename == other.filename &&
            startIndex == other.startIndex &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            containerId,
            endIndex,
            fileId,
            filename,
            startIndex,
            type,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ContainerFileCitationBody{containerId=$containerId, endIndex=$endIndex, fileId=$fileId, filename=$filename, startIndex=$startIndex, type=$type, additionalProperties=$additionalProperties}"
}
