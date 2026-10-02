// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionFailedWebhookEventTest {

    @Test
    fun create() {
        val agentSessionFailedWebhookEvent =
            AgentSessionFailedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(
                    AgentSessionFailedWebhookEvent.Data.builder()
                        .id("id")
                        .environmentType("environment_type")
                        .environmentId("environment_id")
                        .build()
                )
                .build()

        assertThat(agentSessionFailedWebhookEvent.id()).isEqualTo("id")
        assertThat(agentSessionFailedWebhookEvent.createdAt()).isEqualTo(0L)
        assertThat(agentSessionFailedWebhookEvent.data())
            .isEqualTo(
                AgentSessionFailedWebhookEvent.Data.builder()
                    .id("id")
                    .environmentType("environment_type")
                    .environmentId("environment_id")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionFailedWebhookEvent =
            AgentSessionFailedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(
                    AgentSessionFailedWebhookEvent.Data.builder()
                        .id("id")
                        .environmentType("environment_type")
                        .environmentId("environment_id")
                        .build()
                )
                .build()

        val roundtrippedAgentSessionFailedWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionFailedWebhookEvent),
                jacksonTypeRef<AgentSessionFailedWebhookEvent>(),
            )

        assertThat(roundtrippedAgentSessionFailedWebhookEvent)
            .isEqualTo(agentSessionFailedWebhookEvent)
    }
}
