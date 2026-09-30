// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

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

class AgentBrowserOriginAccessParam
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val decision: JsonField<Decision>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("decision") @ExcludeMissing decision: JsonField<Decision> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(decision, type, mutableMapOf())

    /**
     * Whether to allow, deny, or cancel the requested origin access.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun decision(): Decision = decision.getRequired("decision")

    /**
     * Expected to always return the following:
     * ```java
     * JsonValue.from("browser_origin_access")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [decision].
     *
     * Unlike [decision], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("decision") @ExcludeMissing fun _decision(): JsonField<Decision> = decision

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
         * Returns a mutable builder for constructing an instance of
         * [AgentBrowserOriginAccessParam].
         *
         * The following fields are required:
         * ```java
         * .decision()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AgentBrowserOriginAccessParam]. */
    class Builder internal constructor() {

        private var decision: JsonField<Decision>? = null
        private var type: JsonValue = JsonValue.from("browser_origin_access")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(agentBrowserOriginAccessParam: AgentBrowserOriginAccessParam) = apply {
            decision = agentBrowserOriginAccessParam.decision
            type = agentBrowserOriginAccessParam.type
            additionalProperties = agentBrowserOriginAccessParam.additionalProperties.toMutableMap()
        }

        /** Whether to allow, deny, or cancel the requested origin access. */
        fun decision(decision: Decision) = decision(JsonField.of(decision))

        /**
         * Sets [Builder.decision] to an arbitrary JSON value.
         *
         * You should usually call [Builder.decision] with a well-typed [Decision] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun decision(decision: JsonField<Decision>) = apply { this.decision = decision }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("browser_origin_access")
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
         * Returns an immutable instance of [AgentBrowserOriginAccessParam].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .decision()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AgentBrowserOriginAccessParam =
            AgentBrowserOriginAccessParam(
                checkRequired("decision", decision),
                type,
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
    fun validate(): AgentBrowserOriginAccessParam = apply {
        if (validated) {
            return@apply
        }

        decision().validate()
        _type().let {
            if (it != JsonValue.from("browser_origin_access")) {
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
        (decision.asKnown().getOrNull()?.validity() ?: 0) +
            type.let { if (it == JsonValue.from("browser_origin_access")) 1 else 0 }

    /** Whether to allow, deny, or cancel the requested origin access. */
    class Decision @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            /** Allow the browser to access this origin. */
            @JvmField val APPROVE = of("approve")

            /** Deny access to this origin. */
            @JvmField val DENY = of("deny")

            /** Dismiss this request without approving access. */
            @JvmField val CANCEL = of("cancel")

            @JvmStatic fun of(value: String) = Decision(JsonField.of(value))
        }

        /** An enum containing [Decision]'s known values. */
        enum class Known {
            /** Allow the browser to access this origin. */
            APPROVE,
            /** Deny access to this origin. */
            DENY,
            /** Dismiss this request without approving access. */
            CANCEL,
        }

        /**
         * An enum containing [Decision]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Decision] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            /** Allow the browser to access this origin. */
            APPROVE,
            /** Deny access to this origin. */
            DENY,
            /** Dismiss this request without approving access. */
            CANCEL,
            /** An enum member indicating that [Decision] was instantiated with an unknown value. */
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
                APPROVE -> Value.APPROVE
                DENY -> Value.DENY
                CANCEL -> Value.CANCEL
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
                APPROVE -> Known.APPROVE
                DENY -> Known.DENY
                CANCEL -> Known.CANCEL
                else -> throw OpenAIInvalidDataException("Unknown Decision: $value")
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
        fun validate(): Decision = apply {
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

            return other is Decision && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AgentBrowserOriginAccessParam &&
            decision == other.decision &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(decision, type, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AgentBrowserOriginAccessParam{decision=$decision, type=$type, additionalProperties=$additionalProperties}"
}
