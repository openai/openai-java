// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

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
import kotlin.jvm.optionals.getOrNull

/**
 * A URL for the file that's generated when the assistant used the `code_interpreter` tool to
 * generate a file.
 */
class FilePathAnnotation
private constructor(
    private val endIndex: JsonField<Long>,
    private val filePath: JsonField<FilePath>,
    private val startIndex: JsonField<Long>,
    private val text: JsonField<String>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("end_index") @ExcludeMissing endIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("file_path") @ExcludeMissing filePath: JsonField<FilePath> = JsonMissing.of(),
        @JsonProperty("start_index") @ExcludeMissing startIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(endIndex, filePath, startIndex, text, type, mutableMapOf())

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun endIndex(): Long = endIndex.getRequired("end_index")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun filePath(): FilePath = filePath.getRequired("file_path")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun startIndex(): Long = startIndex.getRequired("start_index")

    /**
     * The text in the message content that needs to be replaced.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun text(): String = text.getRequired("text")

    /**
     * Always `file_path`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("file_path")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [endIndex].
     *
     * Unlike [endIndex], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("end_index") @ExcludeMissing fun _endIndex(): JsonField<Long> = endIndex

    /**
     * Returns the raw JSON value of [filePath].
     *
     * Unlike [filePath], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("file_path") @ExcludeMissing fun _filePath(): JsonField<FilePath> = filePath

    /**
     * Returns the raw JSON value of [startIndex].
     *
     * Unlike [startIndex], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("start_index") @ExcludeMissing fun _startIndex(): JsonField<Long> = startIndex

    /**
     * Returns the raw JSON value of [text].
     *
     * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

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
         * Returns a mutable builder for constructing an instance of [FilePathAnnotation].
         *
         * The following fields are required:
         * ```java
         * .endIndex()
         * .filePath()
         * .startIndex()
         * .text()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FilePathAnnotation]. */
    class Builder internal constructor() {

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

        /**
         * Sets [Builder.endIndex] to an arbitrary JSON value.
         *
         * You should usually call [Builder.endIndex] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun endIndex(endIndex: JsonField<Long>) = apply { this.endIndex = endIndex }

        fun filePath(filePath: FilePath) = filePath(JsonField.of(filePath))

        /**
         * Sets [Builder.filePath] to an arbitrary JSON value.
         *
         * You should usually call [Builder.filePath] with a well-typed [FilePath] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun filePath(filePath: JsonField<FilePath>) = apply { this.filePath = filePath }

        fun startIndex(startIndex: Long) = startIndex(JsonField.of(startIndex))

        /**
         * Sets [Builder.startIndex] to an arbitrary JSON value.
         *
         * You should usually call [Builder.startIndex] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun startIndex(startIndex: JsonField<Long>) = apply { this.startIndex = startIndex }

        /** The text in the message content that needs to be replaced. */
        fun text(text: String) = text(JsonField.of(text))

        /**
         * Sets [Builder.text] to an arbitrary JSON value.
         *
         * You should usually call [Builder.text] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun text(text: JsonField<String>) = apply { this.text = text }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("file_path")
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
         * Returns an immutable instance of [FilePathAnnotation].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .endIndex()
         * .filePath()
         * .startIndex()
         * .text()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FilePathAnnotation =
            FilePathAnnotation(
                checkRequired("endIndex", endIndex),
                checkRequired("filePath", filePath),
                checkRequired("startIndex", startIndex),
                checkRequired("text", text),
                type,
                additionalProperties.toMutableMap(),
            )
    }

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
        (if (endIndex.asKnown().isPresent) 1 else 0) +
            (filePath.asKnown().getOrNull()?.validity() ?: 0) +
            (if (startIndex.asKnown().isPresent) 1 else 0) +
            (if (text.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("file_path")) 1 else 0 }

    class FilePath
    private constructor(
        private val fileId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("file_id") @ExcludeMissing fileId: JsonField<String> = JsonMissing.of()
        ) : this(fileId, mutableMapOf())

        /**
         * The ID of the file that was generated.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun fileId(): String = fileId.getRequired("file_id")

        /**
         * Returns the raw JSON value of [fileId].
         *
         * Unlike [fileId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("file_id") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

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
             * Returns a mutable builder for constructing an instance of [FilePath].
             *
             * The following fields are required:
             * ```java
             * .fileId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [FilePath]. */
        class Builder internal constructor() {

            private var fileId: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(filePath: FilePath) = apply {
                fileId = filePath.fileId
                additionalProperties = filePath.additionalProperties.toMutableMap()
            }

            /** The ID of the file that was generated. */
            fun fileId(fileId: String) = fileId(JsonField.of(fileId))

            /**
             * Sets [Builder.fileId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fileId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
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

            /**
             * Returns an immutable instance of [FilePath].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .fileId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): FilePath =
                FilePath(checkRequired("fileId", fileId), additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): FilePath = apply {
            if (validated) {
                return@apply
            }

            fileId()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = (if (fileId.asKnown().isPresent) 1 else 0)

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
