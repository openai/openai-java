// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

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

/** The text or model-input content supplied as a function result. */
@JsonDeserialize(using = AgentFunctionCallOutput.Deserializer::class)
@JsonSerialize(using = AgentFunctionCallOutput.Serializer::class)
class AgentFunctionCallOutput
private constructor(
    private val string: String? = null,
    private val inputContents: List<InputContent>? = null,
    private val _json: JsonValue? = null,
) {

    fun string(): Optional<String> = Optional.ofNullable(string)

    fun inputContents(): Optional<List<InputContent>> = Optional.ofNullable(inputContents)

    fun isString(): Boolean = string != null

    fun isInputContents(): Boolean = inputContents != null

    fun asString(): String = string.getOrThrow("string")

    fun asInputContents(): List<InputContent> = inputContents.getOrThrow("inputContents")

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
     * Optional<String> result = agentFunctionCallOutput.accept(new AgentFunctionCallOutput.Visitor<Optional<String>>() {
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
            inputContents != null -> visitor.visitInputContents(inputContents)
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
    fun validate(): AgentFunctionCallOutput = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitString(string: String) {}

                override fun visitInputContents(inputContents: List<InputContent>) {
                    inputContents.forEach { it.validate() }
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

                override fun visitInputContents(inputContents: List<InputContent>) =
                    inputContents.sumOf { it.validity().toInt() }

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AgentFunctionCallOutput &&
            string == other.string &&
            inputContents == other.inputContents
    }

    override fun hashCode(): Int = Objects.hash(string, inputContents)

    override fun toString(): String =
        when {
            string != null -> "AgentFunctionCallOutput{string=$string}"
            inputContents != null -> "AgentFunctionCallOutput{inputContents=$inputContents}"
            _json != null -> "AgentFunctionCallOutput{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid AgentFunctionCallOutput")
        }

    companion object {

        @JvmStatic fun ofString(string: String) = AgentFunctionCallOutput(string = string)

        @JvmStatic
        fun ofInputContents(inputContents: List<InputContent>) =
            AgentFunctionCallOutput(inputContents = inputContents.toImmutable())
    }

    /**
     * An interface that defines how to map each variant of [AgentFunctionCallOutput] to a value of
     * type [T].
     */
    interface Visitor<out T> {

        fun visitString(string: String): T

        fun visitInputContents(inputContents: List<InputContent>): T

        /**
         * Maps an unknown variant of [AgentFunctionCallOutput] to a value of type [T].
         *
         * An instance of [AgentFunctionCallOutput] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown AgentFunctionCallOutput: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<AgentFunctionCallOutput>(AgentFunctionCallOutput::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): AgentFunctionCallOutput {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<String>())?.let {
                            AgentFunctionCallOutput(string = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<List<InputContent>>())?.let {
                            AgentFunctionCallOutput(inputContents = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> AgentFunctionCallOutput(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer :
        BaseSerializer<AgentFunctionCallOutput>(AgentFunctionCallOutput::class) {

        override fun serialize(
            value: AgentFunctionCallOutput,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.string != null -> generator.writeObject(value.string)
                value.inputContents != null -> generator.writeObject(value.inputContents)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid AgentFunctionCallOutput")
            }
        }
    }
}
