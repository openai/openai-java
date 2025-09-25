// File generated from our OpenAPI spec by Stainless.

package com.openai.models.containers.files

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

class FileCreateResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val bytes: JsonField<Long>,
    private val containerId: JsonField<String>,
    private val createdAt: JsonField<Long>,
    private val object_: JsonValue,
    private val path: JsonField<String>,
    private val source: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("bytes") @ExcludeMissing bytes: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("container_id")
        @ExcludeMissing
        containerId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("created_at") @ExcludeMissing createdAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("path") @ExcludeMissing path: JsonField<String> = JsonMissing.of(),
        @JsonProperty("source") @ExcludeMissing source: JsonField<String> = JsonMissing.of(),
    ) : this(id, bytes, containerId, createdAt, object_, path, source, mutableMapOf())

    /**
     * Unique identifier for the file.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * Size of the file in bytes.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun bytes(): Long = bytes.getRequired("bytes")

    /**
     * The container this file belongs to.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun containerId(): String = containerId.getRequired("container_id")

    /**
     * Unix timestamp (in seconds) when the file was created.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /**
     * The type of this object (`container.file`).
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("container.file")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * Path of the file in the container.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun path(): String = path.getRequired("path")

    /**
     * Source of the file (e.g., `user`, `assistant`).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun source(): String = source.getRequired("source")

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
     * Returns the raw JSON value of [containerId].
     *
     * Unlike [containerId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("container_id")
    @ExcludeMissing
    fun _containerId(): JsonField<String> = containerId

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt(): JsonField<Long> = createdAt

    /**
     * Returns the raw JSON value of [path].
     *
     * Unlike [path], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("path") @ExcludeMissing fun _path(): JsonField<String> = path

    /**
     * Returns the raw JSON value of [source].
     *
     * Unlike [source], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("source") @ExcludeMissing fun _source(): JsonField<String> = source

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
         * Returns a mutable builder for constructing an instance of [FileCreateResponse].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .bytes()
         * .containerId()
         * .createdAt()
         * .path()
         * .source()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FileCreateResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var bytes: JsonField<Long>? = null
        private var containerId: JsonField<String>? = null
        private var createdAt: JsonField<Long>? = null
        private var object_: JsonValue = JsonValue.from("container.file")
        private var path: JsonField<String>? = null
        private var source: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(fileCreateResponse: FileCreateResponse) = apply {
            id = fileCreateResponse.id
            bytes = fileCreateResponse.bytes
            containerId = fileCreateResponse.containerId
            createdAt = fileCreateResponse.createdAt
            object_ = fileCreateResponse.object_
            path = fileCreateResponse.path
            source = fileCreateResponse.source
            additionalProperties = fileCreateResponse.additionalProperties.toMutableMap()
        }

        /** Unique identifier for the file. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Size of the file in bytes. */
        fun bytes(bytes: Long) = bytes(JsonField.of(bytes))

        /**
         * Sets [Builder.bytes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.bytes] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun bytes(bytes: JsonField<Long>) = apply { this.bytes = bytes }

        /** The container this file belongs to. */
        fun containerId(containerId: String) = containerId(JsonField.of(containerId))

        /**
         * Sets [Builder.containerId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.containerId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun containerId(containerId: JsonField<String>) = apply { this.containerId = containerId }

        /** Unix timestamp (in seconds) when the file was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("container.file")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /** Path of the file in the container. */
        fun path(path: String) = path(JsonField.of(path))

        /**
         * Sets [Builder.path] to an arbitrary JSON value.
         *
         * You should usually call [Builder.path] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun path(path: JsonField<String>) = apply { this.path = path }

        /** Source of the file (e.g., `user`, `assistant`). */
        fun source(source: String) = source(JsonField.of(source))

        /**
         * Sets [Builder.source] to an arbitrary JSON value.
         *
         * You should usually call [Builder.source] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun source(source: JsonField<String>) = apply { this.source = source }

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
         * Returns an immutable instance of [FileCreateResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .bytes()
         * .containerId()
         * .createdAt()
         * .path()
         * .source()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FileCreateResponse =
            FileCreateResponse(
                checkRequired("id", id),
                checkRequired("bytes", bytes),
                checkRequired("containerId", containerId),
                checkRequired("createdAt", createdAt),
                object_,
                checkRequired("path", path),
                checkRequired("source", source),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): FileCreateResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        bytes()
        containerId()
        createdAt()
        _object_().let {
            if (it != JsonValue.from("container.file")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        path()
        source()
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
            (if (containerId.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            object_.let { if (it == JsonValue.from("container.file")) 1 else 0 } +
            (if (path.asKnown().isPresent) 1 else 0) +
            (if (source.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FileCreateResponse &&
            id == other.id &&
            bytes == other.bytes &&
            containerId == other.containerId &&
            createdAt == other.createdAt &&
            object_ == other.object_ &&
            path == other.path &&
            source == other.source &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, bytes, containerId, createdAt, object_, path, source, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FileCreateResponse{id=$id, bytes=$bytes, containerId=$containerId, createdAt=$createdAt, object_=$object_, path=$path, source=$source, additionalProperties=$additionalProperties}"
}
