// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionCreatedWebhookEventTest {

    @Test
    fun create() {
        val agentSessionCreatedWebhookEvent =
            AgentSessionCreatedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(
                    AgentSessionCreatedWebhookEvent.Data.builder()
                        .id("id")
                        .environmentType("environment_type")
                        .connect(
                            AgentSessionCreatedWebhookEvent.Data.Connect.builder()
                                .remoteUrl("remote_url")
                                .build()
                        )
                        .environmentId("environment_id")
                        .build()
                )
                .build()

        assertThat(agentSessionCreatedWebhookEvent.id()).isEqualTo("id")
        assertThat(agentSessionCreatedWebhookEvent.createdAt()).isEqualTo(0L)
        assertThat(agentSessionCreatedWebhookEvent.data())
            .isEqualTo(
                AgentSessionCreatedWebhookEvent.Data.builder()
                    .id("id")
                    .environmentType("environment_type")
                    .connect(
                        AgentSessionCreatedWebhookEvent.Data.Connect.builder()
                            .remoteUrl("remote_url")
                            .build()
                    )
                    .environmentId("environment_id")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionCreatedWebhookEvent =
            AgentSessionCreatedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(
                    AgentSessionCreatedWebhookEvent.Data.builder()
                        .id("id")
                        .environmentType("environment_type")
                        .connect(
                            AgentSessionCreatedWebhookEvent.Data.Connect.builder()
                                .remoteUrl("remote_url")
                                .build()
                        )
                        .environmentId("environment_id")
                        .build()
                )
                .build()

        val roundtrippedAgentSessionCreatedWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionCreatedWebhookEvent),
                jacksonTypeRef<AgentSessionCreatedWebhookEvent>(),
            )

        assertThat(roundtrippedAgentSessionCreatedWebhookEvent)
            .isEqualTo(agentSessionCreatedWebhookEvent)
    }
}
