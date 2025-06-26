// File generated from our OpenAPI spec by Stainless.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BatchExpiredWebhookEventTest {

    @Test
    fun create() {
        val batchExpiredWebhookEvent =
            BatchExpiredWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(BatchExpiredWebhookEvent.Data.builder().id("id").build())
                .object_(BatchExpiredWebhookEvent.Object.EVENT)
                .build()

        assertThat(batchExpiredWebhookEvent.id()).isEqualTo("id")
        assertThat(batchExpiredWebhookEvent.createdAt()).isEqualTo(0L)
        assertThat(batchExpiredWebhookEvent.data())
            .isEqualTo(BatchExpiredWebhookEvent.Data.builder().id("id").build())
        assertThat(batchExpiredWebhookEvent.object_())
            .contains(BatchExpiredWebhookEvent.Object.EVENT)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val batchExpiredWebhookEvent =
            BatchExpiredWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(BatchExpiredWebhookEvent.Data.builder().id("id").build())
                .object_(BatchExpiredWebhookEvent.Object.EVENT)
                .build()

        val roundtrippedBatchExpiredWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(batchExpiredWebhookEvent),
                jacksonTypeRef<BatchExpiredWebhookEvent>(),
            )

        assertThat(roundtrippedBatchExpiredWebhookEvent).isEqualTo(batchExpiredWebhookEvent)
    }
}
