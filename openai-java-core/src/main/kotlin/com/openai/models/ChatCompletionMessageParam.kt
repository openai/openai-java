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
    private val developer: ChatCompletionDeveloperMessageParam? = null,
    private val system: ChatCompletionSystemMessageParam? = null,
    private val user: ChatCompletionUserMessageParam? = null,
    private val assistant: ChatCompletionAssistantMessageParam? = null,
    private val tool: ChatCompletionToolMessageParam? = null,
    private val function: ChatCompletionFunctionMessageParam? = null,
    private val _json: JsonValue? = null,
) {

    /**
     * Developer-provided instructions that the model should follow, regardless of messages sent by
     * the user. With o1 models and newer, `developer` messages replace the previous `system`
     * messages.
     */
    fun developer(): Optional<ChatCompletionDeveloperMessageParam> = Optional.ofNullable(developer)

    /**
     * Developer-provided instructions that the model should follow, regardless of messages sent by
     * the user. With o1 models and newer, use `developer` messages for this purpose instead.
     */
    fun system(): Optional<ChatCompletionSystemMessageParam> = Optional.ofNullable(system)

    /** Messages sent by an end user, containing prompts or additional context information. */
    fun user(): Optional<ChatCompletionUserMessageParam> = Optional.ofNullable(user)

    /** Messages sent by the model in response to user messages. */
    fun assistant(): Optional<ChatCompletionAssistantMessageParam> = Optional.ofNullable(assistant)

    fun tool(): Optional<ChatCompletionToolMessageParam> = Optional.ofNullable(tool)

    @Deprecated("deprecated")
    fun function(): Optional<ChatCompletionFunctionMessageParam> = Optional.ofNullable(function)

    fun isDeveloper(): Boolean = developer != null

    fun isSystem(): Boolean = system != null

    fun isUser(): Boolean = user != null

    fun isAssistant(): Boolean = assistant != null

    fun isTool(): Boolean = tool != null

    @Deprecated("deprecated") fun isFunction(): Boolean = function != null

    /**
     * Developer-provided instructions that the model should follow, regardless of messages sent by
     * the user. With o1 models and newer, `developer` messages replace the previous `system`
     * messages.
     */
    fun asDeveloper(): ChatCompletionDeveloperMessageParam = developer.getOrThrow("developer")

    /**
     * Developer-provided instructions that the model should follow, regardless of messages sent by
     * the user. With o1 models and newer, use `developer` messages for this purpose instead.
     */
    fun asSystem(): ChatCompletionSystemMessageParam = system.getOrThrow("system")

    /** Messages sent by an end user, containing prompts or additional context information. */
    fun asUser(): ChatCompletionUserMessageParam = user.getOrThrow("user")

    /** Messages sent by the model in response to user messages. */
    fun asAssistant(): ChatCompletionAssistantMessageParam = assistant.getOrThrow("assistant")

    fun asTool(): ChatCompletionToolMessageParam = tool.getOrThrow("tool")

    @Deprecated("deprecated")
    fun asFunction(): ChatCompletionFunctionMessageParam = function.getOrThrow("function")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            developer != null -> visitor.visitDeveloper(developer)
            system != null -> visitor.visitSystem(system)
            user != null -> visitor.visitUser(user)
            assistant != null -> visitor.visitAssistant(assistant)
            tool != null -> visitor.visitTool(tool)
            function != null -> visitor.visitFunction(function)
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
                override fun visitDeveloper(developer: ChatCompletionDeveloperMessageParam) {
                    developer.validate()
                }

                override fun visitSystem(system: ChatCompletionSystemMessageParam) {
                    system.validate()
                }

                override fun visitUser(user: ChatCompletionUserMessageParam) {
                    user.validate()
                }

                override fun visitAssistant(assistant: ChatCompletionAssistantMessageParam) {
                    assistant.validate()
                }

                override fun visitTool(tool: ChatCompletionToolMessageParam) {
                    tool.validate()
                }

                override fun visitFunction(function: ChatCompletionFunctionMessageParam) {
                    function.validate()
                }
            }
        )
        validated = true
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionMessageParam && developer == other.developer && system == other.system && user == other.user && assistant == other.assistant && tool == other.tool && function == other.function /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(developer, system, user, assistant, tool, function) /* spotless:on */

    override fun toString(): String =
        when {
            developer != null -> "ChatCompletionMessageParam{developer=$developer}"
            system != null -> "ChatCompletionMessageParam{system=$system}"
            user != null -> "ChatCompletionMessageParam{user=$user}"
            assistant != null -> "ChatCompletionMessageParam{assistant=$assistant}"
            tool != null -> "ChatCompletionMessageParam{tool=$tool}"
            function != null -> "ChatCompletionMessageParam{function=$function}"
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
        fun ofDeveloper(developer: ChatCompletionDeveloperMessageParam) =
            ChatCompletionMessageParam(developer = developer)

        /**
         * Developer-provided instructions that the model should follow, regardless of messages sent
         * by the user. With o1 models and newer, use `developer` messages for this purpose instead.
         */
        @JvmStatic
        fun ofSystem(system: ChatCompletionSystemMessageParam) =
            ChatCompletionMessageParam(system = system)

        /** Messages sent by an end user, containing prompts or additional context information. */
        @JvmStatic
        fun ofUser(user: ChatCompletionUserMessageParam) = ChatCompletionMessageParam(user = user)

        /** Messages sent by the model in response to user messages. */
        @JvmStatic
        fun ofAssistant(assistant: ChatCompletionAssistantMessageParam) =
            ChatCompletionMessageParam(assistant = assistant)

        @JvmStatic
        fun ofTool(tool: ChatCompletionToolMessageParam) = ChatCompletionMessageParam(tool = tool)

        @Deprecated("deprecated")
        @JvmStatic
        fun ofFunction(function: ChatCompletionFunctionMessageParam) =
            ChatCompletionMessageParam(function = function)
    }

    /**
     * An interface that defines how to map each variant of [ChatCompletionMessageParam] to a value
     * of type [T].
     */
    interface Visitor<out T> {

        /**
         * Developer-provided instructions that the model should follow, regardless of messages sent
         * by the user. With o1 models and newer, `developer` messages replace the previous `system`
         * messages.
         */
        fun visitDeveloper(developer: ChatCompletionDeveloperMessageParam): T

        /**
         * Developer-provided instructions that the model should follow, regardless of messages sent
         * by the user. With o1 models and newer, use `developer` messages for this purpose instead.
         */
        fun visitSystem(system: ChatCompletionSystemMessageParam): T

        /** Messages sent by an end user, containing prompts or additional context information. */
        fun visitUser(user: ChatCompletionUserMessageParam): T

        /** Messages sent by the model in response to user messages. */
        fun visitAssistant(assistant: ChatCompletionAssistantMessageParam): T

        fun visitTool(tool: ChatCompletionToolMessageParam): T

        @Deprecated("deprecated") fun visitFunction(function: ChatCompletionFunctionMessageParam): T

        /**
         * Maps an unknown variant of [ChatCompletionMessageParam] to a value of type [T].
         *
         * An instance of [ChatCompletionMessageParam] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ChatCompletionMessageParam: $json")
        }
    }

    internal class Deserializer :
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
                            return ChatCompletionMessageParam(developer = it, _json = json)
                        }
                }
                "system" -> {
                    tryDeserialize(node, jacksonTypeRef<ChatCompletionSystemMessageParam>()) {
                            it.validate()
                        }
                        ?.let {
                            return ChatCompletionMessageParam(system = it, _json = json)
                        }
                }
                "user" -> {
                    tryDeserialize(node, jacksonTypeRef<ChatCompletionUserMessageParam>()) {
                            it.validate()
                        }
                        ?.let {
                            return ChatCompletionMessageParam(user = it, _json = json)
                        }
                }
                "assistant" -> {
                    tryDeserialize(node, jacksonTypeRef<ChatCompletionAssistantMessageParam>()) {
                            it.validate()
                        }
                        ?.let {
                            return ChatCompletionMessageParam(assistant = it, _json = json)
                        }
                }
                "tool" -> {
                    tryDeserialize(node, jacksonTypeRef<ChatCompletionToolMessageParam>()) {
                            it.validate()
                        }
                        ?.let {
                            return ChatCompletionMessageParam(tool = it, _json = json)
                        }
                }
                "function" -> {
                    tryDeserialize(node, jacksonTypeRef<ChatCompletionFunctionMessageParam>()) {
                            it.validate()
                        }
                        ?.let {
                            return ChatCompletionMessageParam(function = it, _json = json)
                        }
                }
            }

            return ChatCompletionMessageParam(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<ChatCompletionMessageParam>(ChatCompletionMessageParam::class) {

        override fun serialize(
            value: ChatCompletionMessageParam,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.developer != null -> generator.writeObject(value.developer)
                value.system != null -> generator.writeObject(value.system)
                value.user != null -> generator.writeObject(value.user)
                value.assistant != null -> generator.writeObject(value.assistant)
                value.tool != null -> generator.writeObject(value.tool)
                value.function != null -> generator.writeObject(value.function)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ChatCompletionMessageParam")
            }
        }
    }
}
