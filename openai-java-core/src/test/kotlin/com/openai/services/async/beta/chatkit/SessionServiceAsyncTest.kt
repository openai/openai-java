// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta.chatkit

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.core.JsonValue
import com.openai.models.beta.chatkit.sessions.SessionCreateParams
import com.openai.models.beta.chatkit.threads.ChatSessionChatKitConfigurationParam
import com.openai.models.beta.chatkit.threads.ChatSessionExpiresAfterParam
import com.openai.models.beta.chatkit.threads.ChatSessionRateLimitsParam
import com.openai.models.beta.chatkit.threads.ChatSessionWorkflowParam
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class SessionServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val sessionServiceAsync = client.beta().chatkit().sessions()

        val chatSessionFuture =
            sessionServiceAsync.create(
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
                            .tracing(
                                ChatSessionWorkflowParam.Tracing.builder().enabled(true).build()
                            )
                            .version("version")
                            .build()
                    )
                    .chatkitConfiguration(
                        ChatSessionChatKitConfigurationParam.builder()
                            .automaticThreadTitling(
                                ChatSessionChatKitConfigurationParam.AutomaticThreadTitling
                                    .builder()
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
                    .rateLimits(
                        ChatSessionRateLimitsParam.builder().maxRequestsPer1Minute(1L).build()
                    )
                    .build()
            )

        val chatSession = chatSessionFuture.get()
        chatSession.validate()
    }

    @Test
    fun cancel() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val sessionServiceAsync = client.beta().chatkit().sessions()

        val chatSessionFuture = sessionServiceAsync.cancel("cksess_123")

        val chatSession = chatSessionFuture.get()
        chatSession.validate()
    }
}
