// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionFunctionMessageParamTest {

    @Test
    fun create() {
        val chatCompletionFunctionMessageParam =
            ChatCompletionFunctionMessageParam.builder().content("content").name("name").build()

        assertThat(chatCompletionFunctionMessageParam.content()).contains("content")
        assertThat(chatCompletionFunctionMessageParam.name()).isEqualTo("name")
    }
}
