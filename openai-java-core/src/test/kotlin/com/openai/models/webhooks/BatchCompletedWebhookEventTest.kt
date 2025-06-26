// File generated from our OpenAPI spec by Stainless.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BatchCompletedWebhookEventTest {

    @Test
    fun create() {
        val batchCompletedWebhookEvent =
            BatchCompletedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(BatchCompletedWebhookEvent.Data.builder().id("id").build())
                .object_(BatchCompletedWebhookEvent.Object.EVENT)
                .build()

        assertThat(batchCompletedWebhookEvent.id()).isEqualTo("id")
        assertThat(batchCompletedWebhookEvent.createdAt()).isEqualTo(0L)
        assertThat(batchCompletedWebhookEvent.data())
            .isEqualTo(BatchCompletedWebhookEvent.Data.builder().id("id").build())
        assertThat(batchCompletedWebhookEvent.object_())
            .contains(BatchCompletedWebhookEvent.Object.EVENT)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val batchCompletedWebhookEvent =
            BatchCompletedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(BatchCompletedWebhookEvent.Data.builder().id("id").build())
                .object_(BatchCompletedWebhookEvent.Object.EVENT)
                .build()

        val roundtrippedBatchCompletedWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(batchCompletedWebhookEvent),
                jacksonTypeRef<BatchCompletedWebhookEvent>(),
            )

        assertThat(roundtrippedBatchCompletedWebhookEvent).isEqualTo(batchCompletedWebhookEvent)
    }
}
