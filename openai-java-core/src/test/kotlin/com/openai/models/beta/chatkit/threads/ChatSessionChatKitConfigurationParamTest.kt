// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.chatkit.threads

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatSessionChatKitConfigurationParamTest {

    @Test
    fun create() {
        val chatSessionChatKitConfigurationParam =
            ChatSessionChatKitConfigurationParam.builder()
                .automaticThreadTitling(
                    ChatSessionChatKitConfigurationParam.AutomaticThreadTitling.builder()
                        .enabled(true)
                        .build()
                )
                .fileUpload(
                    ChatSessionChatKitConfigurationParam.FileUpload.builder()
                        .enabled(true)
                        .maxFileSize(1L)
                        .maxFiles(1L)
                        .build()
                )
                .history(
                    ChatSessionChatKitConfigurationParam.History.builder()
                        .enabled(true)
                        .recentThreads(1L)
                        .build()
                )
                .build()

        assertThat(chatSessionChatKitConfigurationParam.automaticThreadTitling())
            .contains(
                ChatSessionChatKitConfigurationParam.AutomaticThreadTitling.builder()
                    .enabled(true)
                    .build()
            )
        assertThat(chatSessionChatKitConfigurationParam.fileUpload())
            .contains(
                ChatSessionChatKitConfigurationParam.FileUpload.builder()
                    .enabled(true)
                    .maxFileSize(1L)
                    .maxFiles(1L)
                    .build()
            )
        assertThat(chatSessionChatKitConfigurationParam.history())
            .contains(
                ChatSessionChatKitConfigurationParam.History.builder()
                    .enabled(true)
                    .recentThreads(1L)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val chatSessionChatKitConfigurationParam =
            ChatSessionChatKitConfigurationParam.builder()
                .automaticThreadTitling(
                    ChatSessionChatKitConfigurationParam.AutomaticThreadTitling.builder()
                        .enabled(true)
                        .build()
                )
                .fileUpload(
                    ChatSessionChatKitConfigurationParam.FileUpload.builder()
                        .enabled(true)
                        .maxFileSize(1L)
                        .maxFiles(1L)
                        .build()
                )
                .history(
                    ChatSessionChatKitConfigurationParam.History.builder()
                        .enabled(true)
                        .recentThreads(1L)
                        .build()
                )
                .build()

        val roundtrippedChatSessionChatKitConfigurationParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatSessionChatKitConfigurationParam),
                jacksonTypeRef<ChatSessionChatKitConfigurationParam>(),
            )

        assertThat(roundtrippedChatSessionChatKitConfigurationParam)
            .isEqualTo(chatSessionChatKitConfigurationParam)
    }
}
