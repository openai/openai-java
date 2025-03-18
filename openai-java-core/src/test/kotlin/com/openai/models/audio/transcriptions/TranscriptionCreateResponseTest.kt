// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio.transcriptions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TranscriptionCreateResponseTest {

    @Test
    fun ofTranscription() {
        val transcription = Transcription.builder().text("text").build()

        val transcriptionCreateResponse = TranscriptionCreateResponse.ofTranscription(transcription)

        assertThat(transcriptionCreateResponse.transcription()).contains(transcription)
        assertThat(transcriptionCreateResponse.verbose()).isEmpty
    }

    @Test
    fun ofVerbose() {
        val verbose =
            TranscriptionVerbose.builder().duration(0.0).language("language").text("text").build()

        val transcriptionCreateResponse = TranscriptionCreateResponse.ofVerbose(verbose)

        assertThat(transcriptionCreateResponse.transcription()).isEmpty
        assertThat(transcriptionCreateResponse.verbose()).contains(verbose)
    }
}
