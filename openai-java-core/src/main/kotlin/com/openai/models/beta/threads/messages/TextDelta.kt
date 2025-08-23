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
import com.openai.core.checkKnown
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class TextDelta
private constructor(
    private val annotations: JsonField<List<AnnotationDelta>>,
    private val value: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("annotations")
        @ExcludeMissing
        annotations: JsonField<List<AnnotationDelta>> = JsonMissing.of(),
        @JsonProperty("value") @ExcludeMissing value: JsonField<String> = JsonMissing.of(),
    ) : this(annotations, value, mutableMapOf())

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun annotations(): Optional<List<AnnotationDelta>> = annotations.getOptional("annotations")

    /**
     * The data that makes up the text.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun value(): Optional<String> = value.getOptional("value")

    /**
     * Returns the raw JSON value of [annotations].
     *
     * Unlike [annotations], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("annotations")
    @ExcludeMissing
    fun _annotations(): JsonField<List<AnnotationDelta>> = annotations

    /**
     * Returns the raw JSON value of [value].
     *
     * Unlike [value], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("value") @ExcludeMissing fun _value(): JsonField<String> = value

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

        /** Returns a mutable builder for constructing an instance of [TextDelta]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TextDelta]. */
    class Builder internal constructor() {

        private var annotations: JsonField<MutableList<AnnotationDelta>>? = null
        private var value: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(textDelta: TextDelta) = apply {
            annotations = textDelta.annotations.map { it.toMutableList() }
            value = textDelta.value
            additionalProperties = textDelta.additionalProperties.toMutableMap()
        }

        fun annotations(annotations: List<AnnotationDelta>) = annotations(JsonField.of(annotations))

        /**
         * Sets [Builder.annotations] to an arbitrary JSON value.
         *
         * You should usually call [Builder.annotations] with a well-typed `List<AnnotationDelta>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun annotations(annotations: JsonField<List<AnnotationDelta>>) = apply {
            this.annotations = annotations.map { it.toMutableList() }
        }

        /**
         * Adds a single [AnnotationDelta] to [annotations].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addAnnotation(annotation: AnnotationDelta) = apply {
            annotations =
                (annotations ?: JsonField.of(mutableListOf())).also {
                    checkKnown("annotations", it).add(annotation)
                }
        }

        /**
         * Alias for calling [addAnnotation] with `AnnotationDelta.ofFileCitation(fileCitation)`.
         */
        fun addAnnotation(fileCitation: FileCitationDeltaAnnotation) =
            addAnnotation(AnnotationDelta.ofFileCitation(fileCitation))

        /**
         * Alias for calling [addAnnotation] with the following:
         * ```java
         * FileCitationDeltaAnnotation.builder()
         *     .index(index)
         *     .build()
         * ```
         */
        fun addFileCitationAnnotation(index: Long) =
            addAnnotation(FileCitationDeltaAnnotation.builder().index(index).build())

        /** Alias for calling [addAnnotation] with `AnnotationDelta.ofFilePath(filePath)`. */
        fun addAnnotation(filePath: FilePathDeltaAnnotation) =
            addAnnotation(AnnotationDelta.ofFilePath(filePath))

        /**
         * Alias for calling [addAnnotation] with the following:
         * ```java
         * FilePathDeltaAnnotation.builder()
         *     .index(index)
         *     .build()
         * ```
         */
        fun addFilePathAnnotation(index: Long) =
            addAnnotation(FilePathDeltaAnnotation.builder().index(index).build())

        /** The data that makes up the text. */
        fun value(value: String) = value(JsonField.of(value))

        /**
         * Sets [Builder.value] to an arbitrary JSON value.
         *
         * You should usually call [Builder.value] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun value(value: JsonField<String>) = apply { this.value = value }

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
         * Returns an immutable instance of [TextDelta].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): TextDelta =
            TextDelta(
                (annotations ?: JsonMissing.of()).map { it.toImmutable() },
                value,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): TextDelta = apply {
        if (validated) {
            return@apply
        }

        annotations().ifPresent { it.forEach { it.validate() } }
        value()
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
        (annotations.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (value.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TextDelta &&
            annotations == other.annotations &&
            value == other.value &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(annotations, value, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TextDelta{annotations=$annotations, value=$value, additionalProperties=$additionalProperties}"
}
