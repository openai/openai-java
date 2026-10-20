// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentEnvironmentExpiredWebhookEventTest {

    @Test
    fun create() {
        val agentEnvironmentExpiredWebhookEvent =
            AgentEnvironmentExpiredWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(AgentEnvironmentExpiredWebhookEvent.Data.builder().id("id").build())
                .build()

        assertThat(agentEnvironmentExpiredWebhookEvent.id()).isEqualTo("id")
        assertThat(agentEnvironmentExpiredWebhookEvent.createdAt()).isEqualTo(0L)
        assertThat(agentEnvironmentExpiredWebhookEvent.data())
            .isEqualTo(AgentEnvironmentExpiredWebhookEvent.Data.builder().id("id").build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentEnvironmentExpiredWebhookEvent =
            AgentEnvironmentExpiredWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(AgentEnvironmentExpiredWebhookEvent.Data.builder().id("id").build())
                .build()

        val roundtrippedAgentEnvironmentExpiredWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentEnvironmentExpiredWebhookEvent),
                jacksonTypeRef<AgentEnvironmentExpiredWebhookEvent>(),
            )

        assertThat(roundtrippedAgentEnvironmentExpiredWebhookEvent)
            .isEqualTo(agentEnvironmentExpiredWebhookEvent)
    }
}
