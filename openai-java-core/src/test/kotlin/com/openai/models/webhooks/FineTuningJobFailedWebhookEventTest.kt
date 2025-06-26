// File generated from our OpenAPI spec by Stainless.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FineTuningJobFailedWebhookEventTest {

    @Test
    fun create() {
        val fineTuningJobFailedWebhookEvent =
            FineTuningJobFailedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(FineTuningJobFailedWebhookEvent.Data.builder().id("id").build())
                .object_(FineTuningJobFailedWebhookEvent.Object.EVENT)
                .build()

        assertThat(fineTuningJobFailedWebhookEvent.id()).isEqualTo("id")
        assertThat(fineTuningJobFailedWebhookEvent.createdAt()).isEqualTo(0L)
        assertThat(fineTuningJobFailedWebhookEvent.data())
            .isEqualTo(FineTuningJobFailedWebhookEvent.Data.builder().id("id").build())
        assertThat(fineTuningJobFailedWebhookEvent.object_())
            .contains(FineTuningJobFailedWebhookEvent.Object.EVENT)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fineTuningJobFailedWebhookEvent =
            FineTuningJobFailedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(FineTuningJobFailedWebhookEvent.Data.builder().id("id").build())
                .object_(FineTuningJobFailedWebhookEvent.Object.EVENT)
                .build()

        val roundtrippedFineTuningJobFailedWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fineTuningJobFailedWebhookEvent),
                jacksonTypeRef<FineTuningJobFailedWebhookEvent>(),
            )

        assertThat(roundtrippedFineTuningJobFailedWebhookEvent)
            .isEqualTo(fineTuningJobFailedWebhookEvent)
    }
}
