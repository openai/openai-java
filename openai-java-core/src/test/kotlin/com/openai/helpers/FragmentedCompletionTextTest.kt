package com.openai.helpers

import com.openai.models.chat.completions.ChatCompletionChunk
import com.openai.models.completions.CompletionUsage
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
        val completion = accumulator.chatCompletion()
        val message = completion.choices().single().message()
        assertThat(message.content()).hasValue("aλ😀".repeat(10_000))
        assertThat(message.refusal()).hasValue("no".repeat(10_000))
        // Inspect retained storage directly rather than relying on nondeterministic GC timing.
        assertThat(accumulator)
            .extracting("messageContents", "messageRefusals")
            .containsExactly(emptyMap<Long, StringBuilder>(), emptyMap<Long, StringBuilder>())

        val usage =
            CompletionUsage.builder().completionTokens(10).promptTokens(5).totalTokens(15).build()
        accumulator.accumulate(
            ChatCompletionChunk.builder()
                .id("test")
                .created(1)
                .model("test")
                .choices(emptyList())
                .usage(usage)
                .build()
        )
        val completionWithUsage = accumulator.chatCompletion()
        assertThat(completionWithUsage.choices()).isEqualTo(completion.choices())
        assertThat(completionWithUsage.usage()).hasValue(usage)
        assertThat(completion.usage()).isEmpty()
        assertThat(accumulator.chatCompletion()).isSameAs(completionWithUsage)
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

    @Test
    fun preservesMultipleChoicesFinalizedInOneChunk() {
        val accumulator = ChatCompletionAccumulator.create()
        val first =
            chunk(
                ChatCompletionChunk.Choice.Delta.builder().content("first").refusal("").build(),
                true,
            )
        val second =
            chunk(
                ChatCompletionChunk.Choice.Delta.builder().content("second").refusal("no").build(),
                true,
                1,
            )
        accumulator.accumulate(first.toBuilder().addChoice(second.choices().single()).build())

        val choices = accumulator.chatCompletion().choices()
        assertThat(choices).hasSize(2)
        assertThat(choices[0].message().content()).hasValue("first")
        assertThat(choices[0].message().refusal()).hasValue("")
        assertThat(choices[1].message().content()).hasValue("second")
        assertThat(choices[1].message().refusal()).hasValue("no")
    }

    private fun chunk(delta: ChatCompletionChunk.Choice.Delta, finished: Boolean, index: Long = 0) =
        ChatCompletionChunk.builder()
            .id("test")
            .created(1)
            .model("test")
            .addChoice(
                ChatCompletionChunk.Choice.builder()
                    .index(index)
                    .delta(delta)
                    .finishReason(
                        if (finished) ChatCompletionChunk.Choice.FinishReason.STOP else null
                    )
                    .build()
            )
            .build()
}
