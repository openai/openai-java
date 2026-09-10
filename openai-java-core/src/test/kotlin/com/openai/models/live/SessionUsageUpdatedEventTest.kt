// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SessionUsageUpdatedEventTest {

    @Test
    fun create() {
        val sessionUsageUpdatedEvent =
            SessionUsageUpdatedEvent.builder()
                .eventId("evt_usage_001")
                .usage(SessionUsage.builder().seconds(32.5).build())
                .clientEventId("client_event_id")
                .contextWindow(
                    SessionUsageUpdatedEvent.ContextWindow.builder().usageRatio(0.12).build()
                )
                .build()

        assertThat(sessionUsageUpdatedEvent.eventId()).isEqualTo("evt_usage_001")
        assertThat(sessionUsageUpdatedEvent.usage())
            .isEqualTo(SessionUsage.builder().seconds(32.5).build())
        assertThat(sessionUsageUpdatedEvent.clientEventId()).contains("client_event_id")
        assertThat(sessionUsageUpdatedEvent.contextWindow())
            .contains(SessionUsageUpdatedEvent.ContextWindow.builder().usageRatio(0.12).build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val sessionUsageUpdatedEvent =
            SessionUsageUpdatedEvent.builder()
                .eventId("evt_usage_001")
                .usage(SessionUsage.builder().seconds(32.5).build())
                .clientEventId("client_event_id")
                .contextWindow(
                    SessionUsageUpdatedEvent.ContextWindow.builder().usageRatio(0.12).build()
                )
                .build()

        val roundtrippedSessionUsageUpdatedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sessionUsageUpdatedEvent),
                jacksonTypeRef<SessionUsageUpdatedEvent>(),
            )

        assertThat(roundtrippedSessionUsageUpdatedEvent).isEqualTo(sessionUsageUpdatedEvent)
    }
}
