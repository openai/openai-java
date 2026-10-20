// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionInProgressWebhookEventTest {

    @Test
    fun create() {
        val agentSessionInProgressWebhookEvent =
            AgentSessionInProgressWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(
                    AgentSessionInProgressWebhookEvent.Data.builder()
                        .id("id")
                        .environmentType("environment_type")
                        .environmentId("environment_id")
                        .build()
                )
                .build()

        assertThat(agentSessionInProgressWebhookEvent.id()).isEqualTo("id")
        assertThat(agentSessionInProgressWebhookEvent.createdAt()).isEqualTo(0L)
        assertThat(agentSessionInProgressWebhookEvent.data())
            .isEqualTo(
                AgentSessionInProgressWebhookEvent.Data.builder()
                    .id("id")
                    .environmentType("environment_type")
                    .environmentId("environment_id")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionInProgressWebhookEvent =
            AgentSessionInProgressWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(
                    AgentSessionInProgressWebhookEvent.Data.builder()
                        .id("id")
                        .environmentType("environment_type")
                        .environmentId("environment_id")
                        .build()
                )
                .build()

        val roundtrippedAgentSessionInProgressWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionInProgressWebhookEvent),
                jacksonTypeRef<AgentSessionInProgressWebhookEvent>(),
            )

        assertThat(roundtrippedAgentSessionInProgressWebhookEvent)
            .isEqualTo(agentSessionInProgressWebhookEvent)
    }
}
