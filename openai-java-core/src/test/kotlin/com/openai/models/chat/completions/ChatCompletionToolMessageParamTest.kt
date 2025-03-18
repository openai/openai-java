// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionToolMessageParamTest {

    @Test
    fun create() {
        val chatCompletionToolMessageParam =
            ChatCompletionToolMessageParam.builder()
                .content("string")
                .toolCallId("tool_call_id")
                .build()

        assertThat(chatCompletionToolMessageParam.content())
            .isEqualTo(ChatCompletionToolMessageParam.Content.ofText("string"))
        assertThat(chatCompletionToolMessageParam.toolCallId()).isEqualTo("tool_call_id")
    }
}
