// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.chatkit.sessions

import com.openai.core.JsonValue
import com.openai.models.beta.chatkit.threads.ChatSessionChatKitConfigurationParam
import com.openai.models.beta.chatkit.threads.ChatSessionExpiresAfterParam
import com.openai.models.beta.chatkit.threads.ChatSessionRateLimitsParam
import com.openai.models.beta.chatkit.threads.ChatSessionWorkflowParam
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SessionCreateParamsTest {

    @Test
    fun create() {
        SessionCreateParams.builder()
            .user("x")
            .workflow(
                ChatSessionWorkflowParam.builder()
                    .id("id")
                    .stateVariables(
                        ChatSessionWorkflowParam.StateVariables.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .tracing(ChatSessionWorkflowParam.Tracing.builder().enabled(true).build())
                    .version("version")
                    .build()
            )
            .chatkitConfiguration(
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
            )
            .expiresAfter(ChatSessionExpiresAfterParam.builder().seconds(1L).build())
            .rateLimits(ChatSessionRateLimitsParam.builder().maxRequestsPer1Minute(1L).build())
            .build()
    }

    @Test
    fun body() {
        val params =
            SessionCreateParams.builder()
                .user("x")
                .workflow(
                    ChatSessionWorkflowParam.builder()
                        .id("id")
                        .stateVariables(
                            ChatSessionWorkflowParam.StateVariables.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .tracing(ChatSessionWorkflowParam.Tracing.builder().enabled(true).build())
                        .version("version")
                        .build()
                )
                .chatkitConfiguration(
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
                )
                .expiresAfter(ChatSessionExpiresAfterParam.builder().seconds(1L).build())
                .rateLimits(ChatSessionRateLimitsParam.builder().maxRequestsPer1Minute(1L).build())
                .build()

        val body = params._body()

        assertThat(body.user()).isEqualTo("x")
        assertThat(body.workflow())
            .isEqualTo(
                ChatSessionWorkflowParam.builder()
                    .id("id")
                    .stateVariables(
                        ChatSessionWorkflowParam.StateVariables.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .tracing(ChatSessionWorkflowParam.Tracing.builder().enabled(true).build())
                    .version("version")
                    .build()
            )
        assertThat(body.chatkitConfiguration())
            .contains(
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
            )
        assertThat(body.expiresAfter())
            .contains(ChatSessionExpiresAfterParam.builder().seconds(1L).build())
        assertThat(body.rateLimits())
            .contains(ChatSessionRateLimitsParam.builder().maxRequestsPer1Minute(1L).build())
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            SessionCreateParams.builder()
                .user("x")
                .workflow(ChatSessionWorkflowParam.builder().id("id").build())
                .build()

        val body = params._body()

        assertThat(body.user()).isEqualTo("x")
        assertThat(body.workflow()).isEqualTo(ChatSessionWorkflowParam.builder().id("id").build())
    }
}
