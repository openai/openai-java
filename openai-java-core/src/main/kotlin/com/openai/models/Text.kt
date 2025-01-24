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
import java.util.Objects

@NoAutoDetect
class Text
@JsonCreator
private constructor(
    @JsonProperty("annotations")
    @ExcludeMissing
    private val annotations: JsonField<List<Annotation>> = JsonMissing.of(),
    @JsonProperty("value") @ExcludeMissing private val value: JsonField<String> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    fun annotations(): List<Annotation> = annotations.getRequired("annotations")

    /** The data that makes up the text. */
    fun value(): String = value.getRequired("value")

    @JsonProperty("annotations")
    @ExcludeMissing
    fun _annotations(): JsonField<List<Annotation>> = annotations

    /** The data that makes up the text. */
    @JsonProperty("value") @ExcludeMissing fun _value(): JsonField<String> = value

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): Text = apply {
        if (validated) {
            return@apply
        }

        annotations().forEach { it.validate() }
        value()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var annotations: JsonField<MutableList<Annotation>>? = null
        private var value: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(text: Text) = apply {
            annotations = text.annotations.map { it.toMutableList() }
            value = text.value
            additionalProperties = text.additionalProperties.toMutableMap()
        }

        fun annotations(annotations: List<Annotation>) = annotations(JsonField.of(annotations))

        fun annotations(annotations: JsonField<List<Annotation>>) = apply {
            this.annotations = annotations.map { it.toMutableList() }
        }

        fun addAnnotation(annotation: Annotation) = apply {
            annotations =
                (annotations ?: JsonField.of(mutableListOf())).apply {
                    asKnown()
                        .orElseThrow {
                            IllegalStateException(
                                "Field was set to non-list type: ${javaClass.simpleName}"
                            )
                        }
                        .add(annotation)
                }
        }

        /**
         * A citation within the message that points to a specific quote from a specific File
         * associated with the assistant or the message. Generated when the assistant uses the
         * "file_search" tool to search files.
         */
        fun addAnnotation(fileCitation: FileCitationAnnotation) =
            addAnnotation(Annotation.ofFileCitation(fileCitation))

        /**
         * A URL for the file that's generated when the assistant used the `code_interpreter` tool
         * to generate a file.
         */
        fun addAnnotation(filePath: FilePathAnnotation) =
            addAnnotation(Annotation.ofFilePath(filePath))

        /** The data that makes up the text. */
        fun value(value: String) = value(JsonField.of(value))

        /** The data that makes up the text. */
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

        fun build(): Text =
            Text(
                checkRequired("annotations", annotations).map { it.toImmutable() },
                checkRequired("value", value),
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is Text && annotations == other.annotations && value == other.value && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(annotations, value, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Text{annotations=$annotations, value=$value, additionalProperties=$additionalProperties}"
}
