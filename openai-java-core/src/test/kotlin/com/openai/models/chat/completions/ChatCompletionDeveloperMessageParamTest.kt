// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionDeveloperMessageParamTest {

    @Test
    fun create() {
        val chatCompletionDeveloperMessageParam =
            ChatCompletionDeveloperMessageParam.builder().content("string").name("name").build()

        assertThat(chatCompletionDeveloperMessageParam.content())
            .isEqualTo(ChatCompletionDeveloperMessageParam.Content.ofText("string"))
        assertThat(chatCompletionDeveloperMessageParam.name()).contains("name")
    }
}
