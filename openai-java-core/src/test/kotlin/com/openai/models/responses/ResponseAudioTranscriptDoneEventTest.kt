// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResponseAudioTranscriptDoneEventTest {

    @Test
    fun createResponseAudioTranscriptDoneEvent() {
        val responseAudioTranscriptDoneEvent = ResponseAudioTranscriptDoneEvent.builder().build()
        assertThat(responseAudioTranscriptDoneEvent).isNotNull
    }
}
