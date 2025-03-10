// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChatCompletionSystemMessageParamTest {

    @Test
    fun createChatCompletionSystemMessageParam() {
        val chatCompletionSystemMessageParam =
            ChatCompletionSystemMessageParam.builder().content("string").name("name").build()
        assertThat(chatCompletionSystemMessageParam).isNotNull
        assertThat(chatCompletionSystemMessageParam.content())
            .isEqualTo(ChatCompletionSystemMessageParam.Content.ofText("string"))
        assertThat(chatCompletionSystemMessageParam.name()).contains("name")
    }
}
