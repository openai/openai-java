// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.decisions

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.JsonValue
import com.openai.core.allMaxBy
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/** Choice values are typed: a string and a boolean with the same text are distinct. */
@JsonDeserialize(using = DecisionChoiceValue.Deserializer::class)
@JsonSerialize(using = DecisionChoiceValue.Serializer::class)
class DecisionChoiceValue
private constructor(
    private val string: String? = null,
    private val bool: Boolean? = null,
    private val _json: JsonValue? = null,
) {

    fun string(): Optional<String> = Optional.ofNullable(string)

    fun bool(): Optional<Boolean> = Optional.ofNullable(bool)

    fun isString(): Boolean = string != null

    fun isBool(): Boolean = bool != null

    fun asString(): String = string.getOrThrow("string")

    fun asBool(): Boolean = bool.getOrThrow("bool")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    /**
     * Maps this instance's current variant to a value of type [T] using the given [visitor].
     *
     * Note that this method is _not_ forwards compatible with new variants from the API, unless
     * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of the
     * SDK gracefully, consider overriding [Visitor.unknown]:
     * ```java
     * import com.openai.core.JsonValue;
     * import java.util.Optional;
     *
     * Optional<String> result = decisionChoiceValue.accept(new DecisionChoiceValue.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitString(String string) {
     *         return Optional.of(string.toString());
     *     }
     *
     *     // ...
     *
     *     @Override
     *     public Optional<String> unknown(JsonValue json) {
     *         // Or inspect the `json`.
     *         return Optional.empty();
     *     }
     * });
     * ```
     *
     * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in [visitor] and
     *   the current variant is unknown.
     */
    fun <T> accept(visitor: Visitor<T>): T =
        when {
            string != null -> visitor.visitString(string)
            bool != null -> visitor.visitBool(bool)
            else -> visitor.unknown(_json)
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
    fun validate(): DecisionChoiceValue = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitString(string: String) {}

                override fun visitBool(bool: Boolean) {}
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
                override fun visitString(string: String) = 1

                override fun visitBool(bool: Boolean) = 1

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is DecisionChoiceValue && string == other.string && bool == other.bool
    }

    override fun hashCode(): Int = Objects.hash(string, bool)

    override fun toString(): String =
        when {
            string != null -> "DecisionChoiceValue{string=$string}"
            bool != null -> "DecisionChoiceValue{bool=$bool}"
            _json != null -> "DecisionChoiceValue{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid DecisionChoiceValue")
        }

    companion object {

        @JvmStatic fun ofString(string: String) = DecisionChoiceValue(string = string)

        @JvmStatic fun ofBool(bool: Boolean) = DecisionChoiceValue(bool = bool)
    }

    /**
     * An interface that defines how to map each variant of [DecisionChoiceValue] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        fun visitString(string: String): T

        fun visitBool(bool: Boolean): T

        /**
         * Maps an unknown variant of [DecisionChoiceValue] to a value of type [T].
         *
         * An instance of [DecisionChoiceValue] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown DecisionChoiceValue")
        }
    }

    internal class Deserializer :
        BaseDeserializer<DecisionChoiceValue>(DecisionChoiceValue::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): DecisionChoiceValue {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<String>())?.let {
                            DecisionChoiceValue(string = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<Boolean>())?.let {
                            DecisionChoiceValue(bool = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from object).
                0 -> DecisionChoiceValue(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer : BaseSerializer<DecisionChoiceValue>(DecisionChoiceValue::class) {

        override fun serialize(
            value: DecisionChoiceValue,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.string != null -> generator.writeObject(value.string)
                value.bool != null -> generator.writeObject(value.bool)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid DecisionChoiceValue")
            }
        }
    }
}
