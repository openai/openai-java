// File generated from our OpenAPI spec by Stainless.

package com.openai.models

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
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/**
 * Controls which (if any) tool is called by the model. `none` means the model will not call any
 * tool and instead generates a message. `auto` means the model can pick between generating a
 * message or calling one or more tools. `required` means the model must call one or more tools.
 * Specifying a particular tool via `{"type": "function", "function": {"name": "my_function"}}`
 * forces the model to call that tool.
 *
 * `none` is the default when no tools are present. `auto` is the default if tools are present.
 */
@JsonDeserialize(using = ChatCompletionToolChoiceOption.Deserializer::class)
@JsonSerialize(using = ChatCompletionToolChoiceOption.Serializer::class)
class ChatCompletionToolChoiceOption
private constructor(
    private val auto: Auto? = null,
    private val chatCompletionNamedToolChoice: ChatCompletionNamedToolChoice? = null,
    private val _json: JsonValue? = null,
) {

    /**
     * `none` means the model will not call any tool and instead generates a message. `auto` means
     * the model can pick between generating a message or calling one or more tools. `required`
     * means the model must call one or more tools.
     */
    fun auto(): Optional<Auto> = Optional.ofNullable(auto)

    /**
     * Specifies a tool the model should use. Use to force the model to call a specific function.
     */
    fun chatCompletionNamedToolChoice(): Optional<ChatCompletionNamedToolChoice> =
        Optional.ofNullable(chatCompletionNamedToolChoice)

    fun isAuto(): Boolean = auto != null

    fun isChatCompletionNamedToolChoice(): Boolean = chatCompletionNamedToolChoice != null

    /**
     * `none` means the model will not call any tool and instead generates a message. `auto` means
     * the model can pick between generating a message or calling one or more tools. `required`
     * means the model must call one or more tools.
     */
    fun asAuto(): Auto = auto.getOrThrow("auto")

    /**
     * Specifies a tool the model should use. Use to force the model to call a specific function.
     */
    fun asChatCompletionNamedToolChoice(): ChatCompletionNamedToolChoice =
        chatCompletionNamedToolChoice.getOrThrow("chatCompletionNamedToolChoice")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            auto != null -> visitor.visitAuto(auto)
            chatCompletionNamedToolChoice != null ->
                visitor.visitChatCompletionNamedToolChoice(chatCompletionNamedToolChoice)
            else -> visitor.unknown(_json)
        }
    }

    private var validated: Boolean = false

    fun validate(): ChatCompletionToolChoiceOption = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitAuto(auto: Auto) {}

                override fun visitChatCompletionNamedToolChoice(
                    chatCompletionNamedToolChoice: ChatCompletionNamedToolChoice
                ) {
                    chatCompletionNamedToolChoice.validate()
                }
            }
        )
        validated = true
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionToolChoiceOption && auto == other.auto && chatCompletionNamedToolChoice == other.chatCompletionNamedToolChoice /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(auto, chatCompletionNamedToolChoice) /* spotless:on */

    override fun toString(): String =
        when {
            auto != null -> "ChatCompletionToolChoiceOption{auto=$auto}"
            chatCompletionNamedToolChoice != null ->
                "ChatCompletionToolChoiceOption{chatCompletionNamedToolChoice=$chatCompletionNamedToolChoice}"
            _json != null -> "ChatCompletionToolChoiceOption{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ChatCompletionToolChoiceOption")
        }

    companion object {

        /**
         * `none` means the model will not call any tool and instead generates a message. `auto`
         * means the model can pick between generating a message or calling one or more tools.
         * `required` means the model must call one or more tools.
         */
        @JvmStatic fun ofAuto(auto: Auto) = ChatCompletionToolChoiceOption(auto = auto)

        /**
         * Specifies a tool the model should use. Use to force the model to call a specific
         * function.
         */
        @JvmStatic
        fun ofChatCompletionNamedToolChoice(
            chatCompletionNamedToolChoice: ChatCompletionNamedToolChoice
        ) =
            ChatCompletionToolChoiceOption(
                chatCompletionNamedToolChoice = chatCompletionNamedToolChoice
            )
    }

    interface Visitor<out T> {

        /**
         * `none` means the model will not call any tool and instead generates a message. `auto`
         * means the model can pick between generating a message or calling one or more tools.
         * `required` means the model must call one or more tools.
         */
        fun visitAuto(auto: Auto): T

        /**
         * Specifies a tool the model should use. Use to force the model to call a specific
         * function.
         */
        fun visitChatCompletionNamedToolChoice(
            chatCompletionNamedToolChoice: ChatCompletionNamedToolChoice
        ): T

        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ChatCompletionToolChoiceOption: $json")
        }
    }

    class Deserializer :
        BaseDeserializer<ChatCompletionToolChoiceOption>(ChatCompletionToolChoiceOption::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ChatCompletionToolChoiceOption {
            val json = JsonValue.fromJsonNode(node)

            tryDeserialize(node, jacksonTypeRef<Auto>())?.let {
                return ChatCompletionToolChoiceOption(auto = it, _json = json)
            }
            tryDeserialize(node, jacksonTypeRef<ChatCompletionNamedToolChoice>()) { it.validate() }
                ?.let {
                    return ChatCompletionToolChoiceOption(
                        chatCompletionNamedToolChoice = it,
                        _json = json
                    )
                }

            return ChatCompletionToolChoiceOption(_json = json)
        }
    }

    class Serializer :
        BaseSerializer<ChatCompletionToolChoiceOption>(ChatCompletionToolChoiceOption::class) {

        override fun serialize(
            value: ChatCompletionToolChoiceOption,
            generator: JsonGenerator,
            provider: SerializerProvider
        ) {
            when {
                value.auto != null -> generator.writeObject(value.auto)
                value.chatCompletionNamedToolChoice != null ->
                    generator.writeObject(value.chatCompletionNamedToolChoice)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ChatCompletionToolChoiceOption")
            }
        }
    }

    /**
     * `none` means the model will not call any tool and instead generates a message. `auto` means
     * the model can pick between generating a message or calling one or more tools. `required`
     * means the model must call one or more tools.
     */
    class Auto
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val NONE = of("none")

            @JvmField val AUTO = of("auto")

            @JvmField val REQUIRED = of("required")

            @JvmStatic fun of(value: String) = Auto(JsonField.of(value))
        }

        enum class Known {
            NONE,
            AUTO,
            REQUIRED,
        }

        enum class Value {
            NONE,
            AUTO,
            REQUIRED,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                NONE -> Value.NONE
                AUTO -> Value.AUTO
                REQUIRED -> Value.REQUIRED
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                NONE -> Known.NONE
                AUTO -> Known.AUTO
                REQUIRED -> Known.REQUIRED
                else -> throw OpenAIInvalidDataException("Unknown Auto: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Auto && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }
}
