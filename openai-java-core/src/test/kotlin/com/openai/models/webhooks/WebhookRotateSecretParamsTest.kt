// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookRotateSecretParamsTest {

    @Test
    fun create() {
        WebhookRotateSecretParams.builder()
            .webhookEndpointId("whe_123")
            .keepOldSecretActiveFor24Hours(true)
            .build()
    }

    @Test
    fun pathParams() {
        val params = WebhookRotateSecretParams.builder().webhookEndpointId("whe_123").build()

        assertThat(params._pathParam(0)).isEqualTo("whe_123")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            WebhookRotateSecretParams.builder()
                .webhookEndpointId("whe_123")
                .keepOldSecretActiveFor24Hours(true)
                .build()

        val body = params._body()

        assertThat(body.keepOldSecretActiveFor24Hours()).contains(true)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = WebhookRotateSecretParams.builder().webhookEndpointId("whe_123").build()

        val body = params._body()
    }
}
