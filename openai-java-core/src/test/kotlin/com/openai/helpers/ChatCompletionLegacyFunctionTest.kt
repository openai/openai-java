package com.openai.helpers

import com.openai.core.JsonValue
import com.openai.models.chat.completions.ChatCompletionChunk
import com.openai.models.completions.CompletionUsage
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChatCompletionLegacyFunctionTest {
    private fun chunk(
        index: Long,
        name: String? = null,
        arguments: String? = null,
        finish: Boolean = false,
        metadata: String? = null,
    ): ChatCompletionChunk {
        val delta = ChatCompletionChunk.Choice.Delta.builder()
        if (!finish)
            delta.functionCall(
                ChatCompletionChunk.Choice.Delta.FunctionCall.builder()
                    .apply {
                        name?.let { name(it) }
                        arguments?.let { arguments(it) }
                        metadata?.let { putAdditionalProperty(it, JsonValue.from(true)) }
                    }
                    .build()
            )
        return ChatCompletionChunk.builder()
            .id("chat-test")
            .created(1)
            .model("test-model")
            .addChoice(
                ChatCompletionChunk.Choice.builder()
                    .index(index)
                    .delta(delta.build())
                    .apply {
                        if (finish)
                            finishReason(ChatCompletionChunk.Choice.FinishReason.FUNCTION_CALL)
                    }
                    .build()
            )
            .build()
    }

    @Test
    fun mergesLegacyFragmentsAcrossChoicesAndRetainsMetadataAndUsage() {
        val accumulator = ChatCompletionAccumulator.create()
        accumulator.accumulate(chunk(0, "get_", "{", metadata = "first"))
        accumulator.accumulate(chunk(1, "lookup", "["))
        accumulator.accumulate(chunk(0, "weather", "\"city\":\"Paris\"", metadata = "second"))
        accumulator.accumulate(chunk(1, arguments = "1]"))
        accumulator.accumulate(chunk(0, arguments = "}"))
        accumulator.accumulate(chunk(1, finish = true))
        accumulator.accumulate(chunk(0, finish = true))
        val result = accumulator.chatCompletion()
        val calls = result.choices().map { it.message().functionCall().get() }
        assertThat(calls.map { it.name() }).containsExactly("get_weather", "lookup")
        assertThat(calls.map { it.arguments() }).containsExactly("{\"city\":\"Paris\"}", "[1]")
        assertThat(calls[0]._additionalProperties().keys)
            .containsExactlyInAnyOrder("first", "second")
        accumulator.accumulate(
            ChatCompletionChunk.builder()
                .id("chat-test")
                .created(1)
                .model("test-model")
                .choices(emptyList())
                .usage(
                    CompletionUsage.builder()
                        .promptTokens(3)
                        .completionTokens(5)
                        .totalTokens(8)
                        .build()
                )
                .build()
        )
        assertThat(accumulator.chatCompletion().choices()).isEqualTo(result.choices())
        assertThat(accumulator.chatCompletion().usage().get().totalTokens()).isEqualTo(8)
        assertThat(result.usage()).isEmpty()
    }

    @Test
    fun manyLegacyArgumentFragmentsRetainAllContent() {
        val accumulator = ChatCompletionAccumulator.create()
        accumulator.accumulate(chunk(0, "test", ""))
        repeat(20000) { accumulator.accumulate(chunk(0, arguments = "x")) }
        accumulator.accumulate(chunk(0, finish = true))
        assertThat(
                accumulator
                    .chatCompletion()
                    .choices()
                    .single()
                    .message()
                    .functionCall()
                    .get()
                    .arguments() == "x".repeat(20000)
            )
            .describedAs("all legacy argument fragments retained")
            .isTrue()
    }
}
