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
    @get:JvmName("responseType") val responseType: Class<T>,
    @get:JvmName("rawChatCompletion") val rawChatCompletion: ChatCompletion,
) {
    /** @see ChatCompletion.id */
    fun id(): String = rawChatCompletion.id()

    private val choices by lazy {
        rawChatCompletion._choices().map { choices -> choices.map { Choice<T>(responseType, it) } }
    }

    /** @see ChatCompletion.choices */
    fun choices(): List<Choice<T>> = choices.getRequired("choices")

    /** @see ChatCompletion.created */
    fun created(): Long = rawChatCompletion.created()

    /** @see ChatCompletion.model */
    fun model(): String = rawChatCompletion.model()

    /** @see ChatCompletion._object_ */
    fun _object_(): JsonValue = rawChatCompletion._object_()

    /** @see ChatCompletion.serviceTier */
    fun serviceTier(): Optional<ServiceTier> = rawChatCompletion.serviceTier()

    /** @see ChatCompletion.systemFingerprint */
    fun systemFingerprint(): Optional<String> = rawChatCompletion.systemFingerprint()

    /** @see ChatCompletion.usage */
    fun usage(): Optional<CompletionUsage> = rawChatCompletion.usage()

    /** @see ChatCompletion._id */
    fun _id(): JsonField<String> = rawChatCompletion._id()

    /** @see ChatCompletion._choices */
    fun _choices(): JsonField<List<Choice<T>>> = choices

    /** @see ChatCompletion._created */
    fun _created(): JsonField<Long> = rawChatCompletion._created()

    /** @see ChatCompletion._model */
    fun _model(): JsonField<String> = rawChatCompletion._model()

    /** @see ChatCompletion._serviceTier */
    fun _serviceTier(): JsonField<ServiceTier> = rawChatCompletion._serviceTier()

    /** @see ChatCompletion._systemFingerprint */
    fun _systemFingerprint(): JsonField<String> = rawChatCompletion._systemFingerprint()

    /** @see ChatCompletion._usage */
    fun _usage(): JsonField<CompletionUsage> = rawChatCompletion._usage()

    /** @see ChatCompletion._additionalProperties */
    fun _additionalProperties(): Map<String, JsonValue> = rawChatCompletion._additionalProperties()

    class Choice<T : Any>
    internal constructor(
        @get:JvmName("responseType") val responseType: Class<T>,
        @get:JvmName("rawChoice") val rawChoice: ChatCompletion.Choice,
    ) {
        /** @see ChatCompletion.Choice.finishReason */
        fun finishReason(): FinishReason = rawChoice.finishReason()

        /** @see ChatCompletion.Choice.index */
        fun index(): Long = rawChoice.index()

        /** @see ChatCompletion.Choice.logprobs */
        fun logprobs(): Optional<Logprobs> = rawChoice.logprobs()

        /** @see ChatCompletion.Choice._finishReason */
        fun _finishReason(): JsonField<FinishReason> = rawChoice._finishReason()

        private val message by lazy {
            rawChoice._message().map { StructuredChatCompletionMessage<T>(responseType, it) }
        }

        /** @see ChatCompletion.Choice.message */
        fun message(): StructuredChatCompletionMessage<T> = message.getRequired("message")

        /** @see ChatCompletion.Choice._index */
        fun _index(): JsonField<Long> = rawChoice._index()

        /** @see ChatCompletion.Choice._logprobs */
        fun _logprobs(): JsonField<Logprobs> = rawChoice._logprobs()

        /** @see ChatCompletion.Choice._message */
        fun _message(): JsonField<StructuredChatCompletionMessage<T>> = message

        /** @see ChatCompletion.Choice._additionalProperties */
        fun _additionalProperties(): Map<String, JsonValue> = rawChoice._additionalProperties()

        /** @see ChatCompletion.Choice.validate */
        fun validate(): Choice<T> = apply {
            message().validate()
            rawChoice.validate()
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
                responseType == other.responseType &&
                rawChoice == other.rawChoice
        }

        private val hashCode: Int by lazy { Objects.hash(responseType, rawChoice) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "${javaClass.simpleName}{responseType=$responseType, rawChoice=$rawChoice}"
    }

    /** @see ChatCompletion.validate */
    fun validate() = apply {
        choices().forEach { it.validate() }
        rawChatCompletion.validate()
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
            responseType == other.responseType &&
            rawChatCompletion == other.rawChatCompletion
    }

    private val hashCode: Int by lazy { Objects.hash(responseType, rawChatCompletion) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "${javaClass.simpleName}{responseType=$responseType, rawChatCompletion=$rawChatCompletion}"
}
