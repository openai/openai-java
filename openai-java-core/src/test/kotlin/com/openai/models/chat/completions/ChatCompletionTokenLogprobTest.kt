// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionTokenLogprobTest {

    @Test
    fun create() {
        val chatCompletionTokenLogprob =
            ChatCompletionTokenLogprob.builder()
                .token("token")
                .addByte(0L)
                .logprob(0.0)
                .addTopLogprob(
                    ChatCompletionTokenLogprob.TopLogprob.builder()
                        .token("token")
                        .addByte(0L)
                        .logprob(0.0)
                        .build()
                )
                .build()

        assertThat(chatCompletionTokenLogprob.token()).isEqualTo("token")
        assertThat(chatCompletionTokenLogprob.bytes().getOrNull()).containsExactly(0L)
        assertThat(chatCompletionTokenLogprob.logprob()).isEqualTo(0.0)
        assertThat(chatCompletionTokenLogprob.topLogprobs())
            .containsExactly(
                ChatCompletionTokenLogprob.TopLogprob.builder()
                    .token("token")
                    .addByte(0L)
                    .logprob(0.0)
                    .build()
            )
    }
}
