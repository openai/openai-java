package com.openai.helpers

import com.openai.core.jsonMapper
import com.openai.models.chat.completions.ChatCompletion
import com.openai.models.chat.completions.ChatCompletionChunk
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class ChatCompletionAccumulatorAudioTest {
    private fun chunk(audio: String, finish: String = "", index: Int = 0): ChatCompletionChunk =
        jsonMapper()
            .readValue(
                """{"id":"chatcmpl_audio_test","object":"chat.completion.chunk","created":123,"model":"synthetic-model","choices":[{"index":$index,"delta":{"audio":$audio}$finish}]}""",
                ChatCompletionChunk::class.java,
            )

    @Test
    fun accumulatesFragmentsAndExpiryWithoutFinishReason() {
        val accumulator = ChatCompletionAccumulator.create()
        accumulator.accumulate(chunk("""{"id":"audio_test","data":"YW","transcript":"hello "}"""))
        assertThatThrownBy { accumulator.chatCompletion() }
            .isInstanceOf(IllegalStateException::class.java)
        accumulator.accumulate(chunk("""{"data":"Jj","transcript":"world","custom":"preserved"}"""))
        accumulator.accumulate(chunk("""{"expires_at":456}"""))
        val completion = accumulator.chatCompletion()
        val audio = completion.choices()[0].message().audio().get()
        assertThat(audio.id()).isEqualTo("audio_test")
        assertThat(audio.data()).isEqualTo("YWJj")
        assertThat(audio.transcript()).isEqualTo("hello world")
        assertThat(audio.expiresAt()).isEqualTo(456)
        assertThat(audio._additionalProperties()["custom"]!!.asString().get())
            .isEqualTo("preserved")
        assertThat(completion.choices()[0].finishReason())
            .isEqualTo(ChatCompletion.Choice.FinishReason.STOP)
    }

    @Test
    fun expiryBeforePayloadDoesNotCompleteTheStream() {
        val accumulator = ChatCompletionAccumulator.create()
        accumulator.accumulate(chunk("""{"expires_at":456}"""))
        assertThatThrownBy { accumulator.chatCompletion() }
            .isInstanceOf(IllegalStateException::class.java)
        accumulator.accumulate(chunk("""{"id":"audio_test","data":"YWJj","transcript":"hello"}"""))
        assertThatThrownBy { accumulator.chatCompletion() }
            .isInstanceOf(IllegalStateException::class.java)
    }

    @Test
    fun finishReasonBeforeExpiryPreservesItsValue() {
        val accumulator = ChatCompletionAccumulator.create()
        accumulator.accumulate(chunk("""{"id":"audio_test","data":"YWJj","transcript":"hello"}"""))
        accumulator.accumulate(chunk("{}", ",\"finish_reason\":\"length\""))
        assertThatThrownBy { accumulator.chatCompletion() }
            .isInstanceOf(IllegalStateException::class.java)
        accumulator.accumulate(chunk("""{"expires_at":456}"""))
        val completion = accumulator.chatCompletion()
        assertThat(completion.choices()[0].finishReason())
            .isEqualTo(ChatCompletion.Choice.FinishReason.LENGTH)
        assertThat(completion.choices()[0].message().audio().get().expiresAt()).isEqualTo(456)
    }

    @Test
    fun multipleChoicesWaitForEachAudioCompletion() {
        val accumulator = ChatCompletionAccumulator.create()
        accumulator.accumulate(
            chunk("""{"id":"audio_0","data":"YWJj","transcript":"first"}""", index = 0)
        )
        accumulator.accumulate(
            chunk("""{"id":"audio_1","data":"YWJj","transcript":"second"}""", index = 1)
        )
        accumulator.accumulate(chunk("""{"expires_at":456}""", index = 0))
        assertThatThrownBy { accumulator.chatCompletion() }
            .isInstanceOf(IllegalStateException::class.java)
        accumulator.accumulate(chunk("""{"expires_at":789}""", index = 1))
        val choices = accumulator.chatCompletion().choices()
        assertThat(choices.map { it.message().audio().get().id() })
            .containsExactly("audio_0", "audio_1")
    }
}
