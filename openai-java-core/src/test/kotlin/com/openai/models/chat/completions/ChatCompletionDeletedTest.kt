// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.chat.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionDeletedTest {

    @Test
    fun createAndRoundtrip() {
        val chatCompletionDeleted = ChatCompletionDeleted.builder().id("id").deleted(true).build()

        assertThat(chatCompletionDeleted.id()).contains("id")
        assertThat(chatCompletionDeleted.deleted()).contains(true)

        val jsonMapper = jsonMapper()

        val roundtrippedChatCompletionDeleted =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionDeleted),
                jacksonTypeRef<ChatCompletionDeleted>(),
            )

        assertThat(roundtrippedChatCompletionDeleted).isEqualTo(chatCompletionDeleted)
    }
}
