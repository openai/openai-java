// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.chatkit.threads

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.models.beta.chatkit.ChatKitWorkflow
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatSessionTest {

    @Test
    fun create() {
        val chatSession =
            ChatSession.builder()
                .id("cksess_123")
                .chatkitConfiguration(
                    ChatSessionChatKitConfiguration.builder()
                        .automaticThreadTitling(
                            ChatSessionAutomaticThreadTitling.builder().enabled(true).build()
                        )
                        .fileUpload(
                            ChatSessionFileUpload.builder()
                                .enabled(true)
                                .maxFileSize(16L)
                                .maxFiles(20L)
                                .build()
                        )
                        .history(
                            ChatSessionHistory.builder().enabled(true).recentThreads(10L).build()
                        )
                        .build()
                )
                .clientSecret("ek_token_123")
                .expiresAt(1712349876L)
                .maxRequestsPer1Minute(60L)
                .rateLimits(ChatSessionRateLimits.builder().maxRequestsPer1Minute(60L).build())
                .status(ChatSessionStatus.ACTIVE)
                .user("user_789")
                .workflow(
                    ChatKitWorkflow.builder()
                        .id("workflow_alpha")
                        .stateVariables(
                            ChatKitWorkflow.StateVariables.builder()
                                .putAdditionalProperty("message", JsonValue.from("hello"))
                                .build()
                        )
                        .tracing(ChatKitWorkflow.Tracing.builder().enabled(true).build())
                        .version("2024-10-01")
                        .build()
                )
                .build()

        assertThat(chatSession.id()).isEqualTo("cksess_123")
        assertThat(chatSession.chatkitConfiguration())
            .isEqualTo(
                ChatSessionChatKitConfiguration.builder()
                    .automaticThreadTitling(
                        ChatSessionAutomaticThreadTitling.builder().enabled(true).build()
                    )
                    .fileUpload(
                        ChatSessionFileUpload.builder()
                            .enabled(true)
                            .maxFileSize(16L)
                            .maxFiles(20L)
                            .build()
                    )
                    .history(ChatSessionHistory.builder().enabled(true).recentThreads(10L).build())
                    .build()
            )
        assertThat(chatSession.clientSecret()).isEqualTo("ek_token_123")
        assertThat(chatSession.expiresAt()).isEqualTo(1712349876L)
        assertThat(chatSession.maxRequestsPer1Minute()).isEqualTo(60L)
        assertThat(chatSession.rateLimits())
            .isEqualTo(ChatSessionRateLimits.builder().maxRequestsPer1Minute(60L).build())
        assertThat(chatSession.status()).isEqualTo(ChatSessionStatus.ACTIVE)
        assertThat(chatSession.user()).isEqualTo("user_789")
        assertThat(chatSession.workflow())
            .isEqualTo(
                ChatKitWorkflow.builder()
                    .id("workflow_alpha")
                    .stateVariables(
                        ChatKitWorkflow.StateVariables.builder()
                            .putAdditionalProperty("message", JsonValue.from("hello"))
                            .build()
                    )
                    .tracing(ChatKitWorkflow.Tracing.builder().enabled(true).build())
                    .version("2024-10-01")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val chatSession =
            ChatSession.builder()
                .id("cksess_123")
                .chatkitConfiguration(
                    ChatSessionChatKitConfiguration.builder()
                        .automaticThreadTitling(
                            ChatSessionAutomaticThreadTitling.builder().enabled(true).build()
                        )
                        .fileUpload(
                            ChatSessionFileUpload.builder()
                                .enabled(true)
                                .maxFileSize(16L)
                                .maxFiles(20L)
                                .build()
                        )
                        .history(
                            ChatSessionHistory.builder().enabled(true).recentThreads(10L).build()
                        )
                        .build()
                )
                .clientSecret("ek_token_123")
                .expiresAt(1712349876L)
                .maxRequestsPer1Minute(60L)
                .rateLimits(ChatSessionRateLimits.builder().maxRequestsPer1Minute(60L).build())
                .status(ChatSessionStatus.ACTIVE)
                .user("user_789")
                .workflow(
                    ChatKitWorkflow.builder()
                        .id("workflow_alpha")
                        .stateVariables(
                            ChatKitWorkflow.StateVariables.builder()
                                .putAdditionalProperty("message", JsonValue.from("hello"))
                                .build()
                        )
                        .tracing(ChatKitWorkflow.Tracing.builder().enabled(true).build())
                        .version("2024-10-01")
                        .build()
                )
                .build()

        val roundtrippedChatSession =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatSession),
                jacksonTypeRef<ChatSession>(),
            )

        assertThat(roundtrippedChatSession).isEqualTo(chatSession)
    }
}
