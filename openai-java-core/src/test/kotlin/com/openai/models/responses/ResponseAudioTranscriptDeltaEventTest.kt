// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResponseAudioTranscriptDeltaEventTest {

    @Test
    fun createResponseAudioTranscriptDeltaEvent() {
        val responseAudioTranscriptDeltaEvent =
            ResponseAudioTranscriptDeltaEvent.builder().delta("delta").build()
        assertThat(responseAudioTranscriptDeltaEvent).isNotNull
        assertThat(responseAudioTranscriptDeltaEvent.delta()).isEqualTo("delta")
    }
}
