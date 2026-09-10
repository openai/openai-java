// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

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
import java.util.Collections
import java.util.Objects

/**
 * Cumulative audio duration for a Live session. Values are totals for the session, not increments
 * to sum across usage events.
 */
class SessionUsage
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val seconds: JsonField<Double>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("seconds") @ExcludeMissing seconds: JsonField<Double> = JsonMissing.of()
    ) : this(seconds, mutableMapOf())

    /**
     * The cumulative Live audio duration in seconds. Do not sum this value across usage events.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun seconds(): Double = seconds.getRequired("seconds")

    /**
     * Returns the raw JSON value of [seconds].
     *
     * Unlike [seconds], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("seconds") @ExcludeMissing fun _seconds(): JsonField<Double> = seconds

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
         * Returns a mutable builder for constructing an instance of [SessionUsage].
         *
         * The following fields are required:
         * ```java
         * .seconds()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SessionUsage]. */
    class Builder internal constructor() {

        private var seconds: JsonField<Double>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(sessionUsage: SessionUsage) = apply {
            seconds = sessionUsage.seconds
            additionalProperties = sessionUsage.additionalProperties.toMutableMap()
        }

        /**
         * The cumulative Live audio duration in seconds. Do not sum this value across usage events.
         */
        fun seconds(seconds: Double) = seconds(JsonField.of(seconds))

        /**
         * Sets [Builder.seconds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.seconds] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun seconds(seconds: JsonField<Double>) = apply { this.seconds = seconds }

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
         * Returns an immutable instance of [SessionUsage].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .seconds()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SessionUsage =
            SessionUsage(checkRequired("seconds", seconds), additionalProperties.toMutableMap())
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
    fun validate(): SessionUsage = apply {
        if (validated) {
            return@apply
        }

        seconds()
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
    @JvmSynthetic internal fun validity(): Int = (if (seconds.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SessionUsage &&
            seconds == other.seconds &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(seconds, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SessionUsage{seconds=$seconds, additionalProperties=$additionalProperties}"
}
