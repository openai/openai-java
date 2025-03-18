// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionUserMessageParamTest {

    @Test
    fun create() {
        val chatCompletionUserMessageParam =
            ChatCompletionUserMessageParam.builder().content("string").name("name").build()

        assertThat(chatCompletionUserMessageParam.content())
            .isEqualTo(ChatCompletionUserMessageParam.Content.ofText("string"))
        assertThat(chatCompletionUserMessageParam.name()).contains("name")
    }
}
