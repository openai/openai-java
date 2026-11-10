// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.automations.invocations

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.core.collectAllProperties
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.beta.agents.automations.Automation
import com.openai.models.beta.agents.automations.OneTimeAutomation
import com.openai.models.beta.agents.automations.PeriodicAutomation
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

class AutomationInvocationSourceAutomation
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val automation: JsonField<Automation>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("automation")
        @ExcludeMissing
        automation: JsonField<Automation> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(automation, type, mutableMapOf())

    /**
     * The automation snapshot for this occurrence, excluding confidential values.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun automation(): Automation = automation.getRequired("automation")

    /**
     * The type of the object. Always `automation`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("automation")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [automation].
     *
     * Unlike [automation], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("automation")
    @ExcludeMissing
    fun _automation(): JsonField<Automation> = automation

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
            "automation" to this.automation,
            "type" to this.type,
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
         * Returns a mutable builder for constructing an instance of
         * [AutomationInvocationSourceAutomation].
         *
         * The following fields are required:
         * ```java
         * .automation()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AutomationInvocationSourceAutomation]. */
    class Builder internal constructor() {

        private var automation: JsonField<Automation>? = null
        private var type: JsonValue = JsonValue.from("automation")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            automationInvocationSourceAutomation: AutomationInvocationSourceAutomation
        ) = apply {
            automation = automationInvocationSourceAutomation.automation
            type = automationInvocationSourceAutomation.type
            additionalProperties =
                automationInvocationSourceAutomation.additionalProperties.toMutableMap()
        }

        /** The automation snapshot for this occurrence, excluding confidential values. */
        fun automation(automation: Automation) = automation(JsonField.of(automation))

        /**
         * Sets [Builder.automation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.automation] with a well-typed [Automation] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun automation(automation: JsonField<Automation>) = apply { this.automation = automation }

        /** Alias for calling [automation] with `Automation.ofPeriodic(periodic)`. */
        fun automation(periodic: PeriodicAutomation) = automation(Automation.ofPeriodic(periodic))

        /** Alias for calling [automation] with `Automation.ofOnce(once)`. */
        fun automation(once: OneTimeAutomation) = automation(Automation.ofOnce(once))

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("automation")
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
         * Returns an immutable instance of [AutomationInvocationSourceAutomation].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .automation()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AutomationInvocationSourceAutomation =
            AutomationInvocationSourceAutomation(
                checkRequired("automation", automation),
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
    fun validate(): AutomationInvocationSourceAutomation = apply {
        if (validated) {
            return@apply
        }

        automation().validate()
        _type().let {
            if (it != JsonValue.from("automation")) {
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
        (automation.asKnown().getOrNull()?.validity() ?: 0) +
            type.let { if (it == JsonValue.from("automation")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AutomationInvocationSourceAutomation &&
            automation == other.automation &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(automation, type, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AutomationInvocationSourceAutomation{automation=$automation, type=$type, additionalProperties=$additionalProperties}"
}
