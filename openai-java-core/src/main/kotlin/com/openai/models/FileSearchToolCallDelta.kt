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

@NoAutoDetect
class FileSearchToolCallDelta
@JsonCreator
private constructor(
    @JsonProperty("index") @ExcludeMissing private val index: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
    @JsonProperty("file_search")
    @ExcludeMissing
    private val fileSearch: JsonValue = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The index of the tool call in the tool calls array. */
    fun index(): Long = index.getRequired("index")

    /** The ID of the tool call object. */
    fun id(): Optional<String> = Optional.ofNullable(id.getNullable("id"))

    /**
     * The type of tool call. This is always going to be `file_search` for this type of tool call.
     */
    fun type(): Type = type.getRequired("type")

    /** The index of the tool call in the tool calls array. */
    @JsonProperty("index") @ExcludeMissing fun _index() = index

    /** The ID of the tool call object. */
    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /**
     * The type of tool call. This is always going to be `file_search` for this type of tool call.
     */
    @JsonProperty("type") @ExcludeMissing fun _type() = type

    /** For now, this is always going to be an empty object. */
    @JsonProperty("file_search") @ExcludeMissing fun _fileSearch() = fileSearch

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): FileSearchToolCallDelta = apply {
        if (!validated) {
            index()
            id()
            type()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var index: JsonField<Long> = JsonMissing.of()
        private var id: JsonField<String> = JsonMissing.of()
        private var type: JsonField<Type> = JsonMissing.of()
        private var fileSearch: JsonValue = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(fileSearchToolCallDelta: FileSearchToolCallDelta) = apply {
            index = fileSearchToolCallDelta.index
            id = fileSearchToolCallDelta.id
            type = fileSearchToolCallDelta.type
            fileSearch = fileSearchToolCallDelta.fileSearch
            additionalProperties = fileSearchToolCallDelta.additionalProperties.toMutableMap()
        }

        /** The index of the tool call in the tool calls array. */
        fun index(index: Long) = index(JsonField.of(index))

        /** The index of the tool call in the tool calls array. */
        fun index(index: JsonField<Long>) = apply { this.index = index }

        /** The ID of the tool call object. */
        fun id(id: String) = id(JsonField.of(id))

        /** The ID of the tool call object. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /**
         * The type of tool call. This is always going to be `file_search` for this type of tool
         * call.
         */
        fun type(type: Type) = type(JsonField.of(type))

        /**
         * The type of tool call. This is always going to be `file_search` for this type of tool
         * call.
         */
        fun type(type: JsonField<Type>) = apply { this.type = type }

        /** For now, this is always going to be an empty object. */
        fun fileSearch(fileSearch: JsonValue) = apply { this.fileSearch = fileSearch }

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
                index,
                id,
                type,
                fileSearch,
                additionalProperties.toImmutable(),
            )
    }

    class Type
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val FILE_SEARCH = of("file_search")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        enum class Known {
            FILE_SEARCH,
        }

        enum class Value {
            FILE_SEARCH,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                FILE_SEARCH -> Value.FILE_SEARCH
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                FILE_SEARCH -> Known.FILE_SEARCH
                else -> throw OpenAIInvalidDataException("Unknown Type: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Type && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FileSearchToolCallDelta && index == other.index && id == other.id && type == other.type && fileSearch == other.fileSearch && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(index, id, type, fileSearch, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FileSearchToolCallDelta{index=$index, id=$id, type=$type, fileSearch=$fileSearch, additionalProperties=$additionalProperties}"
}
