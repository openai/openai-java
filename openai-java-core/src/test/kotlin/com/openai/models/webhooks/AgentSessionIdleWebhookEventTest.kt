// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionIdleWebhookEventTest {

    @Test
    fun create() {
        val agentSessionIdleWebhookEvent =
            AgentSessionIdleWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(
                    AgentSessionIdleWebhookEvent.Data.builder()
                        .id("id")
                        .environmentType("environment_type")
                        .environmentId("environment_id")
                        .build()
                )
                .build()

        assertThat(agentSessionIdleWebhookEvent.id()).isEqualTo("id")
        assertThat(agentSessionIdleWebhookEvent.createdAt()).isEqualTo(0L)
        assertThat(agentSessionIdleWebhookEvent.data())
            .isEqualTo(
                AgentSessionIdleWebhookEvent.Data.builder()
                    .id("id")
                    .environmentType("environment_type")
                    .environmentId("environment_id")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionIdleWebhookEvent =
            AgentSessionIdleWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(
                    AgentSessionIdleWebhookEvent.Data.builder()
                        .id("id")
                        .environmentType("environment_type")
                        .environmentId("environment_id")
                        .build()
                )
                .build()

        val roundtrippedAgentSessionIdleWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionIdleWebhookEvent),
                jacksonTypeRef<AgentSessionIdleWebhookEvent>(),
            )

        assertThat(roundtrippedAgentSessionIdleWebhookEvent).isEqualTo(agentSessionIdleWebhookEvent)
    }
}
