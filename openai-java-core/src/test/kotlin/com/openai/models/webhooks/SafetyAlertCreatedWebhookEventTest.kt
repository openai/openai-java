// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SafetyAlertCreatedWebhookEventTest {

    @Test
    fun create() {
        val safetyAlertCreatedWebhookEvent =
            SafetyAlertCreatedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(
                    SafetyAlertCreatedWebhookEvent.Data.builder()
                        .id("alert_ecc2efdd09bd231a9ad9bd2aada37aa7")
                        .build()
                )
                .build()

        assertThat(safetyAlertCreatedWebhookEvent.id()).isEqualTo("id")
        assertThat(safetyAlertCreatedWebhookEvent.createdAt()).isEqualTo(0L)
        assertThat(safetyAlertCreatedWebhookEvent.data())
            .isEqualTo(
                SafetyAlertCreatedWebhookEvent.Data.builder()
                    .id("alert_ecc2efdd09bd231a9ad9bd2aada37aa7")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val safetyAlertCreatedWebhookEvent =
            SafetyAlertCreatedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(
                    SafetyAlertCreatedWebhookEvent.Data.builder()
                        .id("alert_ecc2efdd09bd231a9ad9bd2aada37aa7")
                        .build()
                )
                .build()

        val roundtrippedSafetyAlertCreatedWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(safetyAlertCreatedWebhookEvent),
                jacksonTypeRef<SafetyAlertCreatedWebhookEvent>(),
            )

        assertThat(roundtrippedSafetyAlertCreatedWebhookEvent)
            .isEqualTo(safetyAlertCreatedWebhookEvent)
    }
}
