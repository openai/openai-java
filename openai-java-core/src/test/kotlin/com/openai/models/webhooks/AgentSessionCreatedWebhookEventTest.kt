// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionCreatedWebhookEventTest {

    @Test
    fun createAndRoundtrip() {
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

        assertThat(agentSessionCreatedWebhookEvent.id()).contains("id")
        assertThat(agentSessionCreatedWebhookEvent.createdAt()).contains(0L)
        assertThat(agentSessionCreatedWebhookEvent.data())
            .contains(
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

        val jsonMapper = jsonMapper()

        val roundtrippedAgentSessionCreatedWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionCreatedWebhookEvent),
                jacksonTypeRef<AgentSessionCreatedWebhookEvent>(),
            )

        assertThat(roundtrippedAgentSessionCreatedWebhookEvent)
            .isEqualTo(agentSessionCreatedWebhookEvent)
    }
}
