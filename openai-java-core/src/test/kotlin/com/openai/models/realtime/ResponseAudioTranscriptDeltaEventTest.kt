// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseAudioTranscriptDeltaEventTest {

    @Test
    fun createAndRoundtrip() {
        val responseAudioTranscriptDeltaEvent =
            ResponseAudioTranscriptDeltaEvent.builder()
                .contentIndex(0L)
                .delta("delta")
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .build()

        assertThat(responseAudioTranscriptDeltaEvent.contentIndex()).contains(0L)
        assertThat(responseAudioTranscriptDeltaEvent.delta()).contains("delta")
        assertThat(responseAudioTranscriptDeltaEvent.eventId()).contains("event_id")
        assertThat(responseAudioTranscriptDeltaEvent.itemId()).contains("item_id")
        assertThat(responseAudioTranscriptDeltaEvent.outputIndex()).contains(0L)
        assertThat(responseAudioTranscriptDeltaEvent.responseId()).contains("response_id")

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
