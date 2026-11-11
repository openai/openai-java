// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

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
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.collectAllProperties
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.CustomToolInputFormat
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * A custom tool that processes input using a specified format. Learn more about
 * [custom tools](https://developers.openai.com/api/docs/guides/function-calling#custom-tools)
 */
class CustomTool
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val name: JsonField<String>,
    private val type: JsonValue,
    private val allowedCallers: JsonField<List<AllowedCaller>>,
    private val async: JsonField<Boolean>,
    private val deferLoading: JsonField<Boolean>,
    private val description: JsonField<String>,
    private val format: JsonField<CustomToolInputFormat>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("allowed_callers")
        @ExcludeMissing
        allowedCallers: JsonField<List<AllowedCaller>> = JsonMissing.of(),
        @JsonProperty("async") @ExcludeMissing async: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("defer_loading")
        @ExcludeMissing
        deferLoading: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("description")
        @ExcludeMissing
        description: JsonField<String> = JsonMissing.of(),
        @JsonProperty("format")
        @ExcludeMissing
        format: JsonField<CustomToolInputFormat> = JsonMissing.of(),
    ) : this(name, type, allowedCallers, async, deferLoading, description, format, mutableMapOf())

    /**
     * The name of the custom tool, used to identify it in tool calls. The schema requires this
     * property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun name(): java.util.Optional<String> = name.getOptional("name")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun nameOrThrow(): String = name.getRequired("name")

    /**
     * The type of the custom tool. Always `custom`. The schema requires this property. Returns
     * empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun type(): java.util.Optional<JsonValue> {
        val raw = type
        return when {
            raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
            !(raw == JsonValue.from("custom")) ->
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
     * The tool invocation context(s). Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun allowedCallers(): java.util.Optional<List<AllowedCaller>> =
        allowedCallers.getOptional("allowed_callers")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun allowedCallersOrThrow(): List<AllowedCaller> = allowedCallers.getRequired("allowed_callers")

    /**
     * Whether the tool response can be returned asynchronously versus immediately returned on next
     * response creation. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun async(): java.util.Optional<Boolean> = async.getOptional("async")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun asyncOrThrow(): Boolean = async.getRequired("async")

    /**
     * Whether this tool should be deferred and discovered via tool search. Returns empty if the
     * JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun deferLoading(): java.util.Optional<Boolean> = deferLoading.getOptional("defer_loading")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun deferLoadingOrThrow(): Boolean = deferLoading.getRequired("defer_loading")

    /**
     * Optional description of the custom tool, used to provide more context. Returns empty if the
     * JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun description(): java.util.Optional<String> = description.getOptional("description")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun descriptionOrThrow(): String = description.getRequired("description")

    /**
     * The input format for the custom tool. Default is unconstrained text. Returns empty if the
     * JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun format(): java.util.Optional<CustomToolInputFormat> = format.getOptional("format")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun formatOrThrow(): CustomToolInputFormat = format.getRequired("format")

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [allowedCallers].
     *
     * Unlike [allowedCallers], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("allowed_callers")
    @ExcludeMissing
    fun _allowedCallers(): JsonField<List<AllowedCaller>> = allowedCallers

    /**
     * Returns the raw JSON value of [async].
     *
     * Unlike [async], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("async") @ExcludeMissing fun _async(): JsonField<Boolean> = async

    /**
     * Returns the raw JSON value of [deferLoading].
     *
     * Unlike [deferLoading], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("defer_loading")
    @ExcludeMissing
    fun _deferLoading(): JsonField<Boolean> = deferLoading

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
            "name" to this.name,
            "type" to this.type,
            "allowed_callers" to this.allowedCallers,
            "async" to this.async,
            "defer_loading" to this.deferLoading,
            "description" to this.description,
            "format" to this.format,
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
        private var allowedCallers: JsonField<MutableList<AllowedCaller>>? = null
        private var async: JsonField<Boolean> = JsonMissing.of()
        private var deferLoading: JsonField<Boolean> = JsonMissing.of()
        private var description: JsonField<String> = JsonMissing.of()
        private var format: JsonField<CustomToolInputFormat> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(customTool: CustomTool) = apply {
            name = customTool.name
            type = customTool.type
            allowedCallers = customTool.allowedCallers.map { it.toMutableList() }
            async = customTool.async
            deferLoading = customTool.deferLoading
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

        /** The tool invocation context(s). */
        fun allowedCallers(allowedCallers: List<AllowedCaller>?) =
            allowedCallers(JsonField.ofNullable(allowedCallers))

        /** Alias for calling [Builder.allowedCallers] with `allowedCallers.orElse(null)`. */
        fun allowedCallers(allowedCallers: Optional<List<AllowedCaller>>) =
            allowedCallers(allowedCallers.getOrNull())

        /**
         * Sets [Builder.allowedCallers] to an arbitrary JSON value.
         *
         * You should usually call [Builder.allowedCallers] with a well-typed `List<AllowedCaller>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun allowedCallers(allowedCallers: JsonField<List<AllowedCaller>>) = apply {
            this.allowedCallers = allowedCallers.map { it.toMutableList() }
        }

        /**
         * Adds a single [AllowedCaller] to [allowedCallers].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addAllowedCaller(allowedCaller: AllowedCaller) = apply {
            allowedCallers =
                (allowedCallers?.takeUnless { it.isMissing() } ?: JsonField.of(mutableListOf()))
                    .also { checkKnown("allowedCallers", it).add(allowedCaller) }
        }

        /**
         * Whether the tool response can be returned asynchronously versus immediately returned on
         * next response creation.
         */
        fun async(async: Boolean) = async(JsonField.of(async))

        /**
         * Sets [Builder.async] to an arbitrary JSON value.
         *
         * You should usually call [Builder.async] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun async(async: JsonField<Boolean>) = apply { this.async = async }

        /** Whether this tool should be deferred and discovered via tool search. */
        fun deferLoading(deferLoading: Boolean) = deferLoading(JsonField.of(deferLoading))

        /**
         * Sets [Builder.deferLoading] to an arbitrary JSON value.
         *
         * You should usually call [Builder.deferLoading] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun deferLoading(deferLoading: JsonField<Boolean>) = apply {
            this.deferLoading = deferLoading
        }

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
                (allowedCallers ?: JsonMissing.of()).map { it.toImmutable() },
                async,
                deferLoading,
                description,
                format,
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
    fun validate(): CustomTool = apply {
        if (validated) {
            return@apply
        }

        nameOrThrow()
        typeOrThrow()
        allowedCallers().ifPresent { it.forEach { it.validate() } }
        async()
        deferLoading()
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
            (allowedCallers.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (async.asKnown().isPresent) 1 else 0) +
            (if (deferLoading.asKnown().isPresent) 1 else 0) +
            (if (description.asKnown().isPresent) 1 else 0) +
            (format.asKnown().getOrNull()?.validity() ?: 0)

    class AllowedCaller @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

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

            @JvmField val DIRECT = of("direct")

            @JvmField val PROGRAMMATIC = of("programmatic")

            @JvmStatic fun of(value: String) = AllowedCaller(JsonField.of(value))
        }

        /** An enum containing [AllowedCaller]'s known values. */
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
        enum class Known {
            DIRECT,
            PROGRAMMATIC,
        }

        /**
         * An enum containing [AllowedCaller]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [AllowedCaller] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
        enum class Value {
            DIRECT,
            PROGRAMMATIC,
            /**
             * An enum member indicating that [AllowedCaller] was instantiated with an unknown
             * value.
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
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
        fun value(): Value =
            when (this) {
                DIRECT -> Value.DIRECT
                PROGRAMMATIC -> Value.PROGRAMMATIC
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
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
        fun known(): Known =
            when (this) {
                DIRECT -> Known.DIRECT
                PROGRAMMATIC -> Known.PROGRAMMATIC
                else -> throw OpenAIInvalidDataException("Unknown AllowedCaller: $value")
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

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): AllowedCaller = apply {
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

            return other is AllowedCaller && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CustomTool &&
            name == other.name &&
            type == other.type &&
            allowedCallers == other.allowedCallers &&
            async == other.async &&
            deferLoading == other.deferLoading &&
            description == other.description &&
            format == other.format &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            name,
            type,
            allowedCallers,
            async,
            deferLoading,
            description,
            format,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CustomTool{name=$name, type=$type, allowedCallers=$allowedCallers, async=$async, deferLoading=$deferLoading, description=$description, format=$format, additionalProperties=$additionalProperties}"
}
