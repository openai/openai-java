// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ThinkingAppendEventTest {

    @Test
    fun create() {
        val thinkingAppendEvent =
            ThinkingAppendEvent.builder()
                .content("Checking availability for two guests at 7 PM.")
                .delegationId("del_abc123")
                .eventId("evt_thinking_001")
                .build()

        assertThat(thinkingAppendEvent.content())
            .isEqualTo("Checking availability for two guests at 7 PM.")
        assertThat(thinkingAppendEvent.delegationId()).contains("del_abc123")
        assertThat(thinkingAppendEvent.eventId()).contains("evt_thinking_001")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val thinkingAppendEvent =
            ThinkingAppendEvent.builder()
                .content("Checking availability for two guests at 7 PM.")
                .delegationId("del_abc123")
                .eventId("evt_thinking_001")
                .build()

        val roundtrippedThinkingAppendEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(thinkingAppendEvent),
                jacksonTypeRef<ThinkingAppendEvent>(),
            )

        assertThat(roundtrippedThinkingAppendEvent).isEqualTo(thinkingAppendEvent)
    }
}
