// File generated from our OpenAPI spec by Stainless.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeCallIncomingWebhookEventTest {

    @Test
    fun create() {
        val realtimeCallIncomingWebhookEvent =
            RealtimeCallIncomingWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(
                    RealtimeCallIncomingWebhookEvent.Data.builder()
                        .callId("call_id")
                        .addSipHeader(
                            RealtimeCallIncomingWebhookEvent.Data.SipHeader.builder()
                                .name("name")
                                .value("value")
                                .build()
                        )
                        .build()
                )
                .object_(RealtimeCallIncomingWebhookEvent.Object.EVENT)
                .build()

        assertThat(realtimeCallIncomingWebhookEvent.id()).isEqualTo("id")
        assertThat(realtimeCallIncomingWebhookEvent.createdAt()).isEqualTo(0L)
        assertThat(realtimeCallIncomingWebhookEvent.data())
            .isEqualTo(
                RealtimeCallIncomingWebhookEvent.Data.builder()
                    .callId("call_id")
                    .addSipHeader(
                        RealtimeCallIncomingWebhookEvent.Data.SipHeader.builder()
                            .name("name")
                            .value("value")
                            .build()
                    )
                    .build()
            )
        assertThat(realtimeCallIncomingWebhookEvent.object_())
            .contains(RealtimeCallIncomingWebhookEvent.Object.EVENT)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeCallIncomingWebhookEvent =
            RealtimeCallIncomingWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(
                    RealtimeCallIncomingWebhookEvent.Data.builder()
                        .callId("call_id")
                        .addSipHeader(
                            RealtimeCallIncomingWebhookEvent.Data.SipHeader.builder()
                                .name("name")
                                .value("value")
                                .build()
                        )
                        .build()
                )
                .object_(RealtimeCallIncomingWebhookEvent.Object.EVENT)
                .build()

        val roundtrippedRealtimeCallIncomingWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeCallIncomingWebhookEvent),
                jacksonTypeRef<RealtimeCallIncomingWebhookEvent>(),
            )

        assertThat(roundtrippedRealtimeCallIncomingWebhookEvent)
            .isEqualTo(realtimeCallIncomingWebhookEvent)
    }
}
