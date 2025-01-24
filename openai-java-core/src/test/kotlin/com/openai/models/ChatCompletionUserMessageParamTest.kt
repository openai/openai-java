// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChatCompletionUserMessageParamTest {

    @Test
    fun createChatCompletionUserMessageParam() {
        val chatCompletionUserMessageParam =
            ChatCompletionUserMessageParam.builder().content("string").name("name").build()
        assertThat(chatCompletionUserMessageParam).isNotNull
        assertThat(chatCompletionUserMessageParam.content())
            .isEqualTo(ChatCompletionUserMessageParam.Content.ofText("string"))
        assertThat(chatCompletionUserMessageParam.name()).contains("name")
    }
}
