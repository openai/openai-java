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

/** A call to a function tool created by the model. */
@JsonDeserialize(using = ChatCompletionMessageToolCall.Deserializer::class)
@JsonSerialize(using = ChatCompletionMessageToolCall.Serializer::class)
class ChatCompletionMessageToolCall
private constructor(
    private val function: ChatCompletionMessageFunctionToolCall? = null,
    private val custom: ChatCompletionMessageCustomToolCall? = null,
    private val _json: JsonValue? = null,
) {

    /** A call to a function tool created by the model. */
    fun function(): Optional<ChatCompletionMessageFunctionToolCall> = Optional.ofNullable(function)

    /** A call to a custom tool created by the model. */
    fun custom(): Optional<ChatCompletionMessageCustomToolCall> = Optional.ofNullable(custom)

    fun isFunction(): Boolean = function != null

    fun isCustom(): Boolean = custom != null

    /** A call to a function tool created by the model. */
    fun asFunction(): ChatCompletionMessageFunctionToolCall = function.getOrThrow("function")

    /** A call to a custom tool created by the model. */
    fun asCustom(): ChatCompletionMessageCustomToolCall = custom.getOrThrow("custom")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            function != null -> visitor.visitFunction(function)
            custom != null -> visitor.visitCustom(custom)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): ChatCompletionMessageToolCall = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitFunction(function: ChatCompletionMessageFunctionToolCall) {
                    function.validate()
                }

                override fun visitCustom(custom: ChatCompletionMessageCustomToolCall) {
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
                override fun visitFunction(function: ChatCompletionMessageFunctionToolCall) =
                    function.validity()

                override fun visitCustom(custom: ChatCompletionMessageCustomToolCall) =
                    custom.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ChatCompletionMessageToolCall &&
            function == other.function &&
            custom == other.custom
    }

    override fun hashCode(): Int = Objects.hash(function, custom)

    override fun toString(): String =
        when {
            function != null -> "ChatCompletionMessageToolCall{function=$function}"
            custom != null -> "ChatCompletionMessageToolCall{custom=$custom}"
            _json != null -> "ChatCompletionMessageToolCall{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ChatCompletionMessageToolCall")
        }

    companion object {

        /** A call to a function tool created by the model. */
        @JvmStatic
        fun ofFunction(function: ChatCompletionMessageFunctionToolCall) =
            ChatCompletionMessageToolCall(function = function)

        /** A call to a custom tool created by the model. */
        @JvmStatic
        fun ofCustom(custom: ChatCompletionMessageCustomToolCall) =
            ChatCompletionMessageToolCall(custom = custom)
    }

    /**
     * An interface that defines how to map each variant of [ChatCompletionMessageToolCall] to a
     * value of type [T].
     */
    interface Visitor<out T> {

        /** A call to a function tool created by the model. */
        fun visitFunction(function: ChatCompletionMessageFunctionToolCall): T

        /** A call to a custom tool created by the model. */
        fun visitCustom(custom: ChatCompletionMessageCustomToolCall): T

        /**
         * Maps an unknown variant of [ChatCompletionMessageToolCall] to a value of type [T].
         *
         * An instance of [ChatCompletionMessageToolCall] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ChatCompletionMessageToolCall: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<ChatCompletionMessageToolCall>(ChatCompletionMessageToolCall::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ChatCompletionMessageToolCall {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "function" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ChatCompletionMessageFunctionToolCall>(),
                        )
                        ?.let { ChatCompletionMessageToolCall(function = it, _json = json) }
                        ?: ChatCompletionMessageToolCall(_json = json)
                }
                "custom" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ChatCompletionMessageCustomToolCall>(),
                        )
                        ?.let { ChatCompletionMessageToolCall(custom = it, _json = json) }
                        ?: ChatCompletionMessageToolCall(_json = json)
                }
            }

            return ChatCompletionMessageToolCall(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<ChatCompletionMessageToolCall>(ChatCompletionMessageToolCall::class) {

        override fun serialize(
            value: ChatCompletionMessageToolCall,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.function != null -> generator.writeObject(value.function)
                value.custom != null -> generator.writeObject(value.custom)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ChatCompletionMessageToolCall")
            }
        }
    }
}
