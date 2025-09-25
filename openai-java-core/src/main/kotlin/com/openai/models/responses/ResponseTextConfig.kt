// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.ResponseFormatJsonObject
import com.openai.models.ResponseFormatText
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Configuration options for a text response from the model. Can be plain text or structured JSON
 * data. Learn more:
 * - [Text inputs and outputs](https://platform.openai.com/docs/guides/text)
 * - [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs)
 */
class ResponseTextConfig
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val format: JsonField<ResponseFormatTextConfig>,
    private val verbosity: JsonField<Verbosity>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("format")
        @ExcludeMissing
        format: JsonField<ResponseFormatTextConfig> = JsonMissing.of(),
        @JsonProperty("verbosity")
        @ExcludeMissing
        verbosity: JsonField<Verbosity> = JsonMissing.of(),
    ) : this(format, verbosity, mutableMapOf())

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
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun format(): Optional<ResponseFormatTextConfig> = format.getOptional("format")

    /**
     * Constrains the verbosity of the model's response. Lower values will result in more concise
     * responses, while higher values will result in more verbose responses. Currently supported
     * values are `low`, `medium`, and `high`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun verbosity(): Optional<Verbosity> = verbosity.getOptional("verbosity")

    /**
     * Returns the raw JSON value of [format].
     *
     * Unlike [format], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("format")
    @ExcludeMissing
    fun _format(): JsonField<ResponseFormatTextConfig> = format

    /**
     * Returns the raw JSON value of [verbosity].
     *
     * Unlike [verbosity], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("verbosity") @ExcludeMissing fun _verbosity(): JsonField<Verbosity> = verbosity

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

        /** Returns a mutable builder for constructing an instance of [ResponseTextConfig]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseTextConfig]. */
    class Builder internal constructor() {

        private var format: JsonField<ResponseFormatTextConfig> = JsonMissing.of()
        private var verbosity: JsonField<Verbosity> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseTextConfig: ResponseTextConfig) = apply {
            format = responseTextConfig.format
            verbosity = responseTextConfig.verbosity
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
         * Sets [Builder.format] to an arbitrary JSON value.
         *
         * You should usually call [Builder.format] with a well-typed [ResponseFormatTextConfig]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun format(format: JsonField<ResponseFormatTextConfig>) = apply { this.format = format }

        /** Alias for calling [format] with `ResponseFormatTextConfig.ofText(text)`. */
        fun format(text: ResponseFormatText) = format(ResponseFormatTextConfig.ofText(text))

        /** Alias for calling [format] with `ResponseFormatTextConfig.ofJsonSchema(jsonSchema)`. */
        fun format(jsonSchema: ResponseFormatTextJsonSchemaConfig) =
            format(ResponseFormatTextConfig.ofJsonSchema(jsonSchema))

        /** Alias for calling [format] with `ResponseFormatTextConfig.ofJsonObject(jsonObject)`. */
        fun format(jsonObject: ResponseFormatJsonObject) =
            format(ResponseFormatTextConfig.ofJsonObject(jsonObject))

        /**
         * Constrains the verbosity of the model's response. Lower values will result in more
         * concise responses, while higher values will result in more verbose responses. Currently
         * supported values are `low`, `medium`, and `high`.
         */
        fun verbosity(verbosity: Verbosity?) = verbosity(JsonField.ofNullable(verbosity))

        /** Alias for calling [Builder.verbosity] with `verbosity.orElse(null)`. */
        fun verbosity(verbosity: Optional<Verbosity>) = verbosity(verbosity.getOrNull())

        /**
         * Sets [Builder.verbosity] to an arbitrary JSON value.
         *
         * You should usually call [Builder.verbosity] with a well-typed [Verbosity] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun verbosity(verbosity: JsonField<Verbosity>) = apply { this.verbosity = verbosity }

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
         * Returns an immutable instance of [ResponseTextConfig].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ResponseTextConfig =
            ResponseTextConfig(format, verbosity, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): ResponseTextConfig = apply {
        if (validated) {
            return@apply
        }

        format().ifPresent { it.validate() }
        verbosity().ifPresent { it.validate() }
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
        (format.asKnown().getOrNull()?.validity() ?: 0) +
            (verbosity.asKnown().getOrNull()?.validity() ?: 0)

    /**
     * Constrains the verbosity of the model's response. Lower values will result in more concise
     * responses, while higher values will result in more verbose responses. Currently supported
     * values are `low`, `medium`, and `high`.
     */
    class Verbosity @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val LOW = of("low")

            @JvmField val MEDIUM = of("medium")

            @JvmField val HIGH = of("high")

            @JvmStatic fun of(value: String) = Verbosity(JsonField.of(value))
        }

        /** An enum containing [Verbosity]'s known values. */
        enum class Known {
            LOW,
            MEDIUM,
            HIGH,
        }

        /**
         * An enum containing [Verbosity]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Verbosity] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            LOW,
            MEDIUM,
            HIGH,
            /**
             * An enum member indicating that [Verbosity] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                LOW -> Value.LOW
                MEDIUM -> Value.MEDIUM
                HIGH -> Value.HIGH
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws OpenAIInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                LOW -> Known.LOW
                MEDIUM -> Known.MEDIUM
                HIGH -> Known.HIGH
                else -> throw OpenAIInvalidDataException("Unknown Verbosity: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws OpenAIInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { OpenAIInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

        fun validate(): Verbosity = apply {
            if (validated) {
                return@apply
            }

            known()
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
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Verbosity && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ResponseTextConfig &&
            format == other.format &&
            verbosity == other.verbosity &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(format, verbosity, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseTextConfig{format=$format, verbosity=$verbosity, additionalProperties=$additionalProperties}"
}
