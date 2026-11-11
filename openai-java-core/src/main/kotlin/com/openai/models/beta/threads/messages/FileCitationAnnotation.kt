// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

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
import com.openai.core.collectAllProperties
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/**
 * A citation within the message that points to a specific quote from a specific File associated
 * with the assistant or the message. Generated when the assistant uses the "file_search" tool to
 * search files.
 */
class FileCitationAnnotation
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val endIndex: JsonField<Long>,
    private val fileCitation: JsonField<FileCitation>,
    private val startIndex: JsonField<Long>,
    private val text: JsonField<String>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("end_index") @ExcludeMissing endIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("file_citation")
        @ExcludeMissing
        fileCitation: JsonField<FileCitation> = JsonMissing.of(),
        @JsonProperty("start_index") @ExcludeMissing startIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(endIndex, fileCitation, startIndex, text, type, mutableMapOf())

    /**
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun endIndex(): java.util.Optional<Long> = endIndex.getOptional("end_index")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun endIndexOrThrow(): Long = endIndex.getRequired("end_index")

    /**
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun fileCitation(): java.util.Optional<FileCitation> = fileCitation.getOptional("file_citation")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun fileCitationOrThrow(): FileCitation = fileCitation.getRequired("file_citation")

    /**
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun startIndex(): java.util.Optional<Long> = startIndex.getOptional("start_index")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun startIndexOrThrow(): Long = startIndex.getRequired("start_index")

    /**
     * The text in the message content that needs to be replaced. The schema requires this property.
     * Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun text(): java.util.Optional<String> = text.getOptional("text")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun textOrThrow(): String = text.getRequired("text")

    /**
     * Always `file_citation`. The schema requires this property. Returns empty if the JSON property
     * is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun type(): java.util.Optional<JsonValue> {
        val raw = type
        return when {
            raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
            !(raw == JsonValue.from("file_citation")) ->
                throw OpenAIInvalidDataException("`type` is invalid")
            else -> java.util.Optional.of(raw)
        }
    }

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

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

    /**
     * Returns an immutable snapshot of all present JSON properties, including declared and
     * additional properties.
     *
     * Keys use their JSON names. Declared properties take precedence over additional properties
     * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
     * values are preserved.
     */
    fun _allProperties(): Map<String, JsonValue> =
        collectAllProperties(
            additionalProperties,
            "end_index" to this.endIndex,
            "file_citation" to this.fileCitation,
            "start_index" to this.startIndex,
            "text" to this.text,
            "type" to this.type,
        )

    @JvmSynthetic
    internal fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    @JsonAnyGetter
    @ExcludeMissing
    private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [FileCitationAnnotation].
         *
         * The following fields are required:
         * ```java
         * .endIndex()
         * .fileCitation()
         * .startIndex()
         * .text()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FileCitationAnnotation]. */
    class Builder internal constructor() {

        private var endIndex: JsonField<Long>? = null
        private var fileCitation: JsonField<FileCitation>? = null
        private var startIndex: JsonField<Long>? = null
        private var text: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("file_citation")
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
         * Returns an immutable instance of [FileCitationAnnotation].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .endIndex()
         * .fileCitation()
         * .startIndex()
         * .text()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FileCitationAnnotation =
            FileCitationAnnotation(
                checkRequired("endIndex", endIndex),
                checkRequired("fileCitation", fileCitation),
                checkRequired("startIndex", startIndex),
                checkRequired("text", text),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): FileCitationAnnotation = apply {
        if (validated) {
            return@apply
        }

        endIndexOrThrow()
        fileCitationOrThrow().validate()
        startIndexOrThrow()
        textOrThrow()
        typeOrThrow()
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
            (fileCitation.asKnown().getOrNull()?.validity() ?: 0) +
            (if (startIndex.asKnown().isPresent) 1 else 0) +
            (if (text.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("file_citation")) 1 else 0 }

    class FileCitation
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val fileId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("file_id") @ExcludeMissing fileId: JsonField<String> = JsonMissing.of()
        ) : this(fileId, mutableMapOf())

        /**
         * The ID of the specific File the citation is from. The schema requires this property.
         * Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun fileId(): java.util.Optional<String> = fileId.getOptional("file_id")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun fileIdOrThrow(): String = fileId.getRequired("file_id")

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

        /**
         * Returns an immutable snapshot of all present JSON properties, including declared and
         * additional properties.
         *
         * Keys use their JSON names. Declared properties take precedence over additional properties
         * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
         * values are preserved.
         */
        fun _allProperties(): Map<String, JsonValue> =
            collectAllProperties(additionalProperties, "file_id" to this.fileId)

        @JvmSynthetic
        internal fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        @JsonAnyGetter
        @ExcludeMissing
        private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [FileCitation].
             *
             * The following fields are required:
             * ```java
             * .fileId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [FileCitation]. */
        class Builder internal constructor() {

            private var fileId: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(fileCitation: FileCitation) = apply {
                fileId = fileCitation.fileId
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
             *
             * The following fields are required:
             * ```java
             * .fileId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): FileCitation =
                FileCitation(checkRequired("fileId", fileId), additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): FileCitation = apply {
            if (validated) {
                return@apply
            }

            fileIdOrThrow()
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

            return other is FileCitation &&
                fileId == other.fileId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(fileId, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "FileCitation{fileId=$fileId, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FileCitationAnnotation &&
            endIndex == other.endIndex &&
            fileCitation == other.fileCitation &&
            startIndex == other.startIndex &&
            text == other.text &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(endIndex, fileCitation, startIndex, text, type, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FileCitationAnnotation{endIndex=$endIndex, fileCitation=$fileCitation, startIndex=$startIndex, text=$text, type=$type, additionalProperties=$additionalProperties}"
}
