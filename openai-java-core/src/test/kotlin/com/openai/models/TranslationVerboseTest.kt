// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TranslationVerboseTest {

    @Test
    fun createTranslationVerbose() {
        val translationVerbose =
            TranslationVerbose.builder()
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
                .build()
        assertThat(translationVerbose).isNotNull
        assertThat(translationVerbose.duration()).isEqualTo(0.0)
        assertThat(translationVerbose.language()).isEqualTo("language")
        assertThat(translationVerbose.text()).isEqualTo("text")
        assertThat(translationVerbose.segments().get())
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
    }
}
