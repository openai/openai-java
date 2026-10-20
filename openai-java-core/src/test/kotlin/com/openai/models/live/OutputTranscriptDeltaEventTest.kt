// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OutputTranscriptDeltaEventTest {

    @Test
    fun create() {
        val outputTranscriptDeltaEvent =
            OutputTranscriptDeltaEvent.builder()
                .delta("Would you like me to reserve that table?")
                .endMs(7200L)
                .eventId("evt_output_transcript_001")
                .startMs(5400L)
                .clientEventId("client_event_id")
                .build()

        assertThat(outputTranscriptDeltaEvent.delta())
            .isEqualTo("Would you like me to reserve that table?")
        assertThat(outputTranscriptDeltaEvent.endMs()).isEqualTo(7200L)
        assertThat(outputTranscriptDeltaEvent.eventId()).isEqualTo("evt_output_transcript_001")
        assertThat(outputTranscriptDeltaEvent.startMs()).isEqualTo(5400L)
        assertThat(outputTranscriptDeltaEvent.clientEventId()).contains("client_event_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val outputTranscriptDeltaEvent =
            OutputTranscriptDeltaEvent.builder()
                .delta("Would you like me to reserve that table?")
                .endMs(7200L)
                .eventId("evt_output_transcript_001")
                .startMs(5400L)
                .clientEventId("client_event_id")
                .build()

        val roundtrippedOutputTranscriptDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(outputTranscriptDeltaEvent),
                jacksonTypeRef<OutputTranscriptDeltaEvent>(),
            )

        assertThat(roundtrippedOutputTranscriptDeltaEvent).isEqualTo(outputTranscriptDeltaEvent)
    }
}
