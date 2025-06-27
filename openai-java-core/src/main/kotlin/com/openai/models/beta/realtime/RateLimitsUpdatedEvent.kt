// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime

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
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Emitted at the beginning of a Response to indicate the updated rate limits. When a Response is
 * created some tokens will be "reserved" for the output tokens, the rate limits shown here reflect
 * that reservation, which is then adjusted accordingly once the Response is completed.
 */
class RateLimitsUpdatedEvent
private constructor(
    private val eventId: JsonField<String>,
    private val rateLimits: JsonField<List<RateLimit>>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("rate_limits")
        @ExcludeMissing
        rateLimits: JsonField<List<RateLimit>> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(eventId, rateLimits, type, mutableMapOf())

    /**
     * The unique ID of the server event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun eventId(): String = eventId.getRequired("event_id")

    /**
     * List of rate limit information.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun rateLimits(): List<RateLimit> = rateLimits.getRequired("rate_limits")

    /**
     * The event type, must be `rate_limits.updated`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("rate_limits.updated")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [eventId].
     *
     * Unlike [eventId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("event_id") @ExcludeMissing fun _eventId(): JsonField<String> = eventId

    /**
     * Returns the raw JSON value of [rateLimits].
     *
     * Unlike [rateLimits], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("rate_limits")
    @ExcludeMissing
    fun _rateLimits(): JsonField<List<RateLimit>> = rateLimits

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
         * Returns a mutable builder for constructing an instance of [RateLimitsUpdatedEvent].
         *
         * The following fields are required:
         * ```java
         * .eventId()
         * .rateLimits()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RateLimitsUpdatedEvent]. */
    class Builder internal constructor() {

        private var eventId: JsonField<String>? = null
        private var rateLimits: JsonField<MutableList<RateLimit>>? = null
        private var type: JsonValue = JsonValue.from("rate_limits.updated")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(rateLimitsUpdatedEvent: RateLimitsUpdatedEvent) = apply {
            eventId = rateLimitsUpdatedEvent.eventId
            rateLimits = rateLimitsUpdatedEvent.rateLimits.map { it.toMutableList() }
            type = rateLimitsUpdatedEvent.type
            additionalProperties = rateLimitsUpdatedEvent.additionalProperties.toMutableMap()
        }

        /** The unique ID of the server event. */
        fun eventId(eventId: String) = eventId(JsonField.of(eventId))

        /**
         * Sets [Builder.eventId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun eventId(eventId: JsonField<String>) = apply { this.eventId = eventId }

        /** List of rate limit information. */
        fun rateLimits(rateLimits: List<RateLimit>) = rateLimits(JsonField.of(rateLimits))

        /**
         * Sets [Builder.rateLimits] to an arbitrary JSON value.
         *
         * You should usually call [Builder.rateLimits] with a well-typed `List<RateLimit>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun rateLimits(rateLimits: JsonField<List<RateLimit>>) = apply {
            this.rateLimits = rateLimits.map { it.toMutableList() }
        }

        /**
         * Adds a single [RateLimit] to [rateLimits].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addRateLimit(rateLimit: RateLimit) = apply {
            rateLimits =
                (rateLimits ?: JsonField.of(mutableListOf())).also {
                    checkKnown("rateLimits", it).add(rateLimit)
                }
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("rate_limits.updated")
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
         * Returns an immutable instance of [RateLimitsUpdatedEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .eventId()
         * .rateLimits()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): RateLimitsUpdatedEvent =
            RateLimitsUpdatedEvent(
                checkRequired("eventId", eventId),
                checkRequired("rateLimits", rateLimits).map { it.toImmutable() },
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): RateLimitsUpdatedEvent = apply {
        if (validated) {
            return@apply
        }

        eventId()
        rateLimits().forEach { it.validate() }
        _type().let {
            if (it != JsonValue.from("rate_limits.updated")) {
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
        (if (eventId.asKnown().isPresent) 1 else 0) +
            (rateLimits.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            type.let { if (it == JsonValue.from("rate_limits.updated")) 1 else 0 }

    class RateLimit
    private constructor(
        private val limit: JsonField<Long>,
        private val name: JsonField<Name>,
        private val remaining: JsonField<Long>,
        private val resetSeconds: JsonField<Double>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("limit") @ExcludeMissing limit: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<Name> = JsonMissing.of(),
            @JsonProperty("remaining")
            @ExcludeMissing
            remaining: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("reset_seconds")
            @ExcludeMissing
            resetSeconds: JsonField<Double> = JsonMissing.of(),
        ) : this(limit, name, remaining, resetSeconds, mutableMapOf())

        /**
         * The maximum allowed value for the rate limit.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun limit(): Optional<Long> = limit.getOptional("limit")

        /**
         * The name of the rate limit (`requests`, `tokens`).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun name(): Optional<Name> = name.getOptional("name")

        /**
         * The remaining value before the limit is reached.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun remaining(): Optional<Long> = remaining.getOptional("remaining")

        /**
         * Seconds until the rate limit resets.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun resetSeconds(): Optional<Double> = resetSeconds.getOptional("reset_seconds")

        /**
         * Returns the raw JSON value of [limit].
         *
         * Unlike [limit], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("limit") @ExcludeMissing fun _limit(): JsonField<Long> = limit

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<Name> = name

        /**
         * Returns the raw JSON value of [remaining].
         *
         * Unlike [remaining], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("remaining") @ExcludeMissing fun _remaining(): JsonField<Long> = remaining

        /**
         * Returns the raw JSON value of [resetSeconds].
         *
         * Unlike [resetSeconds], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("reset_seconds")
        @ExcludeMissing
        fun _resetSeconds(): JsonField<Double> = resetSeconds

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

            /** Returns a mutable builder for constructing an instance of [RateLimit]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [RateLimit]. */
        class Builder internal constructor() {

            private var limit: JsonField<Long> = JsonMissing.of()
            private var name: JsonField<Name> = JsonMissing.of()
            private var remaining: JsonField<Long> = JsonMissing.of()
            private var resetSeconds: JsonField<Double> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(rateLimit: RateLimit) = apply {
                limit = rateLimit.limit
                name = rateLimit.name
                remaining = rateLimit.remaining
                resetSeconds = rateLimit.resetSeconds
                additionalProperties = rateLimit.additionalProperties.toMutableMap()
            }

            /** The maximum allowed value for the rate limit. */
            fun limit(limit: Long) = limit(JsonField.of(limit))

            /**
             * Sets [Builder.limit] to an arbitrary JSON value.
             *
             * You should usually call [Builder.limit] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun limit(limit: JsonField<Long>) = apply { this.limit = limit }

            /** The name of the rate limit (`requests`, `tokens`). */
            fun name(name: Name) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [Name] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<Name>) = apply { this.name = name }

            /** The remaining value before the limit is reached. */
            fun remaining(remaining: Long) = remaining(JsonField.of(remaining))

            /**
             * Sets [Builder.remaining] to an arbitrary JSON value.
             *
             * You should usually call [Builder.remaining] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun remaining(remaining: JsonField<Long>) = apply { this.remaining = remaining }

            /** Seconds until the rate limit resets. */
            fun resetSeconds(resetSeconds: Double) = resetSeconds(JsonField.of(resetSeconds))

            /**
             * Sets [Builder.resetSeconds] to an arbitrary JSON value.
             *
             * You should usually call [Builder.resetSeconds] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun resetSeconds(resetSeconds: JsonField<Double>) = apply {
                this.resetSeconds = resetSeconds
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
             * Returns an immutable instance of [RateLimit].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): RateLimit =
                RateLimit(limit, name, remaining, resetSeconds, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): RateLimit = apply {
            if (validated) {
                return@apply
            }

            limit()
            name().ifPresent { it.validate() }
            remaining()
            resetSeconds()
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
        @JvmSynthetic
        internal fun validity(): Int =
            (if (limit.asKnown().isPresent) 1 else 0) +
                (name.asKnown().getOrNull()?.validity() ?: 0) +
                (if (remaining.asKnown().isPresent) 1 else 0) +
                (if (resetSeconds.asKnown().isPresent) 1 else 0)

        /** The name of the rate limit (`requests`, `tokens`). */
        class Name @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val REQUESTS = of("requests")

                @JvmField val TOKENS = of("tokens")

                @JvmStatic fun of(value: String) = Name(JsonField.of(value))
            }

            /** An enum containing [Name]'s known values. */
            enum class Known {
                REQUESTS,
                TOKENS,
            }

            /**
             * An enum containing [Name]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Name] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                REQUESTS,
                TOKENS,
                /** An enum member indicating that [Name] was instantiated with an unknown value. */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    REQUESTS -> Value.REQUESTS
                    TOKENS -> Value.TOKENS
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws OpenAIInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    REQUESTS -> Known.REQUESTS
                    TOKENS -> Known.TOKENS
                    else -> throw OpenAIInvalidDataException("Unknown Name: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws OpenAIInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    OpenAIInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            fun validate(): Name = apply {
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

                return /* spotless:off */ other is Name && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is RateLimit && limit == other.limit && name == other.name && remaining == other.remaining && resetSeconds == other.resetSeconds && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(limit, name, remaining, resetSeconds, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "RateLimit{limit=$limit, name=$name, remaining=$remaining, resetSeconds=$resetSeconds, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is RateLimitsUpdatedEvent && eventId == other.eventId && rateLimits == other.rateLimits && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(eventId, rateLimits, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RateLimitsUpdatedEvent{eventId=$eventId, rateLimits=$rateLimits, type=$type, additionalProperties=$additionalProperties}"
}
