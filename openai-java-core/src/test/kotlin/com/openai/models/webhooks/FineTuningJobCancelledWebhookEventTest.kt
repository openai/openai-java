// File generated from our OpenAPI spec by Stainless.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FineTuningJobCancelledWebhookEventTest {

    @Test
    fun create() {
        val fineTuningJobCancelledWebhookEvent =
            FineTuningJobCancelledWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(FineTuningJobCancelledWebhookEvent.Data.builder().id("id").build())
                .object_(FineTuningJobCancelledWebhookEvent.Object.EVENT)
                .build()

        assertThat(fineTuningJobCancelledWebhookEvent.id()).isEqualTo("id")
        assertThat(fineTuningJobCancelledWebhookEvent.createdAt()).isEqualTo(0L)
        assertThat(fineTuningJobCancelledWebhookEvent.data())
            .isEqualTo(FineTuningJobCancelledWebhookEvent.Data.builder().id("id").build())
        assertThat(fineTuningJobCancelledWebhookEvent.object_())
            .contains(FineTuningJobCancelledWebhookEvent.Object.EVENT)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fineTuningJobCancelledWebhookEvent =
            FineTuningJobCancelledWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(FineTuningJobCancelledWebhookEvent.Data.builder().id("id").build())
                .object_(FineTuningJobCancelledWebhookEvent.Object.EVENT)
                .build()

        val roundtrippedFineTuningJobCancelledWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fineTuningJobCancelledWebhookEvent),
                jacksonTypeRef<FineTuningJobCancelledWebhookEvent>(),
            )

        assertThat(roundtrippedFineTuningJobCancelledWebhookEvent)
            .isEqualTo(fineTuningJobCancelledWebhookEvent)
    }
}
