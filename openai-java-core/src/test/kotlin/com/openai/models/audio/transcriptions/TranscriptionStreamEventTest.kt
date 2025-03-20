// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio.transcriptions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TranscriptionStreamEventTest {

    @Test
    fun ofTranscriptTextDelta() {
        val transcriptTextDelta = TranscriptionTextDeltaEvent.builder().delta("delta").build()

        val transcriptionStreamEvent =
            TranscriptionStreamEvent.ofTranscriptTextDelta(transcriptTextDelta)

        assertThat(transcriptionStreamEvent.transcriptTextDelta()).contains(transcriptTextDelta)
        assertThat(transcriptionStreamEvent.transcriptTextDone()).isEmpty
    }

    @Test
    fun ofTranscriptTextDone() {
        val transcriptTextDone = TranscriptionTextDoneEvent.builder().text("text").build()

        val transcriptionStreamEvent =
            TranscriptionStreamEvent.ofTranscriptTextDone(transcriptTextDone)

        assertThat(transcriptionStreamEvent.transcriptTextDelta()).isEmpty
        assertThat(transcriptionStreamEvent.transcriptTextDone()).contains(transcriptTextDone)
    }
}
