// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio.transcriptions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TranscriptionTest {

    @Test
    fun create() {
        val transcription = Transcription.builder().text("text").build()

        assertThat(transcription.text()).isEqualTo("text")
    }
}
