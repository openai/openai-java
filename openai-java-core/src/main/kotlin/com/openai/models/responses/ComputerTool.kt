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
import com.openai.core.checkRequired
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/**
 * A tool that controls a virtual computer. Learn more about the
 * [computer tool](https://platform.openai.com/docs/guides/tools-computer-use).
 */
class ComputerTool
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val displayHeight: JsonField<Long>,
    private val displayWidth: JsonField<Long>,
    private val environment: JsonField<Environment>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("display_height")
        @ExcludeMissing
        displayHeight: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("display_width")
        @ExcludeMissing
        displayWidth: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("environment")
        @ExcludeMissing
        environment: JsonField<Environment> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(displayHeight, displayWidth, environment, type, mutableMapOf())

    /**
     * The height of the computer display.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun displayHeight(): Long = displayHeight.getRequired("display_height")

    /**
     * The width of the computer display.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun displayWidth(): Long = displayWidth.getRequired("display_width")

    /**
     * The type of computer environment to control.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun environment(): Environment = environment.getRequired("environment")

    /**
     * The type of the computer use tool. Always `computer_use_preview`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("computer_use_preview")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [displayHeight].
     *
     * Unlike [displayHeight], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("display_height")
    @ExcludeMissing
    fun _displayHeight(): JsonField<Long> = displayHeight

    /**
     * Returns the raw JSON value of [displayWidth].
     *
     * Unlike [displayWidth], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("display_width")
    @ExcludeMissing
    fun _displayWidth(): JsonField<Long> = displayWidth

    /**
     * Returns the raw JSON value of [environment].
     *
     * Unlike [environment], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("environment")
    @ExcludeMissing
    fun _environment(): JsonField<Environment> = environment

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
         * Returns a mutable builder for constructing an instance of [ComputerTool].
         *
         * The following fields are required:
         * ```java
         * .displayHeight()
         * .displayWidth()
         * .environment()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ComputerTool]. */
    class Builder internal constructor() {

        private var displayHeight: JsonField<Long>? = null
        private var displayWidth: JsonField<Long>? = null
        private var environment: JsonField<Environment>? = null
        private var type: JsonValue = JsonValue.from("computer_use_preview")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(computerTool: ComputerTool) = apply {
            displayHeight = computerTool.displayHeight
            displayWidth = computerTool.displayWidth
            environment = computerTool.environment
            type = computerTool.type
            additionalProperties = computerTool.additionalProperties.toMutableMap()
        }

        /** The height of the computer display. */
        fun displayHeight(displayHeight: Long) = displayHeight(JsonField.of(displayHeight))

        /**
         * Sets [Builder.displayHeight] to an arbitrary JSON value.
         *
         * You should usually call [Builder.displayHeight] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun displayHeight(displayHeight: JsonField<Long>) = apply {
            this.displayHeight = displayHeight
        }

        /** The width of the computer display. */
        fun displayWidth(displayWidth: Long) = displayWidth(JsonField.of(displayWidth))

        /**
         * Sets [Builder.displayWidth] to an arbitrary JSON value.
         *
         * You should usually call [Builder.displayWidth] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun displayWidth(displayWidth: JsonField<Long>) = apply { this.displayWidth = displayWidth }

        /** The type of computer environment to control. */
        fun environment(environment: Environment) = environment(JsonField.of(environment))

        /**
         * Sets [Builder.environment] to an arbitrary JSON value.
         *
         * You should usually call [Builder.environment] with a well-typed [Environment] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun environment(environment: JsonField<Environment>) = apply {
            this.environment = environment
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("computer_use_preview")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

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
         * Returns an immutable instance of [ComputerTool].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .displayHeight()
         * .displayWidth()
         * .environment()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ComputerTool =
            ComputerTool(
                checkRequired("displayHeight", displayHeight),
                checkRequired("displayWidth", displayWidth),
                checkRequired("environment", environment),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ComputerTool = apply {
        if (validated) {
            return@apply
        }

        displayHeight()
        displayWidth()
        environment().validate()
        _type().let {
            if (it != JsonValue.from("computer_use_preview")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
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
        (if (displayHeight.asKnown().isPresent) 1 else 0) +
            (if (displayWidth.asKnown().isPresent) 1 else 0) +
            (environment.asKnown().getOrNull()?.validity() ?: 0) +
            type.let { if (it == JsonValue.from("computer_use_preview")) 1 else 0 }

    /** The type of computer environment to control. */
    class Environment @JsonCreator private constructor(private val value: JsonField<String>) :
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

            @JvmField val WINDOWS = of("windows")

            @JvmField val MAC = of("mac")

            @JvmField val LINUX = of("linux")

            @JvmField val UBUNTU = of("ubuntu")

            @JvmField val BROWSER = of("browser")

            @JvmStatic fun of(value: String) = Environment(JsonField.of(value))
        }

        /** An enum containing [Environment]'s known values. */
        enum class Known {
            WINDOWS,
            MAC,
            LINUX,
            UBUNTU,
            BROWSER,
        }

        /**
         * An enum containing [Environment]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Environment] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            WINDOWS,
            MAC,
            LINUX,
            UBUNTU,
            BROWSER,
            /**
             * An enum member indicating that [Environment] was instantiated with an unknown value.
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
                WINDOWS -> Value.WINDOWS
                MAC -> Value.MAC
                LINUX -> Value.LINUX
                UBUNTU -> Value.UBUNTU
                BROWSER -> Value.BROWSER
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
                WINDOWS -> Known.WINDOWS
                MAC -> Known.MAC
                LINUX -> Known.LINUX
                UBUNTU -> Known.UBUNTU
                BROWSER -> Known.BROWSER
                else -> throw OpenAIInvalidDataException("Unknown Environment: $value")
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

        fun validate(): Environment = apply {
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

            return other is Environment && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ComputerTool &&
            displayHeight == other.displayHeight &&
            displayWidth == other.displayWidth &&
            environment == other.environment &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(displayHeight, displayWidth, environment, type, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ComputerTool{displayHeight=$displayHeight, displayWidth=$displayWidth, environment=$environment, type=$type, additionalProperties=$additionalProperties}"
}
