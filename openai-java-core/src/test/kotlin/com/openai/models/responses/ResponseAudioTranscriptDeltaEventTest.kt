// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseAudioTranscriptDeltaEventTest {

    @Test
    fun createAndRoundtrip() {
        val responseAudioTranscriptDeltaEvent =
            ResponseAudioTranscriptDeltaEvent.builder().delta("delta").sequenceNumber(0L).build()

        assertThat(responseAudioTranscriptDeltaEvent.delta()).isEqualTo("delta")
        assertThat(responseAudioTranscriptDeltaEvent.sequenceNumber()).isEqualTo(0L)

        val jsonMapper = jsonMapper()

        val roundtrippedResponseAudioTranscriptDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseAudioTranscriptDeltaEvent),
                jacksonTypeRef<ResponseAudioTranscriptDeltaEvent>(),
            )

        assertThat(roundtrippedResponseAudioTranscriptDeltaEvent)
            .isEqualTo(responseAudioTranscriptDeltaEvent)
    }
}
