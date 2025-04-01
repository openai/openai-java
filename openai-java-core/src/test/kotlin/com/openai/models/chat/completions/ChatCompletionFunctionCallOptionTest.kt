// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionFunctionCallOptionTest {

    @Test
    fun create() {
        val chatCompletionFunctionCallOption =
            ChatCompletionFunctionCallOption.builder().name("name").build()

        assertThat(chatCompletionFunctionCallOption.name()).isEqualTo("name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionFunctionCallOption =
            ChatCompletionFunctionCallOption.builder().name("name").build()

        val roundtrippedChatCompletionFunctionCallOption =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionFunctionCallOption),
                jacksonTypeRef<ChatCompletionFunctionCallOption>(),
            )

        assertThat(roundtrippedChatCompletionFunctionCallOption)
            .isEqualTo(chatCompletionFunctionCallOption)
    }
}
