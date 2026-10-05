// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookDeleteParamsTest {

    @Test
    fun create() {
        WebhookDeleteParams.builder().webhookEndpointId("whe_123").build()
    }

    @Test
    fun pathParams() {
        val params = WebhookDeleteParams.builder().webhookEndpointId("whe_123").build()

        assertThat(params._pathParam(0)).isEqualTo("whe_123")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
