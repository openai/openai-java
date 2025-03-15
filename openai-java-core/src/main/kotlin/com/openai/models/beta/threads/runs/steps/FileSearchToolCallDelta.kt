// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
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

@NoAutoDetect
class FileSearchToolCallDelta
@JsonCreator
private constructor(
    @JsonProperty("file_search")
    @ExcludeMissing
    private val fileSearch: JsonValue = JsonMissing.of(),
    @JsonProperty("index") @ExcludeMissing private val index: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** For now, this is always going to be an empty object. */
    @JsonProperty("file_search") @ExcludeMissing fun _fileSearch(): JsonValue = fileSearch

    /**
     * The index of the tool call in the tool calls array.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun index(): Long = index.getRequired("index")

    /**
     * The type of tool call. This is always going to be `file_search` for this type of tool call.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("file_search")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * The ID of the tool call object.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun id(): Optional<String> = Optional.ofNullable(id.getNullable("id"))

    /**
     * Returns the raw JSON value of [index].
     *
     * Unlike [index], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("index") @ExcludeMissing fun _index(): JsonField<Long> = index

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): FileSearchToolCallDelta = apply {
        if (validated) {
            return@apply
        }

        index()
        _type().let {
            if (it != JsonValue.from("file_search")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        id()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [FileSearchToolCallDelta].
         *
         * The following fields are required:
         * ```java
         * .fileSearch()
         * .index()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FileSearchToolCallDelta]. */
    class Builder internal constructor() {

        private var fileSearch: JsonValue? = null
        private var index: JsonField<Long>? = null
        private var type: JsonValue = JsonValue.from("file_search")
        private var id: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(fileSearchToolCallDelta: FileSearchToolCallDelta) = apply {
            fileSearch = fileSearchToolCallDelta.fileSearch
            index = fileSearchToolCallDelta.index
            type = fileSearchToolCallDelta.type
            id = fileSearchToolCallDelta.id
            additionalProperties = fileSearchToolCallDelta.additionalProperties.toMutableMap()
        }

        /** For now, this is always going to be an empty object. */
        fun fileSearch(fileSearch: JsonValue) = apply { this.fileSearch = fileSearch }

        /** The index of the tool call in the tool calls array. */
        fun index(index: Long) = index(JsonField.of(index))

        /**
         * Sets [Builder.index] to an arbitrary JSON value.
         *
         * You should usually call [Builder.index] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun index(index: JsonField<Long>) = apply { this.index = index }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("file_search")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** The ID of the tool call object. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

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

        fun build(): FileSearchToolCallDelta =
            FileSearchToolCallDelta(
                checkRequired("fileSearch", fileSearch),
                checkRequired("index", index),
                type,
                id,
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FileSearchToolCallDelta && fileSearch == other.fileSearch && index == other.index && type == other.type && id == other.id && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(fileSearch, index, type, id, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FileSearchToolCallDelta{fileSearch=$fileSearch, index=$index, type=$type, id=$id, additionalProperties=$additionalProperties}"
}
