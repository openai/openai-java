// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.chat.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionStreamOptionsTest {

    @Test
    fun createAndRoundtrip() {
        val chatCompletionStreamOptions =
            ChatCompletionStreamOptions.builder()
                .includeObfuscation(true)
                .includeUsage(true)
                .build()

        assertThat(chatCompletionStreamOptions.includeObfuscation()).contains(true)
        assertThat(chatCompletionStreamOptions.includeUsage()).contains(true)

        val jsonMapper = jsonMapper()

        val roundtrippedChatCompletionStreamOptions =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionStreamOptions),
                jacksonTypeRef<ChatCompletionStreamOptions>(),
            )

        assertThat(roundtrippedChatCompletionStreamOptions).isEqualTo(chatCompletionStreamOptions)
    }
}
