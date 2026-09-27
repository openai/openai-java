// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SafetyDeactivationIssuedWebhookEventTest {

    @Test
    fun create() {
        val safetyDeactivationIssuedWebhookEvent =
            SafetyDeactivationIssuedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(SafetyDeactivationIssuedWebhookEvent.Data.builder().id("id").build())
                .build()

        assertThat(safetyDeactivationIssuedWebhookEvent.id()).isEqualTo("id")
        assertThat(safetyDeactivationIssuedWebhookEvent.createdAt()).isEqualTo(0L)
        assertThat(safetyDeactivationIssuedWebhookEvent.data())
            .isEqualTo(SafetyDeactivationIssuedWebhookEvent.Data.builder().id("id").build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val safetyDeactivationIssuedWebhookEvent =
            SafetyDeactivationIssuedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(SafetyDeactivationIssuedWebhookEvent.Data.builder().id("id").build())
                .build()

        val roundtrippedSafetyDeactivationIssuedWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(safetyDeactivationIssuedWebhookEvent),
                jacksonTypeRef<SafetyDeactivationIssuedWebhookEvent>(),
            )

        assertThat(roundtrippedSafetyDeactivationIssuedWebhookEvent)
            .isEqualTo(safetyDeactivationIssuedWebhookEvent)
    }
}
