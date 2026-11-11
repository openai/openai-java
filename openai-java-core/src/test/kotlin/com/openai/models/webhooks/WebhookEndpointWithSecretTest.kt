// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookEndpointWithSecretTest {

    @Test
    fun createAndRoundtrip() {
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

        assertThat(webhookEndpointWithSecret.id()).contains("id")
        assertThat(webhookEndpointWithSecret.createdAt()).contains(0L)
        assertThat(webhookEndpointWithSecret.eventTypes().getOrNull()).containsExactly("string")
        assertThat(webhookEndpointWithSecret.name()).contains("name")
        assertThat(webhookEndpointWithSecret.signingSecret()).contains("signing_secret")
        assertThat(webhookEndpointWithSecret.signingSecretHint()).contains("signing_secret_hint")
        assertThat(webhookEndpointWithSecret.url()).contains("url")
        assertThat(webhookEndpointWithSecret.updatedAt()).contains(0L)

        val jsonMapper = jsonMapper()

        val roundtrippedWebhookEndpointWithSecret =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookEndpointWithSecret),
                jacksonTypeRef<WebhookEndpointWithSecret>(),
            )

        assertThat(roundtrippedWebhookEndpointWithSecret).isEqualTo(webhookEndpointWithSecret)
    }
}
