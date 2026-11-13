// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LiveTransportConnectedWebhookEventTest {

    @Test
    fun createAndRoundtrip() {
        val liveTransportConnectedWebhookEvent =
            LiveTransportConnectedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(
                    LiveTransportConnectedWebhookEvent.Data.builder()
                        .sessionId("session_id")
                        .type(LiveTransportConnectedWebhookEvent.Data.Type.WEBRTC)
                        .build()
                )
                .build()

        assertThat(liveTransportConnectedWebhookEvent.id()).isEqualTo("id")
        assertThat(liveTransportConnectedWebhookEvent.createdAt()).isEqualTo(0L)
        assertThat(liveTransportConnectedWebhookEvent.data())
            .isEqualTo(
                LiveTransportConnectedWebhookEvent.Data.builder()
                    .sessionId("session_id")
                    .type(LiveTransportConnectedWebhookEvent.Data.Type.WEBRTC)
                    .build()
            )

        val jsonMapper = jsonMapper()

        val roundtrippedLiveTransportConnectedWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(liveTransportConnectedWebhookEvent),
                jacksonTypeRef<LiveTransportConnectedWebhookEvent>(),
            )

        assertThat(roundtrippedLiveTransportConnectedWebhookEvent)
            .isEqualTo(liveTransportConnectedWebhookEvent)
    }
}
