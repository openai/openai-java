// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionSystemMessageParamTest {

    @Test
    fun create() {
        val chatCompletionSystemMessageParam =
            ChatCompletionSystemMessageParam.builder().content("string").name("name").build()

        assertThat(chatCompletionSystemMessageParam.content())
            .isEqualTo(ChatCompletionSystemMessageParam.Content.ofText("string"))
        assertThat(chatCompletionSystemMessageParam.name()).contains("name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionSystemMessageParam =
            ChatCompletionSystemMessageParam.builder().content("string").name("name").build()

        val roundtrippedChatCompletionSystemMessageParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionSystemMessageParam),
                jacksonTypeRef<ChatCompletionSystemMessageParam>(),
            )

        assertThat(roundtrippedChatCompletionSystemMessageParam)
            .isEqualTo(chatCompletionSystemMessageParam)
    }
}
