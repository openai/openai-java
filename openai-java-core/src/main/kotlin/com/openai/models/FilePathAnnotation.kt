// File generated from our OpenAPI spec by Stainless.

package com.openai.models

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

/**
 * A URL for the file that's generated when the assistant used the `code_interpreter` tool to
 * generate a file.
 */
@NoAutoDetect
class FilePathAnnotation
@JsonCreator
private constructor(
    @JsonProperty("end_index")
    @ExcludeMissing
    private val endIndex: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("file_path")
    @ExcludeMissing
    private val filePath: JsonField<FilePath> = JsonMissing.of(),
    @JsonProperty("start_index")
    @ExcludeMissing
    private val startIndex: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("text") @ExcludeMissing private val text: JsonField<String> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    fun endIndex(): Long = endIndex.getRequired("end_index")

    fun filePath(): FilePath = filePath.getRequired("file_path")

    fun startIndex(): Long = startIndex.getRequired("start_index")

    /** The text in the message content that needs to be replaced. */
    fun text(): String = text.getRequired("text")

    /** Always `file_path`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    @JsonProperty("end_index") @ExcludeMissing fun _endIndex(): JsonField<Long> = endIndex

    @JsonProperty("file_path") @ExcludeMissing fun _filePath(): JsonField<FilePath> = filePath

    @JsonProperty("start_index") @ExcludeMissing fun _startIndex(): JsonField<Long> = startIndex

    /** The text in the message content that needs to be replaced. */
    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): FilePathAnnotation = apply {
        if (validated) {
            return@apply
        }

        endIndex()
        filePath().validate()
        startIndex()
        text()
        _type().let {
            if (it != JsonValue.from("file_path")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var endIndex: JsonField<Long>? = null
        private var filePath: JsonField<FilePath>? = null
        private var startIndex: JsonField<Long>? = null
        private var text: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("file_path")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(filePathAnnotation: FilePathAnnotation) = apply {
            endIndex = filePathAnnotation.endIndex
            filePath = filePathAnnotation.filePath
            startIndex = filePathAnnotation.startIndex
            text = filePathAnnotation.text
            type = filePathAnnotation.type
            additionalProperties = filePathAnnotation.additionalProperties.toMutableMap()
        }

        fun endIndex(endIndex: Long) = endIndex(JsonField.of(endIndex))

        fun endIndex(endIndex: JsonField<Long>) = apply { this.endIndex = endIndex }

        fun filePath(filePath: FilePath) = filePath(JsonField.of(filePath))

        fun filePath(filePath: JsonField<FilePath>) = apply { this.filePath = filePath }

        fun startIndex(startIndex: Long) = startIndex(JsonField.of(startIndex))

        fun startIndex(startIndex: JsonField<Long>) = apply { this.startIndex = startIndex }

        /** The text in the message content that needs to be replaced. */
        fun text(text: String) = text(JsonField.of(text))

        /** The text in the message content that needs to be replaced. */
        fun text(text: JsonField<String>) = apply { this.text = text }

        /** Always `file_path`. */
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

        fun build(): FilePathAnnotation =
            FilePathAnnotation(
                checkRequired("endIndex", endIndex),
                checkRequired("filePath", filePath),
                checkRequired("startIndex", startIndex),
                checkRequired("text", text),
                type,
                additionalProperties.toImmutable(),
            )
    }

    @NoAutoDetect
    class FilePath
    @JsonCreator
    private constructor(
        @JsonProperty("file_id")
        @ExcludeMissing
        private val fileId: JsonField<String> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The ID of the file that was generated. */
        fun fileId(): String = fileId.getRequired("file_id")

        /** The ID of the file that was generated. */
        @JsonProperty("file_id") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): FilePath = apply {
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
            internal fun from(filePath: FilePath) = apply {
                fileId = filePath.fileId
                additionalProperties = filePath.additionalProperties.toMutableMap()
            }

            /** The ID of the file that was generated. */
            fun fileId(fileId: String) = fileId(JsonField.of(fileId))

            /** The ID of the file that was generated. */
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

            fun build(): FilePath =
                FilePath(checkRequired("fileId", fileId), additionalProperties.toImmutable())
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is FilePath && fileId == other.fileId && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(fileId, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "FilePath{fileId=$fileId, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FilePathAnnotation && endIndex == other.endIndex && filePath == other.filePath && startIndex == other.startIndex && text == other.text && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(endIndex, filePath, startIndex, text, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FilePathAnnotation{endIndex=$endIndex, filePath=$filePath, startIndex=$startIndex, text=$text, type=$type, additionalProperties=$additionalProperties}"
}
