// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionActionRequiredWebhookEventTest {

    @Test
    fun create() {
        val agentSessionActionRequiredWebhookEvent =
            AgentSessionActionRequiredWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(
                    AgentSessionActionRequiredWebhookEvent.Data.builder()
                        .id("id")
                        .requiredAction(
                            AgentSessionActionRequiredWebhookEvent.Data.RequiredAction.builder()
                                .type(
                                    AgentSessionActionRequiredWebhookEvent.Data.RequiredAction.Type
                                        .COMPUTER_USE_APPROVAL_REQUEST
                                )
                                .build()
                        )
                        .build()
                )
                .build()

        assertThat(agentSessionActionRequiredWebhookEvent.id()).isEqualTo("id")
        assertThat(agentSessionActionRequiredWebhookEvent.createdAt()).isEqualTo(0L)
        assertThat(agentSessionActionRequiredWebhookEvent.data())
            .isEqualTo(
                AgentSessionActionRequiredWebhookEvent.Data.builder()
                    .id("id")
                    .requiredAction(
                        AgentSessionActionRequiredWebhookEvent.Data.RequiredAction.builder()
                            .type(
                                AgentSessionActionRequiredWebhookEvent.Data.RequiredAction.Type
                                    .COMPUTER_USE_APPROVAL_REQUEST
                            )
                            .build()
                    )
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionActionRequiredWebhookEvent =
            AgentSessionActionRequiredWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(
                    AgentSessionActionRequiredWebhookEvent.Data.builder()
                        .id("id")
                        .requiredAction(
                            AgentSessionActionRequiredWebhookEvent.Data.RequiredAction.builder()
                                .type(
                                    AgentSessionActionRequiredWebhookEvent.Data.RequiredAction.Type
                                        .COMPUTER_USE_APPROVAL_REQUEST
                                )
                                .build()
                        )
                        .build()
                )
                .build()

        val roundtrippedAgentSessionActionRequiredWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionActionRequiredWebhookEvent),
                jacksonTypeRef<AgentSessionActionRequiredWebhookEvent>(),
            )

        assertThat(roundtrippedAgentSessionActionRequiredWebhookEvent)
            .isEqualTo(agentSessionActionRequiredWebhookEvent)
    }
}
