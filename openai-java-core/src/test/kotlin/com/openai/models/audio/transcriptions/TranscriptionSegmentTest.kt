// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio.transcriptions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TranscriptionSegmentTest {

    @Test
    fun createTranscriptionSegment() {
        val transcriptionSegment =
            TranscriptionSegment.builder()
                .id(0L)
                .avgLogprob(0.0)
                .compressionRatio(0.0)
                .end(0.0)
                .noSpeechProb(0.0)
                .seek(0L)
                .start(0.0)
                .temperature(0.0)
                .text("text")
                .addToken(0L)
                .build()
        assertThat(transcriptionSegment).isNotNull
        assertThat(transcriptionSegment.id()).isEqualTo(0L)
        assertThat(transcriptionSegment.avgLogprob()).isEqualTo(0.0)
        assertThat(transcriptionSegment.compressionRatio()).isEqualTo(0.0)
        assertThat(transcriptionSegment.end()).isEqualTo(0.0)
        assertThat(transcriptionSegment.noSpeechProb()).isEqualTo(0.0)
        assertThat(transcriptionSegment.seek()).isEqualTo(0L)
        assertThat(transcriptionSegment.start()).isEqualTo(0.0)
        assertThat(transcriptionSegment.temperature()).isEqualTo(0.0)
        assertThat(transcriptionSegment.text()).isEqualTo("text")
        assertThat(transcriptionSegment.tokens()).containsExactly(0L)
    }
}
