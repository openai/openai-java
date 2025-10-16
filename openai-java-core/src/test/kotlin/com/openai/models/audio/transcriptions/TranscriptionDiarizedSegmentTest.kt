// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio.transcriptions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TranscriptionDiarizedSegmentTest {

    @Test
    fun create() {
        val transcriptionDiarizedSegment =
            TranscriptionDiarizedSegment.builder()
                .id("id")
                .end(0.0f)
                .speaker("speaker")
                .start(0.0f)
                .text("text")
                .build()

        assertThat(transcriptionDiarizedSegment.id()).isEqualTo("id")
        assertThat(transcriptionDiarizedSegment.end()).isEqualTo(0.0f)
        assertThat(transcriptionDiarizedSegment.speaker()).isEqualTo("speaker")
        assertThat(transcriptionDiarizedSegment.start()).isEqualTo(0.0f)
        assertThat(transcriptionDiarizedSegment.text()).isEqualTo("text")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val transcriptionDiarizedSegment =
            TranscriptionDiarizedSegment.builder()
                .id("id")
                .end(0.0f)
                .speaker("speaker")
                .start(0.0f)
                .text("text")
                .build()

        val roundtrippedTranscriptionDiarizedSegment =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(transcriptionDiarizedSegment),
                jacksonTypeRef<TranscriptionDiarizedSegment>(),
            )

        assertThat(roundtrippedTranscriptionDiarizedSegment).isEqualTo(transcriptionDiarizedSegment)
    }
}
