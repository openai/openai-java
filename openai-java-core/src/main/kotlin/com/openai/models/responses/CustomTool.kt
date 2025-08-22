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
import com.openai.core.checkRequired
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.CustomToolInputFormat
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * A custom tool that processes input using a specified format. Learn more about
 * [custom tools](https://platform.openai.com/docs/guides/function-calling#custom-tools).
 */
class CustomTool
private constructor(
    private val name: JsonField<String>,
    private val type: JsonValue,
    private val description: JsonField<String>,
    private val format: JsonField<CustomToolInputFormat>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("description")
        @ExcludeMissing
        description: JsonField<String> = JsonMissing.of(),
        @JsonProperty("format")
        @ExcludeMissing
        format: JsonField<CustomToolInputFormat> = JsonMissing.of(),
    ) : this(name, type, description, format, mutableMapOf())

    /**
     * The name of the custom tool, used to identify it in tool calls.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = name.getRequired("name")

    /**
     * The type of the custom tool. Always `custom`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("custom")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Optional description of the custom tool, used to provide more context.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun description(): Optional<String> = description.getOptional("description")

    /**
     * The input format for the custom tool. Default is unconstrained text.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun format(): Optional<CustomToolInputFormat> = format.getOptional("format")

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [description].
     *
     * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("description") @ExcludeMissing fun _description(): JsonField<String> = description

    /**
     * Returns the raw JSON value of [format].
     *
     * Unlike [format], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("format") @ExcludeMissing fun _format(): JsonField<CustomToolInputFormat> = format

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
         * Returns a mutable builder for constructing an instance of [CustomTool].
         *
         * The following fields are required:
         * ```java
         * .name()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CustomTool]. */
    class Builder internal constructor() {

        private var name: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("custom")
        private var description: JsonField<String> = JsonMissing.of()
        private var format: JsonField<CustomToolInputFormat> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(customTool: CustomTool) = apply {
            name = customTool.name
            type = customTool.type
            description = customTool.description
            format = customTool.format
            additionalProperties = customTool.additionalProperties.toMutableMap()
        }

        /** The name of the custom tool, used to identify it in tool calls. */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("custom")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** Optional description of the custom tool, used to provide more context. */
        fun description(description: String) = description(JsonField.of(description))

        /**
         * Sets [Builder.description] to an arbitrary JSON value.
         *
         * You should usually call [Builder.description] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun description(description: JsonField<String>) = apply { this.description = description }

        /** The input format for the custom tool. Default is unconstrained text. */
        fun format(format: CustomToolInputFormat) = format(JsonField.of(format))

        /**
         * Sets [Builder.format] to an arbitrary JSON value.
         *
         * You should usually call [Builder.format] with a well-typed [CustomToolInputFormat] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun format(format: JsonField<CustomToolInputFormat>) = apply { this.format = format }

        /** Alias for calling [format] with `CustomToolInputFormat.ofText()`. */
        fun formatText() = format(CustomToolInputFormat.ofText())

        /** Alias for calling [format] with `CustomToolInputFormat.ofGrammar(grammar)`. */
        fun format(grammar: CustomToolInputFormat.Grammar) =
            format(CustomToolInputFormat.ofGrammar(grammar))

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAlladditional_properties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAlladditional_properties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAlladditional_properties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [CustomTool].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .name()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CustomTool =
            CustomTool(
                checkRequired("name", name),
                type,
                description,
                format,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): CustomTool = apply {
        if (validated) {
            return@apply
        }

        name()
        _type().let {
            if (it != JsonValue.from("custom")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        description()
        format().ifPresent { it.validate() }
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
        (if (name.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("custom")) 1 else 0 } +
            (if (description.asKnown().isPresent) 1 else 0) +
            (format.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CustomTool &&
            name == other.name &&
            type == other.type &&
            description == other.description &&
            format == other.format &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(name, type, description, format, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CustomTool{name=$name, type=$type, description=$description, format=$format, additionalProperties=$additionalProperties}"
}
