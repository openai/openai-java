// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookEndpointWithSecretTest {

    @Test
    fun toStringRedactsSigningSecret() {
        val secret = "whsec_test_only_do_not_log"
        val webhookEndpointWithSecret =
            WebhookEndpointWithSecret.builder()
                .id("whe_test")
                .createdAt(0L)
                .addEventType("response.completed")
                .name("Test webhook")
                .signingSecret(secret)
                .signingSecretHint(null as String?)
                .url("https://example.com/webhook")
                .build()

        assertThat(webhookEndpointWithSecret.toString())
            .doesNotContain(secret)
            .contains("signingSecret=[REDACTED]")
        assertThat(webhookEndpointWithSecret.signingSecret()).isEqualTo(secret)

        val mapper = jsonMapper()
        val serialized = mapper.readTree(mapper.writeValueAsString(webhookEndpointWithSecret))
        assertThat(serialized.get("signing_secret").asText()).isEqualTo(secret)
    }

    @Test
    fun create() {
        val webhookEndpointWithSecret =
            WebhookEndpointWithSecret.builder()
                .id("id")
                .createdAt(0L)
                .addEventType("string")
                .name("name")
                .signingSecret("signing_secret")
                .signingSecretHint("signing_secret_hint")
                .url("url")
                .updatedAt(0L)
                .build()

        assertThat(webhookEndpointWithSecret.id()).isEqualTo("id")
        assertThat(webhookEndpointWithSecret.createdAt()).isEqualTo(0L)
        assertThat(webhookEndpointWithSecret.eventTypes()).containsExactly("string")
        assertThat(webhookEndpointWithSecret.name()).isEqualTo("name")
        assertThat(webhookEndpointWithSecret.signingSecret()).isEqualTo("signing_secret")
        assertThat(webhookEndpointWithSecret.signingSecretHint()).contains("signing_secret_hint")
        assertThat(webhookEndpointWithSecret.url()).isEqualTo("url")
        assertThat(webhookEndpointWithSecret.updatedAt()).contains(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookEndpointWithSecret =
            WebhookEndpointWithSecret.builder()
                .id("id")
                .createdAt(0L)
                .addEventType("string")
                .name("name")
                .signingSecret("signing_secret")
                .signingSecretHint("signing_secret_hint")
                .url("url")
                .updatedAt(0L)
                .build()

        val roundtrippedWebhookEndpointWithSecret =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookEndpointWithSecret),
                jacksonTypeRef<WebhookEndpointWithSecret>(),
            )

        assertThat(roundtrippedWebhookEndpointWithSecret).isEqualTo(webhookEndpointWithSecret)
    }
}
