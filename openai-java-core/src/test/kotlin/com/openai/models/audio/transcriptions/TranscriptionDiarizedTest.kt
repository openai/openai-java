// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio.transcriptions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TranscriptionDiarizedTest {

    @Test
    fun create() {
        val transcriptionDiarized =
            TranscriptionDiarized.builder()
                .addSegment(
                    TranscriptionDiarizedSegment.builder()
                        .id("id")
                        .end(0.0)
                        .speaker("speaker")
                        .start(0.0)
                        .text("text")
                        .build()
                )
                .text("text")
                .usage(
                    TranscriptionDiarized.Usage.Tokens.builder()
                        .inputTokens(0L)
                        .outputTokens(0L)
                        .totalTokens(0L)
                        .inputTokenDetails(
                            TranscriptionDiarized.Usage.Tokens.InputTokenDetails.builder()
                                .audioTokens(0L)
                                .textTokens(0L)
                                .build()
                        )
                        .build()
                )
                .build()

        assertThat(transcriptionDiarized.duration()).isEmpty
        assertThat(transcriptionDiarized.segments())
            .containsExactly(
                TranscriptionDiarizedSegment.builder()
                    .id("id")
                    .end(0.0)
                    .speaker("speaker")
                    .start(0.0)
                    .text("text")
                    .build()
            )
        assertThat(transcriptionDiarized.text()).isEqualTo("text")
        assertThat(transcriptionDiarized.usage())
            .contains(
                TranscriptionDiarized.Usage.ofTokens(
                    TranscriptionDiarized.Usage.Tokens.builder()
                        .inputTokens(0L)
                        .outputTokens(0L)
                        .totalTokens(0L)
                        .inputTokenDetails(
                            TranscriptionDiarized.Usage.Tokens.InputTokenDetails.builder()
                                .audioTokens(0L)
                                .textTokens(0L)
                                .build()
                        )
                        .build()
                )
            )
    }

    @Test
    fun deserializeWithoutDuration() {
        val transcriptionDiarized =
            jsonMapper()
                .readValue(
                    """
                    {
                      "text": "text",
                      "segments": [
                        {
                          "id": "id",
                          "end": 1.0,
                          "speaker": "speaker",
                          "start": 0.0,
                          "text": "text"
                        }
                      ]
                    }
                    """
                        .trimIndent(),
                    jacksonTypeRef<TranscriptionDiarized>(),
                )

        assertThat(transcriptionDiarized.duration()).isEmpty
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val transcriptionDiarized =
            TranscriptionDiarized.builder()
                .duration(0.0)
                .addSegment(
                    TranscriptionDiarizedSegment.builder()
                        .id("id")
                        .end(0.0)
                        .speaker("speaker")
                        .start(0.0)
                        .text("text")
                        .build()
                )
                .text("text")
                .usage(
                    TranscriptionDiarized.Usage.Tokens.builder()
                        .inputTokens(0L)
                        .outputTokens(0L)
                        .totalTokens(0L)
                        .inputTokenDetails(
                            TranscriptionDiarized.Usage.Tokens.InputTokenDetails.builder()
                                .audioTokens(0L)
                                .textTokens(0L)
                                .build()
                        )
                        .build()
                )
                .build()

        val roundtrippedTranscriptionDiarized =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(transcriptionDiarized),
                jacksonTypeRef<TranscriptionDiarized>(),
            )

        assertThat(roundtrippedTranscriptionDiarized).isEqualTo(transcriptionDiarized)
        assertThat(roundtrippedTranscriptionDiarized.duration()).contains(0.0)
    }
}
