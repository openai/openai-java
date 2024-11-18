// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChatCompletionFunctionMessageParamTest {

    @Test
    fun createChatCompletionFunctionMessageParam() {
        val chatCompletionFunctionMessageParam =
            ChatCompletionFunctionMessageParam.builder()
                .content("content")
                .name("name")
                .role(ChatCompletionFunctionMessageParam.Role.FUNCTION)
                .build()
        assertThat(chatCompletionFunctionMessageParam).isNotNull
        assertThat(chatCompletionFunctionMessageParam.content()).contains("content")
        assertThat(chatCompletionFunctionMessageParam.name()).isEqualTo("name")
        assertThat(chatCompletionFunctionMessageParam.role())
            .isEqualTo(ChatCompletionFunctionMessageParam.Role.FUNCTION)
    }
}