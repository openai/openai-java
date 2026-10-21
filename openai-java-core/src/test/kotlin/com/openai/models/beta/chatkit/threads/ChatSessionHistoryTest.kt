// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.chatkit.threads

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatSessionHistoryTest {

    @Test
    fun createAndRoundtrip() {
        val chatSessionHistory =
            ChatSessionHistory.builder().enabled(true).recentThreads(0L).build()

        assertThat(chatSessionHistory.enabled()).isEqualTo(true)
        assertThat(chatSessionHistory.recentThreads()).contains(0L)

        val jsonMapper = jsonMapper()

        val roundtrippedChatSessionHistory =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatSessionHistory),
                jacksonTypeRef<ChatSessionHistory>(),
            )

        assertThat(roundtrippedChatSessionHistory).isEqualTo(chatSessionHistory)
    }
}
