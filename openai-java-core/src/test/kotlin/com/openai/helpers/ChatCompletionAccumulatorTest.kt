package com.openai.helpers

import com.openai.core.JsonMissing
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

        // Due to the way the test fixtures are created with a limited number of arguments (for
        // legibility), the indexes are hard-coded.  If more than one tool call is added, it will
        // overwrite the previous tool call with the same index.
        accumulator.accumulate(textChunk("hello", withToolCall = true))
        accumulator.accumulate(textChunk(" world", withFunctionCall = true))
        accumulator.accumulate(finalChunk())

        var chatCompletion = accumulator.chatCompletion()

        assertThat(chatCompletion.choices().size).isEqualTo(1)
        assertThat(chatCompletion.choices()[0].message().functionCall().get().name())
            .isEqualTo("fc_fn_name")
        assertThat(chatCompletion.choices()[0].message().toolCalls().get().size).isEqualTo(1)
        assertThat(chatCompletion.choices()[0].message().toolCalls().get()[0].function().name())
            .isEqualTo("tc_fn_name")
        assertThat(chatCompletion.choices()[0].message().content().get()).isEqualTo("hello world")
    }

    @Test
    fun accumulateToolCallsFromFragments() {
        val accumulator = ChatCompletionAccumulator.create()

        // Accumulate two choices/messages. Each has two tool calls. Each tool call is constructed
        // from four chunks. The first chunk has the tool call ID and function name. The second,
        // third and fourth chunks have the fragments of the function arguments. Naming relates to
        // the choice index and the respective tool call index for that choice. The arguments are
        // not expected to be parsed to JSON, just compared as a string. The accumulated result that
        // is expected is as follows:
        //
        //   Choice 0
        //      Tool Call 0: id=tc-id-0-0, function: name=fn-0-0, args={a-0-0-0, a-0-0-1}
        //      Tool Call 1: id=tc-id-0-1, function: name=fn-0-1, args={a-0-1-0, a-0-1-1}
        //
        //   Choice 1
        //      Tool Call 0: id=tc-id-1-0, function: name=fn-1-0, args={a-1-0-0, a-1-0-1}
        //      Tool Call 1: id=tc-id-1-1, function: name=fn-1-1, args={a-1-1-0, a-1-1-1}
        //
        // The chunks are deliberately accumulated out-of-order to ensure that ordering is
        // identified correctly from indexes, not from order of encounter. The chunks carrying the
        // fragments of the arguments for one tool call must be in encounter order (just like for
        // text chunks), but they are interleaved with other chunks.
        accumulator.accumulate(
            toolCallChunk(
                choiceIndex = 0L,
                toolCallIndex = 0L,
                toolCallId = "tc-id-0-0",
                functionName = "fn-0-0",
            )
        )
        accumulator.accumulate(
            toolCallChunk(choiceIndex = 0L, toolCallIndex = 0L, argsFragment = "{a-0-0-0")
        )

        accumulator.accumulate(
            toolCallChunk(
                choiceIndex = 0L,
                toolCallIndex = 1L,
                toolCallId = "tc-id-0-1",
                functionName = "fn-0-1",
            )
        )
        accumulator.accumulate(
            toolCallChunk(choiceIndex = 0L, toolCallIndex = 0L, argsFragment = ", ")
        )
        accumulator.accumulate(
            toolCallChunk(choiceIndex = 0L, toolCallIndex = 0L, argsFragment = "a-0-0-1}")
        )
        accumulator.accumulate(
            toolCallChunk(choiceIndex = 0L, toolCallIndex = 1L, argsFragment = "{a-0-1-0")
        )
        accumulator.accumulate(
            toolCallChunk(
                choiceIndex = 1L,
                toolCallIndex = 1L,
                toolCallId = "tc-id-1-1",
                functionName = "fn-1-1",
            )
        )

        accumulator.accumulate(
            toolCallChunk(
                choiceIndex = 1L,
                toolCallIndex = 0L,
                toolCallId = "tc-id-1-0",
                functionName = "fn-1-0",
            )
        )
        accumulator.accumulate(
            toolCallChunk(choiceIndex = 1L, toolCallIndex = 0L, argsFragment = "{a-1-0-0")
        )
        accumulator.accumulate(
            toolCallChunk(choiceIndex = 0L, toolCallIndex = 1L, argsFragment = ", ")
        )
        accumulator.accumulate(
            toolCallChunk(choiceIndex = 1L, toolCallIndex = 0L, argsFragment = ", ")
        )

        accumulator.accumulate(
            toolCallChunk(choiceIndex = 1L, toolCallIndex = 1L, argsFragment = "{a-1-1-0")
        )
        accumulator.accumulate(
            toolCallChunk(choiceIndex = 1L, toolCallIndex = 1L, argsFragment = ", ")
        )
        accumulator.accumulate(
            toolCallChunk(choiceIndex = 1L, toolCallIndex = 0L, argsFragment = "a-1-0-1}")
        )
        accumulator.accumulate(
            toolCallChunk(choiceIndex = 1L, toolCallIndex = 1L, argsFragment = "a-1-1-1}")
        )
        accumulator.accumulate(finalChunk(0L))
        accumulator.accumulate(
            toolCallChunk(choiceIndex = 0L, toolCallIndex = 1L, argsFragment = "a-0-1-1}")
        )
        accumulator.accumulate(finalChunk(1L))

        val chatCompletion = accumulator.chatCompletion()
        var tc: ChatCompletionMessageToolCall

        // Not interested in much here except the order and details of the accumulated tool calls.
        assertThat(chatCompletion.choices().size).isEqualTo(2)

        assertThat(chatCompletion.choices()[0].message().toolCalls().get().size).isEqualTo(2)
        tc = chatCompletion.choices()[0].message().toolCalls().get()[0]
        assertThat(tc.id()).isEqualTo("tc-id-0-0")
        assertThat(tc.function().name()).isEqualTo("fn-0-0")
        assertThat(tc.function().arguments()).isEqualTo("{a-0-0-0, a-0-0-1}")
        tc = chatCompletion.choices()[0].message().toolCalls().get()[1]
        assertThat(tc.id()).isEqualTo("tc-id-0-1")
        assertThat(tc.function().name()).isEqualTo("fn-0-1")
        assertThat(tc.function().arguments()).isEqualTo("{a-0-1-0, a-0-1-1}")

        assertThat(chatCompletion.choices()[1].message().toolCalls().get().size).isEqualTo(2)
        tc = chatCompletion.choices()[1].message().toolCalls().get()[0]
        assertThat(tc.id()).isEqualTo("tc-id-1-0")
        assertThat(tc.function().name()).isEqualTo("fn-1-0")
        assertThat(tc.function().arguments()).isEqualTo("{a-1-0-0, a-1-0-1}")
        tc = chatCompletion.choices()[1].message().toolCalls().get()[1]
        assertThat(tc.id()).isEqualTo("tc-id-1-1")
        assertThat(tc.function().name()).isEqualTo("fn-1-1")
        assertThat(tc.function().arguments()).isEqualTo("{a-1-1-0, a-1-1-1}")
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
     * three text chunks each with three text strings: `["A", "B", "C"]`, `["D", "E", "F"]`, `["G",
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

    private fun toolCallChunk(
        choiceIndex: Long,
        toolCallIndex: Long,
        toolCallId: String? = null,
        functionName: String? = null,
        argsFragment: String? = null,
    ) =
        ChatCompletionChunk.builder()
            .id("tc-chunk-id")
            .created(123_456_789L)
            .model("model-id")
            .addChoice(
                toolCallChoice(choiceIndex, toolCallIndex, toolCallId, functionName, argsFragment)
            )
            .build()

    private fun toolCallChoice(
        choiceIndex: Long,
        toolCallIndex: Long,
        toolCallId: String? = null,
        functionName: String? = null,
        argsFragment: String? = null,
    ) =
        ChatCompletionChunk.Choice.builder()
            .delta(toolCallDelta(toolCallIndex, toolCallId, functionName, argsFragment))
            .index(choiceIndex)
            .finishReason(null)
            .build()

    private fun toolCallDelta(
        toolCallIndex: Long,
        toolCallId: String? = null,
        functionName: String? = null,
        argsFragment: String? = null,
    ) =
        ChatCompletionChunk.Choice.Delta.builder()
            .content("hello")
            .addToolCall(
                ChatCompletionChunk.Choice.Delta.ToolCall.builder()
                    // Some validations to ensure the caller knows how this method is expected to
                    // be used.
                    .applyIf((toolCallId == null) != (functionName == null)) {
                        throw IllegalArgumentException(
                            "Set both toolCallId and functionName. or set neither."
                        )
                    }
                    .applyIf(functionName != null && argsFragment != null) {
                        throw IllegalArgumentException(
                            "Set functionName or argsFragment, but not both."
                        )
                    }
                    .applyIf(toolCallId == null && functionName == null && argsFragment == null) {
                        throw IllegalArgumentException(
                            "Set toolCallId and functionName, or set argsFragment."
                        )
                    }
                    .applyIf(toolCallId != null) { id(toolCallId!!) }
                    .applyIf(functionName != null) {
                        function(
                            ChatCompletionChunk.Choice.Delta.ToolCall.Function.builder()
                                .name(functionName!!)
                                .arguments(JsonMissing.of())
                                .build()
                        )
                    }
                    .applyIf(argsFragment != null) {
                        function(
                            ChatCompletionChunk.Choice.Delta.ToolCall.Function.builder()
                                .name(JsonMissing.of())
                                .arguments(argsFragment!!)
                                .build()
                        )
                    }
                    .index(toolCallIndex)
                    .build()
            )
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
