// File generated from our OpenAPI spec by Stainless.

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
                .id("id")
                .chatkitConfiguration(
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
                        .history(
                            ChatSessionHistory.builder().enabled(true).recentThreads(0L).build()
                        )
                        .build()
                )
                .clientSecret("client_secret")
                .expiresAt(0L)
                .maxRequestsPer1Minute(0L)
                .rateLimits(ChatSessionRateLimits.builder().maxRequestsPer1Minute(0L).build())
                .status(ChatSessionStatus.ACTIVE)
                .user("user")
                .workflow(
                    ChatKitWorkflow.builder()
                        .id("id")
                        .stateVariables(
                            ChatKitWorkflow.StateVariables.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .tracing(ChatKitWorkflow.Tracing.builder().enabled(true).build())
                        .version("version")
                        .build()
                )
                .build()

        assertThat(chatSession.id()).isEqualTo("id")
        assertThat(chatSession.chatkitConfiguration())
            .isEqualTo(
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
            )
        assertThat(chatSession.clientSecret()).isEqualTo("client_secret")
        assertThat(chatSession.expiresAt()).isEqualTo(0L)
        assertThat(chatSession.maxRequestsPer1Minute()).isEqualTo(0L)
        assertThat(chatSession.rateLimits())
            .isEqualTo(ChatSessionRateLimits.builder().maxRequestsPer1Minute(0L).build())
        assertThat(chatSession.status()).isEqualTo(ChatSessionStatus.ACTIVE)
        assertThat(chatSession.user()).isEqualTo("user")
        assertThat(chatSession.workflow())
            .isEqualTo(
                ChatKitWorkflow.builder()
                    .id("id")
                    .stateVariables(
                        ChatKitWorkflow.StateVariables.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .tracing(ChatKitWorkflow.Tracing.builder().enabled(true).build())
                    .version("version")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val chatSession =
            ChatSession.builder()
                .id("id")
                .chatkitConfiguration(
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
                        .history(
                            ChatSessionHistory.builder().enabled(true).recentThreads(0L).build()
                        )
                        .build()
                )
                .clientSecret("client_secret")
                .expiresAt(0L)
                .maxRequestsPer1Minute(0L)
                .rateLimits(ChatSessionRateLimits.builder().maxRequestsPer1Minute(0L).build())
                .status(ChatSessionStatus.ACTIVE)
                .user("user")
                .workflow(
                    ChatKitWorkflow.builder()
                        .id("id")
                        .stateVariables(
                            ChatKitWorkflow.StateVariables.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .tracing(ChatKitWorkflow.Tracing.builder().enabled(true).build())
                        .version("version")
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
