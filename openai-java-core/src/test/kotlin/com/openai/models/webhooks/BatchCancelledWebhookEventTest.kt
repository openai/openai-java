// File generated from our OpenAPI spec by Stainless.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BatchCancelledWebhookEventTest {

    @Test
    fun create() {
        val batchCancelledWebhookEvent =
            BatchCancelledWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(BatchCancelledWebhookEvent.Data.builder().id("id").build())
                .object_(BatchCancelledWebhookEvent.Object.EVENT)
                .build()

        assertThat(batchCancelledWebhookEvent.id()).isEqualTo("id")
        assertThat(batchCancelledWebhookEvent.createdAt()).isEqualTo(0L)
        assertThat(batchCancelledWebhookEvent.data())
            .isEqualTo(BatchCancelledWebhookEvent.Data.builder().id("id").build())
        assertThat(batchCancelledWebhookEvent.object_())
            .contains(BatchCancelledWebhookEvent.Object.EVENT)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val batchCancelledWebhookEvent =
            BatchCancelledWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(BatchCancelledWebhookEvent.Data.builder().id("id").build())
                .object_(BatchCancelledWebhookEvent.Object.EVENT)
                .build()

        val roundtrippedBatchCancelledWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(batchCancelledWebhookEvent),
                jacksonTypeRef<BatchCancelledWebhookEvent>(),
            )

        assertThat(roundtrippedBatchCancelledWebhookEvent).isEqualTo(batchCancelledWebhookEvent)
    }
}
