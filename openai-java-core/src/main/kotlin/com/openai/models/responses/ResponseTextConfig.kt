// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

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
import com.openai.models.ResponseFormatJsonObject
import com.openai.models.ResponseFormatText
import java.util.Objects
import java.util.Optional

/**
 * Configuration options for a text response from the model. Can be plain text or structured JSON
 * data. Learn more:
 * - [Text inputs and outputs](https://platform.openai.com/docs/guides/text)
 * - [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs)
 */
@NoAutoDetect
class ResponseTextConfig
@JsonCreator
private constructor(
    @JsonProperty("format")
    @ExcludeMissing
    private val format: JsonField<ResponseFormatTextConfig> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * An object specifying the format that the model must output.
     *
     * Configuring `{ "type": "json_schema" }` enables Structured Outputs, which ensures the model
     * will match your supplied JSON schema. Learn more in the
     * [Structured Outputs guide](https://platform.openai.com/docs/guides/structured-outputs).
     *
     * The default format is `{ "type": "text" }` with no additional options.
     *
     * **Not recommended for gpt-4o and newer models:**
     *
     * Setting to `{ "type": "json_object" }` enables the older JSON mode, which ensures the message
     * the model generates is valid JSON. Using `json_schema` is preferred for models that support
     * it.
     */
    fun format(): Optional<ResponseFormatTextConfig> =
        Optional.ofNullable(format.getNullable("format"))

    /**
     * An object specifying the format that the model must output.
     *
     * Configuring `{ "type": "json_schema" }` enables Structured Outputs, which ensures the model
     * will match your supplied JSON schema. Learn more in the
     * [Structured Outputs guide](https://platform.openai.com/docs/guides/structured-outputs).
     *
     * The default format is `{ "type": "text" }` with no additional options.
     *
     * **Not recommended for gpt-4o and newer models:**
     *
     * Setting to `{ "type": "json_object" }` enables the older JSON mode, which ensures the message
     * the model generates is valid JSON. Using `json_schema` is preferred for models that support
     * it.
     */
    @JsonProperty("format")
    @ExcludeMissing
    fun _format(): JsonField<ResponseFormatTextConfig> = format

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ResponseTextConfig = apply {
        if (validated) {
            return@apply
        }

        format().ifPresent { it.validate() }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /** Returns a mutable builder for constructing an instance of [ResponseTextConfig]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseTextConfig]. */
    class Builder internal constructor() {

        private var format: JsonField<ResponseFormatTextConfig> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseTextConfig: ResponseTextConfig) = apply {
            format = responseTextConfig.format
            additionalProperties = responseTextConfig.additionalProperties.toMutableMap()
        }

        /**
         * An object specifying the format that the model must output.
         *
         * Configuring `{ "type": "json_schema" }` enables Structured Outputs, which ensures the
         * model will match your supplied JSON schema. Learn more in the
         * [Structured Outputs guide](https://platform.openai.com/docs/guides/structured-outputs).
         *
         * The default format is `{ "type": "text" }` with no additional options.
         *
         * **Not recommended for gpt-4o and newer models:**
         *
         * Setting to `{ "type": "json_object" }` enables the older JSON mode, which ensures the
         * message the model generates is valid JSON. Using `json_schema` is preferred for models
         * that support it.
         */
        fun format(format: ResponseFormatTextConfig) = format(JsonField.of(format))

        /**
         * An object specifying the format that the model must output.
         *
         * Configuring `{ "type": "json_schema" }` enables Structured Outputs, which ensures the
         * model will match your supplied JSON schema. Learn more in the
         * [Structured Outputs guide](https://platform.openai.com/docs/guides/structured-outputs).
         *
         * The default format is `{ "type": "text" }` with no additional options.
         *
         * **Not recommended for gpt-4o and newer models:**
         *
         * Setting to `{ "type": "json_object" }` enables the older JSON mode, which ensures the
         * message the model generates is valid JSON. Using `json_schema` is preferred for models
         * that support it.
         */
        fun format(format: JsonField<ResponseFormatTextConfig>) = apply { this.format = format }

        /** Default response format. Used to generate text responses. */
        fun format(text: ResponseFormatText) = format(ResponseFormatTextConfig.ofText(text))

        /**
         * JSON Schema response format. Used to generate structured JSON responses. Learn more about
         * [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs).
         */
        fun format(jsonSchema: ResponseFormatTextJsonSchemaConfig) =
            format(ResponseFormatTextConfig.ofJsonSchema(jsonSchema))

        /**
         * JSON Schema response format. Used to generate structured JSON responses. Learn more about
         * [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs).
         */
        fun jsonSchemaFormat(schema: ResponseFormatTextJsonSchemaConfig.Schema) =
            format(ResponseFormatTextJsonSchemaConfig.builder().schema(schema).build())

        /**
         * JSON object response format. An older method of generating JSON responses. Using
         * `json_schema` is recommended for models that support it. Note that the model will not
         * generate JSON without a system or user message instructing it to do so.
         */
        fun format(jsonObject: ResponseFormatJsonObject) =
            format(ResponseFormatTextConfig.ofJsonObject(jsonObject))

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

        fun build(): ResponseTextConfig =
            ResponseTextConfig(format, additionalProperties.toImmutable())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ResponseTextConfig && format == other.format && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(format, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseTextConfig{format=$format, additionalProperties=$additionalProperties}"
}
