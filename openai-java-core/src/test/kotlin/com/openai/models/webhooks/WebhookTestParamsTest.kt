// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookTestParamsTest {

    @Test
    fun create() {
        WebhookTestParams.builder()
            .webhookEndpointId("whe_123")
            .eventType(WebhookTestParams.EventType.BATCH_COMPLETED)
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            WebhookTestParams.builder()
                .webhookEndpointId("whe_123")
                .eventType(WebhookTestParams.EventType.BATCH_COMPLETED)
                .build()

        assertThat(params._pathParam(0)).isEqualTo("whe_123")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            WebhookTestParams.builder()
                .webhookEndpointId("whe_123")
                .eventType(WebhookTestParams.EventType.BATCH_COMPLETED)
                .build()

        val body = params._body()

        assertThat(body.eventType()).isEqualTo(WebhookTestParams.EventType.BATCH_COMPLETED)
    }
}
