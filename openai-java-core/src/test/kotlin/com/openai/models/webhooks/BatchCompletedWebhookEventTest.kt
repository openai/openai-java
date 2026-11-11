// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BatchCompletedWebhookEventTest {

    @Test
    fun createAndRoundtrip() {
        val batchCompletedWebhookEvent =
            BatchCompletedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(BatchCompletedWebhookEvent.Data.builder().id("id").build())
                .object_(BatchCompletedWebhookEvent.Object.EVENT)
                .build()

        assertThat(batchCompletedWebhookEvent.id()).contains("id")
        assertThat(batchCompletedWebhookEvent.createdAt()).contains(0L)
        assertThat(batchCompletedWebhookEvent.data())
            .contains(BatchCompletedWebhookEvent.Data.builder().id("id").build())
        assertThat(batchCompletedWebhookEvent.object_()).contains(JsonValue.from("event"))

        val jsonMapper = jsonMapper()

        val roundtrippedBatchCompletedWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(batchCompletedWebhookEvent),
                jacksonTypeRef<BatchCompletedWebhookEvent>(),
            )

        assertThat(roundtrippedBatchCompletedWebhookEvent).isEqualTo(batchCompletedWebhookEvent)
    }
}
