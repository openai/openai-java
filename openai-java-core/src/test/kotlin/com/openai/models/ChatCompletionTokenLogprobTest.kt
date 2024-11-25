// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChatCompletionTokenLogprobTest {

    @Test
    fun createChatCompletionTokenLogprob() {
        val chatCompletionTokenLogprob =
            ChatCompletionTokenLogprob.builder()
                .token("token")
                .bytes(listOf(0L))
                .logprob(0.0)
                .topLogprobs(
                    listOf(
                        ChatCompletionTokenLogprob.TopLogprob.builder()
                            .token("token")
                            .bytes(listOf(0L))
                            .logprob(0.0)
                            .build()
                    )
                )
                .build()
        assertThat(chatCompletionTokenLogprob).isNotNull
        assertThat(chatCompletionTokenLogprob.token()).isEqualTo("token")
        assertThat(chatCompletionTokenLogprob.bytes().get()).containsExactly(0L)
        assertThat(chatCompletionTokenLogprob.logprob()).isEqualTo(0.0)
        assertThat(chatCompletionTokenLogprob.topLogprobs())
            .containsExactly(
                ChatCompletionTokenLogprob.TopLogprob.builder()
                    .token("token")
                    .bytes(listOf(0L))
                    .logprob(0.0)
                    .build()
            )
    }
}
