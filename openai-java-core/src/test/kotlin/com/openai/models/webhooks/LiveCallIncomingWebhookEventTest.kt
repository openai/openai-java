// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LiveCallIncomingWebhookEventTest {

    @Test
    fun createAndRoundtrip() {
        val liveCallIncomingWebhookEvent =
            LiveCallIncomingWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(
                    LiveCallIncomingWebhookEvent.Data.builder()
                        .sessionId("session_id")
                        .addSipHeader(
                            LiveCallIncomingWebhookEvent.Data.SipHeader.builder()
                                .name("name")
                                .value("value")
                                .build()
                        )
                        .sipMediaSecurity(LiveCallIncomingWebhookEvent.Data.SipMediaSecurity.RTP)
                        .build()
                )
                .object_(LiveCallIncomingWebhookEvent.Object.EVENT)
                .build()

        assertThat(liveCallIncomingWebhookEvent.id()).contains("id")
        assertThat(liveCallIncomingWebhookEvent.createdAt()).contains(0L)
        assertThat(liveCallIncomingWebhookEvent.data())
            .contains(
                LiveCallIncomingWebhookEvent.Data.builder()
                    .sessionId("session_id")
                    .addSipHeader(
                        LiveCallIncomingWebhookEvent.Data.SipHeader.builder()
                            .name("name")
                            .value("value")
                            .build()
                    )
                    .sipMediaSecurity(LiveCallIncomingWebhookEvent.Data.SipMediaSecurity.RTP)
                    .build()
            )
        assertThat(liveCallIncomingWebhookEvent.object_()).contains(JsonValue.from("event"))

        val jsonMapper = jsonMapper()

        val roundtrippedLiveCallIncomingWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(liveCallIncomingWebhookEvent),
                jacksonTypeRef<LiveCallIncomingWebhookEvent>(),
            )

        assertThat(roundtrippedLiveCallIncomingWebhookEvent).isEqualTo(liveCallIncomingWebhookEvent)
    }
}
