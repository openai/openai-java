// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LiveCallIncomingWebhookEventTest {

    @Test
    fun create() {
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
                        .build()
                )
                .object_(LiveCallIncomingWebhookEvent.Object.EVENT)
                .build()

        assertThat(liveCallIncomingWebhookEvent.id()).isEqualTo("id")
        assertThat(liveCallIncomingWebhookEvent.createdAt()).isEqualTo(0L)
        assertThat(liveCallIncomingWebhookEvent.data())
            .isEqualTo(
                LiveCallIncomingWebhookEvent.Data.builder()
                    .sessionId("session_id")
                    .addSipHeader(
                        LiveCallIncomingWebhookEvent.Data.SipHeader.builder()
                            .name("name")
                            .value("value")
                            .build()
                    )
                    .build()
            )
        assertThat(liveCallIncomingWebhookEvent.object_())
            .contains(LiveCallIncomingWebhookEvent.Object.EVENT)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
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
                        .build()
                )
                .object_(LiveCallIncomingWebhookEvent.Object.EVENT)
                .build()

        val roundtrippedLiveCallIncomingWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(liveCallIncomingWebhookEvent),
                jacksonTypeRef<LiveCallIncomingWebhookEvent>(),
            )

        assertThat(roundtrippedLiveCallIncomingWebhookEvent).isEqualTo(liveCallIncomingWebhookEvent)
    }
}
