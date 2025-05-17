// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio.transcriptions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TranscriptionVerboseTest {

    @Test
    fun create() {
        val transcriptionVerbose =
            TranscriptionVerbose.builder()
                .duration(0.0)
                .language("language")
                .text("text")
                .addSegment(
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
                )
                .addWord(TranscriptionWord.builder().end(0.0f).start(0.0f).word("word").build())
                .build()

        assertThat(transcriptionVerbose.duration()).isEqualTo(0.0)
        assertThat(transcriptionVerbose.language()).isEqualTo("language")
        assertThat(transcriptionVerbose.text()).isEqualTo("text")
        assertThat(transcriptionVerbose.segments().getOrNull())
            .containsExactly(
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
            )
        assertThat(transcriptionVerbose.words().getOrNull())
            .containsExactly(TranscriptionWord.builder().end(0.0f).start(0.0f).word("word").build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val transcriptionVerbose =
            TranscriptionVerbose.builder()
                .duration(0.0)
                .language("language")
                .text("text")
                .addSegment(
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
                )
                .addWord(TranscriptionWord.builder().end(0.0f).start(0.0f).word("word").build())
                .build()

        val roundtrippedTranscriptionVerbose =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(transcriptionVerbose),
                jacksonTypeRef<TranscriptionVerbose>(),
            )

        assertThat(roundtrippedTranscriptionVerbose).isEqualTo(transcriptionVerbose)
    }
}
