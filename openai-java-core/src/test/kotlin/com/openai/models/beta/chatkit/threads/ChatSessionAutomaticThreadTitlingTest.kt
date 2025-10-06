// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.chatkit.threads

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatSessionAutomaticThreadTitlingTest {

    @Test
    fun create() {
        val chatSessionAutomaticThreadTitling =
            ChatSessionAutomaticThreadTitling.builder().enabled(true).build()

        assertThat(chatSessionAutomaticThreadTitling.enabled()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val chatSessionAutomaticThreadTitling =
            ChatSessionAutomaticThreadTitling.builder().enabled(true).build()

        val roundtrippedChatSessionAutomaticThreadTitling =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatSessionAutomaticThreadTitling),
                jacksonTypeRef<ChatSessionAutomaticThreadTitling>(),
            )

        assertThat(roundtrippedChatSessionAutomaticThreadTitling)
            .isEqualTo(chatSessionAutomaticThreadTitling)
    }
}
