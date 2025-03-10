// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChatCompletionDeletedTest {

    @Test
    fun createChatCompletionDeleted() {
        val chatCompletionDeleted = ChatCompletionDeleted.builder().id("id").deleted(true).build()
        assertThat(chatCompletionDeleted).isNotNull
        assertThat(chatCompletionDeleted.id()).isEqualTo("id")
        assertThat(chatCompletionDeleted.deleted()).isEqualTo(true)
    }
}
