// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookEndpointTest {

    @Test
    fun createAndRoundtrip() {
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

        assertThat(webhookEndpoint.id()).contains("id")
        assertThat(webhookEndpoint.createdAt()).contains(0L)
        assertThat(webhookEndpoint.eventTypes().getOrNull()).containsExactly("string")
        assertThat(webhookEndpoint.name()).contains("name")
        assertThat(webhookEndpoint.signingSecretHint()).contains("signing_secret_hint")
        assertThat(webhookEndpoint.url()).contains("url")
        assertThat(webhookEndpoint.updatedAt()).contains(0L)

        val jsonMapper = jsonMapper()

        val roundtrippedWebhookEndpoint =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookEndpoint),
                jacksonTypeRef<WebhookEndpoint>(),
            )

        assertThat(roundtrippedWebhookEndpoint).isEqualTo(webhookEndpoint)
    }
}
