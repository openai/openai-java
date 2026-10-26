// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.chat.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionUserMessageParamTest {

    @Test
    fun createAndRoundtrip() {
        val chatCompletionUserMessageParam =
            ChatCompletionUserMessageParam.builder().content("string").name("name").build()

        assertThat(chatCompletionUserMessageParam.content())
            .isEqualTo(ChatCompletionUserMessageParam.Content.ofText("string"))
        assertThat(chatCompletionUserMessageParam.name()).contains("name")

        val jsonMapper = jsonMapper()

        val roundtrippedChatCompletionUserMessageParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionUserMessageParam),
                jacksonTypeRef<ChatCompletionUserMessageParam>(),
            )

        assertThat(roundtrippedChatCompletionUserMessageParam)
            .isEqualTo(chatCompletionUserMessageParam)
    }
}
