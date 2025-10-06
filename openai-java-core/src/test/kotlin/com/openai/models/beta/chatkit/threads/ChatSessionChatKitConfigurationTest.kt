// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.chatkit.threads

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatSessionChatKitConfigurationTest {

    @Test
    fun create() {
        val chatSessionChatKitConfiguration =
            ChatSessionChatKitConfiguration.builder()
                .automaticThreadTitling(
                    ChatSessionAutomaticThreadTitling.builder().enabled(true).build()
                )
                .fileUpload(
                    ChatSessionFileUpload.builder()
                        .enabled(true)
                        .maxFileSize(0L)
                        .maxFiles(0L)
                        .build()
                )
                .history(ChatSessionHistory.builder().enabled(true).recentThreads(0L).build())
                .build()

        assertThat(chatSessionChatKitConfiguration.automaticThreadTitling())
            .isEqualTo(ChatSessionAutomaticThreadTitling.builder().enabled(true).build())
        assertThat(chatSessionChatKitConfiguration.fileUpload())
            .isEqualTo(
                ChatSessionFileUpload.builder().enabled(true).maxFileSize(0L).maxFiles(0L).build()
            )
        assertThat(chatSessionChatKitConfiguration.history())
            .isEqualTo(ChatSessionHistory.builder().enabled(true).recentThreads(0L).build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val chatSessionChatKitConfiguration =
            ChatSessionChatKitConfiguration.builder()
                .automaticThreadTitling(
                    ChatSessionAutomaticThreadTitling.builder().enabled(true).build()
                )
                .fileUpload(
                    ChatSessionFileUpload.builder()
                        .enabled(true)
                        .maxFileSize(0L)
                        .maxFiles(0L)
                        .build()
                )
                .history(ChatSessionHistory.builder().enabled(true).recentThreads(0L).build())
                .build()

        val roundtrippedChatSessionChatKitConfiguration =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatSessionChatKitConfiguration),
                jacksonTypeRef<ChatSessionChatKitConfiguration>(),
            )

        assertThat(roundtrippedChatSessionChatKitConfiguration)
            .isEqualTo(chatSessionChatKitConfiguration)
    }
}
