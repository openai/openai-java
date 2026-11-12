// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

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
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/** The text input to the model. */
@JsonDeserialize(using = DecisionToolOutput.Deserializer::class)
@JsonSerialize(using = DecisionToolOutput.Serializer::class)
class DecisionToolOutput
private constructor(
    private val string: String? = null,
    private val parts: List<DecisionToolOutputContentPart>? = null,
    private val _json: JsonValue? = null,
) {

    /** The text input to the model. */
    fun string(): Optional<String> = Optional.ofNullable(string)

    fun parts(): Optional<List<DecisionToolOutputContentPart>> = Optional.ofNullable(parts)

    fun isString(): Boolean = string != null

    fun isParts(): Boolean = parts != null

    /** The text input to the model. */
    fun asString(): String = string.getOrThrow("string")

    fun asParts(): List<DecisionToolOutputContentPart> = parts.getOrThrow("parts")

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
     * Optional<String> result = decisionToolOutput.accept(new DecisionToolOutput.Visitor<Optional<String>>() {
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
            parts != null -> visitor.visitParts(parts)
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
    fun validate(): DecisionToolOutput = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitString(string: String) {}

                override fun visitParts(parts: List<DecisionToolOutputContentPart>) {
                    parts.forEach { it.validate() }
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
                override fun visitString(string: String) = 1

                override fun visitParts(parts: List<DecisionToolOutputContentPart>) =
                    parts.sumOf { it.validity().toInt() }

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is DecisionToolOutput &&
            string == other.string &&
            parts == other.parts &&
            (string != null || parts != null || _json == other._json)
    }

    override fun hashCode(): Int =
        if (string == null && parts == null) Objects.hash(_json) else Objects.hash(string, parts)

    override fun toString(): String =
        when {
            string != null -> "DecisionToolOutput{string=$string}"
            parts != null -> "DecisionToolOutput{parts=$parts}"
            _json != null -> "DecisionToolOutput{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid DecisionToolOutput")
        }

    companion object {

        /** The text input to the model. */
        @JvmStatic fun ofString(string: String) = DecisionToolOutput(string = string)

        @JvmStatic
        fun ofParts(parts: List<DecisionToolOutputContentPart>) =
            DecisionToolOutput(parts = parts.toImmutable())
    }

    /**
     * An interface that defines how to map each variant of [DecisionToolOutput] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        /** The text input to the model. */
        fun visitString(string: String): T = unknown(JsonValue.from(string))

        fun visitParts(parts: List<DecisionToolOutputContentPart>): T =
            unknown(JsonValue.from(parts))

        /**
         * Maps an unknown variant of [DecisionToolOutput] to a value of type [T].
         *
         * An instance of [DecisionToolOutput] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * Unhandled known JSON variants reach this method as JSON values.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown DecisionToolOutput")
        }
    }

    internal class Deserializer : BaseDeserializer<DecisionToolOutput>(DecisionToolOutput::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): DecisionToolOutput {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<String>())?.let {
                            DecisionToolOutput(string = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<List<DecisionToolOutputContentPart>>())
                            ?.let { DecisionToolOutput(parts = it, _json = json) },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> DecisionToolOutput(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer : BaseSerializer<DecisionToolOutput>(DecisionToolOutput::class) {

        override fun serialize(
            value: DecisionToolOutput,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.string != null -> generator.writeObject(value.string)
                value.parts != null -> generator.writeObject(value.parts)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid DecisionToolOutput")
            }
        }
    }
}
