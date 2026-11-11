// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.audio.transcriptions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TranscriptionSegmentTest {

    @Test
    fun createAndRoundtrip() {
        val transcriptionSegment =
            TranscriptionSegment.builder()
                .id(0L)
                .avgLogprob(0.0f)
                .compressionRatio(0.0f)
                .end(0.0)
                .noSpeechProb(0.0f)
                .seek(0L)
                .start(0.0)
                .temperature(0.0f)
                .text("text")
                .addToken(0L)
                .build()

        assertThat(transcriptionSegment.id()).contains(0L)
        assertThat(transcriptionSegment.avgLogprob()).contains(0.0f)
        assertThat(transcriptionSegment.compressionRatio()).contains(0.0f)
        assertThat(transcriptionSegment.end()).contains(0.0)
        assertThat(transcriptionSegment.noSpeechProb()).contains(0.0f)
        assertThat(transcriptionSegment.seek()).contains(0L)
        assertThat(transcriptionSegment.start()).contains(0.0)
        assertThat(transcriptionSegment.temperature()).contains(0.0f)
        assertThat(transcriptionSegment.text()).contains("text")
        assertThat(transcriptionSegment.tokens().getOrNull()).containsExactly(0L)

        val jsonMapper = jsonMapper()

        val roundtrippedTranscriptionSegment =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(transcriptionSegment),
                jacksonTypeRef<TranscriptionSegment>(),
            )

        assertThat(roundtrippedTranscriptionSegment).isEqualTo(transcriptionSegment)
    }
}
