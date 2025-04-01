// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
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

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionDeveloperMessageParam =
            ChatCompletionDeveloperMessageParam.builder().content("string").name("name").build()

        val roundtrippedChatCompletionDeveloperMessageParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionDeveloperMessageParam),
                jacksonTypeRef<ChatCompletionDeveloperMessageParam>(),
            )

        assertThat(roundtrippedChatCompletionDeveloperMessageParam)
            .isEqualTo(chatCompletionDeveloperMessageParam)
    }
}
