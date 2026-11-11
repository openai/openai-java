// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.audio.transcriptions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TranscriptionTextSegmentEventTest {

    @Test
    fun createAndRoundtrip() {
        val transcriptionTextSegmentEvent =
            TranscriptionTextSegmentEvent.builder()
                .id("id")
                .end(0.0)
                .speaker("speaker")
                .start(0.0)
                .text("text")
                .build()

        assertThat(transcriptionTextSegmentEvent.id()).contains("id")
        assertThat(transcriptionTextSegmentEvent.end()).contains(0.0)
        assertThat(transcriptionTextSegmentEvent.speaker()).contains("speaker")
        assertThat(transcriptionTextSegmentEvent.start()).contains(0.0)
        assertThat(transcriptionTextSegmentEvent.text()).contains("text")

        val jsonMapper = jsonMapper()

        val roundtrippedTranscriptionTextSegmentEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(transcriptionTextSegmentEvent),
                jacksonTypeRef<TranscriptionTextSegmentEvent>(),
            )

        assertThat(roundtrippedTranscriptionTextSegmentEvent)
            .isEqualTo(transcriptionTextSegmentEvent)
    }
}
