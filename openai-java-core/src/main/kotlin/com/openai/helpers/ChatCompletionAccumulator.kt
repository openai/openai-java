package com.openai.helpers

import com.openai.core.JsonField
import com.openai.core.JsonNull
import com.openai.core.JsonValue
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.chat.completions.ChatCompletion
import com.openai.models.chat.completions.ChatCompletionChunk
import com.openai.models.chat.completions.ChatCompletionMessage
import com.openai.models.chat.completions.ChatCompletionMessageToolCall
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * An accumulator that constructs a [ChatCompletion] from a sequence of streamed chunks. Pass all
 * chunks to [accumulate] and then call [chatCompletion] to get the final accumulated chat
 * completion. The final [ChatCompletion] will be similar to what would have been received had the
 * non-streaming API been used.
 *
 * A [ChatCompletionAccumulator] may only be used to accumulate _one_ chat completion. To accumulate
 * another chat completion, create another instance of [ChatCompletionAccumulator].
 */
class ChatCompletionAccumulator private constructor() {
    /**
     * The final [ChatCompletion] accumulated from the chunks. This is created when the final chunk
     * carrying the `finishReason` is accumulated. It may be re-created if an optional `usage` chunk
     * is accumulated after the presumed final chunk.
     */
    private var chatCompletion: ChatCompletion? = null

    /**
     * The builder for the [chatCompletion]. This is updated until the final chunk is accumulated.
     * It may be used to build the [chatCompletion] again if a final usage chunk is accumulated.
     */
    private var chatCompletionBuilder: ChatCompletion.Builder? = null

    /**
     * The builders for the [ChatCompletion.Choice] elements that are updated for the choices in
     * each chunk. When the last chunk is accumulated, the choices are finally built and added to
     * the [chatCompletionBuilder]. The keys are the `index` values from each chunk delta.
     */
    private val choiceBuilders = mutableMapOf<Long, ChatCompletion.Choice.Builder>()

    /**
     * The builders for the [ChatCompletionMessage] elements that are added to their respective
     * choices when all chunks have been accumulated. The keys are the `index` values from each
     * chunk delta.
     */
    private val messageBuilders = mutableMapOf<Long, ChatCompletionMessage.Builder>()

    /**
     * The accumulated content for each message. The keys correspond to the indexes in
     * [messageBuilders].
     */
    private val messageContents = mutableMapOf<Long, String>()

    /**
     * The accumulated refusal for each message. The keys correspond to the indexes in
     * [messageBuilders].
     */
    private val messageRefusals = mutableMapOf<Long, String>()

    /**
     * The builders for the [ChatCompletion.Choice.Logprobs] of each choice. These are only
     * accumulated if the option to report log probabilities was enabled in the request. When the
     * last chunk is accumulated, these are added to their respective [chatCompletionBuilder]. The
     * keys are the `index` values from each chunk delta.
     */
    private val logprobsBuilders = mutableMapOf<Long, ChatCompletion.Choice.Logprobs.Builder>()

    /**
     * The finished status of each of the `n` completions. When a chunk with a `finishReason` is
     * encountered, its index is recorded against a `true` value. When a `true` has been recorded
     * for all indexes, the chat completion is finished and no further chunks (except perhaps a
     * usage chunk) are expected to be accumulated. The keys are the `index` values from each chunk
     * delta.
     */
    private val isFinished = mutableMapOf<Long, Boolean>()

    companion object {
        @JvmStatic fun create() = ChatCompletionAccumulator()

        @JvmSynthetic
        internal fun convertToolCall(chunkToolCall: ChatCompletionChunk.Choice.Delta.ToolCall) =
            ChatCompletionMessageToolCall.builder()
                .id(chunkToolCall._id())
                .function(convertToolCallFunction(chunkToolCall._function()))
                .additionalProperties(chunkToolCall._additionalProperties())
                // Let the `type` default to "function".
                .build()

        @JvmSynthetic
        internal fun convertToolCallFunction(
            chunkToolCallFunction: JsonField<ChatCompletionChunk.Choice.Delta.ToolCall.Function>
        ): JsonField<ChatCompletionMessageToolCall.Function> =
            chunkToolCallFunction.map { function ->
                ChatCompletionMessageToolCall.Function.builder()
                    .name(function._name())
                    .arguments(function._arguments())
                    .additionalProperties(function._additionalProperties())
                    .build()
            }

        @JvmSynthetic
        internal fun convertFunctionCall(
            chunkFunctionCall: ChatCompletionChunk.Choice.Delta.FunctionCall
        ) =
            ChatCompletionMessage.FunctionCall.builder()
                .name(chunkFunctionCall._name())
                .arguments(chunkFunctionCall._arguments())
                .additionalProperties(chunkFunctionCall._additionalProperties())
                .build()
    }

    /**
     * Gets the final accumulated chat completion. Until the last chunk has been accumulated, a
     * [ChatCompletion] will not be available. Wait until all chunks have been handled by
     * [accumulate] before calling this method. See that method for more details on how the last
     * chunk is detected.
     *
     * @throws IllegalStateException If called before the last chunk has been accumulated.
     */
    fun chatCompletion(): ChatCompletion =
        checkNotNull(chatCompletion) { "Final chat completion chunk(s) not yet received." }

    /**
     * Accumulates a streamed chunk and uses it to construct a [ChatCompletion]. When all chunks
     * have been accumulated, the chat completion can be retrieved by calling [chatCompletion].
     *
     * The last chunk is identified as that which provides the `finishReason`. At that point, the
     * [ChatCompletion] is created and available. However, if the request was configured to include
     * the usage details, one additional chunk may be accumulated which provides those usage details
     * and the [ChatCompletion] will be recreated to reflect them. After that, no more chunks of any
     * kind may be accumulated.
     *
     * @return The given [chunk] for convenience, such as when chaining method calls.
     * @throws IllegalStateException If [accumulate] is called again after the last chunk has been
     *   accumulated. A [ChatCompletionAccumulator] can only be used to accumulate a single
     *   [ChatCompletion].
     * @throws OpenAIInvalidDataException If the [chunk] contains invalid or unexpected data.
     */
    fun accumulate(chunk: ChatCompletionChunk): ChatCompletionChunk {
        val localChatCompletion = chatCompletion

        check(
            localChatCompletion == null ||
                (chunk.usage().getOrNull() != null &&
                    localChatCompletion.usage().getOrNull() == null)
        ) {
            "Already accumulated the final chunk(s)."
        }

        val chatCompletionBuilder = ensureChatCompletionBuilder()

        chunk.usage().getOrNull()?.let {
            chatCompletionBuilder.usage(it)
            chatCompletion = chatCompletionBuilder.build()
            // This final `usage` chunk will have no `choices`, so stop here.
            return@accumulate chunk
        }

        // Each chunk in the stream will repeat these values. They could be copied just once, but it
        // is simpler copy them each time they are encountered.
        chatCompletionBuilder
            // These are the mandatory fields that must be set to something.
            .id(chunk.id())
            .created(chunk.created())
            .model(chunk.model())
            // The other fields are optional and `object` has an appropriate default value.
            .systemFingerprint(chunk._systemFingerprint())
            .apply {
                chunk.serviceTier().ifPresent {
                    serviceTier(ChatCompletion.ServiceTier.of(it.asString()))
                }
            }
            .putAllAdditionalProperties(chunk._additionalProperties())

        // Each chunk contains a `choices` list (the size depends on `n` in the request). Each
        // chunked `choice` has an `index`, that identifies the corresponding `Choice` within the
        // accumulated list of choices; and a `Delta`, that contains additional content to be
        // accumulated in that `Choice`, mostly within its `message`.
        chunk.choices().forEach { choice ->
            val index = choice.index()
            val choiceBuilder =
                choiceBuilders.getOrPut(index) { ChatCompletion.Choice.builder().index(index) }

            accumulateLogprobs(index, choice.logprobs())
            accumulateMessage(index, choice.delta())

            choiceBuilder.additionalProperties(choice._additionalProperties())

            if (choice.finishReason().isPresent) {
                choiceBuilder.finishReason(
                    ChatCompletion.Choice.FinishReason.of(choice.finishReason().get().asString())
                )

                // A non-null `finishReason` signals that this is the final `Chunk` for its index.
                // For each of the `n` messages completed, there will be one chunk carrying only a
                // `finishReason` (its `Choice` will have no `content`). These `finalReason` chunks
                // will all arrive after the non-empty chunks have been received for all `n`
                // choices. Therefore, the value of `n` can be inferred from the number of distinct
                // indexes observed thus far when building choices. When all `n` `finishReason`
                // chunks have been received, presumptively build the `ChatCompletion`. (One further
                // usage chunk _might_ be notified.)
                isFinished[index] = true
                if (choiceBuilders.keys.all { isFinished[it] == true }) {
                    chatCompletion = ensureChatCompletionBuilder().choices(buildChoices()).build()
                }
            } else {
                choiceBuilder.finishReason(JsonNull.of())
            }
        }

        return chunk
    }

    private fun ensureChatCompletionBuilder(): ChatCompletion.Builder =
        chatCompletionBuilder ?: ChatCompletion.builder().also { chatCompletionBuilder = it }

    @JvmSynthetic
    internal fun accumulateLogprobs(
        index: Long,
        logprobs: Optional<ChatCompletionChunk.Choice.Logprobs>,
    ) {
        val chunkLogprobs = logprobs.getOrNull() ?: return

        val logprobsBuilder =
            logprobsBuilders.getOrPut(index) {
                ChatCompletion.Choice.Logprobs.builder()
                    // These must be set explicitly to avoid an error when `build()` is called in
                    // the event that no `content` or `refusal` is added later.
                    .content(mutableListOf())
                    .refusal(mutableListOf())
            }

        chunkLogprobs.content().ifPresent { chunkContentList ->
            chunkContentList.forEach(logprobsBuilder::addContent)
        }
        chunkLogprobs.refusal().ifPresent { chunkRefusalsList ->
            chunkRefusalsList.forEach(logprobsBuilder::addRefusal)
        }
        logprobsBuilder.putAllAdditionalProperties(chunkLogprobs._additionalProperties())
    }

    @JvmSynthetic
    internal fun accumulateMessage(index: Long, delta: ChatCompletionChunk.Choice.Delta) {
        val messageBuilder = messageBuilders.getOrPut(index) { ChatCompletionMessage.builder() }

        delta.content().ifPresent { messageContents[index] = (messageContents[index] ?: "") + it }
        delta.refusal().ifPresent { messageRefusals[index] = (messageRefusals[index] ?: "") + it }
        // The `role` defaults to "assistant", so if no other `role` is set on the delta, there is
        // no need to set it explicitly to anything else.
        delta.role().ifPresent { messageBuilder.role(JsonValue.from(it.asString())) }
        delta.functionCall().ifPresent { messageBuilder.functionCall(convertFunctionCall(it)) }

        // Add the `ToolCall` objects in the order in which they are encountered.
        // (`...Delta.ToolCall.index` is not documented, so it is ignored here.)
        delta.toolCalls().ifPresent { it.map { messageBuilder.addToolCall(convertToolCall(it)) } }
        messageBuilder.putAllAdditionalProperties(delta._additionalProperties())
    }

    @JvmSynthetic
    internal fun buildChoices() =
        choiceBuilders.entries
            .sortedBy { it.key }
            .map {
                it.value
                    .message(buildMessage(it.key))
                    .logprobs(logprobsBuilders[it.key]?.build())
                    .build()
            }

    @JvmSynthetic
    internal fun buildMessage(index: Long) =
        messageBuilders
            .getOrElse(index) {
                throw OpenAIInvalidDataException("Missing message for index $index.")
            }
            .content(messageContents[index])
            .refusal(messageRefusals[index])
            .build()
}
