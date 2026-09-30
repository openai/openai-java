// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookEndpointTest {

    @Test
    fun create() {
        val webhookEndpoint =
            WebhookEndpoint.builder()
                .id("id")
                .createdAt(0L)
                .addEventType("string")
                .name("name")
                .signingSecretHint("signing_secret_hint")
                .url("url")
                .updatedAt(0L)
                .build()

        assertThat(webhookEndpoint.id()).isEqualTo("id")
        assertThat(webhookEndpoint.createdAt()).isEqualTo(0L)
        assertThat(webhookEndpoint.eventTypes()).containsExactly("string")
        assertThat(webhookEndpoint.name()).isEqualTo("name")
        assertThat(webhookEndpoint.signingSecretHint()).contains("signing_secret_hint")
        assertThat(webhookEndpoint.url()).isEqualTo("url")
        assertThat(webhookEndpoint.updatedAt()).contains(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookEndpoint =
            WebhookEndpoint.builder()
                .id("id")
                .createdAt(0L)
                .addEventType("string")
                .name("name")
                .signingSecretHint("signing_secret_hint")
                .url("url")
                .updatedAt(0L)
                .build()

        val roundtrippedWebhookEndpoint =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookEndpoint),
                jacksonTypeRef<WebhookEndpoint>(),
            )

        assertThat(roundtrippedWebhookEndpoint).isEqualTo(webhookEndpoint)
    }
}
