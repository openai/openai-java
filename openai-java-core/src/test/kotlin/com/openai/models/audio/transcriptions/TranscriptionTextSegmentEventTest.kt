// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio.transcriptions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TranscriptionTextSegmentEventTest {

    @Test
    fun create() {
        val transcriptionTextSegmentEvent =
            TranscriptionTextSegmentEvent.builder()
                .id("id")
                .end(0.0f)
                .speaker("speaker")
                .start(0.0f)
                .text("text")
                .build()

        assertThat(transcriptionTextSegmentEvent.id()).isEqualTo("id")
        assertThat(transcriptionTextSegmentEvent.end()).isEqualTo(0.0f)
        assertThat(transcriptionTextSegmentEvent.speaker()).isEqualTo("speaker")
        assertThat(transcriptionTextSegmentEvent.start()).isEqualTo(0.0f)
        assertThat(transcriptionTextSegmentEvent.text()).isEqualTo("text")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val transcriptionTextSegmentEvent =
            TranscriptionTextSegmentEvent.builder()
                .id("id")
                .end(0.0f)
                .speaker("speaker")
                .start(0.0f)
                .text("text")
                .build()

        val roundtrippedTranscriptionTextSegmentEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(transcriptionTextSegmentEvent),
                jacksonTypeRef<TranscriptionTextSegmentEvent>(),
            )

        assertThat(roundtrippedTranscriptionTextSegmentEvent)
            .isEqualTo(transcriptionTextSegmentEvent)
    }
}
