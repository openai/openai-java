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

/** Represents the url or the content of an image generated by the OpenAI API. */
@NoAutoDetect
class Image
@JsonCreator
private constructor(
    @JsonProperty("b64_json")
    @ExcludeMissing
    private val b64Json: JsonField<String> = JsonMissing.of(),
    @JsonProperty("revised_prompt")
    @ExcludeMissing
    private val revisedPrompt: JsonField<String> = JsonMissing.of(),
    @JsonProperty("url") @ExcludeMissing private val url: JsonField<String> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The base64-encoded JSON of the generated image, if `response_format` is `b64_json`. */
    fun b64Json(): Optional<String> = Optional.ofNullable(b64Json.getNullable("b64_json"))

    /** The prompt that was used to generate the image, if there was any revision to the prompt. */
    fun revisedPrompt(): Optional<String> =
        Optional.ofNullable(revisedPrompt.getNullable("revised_prompt"))

    /** The URL of the generated image, if `response_format` is `url` (default). */
    fun url(): Optional<String> = Optional.ofNullable(url.getNullable("url"))

    /** The base64-encoded JSON of the generated image, if `response_format` is `b64_json`. */
    @JsonProperty("b64_json") @ExcludeMissing fun _b64Json(): JsonField<String> = b64Json

    /** The prompt that was used to generate the image, if there was any revision to the prompt. */
    @JsonProperty("revised_prompt")
    @ExcludeMissing
    fun _revisedPrompt(): JsonField<String> = revisedPrompt

    /** The URL of the generated image, if `response_format` is `url` (default). */
    @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): Image = apply {
        if (validated) {
            return@apply
        }

        b64Json()
        revisedPrompt()
        url()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Image]. */
    class Builder internal constructor() {

        private var b64Json: JsonField<String> = JsonMissing.of()
        private var revisedPrompt: JsonField<String> = JsonMissing.of()
        private var url: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(image: Image) = apply {
            b64Json = image.b64Json
            revisedPrompt = image.revisedPrompt
            url = image.url
            additionalProperties = image.additionalProperties.toMutableMap()
        }

        /** The base64-encoded JSON of the generated image, if `response_format` is `b64_json`. */
        fun b64Json(b64Json: String) = b64Json(JsonField.of(b64Json))

        /** The base64-encoded JSON of the generated image, if `response_format` is `b64_json`. */
        fun b64Json(b64Json: JsonField<String>) = apply { this.b64Json = b64Json }

        /**
         * The prompt that was used to generate the image, if there was any revision to the prompt.
         */
        fun revisedPrompt(revisedPrompt: String) = revisedPrompt(JsonField.of(revisedPrompt))

        /**
         * The prompt that was used to generate the image, if there was any revision to the prompt.
         */
        fun revisedPrompt(revisedPrompt: JsonField<String>) = apply {
            this.revisedPrompt = revisedPrompt
        }

        /** The URL of the generated image, if `response_format` is `url` (default). */
        fun url(url: String) = url(JsonField.of(url))

        /** The URL of the generated image, if `response_format` is `url` (default). */
        fun url(url: JsonField<String>) = apply { this.url = url }

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

        fun build(): Image = Image(b64Json, revisedPrompt, url, additionalProperties.toImmutable())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is Image && b64Json == other.b64Json && revisedPrompt == other.revisedPrompt && url == other.url && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(b64Json, revisedPrompt, url, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Image{b64Json=$b64Json, revisedPrompt=$revisedPrompt, url=$url, additionalProperties=$additionalProperties}"
}
