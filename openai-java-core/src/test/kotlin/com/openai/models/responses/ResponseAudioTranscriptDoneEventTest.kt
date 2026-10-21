// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseAudioTranscriptDoneEventTest {

    @Test
    fun createAndRoundtrip() {
        val responseAudioTranscriptDoneEvent =
            ResponseAudioTranscriptDoneEvent.builder().sequenceNumber(0L).build()

        assertThat(responseAudioTranscriptDoneEvent.sequenceNumber()).isEqualTo(0L)

        val jsonMapper = jsonMapper()

        val roundtrippedResponseAudioTranscriptDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseAudioTranscriptDoneEvent),
                jacksonTypeRef<ResponseAudioTranscriptDoneEvent>(),
            )

        assertThat(roundtrippedResponseAudioTranscriptDoneEvent)
            .isEqualTo(responseAudioTranscriptDoneEvent)
    }
}
