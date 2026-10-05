// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookUpdateParamsTest {

    @Test
    fun create() {
        WebhookUpdateParams.builder()
            .webhookEndpointId("whe_123")
            .addEventType(WebhookUpdateParams.EventType.BATCH_COMPLETED)
            .name("x")
            .url("https://")
            .build()
    }

    @Test
    fun pathParams() {
        val params = WebhookUpdateParams.builder().webhookEndpointId("whe_123").build()

        assertThat(params._pathParam(0)).isEqualTo("whe_123")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            WebhookUpdateParams.builder()
                .webhookEndpointId("whe_123")
                .addEventType(WebhookUpdateParams.EventType.BATCH_COMPLETED)
                .name("x")
                .url("https://")
                .build()

        val body = params._body()

        assertThat(body.eventTypes().getOrNull())
            .containsExactly(WebhookUpdateParams.EventType.BATCH_COMPLETED)
        assertThat(body.name()).contains("x")
        assertThat(body.url()).contains("https://")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = WebhookUpdateParams.builder().webhookEndpointId("whe_123").build()

        val body = params._body()
    }
}
