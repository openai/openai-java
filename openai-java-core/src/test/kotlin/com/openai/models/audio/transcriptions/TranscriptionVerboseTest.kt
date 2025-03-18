// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio.transcriptions

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
                )
                .addWord(TranscriptionWord.builder().end(0.0).start(0.0).word("word").build())
                .build()

        assertThat(transcriptionVerbose.duration()).isEqualTo(0.0)
        assertThat(transcriptionVerbose.language()).isEqualTo("language")
        assertThat(transcriptionVerbose.text()).isEqualTo("text")
        assertThat(transcriptionVerbose.segments().getOrNull())
            .containsExactly(
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
            )
        assertThat(transcriptionVerbose.words().getOrNull())
            .containsExactly(TranscriptionWord.builder().end(0.0).start(0.0).word("word").build())
    }
}
