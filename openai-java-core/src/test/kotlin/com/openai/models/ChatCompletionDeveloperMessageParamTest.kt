// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChatCompletionDeveloperMessageParamTest {

    @Test
    fun createChatCompletionDeveloperMessageParam() {
        val chatCompletionDeveloperMessageParam =
            ChatCompletionDeveloperMessageParam.builder()
                .content(ChatCompletionDeveloperMessageParam.Content.ofTextContent("string"))
                .role(ChatCompletionDeveloperMessageParam.Role.DEVELOPER)
                .name("name")
                .build()
        assertThat(chatCompletionDeveloperMessageParam).isNotNull
        assertThat(chatCompletionDeveloperMessageParam.content())
            .isEqualTo(ChatCompletionDeveloperMessageParam.Content.ofTextContent("string"))
        assertThat(chatCompletionDeveloperMessageParam.role())
            .isEqualTo(ChatCompletionDeveloperMessageParam.Role.DEVELOPER)
        assertThat(chatCompletionDeveloperMessageParam.name()).contains("name")
    }
}
