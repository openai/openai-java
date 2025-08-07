// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

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
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A function tool that can be used to generate a response. */
@JsonDeserialize(using = ChatCompletionTool.Deserializer::class)
@JsonSerialize(using = ChatCompletionTool.Serializer::class)
class ChatCompletionTool
private constructor(
    private val function: ChatCompletionFunctionTool? = null,
    private val custom: ChatCompletionCustomTool? = null,
    private val _json: JsonValue? = null,
) {

    /** A function tool that can be used to generate a response. */
    fun function(): Optional<ChatCompletionFunctionTool> = Optional.ofNullable(function)

    /** A custom tool that processes input using a specified format. */
    fun custom(): Optional<ChatCompletionCustomTool> = Optional.ofNullable(custom)

    fun isFunction(): Boolean = function != null

    fun isCustom(): Boolean = custom != null

    /** A function tool that can be used to generate a response. */
    fun asFunction(): ChatCompletionFunctionTool = function.getOrThrow("function")

    /** A custom tool that processes input using a specified format. */
    fun asCustom(): ChatCompletionCustomTool = custom.getOrThrow("custom")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            function != null -> visitor.visitFunction(function)
            custom != null -> visitor.visitCustom(custom)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): ChatCompletionTool = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitFunction(function: ChatCompletionFunctionTool) {
                    function.validate()
                }

                override fun visitCustom(custom: ChatCompletionCustomTool) {
                    custom.validate()
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
                override fun visitFunction(function: ChatCompletionFunctionTool) =
                    function.validity()

                override fun visitCustom(custom: ChatCompletionCustomTool) = custom.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionTool && function == other.function && custom == other.custom /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(function, custom) /* spotless:on */

    override fun toString(): String =
        when {
            function != null -> "ChatCompletionTool{function=$function}"
            custom != null -> "ChatCompletionTool{custom=$custom}"
            _json != null -> "ChatCompletionTool{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ChatCompletionTool")
        }

    companion object {

        /** A function tool that can be used to generate a response. */
        @JvmStatic
        fun ofFunction(function: ChatCompletionFunctionTool) =
            ChatCompletionTool(function = function)

        /** A custom tool that processes input using a specified format. */
        @JvmStatic
        fun ofCustom(custom: ChatCompletionCustomTool) = ChatCompletionTool(custom = custom)
    }

    /**
     * An interface that defines how to map each variant of [ChatCompletionTool] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        /** A function tool that can be used to generate a response. */
        fun visitFunction(function: ChatCompletionFunctionTool): T

        /** A custom tool that processes input using a specified format. */
        fun visitCustom(custom: ChatCompletionCustomTool): T

        /**
         * Maps an unknown variant of [ChatCompletionTool] to a value of type [T].
         *
         * An instance of [ChatCompletionTool] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ChatCompletionTool: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<ChatCompletionTool>(ChatCompletionTool::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ChatCompletionTool {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "function" -> {
                    return tryDeserialize(node, jacksonTypeRef<ChatCompletionFunctionTool>())?.let {
                        ChatCompletionTool(function = it, _json = json)
                    } ?: ChatCompletionTool(_json = json)
                }
                "custom" -> {
                    return tryDeserialize(node, jacksonTypeRef<ChatCompletionCustomTool>())?.let {
                        ChatCompletionTool(custom = it, _json = json)
                    } ?: ChatCompletionTool(_json = json)
                }
            }

            return ChatCompletionTool(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<ChatCompletionTool>(ChatCompletionTool::class) {

        override fun serialize(
            value: ChatCompletionTool,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.function != null -> generator.writeObject(value.function)
                value.custom != null -> generator.writeObject(value.custom)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ChatCompletionTool")
            }
        }
    }
}
