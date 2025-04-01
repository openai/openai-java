// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionStreamOptionsTest {

    @Test
    fun create() {
        val chatCompletionStreamOptions =
            ChatCompletionStreamOptions.builder().includeUsage(true).build()

        assertThat(chatCompletionStreamOptions.includeUsage()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionStreamOptions =
            ChatCompletionStreamOptions.builder().includeUsage(true).build()

        val roundtrippedChatCompletionStreamOptions =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionStreamOptions),
                jacksonTypeRef<ChatCompletionStreamOptions>(),
            )

        assertThat(roundtrippedChatCompletionStreamOptions).isEqualTo(chatCompletionStreamOptions)
    }
}
