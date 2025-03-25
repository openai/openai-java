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
import java.util.Optional

/**
 * A citation within the message that points to a specific quote from a specific File associated
 * with the assistant or the message. Generated when the assistant uses the "file_search" tool to
 * search files.
 */
class FileCitationDeltaAnnotation
private constructor(
    private val index: JsonField<Long>,
    private val type: JsonValue,
    private val endIndex: JsonField<Long>,
    private val fileCitation: JsonField<FileCitation>,
    private val startIndex: JsonField<Long>,
    private val text: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("index") @ExcludeMissing index: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("end_index") @ExcludeMissing endIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("file_citation")
        @ExcludeMissing
        fileCitation: JsonField<FileCitation> = JsonMissing.of(),
        @JsonProperty("start_index") @ExcludeMissing startIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
    ) : this(index, type, endIndex, fileCitation, startIndex, text, mutableMapOf())

    /**
     * The index of the annotation in the text content part.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun index(): Long = index.getRequired("index")

    /**
     * Always `file_citation`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("file_citation")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun endIndex(): Optional<Long> = Optional.ofNullable(endIndex.getNullable("end_index"))

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun fileCitation(): Optional<FileCitation> =
        Optional.ofNullable(fileCitation.getNullable("file_citation"))

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun startIndex(): Optional<Long> = Optional.ofNullable(startIndex.getNullable("start_index"))

    /**
     * The text in the message content that needs to be replaced.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun text(): Optional<String> = Optional.ofNullable(text.getNullable("text"))

    /**
     * Returns the raw JSON value of [index].
     *
     * Unlike [index], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("index") @ExcludeMissing fun _index(): JsonField<Long> = index

    /**
     * Returns the raw JSON value of [endIndex].
     *
     * Unlike [endIndex], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("end_index") @ExcludeMissing fun _endIndex(): JsonField<Long> = endIndex

    /**
     * Returns the raw JSON value of [fileCitation].
     *
     * Unlike [fileCitation], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("file_citation")
    @ExcludeMissing
    fun _fileCitation(): JsonField<FileCitation> = fileCitation

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
         * Returns a mutable builder for constructing an instance of [FileCitationDeltaAnnotation].
         *
         * The following fields are required:
         * ```java
         * .index()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FileCitationDeltaAnnotation]. */
    class Builder internal constructor() {

        private var index: JsonField<Long>? = null
        private var type: JsonValue = JsonValue.from("file_citation")
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
         * JsonValue.from("file_citation")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        fun endIndex(endIndex: Long) = endIndex(JsonField.of(endIndex))

        /**
         * Sets [Builder.endIndex] to an arbitrary JSON value.
         *
         * You should usually call [Builder.endIndex] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun endIndex(endIndex: JsonField<Long>) = apply { this.endIndex = endIndex }

        fun fileCitation(fileCitation: FileCitation) = fileCitation(JsonField.of(fileCitation))

        /**
         * Sets [Builder.fileCitation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fileCitation] with a well-typed [FileCitation] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun fileCitation(fileCitation: JsonField<FileCitation>) = apply {
            this.fileCitation = fileCitation
        }

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
         * Returns an immutable instance of [FileCitationDeltaAnnotation].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .index()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FileCitationDeltaAnnotation =
            FileCitationDeltaAnnotation(
                checkRequired("index", index),
                type,
                endIndex,
                fileCitation,
                startIndex,
                text,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): FileCitationDeltaAnnotation = apply {
        if (validated) {
            return@apply
        }

        index()
        _type().let {
            if (it != JsonValue.from("file_citation")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        endIndex()
        fileCitation().ifPresent { it.validate() }
        startIndex()
        text()
        validated = true
    }

    class FileCitation
    private constructor(
        private val fileId: JsonField<String>,
        private val quote: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("file_id") @ExcludeMissing fileId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("quote") @ExcludeMissing quote: JsonField<String> = JsonMissing.of(),
        ) : this(fileId, quote, mutableMapOf())

        /**
         * The ID of the specific File the citation is from.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun fileId(): Optional<String> = Optional.ofNullable(fileId.getNullable("file_id"))

        /**
         * The specific quote in the file.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun quote(): Optional<String> = Optional.ofNullable(quote.getNullable("quote"))

        /**
         * Returns the raw JSON value of [fileId].
         *
         * Unlike [fileId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("file_id") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

        /**
         * Returns the raw JSON value of [quote].
         *
         * Unlike [quote], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("quote") @ExcludeMissing fun _quote(): JsonField<String> = quote

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

            /** Returns a mutable builder for constructing an instance of [FileCitation]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [FileCitation]. */
        class Builder internal constructor() {

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

            /**
             * Sets [Builder.fileId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fileId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

            /** The specific quote in the file. */
            fun quote(quote: String) = quote(JsonField.of(quote))

            /**
             * Sets [Builder.quote] to an arbitrary JSON value.
             *
             * You should usually call [Builder.quote] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
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

            /**
             * Returns an immutable instance of [FileCitation].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): FileCitation =
                FileCitation(fileId, quote, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): FileCitation = apply {
            if (validated) {
                return@apply
            }

            fileId()
            quote()
            validated = true
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
