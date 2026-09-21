// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookCreateParamsTest {

    @Test
    fun create() {
        WebhookCreateParams.builder()
            .addEventType(WebhookCreateParams.EventType.BATCH_COMPLETED)
            .name("x")
            .url("https://")
            .build()
    }

    @Test
    fun body() {
        val params =
            WebhookCreateParams.builder()
                .addEventType(WebhookCreateParams.EventType.BATCH_COMPLETED)
                .name("x")
                .url("https://")
                .build()

        val body = params._body()

        assertThat(body.eventTypes()).containsExactly(WebhookCreateParams.EventType.BATCH_COMPLETED)
        assertThat(body.name()).isEqualTo("x")
        assertThat(body.url()).isEqualTo("https://")
    }
}
