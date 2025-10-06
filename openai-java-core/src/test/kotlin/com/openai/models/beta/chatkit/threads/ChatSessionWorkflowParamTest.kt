// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.chatkit.threads

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatSessionWorkflowParamTest {

    @Test
    fun create() {
        val chatSessionWorkflowParam =
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

        assertThat(chatSessionWorkflowParam.id()).isEqualTo("id")
        assertThat(chatSessionWorkflowParam.stateVariables())
            .contains(
                ChatSessionWorkflowParam.StateVariables.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(chatSessionWorkflowParam.tracing())
            .contains(ChatSessionWorkflowParam.Tracing.builder().enabled(true).build())
        assertThat(chatSessionWorkflowParam.version()).contains("version")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val chatSessionWorkflowParam =
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

        val roundtrippedChatSessionWorkflowParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatSessionWorkflowParam),
                jacksonTypeRef<ChatSessionWorkflowParam>(),
            )

        assertThat(roundtrippedChatSessionWorkflowParam).isEqualTo(chatSessionWorkflowParam)
    }
}
