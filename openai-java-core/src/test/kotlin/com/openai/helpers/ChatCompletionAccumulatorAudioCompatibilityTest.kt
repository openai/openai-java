package com.openai.helpers

import com.openai.core.jsonMapper
import com.openai.models.chat.completions.ChatCompletion
import com.openai.models.chat.completions.ChatCompletionChunk
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class ChatCompletionAccumulatorAudioCompatibilityTest {
    private fun chunk(choices: String) =
        jsonMapper()
            .readValue(
                """{"id":"chatcmpl-audio","object":"chat.completion.chunk","created":1,
              "model":"audio-test","choices":[$choices]}""",
                ChatCompletionChunk::class.java,
            )

    @Test
    fun accumulatesTypedAudioPerChoiceAndRetainsExtensions() {
        val accumulator = ChatCompletionAccumulator.create()
        accumulator.accumulate(
            chunk(
                """
          {"index":0,"delta":{"role":"assistant","content":"Text","audio":{"id":"audio-0","data":"ab","transcript":"Hi","custom":5}}},
          {"index":1,"delta":{"role":"assistant","audio":{"id":"audio-1","data":"xy","transcript":"Bye"}}}
        """
            )
        )
        accumulator.accumulate(
            chunk(
                """
          {"index":1,"delta":{"audio":{"data":"z","transcript":"!","expires_at":0}},"finish_reason":"stop"},
          {"index":0,"delta":{"audio":{"data":"cd","transcript":" there","expires_at":7}},"finish_reason":"stop"}
        """
            )
        )
        val result = accumulator.chatCompletion().validate()
        val first = result.choices()[0].message()
        assertThat(first.content()).contains("Text")
        assertThat(first.audio().get().id()).isEqualTo("audio-0")
        assertThat(first.audio().get().data()).isEqualTo("abcd")
        assertThat(first.audio().get().transcript()).isEqualTo("Hi there")
        assertThat(first.audio().get().expiresAt()).isEqualTo(7)
        assertThat(
                first.audio().get()._additionalProperties()["custom"]?.asNumber()?.get()?.toLong()
            )
            .isEqualTo(5L)
        val second = result.choices()[1].message().audio().get()
        assertThat(second.id()).isEqualTo("audio-1")
        assertThat(second.data()).isEqualTo("xyz")
        assertThat(second.transcript()).isEqualTo("Bye!")
        assertThat(second.expiresAt()).isZero()
    }

    @Test
    fun trailingAudioExpiryCompletesAudioAndRetainsItsTextAndFinishReason() {
        val accumulator = ChatCompletionAccumulator.create()
        accumulator.accumulate(
            chunk(
                """{"index":0,"delta":{"role":"assistant","content":"Text","audio":{"id":"audio-0","data":"ab","transcript":"Hi"}}}"""
            )
        )
        accumulator.accumulate(
            chunk(
                """{"index":0,"delta":{"audio":{"data":"cd","transcript":"!"}},"finish_reason":"stop"}"""
            )
        )
        assertThatThrownBy { accumulator.chatCompletion() }
            .isInstanceOf(IllegalStateException::class.java)
        accumulator.accumulate(chunk("""{"index":0,"delta":{"audio":{"expires_at":0}}}"""))
        val after = accumulator.chatCompletion().validate()
        assertThat(after.choices()[0].finishReason())
            .isEqualTo(ChatCompletion.Choice.FinishReason.STOP)
        assertThat(after.choices()[0].message().content()).contains("Text")
        assertThat(after.choices()[0].message().audio().get().data()).isEqualTo("abcd")
        assertThat(after.choices()[0].message().audio().get().transcript()).isEqualTo("Hi!")
        assertThat(after.choices()[0].message().audio().get().expiresAt()).isZero()
        assertThatThrownBy {
                accumulator.accumulate(chunk("""{"index":0,"delta":{"content":"late"}}"""))
            }
            .isInstanceOf(IllegalStateException::class.java)
    }
}
