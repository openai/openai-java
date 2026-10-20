// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SafetyOrgAlertCreatedWebhookEventTest {

    @Test
    fun create() {
        val safetyOrgAlertCreatedWebhookEvent =
            SafetyOrgAlertCreatedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(
                    SafetyOrgAlertCreatedWebhookEvent.Data.builder()
                        .id("alert_ecc2efdd09bd231a9ad9bd2aada37aa7")
                        .build()
                )
                .build()

        assertThat(safetyOrgAlertCreatedWebhookEvent.id()).isEqualTo("id")
        assertThat(safetyOrgAlertCreatedWebhookEvent.createdAt()).isEqualTo(0L)
        assertThat(safetyOrgAlertCreatedWebhookEvent.data())
            .isEqualTo(
                SafetyOrgAlertCreatedWebhookEvent.Data.builder()
                    .id("alert_ecc2efdd09bd231a9ad9bd2aada37aa7")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val safetyOrgAlertCreatedWebhookEvent =
            SafetyOrgAlertCreatedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(
                    SafetyOrgAlertCreatedWebhookEvent.Data.builder()
                        .id("alert_ecc2efdd09bd231a9ad9bd2aada37aa7")
                        .build()
                )
                .build()

        val roundtrippedSafetyOrgAlertCreatedWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(safetyOrgAlertCreatedWebhookEvent),
                jacksonTypeRef<SafetyOrgAlertCreatedWebhookEvent>(),
            )

        assertThat(roundtrippedSafetyOrgAlertCreatedWebhookEvent)
            .isEqualTo(safetyOrgAlertCreatedWebhookEvent)
    }
}
