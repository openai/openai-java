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
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Hosted or BYOT tool search configuration for deferred tools. */
class ToolSearchTool
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val type: JsonValue,
    private val description: JsonField<String>,
    private val execution: JsonField<Execution>,
    private val parameters: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("description")
        @ExcludeMissing
        description: JsonField<String> = JsonMissing.of(),
        @JsonProperty("execution")
        @ExcludeMissing
        execution: JsonField<Execution> = JsonMissing.of(),
        @JsonProperty("parameters") @ExcludeMissing parameters: JsonValue = JsonMissing.of(),
    ) : this(type, description, execution, parameters, mutableMapOf())

    /**
     * The type of the tool. Always `tool_search`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("tool_search")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Description shown to the model for a client-executed tool search tool.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun description(): Optional<String> = description.getOptional("description")

    /**
     * Whether tool search is executed by the server or by the client.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun execution(): Optional<Execution> = execution.getOptional("execution")

    /**
     * Parameter schema for a client-executed tool search tool.
     *
     * This arbitrary value can be deserialized into a custom type using the `convert` method:
     * ```java
     * MyClass myObject = toolSearchTool.parameters().convert(MyClass.class);
     * ```
     */
    @JsonProperty("parameters") @ExcludeMissing fun _parameters(): JsonValue = parameters

    /**
     * Returns the raw JSON value of [description].
     *
     * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("description") @ExcludeMissing fun _description(): JsonField<String> = description

    /**
     * Returns the raw JSON value of [execution].
     *
     * Unlike [execution], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("execution") @ExcludeMissing fun _execution(): JsonField<Execution> = execution

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

        /** Returns a mutable builder for constructing an instance of [ToolSearchTool]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ToolSearchTool]. */
    class Builder internal constructor() {

        private var type: JsonValue = JsonValue.from("tool_search")
        private var description: JsonField<String> = JsonMissing.of()
        private var execution: JsonField<Execution> = JsonMissing.of()
        private var parameters: JsonValue = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(toolSearchTool: ToolSearchTool) = apply {
            type = toolSearchTool.type
            description = toolSearchTool.description
            execution = toolSearchTool.execution
            parameters = toolSearchTool.parameters
            additionalProperties = toolSearchTool.additionalProperties.toMutableMap()
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("tool_search")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** Description shown to the model for a client-executed tool search tool. */
        fun description(description: String?) = description(JsonField.ofNullable(description))

        /** Alias for calling [Builder.description] with `description.orElse(null)`. */
        fun description(description: Optional<String>) = description(description.getOrNull())

        /**
         * Sets [Builder.description] to an arbitrary JSON value.
         *
         * You should usually call [Builder.description] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun description(description: JsonField<String>) = apply { this.description = description }

        /** Whether tool search is executed by the server or by the client. */
        fun execution(execution: Execution) = execution(JsonField.of(execution))

        /**
         * Sets [Builder.execution] to an arbitrary JSON value.
         *
         * You should usually call [Builder.execution] with a well-typed [Execution] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun execution(execution: JsonField<Execution>) = apply { this.execution = execution }

        /** Parameter schema for a client-executed tool search tool. */
        fun parameters(parameters: JsonValue) = apply { this.parameters = parameters }

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
         * Returns an immutable instance of [ToolSearchTool].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ToolSearchTool =
            ToolSearchTool(
                type,
                description,
                execution,
                parameters,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ToolSearchTool = apply {
        if (validated) {
            return@apply
        }

        _type().let {
            if (it != JsonValue.from("tool_search")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        description()
        execution().ifPresent { it.validate() }
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
        type.let { if (it == JsonValue.from("tool_search")) 1 else 0 } +
            (if (description.asKnown().isPresent) 1 else 0) +
            (execution.asKnown().getOrNull()?.validity() ?: 0)

    /** Whether tool search is executed by the server or by the client. */
    class Execution @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val SERVER = of("server")

            @JvmField val CLIENT = of("client")

            @JvmStatic fun of(value: String) = Execution(JsonField.of(value))
        }

        /** An enum containing [Execution]'s known values. */
        enum class Known {
            SERVER,
            CLIENT,
        }

        /**
         * An enum containing [Execution]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Execution] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            SERVER,
            CLIENT,
            /**
             * An enum member indicating that [Execution] was instantiated with an unknown value.
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
                SERVER -> Value.SERVER
                CLIENT -> Value.CLIENT
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
                SERVER -> Known.SERVER
                CLIENT -> Known.CLIENT
                else -> throw OpenAIInvalidDataException("Unknown Execution: $value")
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

        fun validate(): Execution = apply {
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

            return other is Execution && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ToolSearchTool &&
            type == other.type &&
            description == other.description &&
            execution == other.execution &&
            parameters == other.parameters &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(type, description, execution, parameters, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ToolSearchTool{type=$type, description=$description, execution=$execution, parameters=$parameters, additionalProperties=$additionalProperties}"
}
