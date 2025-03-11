// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores.files

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
class FileContentResponse
@JsonCreator
private constructor(
    @JsonProperty("text") @ExcludeMissing private val text: JsonField<String> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonField<String> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The text content */
    fun text(): Optional<String> = Optional.ofNullable(text.getNullable("text"))

    /** The content type (currently only `"text"`) */
    fun type(): Optional<String> = Optional.ofNullable(type.getNullable("type"))

    /** The text content */
    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

    /** The content type (currently only `"text"`) */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): FileContentResponse = apply {
        if (validated) {
            return@apply
        }

        text()
        type()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /** Returns a mutable builder for constructing an instance of [FileContentResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FileContentResponse]. */
    class Builder internal constructor() {

        private var text: JsonField<String> = JsonMissing.of()
        private var type: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(fileContentResponse: FileContentResponse) = apply {
            text = fileContentResponse.text
            type = fileContentResponse.type
            additionalProperties = fileContentResponse.additionalProperties.toMutableMap()
        }

        /** The text content */
        fun text(text: String) = text(JsonField.of(text))

        /** The text content */
        fun text(text: JsonField<String>) = apply { this.text = text }

        /** The content type (currently only `"text"`) */
        fun type(type: String) = type(JsonField.of(type))

        /** The content type (currently only `"text"`) */
        fun type(type: JsonField<String>) = apply { this.type = type }

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

        fun build(): FileContentResponse =
            FileContentResponse(text, type, additionalProperties.toImmutable())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FileContentResponse && text == other.text && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(text, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FileContentResponse{text=$text, type=$type, additionalProperties=$additionalProperties}"
}
