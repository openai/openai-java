// File generated from our OpenAPI spec by Stainless.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseFailedWebhookEventTest {

    @Test
    fun create() {
        val responseFailedWebhookEvent =
            ResponseFailedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(ResponseFailedWebhookEvent.Data.builder().id("id").build())
                .object_(ResponseFailedWebhookEvent.Object.EVENT)
                .build()

        assertThat(responseFailedWebhookEvent.id()).isEqualTo("id")
        assertThat(responseFailedWebhookEvent.createdAt()).isEqualTo(0L)
        assertThat(responseFailedWebhookEvent.data())
            .isEqualTo(ResponseFailedWebhookEvent.Data.builder().id("id").build())
        assertThat(responseFailedWebhookEvent.object_())
            .contains(ResponseFailedWebhookEvent.Object.EVENT)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseFailedWebhookEvent =
            ResponseFailedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(ResponseFailedWebhookEvent.Data.builder().id("id").build())
                .object_(ResponseFailedWebhookEvent.Object.EVENT)
                .build()

        val roundtrippedResponseFailedWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseFailedWebhookEvent),
                jacksonTypeRef<ResponseFailedWebhookEvent>(),
            )

        assertThat(roundtrippedResponseFailedWebhookEvent).isEqualTo(responseFailedWebhookEvent)
    }
}
