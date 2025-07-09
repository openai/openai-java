// File generated from our OpenAPI spec by Stainless.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FineTuningJobSucceededWebhookEventTest {

    @Test
    fun create() {
        val fineTuningJobSucceededWebhookEvent =
            FineTuningJobSucceededWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(FineTuningJobSucceededWebhookEvent.Data.builder().id("id").build())
                .object_(FineTuningJobSucceededWebhookEvent.Object.EVENT)
                .build()

        assertThat(fineTuningJobSucceededWebhookEvent.id()).isEqualTo("id")
        assertThat(fineTuningJobSucceededWebhookEvent.createdAt()).isEqualTo(0L)
        assertThat(fineTuningJobSucceededWebhookEvent.data())
            .isEqualTo(FineTuningJobSucceededWebhookEvent.Data.builder().id("id").build())
        assertThat(fineTuningJobSucceededWebhookEvent.object_())
            .contains(FineTuningJobSucceededWebhookEvent.Object.EVENT)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fineTuningJobSucceededWebhookEvent =
            FineTuningJobSucceededWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(FineTuningJobSucceededWebhookEvent.Data.builder().id("id").build())
                .object_(FineTuningJobSucceededWebhookEvent.Object.EVENT)
                .build()

        val roundtrippedFineTuningJobSucceededWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fineTuningJobSucceededWebhookEvent),
                jacksonTypeRef<FineTuningJobSucceededWebhookEvent>(),
            )

        assertThat(roundtrippedFineTuningJobSucceededWebhookEvent)
            .isEqualTo(fineTuningJobSucceededWebhookEvent)
    }
}
