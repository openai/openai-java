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
import com.openai.core.collectAllProperties
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional

/**
 * Cumulative billable duration for a Live session. Eligible WebRTC sessions also report the active
 * and paused breakdown. Do not sum values across usage events.
 */
class SessionUsage
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val seconds: JsonField<Double>,
    private val activeSeconds: JsonField<Long>,
    private val pausedSeconds: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("seconds") @ExcludeMissing seconds: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("active_seconds")
        @ExcludeMissing
        activeSeconds: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("paused_seconds")
        @ExcludeMissing
        pausedSeconds: JsonField<Long> = JsonMissing.of(),
    ) : this(seconds, activeSeconds, pausedSeconds, mutableMapOf())

    /**
     * The cumulative billable duration in whole seconds. When present, the active and paused
     * breakdown adds up to this total.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun seconds(): Double = seconds.getRequired("seconds")

    /**
     * The remaining billable seconds attributed to active audio and any unused prepaid duration.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun activeSeconds(): Optional<Long> = activeSeconds.getOptional("active_seconds")

    /**
     * Billable time attributed to paused inference at the configured rate, rounded down to whole
     * seconds.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun pausedSeconds(): Optional<Long> = pausedSeconds.getOptional("paused_seconds")

    /**
     * Returns the raw JSON value of [seconds].
     *
     * Unlike [seconds], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("seconds") @ExcludeMissing fun _seconds(): JsonField<Double> = seconds

    /**
     * Returns the raw JSON value of [activeSeconds].
     *
     * Unlike [activeSeconds], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("active_seconds")
    @ExcludeMissing
    fun _activeSeconds(): JsonField<Long> = activeSeconds

    /**
     * Returns the raw JSON value of [pausedSeconds].
     *
     * Unlike [pausedSeconds], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("paused_seconds")
    @ExcludeMissing
    fun _pausedSeconds(): JsonField<Long> = pausedSeconds

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
            "seconds" to this.seconds,
            "active_seconds" to this.activeSeconds,
            "paused_seconds" to this.pausedSeconds,
        )

    /**
     * Returns the legacy additional-properties view.
     *
     * @deprecated Use [_allProperties] to access both declared and additional JSON properties. This
     *   accessor retains its legacy additional-properties behavior.
     */
    @Deprecated("Use _allProperties() to access both declared and additional JSON properties.")
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
        private var activeSeconds: JsonField<Long> = JsonMissing.of()
        private var pausedSeconds: JsonField<Long> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(sessionUsage: SessionUsage) = apply {
            seconds = sessionUsage.seconds
            activeSeconds = sessionUsage.activeSeconds
            pausedSeconds = sessionUsage.pausedSeconds
            additionalProperties = sessionUsage.additionalProperties.toMutableMap()
        }

        /**
         * The cumulative billable duration in whole seconds. When present, the active and paused
         * breakdown adds up to this total.
         */
        fun seconds(seconds: Double) = seconds(JsonField.of(seconds))

        /**
         * Sets [Builder.seconds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.seconds] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun seconds(seconds: JsonField<Double>) = apply { this.seconds = seconds }

        /**
         * The remaining billable seconds attributed to active audio and any unused prepaid
         * duration.
         */
        fun activeSeconds(activeSeconds: Long) = activeSeconds(JsonField.of(activeSeconds))

        /**
         * Sets [Builder.activeSeconds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.activeSeconds] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun activeSeconds(activeSeconds: JsonField<Long>) = apply {
            this.activeSeconds = activeSeconds
        }

        /**
         * Billable time attributed to paused inference at the configured rate, rounded down to
         * whole seconds.
         */
        fun pausedSeconds(pausedSeconds: Long) = pausedSeconds(JsonField.of(pausedSeconds))

        /**
         * Sets [Builder.pausedSeconds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.pausedSeconds] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun pausedSeconds(pausedSeconds: JsonField<Long>) = apply {
            this.pausedSeconds = pausedSeconds
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
            SessionUsage(
                checkRequired("seconds", seconds),
                activeSeconds,
                pausedSeconds,
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
    fun validate(): SessionUsage = apply {
        if (validated) {
            return@apply
        }

        seconds()
        activeSeconds()
        pausedSeconds()
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
        (if (seconds.asKnown().isPresent) 1 else 0) +
            (if (activeSeconds.asKnown().isPresent) 1 else 0) +
            (if (pausedSeconds.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SessionUsage &&
            seconds == other.seconds &&
            activeSeconds == other.activeSeconds &&
            pausedSeconds == other.pausedSeconds &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(seconds, activeSeconds, pausedSeconds, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SessionUsage{seconds=$seconds, activeSeconds=$activeSeconds, pausedSeconds=$pausedSeconds, additionalProperties=$additionalProperties}"
}
