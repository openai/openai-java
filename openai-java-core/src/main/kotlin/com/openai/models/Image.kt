// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.toUnmodifiable
import java.util.Objects
import java.util.Optional

/** Represents the url or the content of an image generated by the OpenAI API. */
@JsonDeserialize(builder = Image.Builder::class)
@NoAutoDetect
class Image
private constructor(
    private val b64Json: JsonField<String>,
    private val url: JsonField<String>,
    private val revisedPrompt: JsonField<String>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    /** The base64-encoded JSON of the generated image, if `response_format` is `b64_json`. */
    fun b64Json(): Optional<String> = Optional.ofNullable(b64Json.getNullable("b64_json"))

    /** The URL of the generated image, if `response_format` is `url` (default). */
    fun url(): Optional<String> = Optional.ofNullable(url.getNullable("url"))

    /** The prompt that was used to generate the image, if there was any revision to the prompt. */
    fun revisedPrompt(): Optional<String> =
        Optional.ofNullable(revisedPrompt.getNullable("revised_prompt"))

    /** The base64-encoded JSON of the generated image, if `response_format` is `b64_json`. */
    @JsonProperty("b64_json") @ExcludeMissing fun _b64Json() = b64Json

    /** The URL of the generated image, if `response_format` is `url` (default). */
    @JsonProperty("url") @ExcludeMissing fun _url() = url

    /** The prompt that was used to generate the image, if there was any revision to the prompt. */
    @JsonProperty("revised_prompt") @ExcludeMissing fun _revisedPrompt() = revisedPrompt

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): Image = apply {
        if (!validated) {
            b64Json()
            url()
            revisedPrompt()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var b64Json: JsonField<String> = JsonMissing.of()
        private var url: JsonField<String> = JsonMissing.of()
        private var revisedPrompt: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(image: Image) = apply {
            this.b64Json = image.b64Json
            this.url = image.url
            this.revisedPrompt = image.revisedPrompt
            additionalProperties(image.additionalProperties)
        }

        /** The base64-encoded JSON of the generated image, if `response_format` is `b64_json`. */
        fun b64Json(b64Json: String) = b64Json(JsonField.of(b64Json))

        /** The base64-encoded JSON of the generated image, if `response_format` is `b64_json`. */
        @JsonProperty("b64_json")
        @ExcludeMissing
        fun b64Json(b64Json: JsonField<String>) = apply { this.b64Json = b64Json }

        /** The URL of the generated image, if `response_format` is `url` (default). */
        fun url(url: String) = url(JsonField.of(url))

        /** The URL of the generated image, if `response_format` is `url` (default). */
        @JsonProperty("url")
        @ExcludeMissing
        fun url(url: JsonField<String>) = apply { this.url = url }

        /**
         * The prompt that was used to generate the image, if there was any revision to the prompt.
         */
        fun revisedPrompt(revisedPrompt: String) = revisedPrompt(JsonField.of(revisedPrompt))

        /**
         * The prompt that was used to generate the image, if there was any revision to the prompt.
         */
        @JsonProperty("revised_prompt")
        @ExcludeMissing
        fun revisedPrompt(revisedPrompt: JsonField<String>) = apply {
            this.revisedPrompt = revisedPrompt
        }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            this.additionalProperties.putAll(additionalProperties)
        }

        @JsonAnySetter
        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            this.additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun build(): Image =
            Image(
                b64Json,
                url,
                revisedPrompt,
                additionalProperties.toUnmodifiable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is Image && this.b64Json == other.b64Json && this.url == other.url && this.revisedPrompt == other.revisedPrompt && this.additionalProperties == other.additionalProperties /* spotless:on */
    }

    private var hashCode: Int = 0

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode = /* spotless:off */ Objects.hash(b64Json, url, revisedPrompt, additionalProperties) /* spotless:on */
        }
        return hashCode
    }

    override fun toString() =
        "Image{b64Json=$b64Json, url=$url, revisedPrompt=$revisedPrompt, additionalProperties=$additionalProperties}"
}