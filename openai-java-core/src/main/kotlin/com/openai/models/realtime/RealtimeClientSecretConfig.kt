// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

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
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Configuration options for the generated client secret. */
class RealtimeClientSecretConfig
private constructor(
    private val expiresAfter: JsonField<ExpiresAfter>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("expires_after")
        @ExcludeMissing
        expiresAfter: JsonField<ExpiresAfter> = JsonMissing.of()
    ) : this(expiresAfter, mutableMapOf())

    /**
     * Configuration for the ephemeral token expiration.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun expiresAfter(): Optional<ExpiresAfter> = expiresAfter.getOptional("expires_after")

    /**
     * Returns the raw JSON value of [expiresAfter].
     *
     * Unlike [expiresAfter], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("expires_after")
    @ExcludeMissing
    fun _expiresAfter(): JsonField<ExpiresAfter> = expiresAfter

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
         * Returns a mutable builder for constructing an instance of [RealtimeClientSecretConfig].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RealtimeClientSecretConfig]. */
    class Builder internal constructor() {

        private var expiresAfter: JsonField<ExpiresAfter> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(realtimeClientSecretConfig: RealtimeClientSecretConfig) = apply {
            expiresAfter = realtimeClientSecretConfig.expiresAfter
            additionalProperties = realtimeClientSecretConfig.additionalProperties.toMutableMap()
        }

        /** Configuration for the ephemeral token expiration. */
        fun expiresAfter(expiresAfter: ExpiresAfter) = expiresAfter(JsonField.of(expiresAfter))

        /**
         * Sets [Builder.expiresAfter] to an arbitrary JSON value.
         *
         * You should usually call [Builder.expiresAfter] with a well-typed [ExpiresAfter] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun expiresAfter(expiresAfter: JsonField<ExpiresAfter>) = apply {
            this.expiresAfter = expiresAfter
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
         * Returns an immutable instance of [RealtimeClientSecretConfig].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): RealtimeClientSecretConfig =
            RealtimeClientSecretConfig(expiresAfter, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): RealtimeClientSecretConfig = apply {
        if (validated) {
            return@apply
        }

        expiresAfter().ifPresent { it.validate() }
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
    internal fun validity(): Int = (expiresAfter.asKnown().getOrNull()?.validity() ?: 0)

    /** Configuration for the ephemeral token expiration. */
    class ExpiresAfter
    private constructor(
        private val anchor: JsonField<Anchor>,
        private val seconds: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("anchor") @ExcludeMissing anchor: JsonField<Anchor> = JsonMissing.of(),
            @JsonProperty("seconds") @ExcludeMissing seconds: JsonField<Long> = JsonMissing.of(),
        ) : this(anchor, seconds, mutableMapOf())

        /**
         * The anchor point for the ephemeral token expiration. Only `created_at` is currently
         * supported.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun anchor(): Anchor = anchor.getRequired("anchor")

        /**
         * The number of seconds from the anchor point to the expiration. Select a value between
         * `10` and `7200`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun seconds(): Optional<Long> = seconds.getOptional("seconds")

        /**
         * Returns the raw JSON value of [anchor].
         *
         * Unlike [anchor], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("anchor") @ExcludeMissing fun _anchor(): JsonField<Anchor> = anchor

        /**
         * Returns the raw JSON value of [seconds].
         *
         * Unlike [seconds], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("seconds") @ExcludeMissing fun _seconds(): JsonField<Long> = seconds

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
             * Returns a mutable builder for constructing an instance of [ExpiresAfter].
             *
             * The following fields are required:
             * ```java
             * .anchor()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ExpiresAfter]. */
        class Builder internal constructor() {

            private var anchor: JsonField<Anchor>? = null
            private var seconds: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(expiresAfter: ExpiresAfter) = apply {
                anchor = expiresAfter.anchor
                seconds = expiresAfter.seconds
                additionalProperties = expiresAfter.additionalProperties.toMutableMap()
            }

            /**
             * The anchor point for the ephemeral token expiration. Only `created_at` is currently
             * supported.
             */
            fun anchor(anchor: Anchor) = anchor(JsonField.of(anchor))

            /**
             * Sets [Builder.anchor] to an arbitrary JSON value.
             *
             * You should usually call [Builder.anchor] with a well-typed [Anchor] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun anchor(anchor: JsonField<Anchor>) = apply { this.anchor = anchor }

            /**
             * The number of seconds from the anchor point to the expiration. Select a value between
             * `10` and `7200`.
             */
            fun seconds(seconds: Long) = seconds(JsonField.of(seconds))

            /**
             * Sets [Builder.seconds] to an arbitrary JSON value.
             *
             * You should usually call [Builder.seconds] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun seconds(seconds: JsonField<Long>) = apply { this.seconds = seconds }

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
             * Returns an immutable instance of [ExpiresAfter].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .anchor()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ExpiresAfter =
                ExpiresAfter(
                    checkRequired("anchor", anchor),
                    seconds,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): ExpiresAfter = apply {
            if (validated) {
                return@apply
            }

            anchor().validate()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (anchor.asKnown().getOrNull()?.validity() ?: 0) +
                (if (seconds.asKnown().isPresent) 1 else 0)

        /**
         * The anchor point for the ephemeral token expiration. Only `created_at` is currently
         * supported.
         */
        class Anchor @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val CREATED_AT = of("created_at")

                @JvmStatic fun of(value: String) = Anchor(JsonField.of(value))
            }

            /** An enum containing [Anchor]'s known values. */
            enum class Known {
                CREATED_AT
            }

            /**
             * An enum containing [Anchor]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Anchor] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                CREATED_AT,
                /**
                 * An enum member indicating that [Anchor] was instantiated with an unknown value.
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
                    CREATED_AT -> Value.CREATED_AT
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
                    CREATED_AT -> Known.CREATED_AT
                    else -> throw OpenAIInvalidDataException("Unknown Anchor: $value")
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

            fun validate(): Anchor = apply {
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

                return other is Anchor && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ExpiresAfter &&
                anchor == other.anchor &&
                seconds == other.seconds &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(anchor, seconds, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ExpiresAfter{anchor=$anchor, seconds=$seconds, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RealtimeClientSecretConfig &&
            expiresAfter == other.expiresAfter &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(expiresAfter, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RealtimeClientSecretConfig{expiresAfter=$expiresAfter, additionalProperties=$additionalProperties}"
}
