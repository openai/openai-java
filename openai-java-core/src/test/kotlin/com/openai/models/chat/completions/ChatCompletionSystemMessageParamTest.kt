// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionSystemMessageParamTest {

    @Test
    fun create() {
        val chatCompletionSystemMessageParam =
            ChatCompletionSystemMessageParam.builder().content("string").name("name").build()

        assertThat(chatCompletionSystemMessageParam.content())
            .isEqualTo(ChatCompletionSystemMessageParam.Content.ofText("string"))
        assertThat(chatCompletionSystemMessageParam.name()).contains("name")
    }
}
