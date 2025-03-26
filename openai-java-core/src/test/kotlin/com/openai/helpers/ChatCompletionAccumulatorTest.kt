package com.openai.helpers

import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonNull
import com.openai.core.JsonValue
import com.openai.models.chat.completions.ChatCompletion
import com.openai.models.chat.completions.ChatCompletionChunk
import com.openai.models.chat.completions.ChatCompletionMessageToolCall
import com.openai.models.chat.completions.ChatCompletionTokenLogprob
import com.openai.models.completions.CompletionUsage
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class ChatCompletionAccumulatorTest {
    @Test
    fun convertToolCallFunctionWithoutAdditionalProperties() {
        val jsonFunction = ChatCompletionAccumulator.convertToolCallFunction(_toolCallFunction())
        val function: ChatCompletionMessageToolCall.Function = jsonFunction.getRequired("function")

        assertThat(function.name()).isEqualTo("tc_fn_name")
        assertThat(function.arguments()).isEqualTo("[arg1, arg2]")
        assertThat(function._additionalProperties()).isEmpty()
    }

    @Test
    fun convertToolCallFunctionWithNullFunction() {
        val jsonFunction = ChatCompletionAccumulator.convertToolCallFunction(JsonNull.of())

        assertThat(jsonFunction.isNull()).isTrue()
    }

    @Test
    fun convertToolCallFunctionWithMissingFunction() {
        val jsonFunction = ChatCompletionAccumulator.convertToolCallFunction(JsonMissing.of())

        assertThat(jsonFunction.isMissing()).isTrue()
    }

    @Test
    fun convertToolCallFunctionWithAdditionalProperties() {
        val jsonFunction =
            ChatCompletionAccumulator.convertToolCallFunction(
                _toolCallFunction(
                    additionalProperties =
                        mapOf("a" to JsonValue.from("a-value"), "b" to JsonValue.from("b-value"))
                )
            )
        val function = jsonFunction.getRequired("function")

        assertThat(function.name()).isEqualTo("tc_fn_name")
        assertThat(function.arguments()).isEqualTo("[arg1, arg2]")
        assertThat(function._additionalProperties()).isNotEmpty()
        assertThat(function._additionalProperties()["a"]!!.asString().get()).isEqualTo("a-value")
        assertThat(function._additionalProperties()["b"]!!.asString().get()).isEqualTo("b-value")
    }

    @Test
    fun convertToolCallWithoutAdditionalProperties() {
        val toolCall = ChatCompletionAccumulator.convertToolCall(toolCall())

        // If the function name is OK, the rest of the `Function` details should follow, as that
        // is tested in detail in another test method.
        assertThat(toolCall.function().name()).isEqualTo("tc_fn_name")
        assertThat(toolCall.id()).isEqualTo("tool-call-id")
        assertThat(toolCall._additionalProperties()).isEmpty()
    }

    @Test
    fun convertToolCallWithAdditionalProperties() {
        val toolCall =
            ChatCompletionAccumulator.convertToolCall(
                toolCall(
                    additionalProperties =
                        mapOf("a" to JsonValue.from("a-value"), "b" to JsonValue.from("b-value"))
                )
            )

        // If the function name is OK, the rest of the `Function` details should follow, as that
        // is tested in detail in another test method.
        assertThat(toolCall.function().name()).isEqualTo("tc_fn_name")
        assertThat(toolCall.id()).isEqualTo("tool-call-id")
        assertThat(toolCall._additionalProperties()).isNotEmpty()
        assertThat(toolCall._additionalProperties()["a"]!!.asString().get()).isEqualTo("a-value")
        assertThat(toolCall._additionalProperties()["b"]!!.asString().get()).isEqualTo("b-value")
    }

    @Test
    fun convertFunctionCallWithoutAdditionalProperties() {
        val functionCall =
            ChatCompletionAccumulator.convertFunctionCall(
                functionCall(
                    additionalProperties =
                        mapOf("a" to JsonValue.from("a-value"), "b" to JsonValue.from("b-value"))
                )
            )

        assertThat(functionCall.name()).isEqualTo("fc_fn_name")
        assertThat(functionCall.arguments()).isEqualTo("[arg1, arg2]")
        assertThat(functionCall._additionalProperties()).isNotEmpty()
        assertThat(functionCall._additionalProperties()["a"]!!.asString().get())
            .isEqualTo("a-value")
        assertThat(functionCall._additionalProperties()["b"]!!.asString().get())
            .isEqualTo("b-value")
    }

    @Test
    fun convertFunctionCallWithAdditionalProperties() {
        val functionCall = ChatCompletionAccumulator.convertFunctionCall(functionCall())

        assertThat(functionCall.name()).isEqualTo("fc_fn_name")
        assertThat(functionCall.arguments()).isEqualTo("[arg1, arg2]")
        assertThat(functionCall._additionalProperties()).isEmpty()
    }

    @Test
    fun chatCompletionBeforeAnyAccumulation() {
        val accumulator = ChatCompletionAccumulator.create()

        assertThatThrownBy { accumulator.chatCompletion() }
            .isExactlyInstanceOf(IllegalStateException::class.java)
            .hasMessage("Final chat completion chunk(s) not yet received.")
    }

    @Test
    fun chatCompletionAfterAccumulation() {
        val accumulator = ChatCompletionAccumulator.create()

        accumulator.accumulate(finalChunk())

        val chatCompletion = accumulator.chatCompletion()

        assertThat(chatCompletion.choices()[0].finishReason())
            .isEqualTo(ChatCompletion.Choice.FinishReason.STOP)
        assertThat(chatCompletion.usage()).isNotPresent()
        assertThat(chatCompletion.systemFingerprint().get()).isEqualTo("fingerprint")
        assertThat(chatCompletion.serviceTier().get()).isEqualTo(ChatCompletion.ServiceTier.SCALE)
    }

    @Test
    fun chatCompletionAfterAccumulationWithUsage() {
        val accumulator = ChatCompletionAccumulator.create()

        accumulator.accumulate(finalChunk())

        val chatCompletionA = accumulator.chatCompletion()

        // Accumulating a usage chunk should create a new "final" `ChatCompletion`.
        accumulator.accumulate(finalUsageChunk())

        val chatCompletionB = accumulator.chatCompletion()

        // Expect that a new `ChatCompletion` instance was created after the usage was accumulated.
        assertThat(chatCompletionA).isNotSameAs(chatCompletionB)

        assertThat(chatCompletionA.choices()[0].finishReason())
            .isEqualTo(ChatCompletion.Choice.FinishReason.STOP)
        assertThat(chatCompletionA.usage()).isNotPresent()
        assertThat(chatCompletionA.systemFingerprint().get()).isEqualTo("fingerprint")
        assertThat(chatCompletionA.serviceTier().get()).isEqualTo(ChatCompletion.ServiceTier.SCALE)

        assertThat(chatCompletionB.choices()[0].finishReason())
            .isEqualTo(ChatCompletion.Choice.FinishReason.STOP)
        assertThat(chatCompletionB.usage()).isPresent()
        assertThat(chatCompletionB.usage().get().completionTokens()).isEqualTo(10L)
        assertThat(chatCompletionB.usage().get().promptTokens()).isEqualTo(5L)
        assertThat(chatCompletionB.usage().get().totalTokens()).isEqualTo(15L)
        // The `finalUsageChunk()` had `null` values for `systemFingerprint` and `serviceTier`, but
        // those should _not_ have overwritten the non-`null` values on the `finalChunk()`.
        assertThat(chatCompletionB.systemFingerprint().get()).isEqualTo("fingerprint")
        assertThat(chatCompletionB.serviceTier().get()).isEqualTo(ChatCompletion.ServiceTier.SCALE)
    }

    @Test
    fun accumulateFinalChunkAfterFinalChunk() {
        val accumulator = ChatCompletionAccumulator.create()

        accumulator.accumulate(finalChunk())

        assertThatThrownBy { accumulator.accumulate(finalChunk()) }
            .isExactlyInstanceOf(IllegalStateException::class.java)
            .hasMessage("Already accumulated the final chunk(s).")
    }

    @Test
    fun accumulateTextChunkAfterFinalChunk() {
        val accumulator = ChatCompletionAccumulator.create()

        accumulator.accumulate(finalChunk())

        assertThatThrownBy { accumulator.accumulate(textChunk("hello")) }
            .isExactlyInstanceOf(IllegalStateException::class.java)
            .hasMessage("Already accumulated the final chunk(s).")
    }

    @Test
    fun accumulateFinalUsageChunkAfterFinalUsageChunk() {
        val accumulator = ChatCompletionAccumulator.create()

        accumulator.accumulate(finalChunk())
        accumulator.accumulate(finalUsageChunk())

        assertThatThrownBy { accumulator.accumulate(finalUsageChunk()) }
            .isExactlyInstanceOf(IllegalStateException::class.java)
            .hasMessage("Already accumulated the final chunk(s).")
    }

    @Test
    fun accumulateFinalChunkAfterFinalUsageChunk() {
        val accumulator = ChatCompletionAccumulator.create()

        accumulator.accumulate(finalChunk())
        accumulator.accumulate(finalUsageChunk())

        assertThatThrownBy { accumulator.accumulate(finalChunk()) }
            .isExactlyInstanceOf(IllegalStateException::class.java)
            .hasMessage("Already accumulated the final chunk(s).")
    }

    @Test
    fun accumulateTextChunkAfterFinalUsageChunk() {
        val accumulator = ChatCompletionAccumulator.create()

        accumulator.accumulate(finalChunk())
        accumulator.accumulate(finalUsageChunk())

        assertThatThrownBy { accumulator.accumulate(textChunk("hello")) }
            .isExactlyInstanceOf(IllegalStateException::class.java)
            .hasMessage("Already accumulated the final chunk(s).")
    }

    @Test
    fun accumulateText() {
        val accumulator = ChatCompletionAccumulator.create()

        // Vertical slices through these text chunks define the text of three messages, each will
        // be accumulated in its own `Choice`. Here, `n` = 3, so there should be three final chunks
        // to finalize each of the three messages.
        accumulator.accumulate(textChunk("Hello", "How", "See "))
        accumulator.accumulate(textChunk(", ", " are", "the ba"))
        accumulator.accumulate(textChunk("World", " you", "ll "))
        accumulator.accumulate(textChunk("!", "?", "game?"))

        // These failures checks are not destructive, so they will not affect the later success.
        assertThatThrownBy { accumulator.chatCompletion() }
            .isExactlyInstanceOf(IllegalStateException::class.java)
            .hasMessage("Final chat completion chunk(s) not yet received.")

        accumulator.accumulate(finalChunk(0L))

        assertThatThrownBy { accumulator.chatCompletion() }
            .isExactlyInstanceOf(IllegalStateException::class.java)
            .hasMessage("Final chat completion chunk(s) not yet received.")

        accumulator.accumulate(finalChunk(1L))

        assertThatThrownBy { accumulator.chatCompletion() }
            .isExactlyInstanceOf(IllegalStateException::class.java)
            .hasMessage("Final chat completion chunk(s) not yet received.")

        accumulator.accumulate(finalChunk(2L))

        var chatCompletion = accumulator.chatCompletion()

        assertThat(chatCompletion.choices().size).isEqualTo(3)
        assertThat(chatCompletion.choices()[0].message()._role().asString().get())
            .isEqualTo("assistant")
        assertThat(chatCompletion.choices()[0].message().content().get()).isEqualTo("Hello, World!")
        assertThat(chatCompletion.choices()[1].message().content().get()).isEqualTo("How are you?")
        assertThat(chatCompletion.choices()[2].message().content().get())
            .isEqualTo("See the ball game?")
    }

    @Test
    fun accumulateRefusal() {
        // Refusals are not tested in as in-depth a manner as with the text content chunks. It is
        // known that the code has the same logic for content and refusals, so testing one should be
        // enough to test the other.
        val accumulator = ChatCompletionAccumulator.create()

        accumulator.accumulate(textChunk("hello"))
        accumulator.accumulate(textChunk(" world"))
        accumulator.accumulate(refusalChunk("I "))
        accumulator.accumulate(refusalChunk("cannot "))
        accumulator.accumulate(refusalChunk("answer "))
        accumulator.accumulate(refusalChunk("that!"))
        accumulator.accumulate(finalChunk())

        val chatCompletion = accumulator.chatCompletion()

        assertThat(chatCompletion.choices().size).isEqualTo(1)
        assertThat(chatCompletion.choices()[0].message().content().get()).isEqualTo("hello world")
        assertThat(chatCompletion.choices()[0].message().refusal().get())
            .isEqualTo("I cannot answer that!")
    }

    @Test
    fun accumulateTextChunksWithLogprobs() {
        val accumulator = ChatCompletionAccumulator.create()

        accumulator.accumulate(textChunk("Hello,", withLogprobContents = true))
        accumulator.accumulate(textChunk(" World", withLogprobContents = true))
        accumulator.accumulate(textChunk(". What's", withLogprobRefusals = true))
        accumulator.accumulate(textChunk(" up?", withLogprobRefusals = true))
        accumulator.accumulate(finalChunk())

        val chatCompletion = accumulator.chatCompletion()

        assertThat(chatCompletion.choices().size).isEqualTo(1)
        assertThat(chatCompletion.choices()[0].message().content().get())
            .isEqualTo("Hello, World. What's up?")

        assertThat(chatCompletion.choices()[0].logprobs().get().content().get().size).isEqualTo(4)
        assertThat(chatCompletion.choices()[0].logprobs().get().refusal().get().size).isEqualTo(4)
        assertThat(chatCompletion.choices()[0].logprobs().get().refusal().get()[0].token())
            .isEqualTo("refusal-1")
        assertThat(chatCompletion.choices()[0].logprobs().get().refusal().get()[1].token())
            .isEqualTo("refusal-2")
        assertThat(chatCompletion.choices()[0].logprobs().get().refusal().get()[2].token())
            .isEqualTo("refusal-1")
        assertThat(chatCompletion.choices()[0].logprobs().get().refusal().get()[3].token())
            .isEqualTo("refusal-2")
    }

    @Test
    fun accumulateCustomRole() {
        // The default role is "assistant"; check that a non-default role is copied as expected.
        val accumulator = ChatCompletionAccumulator.create()

        accumulator.accumulate(
            textChunk("hello", role = ChatCompletionChunk.Choice.Delta.Role.DEVELOPER)
        )
        accumulator.accumulate(finalChunk())

        var chatCompletion = accumulator.chatCompletion()

        assertThat(chatCompletion.choices().size).isEqualTo(1)
        assertThat(chatCompletion.choices()[0].message()._role().asString().get())
            .isEqualTo("developer")
        assertThat(chatCompletion.choices()[0].message().content().get()).isEqualTo("hello")
    }

    @Test
    fun accumulateFunctionCallAndToolCall() {
        val accumulator = ChatCompletionAccumulator.create()

        accumulator.accumulate(textChunk("hello", withToolCall = true))
        accumulator.accumulate(textChunk(" world", withToolCall = true, withFunctionCall = true))
        accumulator.accumulate(finalChunk())

        var chatCompletion = accumulator.chatCompletion()

        assertThat(chatCompletion.choices().size).isEqualTo(1)
        assertThat(chatCompletion.choices()[0].message().functionCall().get().name())
            .isEqualTo("fc_fn_name")
        assertThat(chatCompletion.choices()[0].message().toolCalls().get().size).isEqualTo(2)
        assertThat(chatCompletion.choices()[0].message().toolCalls().get()[0].function().name())
            .isEqualTo("tc_fn_name")
        assertThat(chatCompletion.choices()[0].message().content().get()).isEqualTo("hello world")
    }

    // -------------------------------------------------------------------------
    // Helper functions to create test fixtures.

    private fun finalChunk(
        index: Long = 0L,
        finishReason: ChatCompletionChunk.Choice.FinishReason =
            ChatCompletionChunk.Choice.FinishReason.STOP,
    ) =
        ChatCompletionChunk.builder()
            .id("final-chunk-id")
            .created(123_456_789L)
            .model("model-id")
            .systemFingerprint("fingerprint")
            .serviceTier(ChatCompletionChunk.ServiceTier.SCALE)
            .addChoice(
                ChatCompletionChunk.Choice.builder()
                    .finishReason(finishReason)
                    .index(index)
                    .delta(emptyDelta())
                    .build()
            )
            .build()

    private fun finalUsageChunk(
        finishReason: ChatCompletionChunk.Choice.FinishReason =
            ChatCompletionChunk.Choice.FinishReason.STOP
    ) =
        ChatCompletionChunk.builder()
            // Unlike in `finalChunk()`, there is no `systemFingerprint` and no `serviceTier` set
            // here. This allows testing that `null` values do not overwrite non-`null` values.
            .id("final-chunk-id")
            .created(123_456_789L)
            .model("model-id")
            .usage(usage())
            // If the usage is present on a chunk, there will never be any choices.
            .choices(listOf())
            .build()

    private fun usage() =
        CompletionUsage.builder().completionTokens(10L).promptTokens(5L).totalTokens(15L).build()

    /**
     * Creates a text chunk with one or more text choices. The choices are indexed in the order
     * given. Each text string corresponds to a separate completion choice and will be accumulated
     * in a separate `ChatCompletionMessage` in each `Choice` of the final `ChatCompletion`. The
     * number of indexes corresponds to the `n` value in the request. For example, if there are
     * three text chunks each with three text strings(: `["A", "B", "C"]`, `["D", "E", "F"]`, `["G",
     * "H", "I"]`, then the accumulation will contain three choices each with a single message with
     * the respective text `"ADG"`, `"BEH"`, or `"CFI"`.
     */
    private fun textChunk(
        text: String,
        vararg moreText: String,
        withLogprobContents: Boolean = false,
        withLogprobRefusals: Boolean = false,
        withFunctionCall: Boolean = false,
        withToolCall: Boolean = false,
        role: ChatCompletionChunk.Choice.Delta.Role? = null,
    ) =
        ChatCompletionChunk.builder()
            .id("text-chunk-id")
            .created(123_456_789L)
            .model("model-id")
            .addChoice(
                textChoice(
                    0L,
                    text,
                    withLogprobContents,
                    withLogprobRefusals,
                    withFunctionCall,
                    withToolCall,
                    role,
                )
            )
            .apply {
                moreText.forEachIndexed { index, it ->
                    addChoice(
                        textChoice(
                            index + 1L,
                            it,
                            withLogprobContents,
                            withLogprobRefusals,
                            withFunctionCall,
                            withToolCall,
                            role,
                        )
                    )
                }
            }
            .build()

    private fun textChoice(
        index: Long = 0L,
        text: String,
        withLogprobContents: Boolean = false,
        withLogprobRefusals: Boolean = false,
        withFunctionCall: Boolean = false,
        withToolCall: Boolean = false,
        role: ChatCompletionChunk.Choice.Delta.Role? = null,
    ) =
        ChatCompletionChunk.Choice.builder()
            .delta(textDelta(text, withFunctionCall, withToolCall, role))
            .index(index)
            .applyIf(withLogprobContents || withLogprobRefusals) {
                logprobs(
                    logprobs(withContents = withLogprobContents, withRefusals = withLogprobRefusals)
                )
            }
            .finishReason(null)
            .build()

    private fun textDelta(
        text: String,
        withFunctionCall: Boolean = false,
        withToolCall: Boolean = false,
        role: ChatCompletionChunk.Choice.Delta.Role? = null,
    ) =
        ChatCompletionChunk.Choice.Delta.builder()
            .content(text)
            .applyIf(withFunctionCall) { functionCall(functionCall()) }
            .applyIf(withToolCall) { addToolCall(toolCall()) }
            .apply { role?.let { role(it) } }
            .build()

    private fun refusalChunk(text: String) =
        ChatCompletionChunk.builder()
            .id("refusal-chunk-id")
            .created(123_456_789L)
            .model("model-id")
            .addChoice(refusalChoice(0L, text))
            .build()

    private fun refusalChoice(index: Long = 0L, text: String) =
        ChatCompletionChunk.Choice.builder()
            .delta(refusalDelta(text))
            .index(index)
            .finishReason(null)
            .build()

    private fun refusalDelta(text: String) =
        ChatCompletionChunk.Choice.Delta.builder().refusal(text).build()

    private fun emptyDelta() = ChatCompletionChunk.Choice.Delta.builder().build()

    private fun toolCall(
        toolCallId: String = "tool-call-id",
        toolCallFunction: ChatCompletionChunk.Choice.Delta.ToolCall.Function = toolCallFunction(),
        additionalProperties: Map<String, JsonValue>? = null,
    ) =
        ChatCompletionChunk.Choice.Delta.ToolCall.builder()
            .id(toolCallId)
            // Currently, the implementation ignores the `index`. That might change later.
            .index(1L)
            .function(toolCallFunction)
            .apply { additionalProperties?.let { additionalProperties(it) } }
            .build()

    private fun toolCallFunction(
        functionName: String = "tc_fn_name",
        functionArguments: String = "[arg1, arg2]",
        additionalProperties: Map<String, JsonValue>? = null,
    ) =
        ChatCompletionChunk.Choice.Delta.ToolCall.Function.builder()
            .name(functionName)
            .arguments(functionArguments)
            .apply { additionalProperties?.let { additionalProperties(it) } }
            .build()

    private fun _toolCallFunction(
        functionName: JsonField<String> = JsonField.of("tc_fn_name"),
        functionArguments: JsonField<String> = JsonField.of("[arg1, arg2]"),
        additionalProperties: Map<String, JsonValue>? = null,
    ) =
        JsonField.of(
            ChatCompletionChunk.Choice.Delta.ToolCall.Function.builder()
                .name(functionName)
                .arguments(functionArguments)
                .apply { additionalProperties?.let { additionalProperties(it) } }
                .build()
        )

    private fun functionCall(
        functionName: String = "fc_fn_name",
        functionArguments: String = "[arg1, arg2]",
        additionalProperties: Map<String, JsonValue>? = null,
    ) =
        ChatCompletionChunk.Choice.Delta.FunctionCall.builder()
            .name(functionName)
            .arguments(functionArguments)
            .apply { additionalProperties?.let { additionalProperties(it) } }
            .build()

    private fun logprobs(withContents: Boolean = true, withRefusals: Boolean = true) =
        ChatCompletionChunk.Choice.Logprobs.builder()
            .applyIf(withContents) {
                addContent(tokenLogprob("content-1"))
                addContent(tokenLogprob("content-2"))
            }
            .applyIf(!withContents) { content(listOf()) }
            .applyIf(withRefusals) {
                addRefusal(tokenLogprob("refusal-1"))
                addRefusal(tokenLogprob("refusal-2"))
            }
            .applyIf(!withRefusals) { refusal(listOf()) }
            .build()

    private fun tokenLogprob(token: String = "hello") =
        ChatCompletionTokenLogprob.builder()
            .token(token)
            .bytes(listOf(123L, 456L, 789L))
            .logprob(0.123456789)
            .addTopLogprob(
                ChatCompletionTokenLogprob.TopLogprob.builder()
                    .token("$token-top")
                    .bytes(listOf(234L, 567L, 890L))
                    .logprob(0.23456789)
                    .build()
            )
            .build()

    private inline fun <T> T.applyIf(condition: Boolean, block: T.() -> Unit): T {
        if (condition) {
            this.block()
        }
        return this
    }
}
