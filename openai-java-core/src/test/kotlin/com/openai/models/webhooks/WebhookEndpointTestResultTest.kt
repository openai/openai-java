// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookEndpointTestResultTest {

    @Test
    fun create() {
        val webhookEndpointTestResult =
            WebhookEndpointTestResult.builder()
                .eventType("event_type")
                .statusCode(0L)
                .webhookEndpointId("webhook_endpoint_id")
                .build()

        assertThat(webhookEndpointTestResult.eventType()).isEqualTo("event_type")
        assertThat(webhookEndpointTestResult.statusCode()).isEqualTo(0L)
        assertThat(webhookEndpointTestResult.webhookEndpointId()).isEqualTo("webhook_endpoint_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookEndpointTestResult =
            WebhookEndpointTestResult.builder()
                .eventType("event_type")
                .statusCode(0L)
                .webhookEndpointId("webhook_endpoint_id")
                .build()

        val roundtrippedWebhookEndpointTestResult =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookEndpointTestResult),
                jacksonTypeRef<WebhookEndpointTestResult>(),
            )

        assertThat(roundtrippedWebhookEndpointTestResult).isEqualTo(webhookEndpointTestResult)
    }
}
