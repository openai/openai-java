// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

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
import com.openai.models.responses.ToolChoiceFunction
import com.openai.models.responses.ToolChoiceMcp
import com.openai.models.responses.ToolChoiceOptions
import java.util.Objects
import java.util.Optional

/**
 * How the model chooses tools. Provide one of the string modes or force a specific function/MCP
 * tool.
 */
@JsonDeserialize(using = RealtimeToolChoiceConfig.Deserializer::class)
@JsonSerialize(using = RealtimeToolChoiceConfig.Serializer::class)
class RealtimeToolChoiceConfig
private constructor(
    private val toolChoiceOptions: ToolChoiceOptions? = null,
    private val toolChoiceFunction: ToolChoiceFunction? = null,
    private val toolChoiceMcp: ToolChoiceMcp? = null,
    private val _json: JsonValue? = null,
) {

    /**
     * Controls which (if any) tool is called by the model.
     *
     * `none` means the model will not call any tool and instead generates a message.
     *
     * `auto` means the model can pick between generating a message or calling one or more tools.
     *
     * `required` means the model must call one or more tools.
     */
    fun toolChoiceOptions(): Optional<ToolChoiceOptions> = Optional.ofNullable(toolChoiceOptions)

    /** Use this option to force the model to call a specific function. */
    fun toolChoiceFunction(): Optional<ToolChoiceFunction> = Optional.ofNullable(toolChoiceFunction)

    /** Use this option to force the model to call a specific tool on a remote MCP server. */
    fun toolChoiceMcp(): Optional<ToolChoiceMcp> = Optional.ofNullable(toolChoiceMcp)

    fun isToolChoiceOptions(): Boolean = toolChoiceOptions != null

    fun isToolChoiceFunction(): Boolean = toolChoiceFunction != null

    fun isToolChoiceMcp(): Boolean = toolChoiceMcp != null

    /**
     * Controls which (if any) tool is called by the model.
     *
     * `none` means the model will not call any tool and instead generates a message.
     *
     * `auto` means the model can pick between generating a message or calling one or more tools.
     *
     * `required` means the model must call one or more tools.
     */
    fun asToolChoiceOptions(): ToolChoiceOptions = toolChoiceOptions.getOrThrow("toolChoiceOptions")

    /** Use this option to force the model to call a specific function. */
    fun asToolChoiceFunction(): ToolChoiceFunction =
        toolChoiceFunction.getOrThrow("toolChoiceFunction")

    /** Use this option to force the model to call a specific tool on a remote MCP server. */
    fun asToolChoiceMcp(): ToolChoiceMcp = toolChoiceMcp.getOrThrow("toolChoiceMcp")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            toolChoiceOptions != null -> visitor.visitToolChoiceOptions(toolChoiceOptions)
            toolChoiceFunction != null -> visitor.visitToolChoiceFunction(toolChoiceFunction)
            toolChoiceMcp != null -> visitor.visitToolChoiceMcp(toolChoiceMcp)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): RealtimeToolChoiceConfig = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitToolChoiceOptions(toolChoiceOptions: ToolChoiceOptions) {
                    toolChoiceOptions.validate()
                }

                override fun visitToolChoiceFunction(toolChoiceFunction: ToolChoiceFunction) {
                    toolChoiceFunction.validate()
                }

                override fun visitToolChoiceMcp(toolChoiceMcp: ToolChoiceMcp) {
                    toolChoiceMcp.validate()
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
                override fun visitToolChoiceOptions(toolChoiceOptions: ToolChoiceOptions) =
                    toolChoiceOptions.validity()

                override fun visitToolChoiceFunction(toolChoiceFunction: ToolChoiceFunction) =
                    toolChoiceFunction.validity()

                override fun visitToolChoiceMcp(toolChoiceMcp: ToolChoiceMcp) =
                    toolChoiceMcp.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RealtimeToolChoiceConfig &&
            toolChoiceOptions == other.toolChoiceOptions &&
            toolChoiceFunction == other.toolChoiceFunction &&
            toolChoiceMcp == other.toolChoiceMcp
    }

    override fun hashCode(): Int =
        Objects.hash(toolChoiceOptions, toolChoiceFunction, toolChoiceMcp)

    override fun toString(): String =
        when {
            toolChoiceOptions != null ->
                "RealtimeToolChoiceConfig{toolChoiceOptions=$toolChoiceOptions}"
            toolChoiceFunction != null ->
                "RealtimeToolChoiceConfig{toolChoiceFunction=$toolChoiceFunction}"
            toolChoiceMcp != null -> "RealtimeToolChoiceConfig{toolChoiceMcp=$toolChoiceMcp}"
            _json != null -> "RealtimeToolChoiceConfig{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid RealtimeToolChoiceConfig")
        }

    companion object {

        /**
         * Controls which (if any) tool is called by the model.
         *
         * `none` means the model will not call any tool and instead generates a message.
         *
         * `auto` means the model can pick between generating a message or calling one or more
         * tools.
         *
         * `required` means the model must call one or more tools.
         */
        @JvmStatic
        fun ofToolChoiceOptions(toolChoiceOptions: ToolChoiceOptions) =
            RealtimeToolChoiceConfig(toolChoiceOptions = toolChoiceOptions)

        /** Use this option to force the model to call a specific function. */
        @JvmStatic
        fun ofToolChoiceFunction(toolChoiceFunction: ToolChoiceFunction) =
            RealtimeToolChoiceConfig(toolChoiceFunction = toolChoiceFunction)

        /** Use this option to force the model to call a specific tool on a remote MCP server. */
        @JvmStatic
        fun ofToolChoiceMcp(toolChoiceMcp: ToolChoiceMcp) =
            RealtimeToolChoiceConfig(toolChoiceMcp = toolChoiceMcp)
    }

    /**
     * An interface that defines how to map each variant of [RealtimeToolChoiceConfig] to a value of
     * type [T].
     */
    interface Visitor<out T> {

        /**
         * Controls which (if any) tool is called by the model.
         *
         * `none` means the model will not call any tool and instead generates a message.
         *
         * `auto` means the model can pick between generating a message or calling one or more
         * tools.
         *
         * `required` means the model must call one or more tools.
         */
        fun visitToolChoiceOptions(toolChoiceOptions: ToolChoiceOptions): T

        /** Use this option to force the model to call a specific function. */
        fun visitToolChoiceFunction(toolChoiceFunction: ToolChoiceFunction): T

        /** Use this option to force the model to call a specific tool on a remote MCP server. */
        fun visitToolChoiceMcp(toolChoiceMcp: ToolChoiceMcp): T

        /**
         * Maps an unknown variant of [RealtimeToolChoiceConfig] to a value of type [T].
         *
         * An instance of [RealtimeToolChoiceConfig] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown RealtimeToolChoiceConfig: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<RealtimeToolChoiceConfig>(RealtimeToolChoiceConfig::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): RealtimeToolChoiceConfig {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<ToolChoiceOptions>())?.let {
                            RealtimeToolChoiceConfig(toolChoiceOptions = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<ToolChoiceFunction>())?.let {
                            RealtimeToolChoiceConfig(toolChoiceFunction = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<ToolChoiceMcp>())?.let {
                            RealtimeToolChoiceConfig(toolChoiceMcp = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> RealtimeToolChoiceConfig(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer :
        BaseSerializer<RealtimeToolChoiceConfig>(RealtimeToolChoiceConfig::class) {

        override fun serialize(
            value: RealtimeToolChoiceConfig,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.toolChoiceOptions != null -> generator.writeObject(value.toolChoiceOptions)
                value.toolChoiceFunction != null -> generator.writeObject(value.toolChoiceFunction)
                value.toolChoiceMcp != null -> generator.writeObject(value.toolChoiceMcp)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid RealtimeToolChoiceConfig")
            }
        }
    }
}
