package com.openai.models.chat.completions

import com.openai.core.JsonField
import com.openai.core.JsonValue
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.chat.completions.ChatCompletion.Choice.FinishReason
import com.openai.models.chat.completions.ChatCompletion.Choice.Logprobs
import com.openai.models.chat.completions.ChatCompletion.ServiceTier
import com.openai.models.completions.CompletionUsage
import java.util.Objects
import java.util.Optional

/**
 * A wrapper for [ChatCompletion] that provides type-safe access to the [choices] when using the
 * _Structured Outputs_ feature to deserialize a JSON response to an instance of an arbitrary class.
 * See the SDK documentation for more details on _Structured Outputs_.
 *
 * @param T The type of the class to which the JSON data in the response will be deserialized.
 */
class StructuredChatCompletion<T : Any>(
    @get:JvmName("responseFormat") val responseFormat: Class<T>,
    @get:JvmName("chatCompletion") val chatCompletion: ChatCompletion,
) {
    /** @see ChatCompletion.id */
    fun id(): String = chatCompletion.id()

    private val choices by lazy {
        chatCompletion._choices().map { choices -> choices.map { Choice<T>(responseFormat, it) } }
    }

    /** @see ChatCompletion.choices */
    fun choices(): List<Choice<T>> = choices.getRequired("choices")

    /** @see ChatCompletion.created */
    fun created(): Long = chatCompletion.created()

    /** @see ChatCompletion.model */
    fun model(): String = chatCompletion.model()

    /** @see ChatCompletion._object_ */
    fun _object_(): JsonValue = chatCompletion._object_()

    /** @see ChatCompletion.serviceTier */
    fun serviceTier(): Optional<ServiceTier> = chatCompletion.serviceTier()

    /** @see ChatCompletion.systemFingerprint */
    fun systemFingerprint(): Optional<String> = chatCompletion.systemFingerprint()

    /** @see ChatCompletion.usage */
    fun usage(): Optional<CompletionUsage> = chatCompletion.usage()

    /** @see ChatCompletion._id */
    fun _id(): JsonField<String> = chatCompletion._id()

    /** @see ChatCompletion._choices */
    fun _choices(): JsonField<List<Choice<T>>> = choices

    /** @see ChatCompletion._created */
    fun _created(): JsonField<Long> = chatCompletion._created()

    /** @see ChatCompletion._model */
    fun _model(): JsonField<String> = chatCompletion._model()

    /** @see ChatCompletion._serviceTier */
    fun _serviceTier(): JsonField<ServiceTier> = chatCompletion._serviceTier()

    /** @see ChatCompletion._systemFingerprint */
    fun _systemFingerprint(): JsonField<String> = chatCompletion._systemFingerprint()

    /** @see ChatCompletion._usage */
    fun _usage(): JsonField<CompletionUsage> = chatCompletion._usage()

    /** @see ChatCompletion._additionalProperties */
    fun _additionalProperties(): Map<String, JsonValue> = chatCompletion._additionalProperties()

    class Choice<T : Any>
    internal constructor(
        @get:JvmName("responseFormat") val responseFormat: Class<T>,
        @get:JvmName("choice") val choice: ChatCompletion.Choice,
    ) {
        /** @see ChatCompletion.Choice.finishReason */
        fun finishReason(): FinishReason = choice.finishReason()

        /** @see ChatCompletion.Choice.index */
        fun index(): Long = choice.index()

        /** @see ChatCompletion.Choice.logprobs */
        fun logprobs(): Optional<Logprobs> = choice.logprobs()

        /** @see ChatCompletion.Choice._finishReason */
        fun _finishReason(): JsonField<FinishReason> = choice._finishReason()

        private val message by lazy {
            choice._message().map { StructuredChatCompletionMessage<T>(responseFormat, it) }
        }

        /** @see ChatCompletion.Choice.message */
        fun message(): StructuredChatCompletionMessage<T> = message.getRequired("message")

        /** @see ChatCompletion.Choice._index */
        fun _index(): JsonField<Long> = choice._index()

        /** @see ChatCompletion.Choice._logprobs */
        fun _logprobs(): JsonField<Logprobs> = choice._logprobs()

        /** @see ChatCompletion.Choice._message */
        fun _message(): JsonField<StructuredChatCompletionMessage<T>> = message

        /** @see ChatCompletion.Choice._additionalProperties */
        fun _additionalProperties(): Map<String, JsonValue> = choice._additionalProperties()

        /** @see ChatCompletion.Choice.validate */
        fun validate(): Choice<T> = apply {
            message().validate()
            choice.validate()
        }

        /** @see ChatCompletion.Choice.isValid */
        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (_: OpenAIInvalidDataException) {
                false
            }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Choice<*> &&
                responseFormat == other.responseFormat &&
                choice == other.choice
        }

        private val hashCode: Int by lazy { Objects.hash(responseFormat, choice) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "${javaClass.simpleName}{responseFormat=$responseFormat, choice=$choice}"
    }

    /** @see ChatCompletion.validate */
    fun validate() = apply {
        choices().forEach { it.validate() }
        chatCompletion.validate()
    }

    /** @see ChatCompletion.isValid */
    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (_: OpenAIInvalidDataException) {
            false
        }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is StructuredChatCompletion<*> &&
            responseFormat == other.responseFormat &&
            chatCompletion == other.chatCompletion
    }

    private val hashCode: Int by lazy { Objects.hash(responseFormat, chatCompletion) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "${javaClass.simpleName}{responseFormat=$responseFormat, chatCompletion=$chatCompletion}"
}
