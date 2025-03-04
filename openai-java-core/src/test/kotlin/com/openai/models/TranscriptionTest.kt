// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TranscriptionTest {

    @Test
    fun createTranscription() {
        val transcription = Transcription.builder().text("text").build()
        assertThat(transcription).isNotNull
        assertThat(transcription.text()).isEqualTo("text")
    }
}
