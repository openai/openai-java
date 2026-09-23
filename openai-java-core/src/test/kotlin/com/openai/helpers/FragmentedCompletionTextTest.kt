package com.openai.helpers

import com.openai.models.chat.completions.ChatCompletionChunk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FragmentedCompletionTextTest {
    @Test
    fun preservesContentAndRefusalAcrossManyFragments() {
        val accumulator = ChatCompletionAccumulator.create()
        val delta = ChatCompletionChunk.Choice.Delta.builder().content("aλ😀").refusal("no").build()
        val fragment = chunk(delta, false)
        repeat(10_000) { accumulator.accumulate(fragment) }
        accumulator.accumulate(chunk(ChatCompletionChunk.Choice.Delta.builder().build(), true))
        val message = accumulator.chatCompletion().choices().single().message()
        assertThat(message.content()).hasValue("aλ😀".repeat(10_000))
        assertThat(message.refusal()).hasValue("no".repeat(10_000))
    }

    @Test
    fun distinguishesEmptyContentFromMissingRefusal() {
        val accumulator = ChatCompletionAccumulator.create()
        accumulator.accumulate(
            chunk(ChatCompletionChunk.Choice.Delta.builder().content("").build(), false)
        )
        accumulator.accumulate(chunk(ChatCompletionChunk.Choice.Delta.builder().build(), true))
        val message = accumulator.chatCompletion().choices().single().message()
        assertThat(message.content()).hasValue("")
        assertThat(message.refusal()).isEmpty()
    }

    private fun chunk(delta: ChatCompletionChunk.Choice.Delta, finished: Boolean) =
        ChatCompletionChunk.builder()
            .id("test")
            .created(1)
            .model("test")
            .addChoice(
                ChatCompletionChunk.Choice.builder()
                    .index(0)
                    .delta(delta)
                    .finishReason(
                        if (finished) ChatCompletionChunk.Choice.FinishReason.STOP else null
                    )
                    .build()
            )
            .build()
}
