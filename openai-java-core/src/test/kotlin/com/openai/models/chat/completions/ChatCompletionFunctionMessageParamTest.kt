// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.chat.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionFunctionMessageParamTest {

    @Test
    fun createAndRoundtrip() {
        val chatCompletionFunctionMessageParam =
            ChatCompletionFunctionMessageParam.builder().content("content").name("name").build()

        assertThat(chatCompletionFunctionMessageParam.content()).contains("content")
        assertThat(chatCompletionFunctionMessageParam.name()).isEqualTo("name")

        val jsonMapper = jsonMapper()

        val roundtrippedChatCompletionFunctionMessageParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionFunctionMessageParam),
                jacksonTypeRef<ChatCompletionFunctionMessageParam>(),
            )

        assertThat(roundtrippedChatCompletionFunctionMessageParam)
            .isEqualTo(chatCompletionFunctionMessageParam)
    }
}
