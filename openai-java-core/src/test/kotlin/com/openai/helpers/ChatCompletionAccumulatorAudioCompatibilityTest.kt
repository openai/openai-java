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
        val first = result.choicesOrThrow()[0].messageOrThrow()
        assertThat(first.content()).contains("Text")
        assertThat(first.audio().get().idOrThrow()).isEqualTo("audio-0")
        assertThat(first.audio().get().dataOrThrow()).isEqualTo("abcd")
        assertThat(first.audio().get().transcriptOrThrow()).isEqualTo("Hi there")
        assertThat(first.audio().get().expiresAtOrThrow()).isEqualTo(7)
        assertThat(first.audio().get()._allProperties()["custom"]?.asNumber()?.get()?.toLong())
            .isEqualTo(5L)
        val second = result.choicesOrThrow()[1].messageOrThrow().audio().get()
        assertThat(second.idOrThrow()).isEqualTo("audio-1")
        assertThat(second.dataOrThrow()).isEqualTo("xyz")
        assertThat(second.transcriptOrThrow()).isEqualTo("Bye!")
        assertThat(second.expiresAtOrThrow()).isZero()
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
        assertThat(after.choicesOrThrow()[0].finishReasonOrThrow())
            .isEqualTo(ChatCompletion.Choice.FinishReason.STOP)
        assertThat(after.choicesOrThrow()[0].messageOrThrow().content()).contains("Text")
        assertThat(after.choicesOrThrow()[0].messageOrThrow().audio().get().dataOrThrow())
            .isEqualTo("abcd")
        assertThat(after.choicesOrThrow()[0].messageOrThrow().audio().get().transcriptOrThrow())
            .isEqualTo("Hi!")
        assertThat(after.choicesOrThrow()[0].messageOrThrow().audio().get().expiresAtOrThrow())
            .isZero()
        assertThatThrownBy {
                accumulator.accumulate(chunk("""{"index":0,"delta":{"content":"late"}}"""))
            }
            .isInstanceOf(IllegalStateException::class.java)
    }
}
