// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentEnvironmentFailedWebhookEventTest {

    @Test
    fun createAndRoundtrip() {
        val agentEnvironmentFailedWebhookEvent =
            AgentEnvironmentFailedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(AgentEnvironmentFailedWebhookEvent.Data.builder().id("id").build())
                .build()

        assertThat(agentEnvironmentFailedWebhookEvent.id()).isEqualTo("id")
        assertThat(agentEnvironmentFailedWebhookEvent.createdAt()).isEqualTo(0L)
        assertThat(agentEnvironmentFailedWebhookEvent.data())
            .isEqualTo(AgentEnvironmentFailedWebhookEvent.Data.builder().id("id").build())

        val jsonMapper = jsonMapper()

        val roundtrippedAgentEnvironmentFailedWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentEnvironmentFailedWebhookEvent),
                jacksonTypeRef<AgentEnvironmentFailedWebhookEvent>(),
            )

        assertThat(roundtrippedAgentEnvironmentFailedWebhookEvent)
            .isEqualTo(agentEnvironmentFailedWebhookEvent)
    }
}
