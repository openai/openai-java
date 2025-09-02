// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.allMaxBy
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Controls how the realtime conversation is truncated prior to model inference. The default is
 * `auto`. When set to `retention_ratio`, the server retains a fraction of the conversation tokens
 * prior to the instructions.
 */
@JsonDeserialize(using = RealtimeTruncation.Deserializer::class)
@JsonSerialize(using = RealtimeTruncation.Serializer::class)
class RealtimeTruncation
private constructor(
    private val strategy: RealtimeTruncationStrategy? = null,
    private val retentionRatio: RetentionRatioTruncation? = null,
    private val _json: JsonValue? = null,
) {

    /** The truncation strategy to use for the session. */
    fun strategy(): Optional<RealtimeTruncationStrategy> = Optional.ofNullable(strategy)

    /** Retain a fraction of the conversation tokens. */
    fun retentionRatio(): Optional<RetentionRatioTruncation> = Optional.ofNullable(retentionRatio)

    fun isStrategy(): Boolean = strategy != null

    fun isRetentionRatio(): Boolean = retentionRatio != null

    /** The truncation strategy to use for the session. */
    fun asStrategy(): RealtimeTruncationStrategy = strategy.getOrThrow("strategy")

    /** Retain a fraction of the conversation tokens. */
    fun asRetentionRatio(): RetentionRatioTruncation = retentionRatio.getOrThrow("retentionRatio")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            strategy != null -> visitor.visitStrategy(strategy)
            retentionRatio != null -> visitor.visitRetentionRatio(retentionRatio)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): RealtimeTruncation = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitStrategy(strategy: RealtimeTruncationStrategy) {
                    strategy.validate()
                }

                override fun visitRetentionRatio(retentionRatio: RetentionRatioTruncation) {
                    retentionRatio.validate()
                }
            }
        )
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
        accept(
            object : Visitor<Int> {
                override fun visitStrategy(strategy: RealtimeTruncationStrategy) =
                    strategy.validity()

                override fun visitRetentionRatio(retentionRatio: RetentionRatioTruncation) =
                    retentionRatio.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RealtimeTruncation &&
            strategy == other.strategy &&
            retentionRatio == other.retentionRatio
    }

    override fun hashCode(): Int = Objects.hash(strategy, retentionRatio)

    override fun toString(): String =
        when {
            strategy != null -> "RealtimeTruncation{strategy=$strategy}"
            retentionRatio != null -> "RealtimeTruncation{retentionRatio=$retentionRatio}"
            _json != null -> "RealtimeTruncation{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid RealtimeTruncation")
        }

    companion object {

        /** The truncation strategy to use for the session. */
        @JvmStatic
        fun ofStrategy(strategy: RealtimeTruncationStrategy) =
            RealtimeTruncation(strategy = strategy)

        /** Retain a fraction of the conversation tokens. */
        @JvmStatic
        fun ofRetentionRatio(retentionRatio: RetentionRatioTruncation) =
            RealtimeTruncation(retentionRatio = retentionRatio)
    }

    /**
     * An interface that defines how to map each variant of [RealtimeTruncation] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        /** The truncation strategy to use for the session. */
        fun visitStrategy(strategy: RealtimeTruncationStrategy): T

        /** Retain a fraction of the conversation tokens. */
        fun visitRetentionRatio(retentionRatio: RetentionRatioTruncation): T

        /**
         * Maps an unknown variant of [RealtimeTruncation] to a value of type [T].
         *
         * An instance of [RealtimeTruncation] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown RealtimeTruncation: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<RealtimeTruncation>(RealtimeTruncation::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): RealtimeTruncation {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<RealtimeTruncationStrategy>())?.let {
                            RealtimeTruncation(strategy = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<RetentionRatioTruncation>())?.let {
                            RealtimeTruncation(retentionRatio = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from array).
                0 -> RealtimeTruncation(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer : BaseSerializer<RealtimeTruncation>(RealtimeTruncation::class) {

        override fun serialize(
            value: RealtimeTruncation,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.strategy != null -> generator.writeObject(value.strategy)
                value.retentionRatio != null -> generator.writeObject(value.retentionRatio)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid RealtimeTruncation")
            }
        }
    }

    /** The truncation strategy to use for the session. */
    class RealtimeTruncationStrategy
    @JsonCreator
    private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val AUTO = of("auto")

            @JvmField val DISABLED = of("disabled")

            @JvmStatic fun of(value: String) = RealtimeTruncationStrategy(JsonField.of(value))
        }

        /** An enum containing [RealtimeTruncationStrategy]'s known values. */
        enum class Known {
            AUTO,
            DISABLED,
        }

        /**
         * An enum containing [RealtimeTruncationStrategy]'s known values, as well as an [_UNKNOWN]
         * member.
         *
         * An instance of [RealtimeTruncationStrategy] can contain an unknown value in a couple of
         * cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            AUTO,
            DISABLED,
            /**
             * An enum member indicating that [RealtimeTruncationStrategy] was instantiated with an
             * unknown value.
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
                AUTO -> Value.AUTO
                DISABLED -> Value.DISABLED
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
                AUTO -> Known.AUTO
                DISABLED -> Known.DISABLED
                else ->
                    throw OpenAIInvalidDataException("Unknown RealtimeTruncationStrategy: $value")
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

        fun validate(): RealtimeTruncationStrategy = apply {
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

            return other is RealtimeTruncationStrategy && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Retain a fraction of the conversation tokens. */
    class RetentionRatioTruncation
    private constructor(
        private val retentionRatio: JsonField<Double>,
        private val type: JsonValue,
        private val postInstructionsTokenLimit: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("retention_ratio")
            @ExcludeMissing
            retentionRatio: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("post_instructions_token_limit")
            @ExcludeMissing
            postInstructionsTokenLimit: JsonField<Long> = JsonMissing.of(),
        ) : this(retentionRatio, type, postInstructionsTokenLimit, mutableMapOf())

        /**
         * Fraction of pre-instruction conversation tokens to retain (0.0 - 1.0).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun retentionRatio(): Double = retentionRatio.getRequired("retention_ratio")

        /**
         * Use retention ratio truncation.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("retention_ratio")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Optional cap on tokens allowed after the instructions.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun postInstructionsTokenLimit(): Optional<Long> =
            postInstructionsTokenLimit.getOptional("post_instructions_token_limit")

        /**
         * Returns the raw JSON value of [retentionRatio].
         *
         * Unlike [retentionRatio], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("retention_ratio")
        @ExcludeMissing
        fun _retentionRatio(): JsonField<Double> = retentionRatio

        /**
         * Returns the raw JSON value of [postInstructionsTokenLimit].
         *
         * Unlike [postInstructionsTokenLimit], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("post_instructions_token_limit")
        @ExcludeMissing
        fun _postInstructionsTokenLimit(): JsonField<Long> = postInstructionsTokenLimit

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
             * Returns a mutable builder for constructing an instance of [RetentionRatioTruncation].
             *
             * The following fields are required:
             * ```java
             * .retentionRatio()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [RetentionRatioTruncation]. */
        class Builder internal constructor() {

            private var retentionRatio: JsonField<Double>? = null
            private var type: JsonValue = JsonValue.from("retention_ratio")
            private var postInstructionsTokenLimit: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(retentionRatioTruncation: RetentionRatioTruncation) = apply {
                retentionRatio = retentionRatioTruncation.retentionRatio
                type = retentionRatioTruncation.type
                postInstructionsTokenLimit = retentionRatioTruncation.postInstructionsTokenLimit
                additionalProperties = retentionRatioTruncation.additionalProperties.toMutableMap()
            }

            /** Fraction of pre-instruction conversation tokens to retain (0.0 - 1.0). */
            fun retentionRatio(retentionRatio: Double) =
                retentionRatio(JsonField.of(retentionRatio))

            /**
             * Sets [Builder.retentionRatio] to an arbitrary JSON value.
             *
             * You should usually call [Builder.retentionRatio] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun retentionRatio(retentionRatio: JsonField<Double>) = apply {
                this.retentionRatio = retentionRatio
            }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("retention_ratio")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            /** Optional cap on tokens allowed after the instructions. */
            fun postInstructionsTokenLimit(postInstructionsTokenLimit: Long?) =
                postInstructionsTokenLimit(JsonField.ofNullable(postInstructionsTokenLimit))

            /**
             * Alias for [Builder.postInstructionsTokenLimit].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun postInstructionsTokenLimit(postInstructionsTokenLimit: Long) =
                postInstructionsTokenLimit(postInstructionsTokenLimit as Long?)

            /**
             * Alias for calling [Builder.postInstructionsTokenLimit] with
             * `postInstructionsTokenLimit.orElse(null)`.
             */
            fun postInstructionsTokenLimit(postInstructionsTokenLimit: Optional<Long>) =
                postInstructionsTokenLimit(postInstructionsTokenLimit.getOrNull())

            /**
             * Sets [Builder.postInstructionsTokenLimit] to an arbitrary JSON value.
             *
             * You should usually call [Builder.postInstructionsTokenLimit] with a well-typed [Long]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun postInstructionsTokenLimit(postInstructionsTokenLimit: JsonField<Long>) = apply {
                this.postInstructionsTokenLimit = postInstructionsTokenLimit
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
             * Returns an immutable instance of [RetentionRatioTruncation].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .retentionRatio()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): RetentionRatioTruncation =
                RetentionRatioTruncation(
                    checkRequired("retentionRatio", retentionRatio),
                    type,
                    postInstructionsTokenLimit,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): RetentionRatioTruncation = apply {
            if (validated) {
                return@apply
            }

            retentionRatio()
            _type().let {
                if (it != JsonValue.from("retention_ratio")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            postInstructionsTokenLimit()
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
            (if (retentionRatio.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("retention_ratio")) 1 else 0 } +
                (if (postInstructionsTokenLimit.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is RetentionRatioTruncation &&
                retentionRatio == other.retentionRatio &&
                type == other.type &&
                postInstructionsTokenLimit == other.postInstructionsTokenLimit &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(retentionRatio, type, postInstructionsTokenLimit, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "RetentionRatioTruncation{retentionRatio=$retentionRatio, type=$type, postInstructionsTokenLimit=$postInstructionsTokenLimit, additionalProperties=$additionalProperties}"
    }
}
