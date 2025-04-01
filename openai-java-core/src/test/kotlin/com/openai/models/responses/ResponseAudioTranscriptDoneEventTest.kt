// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseAudioTranscriptDoneEventTest {

    @Test
    fun create() {
        val responseAudioTranscriptDoneEvent = ResponseAudioTranscriptDoneEvent.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseAudioTranscriptDoneEvent = ResponseAudioTranscriptDoneEvent.builder().build()

        val roundtrippedResponseAudioTranscriptDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseAudioTranscriptDoneEvent),
                jacksonTypeRef<ResponseAudioTranscriptDoneEvent>(),
            )

        assertThat(roundtrippedResponseAudioTranscriptDoneEvent)
            .isEqualTo(responseAudioTranscriptDoneEvent)
    }
}
