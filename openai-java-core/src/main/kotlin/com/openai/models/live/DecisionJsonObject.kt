// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.ExcludeMissing
import com.openai.core.JsonValue
import com.openai.core.collectAllProperties
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects

class DecisionJsonObject
@JsonCreator
private constructor(
    @com.fasterxml.jackson.annotation.JsonValue
    private val additionalProperties: Map<String, JsonValue>
) {

    /**
     * Returns an immutable snapshot of all present JSON properties, including declared and
     * additional properties.
     *
     * Keys use their JSON names. Declared properties take precedence over additional properties
     * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
     * values are preserved.
     */
    fun _allProperties(): Map<String, JsonValue> = collectAllProperties(additionalProperties)

    @JvmSynthetic
    internal fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    @JsonAnyGetter
    @ExcludeMissing
    private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun toBuilder() = Builder().from(this)

    companion object {

        /** Returns a mutable builder for constructing an instance of [DecisionJsonObject]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [DecisionJsonObject]. */
    class Builder internal constructor() {

        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(decisionJsonObject: DecisionJsonObject) = apply {
            additionalProperties = decisionJsonObject.additionalProperties.toMutableMap()
        }

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
         * Returns an immutable instance of [DecisionJsonObject].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): DecisionJsonObject = DecisionJsonObject(additionalProperties.toImmutable())
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
    fun validate(): DecisionJsonObject = apply {
        if (validated) {
            return@apply
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
        additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is DecisionJsonObject && additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() = "DecisionJsonObject{additionalProperties=$additionalProperties}"
}
