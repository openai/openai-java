// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.chat.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionToolMessageParamTest {

    @Test
    fun createAndRoundtrip() {
        val chatCompletionToolMessageParam =
            ChatCompletionToolMessageParam.builder()
                .content("string")
                .toolCallId("tool_call_id")
                .build()

        assertThat(chatCompletionToolMessageParam.content())
            .isEqualTo(ChatCompletionToolMessageParam.Content.ofText("string"))
        assertThat(chatCompletionToolMessageParam.toolCallId()).isEqualTo("tool_call_id")

        val jsonMapper = jsonMapper()

        val roundtrippedChatCompletionToolMessageParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionToolMessageParam),
                jacksonTypeRef<ChatCompletionToolMessageParam>(),
            )

        assertThat(roundtrippedChatCompletionToolMessageParam)
            .isEqualTo(chatCompletionToolMessageParam)
    }
}
