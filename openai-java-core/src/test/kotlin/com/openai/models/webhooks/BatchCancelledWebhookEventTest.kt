// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BatchCancelledWebhookEventTest {

    @Test
    fun createAndRoundtrip() {
        val batchCancelledWebhookEvent =
            BatchCancelledWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(BatchCancelledWebhookEvent.Data.builder().id("id").build())
                .object_(BatchCancelledWebhookEvent.Object.EVENT)
                .build()

        assertThat(batchCancelledWebhookEvent.id()).contains("id")
        assertThat(batchCancelledWebhookEvent.createdAt()).contains(0L)
        assertThat(batchCancelledWebhookEvent.data())
            .contains(BatchCancelledWebhookEvent.Data.builder().id("id").build())
        assertThat(batchCancelledWebhookEvent.object_()).contains(JsonValue.from("event"))

        val jsonMapper = jsonMapper()

        val roundtrippedBatchCancelledWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(batchCancelledWebhookEvent),
                jacksonTypeRef<BatchCancelledWebhookEvent>(),
            )

        assertThat(roundtrippedBatchCancelledWebhookEvent).isEqualTo(batchCancelledWebhookEvent)
    }
}
