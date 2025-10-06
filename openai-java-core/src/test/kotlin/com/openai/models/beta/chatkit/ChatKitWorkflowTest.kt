// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.chatkit

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatKitWorkflowTest {

    @Test
    fun create() {
        val chatkitWorkflow =
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

        assertThat(chatkitWorkflow.id()).isEqualTo("id")
        assertThat(chatkitWorkflow.stateVariables())
            .contains(
                ChatKitWorkflow.StateVariables.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(chatkitWorkflow.tracing())
            .isEqualTo(ChatKitWorkflow.Tracing.builder().enabled(true).build())
        assertThat(chatkitWorkflow.version()).contains("version")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val chatkitWorkflow =
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

        val roundtrippedChatKitWorkflow =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatkitWorkflow),
                jacksonTypeRef<ChatKitWorkflow>(),
            )

        assertThat(roundtrippedChatKitWorkflow).isEqualTo(chatkitWorkflow)
    }
}
