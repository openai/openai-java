// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionContentPartRefusalTest {

    @Test
    fun create() {
        val chatCompletionContentPartRefusal =
            ChatCompletionContentPartRefusal.builder().refusal("refusal").build()

        assertThat(chatCompletionContentPartRefusal.refusal()).isEqualTo("refusal")
    }
}
