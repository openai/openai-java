// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeErrorEventTest {

    @Test
    fun create() {
        val realtimeErrorEvent =
            RealtimeErrorEvent.builder()
                .error(
                    RealtimeError.builder()
                        .message("message")
                        .type("type")
                        .code("code")
                        .eventId("event_id")
                        .param("param")
                        .build()
                )
                .eventId("event_id")
                .build()

        assertThat(realtimeErrorEvent.error())
            .isEqualTo(
                RealtimeError.builder()
                    .message("message")
                    .type("type")
                    .code("code")
                    .eventId("event_id")
                    .param("param")
                    .build()
            )
        assertThat(realtimeErrorEvent.eventId()).isEqualTo("event_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeErrorEvent =
            RealtimeErrorEvent.builder()
                .error(
                    RealtimeError.builder()
                        .message("message")
                        .type("type")
                        .code("code")
                        .eventId("event_id")
                        .param("param")
                        .build()
                )
                .eventId("event_id")
                .build()

        val roundtrippedRealtimeErrorEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeErrorEvent),
                jacksonTypeRef<RealtimeErrorEvent>(),
            )

        assertThat(roundtrippedRealtimeErrorEvent).isEqualTo(realtimeErrorEvent)
    }
}
