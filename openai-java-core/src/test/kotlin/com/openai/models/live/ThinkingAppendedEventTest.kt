// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ThinkingAppendedEventTest {

    @Test
    fun create() {
        val thinkingAppendedEvent =
            ThinkingAppendedEvent.builder()
                .endMs(4800L)
                .eventId("evt_thinking_002")
                .startMs(4600L)
                .clientEventId("evt_thinking_001")
                .build()

        assertThat(thinkingAppendedEvent.endMs()).isEqualTo(4800L)
        assertThat(thinkingAppendedEvent.eventId()).isEqualTo("evt_thinking_002")
        assertThat(thinkingAppendedEvent.startMs()).isEqualTo(4600L)
        assertThat(thinkingAppendedEvent.clientEventId()).contains("evt_thinking_001")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val thinkingAppendedEvent =
            ThinkingAppendedEvent.builder()
                .endMs(4800L)
                .eventId("evt_thinking_002")
                .startMs(4600L)
                .clientEventId("evt_thinking_001")
                .build()

        val roundtrippedThinkingAppendedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(thinkingAppendedEvent),
                jacksonTypeRef<ThinkingAppendedEvent>(),
            )

        assertThat(roundtrippedThinkingAppendedEvent).isEqualTo(thinkingAppendedEvent)
    }
}
