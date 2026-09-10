// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LiveTransportIncomingWebhookEventTest {

    @Test
    fun create() {
        val liveTransportIncomingWebhookEvent =
            LiveTransportIncomingWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(
                    LiveTransportIncomingWebhookEvent.Data.builder()
                        .sessionId("session_id")
                        .addSipHeader(
                            LiveTransportIncomingWebhookEvent.Data.SipHeader.builder()
                                .name("name")
                                .value("value")
                                .build()
                        )
                        .build()
                )
                .object_(LiveTransportIncomingWebhookEvent.Object.EVENT)
                .build()

        assertThat(liveTransportIncomingWebhookEvent.id()).isEqualTo("id")
        assertThat(liveTransportIncomingWebhookEvent.createdAt()).isEqualTo(0L)
        assertThat(liveTransportIncomingWebhookEvent.data())
            .isEqualTo(
                LiveTransportIncomingWebhookEvent.Data.builder()
                    .sessionId("session_id")
                    .addSipHeader(
                        LiveTransportIncomingWebhookEvent.Data.SipHeader.builder()
                            .name("name")
                            .value("value")
                            .build()
                    )
                    .build()
            )
        assertThat(liveTransportIncomingWebhookEvent.object_())
            .contains(LiveTransportIncomingWebhookEvent.Object.EVENT)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val liveTransportIncomingWebhookEvent =
            LiveTransportIncomingWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(
                    LiveTransportIncomingWebhookEvent.Data.builder()
                        .sessionId("session_id")
                        .addSipHeader(
                            LiveTransportIncomingWebhookEvent.Data.SipHeader.builder()
                                .name("name")
                                .value("value")
                                .build()
                        )
                        .build()
                )
                .object_(LiveTransportIncomingWebhookEvent.Object.EVENT)
                .build()

        val roundtrippedLiveTransportIncomingWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(liveTransportIncomingWebhookEvent),
                jacksonTypeRef<LiveTransportIncomingWebhookEvent>(),
            )

        assertThat(roundtrippedLiveTransportIncomingWebhookEvent)
            .isEqualTo(liveTransportIncomingWebhookEvent)
    }
}
