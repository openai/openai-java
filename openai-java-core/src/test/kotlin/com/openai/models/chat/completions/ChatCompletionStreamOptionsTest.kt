// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionStreamOptionsTest {

    @Test
    fun create() {
        val chatCompletionStreamOptions =
            ChatCompletionStreamOptions.builder().includeUsage(true).build()

        assertThat(chatCompletionStreamOptions.includeUsage()).contains(true)
    }
}
