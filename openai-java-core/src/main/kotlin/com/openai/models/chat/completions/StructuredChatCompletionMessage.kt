package com.openai.models.chat.completions

import com.openai.core.JsonField
import com.openai.core.JsonValue
import com.openai.core.responseTypeFromJson
import com.openai.models.chat.completions.ChatCompletionMessage.FunctionCall
import java.util.Objects
import java.util.Optional

/**
 * A wrapper for [ChatCompletionMessage] that provides type-safe access to the [content] when using
 * the _Structured Outputs_ feature to deserialize a JSON response to an instance of an arbitrary
 * class. See the SDK documentation for more details on _Structured Outputs_.
 *
 * @param T The type of the class to which the JSON data in the content will be deserialized when
 *   [content] is called.
 */
class StructuredChatCompletionMessage<T : Any>
internal constructor(
    @get:JvmName("responseType") val responseType: Class<T>,
    @get:JvmName("rawMessage") val rawMessage: ChatCompletionMessage,
) {

    private val content: JsonField<T> by lazy {
        rawMessage._content().map { responseTypeFromJson<T>(it, responseType) }
    }

    /** @see ChatCompletionMessage.content */
    fun content(): Optional<T> = content.getOptional("content")

    /** @see ChatCompletionMessage.refusal */
    fun refusal(): Optional<String> = rawMessage.refusal()

    /** @see ChatCompletionMessage._role */
    fun _role(): JsonValue = rawMessage._role()

    /** @see ChatCompletionMessage.annotations */
    fun annotations(): Optional<List<ChatCompletionMessage.Annotation>> = rawMessage.annotations()

    /** @see ChatCompletionMessage.audio */
    fun audio(): Optional<ChatCompletionAudio> = rawMessage.audio()

    /** @see ChatCompletionMessage.functionCall */
    @Deprecated("deprecated") fun functionCall(): Optional<FunctionCall> = rawMessage.functionCall()

    /** @see ChatCompletionMessage.toolCalls */
    fun toolCalls(): Optional<List<ChatCompletionMessageToolCall>> = rawMessage.toolCalls()

    /** @see ChatCompletionMessage._content */
    fun _content(): JsonField<T> = content

    /** @see ChatCompletionMessage._refusal */
    fun _refusal(): JsonField<String> = rawMessage._refusal()

    /** @see ChatCompletionMessage._annotations */
    fun _annotations(): JsonField<List<ChatCompletionMessage.Annotation>> =
        rawMessage._annotations()

    /** @see ChatCompletionMessage._audio */
    fun _audio(): JsonField<ChatCompletionAudio> = rawMessage._audio()

    /** @see ChatCompletionMessage._functionCall */
    @Deprecated("deprecated")
    fun _functionCall(): JsonField<FunctionCall> = rawMessage._functionCall()

    /** @see ChatCompletionMessage._toolCalls */
    fun _toolCalls(): JsonField<List<ChatCompletionMessageToolCall>> = rawMessage._toolCalls()

    /** @see ChatCompletionMessage._additionalProperties */
    fun _additionalProperties(): Map<String, JsonValue> = rawMessage._additionalProperties()

    /** @see ChatCompletionMessage.validate */
    // `content()` is not included in the validation by the delegate method, so just call it.
    fun validate(): ChatCompletionMessage = rawMessage.validate()

    /** @see ChatCompletionMessage.isValid */
    fun isValid(): Boolean = rawMessage.isValid()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is StructuredChatCompletionMessage<*> &&
            responseType == other.responseType &&
            rawMessage == other.rawMessage
    }

    private val hashCode: Int by lazy { Objects.hash(responseType, rawMessage) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "${javaClass.simpleName}{responseType=$responseType, rawMessage=$rawMessage}"
}
