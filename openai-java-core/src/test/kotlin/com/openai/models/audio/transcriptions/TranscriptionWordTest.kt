// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio.transcriptions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TranscriptionWordTest {

    @Test
    fun create() {
        val transcriptionWord = TranscriptionWord.builder().end(0.0).start(0.0).word("word").build()

        assertThat(transcriptionWord.end()).isEqualTo(0.0)
        assertThat(transcriptionWord.start()).isEqualTo(0.0)
        assertThat(transcriptionWord.word()).isEqualTo("word")
    }
}
