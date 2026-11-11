// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SafetyDeactivationIssuedWebhookEventTest {

    @Test
    fun createAndRoundtrip() {
        val safetyDeactivationIssuedWebhookEvent =
            SafetyDeactivationIssuedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(SafetyDeactivationIssuedWebhookEvent.Data.builder().id("id").build())
                .build()

        assertThat(safetyDeactivationIssuedWebhookEvent.id()).contains("id")
        assertThat(safetyDeactivationIssuedWebhookEvent.createdAt()).contains(0L)
        assertThat(safetyDeactivationIssuedWebhookEvent.data())
            .contains(SafetyDeactivationIssuedWebhookEvent.Data.builder().id("id").build())

        val jsonMapper = jsonMapper()

        val roundtrippedSafetyDeactivationIssuedWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(safetyDeactivationIssuedWebhookEvent),
                jacksonTypeRef<SafetyDeactivationIssuedWebhookEvent>(),
            )

        assertThat(roundtrippedSafetyDeactivationIssuedWebhookEvent)
            .isEqualTo(safetyDeactivationIssuedWebhookEvent)
    }
}
