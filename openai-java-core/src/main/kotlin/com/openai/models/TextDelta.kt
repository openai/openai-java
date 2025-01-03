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
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import java.util.Objects
import java.util.Optional

@NoAutoDetect
class TextDelta
@JsonCreator
private constructor(
    @JsonProperty("value") @ExcludeMissing private val value: JsonField<String> = JsonMissing.of(),
    @JsonProperty("annotations")
    @ExcludeMissing
    private val annotations: JsonField<List<AnnotationDelta>> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The data that makes up the text. */
    fun value(): Optional<String> = Optional.ofNullable(value.getNullable("value"))

    fun annotations(): Optional<List<AnnotationDelta>> =
        Optional.ofNullable(annotations.getNullable("annotations"))

    /** The data that makes up the text. */
    @JsonProperty("value") @ExcludeMissing fun _value() = value

    @JsonProperty("annotations") @ExcludeMissing fun _annotations() = annotations

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): TextDelta = apply {
        if (!validated) {
            value()
            annotations()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var value: JsonField<String> = JsonMissing.of()
        private var annotations: JsonField<List<AnnotationDelta>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(textDelta: TextDelta) = apply {
            value = textDelta.value
            annotations = textDelta.annotations
            additionalProperties = textDelta.additionalProperties.toMutableMap()
        }

        /** The data that makes up the text. */
        fun value(value: String) = value(JsonField.of(value))

        /** The data that makes up the text. */
        fun value(value: JsonField<String>) = apply { this.value = value }

        fun annotations(annotations: List<AnnotationDelta>) = annotations(JsonField.of(annotations))

        fun annotations(annotations: JsonField<List<AnnotationDelta>>) = apply {
            this.annotations = annotations
        }

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

        fun build(): TextDelta =
            TextDelta(
                value,
                annotations.map { it.toImmutable() },
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is TextDelta && value == other.value && annotations == other.annotations && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(value, annotations, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TextDelta{value=$value, annotations=$annotations, additionalProperties=$additionalProperties}"
}
