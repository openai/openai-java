// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LiveTransportIncomingWebhookEventTest {

    @Test
    fun createAndRoundtrip() {
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
                        .sipMediaSecurity(
                            LiveTransportIncomingWebhookEvent.Data.SipMediaSecurity.RTP
                        )
                        .build()
                )
                .object_(LiveTransportIncomingWebhookEvent.Object.EVENT)
                .build()

        assertThat(liveTransportIncomingWebhookEvent.id()).contains("id")
        assertThat(liveTransportIncomingWebhookEvent.createdAt()).contains(0L)
        assertThat(liveTransportIncomingWebhookEvent.data())
            .contains(
                LiveTransportIncomingWebhookEvent.Data.builder()
                    .sessionId("session_id")
                    .addSipHeader(
                        LiveTransportIncomingWebhookEvent.Data.SipHeader.builder()
                            .name("name")
                            .value("value")
                            .build()
                    )
                    .sipMediaSecurity(LiveTransportIncomingWebhookEvent.Data.SipMediaSecurity.RTP)
                    .build()
            )
        assertThat(liveTransportIncomingWebhookEvent.object_()).contains(JsonValue.from("event"))

        val jsonMapper = jsonMapper()

        val roundtrippedLiveTransportIncomingWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(liveTransportIncomingWebhookEvent),
                jacksonTypeRef<LiveTransportIncomingWebhookEvent>(),
            )

        assertThat(roundtrippedLiveTransportIncomingWebhookEvent)
            .isEqualTo(liveTransportIncomingWebhookEvent)
    }
}
