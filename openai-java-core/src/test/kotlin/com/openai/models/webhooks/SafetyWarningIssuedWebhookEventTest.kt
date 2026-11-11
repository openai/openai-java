// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SafetyWarningIssuedWebhookEventTest {

    @Test
    fun createAndRoundtrip() {
        val safetyWarningIssuedWebhookEvent =
            SafetyWarningIssuedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(SafetyWarningIssuedWebhookEvent.Data.builder().id("id").build())
                .build()

        assertThat(safetyWarningIssuedWebhookEvent.id()).contains("id")
        assertThat(safetyWarningIssuedWebhookEvent.createdAt()).contains(0L)
        assertThat(safetyWarningIssuedWebhookEvent.data())
            .contains(SafetyWarningIssuedWebhookEvent.Data.builder().id("id").build())

        val jsonMapper = jsonMapper()

        val roundtrippedSafetyWarningIssuedWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(safetyWarningIssuedWebhookEvent),
                jacksonTypeRef<SafetyWarningIssuedWebhookEvent>(),
            )

        assertThat(roundtrippedSafetyWarningIssuedWebhookEvent)
            .isEqualTo(safetyWarningIssuedWebhookEvent)
    }
}
