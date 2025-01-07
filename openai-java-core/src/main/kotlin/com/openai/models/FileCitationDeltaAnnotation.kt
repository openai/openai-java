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

/**
 * A citation within the message that points to a specific quote from a specific File associated
 * with the assistant or the message. Generated when the assistant uses the "file_search" tool to
 * search files.
 */
@NoAutoDetect
class FileCitationDeltaAnnotation
@JsonCreator
private constructor(
    @JsonProperty("index") @ExcludeMissing private val index: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
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
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The index of the annotation in the text content part. */
    fun index(): Long = index.getRequired("index")

    /** Always `file_citation`. */
    fun type(): Type = type.getRequired("type")

    fun endIndex(): Optional<Long> = Optional.ofNullable(endIndex.getNullable("end_index"))

    fun fileCitation(): Optional<FileCitation> =
        Optional.ofNullable(fileCitation.getNullable("file_citation"))

    fun startIndex(): Optional<Long> = Optional.ofNullable(startIndex.getNullable("start_index"))

    /** The text in the message content that needs to be replaced. */
    fun text(): Optional<String> = Optional.ofNullable(text.getNullable("text"))

    /** The index of the annotation in the text content part. */
    @JsonProperty("index") @ExcludeMissing fun _index(): JsonField<Long> = index

    /** Always `file_citation`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

    @JsonProperty("end_index") @ExcludeMissing fun _endIndex(): JsonField<Long> = endIndex

    @JsonProperty("file_citation")
    @ExcludeMissing
    fun _fileCitation(): JsonField<FileCitation> = fileCitation

    @JsonProperty("start_index") @ExcludeMissing fun _startIndex(): JsonField<Long> = startIndex

    /** The text in the message content that needs to be replaced. */
    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): FileCitationDeltaAnnotation = apply {
        if (!validated) {
            index()
            type()
            endIndex()
            fileCitation().map { it.validate() }
            startIndex()
            text()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var index: JsonField<Long>? = null
        private var type: JsonField<Type>? = null
        private var endIndex: JsonField<Long> = JsonMissing.of()
        private var fileCitation: JsonField<FileCitation> = JsonMissing.of()
        private var startIndex: JsonField<Long> = JsonMissing.of()
        private var text: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(fileCitationDeltaAnnotation: FileCitationDeltaAnnotation) = apply {
            index = fileCitationDeltaAnnotation.index
            type = fileCitationDeltaAnnotation.type
            endIndex = fileCitationDeltaAnnotation.endIndex
            fileCitation = fileCitationDeltaAnnotation.fileCitation
            startIndex = fileCitationDeltaAnnotation.startIndex
            text = fileCitationDeltaAnnotation.text
            additionalProperties = fileCitationDeltaAnnotation.additionalProperties.toMutableMap()
        }

        /** The index of the annotation in the text content part. */
        fun index(index: Long) = index(JsonField.of(index))

        /** The index of the annotation in the text content part. */
        fun index(index: JsonField<Long>) = apply { this.index = index }

        /** Always `file_citation`. */
        fun type(type: Type) = type(JsonField.of(type))

        /** Always `file_citation`. */
        fun type(type: JsonField<Type>) = apply { this.type = type }

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

        fun build(): FileCitationDeltaAnnotation =
            FileCitationDeltaAnnotation(
                checkNotNull(index) { "`index` is required but was not set" },
                checkNotNull(type) { "`type` is required but was not set" },
                endIndex,
                fileCitation,
                startIndex,
                text,
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

    @NoAutoDetect
    class FileCitation
    @JsonCreator
    private constructor(
        @JsonProperty("file_id")
        @ExcludeMissing
        private val fileId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("quote")
        @ExcludeMissing
        private val quote: JsonField<String> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The ID of the specific File the citation is from. */
        fun fileId(): Optional<String> = Optional.ofNullable(fileId.getNullable("file_id"))

        /** The specific quote in the file. */
        fun quote(): Optional<String> = Optional.ofNullable(quote.getNullable("quote"))

        /** The ID of the specific File the citation is from. */
        @JsonProperty("file_id") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

        /** The specific quote in the file. */
        @JsonProperty("quote") @ExcludeMissing fun _quote(): JsonField<String> = quote

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): FileCitation = apply {
            if (!validated) {
                fileId()
                quote()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var fileId: JsonField<String> = JsonMissing.of()
            private var quote: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(fileCitation: FileCitation) = apply {
                fileId = fileCitation.fileId
                quote = fileCitation.quote
                additionalProperties = fileCitation.additionalProperties.toMutableMap()
            }

            /** The ID of the specific File the citation is from. */
            fun fileId(fileId: String) = fileId(JsonField.of(fileId))

            /** The ID of the specific File the citation is from. */
            fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

            /** The specific quote in the file. */
            fun quote(quote: String) = quote(JsonField.of(quote))

            /** The specific quote in the file. */
            fun quote(quote: JsonField<String>) = apply { this.quote = quote }

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
                FileCitation(
                    fileId,
                    quote,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is FileCitation && fileId == other.fileId && quote == other.quote && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(fileId, quote, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "FileCitation{fileId=$fileId, quote=$quote, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FileCitationDeltaAnnotation && index == other.index && type == other.type && endIndex == other.endIndex && fileCitation == other.fileCitation && startIndex == other.startIndex && text == other.text && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(index, type, endIndex, fileCitation, startIndex, text, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FileCitationDeltaAnnotation{index=$index, type=$type, endIndex=$endIndex, fileCitation=$fileCitation, startIndex=$startIndex, text=$text, additionalProperties=$additionalProperties}"
}
