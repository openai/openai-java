// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InstructionsAppendedEventTest {

    @Test
    fun create() {
        val instructionsAppendedEvent =
            InstructionsAppendedEvent.builder()
                .endMs(1400L)
                .eventId("evt_instructions_002")
                .startMs(1200L)
                .clientEventId("evt_instructions_001")
                .build()

        assertThat(instructionsAppendedEvent.endMs()).isEqualTo(1400L)
        assertThat(instructionsAppendedEvent.eventId()).isEqualTo("evt_instructions_002")
        assertThat(instructionsAppendedEvent.startMs()).isEqualTo(1200L)
        assertThat(instructionsAppendedEvent.clientEventId()).contains("evt_instructions_001")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val instructionsAppendedEvent =
            InstructionsAppendedEvent.builder()
                .endMs(1400L)
                .eventId("evt_instructions_002")
                .startMs(1200L)
                .clientEventId("evt_instructions_001")
                .build()

        val roundtrippedInstructionsAppendedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(instructionsAppendedEvent),
                jacksonTypeRef<InstructionsAppendedEvent>(),
            )

        assertThat(roundtrippedInstructionsAppendedEvent).isEqualTo(instructionsAppendedEvent)
    }
}
