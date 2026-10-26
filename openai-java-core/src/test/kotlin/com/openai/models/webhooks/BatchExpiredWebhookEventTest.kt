// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BatchExpiredWebhookEventTest {

    @Test
    fun createAndRoundtrip() {
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

        val jsonMapper = jsonMapper()

        val roundtrippedBatchExpiredWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(batchExpiredWebhookEvent),
                jacksonTypeRef<BatchExpiredWebhookEvent>(),
            )

        assertThat(roundtrippedBatchExpiredWebhookEvent).isEqualTo(batchExpiredWebhookEvent)
    }
}
