// File generated from our OpenAPI spec by Stainless.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SafetyIdentifierBlockedWebhookEventTest {

    @Test
    fun create() {
        val safetyIdentifierBlockedWebhookEvent =
            SafetyIdentifierBlockedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(
                    SafetyIdentifierBlockedWebhookEvent.Data.builder()
                        .safetyCategory("safety_category")
                        .safetyIdentifier("safety_identifier")
                        .model("model")
                        .projectId("project_id")
                        .requestId("request_id")
                        .build()
                )
                .object_(SafetyIdentifierBlockedWebhookEvent.Object.EVENT)
                .build()

        assertThat(safetyIdentifierBlockedWebhookEvent.id()).isEqualTo("id")
        assertThat(safetyIdentifierBlockedWebhookEvent.createdAt()).isEqualTo(0L)
        assertThat(safetyIdentifierBlockedWebhookEvent.data())
            .isEqualTo(
                SafetyIdentifierBlockedWebhookEvent.Data.builder()
                    .safetyCategory("safety_category")
                    .safetyIdentifier("safety_identifier")
                    .model("model")
                    .projectId("project_id")
                    .requestId("request_id")
                    .build()
            )
        assertThat(safetyIdentifierBlockedWebhookEvent.object_())
            .contains(SafetyIdentifierBlockedWebhookEvent.Object.EVENT)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val safetyIdentifierBlockedWebhookEvent =
            SafetyIdentifierBlockedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(
                    SafetyIdentifierBlockedWebhookEvent.Data.builder()
                        .safetyCategory("safety_category")
                        .safetyIdentifier("safety_identifier")
                        .model("model")
                        .projectId("project_id")
                        .requestId("request_id")
                        .build()
                )
                .object_(SafetyIdentifierBlockedWebhookEvent.Object.EVENT)
                .build()

        val roundtrippedSafetyIdentifierBlockedWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(safetyIdentifierBlockedWebhookEvent),
                jacksonTypeRef<SafetyIdentifierBlockedWebhookEvent>(),
            )

        assertThat(roundtrippedSafetyIdentifierBlockedWebhookEvent)
            .isEqualTo(safetyIdentifierBlockedWebhookEvent)
    }
}
