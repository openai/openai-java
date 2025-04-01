// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionDeletedTest {

    @Test
    fun create() {
        val chatCompletionDeleted = ChatCompletionDeleted.builder().id("id").deleted(true).build()

        assertThat(chatCompletionDeleted.id()).isEqualTo("id")
        assertThat(chatCompletionDeleted.deleted()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionDeleted = ChatCompletionDeleted.builder().id("id").deleted(true).build()

        val roundtrippedChatCompletionDeleted =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionDeleted),
                jacksonTypeRef<ChatCompletionDeleted>(),
            )

        assertThat(roundtrippedChatCompletionDeleted).isEqualTo(chatCompletionDeleted)
    }
}
