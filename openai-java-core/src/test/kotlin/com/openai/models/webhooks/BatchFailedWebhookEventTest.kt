// File generated from our OpenAPI spec by Stainless.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BatchFailedWebhookEventTest {

    @Test
    fun create() {
        val batchFailedWebhookEvent =
            BatchFailedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(BatchFailedWebhookEvent.Data.builder().id("id").build())
                .object_(BatchFailedWebhookEvent.Object.EVENT)
                .build()

        assertThat(batchFailedWebhookEvent.id()).isEqualTo("id")
        assertThat(batchFailedWebhookEvent.createdAt()).isEqualTo(0L)
        assertThat(batchFailedWebhookEvent.data())
            .isEqualTo(BatchFailedWebhookEvent.Data.builder().id("id").build())
        assertThat(batchFailedWebhookEvent.object_()).contains(BatchFailedWebhookEvent.Object.EVENT)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val batchFailedWebhookEvent =
            BatchFailedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(BatchFailedWebhookEvent.Data.builder().id("id").build())
                .object_(BatchFailedWebhookEvent.Object.EVENT)
                .build()

        val roundtrippedBatchFailedWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(batchFailedWebhookEvent),
                jacksonTypeRef<BatchFailedWebhookEvent>(),
            )

        assertThat(roundtrippedBatchFailedWebhookEvent).isEqualTo(batchFailedWebhookEvent)
    }
}
