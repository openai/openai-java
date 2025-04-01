// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseAudioTranscriptDeltaEventTest {

    @Test
    fun create() {
        val responseAudioTranscriptDeltaEvent =
            ResponseAudioTranscriptDeltaEvent.builder().delta("delta").build()

        assertThat(responseAudioTranscriptDeltaEvent.delta()).isEqualTo("delta")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseAudioTranscriptDeltaEvent =
            ResponseAudioTranscriptDeltaEvent.builder().delta("delta").build()

        val roundtrippedResponseAudioTranscriptDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseAudioTranscriptDeltaEvent),
                jacksonTypeRef<ResponseAudioTranscriptDeltaEvent>(),
            )

        assertThat(roundtrippedResponseAudioTranscriptDeltaEvent)
            .isEqualTo(responseAudioTranscriptDeltaEvent)
    }
}
