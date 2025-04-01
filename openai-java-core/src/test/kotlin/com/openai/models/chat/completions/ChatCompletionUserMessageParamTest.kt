// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionUserMessageParamTest {

    @Test
    fun create() {
        val chatCompletionUserMessageParam =
            ChatCompletionUserMessageParam.builder().content("string").name("name").build()

        assertThat(chatCompletionUserMessageParam.content())
            .isEqualTo(ChatCompletionUserMessageParam.Content.ofText("string"))
        assertThat(chatCompletionUserMessageParam.name()).contains("name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionUserMessageParam =
            ChatCompletionUserMessageParam.builder().content("string").name("name").build()

        val roundtrippedChatCompletionUserMessageParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionUserMessageParam),
                jacksonTypeRef<ChatCompletionUserMessageParam>(),
            )

        assertThat(roundtrippedChatCompletionUserMessageParam)
            .isEqualTo(chatCompletionUserMessageParam)
    }
}
