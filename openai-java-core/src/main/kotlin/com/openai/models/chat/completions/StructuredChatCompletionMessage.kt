package com.openai.models.chat.completions

import com.openai.core.JsonField
import com.openai.core.JsonValue
import com.openai.core.fromJson
import com.openai.models.chat.completions.ChatCompletionMessage.FunctionCall
import java.util.Objects
import java.util.Optional

class StructuredChatCompletionMessage<T : Any>
internal constructor(
    val responseFormat: Class<T>,
    val chatCompletionMessage: ChatCompletionMessage,
) {

    private val content: JsonField<T> by lazy {
        chatCompletionMessage._content().map { fromJson<T>(it, responseFormat) }
    }

    /** @see ChatCompletionMessage.content */
    fun content(): Optional<T> = content.getOptional("content")

    /** @see ChatCompletionMessage.refusal */
    fun refusal(): Optional<String> = chatCompletionMessage.refusal()

    /** @see ChatCompletionMessage._role */
    fun _role(): JsonValue = chatCompletionMessage._role()

    /** @see ChatCompletionMessage.annotations */
    fun annotations(): Optional<List<ChatCompletionMessage.Annotation>> =
        chatCompletionMessage.annotations()

    /** @see ChatCompletionMessage.audio */
    fun audio(): Optional<ChatCompletionAudio> = chatCompletionMessage.audio()

    /** @see ChatCompletionMessage.functionCall */
    @Deprecated("deprecated")
    fun functionCall(): Optional<FunctionCall> = chatCompletionMessage.functionCall()

    /** @see ChatCompletionMessage.toolCalls */
    fun toolCalls(): Optional<List<ChatCompletionMessageToolCall>> =
        chatCompletionMessage.toolCalls()

    /** @see ChatCompletionMessage._content */
    fun _content(): JsonField<T> = content

    /** @see ChatCompletionMessage._refusal */
    fun _refusal(): JsonField<String> = chatCompletionMessage._refusal()

    /** @see ChatCompletionMessage._annotations */
    fun _annotations(): JsonField<List<ChatCompletionMessage.Annotation>> =
        chatCompletionMessage._annotations()

    /** @see ChatCompletionMessage._audio */
    fun _audio(): JsonField<ChatCompletionAudio> = chatCompletionMessage._audio()

    /** @see ChatCompletionMessage._functionCall */
    @Deprecated("deprecated")
    fun _functionCall(): JsonField<FunctionCall> = chatCompletionMessage._functionCall()

    /** @see ChatCompletionMessage._toolCalls */
    fun _toolCalls(): JsonField<List<ChatCompletionMessageToolCall>> =
        chatCompletionMessage._toolCalls()

    /** @see ChatCompletionMessage._additionalProperties */
    fun _additionalProperties(): Map<String, JsonValue> =
        chatCompletionMessage._additionalProperties()

    /** @see ChatCompletionMessage.validate */
    // `content()` is not included in the validation by the delegate method, so just call it.
    fun validate(): ChatCompletionMessage = chatCompletionMessage.validate()

    /** @see ChatCompletionMessage.isValid */
    fun isValid(): Boolean = chatCompletionMessage.isValid()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is StructuredChatCompletionMessage<*> &&
            responseFormat == other.responseFormat &&
            chatCompletionMessage == other.chatCompletionMessage
    }

    private val hashCode: Int by lazy { Objects.hash(responseFormat, chatCompletionMessage) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "${javaClass.simpleName}{responseFormat=$responseFormat, chatCompletionMessage=$chatCompletionMessage}"
}
