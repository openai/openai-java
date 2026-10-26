// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.chatkit.threads

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatSessionAutomaticThreadTitlingTest {

    @Test
    fun createAndRoundtrip() {
        val chatSessionAutomaticThreadTitling =
            ChatSessionAutomaticThreadTitling.builder().enabled(true).build()

        assertThat(chatSessionAutomaticThreadTitling.enabled()).isEqualTo(true)

        val jsonMapper = jsonMapper()

        val roundtrippedChatSessionAutomaticThreadTitling =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatSessionAutomaticThreadTitling),
                jacksonTypeRef<ChatSessionAutomaticThreadTitling>(),
            )

        assertThat(roundtrippedChatSessionAutomaticThreadTitling)
            .isEqualTo(chatSessionAutomaticThreadTitling)
    }
}
