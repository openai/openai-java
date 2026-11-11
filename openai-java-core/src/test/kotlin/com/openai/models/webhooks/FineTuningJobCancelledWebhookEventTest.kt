// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FineTuningJobCancelledWebhookEventTest {

    @Test
    fun createAndRoundtrip() {
        val fineTuningJobCancelledWebhookEvent =
            FineTuningJobCancelledWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(FineTuningJobCancelledWebhookEvent.Data.builder().id("id").build())
                .object_(FineTuningJobCancelledWebhookEvent.Object.EVENT)
                .build()

        assertThat(fineTuningJobCancelledWebhookEvent.id()).contains("id")
        assertThat(fineTuningJobCancelledWebhookEvent.createdAt()).contains(0L)
        assertThat(fineTuningJobCancelledWebhookEvent.data())
            .contains(FineTuningJobCancelledWebhookEvent.Data.builder().id("id").build())
        assertThat(fineTuningJobCancelledWebhookEvent.object_()).contains(JsonValue.from("event"))

        val jsonMapper = jsonMapper()

        val roundtrippedFineTuningJobCancelledWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fineTuningJobCancelledWebhookEvent),
                jacksonTypeRef<FineTuningJobCancelledWebhookEvent>(),
            )

        assertThat(roundtrippedFineTuningJobCancelledWebhookEvent)
            .isEqualTo(fineTuningJobCancelledWebhookEvent)
    }
}
