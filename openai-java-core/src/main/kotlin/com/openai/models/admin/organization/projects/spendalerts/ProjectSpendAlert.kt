// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.projects.spendalerts

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
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Represents a spend alert configured at the project level. */
class ProjectSpendAlert
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val currency: JsonField<Currency>,
    private val interval: JsonField<Interval>,
    private val notificationChannel: JsonField<NotificationChannel>,
    private val object_: JsonValue,
    private val thresholdAmount: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("currency") @ExcludeMissing currency: JsonField<Currency> = JsonMissing.of(),
        @JsonProperty("interval") @ExcludeMissing interval: JsonField<Interval> = JsonMissing.of(),
        @JsonProperty("notification_channel")
        @ExcludeMissing
        notificationChannel: JsonField<NotificationChannel> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("threshold_amount")
        @ExcludeMissing
        thresholdAmount: JsonField<Long> = JsonMissing.of(),
    ) : this(id, currency, interval, notificationChannel, object_, thresholdAmount, mutableMapOf())

    /**
     * The identifier, which can be referenced in API endpoints. The schema requires this property.
     * Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun id(): java.util.Optional<String> = id.getOptional("id")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun idOrThrow(): String = id.getRequired("id")

    /**
     * The currency for the threshold amount. The schema requires this property. Returns empty if
     * the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun currency(): java.util.Optional<Currency> = currency.getOptional("currency")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun currencyOrThrow(): Currency = currency.getRequired("currency")

    /**
     * The time interval for evaluating spend against the threshold. The schema requires this
     * property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun interval(): java.util.Optional<Interval> = interval.getOptional("interval")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun intervalOrThrow(): Interval = interval.getRequired("interval")

    /**
     * Email notification settings for a spend alert. The schema requires this property. Returns
     * empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun notificationChannel(): java.util.Optional<NotificationChannel> =
        notificationChannel.getOptional("notification_channel")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun notificationChannelOrThrow(): NotificationChannel =
        notificationChannel.getRequired("notification_channel")

    /**
     * The object type, which is always `project.spend_alert`. The schema requires this property.
     * Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun object_(): java.util.Optional<JsonValue> {
        val raw = object_
        return when {
            raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
            !(raw == JsonValue.from("project.spend_alert")) ->
                throw OpenAIInvalidDataException("`object` is invalid")
            else -> java.util.Optional.of(raw)
        }
    }

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun object_OrThrow(): JsonValue = object_().orElseGet { object_.getRequired("object") }

    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonField<JsonValue> = object_

    /**
     * The alert threshold amount, in cents. The schema requires this property. Returns empty if the
     * JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun thresholdAmount(): java.util.Optional<Long> =
        thresholdAmount.getOptional("threshold_amount")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun thresholdAmountOrThrow(): Long = thresholdAmount.getRequired("threshold_amount")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [currency].
     *
     * Unlike [currency], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("currency") @ExcludeMissing fun _currency(): JsonField<Currency> = currency

    /**
     * Returns the raw JSON value of [interval].
     *
     * Unlike [interval], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("interval") @ExcludeMissing fun _interval(): JsonField<Interval> = interval

    /**
     * Returns the raw JSON value of [notificationChannel].
     *
     * Unlike [notificationChannel], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("notification_channel")
    @ExcludeMissing
    fun _notificationChannel(): JsonField<NotificationChannel> = notificationChannel

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
            "id" to this.id,
            "currency" to this.currency,
            "interval" to this.interval,
            "notification_channel" to this.notificationChannel,
            "object" to this.object_,
            "threshold_amount" to this.thresholdAmount,
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
         * Returns a mutable builder for constructing an instance of [ProjectSpendAlert].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .currency()
         * .interval()
         * .notificationChannel()
         * .thresholdAmount()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ProjectSpendAlert]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var currency: JsonField<Currency>? = null
        private var interval: JsonField<Interval>? = null
        private var notificationChannel: JsonField<NotificationChannel>? = null
        private var object_: JsonValue = JsonValue.from("project.spend_alert")
        private var thresholdAmount: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(projectSpendAlert: ProjectSpendAlert) = apply {
            id = projectSpendAlert.id
            currency = projectSpendAlert.currency
            interval = projectSpendAlert.interval
            notificationChannel = projectSpendAlert.notificationChannel
            object_ = projectSpendAlert.object_
            thresholdAmount = projectSpendAlert.thresholdAmount
            additionalProperties = projectSpendAlert.additionalProperties.toMutableMap()
        }

        /** The identifier, which can be referenced in API endpoints. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The currency for the threshold amount. */
        fun currency(currency: Currency) = currency(JsonField.of(currency))

        /**
         * Sets [Builder.currency] to an arbitrary JSON value.
         *
         * You should usually call [Builder.currency] with a well-typed [Currency] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun currency(currency: JsonField<Currency>) = apply { this.currency = currency }

        /** The time interval for evaluating spend against the threshold. */
        fun interval(interval: Interval) = interval(JsonField.of(interval))

        /**
         * Sets [Builder.interval] to an arbitrary JSON value.
         *
         * You should usually call [Builder.interval] with a well-typed [Interval] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun interval(interval: JsonField<Interval>) = apply { this.interval = interval }

        /** Email notification settings for a spend alert. */
        fun notificationChannel(notificationChannel: NotificationChannel) =
            notificationChannel(JsonField.of(notificationChannel))

        /**
         * Sets [Builder.notificationChannel] to an arbitrary JSON value.
         *
         * You should usually call [Builder.notificationChannel] with a well-typed
         * [NotificationChannel] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun notificationChannel(notificationChannel: JsonField<NotificationChannel>) = apply {
            this.notificationChannel = notificationChannel
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("project.spend_alert")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /** The alert threshold amount, in cents. */
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
         * Returns an immutable instance of [ProjectSpendAlert].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .currency()
         * .interval()
         * .notificationChannel()
         * .thresholdAmount()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ProjectSpendAlert =
            ProjectSpendAlert(
                checkRequired("id", id),
                checkRequired("currency", currency),
                checkRequired("interval", interval),
                checkRequired("notificationChannel", notificationChannel),
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
    fun validate(): ProjectSpendAlert = apply {
        if (validated) {
            return@apply
        }

        idOrThrow()
        currencyOrThrow().validate()
        intervalOrThrow().validate()
        notificationChannelOrThrow().validate()
        object_OrThrow()
        thresholdAmountOrThrow()
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
        (if (id.asKnown().isPresent) 1 else 0) +
            (currency.asKnown().getOrNull()?.validity() ?: 0) +
            (interval.asKnown().getOrNull()?.validity() ?: 0) +
            (notificationChannel.asKnown().getOrNull()?.validity() ?: 0) +
            object_.let { if (it == JsonValue.from("project.spend_alert")) 1 else 0 } +
            (if (thresholdAmount.asKnown().isPresent) 1 else 0)

    /** The currency for the threshold amount. */
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
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
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
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
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
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
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
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
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

    /** The time interval for evaluating spend against the threshold. */
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
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
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
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
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
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
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
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
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

    /** Email notification settings for a spend alert. */
    class NotificationChannel
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val recipients: JsonField<List<String>>,
        private val type: JsonValue,
        private val subjectPrefix: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("recipients")
            @ExcludeMissing
            recipients: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("subject_prefix")
            @ExcludeMissing
            subjectPrefix: JsonField<String> = JsonMissing.of(),
        ) : this(recipients, type, subjectPrefix, mutableMapOf())

        /**
         * Email addresses that receive the spend alert notification. The schema requires this
         * property. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun recipients(): java.util.Optional<List<String>> = recipients.getOptional("recipients")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun recipientsOrThrow(): List<String> = recipients.getRequired("recipients")

        /**
         * The notification channel type. Currently only `email` is supported. The schema requires
         * this property. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun type(): java.util.Optional<JsonValue> {
            val raw = type
            return when {
                raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
                !(raw == JsonValue.from("email")) ->
                    throw OpenAIInvalidDataException("`type` is invalid")
                else -> java.util.Optional.of(raw)
            }
        }

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

        /**
         * Optional subject prefix for alert emails. Returns empty if the JSON property is missing
         * or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun subjectPrefix(): java.util.Optional<String> =
            subjectPrefix.getOptional("subject_prefix")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun subjectPrefixOrThrow(): String = subjectPrefix.getRequired("subject_prefix")

        /**
         * Returns the raw JSON value of [recipients].
         *
         * Unlike [recipients], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("recipients")
        @ExcludeMissing
        fun _recipients(): JsonField<List<String>> = recipients

        /**
         * Returns the raw JSON value of [subjectPrefix].
         *
         * Unlike [subjectPrefix], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("subject_prefix")
        @ExcludeMissing
        fun _subjectPrefix(): JsonField<String> = subjectPrefix

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
                "recipients" to this.recipients,
                "type" to this.type,
                "subject_prefix" to this.subjectPrefix,
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
             * Returns a mutable builder for constructing an instance of [NotificationChannel].
             *
             * The following fields are required:
             * ```java
             * .recipients()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [NotificationChannel]. */
        class Builder internal constructor() {

            private var recipients: JsonField<MutableList<String>>? = null
            private var type: JsonValue = JsonValue.from("email")
            private var subjectPrefix: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(notificationChannel: NotificationChannel) = apply {
                recipients = notificationChannel.recipients.map { it.toMutableList() }
                type = notificationChannel.type
                subjectPrefix = notificationChannel.subjectPrefix
                additionalProperties = notificationChannel.additionalProperties.toMutableMap()
            }

            /** Email addresses that receive the spend alert notification. */
            fun recipients(recipients: List<String>) = recipients(JsonField.of(recipients))

            /**
             * Sets [Builder.recipients] to an arbitrary JSON value.
             *
             * You should usually call [Builder.recipients] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun recipients(recipients: JsonField<List<String>>) = apply {
                this.recipients = recipients.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [recipients].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addRecipient(recipient: String) = apply {
                recipients =
                    (recipients ?: JsonField.of(mutableListOf())).also {
                        checkKnown("recipients", it).add(recipient)
                    }
            }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("email")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            /** Optional subject prefix for alert emails. */
            fun subjectPrefix(subjectPrefix: String?) =
                subjectPrefix(JsonField.ofNullable(subjectPrefix))

            /** Alias for calling [Builder.subjectPrefix] with `subjectPrefix.orElse(null)`. */
            fun subjectPrefix(subjectPrefix: Optional<String>) =
                subjectPrefix(subjectPrefix.getOrNull())

            /**
             * Sets [Builder.subjectPrefix] to an arbitrary JSON value.
             *
             * You should usually call [Builder.subjectPrefix] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun subjectPrefix(subjectPrefix: JsonField<String>) = apply {
                this.subjectPrefix = subjectPrefix
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
             * Returns an immutable instance of [NotificationChannel].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .recipients()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): NotificationChannel =
                NotificationChannel(
                    checkRequired("recipients", recipients).map { it.toImmutable() },
                    type,
                    subjectPrefix,
                    additionalProperties.toMutableMap(),
                )
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
        fun validate(): NotificationChannel = apply {
            if (validated) {
                return@apply
            }

            recipientsOrThrow()
            typeOrThrow()
            subjectPrefix()
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
            (recipients.asKnown().getOrNull()?.size ?: 0) +
                type.let { if (it == JsonValue.from("email")) 1 else 0 } +
                (if (subjectPrefix.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is NotificationChannel &&
                recipients == other.recipients &&
                type == other.type &&
                subjectPrefix == other.subjectPrefix &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(recipients, type, subjectPrefix, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "NotificationChannel{recipients=$recipients, type=$type, subjectPrefix=$subjectPrefix, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ProjectSpendAlert &&
            id == other.id &&
            currency == other.currency &&
            interval == other.interval &&
            notificationChannel == other.notificationChannel &&
            object_ == other.object_ &&
            thresholdAmount == other.thresholdAmount &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            currency,
            interval,
            notificationChannel,
            object_,
            thresholdAmount,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ProjectSpendAlert{id=$id, currency=$currency, interval=$interval, notificationChannel=$notificationChannel, object_=$object_, thresholdAmount=$thresholdAmount, additionalProperties=$additionalProperties}"
}
