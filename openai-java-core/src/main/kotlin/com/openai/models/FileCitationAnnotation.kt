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

/**
 * A citation within the message that points to a specific quote from a specific File associated
 * with the assistant or the message. Generated when the assistant uses the "file_search" tool to
 * search files.
 */
@NoAutoDetect
class FileCitationAnnotation
@JsonCreator
private constructor(
    @JsonProperty("end_index")
    @ExcludeMissing
    private val endIndex: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("file_citation")
    @ExcludeMissing
    private val fileCitation: JsonField<FileCitation> = JsonMissing.of(),
    @JsonProperty("start_index")
    @ExcludeMissing
    private val startIndex: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("text") @ExcludeMissing private val text: JsonField<String> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    fun endIndex(): Long = endIndex.getRequired("end_index")

    fun fileCitation(): FileCitation = fileCitation.getRequired("file_citation")

    fun startIndex(): Long = startIndex.getRequired("start_index")

    /** The text in the message content that needs to be replaced. */
    fun text(): String = text.getRequired("text")

    /** Always `file_citation`. */
    fun type(): Type = type.getRequired("type")

    @JsonProperty("end_index") @ExcludeMissing fun _endIndex(): JsonField<Long> = endIndex

    @JsonProperty("file_citation")
    @ExcludeMissing
    fun _fileCitation(): JsonField<FileCitation> = fileCitation

    @JsonProperty("start_index") @ExcludeMissing fun _startIndex(): JsonField<Long> = startIndex

    /** The text in the message content that needs to be replaced. */
    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

    /** Always `file_citation`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): FileCitationAnnotation = apply {
        if (validated) {
            return@apply
        }

        endIndex()
        fileCitation().validate()
        startIndex()
        text()
        type()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var endIndex: JsonField<Long>? = null
        private var fileCitation: JsonField<FileCitation>? = null
        private var startIndex: JsonField<Long>? = null
        private var text: JsonField<String>? = null
        private var type: JsonField<Type>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(fileCitationAnnotation: FileCitationAnnotation) = apply {
            endIndex = fileCitationAnnotation.endIndex
            fileCitation = fileCitationAnnotation.fileCitation
            startIndex = fileCitationAnnotation.startIndex
            text = fileCitationAnnotation.text
            type = fileCitationAnnotation.type
            additionalProperties = fileCitationAnnotation.additionalProperties.toMutableMap()
        }

        fun endIndex(endIndex: Long) = endIndex(JsonField.of(endIndex))

        fun endIndex(endIndex: JsonField<Long>) = apply { this.endIndex = endIndex }

        fun fileCitation(fileCitation: FileCitation) = fileCitation(JsonField.of(fileCitation))

        fun fileCitation(fileCitation: JsonField<FileCitation>) = apply {
            this.fileCitation = fileCitation
        }

        fun startIndex(startIndex: Long) = startIndex(JsonField.of(startIndex))

        fun startIndex(startIndex: JsonField<Long>) = apply { this.startIndex = startIndex }

        /** The text in the message content that needs to be replaced. */
        fun text(text: String) = text(JsonField.of(text))

        /** The text in the message content that needs to be replaced. */
        fun text(text: JsonField<String>) = apply { this.text = text }

        /** Always `file_citation`. */
        fun type(type: Type) = type(JsonField.of(type))

        /** Always `file_citation`. */
        fun type(type: JsonField<Type>) = apply { this.type = type }

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

        fun build(): FileCitationAnnotation =
            FileCitationAnnotation(
                checkRequired("endIndex", endIndex),
                checkRequired("fileCitation", fileCitation),
                checkRequired("startIndex", startIndex),
                checkRequired("text", text),
                checkRequired("type", type),
                additionalProperties.toImmutable(),
            )
    }

    @NoAutoDetect
    class FileCitation
    @JsonCreator
    private constructor(
        @JsonProperty("file_id")
        @ExcludeMissing
        private val fileId: JsonField<String> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The ID of the specific File the citation is from. */
        fun fileId(): String = fileId.getRequired("file_id")

        /** The ID of the specific File the citation is from. */
        @JsonProperty("file_id") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): FileCitation = apply {
            if (validated) {
                return@apply
            }

            fileId()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var fileId: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(fileCitation: FileCitation) = apply {
                fileId = fileCitation.fileId
                additionalProperties = fileCitation.additionalProperties.toMutableMap()
            }

            /** The ID of the specific File the citation is from. */
            fun fileId(fileId: String) = fileId(JsonField.of(fileId))

            /** The ID of the specific File the citation is from. */
            fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

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

            fun build(): FileCitation =
                FileCitation(checkRequired("fileId", fileId), additionalProperties.toImmutable())
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is FileCitation && fileId == other.fileId && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(fileId, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "FileCitation{fileId=$fileId, additionalProperties=$additionalProperties}"
    }

    /** Always `file_citation`. */
    class Type
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val FILE_CITATION = of("file_citation")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        enum class Known {
            FILE_CITATION,
        }

        enum class Value {
            FILE_CITATION,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                FILE_CITATION -> Value.FILE_CITATION
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                FILE_CITATION -> Known.FILE_CITATION
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

        return /* spotless:off */ other is FileCitationAnnotation && endIndex == other.endIndex && fileCitation == other.fileCitation && startIndex == other.startIndex && text == other.text && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(endIndex, fileCitation, startIndex, text, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FileCitationAnnotation{endIndex=$endIndex, fileCitation=$fileCitation, startIndex=$startIndex, text=$text, type=$type, additionalProperties=$additionalProperties}"
}
