// File generated from our OpenAPI spec by Stainless.

package com.openai.models

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

/**
 * Developer-provided instructions that the model should follow, regardless of messages sent by the
 * user. With o1 models and newer, `developer` messages replace the previous `system` messages.
 */
@JsonDeserialize(using = ChatCompletionMessageParam.Deserializer::class)
@JsonSerialize(using = ChatCompletionMessageParam.Serializer::class)
class ChatCompletionMessageParam
private constructor(
    private val chatCompletionDeveloperMessageParam: ChatCompletionDeveloperMessageParam? = null,
    private val chatCompletionSystemMessageParam: ChatCompletionSystemMessageParam? = null,
    private val chatCompletionUserMessageParam: ChatCompletionUserMessageParam? = null,
    private val chatCompletionAssistantMessageParam: ChatCompletionAssistantMessageParam? = null,
    private val chatCompletionToolMessageParam: ChatCompletionToolMessageParam? = null,
    private val chatCompletionFunctionMessageParam: ChatCompletionFunctionMessageParam? = null,
    private val _json: JsonValue? = null,
) {

    /**
     * Developer-provided instructions that the model should follow, regardless of messages sent by
     * the user. With o1 models and newer, `developer` messages replace the previous `system`
     * messages.
     */
    fun chatCompletionDeveloperMessageParam(): Optional<ChatCompletionDeveloperMessageParam> =
        Optional.ofNullable(chatCompletionDeveloperMessageParam)

    /**
     * Developer-provided instructions that the model should follow, regardless of messages sent by
     * the user. With o1 models and newer, use `developer` messages for this purpose instead.
     */
    fun chatCompletionSystemMessageParam(): Optional<ChatCompletionSystemMessageParam> =
        Optional.ofNullable(chatCompletionSystemMessageParam)

    /** Messages sent by an end user, containing prompts or additional context information. */
    fun chatCompletionUserMessageParam(): Optional<ChatCompletionUserMessageParam> =
        Optional.ofNullable(chatCompletionUserMessageParam)

    /** Messages sent by the model in response to user messages. */
    fun chatCompletionAssistantMessageParam(): Optional<ChatCompletionAssistantMessageParam> =
        Optional.ofNullable(chatCompletionAssistantMessageParam)

    fun chatCompletionToolMessageParam(): Optional<ChatCompletionToolMessageParam> =
        Optional.ofNullable(chatCompletionToolMessageParam)

    @Deprecated("deprecated")
    fun chatCompletionFunctionMessageParam(): Optional<ChatCompletionFunctionMessageParam> =
        Optional.ofNullable(chatCompletionFunctionMessageParam)

    fun isChatCompletionDeveloperMessageParam(): Boolean =
        chatCompletionDeveloperMessageParam != null

    fun isChatCompletionSystemMessageParam(): Boolean = chatCompletionSystemMessageParam != null

    fun isChatCompletionUserMessageParam(): Boolean = chatCompletionUserMessageParam != null

    fun isChatCompletionAssistantMessageParam(): Boolean =
        chatCompletionAssistantMessageParam != null

    fun isChatCompletionToolMessageParam(): Boolean = chatCompletionToolMessageParam != null

    @Deprecated("deprecated")
    fun isChatCompletionFunctionMessageParam(): Boolean = chatCompletionFunctionMessageParam != null

    /**
     * Developer-provided instructions that the model should follow, regardless of messages sent by
     * the user. With o1 models and newer, `developer` messages replace the previous `system`
     * messages.
     */
    fun asChatCompletionDeveloperMessageParam(): ChatCompletionDeveloperMessageParam =
        chatCompletionDeveloperMessageParam.getOrThrow("chatCompletionDeveloperMessageParam")

    /**
     * Developer-provided instructions that the model should follow, regardless of messages sent by
     * the user. With o1 models and newer, use `developer` messages for this purpose instead.
     */
    fun asChatCompletionSystemMessageParam(): ChatCompletionSystemMessageParam =
        chatCompletionSystemMessageParam.getOrThrow("chatCompletionSystemMessageParam")

    /** Messages sent by an end user, containing prompts or additional context information. */
    fun asChatCompletionUserMessageParam(): ChatCompletionUserMessageParam =
        chatCompletionUserMessageParam.getOrThrow("chatCompletionUserMessageParam")

    /** Messages sent by the model in response to user messages. */
    fun asChatCompletionAssistantMessageParam(): ChatCompletionAssistantMessageParam =
        chatCompletionAssistantMessageParam.getOrThrow("chatCompletionAssistantMessageParam")

    fun asChatCompletionToolMessageParam(): ChatCompletionToolMessageParam =
        chatCompletionToolMessageParam.getOrThrow("chatCompletionToolMessageParam")

    @Deprecated("deprecated")
    fun asChatCompletionFunctionMessageParam(): ChatCompletionFunctionMessageParam =
        chatCompletionFunctionMessageParam.getOrThrow("chatCompletionFunctionMessageParam")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            chatCompletionDeveloperMessageParam != null ->
                visitor.visitChatCompletionDeveloperMessageParam(
                    chatCompletionDeveloperMessageParam
                )
            chatCompletionSystemMessageParam != null ->
                visitor.visitChatCompletionSystemMessageParam(chatCompletionSystemMessageParam)
            chatCompletionUserMessageParam != null ->
                visitor.visitChatCompletionUserMessageParam(chatCompletionUserMessageParam)
            chatCompletionAssistantMessageParam != null ->
                visitor.visitChatCompletionAssistantMessageParam(
                    chatCompletionAssistantMessageParam
                )
            chatCompletionToolMessageParam != null ->
                visitor.visitChatCompletionToolMessageParam(chatCompletionToolMessageParam)
            chatCompletionFunctionMessageParam != null ->
                visitor.visitChatCompletionFunctionMessageParam(chatCompletionFunctionMessageParam)
            else -> visitor.unknown(_json)
        }
    }

    private var validated: Boolean = false

    fun validate(): ChatCompletionMessageParam = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitChatCompletionDeveloperMessageParam(
                    chatCompletionDeveloperMessageParam: ChatCompletionDeveloperMessageParam
                ) {
                    chatCompletionDeveloperMessageParam.validate()
                }

                override fun visitChatCompletionSystemMessageParam(
                    chatCompletionSystemMessageParam: ChatCompletionSystemMessageParam
                ) {
                    chatCompletionSystemMessageParam.validate()
                }

                override fun visitChatCompletionUserMessageParam(
                    chatCompletionUserMessageParam: ChatCompletionUserMessageParam
                ) {
                    chatCompletionUserMessageParam.validate()
                }

                override fun visitChatCompletionAssistantMessageParam(
                    chatCompletionAssistantMessageParam: ChatCompletionAssistantMessageParam
                ) {
                    chatCompletionAssistantMessageParam.validate()
                }

                override fun visitChatCompletionToolMessageParam(
                    chatCompletionToolMessageParam: ChatCompletionToolMessageParam
                ) {
                    chatCompletionToolMessageParam.validate()
                }

                override fun visitChatCompletionFunctionMessageParam(
                    chatCompletionFunctionMessageParam: ChatCompletionFunctionMessageParam
                ) {
                    chatCompletionFunctionMessageParam.validate()
                }
            }
        )
        validated = true
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionMessageParam && chatCompletionDeveloperMessageParam == other.chatCompletionDeveloperMessageParam && chatCompletionSystemMessageParam == other.chatCompletionSystemMessageParam && chatCompletionUserMessageParam == other.chatCompletionUserMessageParam && chatCompletionAssistantMessageParam == other.chatCompletionAssistantMessageParam && chatCompletionToolMessageParam == other.chatCompletionToolMessageParam && chatCompletionFunctionMessageParam == other.chatCompletionFunctionMessageParam /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(chatCompletionDeveloperMessageParam, chatCompletionSystemMessageParam, chatCompletionUserMessageParam, chatCompletionAssistantMessageParam, chatCompletionToolMessageParam, chatCompletionFunctionMessageParam) /* spotless:on */

    override fun toString(): String =
        when {
            chatCompletionDeveloperMessageParam != null ->
                "ChatCompletionMessageParam{chatCompletionDeveloperMessageParam=$chatCompletionDeveloperMessageParam}"
            chatCompletionSystemMessageParam != null ->
                "ChatCompletionMessageParam{chatCompletionSystemMessageParam=$chatCompletionSystemMessageParam}"
            chatCompletionUserMessageParam != null ->
                "ChatCompletionMessageParam{chatCompletionUserMessageParam=$chatCompletionUserMessageParam}"
            chatCompletionAssistantMessageParam != null ->
                "ChatCompletionMessageParam{chatCompletionAssistantMessageParam=$chatCompletionAssistantMessageParam}"
            chatCompletionToolMessageParam != null ->
                "ChatCompletionMessageParam{chatCompletionToolMessageParam=$chatCompletionToolMessageParam}"
            chatCompletionFunctionMessageParam != null ->
                "ChatCompletionMessageParam{chatCompletionFunctionMessageParam=$chatCompletionFunctionMessageParam}"
            _json != null -> "ChatCompletionMessageParam{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ChatCompletionMessageParam")
        }

    companion object {

        /**
         * Developer-provided instructions that the model should follow, regardless of messages sent
         * by the user. With o1 models and newer, `developer` messages replace the previous `system`
         * messages.
         */
        @JvmStatic
        fun ofChatCompletionDeveloperMessageParam(
            chatCompletionDeveloperMessageParam: ChatCompletionDeveloperMessageParam
        ) =
            ChatCompletionMessageParam(
                chatCompletionDeveloperMessageParam = chatCompletionDeveloperMessageParam
            )

        /**
         * Developer-provided instructions that the model should follow, regardless of messages sent
         * by the user. With o1 models and newer, use `developer` messages for this purpose instead.
         */
        @JvmStatic
        fun ofChatCompletionSystemMessageParam(
            chatCompletionSystemMessageParam: ChatCompletionSystemMessageParam
        ) =
            ChatCompletionMessageParam(
                chatCompletionSystemMessageParam = chatCompletionSystemMessageParam
            )

        /** Messages sent by an end user, containing prompts or additional context information. */
        @JvmStatic
        fun ofChatCompletionUserMessageParam(
            chatCompletionUserMessageParam: ChatCompletionUserMessageParam
        ) =
            ChatCompletionMessageParam(
                chatCompletionUserMessageParam = chatCompletionUserMessageParam
            )

        /** Messages sent by the model in response to user messages. */
        @JvmStatic
        fun ofChatCompletionAssistantMessageParam(
            chatCompletionAssistantMessageParam: ChatCompletionAssistantMessageParam
        ) =
            ChatCompletionMessageParam(
                chatCompletionAssistantMessageParam = chatCompletionAssistantMessageParam
            )

        @JvmStatic
        fun ofChatCompletionToolMessageParam(
            chatCompletionToolMessageParam: ChatCompletionToolMessageParam
        ) =
            ChatCompletionMessageParam(
                chatCompletionToolMessageParam = chatCompletionToolMessageParam
            )

        @Deprecated("deprecated")
        @JvmStatic
        fun ofChatCompletionFunctionMessageParam(
            chatCompletionFunctionMessageParam: ChatCompletionFunctionMessageParam
        ) =
            ChatCompletionMessageParam(
                chatCompletionFunctionMessageParam = chatCompletionFunctionMessageParam
            )
    }

    interface Visitor<out T> {

        /**
         * Developer-provided instructions that the model should follow, regardless of messages sent
         * by the user. With o1 models and newer, `developer` messages replace the previous `system`
         * messages.
         */
        fun visitChatCompletionDeveloperMessageParam(
            chatCompletionDeveloperMessageParam: ChatCompletionDeveloperMessageParam
        ): T

        /**
         * Developer-provided instructions that the model should follow, regardless of messages sent
         * by the user. With o1 models and newer, use `developer` messages for this purpose instead.
         */
        fun visitChatCompletionSystemMessageParam(
            chatCompletionSystemMessageParam: ChatCompletionSystemMessageParam
        ): T

        /** Messages sent by an end user, containing prompts or additional context information. */
        fun visitChatCompletionUserMessageParam(
            chatCompletionUserMessageParam: ChatCompletionUserMessageParam
        ): T

        /** Messages sent by the model in response to user messages. */
        fun visitChatCompletionAssistantMessageParam(
            chatCompletionAssistantMessageParam: ChatCompletionAssistantMessageParam
        ): T

        fun visitChatCompletionToolMessageParam(
            chatCompletionToolMessageParam: ChatCompletionToolMessageParam
        ): T

        @Deprecated("deprecated")
        fun visitChatCompletionFunctionMessageParam(
            chatCompletionFunctionMessageParam: ChatCompletionFunctionMessageParam
        ): T

        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ChatCompletionMessageParam: $json")
        }
    }

    class Deserializer :
        BaseDeserializer<ChatCompletionMessageParam>(ChatCompletionMessageParam::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ChatCompletionMessageParam {
            val json = JsonValue.fromJsonNode(node)
            val role = json.asObject().getOrNull()?.get("role")?.asString()?.getOrNull()

            when (role) {
                "developer" -> {
                    tryDeserialize(node, jacksonTypeRef<ChatCompletionDeveloperMessageParam>()) {
                            it.validate()
                        }
                        ?.let {
                            return ChatCompletionMessageParam(
                                chatCompletionDeveloperMessageParam = it,
                                _json = json
                            )
                        }
                }
                "system" -> {
                    tryDeserialize(node, jacksonTypeRef<ChatCompletionSystemMessageParam>()) {
                            it.validate()
                        }
                        ?.let {
                            return ChatCompletionMessageParam(
                                chatCompletionSystemMessageParam = it,
                                _json = json
                            )
                        }
                }
                "user" -> {
                    tryDeserialize(node, jacksonTypeRef<ChatCompletionUserMessageParam>()) {
                            it.validate()
                        }
                        ?.let {
                            return ChatCompletionMessageParam(
                                chatCompletionUserMessageParam = it,
                                _json = json
                            )
                        }
                }
                "assistant" -> {
                    tryDeserialize(node, jacksonTypeRef<ChatCompletionAssistantMessageParam>()) {
                            it.validate()
                        }
                        ?.let {
                            return ChatCompletionMessageParam(
                                chatCompletionAssistantMessageParam = it,
                                _json = json
                            )
                        }
                }
                "tool" -> {
                    tryDeserialize(node, jacksonTypeRef<ChatCompletionToolMessageParam>()) {
                            it.validate()
                        }
                        ?.let {
                            return ChatCompletionMessageParam(
                                chatCompletionToolMessageParam = it,
                                _json = json
                            )
                        }
                }
                "function" -> {
                    tryDeserialize(node, jacksonTypeRef<ChatCompletionFunctionMessageParam>()) {
                            it.validate()
                        }
                        ?.let {
                            return ChatCompletionMessageParam(
                                chatCompletionFunctionMessageParam = it,
                                _json = json
                            )
                        }
                }
            }

            return ChatCompletionMessageParam(_json = json)
        }
    }

    class Serializer :
        BaseSerializer<ChatCompletionMessageParam>(ChatCompletionMessageParam::class) {

        override fun serialize(
            value: ChatCompletionMessageParam,
            generator: JsonGenerator,
            provider: SerializerProvider
        ) {
            when {
                value.chatCompletionDeveloperMessageParam != null ->
                    generator.writeObject(value.chatCompletionDeveloperMessageParam)
                value.chatCompletionSystemMessageParam != null ->
                    generator.writeObject(value.chatCompletionSystemMessageParam)
                value.chatCompletionUserMessageParam != null ->
                    generator.writeObject(value.chatCompletionUserMessageParam)
                value.chatCompletionAssistantMessageParam != null ->
                    generator.writeObject(value.chatCompletionAssistantMessageParam)
                value.chatCompletionToolMessageParam != null ->
                    generator.writeObject(value.chatCompletionToolMessageParam)
                value.chatCompletionFunctionMessageParam != null ->
                    generator.writeObject(value.chatCompletionFunctionMessageParam)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ChatCompletionMessageParam")
            }
        }
    }
}
