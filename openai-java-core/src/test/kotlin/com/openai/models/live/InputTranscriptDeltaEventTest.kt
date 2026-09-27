// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InputTranscriptDeltaEventTest {

    @Test
    fun create() {
        val inputTranscriptDeltaEvent =
            InputTranscriptDeltaEvent.builder()
                .delta("A table for two at seven, please.")
                .endMs(3400L)
                .eventId("evt_input_transcript_001")
                .startMs(1600L)
                .clientEventId("client_event_id")
                .build()

        assertThat(inputTranscriptDeltaEvent.delta()).isEqualTo("A table for two at seven, please.")
        assertThat(inputTranscriptDeltaEvent.endMs()).isEqualTo(3400L)
        assertThat(inputTranscriptDeltaEvent.eventId()).isEqualTo("evt_input_transcript_001")
        assertThat(inputTranscriptDeltaEvent.startMs()).isEqualTo(1600L)
        assertThat(inputTranscriptDeltaEvent.clientEventId()).contains("client_event_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inputTranscriptDeltaEvent =
            InputTranscriptDeltaEvent.builder()
                .delta("A table for two at seven, please.")
                .endMs(3400L)
                .eventId("evt_input_transcript_001")
                .startMs(1600L)
                .clientEventId("client_event_id")
                .build()

        val roundtrippedInputTranscriptDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inputTranscriptDeltaEvent),
                jacksonTypeRef<InputTranscriptDeltaEvent>(),
            )

        assertThat(roundtrippedInputTranscriptDeltaEvent).isEqualTo(inputTranscriptDeltaEvent)
    }
}
