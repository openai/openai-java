package com.openai.models.webhooks

import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookEndpointWithSecretRedactionTest {
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
}
