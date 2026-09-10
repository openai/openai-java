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

/** A function result represented as text or supported model-input content. */
@JsonDeserialize(using = AgentFunctionCallOutputParam.Deserializer::class)
@JsonSerialize(using = AgentFunctionCallOutputParam.Serializer::class)
class AgentFunctionCallOutputParam
private constructor(
    private val string: String? = null,
    private val inputContentParams: List<InputContentParam>? = null,
    private val _json: JsonValue? = null,
) {

    fun string(): Optional<String> = Optional.ofNullable(string)

    fun inputContentParams(): Optional<List<InputContentParam>> =
        Optional.ofNullable(inputContentParams)

    fun isString(): Boolean = string != null

    fun isInputContentParams(): Boolean = inputContentParams != null

    fun asString(): String = string.getOrThrow("string")

    fun asInputContentParams(): List<InputContentParam> =
        inputContentParams.getOrThrow("inputContentParams")

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
     * Optional<String> result = agentFunctionCallOutputParam.accept(new AgentFunctionCallOutputParam.Visitor<Optional<String>>() {
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
            inputContentParams != null -> visitor.visitInputContentParams(inputContentParams)
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
    fun validate(): AgentFunctionCallOutputParam = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitString(string: String) {}

                override fun visitInputContentParams(inputContentParams: List<InputContentParam>) {
                    inputContentParams.forEach { it.validate() }
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

                override fun visitInputContentParams(inputContentParams: List<InputContentParam>) =
                    inputContentParams.sumOf { it.validity().toInt() }

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AgentFunctionCallOutputParam &&
            string == other.string &&
            inputContentParams == other.inputContentParams
    }

    override fun hashCode(): Int = Objects.hash(string, inputContentParams)

    override fun toString(): String =
        when {
            string != null -> "AgentFunctionCallOutputParam{string=$string}"
            inputContentParams != null ->
                "AgentFunctionCallOutputParam{inputContentParams=$inputContentParams}"
            _json != null -> "AgentFunctionCallOutputParam{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid AgentFunctionCallOutputParam")
        }

    companion object {

        @JvmStatic fun ofString(string: String) = AgentFunctionCallOutputParam(string = string)

        @JvmStatic
        fun ofInputContentParams(inputContentParams: List<InputContentParam>) =
            AgentFunctionCallOutputParam(inputContentParams = inputContentParams.toImmutable())
    }

    /**
     * An interface that defines how to map each variant of [AgentFunctionCallOutputParam] to a
     * value of type [T].
     */
    interface Visitor<out T> {

        fun visitString(string: String): T

        fun visitInputContentParams(inputContentParams: List<InputContentParam>): T

        /**
         * Maps an unknown variant of [AgentFunctionCallOutputParam] to a value of type [T].
         *
         * An instance of [AgentFunctionCallOutputParam] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown AgentFunctionCallOutputParam: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<AgentFunctionCallOutputParam>(AgentFunctionCallOutputParam::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): AgentFunctionCallOutputParam {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<String>())?.let {
                            AgentFunctionCallOutputParam(string = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<List<InputContentParam>>())?.let {
                            AgentFunctionCallOutputParam(inputContentParams = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> AgentFunctionCallOutputParam(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer :
        BaseSerializer<AgentFunctionCallOutputParam>(AgentFunctionCallOutputParam::class) {

        override fun serialize(
            value: AgentFunctionCallOutputParam,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.string != null -> generator.writeObject(value.string)
                value.inputContentParams != null -> generator.writeObject(value.inputContentParams)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid AgentFunctionCallOutputParam")
            }
        }
    }
}
