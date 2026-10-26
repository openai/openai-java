// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentEnvironmentSuspendedWebhookEventTest {

    @Test
    fun createAndRoundtrip() {
        val agentEnvironmentSuspendedWebhookEvent =
            AgentEnvironmentSuspendedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(AgentEnvironmentSuspendedWebhookEvent.Data.builder().id("id").build())
                .build()

        assertThat(agentEnvironmentSuspendedWebhookEvent.id()).isEqualTo("id")
        assertThat(agentEnvironmentSuspendedWebhookEvent.createdAt()).isEqualTo(0L)
        assertThat(agentEnvironmentSuspendedWebhookEvent.data())
            .isEqualTo(AgentEnvironmentSuspendedWebhookEvent.Data.builder().id("id").build())

        val jsonMapper = jsonMapper()

        val roundtrippedAgentEnvironmentSuspendedWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentEnvironmentSuspendedWebhookEvent),
                jacksonTypeRef<AgentEnvironmentSuspendedWebhookEvent>(),
            )

        assertThat(roundtrippedAgentEnvironmentSuspendedWebhookEvent)
            .isEqualTo(agentEnvironmentSuspendedWebhookEvent)
    }
}
