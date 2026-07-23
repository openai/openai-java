// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.spendlimit

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

/** Represents a hard spend limit configured at the project level. */
class ProjectSpendLimit
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val currency: JsonField<Currency>,
    private val enforcement: JsonField<Enforcement>,
    private val interval: JsonField<Interval>,
    private val object_: JsonValue,
    private val thresholdAmount: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("currency") @ExcludeMissing currency: JsonField<Currency> = JsonMissing.of(),
        @JsonProperty("enforcement")
        @ExcludeMissing
        enforcement: JsonField<Enforcement> = JsonMissing.of(),
        @JsonProperty("interval") @ExcludeMissing interval: JsonField<Interval> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("threshold_amount")
        @ExcludeMissing
        thresholdAmount: JsonField<Long> = JsonMissing.of(),
    ) : this(currency, enforcement, interval, object_, thresholdAmount, mutableMapOf())

    /**
     * The currency for the threshold amount. Currently, only `USD` is supported.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun currency(): Currency = currency.getRequired("currency")

    /**
     * The current enforcement state of the hard spend limit.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun enforcement(): Enforcement = enforcement.getRequired("enforcement")

    /**
     * The time interval for evaluating spend against the threshold. Currently, only `month` is
     * supported.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun interval(): Interval = interval.getRequired("interval")

    /**
     * The object type, which is always `project.spend_limit`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("project.spend_limit")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * The hard spend limit amount, in cents.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun thresholdAmount(): Long = thresholdAmount.getRequired("threshold_amount")

    /**
     * Returns the raw JSON value of [currency].
     *
     * Unlike [currency], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("currency") @ExcludeMissing fun _currency(): JsonField<Currency> = currency

    /**
     * Returns the raw JSON value of [enforcement].
     *
     * Unlike [enforcement], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("enforcement")
    @ExcludeMissing
    fun _enforcement(): JsonField<Enforcement> = enforcement

    /**
     * Returns the raw JSON value of [interval].
     *
     * Unlike [interval], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("interval") @ExcludeMissing fun _interval(): JsonField<Interval> = interval

    /**
     * Returns the raw JSON value of [thresholdAmount].
     *
     * Unlike [thresholdAmount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("threshold_amount")
    @ExcludeMissing
    fun _thresholdAmount(): JsonField<Long> = thresholdAmount

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
         * Returns a mutable builder for constructing an instance of [ProjectSpendLimit].
         *
         * The following fields are required:
         * ```java
         * .currency()
         * .enforcement()
         * .interval()
         * .thresholdAmount()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ProjectSpendLimit]. */
    class Builder internal constructor() {

        private var currency: JsonField<Currency>? = null
        private var enforcement: JsonField<Enforcement>? = null
        private var interval: JsonField<Interval>? = null
        private var object_: JsonValue = JsonValue.from("project.spend_limit")
        private var thresholdAmount: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(projectSpendLimit: ProjectSpendLimit) = apply {
            currency = projectSpendLimit.currency
            enforcement = projectSpendLimit.enforcement
            interval = projectSpendLimit.interval
            object_ = projectSpendLimit.object_
            thresholdAmount = projectSpendLimit.thresholdAmount
            additionalProperties = projectSpendLimit.additionalProperties.toMutableMap()
        }

        /** The currency for the threshold amount. Currently, only `USD` is supported. */
        fun currency(currency: Currency) = currency(JsonField.of(currency))

        /**
         * Sets [Builder.currency] to an arbitrary JSON value.
         *
         * You should usually call [Builder.currency] with a well-typed [Currency] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun currency(currency: JsonField<Currency>) = apply { this.currency = currency }

        /**
         * Sets [currency] to an arbitrary [String].
         *
         * You should usually call [currency] with a well-typed [Currency] constant instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun currency(value: String) = currency(Currency.of(value))

        /** The current enforcement state of the hard spend limit. */
        fun enforcement(enforcement: Enforcement) = enforcement(JsonField.of(enforcement))

        /**
         * Sets [Builder.enforcement] to an arbitrary JSON value.
         *
         * You should usually call [Builder.enforcement] with a well-typed [Enforcement] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun enforcement(enforcement: JsonField<Enforcement>) = apply {
            this.enforcement = enforcement
        }

        /**
         * The time interval for evaluating spend against the threshold. Currently, only `month` is
         * supported.
         */
        fun interval(interval: Interval) = interval(JsonField.of(interval))

        /**
         * Sets [Builder.interval] to an arbitrary JSON value.
         *
         * You should usually call [Builder.interval] with a well-typed [Interval] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun interval(interval: JsonField<Interval>) = apply { this.interval = interval }

        /**
         * Sets [interval] to an arbitrary [String].
         *
         * You should usually call [interval] with a well-typed [Interval] constant instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun interval(value: String) = interval(Interval.of(value))

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("project.spend_limit")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /** The hard spend limit amount, in cents. */
        fun thresholdAmount(thresholdAmount: Long) = thresholdAmount(JsonField.of(thresholdAmount))

        /**
         * Sets [Builder.thresholdAmount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.thresholdAmount] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun thresholdAmount(thresholdAmount: JsonField<Long>) = apply {
            this.thresholdAmount = thresholdAmount
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
         * Returns an immutable instance of [ProjectSpendLimit].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .currency()
         * .enforcement()
         * .interval()
         * .thresholdAmount()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ProjectSpendLimit =
            ProjectSpendLimit(
                checkRequired("currency", currency),
                checkRequired("enforcement", enforcement),
                checkRequired("interval", interval),
                object_,
                checkRequired("thresholdAmount", thresholdAmount),
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
    fun validate(): ProjectSpendLimit = apply {
        if (validated) {
            return@apply
        }

        currency()
        enforcement().validate()
        interval()
        _object_().let {
            if (it != JsonValue.from("project.spend_limit")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        thresholdAmount()
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
        (if (currency.asKnown().isPresent) 1 else 0) +
            (enforcement.asKnown().getOrNull()?.validity() ?: 0) +
            (if (interval.asKnown().isPresent) 1 else 0) +
            object_.let { if (it == JsonValue.from("project.spend_limit")) 1 else 0 } +
            (if (thresholdAmount.asKnown().isPresent) 1 else 0)

    /** The currency for the threshold amount. Currently, only `USD` is supported. */
    class Currency @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val USD = of("USD")

            @JvmStatic fun of(value: String) = Currency(JsonField.of(value))
        }

        /** An enum containing [Currency]'s known values. */
        enum class Known {
            USD
        }

        /**
         * An enum containing [Currency]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Currency] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            USD,
            /** An enum member indicating that [Currency] was instantiated with an unknown value. */
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
                USD -> Value.USD
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
                USD -> Known.USD
                else -> throw OpenAIInvalidDataException("Unknown Currency: $value")
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
        fun validate(): Currency = apply {
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

            return other is Currency && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** The current enforcement state of the hard spend limit. */
    class Enforcement
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val status: JsonField<Status>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of()
        ) : this(status, mutableMapOf())

        /**
         * Whether the hard spend limit is currently enforcing.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun status(): Status = status.getRequired("status")

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

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
             * Returns a mutable builder for constructing an instance of [Enforcement].
             *
             * The following fields are required:
             * ```java
             * .status()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Enforcement]. */
        class Builder internal constructor() {

            private var status: JsonField<Status>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(enforcement: Enforcement) = apply {
                status = enforcement.status
                additionalProperties = enforcement.additionalProperties.toMutableMap()
            }

            /** Whether the hard spend limit is currently enforcing. */
            fun status(status: Status) = status(JsonField.of(status))

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [Status] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<Status>) = apply { this.status = status }

            /**
             * Sets [status] to an arbitrary [String].
             *
             * You should usually call [status] with a well-typed [Status] constant instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun status(value: String) = status(Status.of(value))

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
             * Returns an immutable instance of [Enforcement].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .status()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Enforcement =
                Enforcement(checkRequired("status", status), additionalProperties.toMutableMap())
        }

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
        fun validate(): Enforcement = apply {
            if (validated) {
                return@apply
            }

            status()
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
        @JvmSynthetic internal fun validity(): Int = (if (status.asKnown().isPresent) 1 else 0)

        /** Whether the hard spend limit is currently enforcing. */
        class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val INACTIVE = of("inactive")

                @JvmField val ENFORCING = of("enforcing")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                INACTIVE,
                ENFORCING,
            }

            /**
             * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Status] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                INACTIVE,
                ENFORCING,
                /**
                 * An enum member indicating that [Status] was instantiated with an unknown value.
                 */
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
                    INACTIVE -> Value.INACTIVE
                    ENFORCING -> Value.ENFORCING
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
                    INACTIVE -> Known.INACTIVE
                    ENFORCING -> Known.ENFORCING
                    else -> throw OpenAIInvalidDataException("Unknown Status: $value")
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

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Status = apply {
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

                return other is Status && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Enforcement &&
                status == other.status &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(status, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Enforcement{status=$status, additionalProperties=$additionalProperties}"
    }

    /**
     * The time interval for evaluating spend against the threshold. Currently, only `month` is
     * supported.
     */
    class Interval @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val MONTH = of("month")

            @JvmStatic fun of(value: String) = Interval(JsonField.of(value))
        }

        /** An enum containing [Interval]'s known values. */
        enum class Known {
            MONTH
        }

        /**
         * An enum containing [Interval]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Interval] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            MONTH,
            /** An enum member indicating that [Interval] was instantiated with an unknown value. */
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
                MONTH -> Value.MONTH
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
                MONTH -> Known.MONTH
                else -> throw OpenAIInvalidDataException("Unknown Interval: $value")
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
        fun validate(): Interval = apply {
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

            return other is Interval && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ProjectSpendLimit &&
            currency == other.currency &&
            enforcement == other.enforcement &&
            interval == other.interval &&
            object_ == other.object_ &&
            thresholdAmount == other.thresholdAmount &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            currency,
            enforcement,
            interval,
            object_,
            thresholdAmount,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ProjectSpendLimit{currency=$currency, enforcement=$enforcement, interval=$interval, object_=$object_, thresholdAmount=$thresholdAmount, additionalProperties=$additionalProperties}"
}
