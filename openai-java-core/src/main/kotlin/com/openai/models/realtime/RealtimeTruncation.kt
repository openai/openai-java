// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.annotation.JsonCreator
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
import com.openai.core.JsonField
import com.openai.core.JsonValue
import com.openai.core.allMaxBy
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/**
 * Controls how the realtime conversation is truncated prior to model inference. The default is
 * `auto`.
 */
@JsonDeserialize(using = RealtimeTruncation.Deserializer::class)
@JsonSerialize(using = RealtimeTruncation.Serializer::class)
class RealtimeTruncation
private constructor(
    private val strategy: RealtimeTruncationStrategy? = null,
    private val retentionRatio: RealtimeTruncationRetentionRatio? = null,
    private val _json: JsonValue? = null,
) {

    /**
     * The truncation strategy to use for the session. `auto` is the default truncation strategy.
     * `disabled` will disable truncation and emit errors when the conversation exceeds the input
     * token limit.
     */
    fun strategy(): Optional<RealtimeTruncationStrategy> = Optional.ofNullable(strategy)

    /**
     * Retain a fraction of the conversation tokens when the conversation exceeds the input token
     * limit. This allows you to amortize truncations across multiple turns, which can help improve
     * cached token usage.
     */
    fun retentionRatio(): Optional<RealtimeTruncationRetentionRatio> =
        Optional.ofNullable(retentionRatio)

    fun isStrategy(): Boolean = strategy != null

    fun isRetentionRatio(): Boolean = retentionRatio != null

    /**
     * The truncation strategy to use for the session. `auto` is the default truncation strategy.
     * `disabled` will disable truncation and emit errors when the conversation exceeds the input
     * token limit.
     */
    fun asStrategy(): RealtimeTruncationStrategy = strategy.getOrThrow("strategy")

    /**
     * Retain a fraction of the conversation tokens when the conversation exceeds the input token
     * limit. This allows you to amortize truncations across multiple turns, which can help improve
     * cached token usage.
     */
    fun asRetentionRatio(): RealtimeTruncationRetentionRatio =
        retentionRatio.getOrThrow("retentionRatio")

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

                override fun visitRetentionRatio(retentionRatio: RealtimeTruncationRetentionRatio) {
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

                override fun visitRetentionRatio(retentionRatio: RealtimeTruncationRetentionRatio) =
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

        /**
         * The truncation strategy to use for the session. `auto` is the default truncation
         * strategy. `disabled` will disable truncation and emit errors when the conversation
         * exceeds the input token limit.
         */
        @JvmStatic
        fun ofStrategy(strategy: RealtimeTruncationStrategy) =
            RealtimeTruncation(strategy = strategy)

        /**
         * Retain a fraction of the conversation tokens when the conversation exceeds the input
         * token limit. This allows you to amortize truncations across multiple turns, which can
         * help improve cached token usage.
         */
        @JvmStatic
        fun ofRetentionRatio(retentionRatio: RealtimeTruncationRetentionRatio) =
            RealtimeTruncation(retentionRatio = retentionRatio)
    }

    /**
     * An interface that defines how to map each variant of [RealtimeTruncation] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        /**
         * The truncation strategy to use for the session. `auto` is the default truncation
         * strategy. `disabled` will disable truncation and emit errors when the conversation
         * exceeds the input token limit.
         */
        fun visitStrategy(strategy: RealtimeTruncationStrategy): T

        /**
         * Retain a fraction of the conversation tokens when the conversation exceeds the input
         * token limit. This allows you to amortize truncations across multiple turns, which can
         * help improve cached token usage.
         */
        fun visitRetentionRatio(retentionRatio: RealtimeTruncationRetentionRatio): T

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
                        tryDeserialize(node, jacksonTypeRef<RealtimeTruncationRetentionRatio>())
                            ?.let { RealtimeTruncation(retentionRatio = it, _json = json) },
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

    /**
     * The truncation strategy to use for the session. `auto` is the default truncation strategy.
     * `disabled` will disable truncation and emit errors when the conversation exceeds the input
     * token limit.
     */
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
}
