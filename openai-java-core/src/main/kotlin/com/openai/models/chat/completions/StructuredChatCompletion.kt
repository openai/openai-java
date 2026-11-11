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
    fun id(): Optional<String> = rawChatCompletion.id()

    fun idOrThrow(): String = rawChatCompletion.idOrThrow()

    private val choices by lazy {
        rawChatCompletion._choices().map { choices -> choices.map { Choice<T>(responseType, it) } }
    }

    /** @see ChatCompletion.choices */
    fun choices(): Optional<List<Choice<T>>> = choices.getOptional("choices")

    fun choicesOrThrow(): List<Choice<T>> = choices.getRequired("choices")

    /** @see ChatCompletion.created */
    fun created(): Optional<Long> = rawChatCompletion.created()

    fun createdOrThrow(): Long = rawChatCompletion.createdOrThrow()

    /** @see ChatCompletion.model */
    fun model(): Optional<String> = rawChatCompletion.model()

    fun modelOrThrow(): String = rawChatCompletion.modelOrThrow()

    /** @see ChatCompletion.metadata */
    fun metadata(): Optional<ChatCompletion.Metadata> = rawChatCompletion.metadata()

    fun metadataOrThrow(): ChatCompletion.Metadata = rawChatCompletion.metadataOrThrow()

    /** @see ChatCompletion.moderation */
    fun moderation(): Optional<ChatCompletion.Moderation> = rawChatCompletion.moderation()

    fun moderationOrThrow(): ChatCompletion.Moderation = rawChatCompletion.moderationOrThrow()

    /** @see ChatCompletion._object_ */
    fun _object_(): JsonField<JsonValue> = rawChatCompletion._object_()

    fun object_(): Optional<JsonValue> = rawChatCompletion.object_()

    fun object_OrThrow(): JsonValue = rawChatCompletion.object_OrThrow()

    /** @see ChatCompletion.serviceTier */
    fun serviceTier(): Optional<ServiceTier> = rawChatCompletion.serviceTier()

    fun serviceTierOrThrow(): ServiceTier = rawChatCompletion.serviceTierOrThrow()

    /** @see ChatCompletion.systemFingerprint */
    fun systemFingerprint(): Optional<String> = rawChatCompletion.systemFingerprint()

    fun systemFingerprintOrThrow(): String = rawChatCompletion.systemFingerprintOrThrow()

    /** @see ChatCompletion.usage */
    fun usage(): Optional<CompletionUsage> = rawChatCompletion.usage()

    fun usageOrThrow(): CompletionUsage = rawChatCompletion.usageOrThrow()

    /** @see ChatCompletion._id */
    fun _id(): JsonField<String> = rawChatCompletion._id()

    /** @see ChatCompletion._choices */
    fun _choices(): JsonField<List<Choice<T>>> = choices

    /** @see ChatCompletion._created */
    fun _created(): JsonField<Long> = rawChatCompletion._created()

    /** @see ChatCompletion._model */
    fun _model(): JsonField<String> = rawChatCompletion._model()

    /** @see ChatCompletion._metadata */
    fun _metadata(): JsonField<ChatCompletion.Metadata> = rawChatCompletion._metadata()

    /** @see ChatCompletion._moderation */
    fun _moderation(): JsonField<ChatCompletion.Moderation> = rawChatCompletion._moderation()

    /** @see ChatCompletion._serviceTier */
    fun _serviceTier(): JsonField<ServiceTier> = rawChatCompletion._serviceTier()

    /** @see ChatCompletion._systemFingerprint */
    fun _systemFingerprint(): JsonField<String> = rawChatCompletion._systemFingerprint()

    /** @see ChatCompletion._usage */
    fun _usage(): JsonField<CompletionUsage> = rawChatCompletion._usage()

    /** @see ChatCompletion._allProperties */
    fun _allProperties(): Map<String, JsonValue> = rawChatCompletion._allProperties()

    class Choice<T : Any>
    internal constructor(
        @get:JvmName("responseType") val responseType: Class<T>,
        @get:JvmName("rawChoice") val rawChoice: ChatCompletion.Choice,
    ) {
        /** @see ChatCompletion.Choice.finishReason */
        fun finishReason(): Optional<FinishReason> = rawChoice.finishReason()

        fun finishReasonOrThrow(): FinishReason = rawChoice.finishReasonOrThrow()

        /** @see ChatCompletion.Choice.index */
        fun index(): Optional<Long> = rawChoice.index()

        fun indexOrThrow(): Long = rawChoice.indexOrThrow()

        /** @see ChatCompletion.Choice.logprobs */
        fun logprobs(): Optional<Logprobs> = rawChoice.logprobs()

        fun logprobsOrThrow(): Logprobs = rawChoice.logprobsOrThrow()

        /** @see ChatCompletion.Choice._finishReason */
        fun _finishReason(): JsonField<FinishReason> = rawChoice._finishReason()

        private val message by lazy {
            rawChoice._message().map { StructuredChatCompletionMessage<T>(responseType, it) }
        }

        /** @see ChatCompletion.Choice.message */
        fun message(): Optional<StructuredChatCompletionMessage<T>> = message.getOptional("message")

        fun messageOrThrow(): StructuredChatCompletionMessage<T> = message.getRequired("message")

        /** @see ChatCompletion.Choice._index */
        fun _index(): JsonField<Long> = rawChoice._index()

        /** @see ChatCompletion.Choice._logprobs */
        fun _logprobs(): JsonField<Logprobs> = rawChoice._logprobs()

        /** @see ChatCompletion.Choice._message */
        fun _message(): JsonField<StructuredChatCompletionMessage<T>> = message

        /** @see ChatCompletion.Choice._allProperties */
        fun _allProperties(): Map<String, JsonValue> = rawChoice._allProperties()

        /** @see ChatCompletion.Choice.validate */
        fun validate(): Choice<T> = apply {
            messageOrThrow().validate()
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
        choicesOrThrow().forEach { it.validate() }
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
