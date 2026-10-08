// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentEnvironmentReadyWebhookEventTest {

    @Test
    fun create() {
        val agentEnvironmentReadyWebhookEvent =
            AgentEnvironmentReadyWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(AgentEnvironmentReadyWebhookEvent.Data.builder().id("id").build())
                .build()

        assertThat(agentEnvironmentReadyWebhookEvent.id()).isEqualTo("id")
        assertThat(agentEnvironmentReadyWebhookEvent.createdAt()).isEqualTo(0L)
        assertThat(agentEnvironmentReadyWebhookEvent.data())
            .isEqualTo(AgentEnvironmentReadyWebhookEvent.Data.builder().id("id").build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentEnvironmentReadyWebhookEvent =
            AgentEnvironmentReadyWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(AgentEnvironmentReadyWebhookEvent.Data.builder().id("id").build())
                .build()

        val roundtrippedAgentEnvironmentReadyWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentEnvironmentReadyWebhookEvent),
                jacksonTypeRef<AgentEnvironmentReadyWebhookEvent>(),
            )

        assertThat(roundtrippedAgentEnvironmentReadyWebhookEvent)
            .isEqualTo(agentEnvironmentReadyWebhookEvent)
    }
}
