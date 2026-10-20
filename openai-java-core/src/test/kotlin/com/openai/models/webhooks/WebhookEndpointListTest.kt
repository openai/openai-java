// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookEndpointListTest {

    @Test
    fun create() {
        val webhookEndpointList =
            WebhookEndpointList.builder()
                .addData(
                    WebhookEndpoint.builder()
                        .id("id")
                        .createdAt(0L)
                        .addEventType("string")
                        .name("name")
                        .signingSecretHint("signing_secret_hint")
                        .url("url")
                        .updatedAt(0L)
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(webhookEndpointList.data())
            .containsExactly(
                WebhookEndpoint.builder()
                    .id("id")
                    .createdAt(0L)
                    .addEventType("string")
                    .name("name")
                    .signingSecretHint("signing_secret_hint")
                    .url("url")
                    .updatedAt(0L)
                    .build()
            )
        assertThat(webhookEndpointList.firstId()).contains("first_id")
        assertThat(webhookEndpointList.hasMore()).isEqualTo(true)
        assertThat(webhookEndpointList.lastId()).contains("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookEndpointList =
            WebhookEndpointList.builder()
                .addData(
                    WebhookEndpoint.builder()
                        .id("id")
                        .createdAt(0L)
                        .addEventType("string")
                        .name("name")
                        .signingSecretHint("signing_secret_hint")
                        .url("url")
                        .updatedAt(0L)
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        val roundtrippedWebhookEndpointList =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookEndpointList),
                jacksonTypeRef<WebhookEndpointList>(),
            )

        assertThat(roundtrippedWebhookEndpointList).isEqualTo(webhookEndpointList)
    }
}
