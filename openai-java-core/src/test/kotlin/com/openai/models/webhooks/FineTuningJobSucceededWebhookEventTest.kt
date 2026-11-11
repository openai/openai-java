// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FineTuningJobSucceededWebhookEventTest {

    @Test
    fun createAndRoundtrip() {
        val fineTuningJobSucceededWebhookEvent =
            FineTuningJobSucceededWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(FineTuningJobSucceededWebhookEvent.Data.builder().id("id").build())
                .object_(FineTuningJobSucceededWebhookEvent.Object.EVENT)
                .build()

        assertThat(fineTuningJobSucceededWebhookEvent.id()).contains("id")
        assertThat(fineTuningJobSucceededWebhookEvent.createdAt()).contains(0L)
        assertThat(fineTuningJobSucceededWebhookEvent.data())
            .contains(FineTuningJobSucceededWebhookEvent.Data.builder().id("id").build())
        assertThat(fineTuningJobSucceededWebhookEvent.object_()).contains(JsonValue.from("event"))

        val jsonMapper = jsonMapper()

        val roundtrippedFineTuningJobSucceededWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fineTuningJobSucceededWebhookEvent),
                jacksonTypeRef<FineTuningJobSucceededWebhookEvent>(),
            )

        assertThat(roundtrippedFineTuningJobSucceededWebhookEvent)
            .isEqualTo(fineTuningJobSucceededWebhookEvent)
    }
}
