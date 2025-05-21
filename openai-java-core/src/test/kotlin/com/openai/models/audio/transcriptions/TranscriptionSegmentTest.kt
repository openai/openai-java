// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio.transcriptions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TranscriptionSegmentTest {

    @Test
    fun create() {
        val transcriptionSegment =
            TranscriptionSegment.builder()
                .id(0L)
                .avgLogprob(0.0f)
                .compressionRatio(0.0f)
                .end(0.0f)
                .noSpeechProb(0.0f)
                .seek(0L)
                .start(0.0f)
                .temperature(0.0f)
                .text("text")
                .addToken(0L)
                .build()

        assertThat(transcriptionSegment.id()).isEqualTo(0L)
        assertThat(transcriptionSegment.avgLogprob()).isEqualTo(0.0f)
        assertThat(transcriptionSegment.compressionRatio()).isEqualTo(0.0f)
        assertThat(transcriptionSegment.end()).isEqualTo(0.0f)
        assertThat(transcriptionSegment.noSpeechProb()).isEqualTo(0.0f)
        assertThat(transcriptionSegment.seek()).isEqualTo(0L)
        assertThat(transcriptionSegment.start()).isEqualTo(0.0f)
        assertThat(transcriptionSegment.temperature()).isEqualTo(0.0f)
        assertThat(transcriptionSegment.text()).isEqualTo("text")
        assertThat(transcriptionSegment.tokens()).containsExactly(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val transcriptionSegment =
            TranscriptionSegment.builder()
                .id(0L)
                .avgLogprob(0.0f)
                .compressionRatio(0.0f)
                .end(0.0f)
                .noSpeechProb(0.0f)
                .seek(0L)
                .start(0.0f)
                .temperature(0.0f)
                .text("text")
                .addToken(0L)
                .build()

        val roundtrippedTranscriptionSegment =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(transcriptionSegment),
                jacksonTypeRef<TranscriptionSegment>(),
            )

        assertThat(roundtrippedTranscriptionSegment).isEqualTo(transcriptionSegment)
    }
}
