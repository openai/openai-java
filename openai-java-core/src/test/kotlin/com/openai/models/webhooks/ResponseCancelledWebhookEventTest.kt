// File generated from our OpenAPI spec by Stainless.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseCancelledWebhookEventTest {

    @Test
    fun create() {
        val responseCancelledWebhookEvent =
            ResponseCancelledWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(ResponseCancelledWebhookEvent.Data.builder().id("id").build())
                .object_(ResponseCancelledWebhookEvent.Object.EVENT)
                .build()

        assertThat(responseCancelledWebhookEvent.id()).isEqualTo("id")
        assertThat(responseCancelledWebhookEvent.createdAt()).isEqualTo(0L)
        assertThat(responseCancelledWebhookEvent.data())
            .isEqualTo(ResponseCancelledWebhookEvent.Data.builder().id("id").build())
        assertThat(responseCancelledWebhookEvent.object_())
            .contains(ResponseCancelledWebhookEvent.Object.EVENT)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseCancelledWebhookEvent =
            ResponseCancelledWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(ResponseCancelledWebhookEvent.Data.builder().id("id").build())
                .object_(ResponseCancelledWebhookEvent.Object.EVENT)
                .build()

        val roundtrippedResponseCancelledWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseCancelledWebhookEvent),
                jacksonTypeRef<ResponseCancelledWebhookEvent>(),
            )

        assertThat(roundtrippedResponseCancelledWebhookEvent)
            .isEqualTo(responseCancelledWebhookEvent)
    }
}
